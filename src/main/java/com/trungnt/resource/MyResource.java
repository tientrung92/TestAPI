package com.trungnt.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "objects" path).
 */
@Path("/objects")
public class MyResource {

  /**
   * function get data.
   *
   * @param atId
   *          themeID
   * @param dsId
   *          dataasourceID
   * @param info
   *          parameters
   * @return Response
   */
  @GET
  @Path("/data")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getData() {
    throw new UnsupportedOperationException();

  }

}
