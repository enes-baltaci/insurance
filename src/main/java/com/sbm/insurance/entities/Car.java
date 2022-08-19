package com.sbm.insurance.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "plateNumber",
                columnNames = "plateNumber"
        )
)
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1900, message = "Minimum model year is 1900.")
    @Max(value = 2023, message = "Maximum model year is 2023")
    private int modelYear;

    private String type = "SUV";

    @Size(min = 4, message = "Plate number length may be in between 4 to 15 characters")
    @Column(length = 15)
    private String plateNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id", nullable = false)
    private Proposal proposal;

    @ManyToOne
    @JoinColumn(name = "car_brand_id", referencedColumnName = "id", nullable = false)
    private CarBrands brand;
}