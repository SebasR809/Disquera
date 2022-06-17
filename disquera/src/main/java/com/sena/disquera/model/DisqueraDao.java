package com.sena.disquera.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DisqueraDao implements IDisquera{
    
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Disquera> findAll(){
        return em.createQuery("from Disquera").getResultList();
    }

    @Transactional
    @Override
    public void save(Disquera disquera) {
        if (disquera.getIdDisq() != null && disquera.getIdDisq() > 0){
            em.merge(disquera);
        } else {
            em.persist(disquera);   
        }
    }
        
    @Transactional(readOnly = true)
    @Override
    public Disquera findOne(Integer id) {
        
        return em.find(Disquera.class, id);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        em.remove(findOne(id));     
    }
}
