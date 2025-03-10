package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try {
		logger.info("****StartTC001_AccountRegistrationTest****");
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.ClickRegister();
		logger.info("Clicked Registration link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("****Providing Customer Details****");
		regpage.setfirstname1(randomstring().toUpperCase());
		regpage.setlastname(randomstring().toUpperCase());
		regpage.setemail(randomstring()+"@gmail.com");
		regpage.settelephone(randomnumber());
		
		String password=randomAlphanumeric();
		regpage.setpassword(password);
		regpage.setconfirmpassword(password);
		regpage.setprivacypolicy();
		regpage.clickcontinue();
		
		
		logger.info("***Validating Expected Message****");
		String confmsg=regpage.getconfirmationmsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
	}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("debug logs");
			Assert.fail();
		}
		logger.info("***FinishTC001_AccountRegistrationTest****");
	}
	
}
