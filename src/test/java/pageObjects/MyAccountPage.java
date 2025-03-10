package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) 
	{
	  super(driver);	
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading;  //my account page heading
	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnklogout;  //add step 6
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
		public void ClickLogout()
		{
			lnklogout.click();
		}
	
	
	
	
}
