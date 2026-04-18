package com.staffops.shared.exceptions;

import java.util.Map;

public class UnexpectedException extends BaseException {
    private static final String ERROR_CODE = "UNEXPECTED";

    public UnexpectedException(String message) {
        this(message, null);
    }

    public UnexpectedException(String message, Map<String, Object> details) {
        super(ERROR_CODE, message, details);
    }
}
