package com.food.crud.model;

import javax.persistence.*;

@Entity
@Table(name="Food")
public class Food {
    @Id
    @SequenceGenerator(name="Food_ID_GENERATOR", sequenceName = "SQ_FODD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_ID_GENERATOR")
    @Column(name = "id", unique = true, nullable = false, precision = 5)
    private long id;

    @Column(name="name", nullable = true, length = 250)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
