package com.sbm.insurance.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DaskDamageStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 30)
    private String damageStatus;

    @Min(1)
    @Max(999999)
    private float priceMultiplier;

    @OneToMany(
            mappedBy = "daskDamageStatus",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Dask> dasks;
}