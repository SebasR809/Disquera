package com.sena.disquera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disquera.model.Artista;
import com.sena.disquera.model.IArtista;

@Service
public class ArtistaServiceImpl implements IArtistaService{
    
    @Autowired
    private IArtista iartista;

    @Override
    public List<Artista> findAll() {
        return (List<Artista>) iartista.findAll();
    }

    @Override
    public void save(Artista artista) {  
        iartista.save(artista);
    }

    @Override
    public Artista findOne(Integer id) {
        return iartista.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iartista.deleteById(id);
    }
    
    
}
