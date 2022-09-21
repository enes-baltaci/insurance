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
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "email",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "identity",
                        columnNames = "identity"
                )
        }

)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(10000000000L)
    @Max(99999999999L)
    private Long identity;

    @NotEmpty(message = "Name may not be empty")
    @Size(min = 1, message = "Name length may be in between 1 to 30 character")
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "Surname may not be empty.")
    @Size(min = 1, message = "Surname length may be in between 1 to 30 character")
    @Column(length = 30)
    private String surname;

    @Min(value = 0, message = "Minimum age is 0.")
    @Max(value = 250, message = "Maximum age is 125")
    private int age;

    @NotBlank(message = "Email may not be empty")
    @Email
    @Column(length = 70)
    private String email;

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Car> cars;

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Travel> travels;

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Dask> dasks;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;
}