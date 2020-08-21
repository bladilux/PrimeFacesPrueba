/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modulo.Mantenimiento;

/**
 *
 * @author Bladilu_xxx
 */
@Stateless
public class MantenimientoFacade extends AbstractFacade<Mantenimiento> {

    @PersistenceContext(unitName = "pajinasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MantenimientoFacade() {
        super(Mantenimiento.class);
    }
    
}
