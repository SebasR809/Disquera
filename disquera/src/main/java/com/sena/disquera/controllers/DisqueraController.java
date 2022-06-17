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

import com.sena.disquera.model.Disquera;
import com.sena.disquera.model.IDisquera;

@Controller
@SessionAttributes("disquera")
@RequestMapping("/disqueras")
public class DisqueraController {
    @Autowired
    private IDisquera idisquera;
    
    @GetMapping(path={"/listdisq","","/"})
    public String listgen(Model m){
        m.addAttribute("disqueras",idisquera.findAll());
        return "disquera/listdisq";
    }
    // Vista Añadir
    @GetMapping("/adddisq")
        public String adddisq(Model m){
            Disquera disquera = new Disquera();
            m.addAttribute("disquera" , disquera);
            m.addAttribute("accion" , "Agregar nuevo disquera");
            return "disquera/adddisq";
        }
    @PostMapping("/add")
    public String add(@Valid Disquera disquera,BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "disquera/adddisq";      
        }
        idisquera.save(disquera);
        status.setComplete();
        return "redirect:listdisq";
    }  
    // Buscar por id
    @GetMapping("/listid/{id}")
    public String listid(@PathVariable Integer id, Model m){
        Disquera disquera = null;
        if(id>0){
            disquera = idisquera.findOne(id);
        }
        else {
            return "redirect:listdisq";
        }
        m.addAttribute("disquera", disquera);
        m.addAttribute("accion" , "Actualizar un nuevo género");
        return "disquera/adddisq";
    }

    //Eliminar
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id>0){
            idisquera.delete(id);
        }
        return "redirect:../listdisq ";
    }
}
