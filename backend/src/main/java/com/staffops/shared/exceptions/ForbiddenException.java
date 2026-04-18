package com.staffops.shared.exceptions;

import java.util.Map;

public class ForbiddenException extends BaseException {
    private static final String ERROR_CODE = "FORBIDDEN";

    public ForbiddenException(String message) {
        this(message, null);
    }

    public ForbiddenException(String message, Map<String, Object> details) {
        super(ERROR_CODE, message, details);
    }
}
