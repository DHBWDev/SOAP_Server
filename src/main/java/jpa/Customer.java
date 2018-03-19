/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

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
public class Customer {
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
}