package com.staffops.employee.models.provinces;

import com.staffops.employee.entities.Province;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CreateProvinceResult {
    private UUID id;
    private String name;

    public static CreateProvinceResult fromEntity(Province province) {
        CreateProvinceResult result = new CreateProvinceResult();
        result.setId(province.getId());
        result.setName(province.getName());
        return result;
    }
}
