package org.keyin.Aircraft;

import org.keyin.Passenger.Passenger;
import javax.persistence.*;
import java.util.List;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;

    @ManyToMany
    protected List<Passenger> passengers;

    public Aircraft() {
    }

    public Long getId() { return this.id; }

    public String getName() { return this.name; }

    public List<Passenger> getPassengers() { return this.passengers; }

    public void setName(String name) { this.name = name; }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
