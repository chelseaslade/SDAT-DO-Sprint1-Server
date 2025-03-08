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

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public List<Airport> getAirports() {
        return this.airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setCountry(String value) {
        this.country = value;
    }
}
