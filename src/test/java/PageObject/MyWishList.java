

	package PageObject;

	import java.util.List;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;
import Base.BasePage;

	public class MyWishList extends BaseClass
	{
		
		public MyWishList(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			// TODO Auto-generated constructor stub
		}
		
		@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
		WebElement  wishlistSuccess;
		
		@FindBy(xpath="//a[@class='product-item-link']")
		List <WebElement>  wishlistJacket;
		
		@FindBy(xpath="//h1[@class='page-title']/descendant::span")
		WebElement  searchresultText;

		public String verifySuccessMessage()
		{
			String sText =   wishlistSuccess.getText();
			return sText;	
		}
		
		public String validateSearch()
		{
			return searchresultText.getText();
		}
	
}
