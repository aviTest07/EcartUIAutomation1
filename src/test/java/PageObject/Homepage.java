package PageObject;
import org.openqa.selenium.WebDriver;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



	public class Homepage 
	{
		WebDriver driver;
		public Homepage(WebDriver driver)
		{
		this.driver=driver;
			PageFactory.initElements(driver,this);
			// TODO Auto-generated constructor stub
		}
		
		@FindBy(xpath="(//a[contains(text(),'Create an Account')])[1]")
		WebElement registerLink;
		
		public void openAccount()
		{
			registerLink.click();
		}
		
		
	

}
