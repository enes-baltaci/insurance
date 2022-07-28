package com.sbm.insurance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, unique = false)
    private int age;

    @Column(nullable = false, unique = false)
    private String model;

    @Column(nullable = false, unique = false)
    private int memberYear;

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
}