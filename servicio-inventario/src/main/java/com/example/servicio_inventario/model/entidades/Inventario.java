package com.example.servicio_inventario.model.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventarios")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;
    @Column(nullable = false)
    private Long cantidad;
}
