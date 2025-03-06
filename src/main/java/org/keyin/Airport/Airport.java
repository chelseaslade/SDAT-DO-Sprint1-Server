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
}
