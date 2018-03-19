/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CarBean;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import jpa.Car;

/**
 *
 * @author Samuel
 */
@Stateless
@WebService(serviceName = "CarWebService")
public class CarWebService {

    @EJB
    private CarBean carBean;

    @WebMethod
    @WebResult(name = "car")
    public List<Car> findAll() {
        return this.carBean.findAll();
    }

    @WebMethod
    @WebResult(name = "car")
    public Car findById(@WebParam(name = "id") long id) {
        return this.carBean.findById(id);
    }

    @WebMethod
    @WebResult(name = "car")
    public Car saveNewMovie(@WebParam(name = "car") Car car) {
        return this.carBean.saveNew(car);
    }

    @WebMethod
    @WebResult(name = "car")
    public Car updateExistingMovie(@WebParam(name = "car") Car car) {
        return this.carBean.update(car);
    }

    @WebMethod
    public void deleteMovie(@WebParam(name = "car") Car car) {
        this.carBean.delete(car);
    }

}
