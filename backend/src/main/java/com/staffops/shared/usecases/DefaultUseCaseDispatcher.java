package com.staffops.shared.usecases;

import com.staffops.shared.abstracts.usecases.HandlerResolver;
import com.staffops.shared.abstracts.usecases.UseCaseDispatcher;
import com.staffops.shared.abstracts.usecases.UseCaseHandler;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class DefaultUseCaseDispatcher implements UseCaseDispatcher {
    private final HandlerResolver handlerResolver;

    @Override
    @SuppressWarnings("unchecked")
    public <TRequest, TResponse> Uni<TResponse> send(TRequest request) {
        var handler = (UseCaseHandler<TRequest, TResponse>) handlerResolver.resolve(request.getClass());
        return handler.handle(request);
    }
}