

	package TestCase;

	import org.testng.annotations.Test;

	import Base.BaseClass;
	import org.testng.Assert;
	import PageObject.Homepage;
	import PageObject.LoginPage;
	import PageObject.RegisterDetails;

	public class TC_001_AccountCreation extends BaseClass
	{
		public static RegisterDetails rd;
		 public static Homepage hp;
		@Test(enabled=true)
		public void accountCreation() throws Exception
		{
			try
			{
			hp=new Homepage(driver);
			hp.openAccount();
		
			rd= new RegisterDetails(driver);
			
			rd.enterRegisterDetails(prop.getProperty("name"),prop.getProperty("lastname"),prop.getProperty("email"),prop.getProperty("password"));
			
	        Assert.assertEquals(rd.getConfirmation(),"Thank you for registering with Main Website Store.");
			}
			
				catch(Exception e)
				{
					Assert.fail();
				}
			}
		
		@Test
		public void validationmesasge()
		{
			hp=new Homepage(driver);
			rd= new RegisterDetails(driver);
			rd.logoutuser();
			hp.openAccount();
			String message= rd.checkvalidation();
			Assert.assertEquals(message,prop.getProperty("ValidationMess"));
		}
		
		
		@Test
		public void verifypasswords() throws InterruptedException
		{	
			rd= new RegisterDetails(driver);
		rd.enterDetailsVerifyPassword(prop.getProperty("name"),prop.getProperty("lastname"),prop.getProperty("email"),prop.getProperty("pass"),prop.getProperty("passc"));
		String message= rd.getPasswordVaidationConfirmation();
		Assert.assertEquals(message,prop.getProperty("passwordValidation"));
		}
		
		}


