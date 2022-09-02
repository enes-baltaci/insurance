package com.sbm.insurance.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 30)
    private String cityName;

    @Min(1)
    @Max(999999)
    private float priceMultiplier;

    @OneToMany(
            mappedBy = "city",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Address> addresses;

    @OneToMany(
            mappedBy = "city",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Account> accounts;
}