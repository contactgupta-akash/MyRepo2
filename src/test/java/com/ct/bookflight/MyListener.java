package com.ct.bookflight;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ct.test.base.Driver;

public class MyListener implements ITestListener{

	// WebDriver driver;

	 String filePath = System.getProperty("user.dir")+ "\\output\\ScreenShots\\";

	 public void onTestStart(ITestResult result) {
	 

	 }

	 public void onTestSuccess(ITestResult result) {
	 

	 }




	 public void onStart(ITestContext context) {
	  // TODO Auto-generated method stub

	 }

	 public void onFinish(ITestContext context) {
	  // TODO Auto-generated method stub

	 }

	 public void onTestFailure(ITestResult result) {
	  System.out.println(" Error "+result.getName()+" test has failed ");
	  File scrFile = ((TakesScreenshot) Driver.driver)
	    .getScreenshotAs(OutputType.FILE);
	  String sFilename = null;
	  sFilename = "Screenshot-"+".png";
	  String FullSnapShotFilePath = System.getProperty("user.dir")
	    + "\\output\\ScreenShots\\" + sFilename;
	    try {
	     FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
	    } catch (Exception e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	    }
	   

}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
