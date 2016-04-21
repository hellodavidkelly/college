/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author geraldine gray
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "JEEapp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    public List<entity.Customer> findByState(String state) {
                if (state.isEmpty()) {
            Query query = em.createNamedQuery("Customer.findAll");
            return query.getResultList();
        } else {
            Query query = em.createNamedQuery("Customer.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        }

    }
   
    
    
}
