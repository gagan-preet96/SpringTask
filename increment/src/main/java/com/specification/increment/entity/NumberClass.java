package com.specification.increment.entity;

import javax.persistence.*;

@Entity
@Table(name="number")
public class NumberClass {

    @Column(name="id")
    private int id;

    public NumberClass(){

    }
    public NumberClass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                '}';
    }
}
