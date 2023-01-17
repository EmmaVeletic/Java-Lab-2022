package com.example.pages.components.Entities;

public class Measurement {

    private Long id;

    private int year;

    private int month;

    private int day;

    private int value;

    private int gg;

    private int dg;

    private Device device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getGg() {
        return gg;
    }

    public void setGg(int gg) {
        this.gg = gg;
    }

    public int getDg() {
        return dg;
    }

    public void setDg(int dg) {
        this.dg = dg;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Measurement(int year, int month, int day, int gg, int dg) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.gg = gg;
        this.dg = dg;
    }

    public Measurement() {

    }
}
