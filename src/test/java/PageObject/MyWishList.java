

	package PageObject;

	import java.util.List;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import Base.BasePage;

	public class MyWishList extends BasePage
	{
		
		public MyWishList(WebDriver driver) {
			super(driver);
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
