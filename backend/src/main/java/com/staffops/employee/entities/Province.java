package com.staffops.employee.entities;

import com.staffops.employee.abstracts.entities.BaseEntity;
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
@Table(name = "provinces")
public class Province extends BaseEntity {
    @Column(name = "name", length = 127, nullable = false, unique = true)
    private String name;
}
