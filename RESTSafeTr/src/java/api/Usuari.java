/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "USUARI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuari.findAll", query = "SELECT u FROM Usuari u"),
    @NamedQuery(name = "Usuari.findByAlias", query = "SELECT u FROM Usuari u WHERE u.alias = :alias"),
    @NamedQuery(name = "Usuari.findByContrasenya", query = "SELECT u FROM Usuari u WHERE u.contrasenya = :contrasenya"),
    @NamedQuery(name = "Usuari.findByNom", query = "SELECT u FROM Usuari u WHERE u.nom = :nom"),
    @NamedQuery(name = "Usuari.findByCognom1", query = "SELECT u FROM Usuari u WHERE u.cognom1 = :cognom1"),
    @NamedQuery(name = "Usuari.findByCognom2", query = "SELECT u FROM Usuari u WHERE u.cognom2 = :cognom2"),
    @NamedQuery(name = "Usuari.findByAdre\u00e7a", query = "SELECT u FROM Usuari u WHERE u.adre\u00e7a = :adre\u00e7a"),
    @NamedQuery(name = "Usuari.findByTelefon", query = "SELECT u FROM Usuari u WHERE u.telefon = :telefon"),
    @NamedQuery(name = "Usuari.findByEmail", query = "SELECT u FROM Usuari u WHERE u.email = :email"),
    @NamedQuery(name = "Usuari.findByDataNaix", query = "SELECT u FROM Usuari u WHERE u.dataNaix = :dataNaix"),
    @NamedQuery(name = "Usuari.findBySexe", query = "SELECT u FROM Usuari u WHERE u.sexe = :sexe")})
public class Usuari implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ALIAS")
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONTRASENYA")
    private String contrasenya;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COGNOM1")
    private String cognom1;
    @Size(max = 50)
    @Column(name = "COGNOM2")
    private String cognom2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADRE\u00c7A")
    private String adreça;
    @Size(max = 9)
    @Column(name = "TELEFON")
    private String telefon;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_NAIX")
    @Temporal(TemporalType.DATE)
    private Date dataNaix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SEXE")
    private String sexe;
    @OneToMany(mappedBy = "idUsuari")
    private Collection<Comanda> comandaCollection;

    public Usuari() {
    }

    public Usuari(String alias) {
        this.alias = alias;
    }

    public Usuari(String alias, String contrasenya, String nom, String cognom1, String adreça, String email, Date dataNaix, String sexe) {
        this.alias = alias;
        this.contrasenya = contrasenya;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.adreça = adreça;
        this.email = email;
        this.dataNaix = dataNaix;
        this.sexe = sexe;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNaix() {
        return dataNaix;
    }

    public void setDataNaix(Date dataNaix) {
        this.dataNaix = dataNaix;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
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
        hash += (alias != null ? alias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuari)) {
            return false;
        }
        Usuari other = (Usuari) object;
        if ((this.alias == null && other.alias != null) || (this.alias != null && !this.alias.equals(other.alias))) {
            return false;
        }
        return true;
    }

    public void convertToUser(String data){
         Gson gs =new Gson();
         Usuari usuari=gs.fromJson(data, Usuari.class);
         this.nom=usuari.getNom();
         this.cognom1=usuari.getCognom1();
         this.cognom2=usuari.getCognom2();
         this.contrasenya=usuari.getContrasenya();
         this.telefon=usuari.getTelefon();
         this.email=usuari.getEmail();
         this.dataNaix=usuari.getDataNaix();
         this.adreça=usuari.getAdreça();
         this.sexe=usuari.getSexe();
         this.alias=usuari.getAlias();
    }
    @Override
    public String toString() {
        return "api.Usuari[ alias=" + alias + " ]";
    }
    
}
