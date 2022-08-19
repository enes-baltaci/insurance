package com.sbm.insurance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1000)
    @Max(2022)
    private int buildYear;

    @NotNull
    @Column(length = 30)
    private String buildingStyle;

    @Min(1)
    private int floorNumber;

    private String damageStatus;

    @Min(20)
    @Max(999999)
    private int area;
}