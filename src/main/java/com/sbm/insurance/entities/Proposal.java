package com.sbm.insurance.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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

    @DateTimeFormat(pattern = "dd-MM-yyyy 'at' HH:mm:ss")
    private Date proposalDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy 'at' HH:mm:ss")
    private Date proposalAcceptedDate;

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.REMOVE)
    private Car car;

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.REMOVE)
    private Travel travel;

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.REMOVE)
    private Dask dask;
}