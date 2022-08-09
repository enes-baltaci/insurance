package com.sbm.insurance.entities;

import lombok.*;

import javax.persistence.*;
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

    private String name;
    private String surname;

    private int age;

    private String email;

    @OneToMany(mappedBy = "account")
    private List<Car> cars;

    @OneToMany(mappedBy = "account")
    private List<Travel> travels;
}