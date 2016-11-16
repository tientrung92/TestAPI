package com.trungnt.dao;

import com.trungnt.model.DataModel;

import java.util.List;

public enum DataDAO {
  INSTANCE;

  public List<DataModel> getData(String startDate, String endDate) {
    List<DataModel> data = DataModel.getDummyData();
    return data;
  }

}
