package com.hogwarts.learn.ch23_callback;

import org.junit.jupiter.api.extension.*;

public class CallExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback,
        BeforeTestExecutionCallback, AfterTestExecutionCallback {
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("CallExtension -- afterAll");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("CallExtension -- afterEach");
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("CallExtension -- afterTestExecution");

    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("CallExtension -- beforeAll");

    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("CallExtension -- beforeEach");

    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("CallExtension -- beforeTestExecution");

    }
}
