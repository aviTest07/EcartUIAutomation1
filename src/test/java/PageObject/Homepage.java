package PageObject;



	

	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import Base.BasePage;

	public class Homepage  extends BasePage
	{

		public Homepage(WebDriver driver) 
		{
			super(driver);
			// TODO Auto-generated constructor stub
		}
		
		@FindBy(xpath="(//a[contains(text(),'Create an Account')])[1]")
		WebElement registerLink;
		
		public void openAccount()
		{
			registerLink.click();
		}
		
		
	

}
