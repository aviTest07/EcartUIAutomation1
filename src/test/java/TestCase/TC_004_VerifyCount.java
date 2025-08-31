package TestCase;

import org.testng.Assert;

import org.testng.annotations.Test;
import io.qameta.allure.*;
import Base.BaseClass;
import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.MyWishList;
import PageObject.ProductsPage;

public class TC_004_VerifyCount extends BaseClass
{
	public static LandingPage lap;
	public static LoginPage lp;
	public static ProductsPage prod;
	public static	MyWishList wishlist;
	//Login the application
	@Test(priority = 1)
	public void login() throws Exception
	{
		lp=new LoginPage(driver);
		lp.clickSignIn();
		
		lap=lp.signingIn(prop.getProperty("email"),prop.getProperty("password"));
		String expected = driver.getTitle();
		Assert.assertEquals("Home Page", expected);
	}
	
	//Verify the top menu
	@Test(description = " This test verifies the count of items displayed")
	@Description("This test verifies the count of items displayed.")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Total Products display")
	@Feature("Authentication")
	public void verifyCount() throws InterruptedException
	{
		lap=new LandingPage(driver);
		prod=lap.selectItems();

		String getCount=prod.getCountofItems();
		
		Assert.assertEquals(getCount,prod.getProductCount());
		Thread.sleep(3000);
	}
	//verify the sorting filter by price
	@Test(priority = 3)
	public void checkSortingoptions()
	{
		 prod= new ProductsPage(driver);
		 prod.sortByprice();
		Assert.assertTrue(prod.isSorted());	
	}
	//verify that user is able to wishlist the item or not.
	@Test(priority=4)

	public void verifyWishListItem()
	{
		prod= new ProductsPage(driver);
		wishlist=prod.wishList();
		Assert.assertEquals(wishlist.verifySuccessMessage(),"Proteus Fitness Jackshirt has been added to your Wish List. Click here to continue shopping.");
	}
	
}
