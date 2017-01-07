package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntltaxi.initializer.initializer;

public class ScreenshotGenerator extends initializer {

	
	
	public static void teardown(ITestResult R) throws IOException
	{
		Object[] data =  R.getParameters();
		if(R.isSuccess()){
			System.out.println(data[0].toString());
			String path = takesscreenshot(data[0].toString());
			Log.log(LogStatus.PASS, data[0].toString(), Log.addScreenCapture(path));
			
		}
		else
		{
			String path = takesscreenshot(data[0].toString());
			Log.log(LogStatus.FAIL, data[0].toString(), Log.addScreenCapture(path));
			
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
