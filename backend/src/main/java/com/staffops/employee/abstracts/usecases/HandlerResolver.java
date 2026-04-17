package com.staffops.employee.abstracts.usecases;

public interface HandlerResolver {
    <TRequest, TResponse> UseCaseHandler<TRequest, TResponse> resolve(Class<?> requestType);
}
