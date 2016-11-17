import static org.junit.Assert.*;

import com.trungnt.exception.DataException;
import com.trungnt.filters.RequestFilter;
import com.trungnt.model.RequestData;
import com.trungnt.model.ResponseMessage;
import com.trungnt.service.DataService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;


public class RequestFilterTest {

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  /**
   * test case request data is null
   */
  @SuppressWarnings("null")
  @Test
  public void getFilter_01() {
    String requestData = "{\"startDate\":\"2016-08-02T10:26:48+0200\",\"endDate\":\"2016-08-03T10:26:48+0200\"}";
    ContainerRequestContext context = null ;
    context.setEntityStream(getInputStream(requestData));
    RequestFilter filter = new RequestFilter();
    try {
      filter.filter(context);
      fail("Should throw an exception if one or more of given numbers are negative");
    } catch (Exception e) {
      if (e instanceof IllegalStateException) {
        Assert.assertTrue(true);

      } else {
        fail("Not expect");
      }
    }
  }

  private InputStream getInputStream(String payload) {
    return new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8));
  }

}
