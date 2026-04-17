package com.staffops.employee.usecases;

import com.staffops.employee.abstracts.usecases.HandlerResolver;
import com.staffops.employee.abstracts.usecases.UseCaseHandler;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@ApplicationScoped
public class InMemoryHandlerResolver implements HandlerResolver {

    private final Map<Class<?>, UseCaseHandler<?, ?>> handlers;

    @Override
    @SuppressWarnings("unchecked")
    public <TRequest, TResponse> UseCaseHandler<TRequest, TResponse> resolve(Class<?> requestType) {
        var handler = handlers.get(requestType);
        if (handler == null) {
            throw new IllegalStateException("No handler found for: " + requestType.getName());
        }
        return (UseCaseHandler<TRequest, TResponse>) handler;
    }
}