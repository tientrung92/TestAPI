package com.trungnt.service;

import com.trungnt.dao.DataDAO;
import com.trungnt.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataService {
  private DataDAO dataDAO = DataDAO.INSTANCE;

  public List<DataModel> getData(String startDate, String endDate) {
    List<DataModel> data = new ArrayList<DataModel>();
    data = dataDAO.getData(startDate, endDate);
    return data;
  }
}
