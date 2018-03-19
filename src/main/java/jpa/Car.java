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
public class Car implements Serializable{
    @Id
    @GeneratedValue(generator = "car_ids")
    @TableGenerator(name = "car_ids", initialValue = 0, allocationSize = 1)
    private long id;
    
    //@NotNull(message = "Der Hersteller darf nicht leer sein.")
    @Column(length = 50)
    private String producer = "";
    
    //@NotNull(message = "Das Modell darf nicht leer sein.")
    @Column(length = 50)
    private String model = "";
    
    //@NotNull(message = "Das Baujahr darf nicht leer sein.")
    private Integer construtionYear = 0;
    
    
    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Car() {
    }
    
    public Car (String producer, String model, Integer construtionYear){
        this.producer = producer;
        this.model = model;
        this.construtionYear = construtionYear;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter und Setter">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getProducer() {
        return producer;
    }
    
    public void setProducer(String producer) {
        this.producer = producer;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public Integer getconstrutionYear() {
        return construtionYear;
    }
    
    public void setconstrutionYear(Integer construtionYear) {
        this.construtionYear = construtionYear;
    }
//</editor-fold> 
}
