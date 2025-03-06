package org.keyin.Passenger;

import org.keyin.Aircraft.Aircraft;
import org.keyin.City.City;

import javax.persistence.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;

    @ManyToOne
    protected City city;
}
