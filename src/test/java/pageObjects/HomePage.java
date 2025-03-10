package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkmyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkregistert;
	
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnklogin;  //login link added in step5
	public void ClickMyAccount()
	{
		lnkmyaccount.click();
	}
	
	public void ClickRegister() 
	{
		 lnkregistert.click();
	}
	
	public void ClickLogin()
	{
		lnklogin.click();
	}
	
}
