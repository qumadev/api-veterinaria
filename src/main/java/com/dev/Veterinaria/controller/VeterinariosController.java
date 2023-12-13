package com.dev.Veterinaria.controller;


import com.dev.Veterinaria.model.Veterinarios;
import com.dev.Veterinaria.service.VeterinariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
@RestController
@RequestMapping("/veterinarios")
public class VeterinariosController {

    @Autowired
    private VeterinariosService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<Veterinarios> items = service.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id){
        Veterinarios veterinarios = service.findById(id);
        if(veterinarios!=null){
            return new ResponseEntity<>(veterinarios,HttpStatus.OK );
        }
        return  new ResponseEntity<>("Veterinario no se registro correctamente",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Veterinarios veterinarios){
        service.insert(veterinarios);
        return  new ResponseEntity<>("Veterianrio registrada",HttpStatus.CREATED);
    }
}
