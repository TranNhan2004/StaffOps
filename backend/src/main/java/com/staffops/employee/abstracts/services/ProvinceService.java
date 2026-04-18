package com.staffops.employee.abstracts.services;

import com.staffops.employee.entities.Province;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

public interface ProvinceService {
    Uni<List<Province>> getAll();

    Uni<Province> getById(UUID id);

    Uni<Province> create(Province province);
}
