package com.sbm.insurance.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class TravelTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 10)
    private String travelType;

    @Min(2)
    @Max(999999)
    private int distanceMultiplier;

    @Min(35)
    @Max(999999)
    private int dayMultiplier;

    @OneToMany(
            mappedBy = "travelTypes",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Travel> travels;
}