/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import jpa.Contract;
import jpa.Customer;

/**
 *
 * @author Samuel
 */
@Stateless
public class ContractBean extends EntityBean<Contract, Long> {

    public ContractBean() {
        super(Contract.class);
    }

    public List<Contract> findAllByCustomer(Customer customer) {
        
        return null;
    }

}
