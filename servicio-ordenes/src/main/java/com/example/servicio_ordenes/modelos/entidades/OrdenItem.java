package com.example.servicio_ordenes.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orden_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sku;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Long cantidad;
    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;
}
