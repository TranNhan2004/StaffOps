package com.staffops.shared.exceptions;

import java.util.Map;

public class ConflictException extends BaseException {
    private static final String ERROR_CODE = "CONFLICT";

    public ConflictException(String message) {
        this(message, null);
    }

    public ConflictException(String message, Map<String, Object> details) {
        super(ERROR_CODE, message, details);
    }
}
