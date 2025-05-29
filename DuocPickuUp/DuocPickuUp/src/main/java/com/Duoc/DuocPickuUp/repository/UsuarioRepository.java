package com.Duoc.DuocPickuUp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Duoc.DuocPickuUp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndPassword(String correo, String password);}
