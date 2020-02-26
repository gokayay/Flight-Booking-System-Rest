package com.airlines.automationsystem.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tickets")
public class Ticket {
    public Ticket(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @Column
    private String person_name;

    @Column
    private String gender;

    @Column
    private Date date;

    @Column
    private Double price;

    @Column
    private Boolean validity;
}
