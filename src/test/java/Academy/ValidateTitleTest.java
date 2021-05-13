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


import resources.Base;
import pageObjects.LandingPage;


public class ValidateTitleTest extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	LandingPage l;
			
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=InitializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	
	@Test
	public void validateTitle() throws IOException 
	{
		
		
		l=new LandingPage(driver);
		//compare the text from the browser with actual value
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		log.info("Successfully validated Text message");
	}
	
	@Test
	public void validatezHeader() throws IOException 
	{
		//compare the text from the browser with actual value
		Assert.assertEquals(l.getHeader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated Text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
