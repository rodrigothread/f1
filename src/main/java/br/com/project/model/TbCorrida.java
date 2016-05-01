/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.model;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danglar
 */
@Entity
@Table(schema = "public", name = "tb_corrida")
@SequenceGenerator(schema = "public", name="corrida_seq", sequenceName = "tb_corrida_id_corrida_seq", initialValue=1, allocationSize=1)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCorrida.findAll", query = "SELECT t FROM TbCorrida t"),
    @NamedQuery(name = "TbCorrida.findByIdCorrida", query = "SELECT t FROM TbCorrida t WHERE t.idCorrida = :idCorrida"),
    @NamedQuery(name = "TbCorrida.findByPosPrimeiro", query = "SELECT t FROM TbCorrida t WHERE t.posPrimeiro = :posPrimeiro"),
    @NamedQuery(name = "TbCorrida.findByPosSegundo", query = "SELECT t FROM TbCorrida t WHERE t.posSegundo = :posSegundo"),
    @NamedQuery(name = "TbCorrida.findByPosTerceiro", query = "SELECT t FROM TbCorrida t WHERE t.posTerceiro = :posTerceiro")})
public class TbCorrida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corrida_seq")
    @Basic(optional = false)
    @Column(name = "id_corrida")
    private Integer idCorrida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pos_primeiro")
    private String posPrimeiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pos_segundo")
    private String posSegundo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pos_terceiro")
    private String posTerceiro;
    @JoinColumn(name = "id_pista", referencedColumnName = "id_pista")
    @ManyToOne
    private TbPista idPista;
    @JoinColumn(name = "id_piloto", referencedColumnName = "id_piloto")
    @ManyToOne
    private TbPiloto idPiloto;

    public TbCorrida() {
    }

    public TbCorrida(Integer idCorrida) {
        this.idCorrida = idCorrida;
    }

    public TbCorrida(Integer idCorrida, String posPrimeiro, String posSegundo, String posTerceiro) {
        this.idCorrida = idCorrida;
        this.posPrimeiro = posPrimeiro;
        this.posSegundo = posSegundo;
        this.posTerceiro = posTerceiro;
    }

    public Integer getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(Integer idCorrida) {
        this.idCorrida = idCorrida;
    }

    public String getPosPrimeiro() {
        return posPrimeiro;
    }

    public void setPosPrimeiro(String posPrimeiro) {
        this.posPrimeiro = posPrimeiro;
    }

    public String getPosSegundo() {
        return posSegundo;
    }

    public void setPosSegundo(String posSegundo) {
        this.posSegundo = posSegundo;
    }

    public String getPosTerceiro() {
        return posTerceiro;
    }

    public void setPosTerceiro(String posTerceiro) {
        this.posTerceiro = posTerceiro;
    }

    public TbPista getIdPista() {
        return idPista;
    }

    public void setIdPista(TbPista idPista) {
        this.idPista = idPista;
    }

    public TbPiloto getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(TbPiloto idPiloto) {
        this.idPiloto = idPiloto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorrida != null ? idCorrida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCorrida)) {
            return false;
        }
        TbCorrida other = (TbCorrida) object;
        if ((this.idCorrida == null && other.idCorrida != null) || (this.idCorrida != null && !this.idCorrida.equals(other.idCorrida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idCorrida + "";
    }
    
}
