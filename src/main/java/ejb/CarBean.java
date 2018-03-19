/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import jpa.Car;

/**
 *
 * @author Samuel
 */
@Stateless
public class CarBean extends EntityBean<Car, Long> {

    public CarBean() {
        super(Car.class);
    }

}
