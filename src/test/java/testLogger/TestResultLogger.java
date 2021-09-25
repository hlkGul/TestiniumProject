package testLogger;

import logger.Log;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;

public class TestResultLogger implements TestWatcher {

    Log log = new Log();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log.warn(context.getDisplayName() + " DISABLED");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log.info(context.getDisplayName() + " PASSED");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log.warn(context.getDisplayName() + " ABORTED");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.error(context.getDisplayName() + " FAILED with cause : "+ cause.getMessage());
    }
}
