package com.staffops.shared.dtos.errors;

import com.staffops.shared.exceptions.BaseException;
import com.staffops.shared.exceptions.UnexpectedException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private String errorCode;
    private String message;
    private Map<String, Object> details;

    public static ErrorResponse fromException(BaseException exception) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(exception.getErrorCode());
        response.setMessage(exception.getMessage());
        response.setDetails(exception instanceof UnexpectedException ? null : exception.getDetails());
        return response;
    }
}
