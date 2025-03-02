package org.keyin.City;

import javax.persistence.*;
@Entity

public class City {
    @Id
    protected int id;
    protected int population;
}
