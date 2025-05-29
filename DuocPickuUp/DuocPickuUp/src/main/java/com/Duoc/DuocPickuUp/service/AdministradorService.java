package com.Duoc.DuocPickuUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duoc.DuocPickuUp.model.Administrador;
import com.Duoc.DuocPickuUp.repository.AdministradorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdministradorService {

    private final AdministradorRepository repo;

    public List<Administrador> listar() {
        return repo.findAll();
    }

    public Administrador guardar(Administrador admin) {
        return repo.save(admin);
    }

    public Optional<Administrador> buscar(Long id) {
        return repo.findById(id);
    }

    public boolean eliminar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Administrador> login(String correo, String password) {
        return repo.findByCorreoAndContrasena(correo, password);
    }
}