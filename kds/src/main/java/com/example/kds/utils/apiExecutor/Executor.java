package com.example.kds.utils.apiExecutor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public interface Executor {
    List<Object> execute(List<CompletableFuture<?>> future) throws ExecutionException, InterruptedException;

    default ExecutorService createNamedExecutor(int threadCount, String threadNamePrefix) {
        AtomicInteger threadIndex = new AtomicInteger(0);
        return Executors.newFixedThreadPool(
                threadCount,
                r -> {
                    Thread thread = new Thread(r, threadNamePrefix + threadIndex.getAndIncrement());
                    thread.setUncaughtExceptionHandler(
                            (t, e) ->
                                    System.out.println("Uncaught exception in thread" + t.getName() + e.getMessage() + e));
                    return thread;
                });
    }

    default List<Object> executionHelper(List<CompletableFuture<?>> futureArray, ExecutorService executor) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Object>> futuresArray = CompletableFuture
                .supplyAsync(() -> {
                    return futureArray.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                }, executor);
        return futuresArray.get();
    }
}
