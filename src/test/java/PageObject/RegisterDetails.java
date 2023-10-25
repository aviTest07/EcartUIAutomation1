
	package PageObject;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import Base.BasePage;

	public class RegisterDetails extends BasePage
	{
		public RegisterDetails(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		
		@FindBy(id="firstname")
		WebElement firstnameText;
		
		@FindBy(id="lastname")
		WebElement lastnameText;
		
		@FindBy(id="email_address")
		WebElement emailfield;
		
		@FindBy(id="password")
		WebElement passwordfield;
		
		@FindBy(id="password-confirmation")
		WebElement passcon;
		
		@FindBy(xpath="//button/span[contains(text(),'Create an Account')]")
		WebElement submit1;
		
		@FindBy(xpath="//div[contains(text(),'Thank you for registering with Main Website Store.')]")
		WebElement succesmessage;
		
		@FindBy(xpath="//div[contains(@for,'firstname')]")
		WebElement validationmessage;
		
		@FindBy(xpath="(//button[contains(.,'Change')])[1]")
		WebElement logoutdropdown;
		
		@FindBy(xpath="(//a[contains(.,'Sign Out')])[1]")
		WebElement logout;
		
		@FindBy(xpath="//div[contains(@for,'password-confirmation')]")
		WebElement passwordValidation;
		
		public void enterRegisterDetails(String name,String lastname,String email,String password) throws InterruptedException
		{
			firstnameText.sendKeys(name);
			lastnameText.sendKeys(lastname);
			emailfield.sendKeys(email);
			passwordfield.sendKeys(password);
			passcon.sendKeys(password);
		
		//	JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.scrollBy(0,350)", "");
			
			//js.executeScript("window.scrollBy(0,350)", "");
			submit1.click();
			
		}
		
		public void enterDetails(String name,String lastname,String email,String password,String exp) throws InterruptedException
		{
			firstnameText.sendKeys(name);
			lastnameText.sendKeys(lastname);
			emailfield.sendKeys(email);
			passwordfield.sendKeys(password);
			passcon.sendKeys(password);
		
		//	JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.scrollBy(0,350)", "");
			
		
			
			//js.executeScript("window.scrollBy(0,350)", "");
			submit1.click();
				
		}
		
		public void enterDetailsVerifyPassword(String name,String lastname,String email,String password,String conpassword) throws InterruptedException
		{
			firstnameText.sendKeys(name);
			lastnameText.sendKeys(lastname);
			emailfield.sendKeys(email);
			passwordfield.sendKeys(password);
			passcon.sendKeys(conpassword);
		
		//	JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.scrollBy(0,350)", "");
			//js.executeScript("window.scrollBy(0,350)", "");
			submit1.click();
			}
		public String  checkvalidation()
		{
			submit1.click();
			return validationmessage.getText();	
		}
		public void logoutuser()
		{
			logoutdropdown.click();
			logout.click();
			
		}
		public String getConfirmation( )
		{
			return succesmessage.getText();
			
		}
		public String getPasswordVaidationConfirmation ( )
		{
			return passwordValidation.getText();	
		}
		
		

	

}
