package com.example.labo1.Model;

import jakarta.persistence.*;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Person person;

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToOne
    private Series series;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
