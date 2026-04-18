package com.staffops.shared.abstracts.usecases;

import io.smallrye.mutiny.Uni;

public interface UseCaseHandler<TRequest, TResponse> {
    Uni<TResponse> handle(TRequest request);
}