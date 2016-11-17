package com.trungnt.resource;

import com.trungnt.model.DataModel;
import com.trungnt.model.RequestData;
import com.trungnt.model.ResponseData;
import com.trungnt.service.DataService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "objects" path).
 */
@Path("/data")
public class MyResource {
  /**
   * Data service
   */
  private DataService service = new DataService();

  /**
   * API get data
   * @param requestData: include startDate and endDate
   * @return positions data
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ResponseData getData(RequestData requestData) {
    ResponseData responseData = new ResponseData();
    List<DataModel> data = service.getData(requestData);
    responseData.setpositionsResponse(data);
    return responseData;
  }

}
