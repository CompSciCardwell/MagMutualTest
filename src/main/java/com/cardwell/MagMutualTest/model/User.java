package com.cardwell.MagMutualTest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Entity
@Document(collection = "users")
public class User {

    @Id
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String profession;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateCreated;

    private String country;
    private String city;

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String profession, Date dateCreated, String country, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profession = profession;
        this.dateCreated = dateCreated;
        this.country = country;
        this.city = city;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User[" +
                "id = '" + id +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", email = " + email +
                ", profession = " + profession +
                ", dateCreated = " + dateCreated +
                ", country = " + country +
                ", city = " + city +
                ']';
    }
}