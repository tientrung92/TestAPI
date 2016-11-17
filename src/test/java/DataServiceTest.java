import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.trungnt.exception.DataException;
import com.trungnt.model.DataModel;
import com.trungnt.model.RequestData;
import com.trungnt.model.ResponseMessage;
import com.trungnt.service.DataService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import javax.ws.rs.core.Response;


public class DataServiceTest {

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  // @Test
  // public void test() {
  // fail("Not yet implemented");
  // }

  /**
   * test case request data is null
   */
  @Test
  public void getData_01() {
    RequestData requestData = null;
    DataService service = new DataService();
    try {
      service.getData(requestData);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof DataException) {
        Response rs = ((DataException) e).getResponse();
        ResponseMessage res = (ResponseMessage) (rs.getEntity());
        Assert.assertTrue(res.getMessage().equals("Request data is null!"));
        Assert.assertEquals(400, rs.getStatus());

      } else {
        fail("Not expect");
      }
    }
  }

  /**
   * test case request data with startDate is null
   */
  @Test
  public void getData_02() {
    RequestData requestData = new RequestData(null, "2016-08-02T10:26:48+0200");
    DataService service = new DataService();
    try {
      service.getData(requestData);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof DataException) {
        Response rs = ((DataException) e).getResponse();
        ResponseMessage res = (ResponseMessage) (rs.getEntity());
        Assert.assertTrue(res.getMessage().equals("StartDate or endDate is null!"));
        Assert.assertEquals(400, rs.getStatus());

      } else {
        fail("Not expect");
      }
    }
  }

  /**
   * test case request data with endDate is null
   */
  @Test
  public void getData_03() {
    RequestData requestData = new RequestData("2016-08-02T10:26:48+0200", null);
    DataService service = new DataService();
    try {
      service.getData(requestData);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof DataException) {
        Response rs = ((DataException) e).getResponse();
        ResponseMessage res = (ResponseMessage) (rs.getEntity());
        Assert.assertTrue(res.getMessage().equals("StartDate or endDate is null!"));
        Assert.assertEquals(400, rs.getStatus());

      } else {
        fail("Not expect");
      }
    }
  }

  /**
   * test case request data with startDate is empty
   */
  @Test
  public void getData_04() {
    RequestData requestData = new RequestData("", "2016-08-02T10:26:48+0200");
    DataService service = new DataService();
    try {
      service.getData(requestData);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof DataException) {
        Response rs = ((DataException) e).getResponse();
        ResponseMessage res = (ResponseMessage) (rs.getEntity());
        Assert.assertTrue(res.getMessage().equals("Input date is empty!"));
        Assert.assertEquals(400, rs.getStatus());

      } else {
        fail("Not expect");
      }
    }
  }

  /**
   * test case request data with endDate is empty
   */
  @Test
  public void getData_05() {
    RequestData requestData = new RequestData("2016-08-02T10:26:48+0200", "");
    DataService service = new DataService();
    try {
      service.getData(requestData);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof DataException) {
        Response rs = ((DataException) e).getResponse();
        ResponseMessage res = (ResponseMessage) (rs.getEntity());
        Assert.assertTrue(res.getMessage().equals("Input date is empty!"));
        Assert.assertEquals(400, rs.getStatus());

      } else {
        fail("Not expect");
      }
    }
  }

  /**
   * test case request data with startDate has not incorrect format
   */
  @Test
  public void getData_07() {
    RequestData requestData = new RequestData("2016:08:02 10:26:48+0200",
        "2016-08-03T10:26:48+0200");
    DataService service = new DataService();
    try {
      service.getData(requestData);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof DataException) {
        Response rs = ((DataException) e).getResponse();
        ResponseMessage res = (ResponseMessage) (rs.getEntity());
        Assert.assertTrue(res.getMessage().equals("Date format is invalid!"));
        Assert.assertEquals(400, rs.getStatus());

      } else {
        fail("Not expect");
      }
    }
  }

  /**
   * test case request data with endDate has not incorrect format
   */
  @Test
  public void getData_08() {
    RequestData requestData = new RequestData("2016-08-02T10:26:48+0200",
        "2016:08:03 10:26:48+0200");
    DataService service = new DataService();
    try {
      service.getData(requestData);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof DataException) {
        Response rs = ((DataException) e).getResponse();
        ResponseMessage res = (ResponseMessage) (rs.getEntity());
        Assert.assertTrue(res.getMessage().equals("Date format is invalid!"));
        Assert.assertEquals(400, rs.getStatus());

      } else {
        fail("Not expect");
      }
    }
  }

  /**
   * test case request data with startDate is after endDate
   */
  @Test
  public void getData_09() {
    RequestData requestData = new RequestData("2016-08-04T10:26:48+0200",
        "2016-08-03T10:26:48+0200");
    DataService service = new DataService();
    try {
      service.getData(requestData);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof DataException) {
        Response rs = ((DataException) e).getResponse();
        ResponseMessage res = (ResponseMessage) (rs.getEntity());
        Assert.assertTrue(res.getMessage().equals("Startdate is after endDate!"));
        Assert.assertEquals(400, rs.getStatus());

      } else {
        fail("Not expect");
      }
    }
  }

  /**
   * test case normal
   */
  @Test
  public void getData_10() {
    RequestData requestData = new RequestData("2016-08-02T10:26:48+0200",
        "2016-08-03T10:26:48+0200");
    DataService service = new DataService();

    List<DataModel> expectData = service.getData(requestData);
    assertEquals(expectData.size(), 3);
  }

}
