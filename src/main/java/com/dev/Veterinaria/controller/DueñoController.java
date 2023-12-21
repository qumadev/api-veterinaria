package com.dev.Veterinaria.controller;



import com.dev.Veterinaria.model.Dueño;
import com.dev.Veterinaria.service.DueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
@RestController
@RequestMapping("/dueño")
public class DueñoController {

    @Autowired
    private DueñoService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> listar()
    {
        Collection<Dueño> items = service.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> buscar(@PathVariable long id){
        Dueño dueño = service.findById(id);
        if(dueño!=null){
            return new ResponseEntity<>(dueño,HttpStatus.OK );
        }
        return  new ResponseEntity<>("El Dueño no se registro correctamente",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> agregar(@RequestBody Dueño dueño){
        service.insert(dueño);
        return  new ResponseEntity<>("Dueño registrada",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id_dueño}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> editar(@PathVariable Long id_dueño,
                                    @RequestBody Dueño newDueño) {
        Dueño bdDueño = service.findById(id_dueño);

        if (bdDueño != null) {
            bdDueño.setNombre(newDueño.getNombre());
            bdDueño.setTelefono(newDueño.getTelefono());


            service.update(bdDueño);
            return new ResponseEntity<>("Se modificó  el dueño con el id: " + bdDueño.getId_dueño(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{id_dueño}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> borrarDueño(@PathVariable Long id_dueño) {
        Dueño bdDueño = service.findById(id_dueño);

        if (bdDueño != null) {
            service.delete(id_dueño);
            return new ResponseEntity<>("Se elimino el id: " + bdDueño.getId_dueño()+ " con el nombre:" +bdDueño.getNombre(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
