package com.trungnt.service;

import com.trungnt.dao.DataDAO;
import com.trungnt.exception.DataException;
import com.trungnt.model.DataModel;
import com.trungnt.model.RequestData;
import com.trungnt.util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response.Status;

/**
 * DataService class
 * @author trungnt
 *
 */
public class DataService {
  /**
   * Data Access Object
   */
  private DataDAO dataDAO = DataDAO.INSTANCE;

  /**
   * function get data
   * @param requestData
   * @return list of DataModel
   */
  public List<DataModel> getData(RequestData requestData) {
    List<DataModel> data = new ArrayList<DataModel>();
    try {
      checkRequestData(requestData);
      Date startDate = parseDate(requestData.getStartDate());
      Date endDate = parseDate(requestData.getEndDate());
      data = dataDAO.getData(startDate, endDate);
    } catch (NullPointerException | IllegalArgumentException ex) {
      throw new DataException(ex.getMessage(), Status.BAD_REQUEST);
    } catch (ParseException | IllegalAccessException ex) {
      throw new DataException("Date format is invalid!", Status.BAD_REQUEST);
    }
    return data;
  }

  /**
   * function check request data is valid or not?
   * @param requestData
   * @throws NullPointerException
   * @throws IllegalArgumentException
   * @throws ParseException
   * @throws IllegalAccessException
   */
  private void checkRequestData(RequestData requestData) throws NullPointerException,
      IllegalArgumentException, ParseException, IllegalAccessException {
    SimpleDateFormat sdf = new SimpleDateFormat(Utils.TIMESTAMP_FORMAT);// "2016-08-02T10:26:48+0200"
    // check request data is null?
    if (requestData == null) {
      throw new NullPointerException("Request data is null!");
    }
    String startDate = requestData.getStartDate();
    String endDate = requestData.getEndDate();
    if (startDate == null || endDate == null) {
      throw new NullPointerException("StartDate or endDate is null!");
    }

    // check startdate and enddate is empty?
    if (startDate.isEmpty() || endDate.isEmpty()) {
      throw new IllegalArgumentException("Input date is empty!");
    }

    // check startdate and enddate has valid format?
    Date date1 = sdf.parse(startDate);
    Date date2 = sdf.parse(endDate);
    if (date1.after(date2)) {
      throw new IllegalArgumentException("Startdate is after endDate!");
    }
  }

  /**
   * function parse date from string
   * @param date
   * @return Date object
   * @throws ParseException
   */
  private Date parseDate(String date) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat(Utils.TIMESTAMP_FORMAT);// "2016-08-02T10:26:48+0200"
    return sdf.parse(date);
  }
}
