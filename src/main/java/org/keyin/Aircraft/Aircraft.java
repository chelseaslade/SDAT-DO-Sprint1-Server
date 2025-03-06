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

    public Long getId() { return this.id; }

    public String getName() { return this.name; }
}
