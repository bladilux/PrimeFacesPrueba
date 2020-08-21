/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bladilu_xxx
 */
@Entity
@Table(name = "veihculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veihculo.findAll", query = "SELECT v FROM Veihculo v")
    , @NamedQuery(name = "Veihculo.findByPlaca", query = "SELECT v FROM Veihculo v WHERE v.placa = :placa")
    , @NamedQuery(name = "Veihculo.findByA\u00f1o", query = "SELECT v FROM Veihculo v WHERE v.a\u00f1o = :a\u00f1o")
    , @NamedQuery(name = "Veihculo.findByModeo", query = "SELECT v FROM Veihculo v WHERE v.modeo = :modeo")
    , @NamedQuery(name = "Veihculo.findByMarca", query = "SELECT v FROM Veihculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Veihculo.findByCiloindraje", query = "SELECT v FROM Veihculo v WHERE v.ciloindraje = :ciloindraje")
    , @NamedQuery(name = "Veihculo.findByPaisDeFabricaion", query = "SELECT v FROM Veihculo v WHERE v.paisDeFabricaion = :paisDeFabricaion")})
public class Veihculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "placa")
    private String placa;
    @Column(name = "a\u00f1o")
    private Integer año;
    @Size(max = 45)
    @Column(name = "modeo")
    private String modeo;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "ciloindraje")
    private String ciloindraje;
    @Size(max = 45)
    @Column(name = "pais_de_fabricaion")
    private String paisDeFabricaion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veihculo")
    private List<Mantenimiento> mantenimientoList;

    public Veihculo() {
    }

    public Veihculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getModeo() {
        return modeo;
    }

    public void setModeo(String modeo) {
        this.modeo = modeo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCiloindraje() {
        return ciloindraje;
    }

    public void setCiloindraje(String ciloindraje) {
        this.ciloindraje = ciloindraje;
    }

    public String getPaisDeFabricaion() {
        return paisDeFabricaion;
    }

    public void setPaisDeFabricaion(String paisDeFabricaion) {
        this.paisDeFabricaion = paisDeFabricaion;
    }

    @XmlTransient
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veihculo)) {
            return false;
        }
        Veihculo other = (Veihculo) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulo.Veihculo[ placa=" + placa + " ]";
    }
    
}
