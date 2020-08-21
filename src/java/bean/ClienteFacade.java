/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modulo.Cliente;

/**
 *
 * @author Bladilu_xxx
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "pajinasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
}
