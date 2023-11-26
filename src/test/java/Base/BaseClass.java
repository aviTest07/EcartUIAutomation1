package Base;



	import java.io.File;


	import java.io.FileInputStream;

	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
	import java.util.Properties;
	import java.util.ResourceBundle;
	import java.util.logging.LogManager;

	import org.apache.commons.io.FileUtils;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass 
	{
		
		public static WebDriver driver;
		public static Logger logger;
		public static Properties prop;
		public static ResourceBundle rb;
		public static FileInputStream  fis;
		public WebDriverWait wait;
		/*public BaseClass(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
		*/
		
		@Parameters("browser")
		@BeforeClass
		public void setup(@Optional("chrome")String browser) throws IOException
		{
			//logger=LogManager.getLogger(this.getClass());  //logging
			
			// OR we can use ResourceBundle to use property file.
			
			// rb=ResourceBundle.getBundle("config");
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.Properties");
			prop=new Properties();
			prop.load(fis);
			
			if(browser.equalsIgnoreCase("edge"))
			{	
			System.setProperty("Webdriver.edge.driver",System.getProperty("user.dir") +"\\Driver\\msedgedriver.exe");
				//WebDriverManager.chromedriver().setup();
		//	ChromeOptions chromeOptions = new ChromeOptions();

			//chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\test\\Resources\\Drivers\\chromedriver.exe");
				
				ChromeOptions chromeOptions = new ChromeOptions();

				chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
				
			}
			else
			{
				
			}
		driver= new ChromeDriver();

			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			driver.get(prop.getProperty("url"));
			
			// OR we can use ResourceBundle to use property file.
			
			//driver.get(rb.getString("url"));
			
			driver.manage().window().maximize();		
		}

		public	boolean checkSorting(ArrayList< Integer > arraylist)
		{
			boolean isSorted=true;
		    for(int i=1;i < arraylist.size();i++){
		        if(arraylist.get(i-1).compareTo(arraylist.get(i)) > 0){
		            isSorted= false;
		            break;
		        }
		    }
		    return isSorted;
		}
		
		public String captureScreenShot(String testname)
		{
			String timestamp= new SimpleDateFormat("YYYYMMDDHHMMSS").format(new Date());
			
			TakesScreenshot tks = (TakesScreenshot) driver;
			File source = tks.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir")+"\\screenshots\\" + testname + "_" + timestamp + ".png";
			
			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return destination;
		}
		
		public   void waitForElement(By by)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		
		
		
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		
		
	

}
