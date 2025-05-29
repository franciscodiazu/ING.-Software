package com.Duoc.DuocPickuUp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Duoc.DuocPickuUp.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByCorreoAndContrasena(String correo, String contrasena);
}

