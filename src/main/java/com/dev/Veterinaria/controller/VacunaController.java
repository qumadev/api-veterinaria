package com.dev.Veterinaria.controller;

import com.dev.Veterinaria.model.Vacuna;
import com.dev.Veterinaria.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/vacuna")
public class VacunaController {
    @Autowired
    private VacunaService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> listar()
    {
        Collection<Vacuna> items = service.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> buscar(@PathVariable long id){
        Vacuna vacuna = service.findById(id);
        if(vacuna!=null){
            return new ResponseEntity<>(vacuna,HttpStatus.OK );
        }
        return  new ResponseEntity<>("Vacuna no registrada",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> agregar(@RequestBody Vacuna vacuna){
        service.insert(vacuna);
        return  new ResponseEntity<>("Vacuna registrada",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> editar(@PathVariable Long id,
                                    @RequestBody Vacuna updated) {
        Vacuna vacuna = service.findById(id);

        if (vacuna != null) {
            vacuna.setNombre(updated.getNombre());
            vacuna.setFecha_vencimiento(updated.getFecha_vencimiento());
            vacuna.setCosto(updated.getCosto());

            service.update(vacuna);
            return new ResponseEntity<>("Se modificó la vacuna con el id: " +vacuna.getId_vacuna(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> borrarDueño(@PathVariable Long id) {
        Vacuna vacuna = service.findById(id);

        if (vacuna != null) {
            service.delete(id);
            return new ResponseEntity<>("Se elimino el id: " + vacuna.getId_vacuna()+ " con el nombre:" +vacuna.getNombre(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
