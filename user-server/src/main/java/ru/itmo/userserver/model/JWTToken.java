package ru.itmo.userserver.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JWTToken {
    private final String type = "Bearer";
    private String value;
}
