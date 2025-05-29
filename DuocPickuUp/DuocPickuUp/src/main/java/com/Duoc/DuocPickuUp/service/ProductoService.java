package com.Duoc.DuocPickuUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duoc.DuocPickuUp.model.Producto;
import com.Duoc.DuocPickuUp.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repo;

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto guardar(Producto producto) {
        return repo.save(producto);
    }

    public Optional<Producto> buscar(Long id) {
        return repo.findById(id);
    }

    public boolean eliminar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}