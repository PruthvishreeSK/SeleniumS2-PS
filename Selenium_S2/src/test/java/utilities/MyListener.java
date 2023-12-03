package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pages.TestBase;

public class MyListener extends TestBase implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/myss.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("TestNG started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("TestNG finished");
	}

}
