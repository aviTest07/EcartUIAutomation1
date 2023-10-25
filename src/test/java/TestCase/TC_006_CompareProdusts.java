
	package TestCase;

	import java.util.ArrayList;


	import org.testng.Assert;
	import org.testng.annotations.Test;

	import Base.BaseClass;
	import PageObject.LandingPage;
	import PageObject.LoginPage;
	import PageObject.ProductsPage;

	public class TC_006_CompareProdusts extends BaseClass
	{
		public static LandingPage pg;
		
		@Test(priority=1)
		public void login() throws Exception
		{
			LoginPage lp=new LoginPage(driver);
			lp.clickSignIn();
			
			lp.signingIn(prop.getProperty("username"),prop.getProperty("passWord"));
			String expected = driver.getTitle();
			Assert.assertEquals("Home Page", expected);
		}
		@Test(priority=2)
		public void compareItems() throws Exception
		{
			pg=new LandingPage(driver);
			ProductsPage prpage = pg.selectItems();
			
			prpage.addcompareItems();
			
			Assert.assertTrue(prpage.successMessages().contains(prop.getProperty("comparehoodieName1")));
			
			prpage.addcompareItems2();
			Assert.assertTrue(prpage.successMessages().contains(prop.getProperty("comparehoodieName2")));
			
			ArrayList <String> checklist=prpage.getList();
			Assert.assertTrue(checklist.contains(prop.getProperty("comparehoodieName1")));
			Assert.assertTrue(checklist.contains(prop.getProperty("comparehoodieName2")));
			
			
		
		}
	
}
