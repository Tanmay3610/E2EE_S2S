package com.example.kds.services;

import com.example.kds.enums.ExecutorsType;
import com.example.kds.utils.api.ApiClient;
import com.example.kds.utils.apiExecutor.Executor;
import com.example.kds.utils.apiExecutor.ExecutorSelector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ApiCompositionService {
    ApiClient apiClient;
    ExecutorSelector executorSelector;

    ApiCompositionService(ApiClient apiClient, ExecutorSelector executorSelector) {
        this.apiClient = apiClient;
        this.executorSelector = executorSelector;
    }

    private List<CompletableFuture<?>> getRequestListBatch1() {
        List<CompletableFuture<?>> completableFuturesList = new ArrayList<>(List.of());
        completableFuturesList.add(apiClient.get(1));
        completableFuturesList.add(apiClient.get(2));
        completableFuturesList.add(apiClient.get(3));
        completableFuturesList.add(apiClient.get(4));
        completableFuturesList.add(apiClient.get(5));
        completableFuturesList.add(apiClient.get(6));
        completableFuturesList.add(apiClient.get(7));
        completableFuturesList.add(apiClient.get(8));

        return completableFuturesList;
    }

    private List<CompletableFuture<?>> getRequestListBatch2() {
        List<CompletableFuture<?>> completableFuturesList = new ArrayList<>(List.of());
        completableFuturesList.add(apiClient.get(9));
        completableFuturesList.add(apiClient.get(10));
        completableFuturesList.add(apiClient.get(11));
        completableFuturesList.add(apiClient.get(12));
        completableFuturesList.add(apiClient.get(13));
        completableFuturesList.add(apiClient.get(14));
        completableFuturesList.add(apiClient.get(15));
        completableFuturesList.add(apiClient.get(16));

        return completableFuturesList;
    }

    private void runParallelExecutor() throws ExecutionException, InterruptedException {
        Executor parallelExecutor = executorSelector.getExecutor(ExecutorsType.PARALLEL);

        List<Object> parallelExecutorRes = parallelExecutor.execute(getRequestListBatch1());
    }

    private void runSequentialExecutor() throws ExecutionException, InterruptedException {
        Executor sequentialExecutor = executorSelector.getExecutor(ExecutorsType.SEQUENTIAL);

        List<Object> sequentialExecutorRes = sequentialExecutor.execute(getRequestListBatch2());
    }

    public String compositionTesting() throws ExecutionException, InterruptedException {
        runParallelExecutor();
        runSequentialExecutor();
        return "";
    }
}
