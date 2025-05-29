package com.Duoc.DuocPickuUp.controller;
import com.Duoc.DuocPickuUp.model.Administrador;
import com.Duoc.DuocPickuUp.repository.AdministradorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping
    public List<Administrador> getAdministradores() {
        return administradorRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador createAdministrador(@Valid @RequestBody Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @PutMapping("/{id}")
    public Administrador updateAdministrador(@PathVariable Long id, @Valid @RequestBody Administrador administrador) {
        if (!administradorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador no encontrado");
        }
        administrador.setId(id);
        return administradorRepository.save(administrador);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdministrador(@PathVariable Long id) {
        if (!administradorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador no encontrado");
        }
        administradorRepository.deleteById(id);
    }
} 
