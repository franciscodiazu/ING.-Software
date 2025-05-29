package com.Duoc.DuocPickuUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duoc.DuocPickuUp.model.Estudiante;
import com.Duoc.DuocPickuUp.repository.EstudianteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository repo;

    public List<Estudiante> listar() {
        return repo.findAll();
    }

    public Estudiante guardar(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    public Optional<Estudiante> buscar(Long id) {
        return repo.findById(id);
    }

    public boolean eliminar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Estudiante> login(String correo, String password) {
        return repo.findByCorreoAndContrasena(correo, password);
    }
}