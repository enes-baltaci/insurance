package com.sbm.insurance.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "email",
                columnNames = "email"
        )
)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name may not be empty")
    @Size(min = 3, message = "Minimum name length is 3")
    private String name;

    @NotEmpty(message = "Surname may not be empty.")
    @Size(min = 2, message = "Minimum surname length is 2")
    private String surname;

    @Min(value = 0, message = "Minimum age is 0.")
    private int age;

    @NotBlank
    @Email
    private String email;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Car> cars;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Travel> travels;
}