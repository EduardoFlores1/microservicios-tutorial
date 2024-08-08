package com.example.servicio_ordenes.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orden")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroOrden;
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    List<OrdenItem> ordenItems;
}
