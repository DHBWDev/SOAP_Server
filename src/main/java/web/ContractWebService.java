/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.*;
import jpa.*;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import jpa.Contract;

/**
 *
 * @author Samuel
 */
@Stateless
@WebService(serviceName = "ContractWebService")
public class ContractWebService {

    @EJB
    ContractBean contractBean;
    
    @EJB
    private CustomerBean customerBean;
    
    @EJB
    private CarBean carBean;

    @WebMethod
    @WebResult(name = "contract")
    public Contract saveNewContract(@WebParam(name = "StartDatum") Date startDate,  
            @WebParam(name = "EndeDatum") Date dueDate, 
            @WebParam(name = "CostumerId") Long costumerId,
            @WebParam(name = "CarId") Long carId) throws ContractBean.CarIsNotAvailableException { 
        
        Customer costumer = customerBean.findById(costumerId);
        Car car = carBean.findById(carId);
        
        Contract contract = new Contract(startDate, dueDate, costumer, car);
        return this.contractBean.saveNew(contract);
    }
}
