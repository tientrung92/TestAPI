import static org.junit.Assert.fail;

import com.trungnt.dao.DataDAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;



public class DataDAOTest {

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
   * test case with startDate is null
   */
  @Test
  public void test_DataDAO_01() {
     DataDAO dataDAO = DataDAO.INSTANCE;
     Date startDate = null;
     Date endDate = new Date();
     try {
       dataDAO.getData(startDate, endDate);
     } catch (Exception ex) {
       if (ex instanceof NullPointerException) {
         Assert.assertTrue(ex.getMessage().equals("StartDate or endDate is null!"));
       } else {
         fail("Not expect");
       }
     }
  }

  /**
   * test case with endDate is null
   */
  @Test
  public void test_DataDAO_02() {
     DataDAO dataDAO = DataDAO.INSTANCE;
     Date endDate = null;
     Date startDate = new Date();
     try {
       dataDAO.getData(startDate, endDate);
     } catch (Exception ex) {
       if (ex instanceof NullPointerException) {
         Assert.assertTrue(ex.getMessage().equals("StartDate or endDate is null!"));
       } else {
         fail("Not expect");
       }
     }
  }

}
