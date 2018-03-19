/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CustomerBean;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import jpa.Customer;

/**
 *
 * @author Samuel
 */
@Stateless
@WebService(serviceName = "CustomerWebService")
public class CustomerWebService {

    @EJB
    private CustomerBean customerBean;

    @WebMethod
    @WebResult(name = "customer")
    public List<Customer> findAll() {
        return this.customerBean.findAll();
    }

    @WebMethod
    @WebResult(name = "customer")
    public Customer findById(@WebParam(name = "id") long id) {
        return this.customerBean.findById(id);
    }

    @WebMethod
    @WebResult(name = "customer")
    public Customer saveNewCustomer(@WebParam(name = "customer") Customer customer) {
        return this.customerBean.saveNew(customer);
    }

    @WebMethod
    @WebResult(name = "customer")
    public Customer updateExistingCustomer(@WebParam(name = "customer") Customer customer) {
        return this.customerBean.update(customer);
    }

    @WebMethod
    public void deleteCustomer(@WebParam(name = "customer") Customer customer) {
        this.customerBean.delete(customer);
    }
}
