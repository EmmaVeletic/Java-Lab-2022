package com.example.pages.components.Entities;


import java.util.List;

public class Device {

    private Long id;

    private String model;

    private List<Measurement> measurements;

    private Client client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Device(Long id) {
        this.id = id;
    }

    public Device(){

    }
}
