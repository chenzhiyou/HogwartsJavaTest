package com.hogwarts.junit5Basics.ch17_parallel;

import org.junit.platform.commons.JUnitException;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

// 自定义并发执行策略
public class MyCustomStrategy implements ParallelExecutionConfigurationStrategy {
    @Override
    public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
        int count = configurationParameters.get("custom.parallelism", Integer::valueOf).orElseThrow(
                ()->{
                    return new JUnitException(String.format("Configuration %s must be set", "custom.parallelism"));
                });
        return new ParallelExecutionConfiguration() {
            @Override
            public int getParallelism() {
                return count;
            }

            @Override
            public int getMinimumRunnable() {
                return count;
            }

            @Override
            public int getMaxPoolSize() {
                return count;
            }

            @Override
            public int getCorePoolSize() {
                return count;
            }

            @Override
            public int getKeepAliveSeconds() {
                return count;
            }
        };
    }
}
