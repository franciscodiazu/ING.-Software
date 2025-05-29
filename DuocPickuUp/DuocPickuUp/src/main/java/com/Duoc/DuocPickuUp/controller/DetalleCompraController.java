package com.Duoc.DuocPickuUp.controller;


import com.Duoc.DuocPickuUp.model.DetalleCompra;
import com.Duoc.DuocPickuUp.repository.DetalleCompraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-compras")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @GetMapping
    public List<DetalleCompra> getDetalleCompras() {
        return detalleCompraRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleCompra createDetalleCompra(@Valid @RequestBody DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    @PutMapping("/{id}")
    public DetalleCompra updateDetalleCompra(@PathVariable Long id, @Valid @RequestBody DetalleCompra detalleCompra) {
        if (!detalleCompraRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Detalle de compra no encontrado");
        }
        detalleCompra.setId(id);
        return detalleCompraRepository.save(detalleCompra);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDetalleCompra(@PathVariable Long id) {
        if (!detalleCompraRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Detalle de compra no encontrado");
        }
        detalleCompraRepository.deleteById(id);
    }
}
