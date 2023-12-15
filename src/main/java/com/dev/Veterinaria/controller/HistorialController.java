package com.dev.Veterinaria.controller;

import com.dev.Veterinaria.model.Historial;
import com.dev.Veterinaria.model.Vacuna;
import com.dev.Veterinaria.service.HistorialService;
import com.dev.Veterinaria.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
@RequestMapping("/historial")
public class HistorialController {
    @Autowired
    private HistorialService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> listar()
    {
        Collection<Historial> items = service.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> buscar(@PathVariable long id){
        Historial historial = service.findById(id);
        if(historial!=null){
            return new ResponseEntity<>(historial,HttpStatus.OK );
        }
        return  new ResponseEntity<>("Historial no registrado",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> agregar(@RequestBody Historial historial){
        service.insert(historial);
        return  new ResponseEntity<>("Historial registrado",HttpStatus.CREATED);
    }
}
