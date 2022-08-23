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
public class DaskBuildingStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 45)
    private String buildingStyle;

    @Min(1)
    @Max(999999)
    private float priceMultiplier;

    @OneToMany(
            mappedBy = "daskBuildingStyle",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Dask> dasks;
}