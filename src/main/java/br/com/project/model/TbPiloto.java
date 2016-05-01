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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(schema = "public", name = "tb_piloto")
@SequenceGenerator(schema = "public", name="piloto_seq", sequenceName = "tb_piloto_id_piloto_seq", initialValue=1, allocationSize=1)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPiloto.findAll", query = "SELECT t FROM TbPiloto t"),
    @NamedQuery(name = "TbPiloto.findByIdPiloto", query = "SELECT t FROM TbPiloto t WHERE t.idPiloto = :idPiloto"),
    @NamedQuery(name = "TbPiloto.findByNomePiloto", query = "SELECT t FROM TbPiloto t WHERE t.nomePiloto = :nomePiloto"),
    @NamedQuery(name = "TbPiloto.findByPontos", query = "SELECT t FROM TbPiloto t WHERE t.pontos = :pontos"),
    @NamedQuery(name = "TbPiloto.findByVitorias", query = "SELECT t FROM TbPiloto t WHERE t.vitorias = :vitorias")})
public class TbPiloto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "piloto_seq")
    @Basic(optional = false)
    @Column(name = "id_piloto")
    private Integer idPiloto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_piloto")
    private String nomePiloto;
    @Column(name = "pontos")
    private Integer pontos;
    @Column(name = "vitorias")
    private Integer vitorias;
    @JoinColumn(name = "id_equipe", referencedColumnName = "id_equipe")
    @ManyToOne
    private TbConstrutores idEquipe;
    @OneToMany(mappedBy = "idPiloto")
    private Collection<TbCorrida> tbCorridaCollection;

    public TbPiloto() {
    }

    public TbPiloto(Integer idPiloto) {
        this.idPiloto = idPiloto;
    }

    public TbPiloto(Integer idPiloto, String nomePiloto) {
        this.idPiloto = idPiloto;
        this.nomePiloto = nomePiloto;
    }

    public Integer getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Integer idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public TbConstrutores getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(TbConstrutores idEquipe) {
        this.idEquipe = idEquipe;
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
        hash += (idPiloto != null ? idPiloto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPiloto)) {
            return false;
        }
        TbPiloto other = (TbPiloto) object;
        if ((this.idPiloto == null && other.idPiloto != null) || (this.idPiloto != null && !this.idPiloto.equals(other.idPiloto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomePiloto ;
    }
    
}
