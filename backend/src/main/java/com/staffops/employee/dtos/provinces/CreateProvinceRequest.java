package com.staffops.employee.dtos.provinces;

import com.staffops.employee.models.provinces.CreateProvinceCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateProvinceRequest {
    private String name;

    public static CreateProvinceCommand toModel(CreateProvinceRequest request) {
        CreateProvinceCommand command = new CreateProvinceCommand();
        command.setName(request.getName());
        return command;
    }
}
