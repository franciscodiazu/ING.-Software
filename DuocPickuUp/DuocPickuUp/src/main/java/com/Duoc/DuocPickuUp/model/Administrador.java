package com.Duoc.DuocPickuUp.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true) /*Esto sirve para utilizar los atributos de la clase padre (en este caso Usuario) */
@NoArgsConstructor
@AllArgsConstructor
public class Administrador extends Usuario {
    @NotBlank
    private String rol;}