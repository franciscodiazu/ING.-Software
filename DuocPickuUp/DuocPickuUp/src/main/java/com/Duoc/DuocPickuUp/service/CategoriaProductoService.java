package com.Duoc.DuocPickuUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duoc.DuocPickuUp.model.CategoriaProducto;
import com.Duoc.DuocPickuUp.repository.CategoriaProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaProductoService {

    private final CategoriaProductoRepository repo;

    public List<CategoriaProducto> listar() {
        return repo.findAll();
    }

    public CategoriaProducto guardar(CategoriaProducto categoria) {
        return repo.save(categoria);
    }

    public Optional<CategoriaProducto> buscar(Long id) {
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