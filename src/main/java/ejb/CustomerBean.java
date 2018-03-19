/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import jpa.Customer;

/**
 *
 * @author Samuel
 */
@Stateless
public class CustomerBean extends EntityBean<Customer, Long> {

    public CustomerBean() {
        super(Customer.class);
    }
}
