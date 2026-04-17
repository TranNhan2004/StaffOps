package com.staffops.employee.models.provinces;

import com.staffops.employee.entities.Province;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateProvinceCommand {
    private String name;

    public static Province toEntity(CreateProvinceCommand command) {
        Province province = new Province();
        province.setName(command.getName());
        return province;
    }
}
