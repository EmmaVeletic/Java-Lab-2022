package com.emmaveletic.vjezba4.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "data")
public class Data {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private String time;

    @Column(name = "value")
    private Double value;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "device_id")
    private Device device;
    
	@Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "date = " + date + ", " +
                "time = " + time + ", " +
                "value = " + value + ")";
    }
}
