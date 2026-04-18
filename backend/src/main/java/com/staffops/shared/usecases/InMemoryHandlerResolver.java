package com.staffops.shared.usecases;

import com.staffops.shared.abstracts.usecases.HandlerResolver;
import com.staffops.shared.abstracts.usecases.UseCaseHandler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class InMemoryHandlerResolver implements HandlerResolver {

    private final Map<Class<?>, UseCaseHandler<?, ?>> handlers;

    public InMemoryHandlerResolver(@Any Instance<UseCaseHandler<?, ?>> handlerInstances) {
        Map<Class<?>, UseCaseHandler<?, ?>> resolvedHandlers = new HashMap<>();
        for (Instance.Handle<UseCaseHandler<?, ?>> handle : handlerInstances.handles()) {
            Class<?> requestType = resolveRequestType(handle.getBean().getBeanClass());
            UseCaseHandler<?, ?> previous = resolvedHandlers.put(requestType, handle.get());
            if (previous != null) {
                throw new IllegalStateException("Duplicate handler registered for: " + requestType.getName());
            }
        }
        this.handlers = Map.copyOf(resolvedHandlers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <TRequest, TResponse> UseCaseHandler<TRequest, TResponse> resolve(Class<?> requestType) {
        var handler = handlers.get(requestType);
        if (handler == null) {
            throw new IllegalStateException("No handler found for: " + requestType.getName());
        }
        return (UseCaseHandler<TRequest, TResponse>) handler;
    }

    private Class<?> resolveRequestType(Class<?> handlerClass) {
        Class<?> resolvedType = resolveRequestTypeFromClass(handlerClass);
        if (resolvedType == null) {
            throw new IllegalStateException("Cannot resolve request type for handler: " + handlerClass.getName());
        }
        return resolvedType;
    }

    private Class<?> resolveRequestTypeFromClass(Class<?> handlerClass) {
        for (Type genericInterface : handlerClass.getGenericInterfaces()) {
            Class<?> resolvedType = resolveRequestTypeFromType(genericInterface);
            if (resolvedType != null) {
                return resolvedType;
            }
        }

        Type genericSuperclass = handlerClass.getGenericSuperclass();
        if (genericSuperclass != null) {
            Class<?> resolvedType = resolveRequestTypeFromType(genericSuperclass);
            if (resolvedType != null) {
                return resolvedType;
            }
        }

        Class<?> superclass = handlerClass.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            return resolveRequestTypeFromClass(superclass);
        }

        return null;
    }

    private Class<?> resolveRequestTypeFromType(Type type) {
        if (type instanceof ParameterizedType parameterizedType) {
            Type rawType = parameterizedType.getRawType();
            if (rawType instanceof Class<?> rawClass && UseCaseHandler.class.equals(rawClass)) {
                Type requestType = parameterizedType.getActualTypeArguments()[0];
                if (requestType instanceof Class<?> requestClass) {
                    return requestClass;
                }
                throw new IllegalStateException("Handler request type must be a concrete class: " + requestType.getTypeName());
            }
            if (rawType instanceof Class<?> rawClass) {
                return resolveRequestTypeFromClass(rawClass);
            }
        }

        if (type instanceof Class<?> rawClass) {
            return resolveRequestTypeFromClass(rawClass);
        }

        return null;
    }
}
