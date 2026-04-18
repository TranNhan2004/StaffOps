package com.staffops.shared.exceptions;

import java.util.Map;

public class ValidationException extends BaseException {
    private static final String ERROR_CODE = "VALIDATION";

    public ValidationException(String message) {
        this(message, null);
    }

    public ValidationException(String message, Map<String, Object> details) {
        super(ERROR_CODE, message, details);
    }
}
