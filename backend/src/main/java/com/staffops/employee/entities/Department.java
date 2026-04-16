package com.staffops.employee.entities;

import com.staffops.employee.abstracts.entities.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department extends AuditableEntity {
    @Column(name = "code", length = 64, nullable = false, unique = true)
    private String code;

    @Column(name = "name", length = 1024, nullable = false)
    private String name;

    @Column(name = "description", length = 4096, nullable = false)
    private String description;
}
