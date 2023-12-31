package com.hogwarts.learn.ch23_callback;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import javax.mail.event.MailEvent;
import java.lang.reflect.Method;
import java.util.Optional;

public class TimeExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        Long startTime = context.getStore(ExtensionContext.Namespace.create(
                getClass(), testMethod
        )).remove("Start-Time", long.class);
        Long endTime = System.currentTimeMillis();
        Long durationTime = endTime -startTime;
        System.out.println("方法名为： "+ testMethod.getName() + " 持续时间为： "+ durationTime);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        context.getStore(ExtensionContext.Namespace.create(
                getClass(), testMethod
        )).put("Start-Time", System.currentTimeMillis());
    }
}
