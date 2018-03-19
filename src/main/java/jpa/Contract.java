/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fabio Kraemer
 */
@Entity
public class Contract {
    @Id
    @GeneratedValue(generator = "contract_ids")
    @TableGenerator(name = "contract_ids", initialValue = 0, allocationSize = 1)
    private long id;
    
    @NotNull(message = "Das Beginndatum darf nicht leer sein.")
    @Temporal(TemporalType.DATE)
    private Date startDate = new Date();
    
    @NotNull(message = "Das Enddatum darf nicht leer sein.")
    @Temporal(TemporalType.DATE)
    private Date dueDate = new Date();
    
    @ManyToOne
    Customer customer = new Customer();
    
    @ManyToOne 
    Car car = new Car();
   
}
