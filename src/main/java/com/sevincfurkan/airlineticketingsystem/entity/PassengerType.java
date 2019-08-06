package com.sevincfurkan.airlineticketingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passenger_type")
public class PassengerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerType;
    @JoinColumn
    @OneToMany(fetch = FetchType.LAZY)
    private List<Passenger> passengerList;
    @JoinColumn
    @Enumerated(EnumType.STRING)
    private PassengerTypeEnum passengerTypeEnum;
}
