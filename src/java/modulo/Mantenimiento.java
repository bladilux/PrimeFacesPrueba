/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bladilu_xxx
 */
@Entity
@Table(name = "mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByClientecedula", query = "SELECT m FROM Mantenimiento m WHERE m.mantenimientoPK.clientecedula = :clientecedula")
    , @NamedQuery(name = "Mantenimiento.findByVeihculoplaca", query = "SELECT m FROM Mantenimiento m WHERE m.mantenimientoPK.veihculoplaca = :veihculoplaca")
    , @NamedQuery(name = "Mantenimiento.findByFecha", query = "SELECT m FROM Mantenimiento m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mantenimiento.findByDescripcion", query = "SELECT m FROM Mantenimiento m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Mantenimiento.findByKilometraje", query = "SELECT m FROM Mantenimiento m WHERE m.kilometraje = :kilometraje")})
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MantenimientoPK mantenimientoPK;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "kilometraje")
    private String kilometraje;
    @JoinColumn(name = "Cliente_cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "Veihculo_placa", referencedColumnName = "placa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Veihculo veihculo;

    public Mantenimiento() {
    }

    public Mantenimiento(MantenimientoPK mantenimientoPK) {
        this.mantenimientoPK = mantenimientoPK;
    }

    public Mantenimiento(int clientecedula, String veihculoplaca) {
        this.mantenimientoPK = new MantenimientoPK(clientecedula, veihculoplaca);
    }

    public MantenimientoPK getMantenimientoPK() {
        return mantenimientoPK;
    }

    public void setMantenimientoPK(MantenimientoPK mantenimientoPK) {
        this.mantenimientoPK = mantenimientoPK;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veihculo getVeihculo() {
        return veihculo;
    }

    public void setVeihculo(Veihculo veihculo) {
        this.veihculo = veihculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mantenimientoPK != null ? mantenimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.mantenimientoPK == null && other.mantenimientoPK != null) || (this.mantenimientoPK != null && !this.mantenimientoPK.equals(other.mantenimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulo.Mantenimiento[ mantenimientoPK=" + mantenimientoPK + " ]";
    }
    
}
