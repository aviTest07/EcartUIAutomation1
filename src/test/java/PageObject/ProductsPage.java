package PageObject;

	import java.util.ArrayList;

	import java.util.List;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseClass;
import Base.BasePage;

	public class ProductsPage extends BaseClass
	{

		@FindBy(xpath="(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[4]/following-sibling::span")
		WebElement menSection;
		
		@FindBy(xpath="(//span[.='Tops'])[2]")
		WebElement mensTop;
		
		@FindBy(xpath="//a[@id='ui-id-19']")
		WebElement jackets;
		
		@FindBy(xpath="(//span[@class='toolbar-number'])[1]")
		WebElement jacketscount;
		
		@FindBy(xpath="//li[@class='item product product-item']")
		List <WebElement> actualtscount;
		
		@FindBy(xpath="//li[@class='item product product-item']")
		List <WebElement> allJackets;

		@FindBy(xpath="//span[contains(@id,'product-price')]")
		List <WebElement> productprices;
		
		@FindBy(xpath="//input[@id='search']")
		WebElement search ;
		
		@FindBy(xpath="(//select[@id='sorter'])[1]")
		WebElement sorter1 ;
		
		@FindBy(xpath="//a[contains(@data-post,'430')] [@title='Add to Wish List']")
		WebElement wishlisticon;//a[contains(@data-post,'430')] [@title='Add to Wish List']
		
		@FindBy(xpath="//a[contains(@data-post,'350')] [@title='Add to Compare']")
		WebElement addtocompare;
		
		@FindBy(xpath="//img[@alt='Taurus Elements Shell']")
		WebElement compareableproduct1;
		
		@FindBy(xpath="//img[@alt='Montana Wind Jacket']")
		WebElement compareableproduct2;
		
		@FindBy(xpath="//a[contains(@data-post,'414')] [@title='Add to Compare']")
		WebElement addtocompare2;
		
		@FindBy(xpath="//div[contains(@data-ui-id,'message-success')]")
		WebElement text;
		
		@FindBy(xpath="//a[@class='action compare']")
		WebElement comparableitemscount;
		
		@FindBy(xpath="//strong[@class='product-item-name']")
		List <WebElement> compareitemslist;
		
		@FindBy(xpath="(//a[@title='Remove Product'])[1]")
		WebElement reomveitem;
		
		@FindBy(xpath="//div[@id='modal-content-15']")
		WebElement modalpopup;
		
		@FindBy(xpath="//button[.='OK']")
		WebElement acceptOk;
		
		public ProductsPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			// TODO Auto-generated constructor stub
		}
		
		public String getCountofItems() throws InterruptedException
		{
			
			 String count=jacketscount.getText();
			return count;
		}
		
		public String getProductCount()
		{
			int count=productprices.size();
			String procount= String.valueOf(count);
			return procount;		
		}
		
		public boolean isSorted()
		{
			ArrayList<Integer> price=new ArrayList<Integer>();
			for(WebElement pr:productprices)
			{
				String amt=pr.getText();
			  amt=  amt.substring(1,2);
				int amount=Integer.parseInt(amt);
				price.add(amount);		
			}
			return checkSorting(price);
		}
		public int actualCounts() 
		{
			 int count=actualtscount.size();
			return count;
		}
		
		public void sortByprice() 
		{
			Select s=new Select(sorter1);
			s.selectByVisibleText("Price");
		}
		
		public MyWishList wishList()
		{
		         JavascriptExecutor js = (JavascriptExecutor)driver; 
			        // Call the JavascriptExecutor methods
			        js.executeScript("arguments[0].click();",wishlisticon);
					return new MyWishList(driver);	    
		}
		
		public void addcompareItems()
		{
			Actions act=new Actions(driver);
			act.moveToElement(compareableproduct1).build().perform();
			act.moveToElement(addtocompare).click().perform();
		}
		
		public void addcompareItems2()
		{
			Actions act=new Actions(driver);
			act.moveToElement(compareableproduct2).build().perform();
			act.moveToElement(addtocompare2).click().perform();
		}
		
		public String successMessages()
		{
			return text.getText();
		}
		
		public void comaprablecount()
		{
			comparableitemscount.click();
		}
		
		public void getCompareList()
		{
			comparableitemscount.click();
		}

		public ArrayList<String> getList()
		{  
			comparableitemscount.click();
			ArrayList<String> arr=new ArrayList<String>();
			for(WebElement items:compareitemslist)
			{
				String getlistitem
				= items.getText();
				arr.add(getlistitem);
			}
			return arr;
		}
		
		public boolean removeItem(String alertmessage)
		{
			reomveitem.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String alertmess=modalpopup.getText();
			System.out.println(alertmess);
			if(alertmess.equalsIgnoreCase(alertmessage))
			{
				acceptOk.click();
				return true;
			}
			return false;
		}
		
	

}
