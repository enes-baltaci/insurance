package com.sbm.insurance.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "carBrand",
                columnNames = "carBrand"
        )
)
public class CarBrands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car Brand can't be null or empty")
    private String carBrand;

    @OneToMany(
            mappedBy = "brand",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Car> car;
}