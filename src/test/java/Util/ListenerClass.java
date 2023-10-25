package Util;



	import java.text.SimpleDateFormat;



	import java.util.Date;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	import Base.BaseClass;



	public class ListenerClass extends Base.BaseClass implements ITestListener

	{
		public ExtentSparkReporter sparkReporter;
		public ExtentReports extent;
		public ExtentTest test;

		String repName;
		
		@Override
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			repName = "Test-Report-" + timeStamp + ".html";
			sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report

			sparkReporter.config().setDocumentTitle("opencart Automation Report"); // Title of report
			sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report
			sparkReporter.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application", "opencart");
			extent.setSystemInfo("Module", "Admin");
			extent.setSystemInfo("Sub Module", "Customers");
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Environemnt", "QA");		
		}
		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			test = extent.createTest(result.getName());
			test.log(Status.PASS, "Test Passed");
		}
		@Override
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			test = extent.createTest(result.getName());
			test.log(Status.FAIL, "Test Failed");
			test.log(Status.FAIL, result.getThrowable().getMessage());
			
			String imgPath = new Base.BaseClass().captureScreenShot(result.getName());
			System.out.println(imgPath);
			test.addScreenCaptureFromPath(imgPath);
		}
		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			test = extent.createTest(result.getName());
			test.log(Status.SKIP, "Test Skipped");
			test.log(Status.SKIP, result.getThrowable().getMessage());
		}
		@Override 
		public void onFinish(ITestContext context) {
			    extent.flush();
			  

		
	}
		
		

		
		
		



}
