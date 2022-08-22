package com.sbm.insurance.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1000)
    @Max(2022)
    private int buildYear;

    @NotNull
    @Column(length = 30)
    private String buildingStyle = "Masonry";

    @Min(1)
    @Max(200)
    private int floorNumber;

    @Min(1)
    @Max(5)
    private int damageStatus;

    @Min(20)
    @Max(999999)
    private int area;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToOne(mappedBy = "dask", cascade = CascadeType.REMOVE)
    private Address address;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id", nullable = true) // id not null
    private Proposal proposal;
}