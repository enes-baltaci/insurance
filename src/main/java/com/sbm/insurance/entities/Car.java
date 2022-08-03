package com.sbm.insurance.entities;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "email",
                columnNames = "email"
        )
)
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    private int age;

    private String model;

    private int memberYear;

    private int price;

    public Car(String email, int age, String model, int memberYear) {
        this.email = email;
        this.age = age;
        this.model = model;
        this.memberYear = memberYear;
    }

    public Car() {

    }

    @Override
    public String toString() {
        return "Car [age=" + age + ", email=" + email + ", id=" + id + ", memberYear=" + memberYear + ", model=" + model
                + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemberYear() {
        return memberYear;
    }

    public void setMemberYear(int memberYear) {
        this.memberYear = memberYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}