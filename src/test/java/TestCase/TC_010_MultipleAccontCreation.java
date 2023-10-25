

	package TestCase;

	import org.testng.Assert;

	import org.testng.annotations.Test;

	import Base.BaseClass;
	import PageObject.Homepage;
	import PageObject.RegisterDetails;
	import Util.DataProviders;

	public class TC_010_MultipleAccontCreation extends BaseClass
	{	
	@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class)
	public void test_accountCreation(String firstName, String lastName,String email, String password,String ConfirmPassword,String exp) throws InterruptedException
	{
		Homepage hp=new Homepage(driver);
		hp.openAccount();
		RegisterDetails rd= new RegisterDetails(driver);
		rd.enterDetails(firstName, lastName, email, ConfirmPassword,exp);
		String mess=rd.getConfirmation();
		boolean targetpage=mess.equalsIgnoreCase(prop.getProperty("successmessage"));
		{
			if (exp.equals("Valid")) 
				if(targetpage==true)
	{	
				rd.logoutuser();
			    Assert.assertTrue(true);
			}
			else
			{
			Assert.assertFalse(false);
			}
				
			}
		if (exp.equals("InValid")) 
		{
			Assert.assertFalse(false);
			rd.logoutuser();
		}
	
	}

}
