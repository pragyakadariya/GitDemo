package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

	
public class Base {
	public WebDriver driver;//declare global variable driver
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException 
	{
		//if browser is chrome invoke ChromeDriver 
		
		//firefox
		
		//IE
		
		prop=new Properties();//used to access the properties
		//system.getproperty("user.dir") this gives the project path so it can prevent hard coding the the root path  
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//mvn test -Dbrowser=chrome
		//String browsername = System.getProperty("browser");//this will check if any parameters are passed in the maven command
		
		String browsername=prop.getProperty("browser");
		if(browsername.contains("chrome"))
		{
			//execute in chrome browser
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browsername.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
			
		}
		
		else if (browsername.equals("firefox"))
		{
			//execute in firefox browser
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			
			
		}
		
		else if (browsername.equals("IE"))
		{
			//execute in IE browser
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}