package PageObject;


	import java.util.List;

	
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;


	public class CartPage extends BaseClass 
	{
		WebDriver driver;
		public CartPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			// TODO Auto-generated constructor stub
		}

		@FindBy(xpath="//div[@option-label='Black']")
		WebElement prductcolor;
		
		@FindBy(xpath="//input[@class='input-text qty']")
		WebElement prducquantity;
		
		@FindBy(xpath="//div[contains(@id,'option-label-size-143-item-')]")
		WebElement prductsize;
		
	    @FindBy(xpath="//button[@title='Add to Cart']")
		WebElement addtocartButton;
	    
	    @FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
		WebElement cartSuccessmessage;
	    
	    @FindBy(xpath="//a[@class='action showcart']")
	   	WebElement cart;
	    
	    @FindBy(xpath="//a[@data-bind='attr: {href: product_url}, html: product_name']")
	   	List <WebElement> checkcart;
	    
	    @FindBy(xpath="//div[text()='Please enter a valid number in this field.']")
	   	WebElement errormessage;
	    
	    
	   
		public void selectSize()
		{
			prductsize.click();
			System.out.println(prductsize.getText());
		}
		public void selectColors()
		{
			prductcolor.click();
		}
		public void selectQuantity(String quantity)
		{
			prducquantity.sendKeys(quantity);
		}
		
		public void removetext()
		{
			prducquantity.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		}

		public void addtoCart()
		{
			addtocartButton.click();
		}
		public String checkMessage() 
		{
			return cartSuccessmessage.getText();
		}
		
		public boolean checkart(String addedproduct)
		{
			cart.click();
			for(WebElement pr:checkcart)
			{
				String product=pr.getText();
				if(product.equalsIgnoreCase(addedproduct)) {
			return true;
				}
				
		}
			return false;
			}
		
		public String checkQuantityField()
		{
			 return errormessage.
			getText();
		}
		

}
