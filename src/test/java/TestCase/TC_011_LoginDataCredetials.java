package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.Homepage;
import PageObject.LoginPage;
import PageObject.RegisterDetails;
import Util.DataProviders;

public class TC_011_LoginDataCredetials extends BaseClass
{
	@Test(dataProvider="verifylogincredntials",dataProviderClass = DataProviders.class)
public void checkCredentails(String username,String password,String exp) throws InterruptedException
{
		RegisterDetails rd=new RegisterDetails(driver);
		LoginPage lp=new LoginPage(driver);
		
		lp.clickSignIn();
		
		lp.signingIn(username,password);
		
		String targetpage = driver.getTitle();
		
			if (exp.equals("Valid")) 
				if(targetpage.equalsIgnoreCase("Home Page")|| targetpage.equalsIgnoreCase("My Account"))
	{	
				rd.logoutuser();
			    Assert.assertTrue(true);
			}
			else
			{
			Assert.assertTrue(false);
			}			
		if (exp.equals("InValid")) 
		{
			if(targetpage.equalsIgnoreCase("Customer Login"))
			lp.clickSignIn();
			
			Assert.assertFalse(false);
		}
		else
		{
		Assert.assertFalse(false);
		}
	
	
}	
}
