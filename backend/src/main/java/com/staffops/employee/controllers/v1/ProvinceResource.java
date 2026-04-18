package com.staffops.employee.controllers.v1;

import com.staffops.employee.dtos.v1.provinces.CreateProvinceRequest;
import com.staffops.employee.dtos.v1.provinces.CreateProvinceResponse;
import com.staffops.employee.models.provinces.CreateProvinceCommand;
import com.staffops.employee.models.provinces.CreateProvinceResult;
import com.staffops.shared.abstracts.usecases.UseCaseDispatcher;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/api/v1/provinces")
@RequiredArgsConstructor
@ApplicationScoped
public class ProvinceResource {
    private final UseCaseDispatcher dispatcher;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> create(@Valid CreateProvinceRequest request) {
        CreateProvinceCommand command = CreateProvinceRequest.toModel(request);
        Uni<CreateProvinceResult> result = dispatcher.send(command);
        return result
            .map(CreateProvinceResponse::fromModel)
            .map(responseBody -> Response.status(Response.Status.CREATED)
                .entity(responseBody)
                .build());
    }
}
