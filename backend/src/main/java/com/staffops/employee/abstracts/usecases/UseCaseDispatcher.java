package com.staffops.employee.abstracts.usecases;

import io.smallrye.mutiny.Uni;

public interface UseCaseDispatcher {
    <TRequest, TResponse> Uni<TResponse> send(TRequest request);
}