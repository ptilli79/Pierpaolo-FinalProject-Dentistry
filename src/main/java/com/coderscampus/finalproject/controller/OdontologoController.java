	package com.coderscampus.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.coderscampus.finalproject.domain.Odontologo;
import com.coderscampus.finalproject.exceptions.ResourceNotFoundException;
import com.coderscampus.finalproject.service.OdontologoService;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/odontologos")
public class OdontologoController {
    //inyecto service por constructor
	@Autowired
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //métodos
    //GUARDAR
    @PostMapping("/odontologos")
    public ResponseEntity<Object> registrarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException{
    	
        if (odontologoService.busquedaXmatricula(odontologo.getMatricula()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        
        odontologoService.guardar(odontologo);
        return new ResponseEntity<>(odontologo, HttpStatus.CREATED);
    }
    	
    //BUSCAR X ID
    @GetMapping("/odontologos/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo=odontologoService.busquedaXid(id);
        if (odontologo.isPresent()){
            return ResponseEntity.ok(odontologo.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR TODOS
    @GetMapping("/odontologos")
    public ResponseEntity<List<Odontologo>> buscarTodosOdontologos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }


    @DeleteMapping("/odontologos/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo=odontologoService.busquedaXid(id);
        if (odontologo.isPresent()){
            odontologoService.borrar(id);
            return ResponseEntity.ok("Se eliminó al odontólogo con id="+id);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo borrar por no existir el id "+id);
        }
    }

    //ACTUALIZAR
    @PutMapping("/odontologos")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody @AuthenticationPrincipal Odontologo odontologo) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado=odontologoService.busquedaXid(odontologo.getId());
        if (odontologoBuscado.isPresent()){
            Odontologo odontologoActualizado=odontologoService.actualizar(odontologo);
            return ResponseEntity.ok(odontologoActualizado);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/odontologoAlta")
    public String ondontologoAlta () {
        return "odontologoAlta";
      }
    
    @GetMapping("/odontologosList")
    public String ondontologoList () {
        return "odontologosList";
      }   
    
    @GetMapping("/pacienteAlta")
    public String pacienteAlta () {
        return "pacienteAlta";
      }
    
    @GetMapping("/pacientesList")
    public String pacientesList () {
        return "pacientesList";
      }   
}
