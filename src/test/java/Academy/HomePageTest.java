package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePageTest extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException 
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void BasePageNavigation(String Username, String Password, String text) throws IOException 
	{
		
		
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin();//lp is initialized in the getLogin method
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		log.info(text);
		lp.getLogin().click();
		ForgotPassword fp= lp.ForgotPassword();//fp is initialized in ForgotPassword method
		fp.getEmail().sendKeys("asdasdsa");
		fp.sendMeInstructions().click();
		
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData() 
	{
		//row stands for how may different data types test should run
		//column stands for how many values per each test
		//object[1][2] means we have 1 row 
		//2 means we are passing two parameters per test 
		Object[][] data=new Object[2][3];
		//oth row 
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="non restricted user";
		
//		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456789";
		data[1][2]="restricted user";
		
		return data;
	}
	
	}