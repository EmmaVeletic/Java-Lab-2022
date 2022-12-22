package com.emmaveletic.vjezba4.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

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
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "value")
    private Double value;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "device_id")
    private Device device;
    
    

    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public Double getValue() {
		return value;
	}



	public void setValue(Double value) {
		this.value = value;
	}



	public Device getDevice() {
		return device;
	}



	public void setDevice(Device device) {
		this.device = device;
	}



	@Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "date = " + date + ", " +
                "time = " + time + ", " +
                "value = " + value + ")";
    }
}
