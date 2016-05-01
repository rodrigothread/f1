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
@Table(schema = "public", name = "tb_construtores")
@SequenceGenerator(schema = "public", name="construtores_seq", sequenceName = "tb_construtores_id_construtores_seq", initialValue=1, allocationSize=1)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbConstrutores.findAll", query = "SELECT t FROM TbConstrutores t"),
    @NamedQuery(name = "TbConstrutores.findByIdEquipe", query = "SELECT t FROM TbConstrutores t WHERE t.idEquipe = :idEquipe"),
    @NamedQuery(name = "TbConstrutores.findByNomeEquipe", query = "SELECT t FROM TbConstrutores t WHERE t.nomeEquipe = :nomeEquipe")})
public class TbConstrutores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id_equipe")
    private Integer idEquipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome_equipe")
    private String nomeEquipe;
    @OneToMany(mappedBy = "idEquipe")
    private Collection<TbPiloto> tbPilotoCollection;

    public TbConstrutores() {
    }

    public TbConstrutores(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public TbConstrutores(Integer idEquipe, String nomeEquipe) {
        this.idEquipe = idEquipe;
        this.nomeEquipe = nomeEquipe;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    @XmlTransient
    public Collection<TbPiloto> getTbPilotoCollection() {
        return tbPilotoCollection;
    }

    public void setTbPilotoCollection(Collection<TbPiloto> tbPilotoCollection) {
        this.tbPilotoCollection = tbPilotoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipe != null ? idEquipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbConstrutores)) {
            return false;
        }
        TbConstrutores other = (TbConstrutores) object;
        if ((this.idEquipe == null && other.idEquipe != null) || (this.idEquipe != null && !this.idEquipe.equals(other.idEquipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeEquipe;
    }
    
}
