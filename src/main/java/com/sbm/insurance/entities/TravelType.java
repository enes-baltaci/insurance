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
public class TravelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Max(999999)
    private int price;

    @NotNull
    @Column(length = 10)
    private String travelType;

    @Min(2)
    @Max(999999)
    private int distanceMultiplier;

    @Min(1)
    @Max(999999)
    private int dayMultiplier;

    @OneToMany(
            mappedBy = "travelType",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Travel> travels;
}