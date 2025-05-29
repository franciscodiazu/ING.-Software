package com.Duoc.DuocPickuUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duoc.DuocPickuUp.model.Usuario;
import com.Duoc.DuocPickuUp.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repo;

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    public Optional<Usuario> buscar(Long id) {
        return repo.findById(id);
    }

    public boolean eliminar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Usuario> login(String correo, String password) {
        return repo.findByCorreoAndPassword(correo, password);
    }
}
