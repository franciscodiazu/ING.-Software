package com.Duoc.DuocPickuUp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Duoc.DuocPickuUp.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByCorreoAndContrasena(String correo, String contrasena);
}
