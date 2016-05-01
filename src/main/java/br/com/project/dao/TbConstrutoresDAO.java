/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.dao;

import br.com.project.model.TbConstrutores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author danglar
 */
@Transactional
public class TbConstrutoresDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(TbConstrutores tbConstrutores) throws Exception {
        this.em.persist(tbConstrutores);
    }
    
    public void edit(TbConstrutores tbConstrutores) throws Exception {
        this.em.merge(tbConstrutores);
    }
    
    public void delete(int idTbConstrutores) throws Exception {
        int numRowUpdated = em.createQuery("DELETE FROM TbConstrutores e WHERE e.idEquipe ="+idTbConstrutores).executeUpdate();
    }
   
    public List<TbConstrutores> listAll() {
            return this.em.createNamedQuery(
                   "TbConstrutores.findAll", TbConstrutores.class).getResultList();
    }    

    public TbConstrutores getByID(int id) {
        return this.em.getReference(TbConstrutores.class, id);
    }
    
}
