
	package TestCase;

	import org.testng.Assert;

	import org.testng.annotations.Test;

	import Base.BaseClass;
	import PageObject.LoginPage;

	public class TC_008_Checkalignment extends BaseClass
	{

		public static LoginPage login;
		
		@Test
		public void errorMessColour()
		{
			login=new LoginPage(driver);
			login.clickSignIn();
			Assert.assertTrue(login.getdimensionLength());
			
		}   @Test(priority = 1)
		public void checkusernamePassword()
		{
			login=new LoginPage(driver);
			Assert.assertTrue(login.Verify_PWDfieldsAreAligned_SameRow());
		}
		
		
	}


