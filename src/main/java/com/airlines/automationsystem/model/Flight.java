package com.airlines.automationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "flights")
public class Flight {

    public Flight(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column
    private Date date;

    @Column
    private Integer quota;

    @Column
    private Integer sold;

    @Column
    private Double first_price;

    @JsonIgnore
    @OneToMany(mappedBy = "flight")
    private Set<Ticket> tickets;
}
