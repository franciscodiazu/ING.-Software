package com.Duoc.DuocPickuUp.service;

import com.Duoc.DuocPickuUp.model.DetalleCompra;
import com.Duoc.DuocPickuUp.repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraService {

    @Autowired
    private DetalleCompraRepository repository;

    public List<DetalleCompra> findAll() {
        return repository.findAll();
    }

    public Optional<DetalleCompra> findById(Long id) {
        return repository.findById(id);
    }

    public DetalleCompra save(DetalleCompra detalleCompra) {
        return repository.save(detalleCompra);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}