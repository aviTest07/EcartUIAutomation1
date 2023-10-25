

	package TestCase;

	import java.util.ArrayList;


	import org.testng.Assert;
	import org.testng.annotations.Test;

	import Base.BaseClass;
	import PageObject.LandingPage;
	import PageObject.LoginPage;
	import PageObject.ProductsPage;

	public class TC_007_DeleteProducts extends BaseClass
	{

	public static LoginPage login;
		
	@Test
	public void deletecompareitems() throws InterruptedException
	{
		login=new LoginPage(driver);
		login.clickSignIn();
		LandingPage landpage=login.signingIn(prop.getProperty("username"),prop.getProperty("passWord"));
		ProductsPage page=landpage.selectItems();
		page.addcompareItems();
		
		Assert.assertTrue(page.successMessages().contains(prop.getProperty("comparehoodieName1")));
		
		page.addcompareItems2();
		Assert.assertTrue(page.successMessages().contains(prop.getProperty("comparehoodieName2")));
		
		ArrayList <String> checklist=page.getList();
		Assert.assertTrue(checklist.contains(prop.getProperty("comparehoodieName1")));
		Assert.assertTrue(checklist.contains(prop.getProperty("comparehoodieName2")));
		
		Assert.assertTrue(page.removeItem("Are you sure you want to remove this item from your Compare Products list?"));
		}
	}





