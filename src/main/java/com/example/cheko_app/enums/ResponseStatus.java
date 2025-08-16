package com.example.cheko_app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {

    SUCCESS(1001, "تم بنجاح", "SUCCESS"),
    FAIL(2001, "فشل", "FAIL");

    private final int code;
    private final String message;
    private final String messageEn;
}
