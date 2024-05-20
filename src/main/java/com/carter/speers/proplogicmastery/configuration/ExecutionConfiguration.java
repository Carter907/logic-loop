package com.carter.speers.proplogicmastery.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class ExecutionConfiguration {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Number of threads to keep in the pool, even if they are idle
        executor.setMaxPoolSize(10); // Maximum number of threads to allow in the pool
        executor.setQueueCapacity(5); // Queue size for holding tasks before they are executed
        executor.initialize();
        return executor;
    }
}
