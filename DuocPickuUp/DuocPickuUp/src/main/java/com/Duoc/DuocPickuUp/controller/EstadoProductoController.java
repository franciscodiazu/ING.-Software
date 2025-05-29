package com.Duoc.DuocPickuUp.controller;

import com.Duoc.DuocPickuUp.model.EstadoProducto;
import com.Duoc.DuocPickuUp.repository.EstadoProductoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/estado-productos")
public class EstadoProductoController {

    @Autowired
    private EstadoProductoRepository estadoProductoRepository;

    @GetMapping
    public List<EstadoProducto> getEstadoProductos() {
        return estadoProductoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoProducto createEstadoProducto(@Valid @RequestBody EstadoProducto estadoProducto) {
        return estadoProductoRepository.save(estadoProducto);
    }

    @PutMapping("/{id}")
    public EstadoProducto updateEstadoProducto(@PathVariable Long id, @Valid @RequestBody EstadoProducto estadoProducto) {
        if (!estadoProductoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado de producto no encontrado");
        }
        estadoProducto.setId(id);
        return estadoProductoRepository.save(estadoProducto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEstadoProducto(@PathVariable Long id) {
        if (!estadoProductoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado de producto no encontrado");
        }
        estadoProductoRepository.deleteById(id);
    }
}
