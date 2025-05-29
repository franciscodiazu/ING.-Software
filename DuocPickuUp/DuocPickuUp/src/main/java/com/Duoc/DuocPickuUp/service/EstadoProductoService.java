package com.Duoc.DuocPickuUp.service;


import com.Duoc.DuocPickuUp.model.EstadoProducto;
import com.Duoc.DuocPickuUp.repository.EstadoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoProductoService {

    @Autowired
    private EstadoProductoRepository repository;

    public List<EstadoProducto> findAll() {
        return repository.findAll();
    }

    public Optional<EstadoProducto> findById(Long id) {
        return repository.findById(id);
    }

    public EstadoProducto save(EstadoProducto estadoProducto) {
        return repository.save(estadoProducto);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}