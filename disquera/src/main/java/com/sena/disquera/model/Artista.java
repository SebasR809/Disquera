package com.sena.disquera.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="artistas")
public class Artista {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArt;

    @Column(length=50)
    @NotEmpty
    private String nomArt;
    
    @Column(length=50)
    @NotEmpty
    private String apelArt;

    @Column(length=50)
    @NotEmpty
    private String apodoArt;

    @Column(length=4)
    @NotEmpty
    private String tipdocArt; 
    
    @NotNull
    private Integer numdocArt;

    private Date fecnacArt;

    @Column(length=50)
    @NotEmpty
    private String emailArt;

    private Boolean estArt;

    public Artista(){

    }
    public Artista(Integer idArt, String nomArt, String apelArt, String apodoArt, String tipdocArt, Integer numdocArt,
            Date fecnacArt, String emailArt, Boolean estArt) {
        this.idArt = idArt;
        this.nomArt = nomArt;
        this.apelArt = apelArt;
        this.apodoArt = apodoArt;
        this.tipdocArt = tipdocArt;
        this.numdocArt = numdocArt;
        this.fecnacArt = fecnacArt;
        this.emailArt = emailArt;
        this.estArt = estArt;
    }
    public Integer getIdArt() {
        return idArt;
    }
    public void setIdArt(Integer idArt) {
        this.idArt = idArt;
    }
    public String getNomArt() {
        return nomArt;
    }
    public void setNomArt(String nomArt) {
        this.nomArt = nomArt;
    }
    public String getApelArt() {
        return apelArt;
    }
    public void setApelArt(String apelArt) {
        this.apelArt = apelArt;
    }
    public String getApodoArt() {
        return apodoArt;
    }
    public void setApodoArt(String apodoArt) {
        this.apodoArt = apodoArt;
    }
    public String getTipdocArt() {
        return tipdocArt;
    }
    public void setTipdocArt(String tipdocArt) {
        this.tipdocArt = tipdocArt;
    }
    public Integer getNumdocArt() {
        return numdocArt;
    }
    public void setNumdocArt(Integer numdocArt) {
        this.numdocArt = numdocArt;
    }
    public Date getFecnacArt() {
        return fecnacArt;
    }
    public void setFecnacArt(Date fecnacArt) {
        this.fecnacArt = fecnacArt;
    }
    public String getEmailArt() {
        return emailArt;
    }
    public void setEmailArt(String emailArt) {
        this.emailArt = emailArt;
    }
    public Boolean getEstArt() {
        return estArt;
    }
    public void setEstArt(Boolean estArt) {
        this.estArt = estArt;
    }
}
