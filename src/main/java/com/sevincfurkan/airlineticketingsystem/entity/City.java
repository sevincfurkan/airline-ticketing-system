package com.sevincfurkan.airlineticketingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Country countryName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AirPort> airPortList;
}
