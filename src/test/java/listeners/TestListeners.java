package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.Logs;
import utilities.FileManager;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("Test start: %s", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("Test success: %s", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.info("Test fail: %s", result.getName());
        FileManager.getScreenshot(result.getName());
        FileManager.getPageSource(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("Test skipped: %s", result.getName());
    }
}
