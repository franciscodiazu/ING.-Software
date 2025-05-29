package com.Duoc.DuocPickuUp.controller;


import com.Duoc.DuocPickuUp.model.Compra;
import com.Duoc.DuocPickuUp.repository.CompraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @GetMapping
    public List<Compra> getCompras() {
        return compraRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compra createCompra(@Valid @RequestBody Compra compra) {
        return compraRepository.save(compra);
    }

    @PutMapping("/{id}")
    public Compra updateCompra(@PathVariable Long id, @Valid @RequestBody Compra compra) {
        if (!compraRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra no encontrada");
        }
        compra.setId(id);
        return compraRepository.save(compra);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompra(@PathVariable Long id) {
        if (!compraRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra no encontrada");
        }
        compraRepository.deleteById(id);
    }
}

