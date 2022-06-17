package com.sena.disquera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="disqueras")
public class Disquera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisq;
    
    @Column(length=20)
    @NotEmpty
    private String nitDisq;

    @Column(length=100)
    @NotEmpty
    private String nomDisq;

    @Column(length=15)
    @NotEmpty
    private String numDisq;
    
    @Column(length=100)
    @NotEmpty
    private String dirreDisq;

    private boolean estDisq;


    public Disquera(){

    }
    public Disquera(Integer idDisq,String nitDisq, String nomDisq, String numDisq, String dirreDisq, boolean estDisq){
        this.idDisq = idDisq;
        this.nitDisq = nitDisq;
        this.nomDisq = nomDisq;
        this.numDisq = numDisq;
        this.dirreDisq = dirreDisq;
        this.estDisq = estDisq;
    }
    public Integer getIdDisq() {
        return idDisq;
    }
    public void setIdDisq(Integer idDisq) {
        this.idDisq = idDisq;
    }
    public String getNitDisq() {
        return nitDisq;
    }
    public void setNitDisq(String nitDisq) {
        this.nitDisq = nitDisq;
    }
    public String getNomDisq() {
        return nomDisq;
    }
    public void setNomDisq(String nomDisq) {
        this.nomDisq = nomDisq;
    }
    public String getNumDisq() {
        return numDisq;
    }
    public void setNumDisq(String string) {
        this.numDisq = string;
    }
    public String getDirreDisq() {
        return dirreDisq;
    }
    public void setDirreDisq(String dirreDisq) {
        this.dirreDisq = dirreDisq;
    }
    public Boolean getEstDisq() {
        return estDisq;
    }
    public void setEstDisq(boolean estDisq) {
        this.estDisq = estDisq;
    }

}
