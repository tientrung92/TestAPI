package com.trungnt.util;

import com.trungnt.model.ResponseMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ResponseUtils {
  /**
   * Create response for exception.
   *
   * @param status
   *          Status of response
   * @param message
   *          Message of reponse
   * @return Response
   */
  public static Response getErrorResponse(Status status, String message) {
    Response response = Response.status(status)
        .entity(new ResponseMessage(message)).type(MediaType.APPLICATION_JSON)
        .build();
    return response;
  }

  public static final String INTERNAL_SERVER_ERROR_MSG = "Internal server error";

}
