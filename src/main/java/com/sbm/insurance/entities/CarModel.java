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
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 15)
    private String carType;

    @Min(0)
    @Max(1)
    private float carTypeMultiplier;

    @OneToMany(
            mappedBy = "model",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Car> car;
}