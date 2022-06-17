package com.sena.disquera.model;

import java.util.List;

public interface IDisquera {
    public List<Disquera> findAll();
    public void save(Disquera disquera);
    public Disquera findOne(Integer id);
    public void delete(Integer id);
}
