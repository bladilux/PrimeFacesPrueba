/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import modulo.Mantenimiento;
import modulo.MantenimientoPK;

/**
 *
 * @author Bladilu_xxx
 */
@Stateless
@Path("modulo.mantenimiento")
public class MantenimientoFacadeREST extends AbstractFacade<Mantenimiento> {

    @PersistenceContext(unitName = "pajinasPU")
    private EntityManager em;

    private MantenimientoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;clientecedula=clientecedulaValue;veihculoplaca=veihculoplacaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        modulo.MantenimientoPK key = new modulo.MantenimientoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> clientecedula = map.get("clientecedula");
        if (clientecedula != null && !clientecedula.isEmpty()) {
            key.setClientecedula(new java.lang.Integer(clientecedula.get(0)));
        }
        java.util.List<String> veihculoplaca = map.get("veihculoplaca");
        if (veihculoplaca != null && !veihculoplaca.isEmpty()) {
            key.setVeihculoplaca(veihculoplaca.get(0));
        }
        return key;
    }

    public MantenimientoFacadeREST() {
        super(Mantenimiento.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Mantenimiento entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Mantenimiento entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        modulo.MantenimientoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Mantenimiento find(@PathParam("id") PathSegment id) {
        modulo.MantenimientoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mantenimiento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mantenimiento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
