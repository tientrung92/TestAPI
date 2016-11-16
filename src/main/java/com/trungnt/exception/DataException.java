package com.trungnt.exception;

import com.trungnt.util.ResponseUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class DataException extends WebApplicationException {

  /**
   * variable serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor of Custom Exception.
   *
   * @param message
   *          Message
   * @param status
   *          Status
   */
  public DataException(String message, Status status) {
    super(ResponseUtils.getErrorResponse(status, message));
  }
}
