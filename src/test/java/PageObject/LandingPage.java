package PageObject;



	import java.time.Duration;

	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import Base.BasePage;

	public class LandingPage  {
		
		WebDriver driver;

		public LandingPage(WebDriver driver) {
		this.driver=driver;
			PageFactory.initElements(driver,this);
			// TODO Auto-generated constructor stub
		}
		
		@FindBy(xpath="(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[4]/following-sibling::span")
		WebElement menSection;
		
		@FindBy(xpath="(//span[.='Tops'])[2]")
		WebElement mensTop;
		
		@FindBy(xpath="//a[@id='ui-id-19']")
		WebElement jackets;
		
		@FindBy(xpath="//li[starts-with(@class,'level0')]")
		List <WebElement> topMenu;
		
		@FindBy(xpath="//input[@id='search']")
		WebElement  searchButton;
		
		@FindBy(xpath="//a[@class='product-item-link']")
		List <WebElement> searchedProductList;
		
		
		@FindBy(xpath="//li[contains(@id,'qs-option')]")
		List <WebElement> productList;
		
		
		public ArrayList<String> verifytopMenu()
		{
			ArrayList<String> options = new ArrayList<String>();
			for(WebElement option:topMenu)
			{
				String category = option.getText();
				//System.out.println(category);		 
				options.add(category);
				options.size();	
			}
			return options;
		}
		public ProductsPage selectItems() throws InterruptedException
		{
			Actions ac=new Actions(driver);
			
			ac.moveToElement(menSection).build().perform();
			ac.moveToElement(mensTop).build().perform();	
			ac.moveToElement(jackets).click().perform();
			Thread.sleep(2000);
			 
			return new ProductsPage(driver);
		}
		public void searching(String serachText,String serachItem ) throws InterruptedException
		{
			searchButton.sendKeys(serachText);
		   
			
		   Thread.sleep(3000);
		for(WebElement list:productList)
			{
				Thread.sleep(3000);
				String serachKey = list.getText();
				
				if(serachKey.contains("156"))
				{ 
				
					list.click();
					break;
				}
			}
		}
		public void selectProduct(String orignalproduct)
		{
			for(WebElement dispalyedproduct: searchedProductList)
			{  
				String userChoice=dispalyedproduct.getText();
				
				if(userChoice.equalsIgnoreCase(orignalproduct))
				{
					dispalyedproduct.click();
					break;
				}
			
		}
			
	}


}
