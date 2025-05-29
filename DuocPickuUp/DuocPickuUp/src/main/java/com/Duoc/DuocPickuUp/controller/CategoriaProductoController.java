package com.Duoc.DuocPickuUp.controller;


import com.Duoc.DuocPickuUp.model.CategoriaProducto;
import com.Duoc.DuocPickuUp.repository.CategoriaProductoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @GetMapping
    public List<CategoriaProducto> getCategorias() {
        return categoriaProductoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaProducto createCategoria(@Valid @RequestBody CategoriaProducto categoriaProducto) {
        return categoriaProductoRepository.save(categoriaProducto);
    }

    @PutMapping("/{id}")
    public CategoriaProducto updateCategoria(@PathVariable Long id, @Valid @RequestBody CategoriaProducto categoriaProducto) {
        if (!categoriaProductoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada");
        }
        categoriaProducto.setId(id);
        return categoriaProductoRepository.save(categoriaProducto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoria(@PathVariable Long id) {
        if (!categoriaProductoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada");
        }
        categoriaProductoRepository.deleteById(id);
    }
}
