package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BasePage;
import report.ExtentReportNG;
import screenshot.TakeScreenShot;

import java.io.IOException;

public class Listeners extends BasePage implements ITestListener  {
    ExtentTest test;
    ExtentReports extent=ExtentReportNG.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String filepath;
        try {
            filepath = TakeScreenShot.screenShot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName()); //to attach screenshots to report
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}