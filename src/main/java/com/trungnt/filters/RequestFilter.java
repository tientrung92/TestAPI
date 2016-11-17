package com.trungnt.filters;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trungnt.util.ResponseUtils;
import com.trungnt.util.Utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;

public class RequestFilter implements ContainerRequestFilter {

  /**
   * function filter request
   */
  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    if (requestContext.getMethod().toUpperCase().equals("POST")) {
      String payload = getRequestPayload(requestContext);
      InputStream inputStream = getInputStream(payload);
      if (!isValidJSON(inputStream)) {
        requestContext.abortWith(ResponseUtils.getErrorResponse(Status.BAD_REQUEST,
            "Request data is invalid Json format!"));
      }
      if (!hasKey(payload, Utils.REQUEST_KEY_1) || !hasKey(payload, Utils.REQUEST_KEY_2)) {
        requestContext.abortWith(ResponseUtils.getErrorResponse(Status.BAD_REQUEST,
            "Request data is invalid, does not have " + Utils.REQUEST_KEY_1 + " or "
                + Utils.REQUEST_KEY_2 + "!"));
      }
      System.out.println("OK");
      requestContext.setEntityStream(getInputStream(payload));
    }
  }

  /**
   * check reuest data is Json valid or not?
   * @param inputStream
   * @return boolean
   */
  private boolean isValidJSON(InputStream inputStream) {
    boolean valid = false;
    try {
      final JsonParser parser = new ObjectMapper().getFactory().createParser(inputStream);

      while (parser.nextToken() != null) {
      }
      valid = true;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return valid;
  }
  /**
   * function check request data has correct key or not?
   * @param jsonContent
   * @param key
   * @return boolean
   */

  private boolean hasKey(String jsonContent, String key) {
    return jsonContent.lastIndexOf(key) != -1;
  }

  /**
   * function get string from container request context
   * @param request
   * @return String object
   */
  private String getRequestPayload(ContainerRequestContext request) {
    final int payloadLength = request.getLength();
    final StringBuilder sb = new StringBuilder(payloadLength);
    try {
      final InputStream iStream = request.getEntityStream();
      final BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
      reader.mark(payloadLength + 1);
      final char[] charBuffer = new char[payloadLength + 1];
      int byteReads = -1;
      while ((byteReads = reader.read(charBuffer)) > 0) {
        sb.append(charBuffer, 0, byteReads);
      }
      reader.reset();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return sb.toString();
  }

  /**
   * function get InputStream object from String
   * @param payload string input
   * @return InputStream
   */
  private InputStream getInputStream(String payload) {
    return new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8));
  }

}