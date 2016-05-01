/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danglar
 */
@Entity
@Table(schema = "public",name = "tb_pista")
@SequenceGenerator(schema = "public", name="pista_seq", sequenceName = "tb_pista_id_pista_seq", initialValue=1, allocationSize=1)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPista.findAll", query = "SELECT t FROM TbPista t"),
    @NamedQuery(name = "TbPista.findByIdPista", query = "SELECT t FROM TbPista t WHERE t.idPista = :idPista"),
    @NamedQuery(name = "TbPista.findByNomegp", query = "SELECT t FROM TbPista t WHERE t.nomegp = :nomegp")})
public class TbPista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pista_seq")
    @Basic(optional = false)
    @Column(name = "id_pista")
    private Integer idPista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomegp")
    private String nomegp;
    @OneToMany(mappedBy = "idPista")
    private Collection<TbCorrida> tbCorridaCollection;

    public TbPista() {
    }

    public TbPista(Integer idPista) {
        this.idPista = idPista;
    }

    public TbPista(Integer idPista, String nomegp) {
        this.idPista = idPista;
        this.nomegp = nomegp;
    }

    public Integer getIdPista() {
        return idPista;
    }

    public void setIdPista(Integer idPista) {
        this.idPista = idPista;
    }

    public String getNomegp() {
        return nomegp;
    }

    public void setNomegp(String nomegp) {
        this.nomegp = nomegp;
    }

    @XmlTransient
    public Collection<TbCorrida> getTbCorridaCollection() {
        return tbCorridaCollection;
    }

    public void setTbCorridaCollection(Collection<TbCorrida> tbCorridaCollection) {
        this.tbCorridaCollection = tbCorridaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPista != null ? idPista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPista)) {
            return false;
        }
        TbPista other = (TbPista) object;
        if ((this.idPista == null && other.idPista != null) || (this.idPista != null && !this.idPista.equals(other.idPista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomegp;
    }
    
}
