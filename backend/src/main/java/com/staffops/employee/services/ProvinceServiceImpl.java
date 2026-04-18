package com.staffops.employee.services;

import com.staffops.employee.abstracts.repositories.ProvinceRepository;
import com.staffops.employee.abstracts.services.ProvinceService;
import com.staffops.employee.entities.Province;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@ApplicationScoped
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepository;

    @Override
    public Uni<List<Province>> getAll() {
        return provinceRepository.listAll();
    }

    @Override
    public Uni<Province> getById(UUID id) {
        return provinceRepository.findById(id);
    }

    @Override
    @WithTransaction
    public Uni<Province> create(Province province) {
        return provinceRepository.persist(province);
    }
}
