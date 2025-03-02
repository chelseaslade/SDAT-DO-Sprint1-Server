package org.keyin.Aircraft;

import org.keyin.Passenger.Passenger;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;

    @ManyToMany
    protected ArrayList<Passenger> passengers;
}
