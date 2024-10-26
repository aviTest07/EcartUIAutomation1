
package TestCase;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.LandingPage;
import PageObject.LoginPage;

public class TC_003_TopMenu extends BaseClass 
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
	 ArrayList<String>  list = new ArrayList<String>();
	
	@Test
	public void verifyTopMenu()
	{
		list.add("What's New");
		list.add("Women");
		list.add("Men");
		list.add("Gear");
		list.add("Training");
		list.add("Sale");
		
		LandingPage lp=new LandingPage(driver);
		ArrayList<String> str = lp.verifytopMenu();
		for(String lists:str)
		{
			System.out.println(lists);
		}
		boolean flag=str.containsAll(list);
	//	System.out.print(flag);
		Assert.assertEquals(str.containsAll(list),true); 	
		}
		
	}

