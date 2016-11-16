package com.trungnt.resource;

import com.trungnt.exception.DataException;
import com.trungnt.model.DataModel;
import com.trungnt.model.RequestData;
import com.trungnt.model.ResponseData;
import com.trungnt.service.DataService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

/**
 * Root resource (exposed at "objects" path).
 */
@Path("/data")
public class MyResource {
  /**
   * Data service
   */
  private DataService service = new DataService();

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ResponseData getData(RequestData requestData) {
    ResponseData responseData = new ResponseData();
    try {
      checkRequestData(requestData);
      List<DataModel> data = service.getData(requestData.getStartDate(), requestData.getEndDate());
      responseData.setpositionsResponse(data);
    } catch (NullPointerException | IllegalArgumentException ex) {
      throw new DataException(ex.getMessage(), Status.BAD_REQUEST);
    } catch (ParseException | IllegalAccessException ex) {
      throw new DataException("Date format is invalid!", Status.BAD_REQUEST);
    }
    return responseData;
  }

  private void checkRequestData(RequestData requestData) throws NullPointerException,
      IllegalArgumentException, ParseException, IllegalAccessException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");// "2016-08-02T10:26:48+0200"
    String startDate = requestData.getStartDate();
    String endDate = requestData.getEndDate();
    // check request data is null?
    if (requestData == null || startDate == null || endDate == null) {
      throw new NullPointerException("Request data is null!");
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

}
