package com.sevincfurkan.airlineticketingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "airport")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AirPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airPortName;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private City cityName;
    @JoinColumn
    @OneToMany(fetch = FetchType.LAZY)
    private List<AirPlane> airPlaneList;
    @JoinColumn
    @OneToMany(fetch = FetchType.LAZY)
    private List<Rota> rotaList;
}
