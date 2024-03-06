package extentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageobjects.FirstPageBikes;
import pageobjects.LoginPage;
import pageobjects.SecondPageBikes;
import pageobjects.ThirdPageBikes;

 
public class Extentreports implements ITestListener
{
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
 
	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/Reports/report.html");//specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","manikanta");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
	}
 
 
	public void onTestSuccess(ITestResult result) {
		String path = FirstPageBikes.path;
		String path2 = SecondPageBikes.path;
		String path3 = ThirdPageBikes.path;
		String path4 =LoginPage.path;
		if(result.getName().equals("NewBikes")) {
			
			test = extent.createTest(result.getName())
					.addScreenCaptureFromPath(path,result.getName());
		}
        else if(result.getName().equals("UpcomingBikes")) {
			
			test = extent.createTest(result.getName())
					.addScreenCaptureFromPath(path,result.getName());
		}
		else if(result.getName().equals("ManufacturerDrop")) {
			
			test = extent.createTest(result.getName())
					.addScreenCaptureFromPath(path2,result.getName());
		}
		else if(result.getName().equals("Viewmore")){
			
			test = extent.createTest(result.getName())
					.addScreenCaptureFromPath(path3,result.getName());
		}
		else if(result.getName().equals("Usedcars")) {
			
			test = extent.createTest(result.getName())
					.addScreenCaptureFromPath(path3,result.getName());
		}
		
         
		else if(result.getName().equals("Lognwndw")){
			
			test = extent.createTest(result.getName())
					.addScreenCaptureFromPath(path4,result.getName());
			
		}
       else if(result.getName().equals("EnterDetails")) {
			
			test = extent.createTest(result.getName())
					.addScreenCaptureFromPath(path4,result.getName());
		}
		else if(result.getName().equals("ErrorMsg")){
			
			test = extent.createTest(result.getName())
					.addScreenCaptureFromPath(path4,result.getName());
			
		}
		else {
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
	}
	}
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
	}
 
	public void onTestSkipped(ITestResult result) {
 
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	}
 
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}