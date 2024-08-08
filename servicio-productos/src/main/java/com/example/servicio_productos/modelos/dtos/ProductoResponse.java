package com.example.servicio_productos.modelos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoResponse {
    private Long id;
    private String sku;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Boolean estado;
}
