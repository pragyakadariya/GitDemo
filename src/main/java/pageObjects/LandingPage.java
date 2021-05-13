package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	private By signin= By.cssSelector("a[href*='sign_in']");
	
	private By title= By.cssSelector("div[class='text-center'] h2");
	
	private By navbar = By.cssSelector("[class*='navbar-nav']");
	private By header= By.cssSelector("div[class*='video-banner'] h3");


	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}




	public LoginPage getLogin() 
	{
		driver.findElement(signin).click();//click on the login link and initiate another page object method in this method itself
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navbar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}

}