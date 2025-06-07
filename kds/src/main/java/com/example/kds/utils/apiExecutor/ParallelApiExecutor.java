package com.example.kds.utils.apiExecutor;

import com.example.kds.utils.Constants;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

@Component(value = Constants.PARALLEL_EXECUTOR_BEAN_NAME)
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ParallelApiExecutor implements Executor{
    private ExecutorService ioBoundExecutor = null;

    ParallelApiExecutor() {
        int cpuCores = Runtime.getRuntime().availableProcessors();
        int IO_MULTIPLIER = 5;

        this.ioBoundExecutor = this.createNamedExecutor(cpuCores * IO_MULTIPLIER, "io-bound-executor-thread-");
    }

    @Override
    public List<Object> execute(List<CompletableFuture<?>> futureArray) throws ExecutionException, InterruptedException {
        Instant startTimeExecution = Instant.now();
        List<Object> res = this.executionHelper(futureArray, ioBoundExecutor);
        System.out.println("Parallel Time Execution in Millis: " + Duration.between(startTimeExecution, Instant.now()).toMillis());
        return res;
    }
}
