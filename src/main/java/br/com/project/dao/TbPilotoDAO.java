/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.dao;


import br.com.project.model.TbPiloto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author danglar
 */
@Transactional
public class TbPilotoDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(TbPiloto tbPiloto) throws Exception {
        this.em.persist(tbPiloto);
    }
    
    public void edit(TbPiloto tbPiloto) throws Exception {
        this.em.merge(tbPiloto);
    }
    
    public void delete(int idTbPiloto) throws Exception {
        int numRowUpdated = em.createQuery("DELETE FROM TbPiloto e WHERE e.idPiloto ="+idTbPiloto).executeUpdate();
    }
   
    public List<TbPiloto> listAll() {
            return this.em.createNamedQuery(
                   "TbPiloto.findAll", TbPiloto.class).getResultList();
    }    

    public TbPiloto getByID(int id) {
        return this.em.getReference(TbPiloto.class, id);
    }
    
}
