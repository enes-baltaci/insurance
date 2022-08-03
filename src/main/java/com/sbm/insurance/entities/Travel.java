package com.sbm.insurance.entities;

import javax.persistence.*;

@Entity
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String date;

    private int distance;

    private int days;

    private int price;

    public Travel(Long id, String type, String date, int distance, int days) {
        this.type = type;
        this.date = date;
        this.distance = distance;
        this.days = days;
    }

    public Travel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int howMuchDay) {
        this.days = howMuchDay;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}