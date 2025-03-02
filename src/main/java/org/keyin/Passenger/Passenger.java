package org.keyin.Passenger;

import org.keyin.Aircraft.Aircraft;
import org.keyin.Airport.Airport;
import org.keyin.City.City;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;

    @ManyToMany
    protected ArrayList<Aircraft> aircrafts;

    @ManyToOne
    protected City city;
}
