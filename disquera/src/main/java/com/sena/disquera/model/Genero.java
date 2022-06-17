package com.sena.disquera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="generos")
public class Genero{

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGen;
 
    @Column(length=50)
    @NotEmpty
    private String nomGen;
    
    private boolean estGen;

    public Genero(){

    }

    public Genero(Integer idGen, String nomGen, boolean estGen){
        this.idGen = idGen;
        this.nomGen = nomGen;
        this.estGen = estGen;
    }
    public Integer getIdGen() {
        return idGen;
    }
    public void setIdGen(Integer idGen) {
        this.idGen = idGen;
    }
    public String getNomGen() {
        return nomGen;
    }
    public void setNomGen(String nomGen) {
        this.nomGen = nomGen;
    }
    public boolean getEstGen() {
        return estGen;
    }
    public void setEstGen(boolean estGen) {
        this.estGen = estGen;
    }
}
