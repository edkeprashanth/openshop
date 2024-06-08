package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base_test {
	public static WebDriver driver;
	
	public Logger logger;
	
	@BeforeClass
	@Parameters("Browser")
 public void setup(String brw) {
		
		ResourceBundle rb = ResourceBundle.getBundle("Config");
		
		logger=LogManager.getLogger(this.getClass());
		logger.info("Choose browser");
		if(brw.equalsIgnoreCase("Chrome")) {
		driver = new ChromeDriver();
		}
		else if(brw.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Application Url is opening......");
			driver.get(rb.getString("AppUrl"));
			driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tear() {
		
		logger.info("driver is closing....");
		driver.quit();;
	}
	
	
	public String randomnumber() {
		
		
		String telnum=RandomStringUtils.randomNumeric(7);
		return telnum;
	}
	
	public String randomString() {
		String generatefname=RandomStringUtils.randomAlphabetic(7);
		return generatefname; 
	}
	
	public String randomalphanumeric() {
		String generatealphanumeric = RandomStringUtils.randomAlphanumeric(7);
		return generatealphanumeric;
	}
public String Capturingimg(String tesname) throws IOException {
	Date currentdate = new Date();
	SimpleDateFormat formate = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
	String timestamp = formate.format(currentdate);
	
		String ff= tesname+"Screenshot-"+timestamp+".html";
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File Sourcefile =ts.getScreenshotAs(OutputType.FILE);
	File Destinationfile=new File(System.getProperty("user.dir")+"\\ScreenShot\\"+ff);
	String  Destination = System.getProperty("user.dir")+"\\ScreenShot\\"+ff;
	
	FileUtils.copyFile(Sourcefile,Destinationfile);
	return Destination;
}
	
}
