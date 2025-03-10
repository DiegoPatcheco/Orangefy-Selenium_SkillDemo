package listeners;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import utilities.Logs;
import utilities.WebDriverProvider;
import utilities.FileManager;

public class AllureListeners implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        Logs.debug("Allure: Taking screenshot");
        final var resultType = result.getStatus();

        switch (resultType) {
            case BROKEN, FAILED -> {
                if (new WebDriverProvider().get() != null) {
                    FileManager.getScreenshot();
                    FileManager.getPageSource();
                }
            }
        }
    }
}
