package org.keyin.City;

import org.keyin.Aircraft.Aircraft;
import org.keyin.Airport.Airport;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected int population;

    @OneToMany
    protected ArrayList<Airport> airports;

}
