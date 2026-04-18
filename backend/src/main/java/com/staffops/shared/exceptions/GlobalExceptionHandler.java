package com.staffops.shared.exceptions;

import com.staffops.shared.dtos.errors.ErrorResponse;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {
    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);
    private static final String DEFAULT_UNEXPECTED_MESSAGE = "An unexpected error occurred";

    @Override
    public Response toResponse(Throwable throwable) {
        LOGGER.error("An exception occurs: ", throwable);

        if (throwable instanceof BaseException baseException) {
            return buildResponse(resolveStatus(baseException), ErrorResponse.fromException(baseException));
        }

        if (throwable instanceof WebApplicationException webApplicationException) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode("HTTP_" + webApplicationException.getResponse().getStatus());
            errorResponse.setMessage(resolveWebApplicationMessage(webApplicationException));
            errorResponse.setDetails(null);

            return buildResponse(webApplicationException.getResponse().getStatus(), errorResponse);
        }

        UnexpectedException unexpectedException = new UnexpectedException(DEFAULT_UNEXPECTED_MESSAGE, null);
        return buildResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorResponse.fromException(unexpectedException));
    }

    private int resolveStatus(BaseException exception) {
        if (exception instanceof NotFoundException) {
            return Response.Status.NOT_FOUND.getStatusCode();
        }
        if (exception instanceof ForbiddenException) {
            return Response.Status.FORBIDDEN.getStatusCode();
        }
        if (exception instanceof ConflictException) {
            return Response.Status.CONFLICT.getStatusCode();
        }
        if (exception instanceof ValidationException) {
            return Response.Status.BAD_REQUEST.getStatusCode();
        }
        if (exception instanceof UnexpectedException) {
            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        }
        return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    }

    private String resolveWebApplicationMessage(WebApplicationException exception) {
        String message = exception.getMessage();
        if (message == null || message.isBlank()) {
            Response.Status status = Response.Status.fromStatusCode(exception.getResponse().getStatus());
            if (status == null) {
                return "HTTP " + exception.getResponse().getStatus();
            }
            return status.getReasonPhrase();
        }
        return message;
    }

    private Response buildResponse(int statusCode, ErrorResponse errorResponse) {
        return Response.status(statusCode)
            .type(MediaType.APPLICATION_JSON)
            .entity(errorResponse)
            .build();
    }
}
