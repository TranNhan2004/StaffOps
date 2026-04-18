package com.staffops.shared.exceptions;

import java.util.Map;

public class NotFoundException extends BaseException {
    private static final String ERROR_CODE = "NOT_FOUND";

    public NotFoundException(String message) {
        this(message, null);
    }

    public NotFoundException(String message, Map<String, Object> details) {
        super(ERROR_CODE, message, details);
    }
}
