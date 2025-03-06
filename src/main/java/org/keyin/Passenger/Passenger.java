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

    public Passenger(String name, City city) {
    }

    public Long getId() { return this.id; }

    public String getName() { return this.name; }

    public City getCity() { return this.city; }

    public void setCity(City city) { this.city = city; }

    public void setName(String name) { this.name = name; }
}
