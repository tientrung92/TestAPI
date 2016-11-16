package com.trungnt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DataModel {
  @JsonProperty("vehicleId")
  private String vehicleId;
  @JsonProperty("uniqueId")
  private String uniqueId;
  @JsonProperty("lisencePlate")
  private String lisencePlate;
  @JsonProperty("executionDate")
  private String executionDate;
  @JsonProperty("objectLongitude")
  private String objectLongitude;

  public DataModel(String vehicleId, String uniqueId, String lisencePlate, String executionDate,
      String objectLongitude, String objectLatitude) {
    super();
    this.vehicleId = vehicleId;
    this.uniqueId = uniqueId;
    this.lisencePlate = lisencePlate;
    this.executionDate = executionDate;
    this.objectLongitude = objectLongitude;
    this.objectLatitude = objectLatitude;
  }
  /**
   * @return the vehicleId
   */
  public String getVehicleId() {
    return vehicleId;
  }
  /**
   * @param vehicleId the vehicleId to set
   */
  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }
  /**
   * @return the uniqueId
   */
  public String getUniqueId() {
    return uniqueId;
  }
  /**
   * @param uniqueId the uniqueId to set
   */
  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }
  /**
   * @return the lisencePlate
   */
  public String getLisencePlate() {
    return lisencePlate;
  }
  /**
   * @param lisencePlate the lisencePlate to set
   */
  public void setLisencePlate(String lisencePlate) {
    this.lisencePlate = lisencePlate;
  }
  /**
   * @return the executionDate
   */
  public String getExecutionDate() {
    return executionDate;
  }
  /**
   * @param executionDate the executionDate to set
   */
  public void setExecutionDate(String executionDate) {
    this.executionDate = executionDate;
  }
  /**
   * @return the objectLongitude
   */
  public String getObjectLongitude() {
    return objectLongitude;
  }
  /**
   * @param objectLongitude the objectLongitude to set
   */
  public void setObjectLongitude(String objectLongitude) {
    this.objectLongitude = objectLongitude;
  }
  /**
   * @return the objectLatitude
   */
  public String getObjectLatitude() {
    return objectLatitude;
  }
  /**
   * @param objectLatitude the objectLatitude to set
   */
  public void setObjectLatitude(String objectLatitude) {
    this.objectLatitude = objectLatitude;
  }
  private String objectLatitude;

  /**
   * function get dummyData
   */
  public static List<DataModel> getDummyData() {
    List<DataModel> data = new ArrayList<DataModel>();
    DataModel model1 = new DataModel("100001087", "Renault Master 2016", "NRU-685", "2016-08-02T10:26:48+0200", "8.2222668", "48.8666835999");
    DataModel model2 = new DataModel("100001087", "Renault Master 2016", "NRU-685", "2016-08-02T10:26:57+0200", "8.2223991", "48.8667381");
    DataModel model3 = new DataModel("100000175", "Audi R8", "NRU-683", "2016-08-02T14:35:10+0200", "19.6874886", "46.8760015999");
    data.add(model1);
    data.add(model2);
    data.add(model3);
    return data;
  }

}
