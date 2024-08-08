package com.example.servicio_inventario.model.mappers;

import com.example.servicio_inventario.model.dtos.InventarioResponse;
import com.example.servicio_inventario.model.entidades.Inventario;

public class InventarioMapper {
    public static InventarioResponse toResponse(Inventario inventario) {
        return InventarioResponse.builder()
                .id(inventario.getId())
                .sku(inventario.getSku())
                .cantidad(inventario.getCantidad())
                .build();
    }
}
