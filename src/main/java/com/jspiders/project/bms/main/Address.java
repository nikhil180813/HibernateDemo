package com.jspiders.project.bms.main;

import jakarta.persistence.*;

@Entity
@Table(name="audi_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="street",nullable = false)
    private String street;

    @Column(name="area",nullable = false)
    private String area;

    @Column(name="city",nullable = false)
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
