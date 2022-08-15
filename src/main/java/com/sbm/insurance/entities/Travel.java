package com.sbm.insurance.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
    private String type = "Flight";

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date travelDate;

    @Min(0)
    private int distance;

    @Size(min = 4)
    @Column(length = 9)
    private String distanceType = "Kilometer";

    @Min(1)
    private int days;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id", nullable = false)
    private Proposal proposal;
}