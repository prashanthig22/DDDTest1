package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initializer.initializer;

public class ReportGenerator extends initializer{
		
	@Test
	public static void archivefiles() throws IOException
	{  
		if(isarchive)
		{
		SimpleDateFormat sf = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
	    String Date = sf.format(new Date());
		File src = new File("F:\\Selenium\\dddtest-old\\Screenshot");
		File dest = new File("F:\\Selenium\\dddtest-old\\old screenshot\\"+Date);
		FileUtils.copyDirectory(src, dest);
		FileUtils.cleanDirectory(src);
		isarchive=false;
		}
	}

}
