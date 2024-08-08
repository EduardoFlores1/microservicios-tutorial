package com.example.servicio_ordenes.modelos.mappers;

import com.example.servicio_ordenes.modelos.dtos.OrdenResponse;
import com.example.servicio_ordenes.modelos.entidades.Orden;

public class OrdenMapper {
    public static OrdenResponse toResponse(Orden orden) {
        return OrdenResponse.builder()
                .id(orden.getId())
                .numeroOrden(orden.getNumeroOrden())
                .ordenItems(orden.getOrdenItems().stream().map(OrdenItemMapper::toResponse).toList())
                .build();
    }
}
