package com.sena.disquera.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GeneroDao implements IGenero{

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Genero> findAll(){
        return em.createQuery("from Genero").getResultList();
    }

    @Transactional
    @Override
    public void save(Genero genero) {
        if (genero.getIdGen() != null && genero.getIdGen() > 0){
            em.merge(genero);
        } else {
            em.persist(genero);   
        }
    }
    @Transactional(readOnly = true)
    @Override
    public Genero findOne(Integer id) {
        
        return em.find(Genero.class, id);
    }

    
    @Override
    @Transactional
    public void delete(Integer id) {
        em.remove(findOne(id));
    }

    
    
}
