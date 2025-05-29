package com.Duoc.DuocPickuUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duoc.DuocPickuUp.model.Compra;
import com.Duoc.DuocPickuUp.repository.CompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository repo;

    public List<Compra> listar() {
        return repo.findAll();
    }

    public Compra guardar(Compra compra) {
        return repo.save(compra);
    }

    public Optional<Compra> buscar(Long id) {
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