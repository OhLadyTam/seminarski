/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tamtam
 */
@Entity
@Table(name = "podsistem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Podsistem.findAll", query = "SELECT p FROM Podsistem p")
    , @NamedQuery(name = "Podsistem.findById", query = "SELECT p FROM Podsistem p WHERE p.id = :id")})
public class Podsistem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Lob
    @Column(name = "Opis")
    private String opis;
    @Lob
    @Column(name = "Oznaka")
    private String oznaka;
    @Basic(optional = false)
    @Lob
    @Column(name = "Naziv")
    private String naziv;
    @OneToOne(mappedBy = "idNadSistema", fetch = FetchType.EAGER)
    private Podsistem podsistem;
    @JoinColumn(name = "IdNadSistema", referencedColumnName = "Id")
    @OneToOne(fetch = FetchType.EAGER)
    private Podsistem idNadSistema;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPodsistema", fetch = FetchType.EAGER)
    private Proces proces;

    public Podsistem() {
    }

    public Podsistem(Integer id) {
        this.id = id;
    }

    public Podsistem(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Podsistem getPodsistem() {
        return podsistem;
    }

    public void setPodsistem(Podsistem podsistem) {
        this.podsistem = podsistem;
    }

    public Podsistem getIdNadSistema() {
        return idNadSistema;
    }

    public void setIdNadSistema(Podsistem idNadSistema) {
        this.idNadSistema = idNadSistema;
    }

    public Proces getProces() {
        return proces;
    }

    public void setProces(Proces proces) {
        this.proces = proces;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Podsistem)) {
            return false;
        }
        Podsistem other = (Podsistem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Podsistem[ id=" + id + " ]";
    }
    
}
