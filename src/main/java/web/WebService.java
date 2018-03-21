/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CarBean;
import ejb.ContractBean;
import ejb.CustomerBean;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import jpa.Car;
import jpa.Contract;
import jpa.Customer;

/**
 *
 * @author Samuel
 */
@Stateless
@javax.jws.WebService(serviceName = "WebService")
public class WebService {

    @EJB
    private CarBean carBean;
    @EJB
    private ContractBean contractBean;
    @EJB
    private CustomerBean customerBean;

    //😎 Registrieren eines neuen Kundendatensatzes
    @WebMethod
    @WebResult(name = "customer")
    public Customer saveNewCustomer(@WebParam(name = "customer") Customer customer) {
        return this.customerBean.saveNew(customer);
    }

    //🚓 Anlegen eines neuen Fahrzeugs
    @WebMethod
    @WebResult(name = "car")
    public Car saveNewCar(@WebParam(name = "car") Car car) {
        return this.carBean.saveNew(car);
    }

    //📄 Ausleihen eines Fahrzeugs
    //Fehlt noch
    //🏎 Auflisten aller vorhandenen Fahrzeuge
    @WebMethod
    @WebResult(name = "car")
    public List<Car> findAllCars() {
        return this.carBean.findAll();
    }

    //🖨 Auflisten aller Leihverträge eines Kunden 
    @WebMethod
    @WebResult(name = "contract")
    public List<Contract> findContractsByCustomerId(@WebParam(name = "id") long id) {
        return this.contractBean.findContractsByCustomerId(id);
    }

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
    
    @WebMethod
    @WebResult(name = "contract")
    public Contract sNewContract(@WebParam(name = "contract") Contract contract) throws ContractBean.CarIsNotAvailableException {

        
        return this.contractBean.saveNew(contract);
    }
    
}
