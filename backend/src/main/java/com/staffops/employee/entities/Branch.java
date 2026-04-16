package com.staffops.employee.entities;

import com.staffops.employee.abstracts.entities.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "branches")
public class Branch extends AuditableEntity {
    @Column(name = "name", length = 1024, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "commune_id", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Commune commune;

    @Column(name = "additional_address", length = 1024, nullable = false)
    private String additionalAddress;
}
