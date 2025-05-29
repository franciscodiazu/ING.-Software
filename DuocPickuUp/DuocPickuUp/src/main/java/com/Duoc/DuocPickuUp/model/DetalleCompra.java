package com.Duoc.DuocPickuUp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @NotNull
    @Min(1)
    private Integer cantidad;
}