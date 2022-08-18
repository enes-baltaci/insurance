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

    private float price;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @Column(length = 40)
    private String proposalDate;

    @Column(length = 40)
    private String proposalAcceptedDate;

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.REMOVE)
    private Car car;

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.REMOVE)
    private Travel travel;
}