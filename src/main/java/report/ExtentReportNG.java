package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.BasePage;

public class ExtentReportNG extends BasePage {

    public static ExtentReports getReportObject() {

        String reportPath = System.getProperty("user.dir") + "//reports/index.html";
        ExtentSparkReporter report = new ExtentSparkReporter(reportPath);
        report.config().setReportName("Jumia Tests Report");
        report.config().setDocumentTitle("Jumia Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Eslam Mashaly", "Tester");
        return extent;
    }
}