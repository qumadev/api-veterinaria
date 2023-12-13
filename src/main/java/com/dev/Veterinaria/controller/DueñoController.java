package com.dev.Veterinaria.controller;



import com.dev.Veterinaria.model.Dueño;
import com.dev.Veterinaria.service.DueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
@RestController
@RequestMapping("/dueño")
public class DueñoController {

    @Autowired
    private DueñoService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<Dueño> items = service.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id){
        Dueño dueño = service.findById(id);
        if(dueño!=null){
            return new ResponseEntity<>(dueño,HttpStatus.OK );
        }
        return  new ResponseEntity<>("El Dueño no se registro correctamente",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Dueño dueño){
        service.insert(dueño);
        return  new ResponseEntity<>("Dueño registrada",HttpStatus.CREATED);
    }
}
