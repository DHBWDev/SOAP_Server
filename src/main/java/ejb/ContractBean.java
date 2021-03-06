/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.Contract;
import jpa.Customer;
import javax.ejb.EJB;

/**
 *
 * @author Samuel
 */
@Stateless
public class ContractBean extends EntityBean<Contract, Long> {

    @PersistenceContext
    EntityManager em;

    @EJB
    CustomerBean customerBean;

    public ContractBean() {
        super(Contract.class);
    }

    public Contract saveNewContract(Contract contract) throws CarIsNotAvailableException {
        //Überprüfen ob es bereits einen Leihvertrag für das Auto und den Zeitraum gibt
        if (!em.createQuery("SELECT c FROM Contract c"
                + " WHERE c.car = :car"
                + " AND ((c.startDate <= :thisStartDate AND c.dueDate >= :thisStartDate)"
                + "        OR (c.startDate >= :thisStartDate AND c.startDate <= :thisDueDate))")
                .setParameter("thisStartDate", contract.getStartDate())
                .setParameter("thisDueDate", contract.getDueDate())
                .setParameter("car", contract.getCar())
                .getResultList().isEmpty()) {
            throw new CarIsNotAvailableException("Es gibt Überschneidungen mit einem bereits bestehenden Leihvetrag");
        }

        return saveNew(contract);
    }

    public class CarIsNotAvailableException extends Exception {

        public CarIsNotAvailableException(String message) {
            super(message);
        }
    }

    public List<Contract> findContractsByCustomerId(Long customerid) {

        Customer customer = this.customerBean.findById(customerid);

        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Contract> query = cb.createQuery(Contract.class);
        Root<Contract> from = query.from(Contract.class);
        query.select(from);
        if (customer != null) {
            query.where(cb.equal(from.get("customer"), customer));
        }
        return em.createQuery(query).getResultList();

    }
}
