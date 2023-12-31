
	package TestCase;

	import org.openqa.selenium.By;


	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import Base.BaseClass;
	import PageObject.CartPage;
	import PageObject.LandingPage;
	import PageObject.LoginPage;
	import PageObject.MyWishList;

	public class TC_005_Add_To_Cart extends BaseClass 
	{
		
		public static LandingPage pg;
		public static CartPage cp;
		public static MyWishList mywishlis;
		
		@Test(priority = 1)
		public void login() throws Exception
		{
			LoginPage lp=new LoginPage(driver);
			lp.clickSignIn();
			
			lp.signingIn(prop.getProperty("username"),prop.getProperty("passWord"));
			String expected = driver.getTitle();
			Assert.assertEquals("Home Page", expected);
		}
		
		@Test(priority = 2)
		public void verifySerchItem() throws InterruptedException
		{
			pg=new LandingPage(driver);
			mywishlis=new MyWishList(driver);
			
			pg.searching(prop.getProperty("serachText"),prop.getProperty("serachItem"));
			
			Assert.assertEquals(mywishlis.validateSearch(),"Search results for: '"+prop.getProperty("serachItem")+"'" );
			
			pg.selectProduct(prop.getProperty("hoodiename"));
			Thread.sleep(2000);
			cp=new CartPage(driver);
			Thread.sleep(2000);
			cp.selectSize();
			cp.selectColors();
			
			cp.removetext();
		
		    Thread.sleep(2000);
			cp.selectQuantity("1");
			cp.addtoCart();
			Thread.sleep(2000);
			Assert.assertEquals(cp.checkMessage(),prop.getProperty("addtocartSuccess"));
			Assert.assertTrue(cp.checkart(prop.getProperty("hoodiename")));
		}
		@Test(priority = 3)
		public void checktextBox()
		{
			cp=new CartPage(driver);
			cp.removetext();
			cp.selectQuantity("E");
			cp.addtoCart();
			Assert.assertEquals(cp.checkQuantityField(),prop.getProperty("quantityfielderr") );
		}
		
		
		}


