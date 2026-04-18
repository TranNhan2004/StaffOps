package com.staffops.employee.abstracts.repositories;

import com.staffops.employee.entities.Department;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import java.util.UUID;

public interface DepartmentRepository extends PanacheRepositoryBase<Department, UUID> {
}
