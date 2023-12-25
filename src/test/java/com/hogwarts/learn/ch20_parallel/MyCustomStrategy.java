package com.hogwarts.learn.ch20_parallel;

import org.junit.platform.commons.JUnitException;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

public class MyCustomStrategy implements ParallelExecutionConfigurationStrategy {
    @Override
    public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
        // 自定义并发次数：
        Integer count = configurationParameters.get("custom.parallelism", Integer::valueOf)
                .orElseThrow(() -> {
                    return new JUnitException(String.format("Configuration parameter %s must be set", "fixed.parallelism"));
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
