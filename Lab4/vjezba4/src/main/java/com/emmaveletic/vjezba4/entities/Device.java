package com.emmaveletic.vjezba4.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "device")
public class Device {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "device", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonManagedReference
    private List<Data> electricityData = new ArrayList<>();
    
    

    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public List<Data> getElectricityData() {
		return electricityData;
	}



	public void setElectricityData(List<Data> electricityData) {
		this.electricityData = electricityData;
	}



	@Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ")";
    }
}
