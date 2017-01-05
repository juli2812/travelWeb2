/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author realm
 */
@Entity
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByOfertaId", query = "SELECT o FROM Oferta o WHERE o.ofertaId = :ofertaId"),
    @NamedQuery(name = "Oferta.findByTitolOferta", query = "SELECT o FROM Oferta o WHERE o.titolOferta = :titolOferta"),
    @NamedQuery(name = "Oferta.findByDescripcio", query = "SELECT o FROM Oferta o WHERE o.descripcio = :descripcio"),
    @NamedQuery(name = "Oferta.findByPlacesDisp", query = "SELECT o FROM Oferta o WHERE o.placesDisp = :placesDisp"),
    @NamedQuery(name = "Oferta.findByPreuPers", query = "SELECT o FROM Oferta o WHERE o.preuPers = :preuPers"),
    @NamedQuery(name = "Oferta.findByDesti", query = "SELECT o FROM Oferta o WHERE o.desti = :desti"),
    @NamedQuery(name = "Oferta.findByDataSortida", query = "SELECT o FROM Oferta o WHERE o.dataSortida = :dataSortida"),
    @NamedQuery(name = "Oferta.findByDataTornada", query = "SELECT o FROM Oferta o WHERE o.dataTornada = :dataTornada"),
    @NamedQuery(name = "Oferta.findByDiesEstada", query = "SELECT o FROM Oferta o WHERE o.diesEstada = :diesEstada"),
    @NamedQuery(name = "Oferta.findByDescripcioGran", query = "SELECT o FROM Oferta o WHERE o.descripcioGran = :descripcioGran")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OFERTA_ID")
    private Integer ofertaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITOL_OFERTA")
    private String titolOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCIO")
    private String descripcio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLACES_DISP")
    private int placesDisp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PREU_PERS")
    private double preuPers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESTI")
    private String desti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_SORTIDA")
    @Temporal(TemporalType.DATE)
    private Date dataSortida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_TORNADA")
    @Temporal(TemporalType.DATE)
    private Date dataTornada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIES_ESTADA")
    private int diesEstada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "DESCRIPCIO_GRAN")
    private String descripcioGran;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOferta")
    private Collection<Comanda> comandaCollection;

    public Oferta() {
    }

    public Oferta(Integer ofertaId) {
        this.ofertaId = ofertaId;
    }

    public Oferta(Integer ofertaId, String titolOferta, String descripcio, int placesDisp, double preuPers, String desti, Date dataSortida, Date dataTornada, int diesEstada, String descripcioGran) {
        this.ofertaId = ofertaId;
        this.titolOferta = titolOferta;
        this.descripcio = descripcio;
        this.placesDisp = placesDisp;
        this.preuPers = preuPers;
        this.desti = desti;
        this.dataSortida = dataSortida;
        this.dataTornada = dataTornada;
        this.diesEstada = diesEstada;
        this.descripcioGran = descripcioGran;
    }

    public Integer getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(Integer ofertaId) {
        this.ofertaId = ofertaId;
    }

    public String getTitolOferta() {
        return titolOferta;
    }

    public void setTitolOferta(String titolOferta) {
        this.titolOferta = titolOferta;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getPlacesDisp() {
        return placesDisp;
    }

    public void setPlacesDisp(int placesDisp) {
        this.placesDisp = placesDisp;
    }

    public double getPreuPers() {
        return preuPers;
    }

    public void setPreuPers(double preuPers) {
        this.preuPers = preuPers;
    }

    public String getDesti() {
        return desti;
    }

    public void setDesti(String desti) {
        this.desti = desti;
    }

    public Date getDataSortida() {
        return dataSortida;
    }

    public void setDataSortida(Date dataSortida) {
        this.dataSortida = dataSortida;
    }

    public Date getDataTornada() {
        return dataTornada;
    }

    public void setDataTornada(Date dataTornada) {
        this.dataTornada = dataTornada;
    }

    public int getDiesEstada() {
        return diesEstada;
    }

    public void setDiesEstada(int diesEstada) {
        this.diesEstada = diesEstada;
    }

    public String getDescripcioGran() {
        return descripcioGran;
    }

    public void setDescripcioGran(String descripcioGran) {
        this.descripcioGran = descripcioGran;
    }

    @XmlTransient
    public Collection<Comanda> getComandaCollection() {
        return comandaCollection;
    }

    public void setComandaCollection(Collection<Comanda> comandaCollection) {
        this.comandaCollection = comandaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ofertaId != null ? ofertaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.ofertaId == null && other.ofertaId != null) || (this.ofertaId != null && !this.ofertaId.equals(other.ofertaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Oferta[ ofertaId=" + ofertaId + " ]";
    }
    
}
