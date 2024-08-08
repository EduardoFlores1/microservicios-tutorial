package com.example.servicio_inventario.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventarioResponse {
    private Long id;
    private String sku;
    private Long cantidad;
}
