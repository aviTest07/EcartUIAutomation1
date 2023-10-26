package TestCase;

import org.testng.Assert;

import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.MyAccount;

public class TC_009_CheckReviews extends BaseClass
{
	
	 LandingPage  pr = new LandingPage(driver);
 
	@Test(priority= 1)
	public void  checkReviewdetails() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		MyAccount account=new MyAccount(driver);
	 	lp.clickSignIn();
	 	 pr =lp.signingIn(prop.getProperty("email"),prop.getProperty("password"));
	 	account.selectdropdown();
	    String countofreviewbefore= account.getReviewItem();
	    countofreviewbefore = countofreviewbefore.replaceAll("[^0-9]","");
	    
	    Assert.assertEquals(countofreviewbefore,prop.getProperty("countofreview"));
	}
	
	
	@Test(priority= 2)
	public void submitReview() throws InterruptedException 
	{
		LandingPage pr = new LandingPage(driver);
		MyAccount account=new MyAccount(driver);
		pr.selectItems();
		account.selectproductreview();
		
		account.enterarating();
		
		account.entersummary("Product Review");
		account.enterreview("Product is good");
		account.submitreview();
		account.selectdropdown();
		
		String countofreview= account.getReviewItem();
	    countofreview = countofreview.replaceAll("[^0-9]","");
	    
	    Assert.assertEquals(countofreview,prop.getProperty("countofreview1"));
		
	}
}



