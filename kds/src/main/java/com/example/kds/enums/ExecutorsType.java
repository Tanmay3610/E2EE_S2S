package com.example.kds.enums;

import com.example.kds.utils.Constants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExecutorsType {
    PARALLEL(Constants.PARALLEL_EXECUTOR_BEAN_NAME),
    SEQUENTIAL(Constants.SEQUENTIAL_EXECUTOR_BEAN_NAME);

    private final String type;
}
