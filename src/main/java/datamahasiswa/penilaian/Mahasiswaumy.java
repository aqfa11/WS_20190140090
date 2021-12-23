/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa.penilaian;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MSI NOTEBOOK
 */
@Entity
@Table(name = "mahasiswaumy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mahasiswaumy.findAll", query = "SELECT m FROM Mahasiswaumy m"),
    @NamedQuery(name = "Mahasiswaumy.findByNim", query = "SELECT m FROM Mahasiswaumy m WHERE m.nim = :nim"),
    @NamedQuery(name = "Mahasiswaumy.findByNama", query = "SELECT m FROM Mahasiswaumy m WHERE m.nama = :nama"),
    @NamedQuery(name = "Mahasiswaumy.findByAlamat", query = "SELECT m FROM Mahasiswaumy m WHERE m.alamat = :alamat"),
    @NamedQuery(name = "Mahasiswaumy.findByProgamstudi", query = "SELECT m FROM Mahasiswaumy m WHERE m.progamstudi = :progamstudi"),
    @NamedQuery(name = "Mahasiswaumy.findByFakultas", query = "SELECT m FROM Mahasiswaumy m WHERE m.fakultas = :fakultas")})
public class Mahasiswaumy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nim")
    private String nim;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @Column(name = "progamstudi")
    private String progamstudi;
    @Basic(optional = false)
    @Column(name = "fakultas")
    private String fakultas;

    public Mahasiswaumy() {
    }

    public Mahasiswaumy(String nim) {
        this.nim = nim;
    }

    public Mahasiswaumy(String nim, String nama, String alamat, String progamstudi, String fakultas) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.progamstudi = progamstudi;
        this.fakultas = fakultas;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProgamstudi() {
        return progamstudi;
    }

    public void setProgamstudi(String progamstudi) {
        this.progamstudi = progamstudi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mahasiswaumy)) {
            return false;
        }
        Mahasiswaumy other = (Mahasiswaumy) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datamahasiswa.penilaian.Mahasiswaumy[ nim=" + nim + " ]";
    }
    
}
