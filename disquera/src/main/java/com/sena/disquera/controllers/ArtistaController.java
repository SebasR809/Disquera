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

import com.sena.disquera.model.Artista;
import com.sena.disquera.service.IArtistaService;

@Controller
@SessionAttributes("artista")
@RequestMapping("/artista")
public class ArtistaController {
    @Autowired
    private IArtistaService iartista;

    @GetMapping(path={"/listart","","/"})
    public String listart(Model m){
        m.addAttribute("artistas", iartista.findAll());
        return "artista/listart";
    }

    // Vista Añadir
    @GetMapping("/addart") 
        public String addgen(Model m){
            Artista artista = new Artista();
            m.addAttribute("artista" , artista);
            m.addAttribute("accion" , "Agregar nuevo artista");
            return "artista/addart";
        }
    @PostMapping("/add")
    public String add(@Valid Artista artista,BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            m.addAttribute("accion" , "Agregar nuevo artista");
            return "artista/addart";      
        }
        iartista.save(artista);
        status.setComplete();
        return "redirect:listart";
    }
    // Buscar por id
    @GetMapping("/listid/{id}")
    public String listid(@PathVariable Integer id, Model m){
        Artista artista = null;
        if(id>0){
            artista = iartista.findOne(id);
        }
        else {
            return "redirect:listart";
        }
        m.addAttribute("artista", artista);
        m.addAttribute("accion" , "Actualizar un artista");
        return "artista/addart";
    }

    //Eliminar
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id>0){
            iartista.delete(id);
        }
        return "redirect:listart";
    }
}
