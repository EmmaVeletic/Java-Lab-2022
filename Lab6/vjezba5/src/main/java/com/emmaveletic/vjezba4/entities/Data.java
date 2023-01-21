package com.emmaveletic.vjezba4.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "data")
public class Data {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

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
	
	/*public void setDate(String date) {
        try {
            this.date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/
}
