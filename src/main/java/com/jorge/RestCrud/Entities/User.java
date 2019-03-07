package com.jorge.RestCrud.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue
    @JsonProperty
    private int id;
    @NotNull
    @Size(min=2, message="Name should have atleast 2 characters")
    @JsonProperty
    private String name;
    @JsonProperty
    private Date birthDay;

    public User(){

    }

    public User(int id, @NotNull @Size(min = 2, message = "Name should have atleast 2 characters") String name, Date birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}