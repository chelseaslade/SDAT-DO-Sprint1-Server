package org.keyin.Airport;

import org.keyin.Aircraft.Aircraft;
import org.keyin.City.City;
import javax.persistence.*;
import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String airportCode;

    @ManyToMany
    protected List<Aircraft> aircraft;
    @ManyToOne
    protected City city;

    public Airport() {}

    public Long getId() { return this.id; }

    public String getName() { return this.name; }

    public City getCity() { return this.city; }

    public String getAirportCode() { return this.airportCode; }

    public void setAirportCode(String airportCode) { this.airportCode = airportCode; }

    public void setCity(City city) { this.city = city; }

    public void setName(String airportName) { this.name = airportName; }
}
