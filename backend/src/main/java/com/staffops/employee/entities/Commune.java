package com.staffops.employee.entities;

import com.staffops.employee.abstracts.entities.BaseEntity;
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
@Table(name = "communes")
public class Commune extends BaseEntity {
    @Column(name = "name", length = 127, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "province_id", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Province province;
}
