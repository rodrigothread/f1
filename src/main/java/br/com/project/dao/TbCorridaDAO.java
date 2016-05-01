/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.dao;


import br.com.project.model.TbCorrida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author danglar
 */
@Transactional
public class TbCorridaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(TbCorrida tbCorrida) throws Exception {
        this.em.persist(tbCorrida);
    }
    
    public void edit(TbCorrida tbCorrida) throws Exception {
        this.em.merge(tbCorrida);
    }
    
    public void delete(int idTbCorrida) throws Exception {
        int numRowUpdated = em.createQuery("DELETE FROM TbCorrida e WHERE e.idCorrida ="+idTbCorrida).executeUpdate();
    }
   
    public List<TbCorrida> listAll() {
            return this.em.createNamedQuery(
                   "TbCorrida.findAll", TbCorrida.class).getResultList();
    }    

    public TbCorrida getByID(int id) {
        return this.em.getReference(TbCorrida.class, id);
    }
    
}
