package utility;

import java.io.IOException;
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

import jdk.internal.org.jline.utils.Log;
import testbase.Base_test;

public class ExtentReportUtility implements ITestListener {
	
	ExtentSparkReporter Sparkreporter;
	
	ExtentReports Extent;
	
	ExtentTest test;
	
		public void onStart(ITestContext contextStart) {
			
			Date Currentdate = new Date();	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); 
			String timeStamp=formatter.format(Currentdate);
			String repname = "Test-Report-"+timeStamp+".html";
//			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
         Sparkreporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+repname);
         Sparkreporter.config().setDocumentTitle("opencart Automation Report");
         Sparkreporter.config().setReportName("opencart Functional Testing");
         Sparkreporter.config().setTheme(Theme.STANDARD);
         
         
         
         Extent=new ExtentReports();
         Extent.attachReporter(Sparkreporter);
         Extent.setSystemInfo("Application", "opencart");
 		Extent.setSystemInfo("Module", "Admin");
 		Extent.setSystemInfo("Sub Module", "Customers");
 		Extent.setSystemInfo("Operating System", System.getProperty("os.name"));
 		Extent.setSystemInfo("User Name", System.getProperty("user.name"));
 		Extent.setSystemInfo("Environemnt", "QA");
			
			}
		public void onTestSuccess(ITestResult result) {
			
			test= Extent.createTest(result.getName());

			test.log(Status.PASS, "Test passed");

			}
		public void onTestSkipped(ITestResult result) {

 test = Extent.createTest(result.getName());
 test.log(Status.SKIP, "Test Skipped");
 test.log(Status.SKIP, result.getThrowable().getMessage());
			}

		
		public void onTestFailure(ITestResult result) {
		test = Extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		Base_test Sc =new Base_test();
		
		try {
			String path = Sc.Capturingimg(result.getName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		}

		
		public void onFinish(ITestContext contextFinish) {
				Extent.flush();

				}
}
