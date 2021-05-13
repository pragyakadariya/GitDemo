package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	private By email= By.cssSelector("input[id='user_email']");
	private By password = By.cssSelector("input[id='user_password']");
	private By login= By.cssSelector("input[name='commit']");
	private By forgotPassword=By.cssSelector("[href*='password/new']");
	


	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}




	public WebElement getEmail() 
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword() 
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin() 
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword ForgotPassword()
	{
		driver.findElement(forgotPassword).click();
		ForgotPassword fp= new ForgotPassword(driver);
		return fp;
	}
	
	

}