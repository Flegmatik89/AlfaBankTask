package com.example.alfaTestTask.listeners;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.example.alfaTestTask.utility.Utils;

public class AllureListener implements AfterTestExecutionCallback {
    Utils utils = new Utils();


    @Override
    public void afterTestExecution(ExtensionContext context) {
        boolean testFailed = context.getExecutionException().isPresent();

        if (testFailed) {
            utils.takeScreenshot();
        }
    }
}
