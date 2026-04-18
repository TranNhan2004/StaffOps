package com.staffops.employee.abstracts.repositories;

import com.staffops.employee.entities.Commune;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import java.util.UUID;

public interface CommuneRepository extends PanacheRepositoryBase<Commune, UUID> {
}
