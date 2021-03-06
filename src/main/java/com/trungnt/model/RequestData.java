package com.trungnt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestData {
  @JsonProperty("startDate")
  private String startDate;
  @JsonProperty("endDate")
  private String endDate;

  /**
   * constructor function without parameters
   */
  public RequestData() {

  }

  /**
   * constructor function with parameters
   * @param startDate
   * @param endDate
   */
  public RequestData(String startDate, String endDate) {
    super();
    this.startDate = startDate;
    this.endDate = endDate;
  }
  /**
   * @return the startString
   */
  public String getStartDate() {
    return startDate;
  }
  /**
   * @param startString the startString to set
   */
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  /**
   * @return the endString
   */
  public String getEndDate() {
    return endDate;
  }
  /**
   * @param endString the endString to set
   */
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return startDate + " " + endDate;
  }
}
