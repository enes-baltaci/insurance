package com.sbm.insurance.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private int price;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    private String proposalDate;

    @OneToOne(mappedBy = "proposal")
    private Car car;

    @OneToOne(mappedBy = "proposal")
    private Travel travel;
}