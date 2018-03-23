/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fabio Kraemer
 */
@Entity
public class Contract implements Serializable {

    @Id
    @GeneratedValue(generator = "contract_ids")
    @TableGenerator(name = "contract_ids", initialValue = 0, allocationSize = 1)
    private long id;

    //@NotNull(message = "Das Beginndatum darf nicht leer sein.")
    @Temporal(TemporalType.DATE)
    private Date startDate = new Date();

    //@NotNull(message = "Das Enddatum darf nicht leer sein.")
    @Temporal(TemporalType.DATE)
    private Date dueDate = new Date();

    @ManyToOne
    //Customer customer = new Customer();
    private Customer customer;

    @ManyToOne
    Car car = new Car();

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Contract() {
    }

    public Contract(Date startDate, Date dueDate, Customer customer, Car car) {
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.customer = customer;
        this.car = car;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter und Setter">
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
//</editor-fold>

}
