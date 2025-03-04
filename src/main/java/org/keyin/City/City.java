package org.keyin.City;

import org.keyin.Airport.Airport;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected int population;

    @OneToMany
    protected ArrayList<Airport> airports;

}
