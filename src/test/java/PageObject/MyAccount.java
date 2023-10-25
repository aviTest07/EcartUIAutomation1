package PageObject;



	import org.openqa.selenium.By;

	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.testng.Assert;

	import Base.BaseClass;
	import Base.BasePage;

	public class MyAccount extends BasePage
	{

		public MyAccount(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		
		@FindBy(xpath="(//span[@aria-haspopup='true'])[1]")
		WebElement dropdown;
		
		@FindBy(xpath="(//a[contains(text(),'My Account')])[1]")
		WebElement  myaccount;
		
		@FindBy(xpath="(//a[contains(text(),'My Account')])[1]")
		WebElement  reviewlist;
		
		@FindBy(xpath="//img[@alt='Proteus Fitness Jackshirt']")
		WebElement  reviewproduct;
		
		@FindBy(xpath="//a[@id='tab-label-reviews-title']")
		WebElement  reviews;
		
		@FindBy(xpath="//label[contains(@id,'Rating_3')]")
		WebElement  rating;
		
		By ratings= By.xpath("//label[contains(@id,'Rating_3')]");
		
		@FindBy(xpath="//input[@id='summary_field']")
		WebElement  summaryfield;
		
		@FindBy(xpath="//textarea[@name='detail']")
		WebElement  reviewField;
		
		@FindBy(xpath="//strong[contains(.,'My Recent Reviews')]/following-sibling::a")
		WebElement  viewall;
		
		@FindBy(xpath="//span[@class='toolbar-number']")
		WebElement  countlist;
		
		@FindBy(xpath="//span[contains(.,'Submit Review')]")
		WebElement  submitreview;

		public void selectproductreview()
		{
			reviewproduct.click();	
		}
		
		public void selectdropdown()
		{
			dropdown.click();
			myaccount.click();
			viewall.click();
			
		}

		public String getReviewItem()
		{
			return countlist.getText();
			
		}
		
		public void enterarating() throws InterruptedException
		{
			reviews.click();
			BaseClass.waitForElement(ratings);
			//Thread.sleep(5000);
			Actions act=new Actions(driver);
			act.moveToElement(rating).build().perform();
			act.moveToElement(rating).click().perform();
		}
		
		public void entersummary(String summary)
		{
			summaryfield.sendKeys(summary);
		}
		
		public void enterreview(String reviewtext)
		{
			reviewField.sendKeys(reviewtext);
		}
		
		public void submitreview()
		{
			submitreview.click();
			
		
		
	}


}
