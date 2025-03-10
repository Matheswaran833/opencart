package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
Data is valid-login sucess-test pass-logout
data is valid-login failed-test fail
Data is invalid-login sucess-test fail- logout
Data is invalid login failed-test pass 
*/
public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
	

			//HomePage
			HomePage hp=new HomePage(driver);
			hp.ClickMyAccount();
			hp.ClickLogin();
			
			//LoginPage
			LoginPage lp=new LoginPage(driver);
			lp.SetEmail(p.getProperty("email"));
			lp.SetPassword(p.getProperty("password"));
			lp.ClickLogin();
			
			//MyAccountPage
			MyAccountPage map=new MyAccountPage(driver);
			boolean targetpage=map.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetpage==true)
				{
					map.ClickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetpage==true)
				{
					map.ClickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
}
