package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.ObjectsRepo;

public class MyListener extends ObjectsRepo implements ITestListener {

		@Override
		public void onTestStart(ITestResult result) {
			test=report.createTest(result.getMethod().getMethodName());
		}                                                                  	

		@Override 
		public void onTestSuccess(ITestResult result) {
			test.log(Status.PASS, "Test Case:"+result.getMethod().getMethodName()+" is Passed");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			test.log(Status.FAIL, "Test Case:"+result.getMethod().getMethodName()+" is Failed");
			test.log(Status.FAIL, result.getThrowable());
				
			SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
			Date date=new Date();
			String formatedDate=format.format(date);
			
			//String random=result.getName();
			TakesScreenshot t=(TakesScreenshot)driver;
			File src=t.getScreenshotAs(OutputType.FILE);
			String filePath=System.getProperty("user.dir")+"./TestReports/Screenshots/Screenshot_"+formatedDate+".png";
			File des=new File(filePath);
			try {
				FileUtils.copyFile(src, des);
			} 
			catch (IOException e) {
			}	
			test.addScreenCaptureFromPath(filePath, "Test Case Failure ScreenShot");
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			test.log(Status.SKIP, "Test Case:"+result.getMethod().getMethodName()+" is Skipped");
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
		}

		@Override
		public void onStart(ITestContext context) {
			report=ExtentReportManager.setupExtentReport();
		}

		@Override
		public void onFinish(ITestContext context) {
			report.flush();
		} 
}
