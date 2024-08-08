package com.example.servicio_inventario.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenItemRequest {
    private Long id;
    private String sku;
    private Double precio;
    private Long cantidad;
}
