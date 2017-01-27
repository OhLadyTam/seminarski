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
@Table(name = "aktivnost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aktivnost.findAll", query = "SELECT a FROM Aktivnost a")
    , @NamedQuery(name = "Aktivnost.findById", query = "SELECT a FROM Aktivnost a WHERE a.id = :id")})
public class Aktivnost implements Serializable {

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
    @Column(name = "Opis")
    private String opis;
    @Lob
    @Column(name = "Oznaka")
    private String oznaka;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "aktivnost", fetch = FetchType.EAGER)
    private AktivnostDokument aktivnostDokument;
    @JoinColumn(name = "IdProcesa", referencedColumnName = "Id")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Proces idProcesa;

    public Aktivnost() {
    }

    public Aktivnost(Integer id) {
        this.id = id;
    }

    public Aktivnost(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
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

    public AktivnostDokument getAktivnostDokument() {
        return aktivnostDokument;
    }

    public void setAktivnostDokument(AktivnostDokument aktivnostDokument) {
        this.aktivnostDokument = aktivnostDokument;
    }

    public Proces getIdProcesa() {
        return idProcesa;
    }

    public void setIdProcesa(Proces idProcesa) {
        this.idProcesa = idProcesa;
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
        if (!(object instanceof Aktivnost)) {
            return false;
        }
        Aktivnost other = (Aktivnost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Aktivnost[ id=" + id + " ]";
    }
    
}
