/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@Table(name = "aktivnost_dokument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AktivnostDokument.findAll", query = "SELECT a FROM AktivnostDokument a")
    , @NamedQuery(name = "AktivnostDokument.findByIdAktivnosti", query = "SELECT a FROM AktivnostDokument a WHERE a.aktivnostDokumentPK.idAktivnosti = :idAktivnosti")
    , @NamedQuery(name = "AktivnostDokument.findByIdTipaDokumenta", query = "SELECT a FROM AktivnostDokument a WHERE a.aktivnostDokumentPK.idTipaDokumenta = :idTipaDokumenta")
    , @NamedQuery(name = "AktivnostDokument.findByTipVeze", query = "SELECT a FROM AktivnostDokument a WHERE a.aktivnostDokumentPK.tipVeze = :tipVeze")
    , @NamedQuery(name = "AktivnostDokument.findByTipOperacije", query = "SELECT a FROM AktivnostDokument a WHERE a.tipOperacije = :tipOperacije")})
public class AktivnostDokument implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AktivnostDokumentPK aktivnostDokumentPK;
    @Basic(optional = false)
    @Column(name = "tipOperacije")
    private int tipOperacije;
    @JoinColumn(name = "IdAktivnosti", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Aktivnost aktivnost;
    @JoinColumn(name = "IdTipaDokumenta", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Tipdokumenta tipdokumenta;

    public AktivnostDokument() {
    }

    public AktivnostDokument(AktivnostDokumentPK aktivnostDokumentPK) {
        this.aktivnostDokumentPK = aktivnostDokumentPK;
    }

    public AktivnostDokument(AktivnostDokumentPK aktivnostDokumentPK, int tipOperacije) {
        this.aktivnostDokumentPK = aktivnostDokumentPK;
        this.tipOperacije = tipOperacije;
    }

    public AktivnostDokument(int idAktivnosti, int idTipaDokumenta, int tipVeze) {
        this.aktivnostDokumentPK = new AktivnostDokumentPK(idAktivnosti, idTipaDokumenta, tipVeze);
    }

    public AktivnostDokumentPK getAktivnostDokumentPK() {
        return aktivnostDokumentPK;
    }

    public void setAktivnostDokumentPK(AktivnostDokumentPK aktivnostDokumentPK) {
        this.aktivnostDokumentPK = aktivnostDokumentPK;
    }

    public int getTipOperacije() {
        return tipOperacije;
    }

    public void setTipOperacije(int tipOperacije) {
        this.tipOperacije = tipOperacije;
    }

    public Aktivnost getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(Aktivnost aktivnost) {
        this.aktivnost = aktivnost;
    }

    public Tipdokumenta getTipdokumenta() {
        return tipdokumenta;
    }

    public void setTipdokumenta(Tipdokumenta tipdokumenta) {
        this.tipdokumenta = tipdokumenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aktivnostDokumentPK != null ? aktivnostDokumentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AktivnostDokument)) {
            return false;
        }
        AktivnostDokument other = (AktivnostDokument) object;
        if ((this.aktivnostDokumentPK == null && other.aktivnostDokumentPK != null) || (this.aktivnostDokumentPK != null && !this.aktivnostDokumentPK.equals(other.aktivnostDokumentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.AktivnostDokument[ aktivnostDokumentPK=" + aktivnostDokumentPK + " ]";
    }
    
}
