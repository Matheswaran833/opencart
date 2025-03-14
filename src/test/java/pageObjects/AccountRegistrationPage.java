package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
	       super(driver);	
	}

@FindBy(xpath="//input[@id='input-firstname']") WebElement txtfirstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement txtlastname;
@FindBy(xpath="//input[@id='input-email']") WebElement txtemail;	
@FindBy(xpath="//input[@id='input-telephone']") WebElement txttelephone;	
@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;	
@FindBy(xpath="//input[@id='input-confirm']") WebElement txtconfirmpassword;	
@FindBy(xpath="//input[@name='agree']") WebElement chkpolicy;
@FindBy(xpath="//input[@value='Continue']") WebElement btncontinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgconfirmation;

public void setfirstname1 (String fname) {
	 txtfirstname.sendKeys(fname);    }

public void setlastname(String lastname){
	 txtlastname.sendKeys(lastname);    }

public void setemail(String email){
	 txtemail.sendKeys(email);    }

public void settelephone(String telephone){
	 txttelephone.sendKeys(telephone);    }

public void setpassword(String password){
	 txtpassword.sendKeys(password);    }

public void setconfirmpassword(String conpassword){
	 txtconfirmpassword.sendKeys(conpassword);    }

public void setprivacypolicy(){
	 chkpolicy.click();    }

public void clickcontinue(){
	 btncontinue.click();   }


public  String getconfirmationmsg() {
try{
	return (msgconfirmation.getText());
}
   catch (Exception e)
{
	   return (e.getMessage());
}

}
}
