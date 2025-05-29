package com.Duoc.DuocPickuUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duoc.DuocPickuUp.model.Local;
import com.Duoc.DuocPickuUp.repository.LocalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalService {

    private final LocalRepository repo;

    public List<Local> listar() {
        return repo.findAll();
    }

    public Local guardar(Local local) {
        return repo.save(local);
    }

    public Optional<Local> buscar(Long id) {
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