package com.staffops.shared.exceptions;

import java.util.Map;

public class BaseException extends RuntimeException {
    private final String errorCode;
    private final Map<String, Object> details;

    public BaseException(String errorCode, String message, Map<String, Object> details) {
        super(message);
        this.errorCode = errorCode;
        this.details = details;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Map<String, Object> getDetails() {
        return details;
    }
}
