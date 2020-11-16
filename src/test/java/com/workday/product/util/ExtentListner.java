package com.workday.product.util;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListner extends BaseTest implements ITestListener  {
	
	public static ExtentTest logger;

	
	public static ExtentReports extent =ExtentManager.createReport("./Reports/ListenerReport.html");
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		logger = extent.createTest(result.getClass().getName() + " @TestCase" + result.getMethod().getMethodName());
		testReport.set(logger);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  PASSED" + "</b>";

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		logger.pass(m);

		// logger.getStatus();
	    // logger.log(Status.PASS, " TEST CASE PASS IS " + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		//
		// First arugement
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		
		logger.fail("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured:Click to see"
				+ "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		
		logger.log(Status.FAIL, m);

				// second argument
				String methodName = result.getMethod().getMethodName();

				String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " FAILED" + "</b>";

				Markup m1 = MarkupHelper.createLabel(logText, ExtentColor.RED);
				logger.fail(m1);
				
				// Third argument individual
				logger.fail(result.getThrowable().getMessage());
				logger.log(Status.FAIL, result.getName() + " TEST CASE ERROR IS " + result.getThrowable().getMessage());
				
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// first argument
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		logger.skip("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured:Click to see"
				+ "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

		String skippedLogg = "TEST CASE SKIPPED  " + result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(skippedLogg, ExtentColor.ORANGE);
		logger.log(Status.SKIP, m);
		
		// second argument
		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " SKIPPED" + "</b>";

		Markup m1 = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		logger.pass(m1);
		// third argument
		logger.skip(result.getThrowable().getMessage());
		logger.log(Status.SKIP, result.getName() + " TEST CASE ERROR IS " + result.getThrowable().getMessage());

		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
	
			// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
			System.out.println(context.getName()+" *******   EXECUTED   ********* ");
		}
		
	}

}
