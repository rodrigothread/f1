/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.dao;


import br.com.project.model.TbPista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author danglar
 */
@Transactional
public class TbPistaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(TbPista tbPista) throws Exception {
        this.em.persist(tbPista);
    }
    
    public void edit(TbPista tbPista) throws Exception {
        this.em.merge(tbPista);
    }
    
    public void delete(int idTbPista) throws Exception {
        int numRowUpdated = em.createQuery("DELETE FROM TbPista e WHERE e.idPista ="+idTbPista).executeUpdate();
    }
   
    public List<TbPista> listAll() {
            return this.em.createNamedQuery(
                   "TbPista.findAll", TbPista.class).getResultList();
    }    

    public TbPista getByID(int id) {
        return this.em.getReference(TbPista.class, id);
    }
    
}
