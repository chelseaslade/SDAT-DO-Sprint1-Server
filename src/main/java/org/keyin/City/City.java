package org.keyin.City;

import org.keyin.Airport.Airport;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String country;

    @OneToMany
    protected List<Airport> airports;

    public City(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public City() {

    }

    public String getName() {
        return this.name;
    }
}
