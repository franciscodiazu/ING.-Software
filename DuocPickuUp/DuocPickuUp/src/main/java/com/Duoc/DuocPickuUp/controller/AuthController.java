package com.Duoc.DuocPickuUp.controller;

import com.Duoc.DuocPickuUp.model.Administrador;
import com.Duoc.DuocPickuUp.model.Estudiante;
import com.Duoc.DuocPickuUp.repository.AdministradorRepository;
import com.Duoc.DuocPickuUp.repository.EstudianteRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @PostMapping("/login/administrador")
    public Administrador loginAdministrador(@RequestBody LoginRequest request) {
        Optional<Administrador> admin = administradorRepository.findByCorreoAndContrasena(request.getCorreo(), request.getContrasena());
        return admin.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas para administrador"));
    }

    @PostMapping("/login/estudiante")
    public Estudiante loginEstudiante(@RequestBody LoginRequest request) {
        Optional<Estudiante> estudiante = estudianteRepository.findByCorreoAndContrasena(request.getCorreo(), request.getContrasena());
        return estudiante.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas para estudiante"));
    }

    public static class LoginRequest {
        @Email
        @NotBlank
        private String correo;

        @NotBlank
        private String contrasena;

        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }

        public String getContrasena() { return contrasena; }
        public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    }
} 
