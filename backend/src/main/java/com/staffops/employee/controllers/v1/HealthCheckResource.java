package com.staffops.employee.controllers.v1;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/api/v1/health-check")
@RequiredArgsConstructor
@ApplicationScoped
public class HealthCheckResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Response> check() {
        return Uni
            .createFrom()
            .item(() -> Response.ok("Hello").build());
    }
}
