/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author realm
 */
@Entity
@Table(name = "COMANDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comanda.findAll", query = "SELECT c FROM Comanda c"),
    @NamedQuery(name = "Comanda.findByIdComanda", query = "SELECT c FROM Comanda c WHERE c.idComanda = :idComanda"),
    @NamedQuery(name = "Comanda.findByPreuTotal", query = "SELECT c FROM Comanda c WHERE c.preuTotal = :preuTotal"),
    @NamedQuery(name = "Comanda.findByPersonas", query = "SELECT c FROM Comanda c WHERE c.personas = :personas"),
    @NamedQuery(name = "Comanda.findByData", query = "SELECT c FROM Comanda c WHERE c.data = :data"),
    @NamedQuery(name = "Comanda.findByHora", query = "SELECT c FROM Comanda c WHERE c.hora = :hora")})
public class Comanda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMANDA")
    private Integer idComanda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PREU_TOTAL")
    private double preuTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONAS")
    private int personas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "ID_OFERTA", referencedColumnName = "OFERTA_ID")
    @ManyToOne(optional = false)
    private Oferta idOferta;
    @JoinColumn(name = "ID_USUARI", referencedColumnName = "ALIAS")
    @ManyToOne
    private Usuari idUsuari;

    public Comanda() {
    }

    public Comanda(Integer idComanda) {
        this.idComanda = idComanda;
    }

    public Comanda(Integer idComanda, double preuTotal, int personas, Date data, Date hora) {
        this.idComanda = idComanda;
        this.preuTotal = preuTotal;
        this.personas = personas;
        this.data = data;
        this.hora = hora;
    }

    public Integer getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Integer idComanda) {
        this.idComanda = idComanda;
    }

    public double getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = preuTotal;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Oferta getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Oferta idOferta) {
        this.idOferta = idOferta;
    }

    public Usuari getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(Usuari idUsuari) {
        this.idUsuari = idUsuari;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComanda != null ? idComanda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.idComanda == null && other.idComanda != null) || (this.idComanda != null && !this.idComanda.equals(other.idComanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Comanda[ idComanda=" + idComanda + " ]";
    }
    
}
