package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This method provides implementation for ITestListener interface of TestNG
 * @author metri
 */

public class ListenersImplementation implements ITestListener
{
	
	ExtentReports report;
	ExtentTest test;  //Defines a test. You can add logs, snapshots, assign author and categories to a test and its children. 

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		result.getTestName();
		String scriptName = result.getMethod().getMethodName();
		System.out.println(scriptName+"==== Test execution started ====");
		
		//Create test script
		test=report.createTest(scriptName);		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String scriptName = result.getMethod().getMethodName();
		System.out.println(scriptName+"==== Pass ====");
		
		//Log the success
		test.log(Status.PASS, scriptName+" == PASS ==");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//Screenshot n failure of test
		String scriptName = result.getMethod().getMethodName();
		System.out.println(scriptName+"==== Fail ====");
		
		//Exception on failure
		System.out.println(result.getThrowable());
		
		//log for failure
		test.log(Status.FAIL, scriptName+" == Fail ==");
		test.log(Status.INFO, result.getThrowable());
		
		//Screenshot
		String screenShotName = scriptName + new JavaUtility().getSystemDate();
		
		WebDriverUtility w=new WebDriverUtility();
		try {
			String path=w.captureScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generatedr5 catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String scriptName = result.getMethod().getMethodName();
		System.out.println(scriptName+"==== Skip ====");
		
		//Exception on skip
		System.out.println(result.getThrowable());
		
		//On skip
		test.log(Status.SKIP,scriptName+"== Skip ==");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Suite execution started ====");
		
		//Basic report configueration
		ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtendsReport\\Reports"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.STANDARD);
		html.config().setDocumentTitle("Execution report");
		html.config().setReportName("Vtiger");
//		html.config().setReporter(html);
		report=new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base browser","firefox");
		report.setSystemInfo("Base platform","windows");
		report.setSystemInfo("Base environment","test env");
		report.setSystemInfo("reporter name","me");
		

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Suite execution finished ====");
		report.flush();  // MAndatory :- it will consolidate all test execution status and generate the report. 

	}

}
