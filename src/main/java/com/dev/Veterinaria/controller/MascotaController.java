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

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> editar(@PathVariable Long id,
                                    @RequestBody Mascota updated) {
        Mascota mascota = service.findById(id);

        if (mascota != null) {
            mascota.setNombre(updated.getNombre());
            mascota.setEspecie(updated.getEspecie());
            mascota.setFecha_nacimiento(updated.getFecha_nacimiento());

            service.update(mascota);
            return new ResponseEntity<>("Se modificó la mascota con el id: " +mascota.getId_mascota(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> borrarDueño(@PathVariable Long id) {
        Mascota mascota = service.findById(id);

        if (mascota != null) {
            service.delete(id);
            return new ResponseEntity<>("Se elimino el id: " + mascota.getId_mascota()+ " con el nombre:" +mascota.getNombre(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
