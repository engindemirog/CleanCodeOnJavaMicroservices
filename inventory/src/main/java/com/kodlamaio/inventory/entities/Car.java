package com.kodlamaio.inventory.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "model_year")
    private int modelYear;
    @Column(name = "plate")
    private String plate;
    @Column(name = "state")
    private int state;
    @Column(name = "daily_price")
    private double dailyPrice;
    @ManyToOne()
    @JoinColumn(name = "model_id")
    private Model model;
}