package TestCase;



	import org.testng.Assert;

	import org.testng.annotations.Test;

	import Base.BaseClass;
	import PageObject.LoginPage;

	public class TC_002_Login extends BaseClass
	{
		
		@Test
		public void login() throws Exception
		{
			LoginPage lp=new LoginPage(driver);
			lp.clickSignIn();
			
			lp.signingIn(prop.getProperty("email"),prop.getProperty("password"));
			String expected = driver.getTitle();
			Assert.assertEquals("Home Page", expected);
		}

	

}
