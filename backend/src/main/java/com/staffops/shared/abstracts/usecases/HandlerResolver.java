package com.staffops.shared.abstracts.usecases;

public interface HandlerResolver {
    <TRequest, TResponse> UseCaseHandler<TRequest, TResponse> resolve(Class<?> requestType);
}
