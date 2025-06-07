package com.example.kds.utils.apiExecutor;

import com.example.kds.enums.ExecutorsType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExecutorSelector {
    Map<String, Executor> executorsMap;

    ExecutorSelector(Map<String, Executor> executorsMap) {
        this.executorsMap = executorsMap;
    }

    public Executor getExecutor(ExecutorsType key) {
        return executorsMap.get(key.getType());
    }
}
