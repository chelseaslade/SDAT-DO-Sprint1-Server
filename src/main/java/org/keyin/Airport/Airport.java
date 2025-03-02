package org.keyin.Airport;

import org.keyin.Aircraft.Aircraft;
import org.keyin.City.City;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;

    @ManyToMany
    protected ArrayList<Aircraft> aircraft;
    @ManyToOne
    protected City city;
}
