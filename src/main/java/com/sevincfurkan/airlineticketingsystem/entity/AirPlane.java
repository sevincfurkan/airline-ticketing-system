package com.sevincfurkan.airlineticketingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "air_plane")
@AllArgsConstructor
@NoArgsConstructor
public class AirPlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airPlaneName;
    private String airPlaneModel;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private AirPort airPortName;
    private int capacity;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Ticket> ticketList;
}
