package com.jspiders.project.bms.main;

import jakarta.persistence.*;

@Entity
@Table(name = "auditorium")
public class Audi {

    @Id
    private long id;
    @Column(name = "audi_name",nullable = false)
    private String name;
    @Column(name = "seat_rows",nullable = false)
    private Integer seatRows;
    @Column(name = "seat_columns",nullable = false)
    private Integer seatColumns;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addrs_id")
    private Address address;

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

    public Integer getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(Integer seatRows) {
        this.seatRows = seatRows;
    }

    public Integer getSeatColumns() {
        return seatColumns;
    }

    public void setSeatColumns(Integer seatColumns) {
        this.seatColumns = seatColumns;
    }

}
