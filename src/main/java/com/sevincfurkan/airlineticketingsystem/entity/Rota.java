package com.sevincfurkan.airlineticketingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date takeOff;
    @Temporal(TemporalType.DATE)
    private Date arrival;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private AirPort airPortName;
    @JoinColumn
    @OneToMany(fetch = FetchType.LAZY)
    private List<Fly> flyList;
    private String position;
    private String destination;

}
