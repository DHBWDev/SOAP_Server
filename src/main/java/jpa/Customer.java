/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fabio Kraemer
 */
@Entity
public class Customer implements Serializable{
    @Id
    @GeneratedValue(generator = "customer_ids")
    @TableGenerator(name = "customer_ids", initialValue = 0, allocationSize = 1)
    private long id;
    
    @NotNull(message = "Der Vorname darf nicht leer sein.")
    @Column(length = 50)
    private String firstName = "";
    
    @NotNull(message = "Der Nachname darf nicht leer sein.")
    @Column(length = 50)
    private String name = "";
    
    @NotNull(message = "Die STraße darf nicht leer sein.")
    private String street = "";
    
    @NotNull(message = "Die Hausnummer darf nicht leer sein.")
    @Column(length = 10)
    private String houseNumber = "";
    
    @NotNull(message = "Die Postleitzahl darf nicht leer sein.")
    @Column(length = 25)
    private String postCode = "";
    
    @NotNull(message = "Der Ort darf nicht leer sein.")
    @Column(length = 50)
    private String place = "";
    
    @NotNull(message = "Das Land darf nicht leer sein.")
    @Column(length = 50)
    private String country = "";
    
    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Customer () {
    }
    
    public Customer (String firstName, String name, String street, String houseNumber, String postCode, String place, String country) {
        this.firstName = firstName;
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.place = place;
        this.country = country;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter und Setter">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getHouseNumber() {
        return houseNumber;
    }
    
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    
    public String getPostCode() {
        return postCode;
    }
    
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    public String getPlace() {
        return place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
//</editor-fold>
}