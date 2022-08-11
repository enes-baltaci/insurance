package com.sbm.insurance.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Choosing travel type is mandatory")
    private String type;

    @Size(min = 10, max = 10, message = "Date length should exactly be 10 character long.")
    @Column(name = "travel_date")
    private String date;

    @Min(0)
    private int distance;

    @Min(1)
    private int days;

    @NotNull
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id", nullable = false)
    private Proposal proposal;
}