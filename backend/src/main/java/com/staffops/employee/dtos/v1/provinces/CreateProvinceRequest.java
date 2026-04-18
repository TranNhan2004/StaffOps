package com.staffops.employee.dtos.v1.provinces;

import com.staffops.employee.models.provinces.CreateProvinceCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateProvinceRequest {
    @NotBlank(message = "Province name cannot be null or empty.")
    @Size(max = 127, message = "Province name cannot exceed 127 characters.")
    private String name;

    public static CreateProvinceCommand toModel(CreateProvinceRequest request) {
        CreateProvinceCommand command = new CreateProvinceCommand();
        command.setName(request.getName());
        return command;
    }
}
