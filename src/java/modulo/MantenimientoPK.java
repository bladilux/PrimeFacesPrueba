/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Bladilu_xxx
 */
@Embeddable
public class MantenimientoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Cliente_cedula")
    private int clientecedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Veihculo_placa")
    private String veihculoplaca;

    public MantenimientoPK() {
    }

    public MantenimientoPK(int clientecedula, String veihculoplaca) {
        this.clientecedula = clientecedula;
        this.veihculoplaca = veihculoplaca;
    }

    public int getClientecedula() {
        return clientecedula;
    }

    public void setClientecedula(int clientecedula) {
        this.clientecedula = clientecedula;
    }

    public String getVeihculoplaca() {
        return veihculoplaca;
    }

    public void setVeihculoplaca(String veihculoplaca) {
        this.veihculoplaca = veihculoplaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clientecedula;
        hash += (veihculoplaca != null ? veihculoplaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MantenimientoPK)) {
            return false;
        }
        MantenimientoPK other = (MantenimientoPK) object;
        if (this.clientecedula != other.clientecedula) {
            return false;
        }
        if ((this.veihculoplaca == null && other.veihculoplaca != null) || (this.veihculoplaca != null && !this.veihculoplaca.equals(other.veihculoplaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulo.MantenimientoPK[ clientecedula=" + clientecedula + ", veihculoplaca=" + veihculoplaca + " ]";
    }
    
}
