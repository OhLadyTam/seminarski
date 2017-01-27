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
@Table(name = "proces")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proces.findAll", query = "SELECT p FROM Proces p")
    , @NamedQuery(name = "Proces.findById", query = "SELECT p FROM Proces p WHERE p.id = :id")
    , @NamedQuery(name = "Proces.findByNivo", query = "SELECT p FROM Proces p WHERE p.nivo = :nivo")})
public class Proces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "Naziv")
    private String naziv;
    @Lob
    @Column(name = "Oznaka")
    private String oznaka;
    @Lob
    @Column(name = "Opis")
    private String opis;
    @Basic(optional = false)
    @Column(name = "Nivo")
    private String nivo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idProcesa", fetch = FetchType.EAGER)
    private Aktivnost aktivnost;
    @JoinColumn(name = "IdPodsistema", referencedColumnName = "Id")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Podsistem idPodsistema;
    @OneToOne(mappedBy = "idNadProcesa", fetch = FetchType.EAGER)
    private Proces proces;
    @JoinColumn(name = "IdNadProcesa", referencedColumnName = "Id")
    @OneToOne(fetch = FetchType.EAGER)
    private Proces idNadProcesa;

    public Proces() {
    }

    public Proces(Integer id) {
        this.id = id;
    }

    public Proces(Integer id, String naziv, String nivo) {
        this.id = id;
        this.naziv = naziv;
        this.nivo = nivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNivo() {
        return nivo;
    }

    public void setNivo(String nivo) {
        this.nivo = nivo;
    }

    public Aktivnost getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(Aktivnost aktivnost) {
        this.aktivnost = aktivnost;
    }

    public Podsistem getIdPodsistema() {
        return idPodsistema;
    }

    public void setIdPodsistema(Podsistem idPodsistema) {
        this.idPodsistema = idPodsistema;
    }

    public Proces getProces() {
        return proces;
    }

    public void setProces(Proces proces) {
        this.proces = proces;
    }

    public Proces getIdNadProcesa() {
        return idNadProcesa;
    }

    public void setIdNadProcesa(Proces idNadProcesa) {
        this.idNadProcesa = idNadProcesa;
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
        if (!(object instanceof Proces)) {
            return false;
        }
        Proces other = (Proces) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Proces[ id=" + id + " ]";
    }
    
}
