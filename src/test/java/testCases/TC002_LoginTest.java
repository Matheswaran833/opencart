package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"sanity","Master"})
	public void verify_login()
	{
		logger.info("***StaringTC002_loginTest****");
		
		try
		{
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
			Assert.assertTrue(targetpage);  //Assert.assertEquals(targetpage,true,"login Failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finished Tc002_LoginTest*****");
	}
}
