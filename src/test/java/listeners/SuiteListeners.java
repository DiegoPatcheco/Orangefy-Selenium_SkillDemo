package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.Logs;
import utilities.FileManager;

public class SuiteListeners implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        Logs.info("Suite starting: %s", suite.getName());
        FileManager.deletePreviousEvidence();
    }

    @Override
    public void onFinish(ISuite suite) {
        Logs.info("Suite finishing: %s", suite.getName());
    }
}
