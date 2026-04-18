package com.staffops.employee.dtos.v1.provinces;

import com.staffops.employee.models.provinces.CreateProvinceResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CreateProvinceResponse {
    private UUID id;
    private String name;

    public static CreateProvinceResponse fromModel(CreateProvinceResult result) {
        CreateProvinceResponse response = new CreateProvinceResponse();
        response.setId(result.getId());
        response.setName(result.getName());
        return response;
    }
}
