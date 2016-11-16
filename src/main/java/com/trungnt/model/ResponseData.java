package com.trungnt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseData {
  /**
   * Default constructor.
   */
  public ResponseData() {
    super();
  }

  /**
   * Response positionsResponse constructor.
   *
   * @param positionsResponse
   *          positionsResponse
   */
  public ResponseData(List<DataModel> positionsResponse) {
    this.positionsResponse = positionsResponse;
  }

  @JsonProperty("positionsResponse")
  List<DataModel> positionsResponse;

  /**
   * Get positionsResponse.
   *
   * @return positionsResponse
   */
  public List<DataModel> getpositionsResponse() {
    return positionsResponse;
  }

  /**
   * Set positionsResponse.
   *
   * @param positionsResponse
   *          positionsResponse
   */
  public void setpositionsResponse(List<DataModel> positionsResponse) {
    this.positionsResponse = positionsResponse;
  }

}
