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
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1900, message = "Minimum model year is 1900.")
    @Max(value = 2023, message = "Maximum model year is 2023")
    private int modelYear;

    private String model;

    @Size(min = 8, max = 8, message = "Plate number should be exactly 8 character long.")
    private String plateNumber;

    @NotBlank(message = "Brand may not be blank nor empty")
    private String brand;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id", nullable = false)
    private Proposal proposal;
}