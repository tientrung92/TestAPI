package com.trungnt.dao;

import com.trungnt.model.DataModel;

import java.util.Date;
import java.util.List;

/**
 * DataDAo class
 * @author trungnt
 *
 */
public enum DataDAO {
  INSTANCE;

  /**
   * function get positions data
   * @param startDate
   * @param endDate
   * @return positions data
   */
  public List<DataModel> getData(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      throw new NullPointerException("StartDate or endDate is null!");
    }
    List<DataModel> data = DataModel.getDummyData();
    return data;
  }

}
