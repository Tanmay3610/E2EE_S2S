package com.example.kds.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientType {
    BANK("bank"), PARTNER("partner");
    private final String clientType;
}
