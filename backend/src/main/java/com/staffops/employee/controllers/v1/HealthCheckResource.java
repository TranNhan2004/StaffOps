package com.staffops.employee.controllers.v1;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/health-check")
@ApplicationScoped
public class HealthCheckResource {

    @GET
    public Uni<Response> check() {
        return Uni
            .createFrom()
            .item(() -> Response.ok("Hello").build());
    }
}
