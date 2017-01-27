/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tamtam
 */
@Entity
@Table(name = "dokument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dokument.findAll", query = "SELECT d FROM Dokument d")
    , @NamedQuery(name = "Dokument.findById", query = "SELECT d FROM Dokument d WHERE d.id = :id")
    , @NamedQuery(name = "Dokument.findByDatumKreiranja", query = "SELECT d FROM Dokument d WHERE d.datumKreiranja = :datumKreiranja")
    , @NamedQuery(name = "Dokument.findByLokacijaOriginala", query = "SELECT d FROM Dokument d WHERE d.lokacijaOriginala = :lokacijaOriginala")
    , @NamedQuery(name = "Dokument.findByPoslato", query = "SELECT d FROM Dokument d WHERE d.poslato = :poslato")})
public class Dokument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "DatumKreiranja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumKreiranja;
    @Lob
    @Column(name = "Napomena")
    private String napomena;
    @Column(name = "LokacijaOriginala")
    private String lokacijaOriginala;
    @Column(name = "poslato")
    private Boolean poslato;
    @JoinColumn(name = "IdTipDokumenta", referencedColumnName = "Id")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Tipdokumenta idTipDokumenta;

    public Dokument() {
    }

    public Dokument(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getLokacijaOriginala() {
        return lokacijaOriginala;
    }

    public void setLokacijaOriginala(String lokacijaOriginala) {
        this.lokacijaOriginala = lokacijaOriginala;
    }

    public Boolean getPoslato() {
        return poslato;
    }

    public void setPoslato(Boolean poslato) {
        this.poslato = poslato;
    }

    public Tipdokumenta getIdTipDokumenta() {
        return idTipDokumenta;
    }

    public void setIdTipDokumenta(Tipdokumenta idTipDokumenta) {
        this.idTipDokumenta = idTipDokumenta;
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
        if (!(object instanceof Dokument)) {
            return false;
        }
        Dokument other = (Dokument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Dokument[ id=" + id + " ]";
    }
    
}
