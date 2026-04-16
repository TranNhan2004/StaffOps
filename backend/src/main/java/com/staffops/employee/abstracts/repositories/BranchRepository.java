package com.staffops.employee.abstracts.repositories;

import com.staffops.employee.entities.Province;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import java.util.UUID;


public interface BranchRepository extends PanacheRepositoryBase<Province, UUID> {
}
