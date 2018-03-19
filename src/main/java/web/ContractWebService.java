/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.ContractBean;
import java.util.List;
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
    private ContractBean contractBean;

    @WebMethod
    @WebResult(name = "contract")
    public List<Contract> findAll() {
        return this.contractBean.findAll();
    }

    @WebMethod
    @WebResult(name = "contract")
    public Contract findById(@WebParam(name = "id") long id) {
        return this.contractBean.findById(id);
    }

    @WebMethod
    @WebResult(name = "contract")
    public Contract saveNewContract(@WebParam(name = "contract") Contract contract) {
        return this.contractBean.saveNew(contract);
    }

    @WebMethod
    @WebResult(name = "contract")
    public Contract updateExistingContract(@WebParam(name = "contract") Contract contract) {
        return this.contractBean.update(contract);
    }

    @WebMethod
    public void deleteContract(@WebParam(name = "contract") Contract contract) {
        this.contractBean.delete(contract);
    }

}
