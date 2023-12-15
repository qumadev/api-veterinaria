package com.dev.Veterinaria.controller;

import com.dev.Veterinaria.model.Mascota;
import com.dev.Veterinaria.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    private MascotaService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> listar()
    {
        Collection<Mascota> items = service.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> buscar(@PathVariable long id){
        Mascota mascota = service.findById(id);
        if(mascota!=null){
            return new ResponseEntity<>(mascota,HttpStatus.OK );
        }
        return  new ResponseEntity<>("Mascota no registrada",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> agregar(@RequestBody Mascota mascota){
        service.insert(mascota);
        return  new ResponseEntity<>("Mascota registrada",HttpStatus.CREATED);
    }
}
