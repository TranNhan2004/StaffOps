package com.staffops.employee.usecases.provinces.commands;

import com.staffops.employee.abstracts.services.ProvinceService;
import com.staffops.employee.entities.Province;
import com.staffops.employee.models.provinces.CreateProvinceCommand;
import com.staffops.employee.models.provinces.CreateProvinceResult;
import com.staffops.shared.abstracts.usecases.UseCaseHandler;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class CreateProvinceHandler implements UseCaseHandler<CreateProvinceCommand, CreateProvinceResult> {

    private final ProvinceService provinceService;

    @Override
    public Uni<CreateProvinceResult> handle(CreateProvinceCommand createProvinceCommand) {
        Province province = CreateProvinceCommand.toEntity(createProvinceCommand);
        Uni<Province> createdProvinceUni = provinceService.create(province);
        return createdProvinceUni.map(CreateProvinceResult::fromEntity);
    }
}
