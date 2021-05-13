package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

//adding logs
//generating html reports
//screenshots on failure 
//Jenkins integration

public class ValidateNavigationPanelTest extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException 
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void validateNavigationPanel() throws IOException, InterruptedException 
	{

		
		LandingPage l=new LandingPage(driver);
		//
		//verify navigation bar is present		
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("navigation bar is verified");
		log.info("navigation bar is verified");
		log.info("navigation bar is verified");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
