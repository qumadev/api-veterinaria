package com.dev.Veterinaria.controller;

import com.dev.Veterinaria.model.Vacuna;
import com.dev.Veterinaria.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/vacuna")
public class VacunaController {
    @Autowired
    private VacunaService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<Vacuna> items = service.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id){
        Vacuna vacuna = service.findById(id);
        if(vacuna!=null){
            return new ResponseEntity<>(vacuna,HttpStatus.OK );
        }
        return  new ResponseEntity<>("Vacuna no registrada",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Vacuna vacuna){
        service.insert(vacuna);
        return  new ResponseEntity<>("Vacuna registrada",HttpStatus.CREATED);
    }
}
