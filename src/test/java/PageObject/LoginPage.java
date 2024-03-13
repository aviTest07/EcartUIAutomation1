package PageObject;



	import org.openqa.selenium.WebDriver;	
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import Base.BaseClass;
//import Base.BasePage;

	public class LoginPage extends BaseClass
	{
		public LoginPage(WebDriver driver) {
			//this.driver=driver;
			PageFactory.initElements(driver,this);
			// TODO Auto-generated constructor stub
		}
		
		@FindBy(xpath="(//a[contains(text(),'Sign In')])[1]")
		WebElement signin;
		
		@FindBy(xpath="//input[@id='email']")
		WebElement emailId;
		
		@FindBy(xpath="//input[@name='login[password]']")
		WebElement pass;
		
		@FindBy(xpath="(//span[contains(.,'Sign In')])[1]")
		WebElement submit;
		
		@FindBy(xpath="//div[.='This is a required field.']")
		WebElement errormessag;
		
		public void clickSignIn()
		{
			signin.click();	
			
		}
		
		public LandingPage signingIn(String email,String password) throws InterruptedException
		{
			emailId.sendKeys(email);
			
			pass.sendKeys(password);
		
			submit.click();
			return new LandingPage(driver);
		}
		
		public boolean  signingIn()
		{
			submit.click();
			String errtext= errormessag.getText();
			System.out.println(errtext);
			String colortext= errormessag.getCssValue("color");
			System.out.println(colortext);
			
			if(colortext.equals("#e02b27"))
			{
			return true;
			}
			return false;
			
		}
		
		public boolean  getdimensionLength() {
			int emaillen= emailId.getSize().getHeight();
			 int emailWidth=	 emailId.getSize().getWidth();
			int passlen= pass.getSize().getHeight();
			int passWidth= pass.getSize().getWidth();
			
			if(emaillen==passlen && emailWidth==passWidth)
			{
				return true;
			}
			return false;
			 
		}
		public boolean  Verify_PWDfieldsAreAligned_SameRow() {
			int emaillen= emailId.getLocation().getY();
			int passlen= pass.getLocation().getY();
			
			if(emaillen==passlen)
			{
				return true;
			}
			return false;
			 
		}
		}
