import junit.framework.TestCase;
import org.junit.Test;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleniumException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ITSeleniumHelloWorldExample extends TestCase {
    private static final Logger LOG = LoggerFactory.getLogger(ITSeleniumHelloWorldExample.class);

  private DefaultSelenium selenium;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    selenium = createSeleniumClient("http://localhost:8080/");
    selenium.start();
  }

  @Override
  public void tearDown() throws Exception {
    selenium.stop();
    super.tearDown();
  }

  protected DefaultSelenium createSeleniumClient(String url) throws Exception {
    return new DefaultSelenium("localhost", 4444, "*googlechrome", url);
  }
  
  @Test
  public void testHelloWorld() throws Exception {
        LOG.debug("Start");

    try {
	System.out.println("Here am i");
       
      selenium.open("http://localhost:8080/index.jsp");
      assertEquals("Hello World!", selenium.getText("//h1"));
       
    } catch (SeleniumException ex) {
      fail(ex.getMessage());
      throw ex;
    }
  }
}