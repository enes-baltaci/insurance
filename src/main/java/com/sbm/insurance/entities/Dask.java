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

    @Min(1)
    @Max(200)
    private int floorNumber;

    @Min(20)
    @Max(999999)
    private int area;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToOne(mappedBy = "dask", cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id")
    private Proposal proposal;

    @ManyToOne
    @JoinColumn(name = "daskdamage_id", referencedColumnName = "id", nullable = false)
    private DaskDamageStatus daskDamageStatus;

    @ManyToOne
    @JoinColumn(name = "buildingstyle_id", referencedColumnName = "id", nullable = false)
    private DaskBuildingStyle daskBuildingStyle;
}