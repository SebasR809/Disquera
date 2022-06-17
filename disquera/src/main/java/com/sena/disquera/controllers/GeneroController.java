package com.sena.disquera.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.disquera.model.Genero;
import com.sena.disquera.model.IGenero;

@Controller
@SessionAttributes("genero")
@RequestMapping("/genero")
public class GeneroController{
    @Autowired
    private IGenero igenero;

    @GetMapping(path={"/listgen","","/"})
    public String listgen(Model m){
        m.addAttribute("generos", igenero.findAll());
        return "genero/listgen";
    }

    // Solo muestra un registro
    @GetMapping("/testegen")
        public String proba(Model m){
            Genero gen = new Genero();
            gen.setIdGen(1);
            gen.setNomGen("Rock");
            gen.setEstGen(true);
            m.addAttribute("genero", gen);
            return "genero/testegen";
        }

    // Vista Añadir
    @GetMapping("/addgen")
        public String addgen(Model m){
            Genero genero = new Genero();
            m.addAttribute("genero" , genero);
            m.addAttribute("accion" , "Agregar nuevo género");
            return "genero/addgen";
        }
    @PostMapping("/add")
    public String add(@Valid Genero genero,BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            m.addAttribute("accion" , "Agregar nuevo género");
            return "genero/addgen";      
        }
        igenero.save(genero);
        status.setComplete();
        return "redirect:listgen";
    }  

    // Buscar por id
    @GetMapping("/listid/{id}")
    public String listid(@PathVariable Integer id, Model m){
        Genero genero = null;
        if(id>0){
            genero = igenero.findOne(id);
        }
        else {
            return "redirect:listgen";
        }
        m.addAttribute("genero", genero);
        m.addAttribute("accion" , "Modificar el género");
        return "genero/addgen";
    }

    //Eliminar
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id>0){
            igenero.delete(id);
        }
        return "redirect:../listgen";
    }



}