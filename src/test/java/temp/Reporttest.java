package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporttest {
	public static WebDriver wd;
	public static ExtentReports reports;
	public static ExtentTest Log;
	@Test(priority=1)
	public void GoogleTest()
	{   wd=new FirefoxDriver();
	    wd.get("https://www.google.co.in/?gfe_rd=cr&ei=uaZCWJ7vC8WL8QfR7YiQBQ&gws_rd=ssl");
		reports = new ExtentReports("F:\\Selenium\\dddtest-old\\Reports\\ddd.html");
		Log=reports.startTest("GoogleTest");
		
		
	}
	@Test(priority=2)
	public void YahooTest()
	{
		Log=reports.startTest("YahooTest");
		wd.get("https://in.yahoo.com/?p=us");
	}
	@Test(priority=3)
	public void GmailTest()
	{  Log=reports.startTest("GmailTest");
		wd.get("https://accounts.google.com/");
	}
	@AfterMethod
	public void teardown(ITestResult R) throws IOException
	{
		Object[] data =  R.getParameters();
		if(R.isSuccess()){
			System.out.println(data[0].toString());
			String path = takesscreenshot(R.getName());
			Log.log(LogStatus.PASS, R.getName(), Log.addScreenCapture(path));
			
		}
		else
		{
			String path = takesscreenshot(data[0].toString());
			Log.log(LogStatus.FAIL, R.getName(), Log.addScreenCapture(path));
			
		}
		reports.endTest(Log);
		reports.flush();
	}
	public static String takesscreenshot(String name) throws IOException{//i need to return location of screenshot.Hence changing return type to string
	 File src=((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
	 File dest = new File("F:\\Selenium\\dddtest-old\\Screenshot\\"+name+".jpeg");
	 FileUtils.copyFile(src, dest);
	return dest.toString();//change file type to string
	}
}
