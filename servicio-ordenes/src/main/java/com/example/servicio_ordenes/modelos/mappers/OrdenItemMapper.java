package com.example.servicio_ordenes.modelos.mappers;

import com.example.servicio_ordenes.modelos.dtos.OrdenItemRequest;
import com.example.servicio_ordenes.modelos.dtos.OrdenItemResponse;
import com.example.servicio_ordenes.modelos.entidades.Orden;
import com.example.servicio_ordenes.modelos.entidades.OrdenItem;

public class OrdenItemMapper {
    public static OrdenItem mapToEntity(OrdenItemRequest ordenItemRequest, Orden orden) {
        return OrdenItem.builder()
                .sku(ordenItemRequest.getSku())
                .precio(ordenItemRequest.getPrecio())
                .cantidad(ordenItemRequest.getCantidad())
                .orden(orden)
                .build();
    }

    public static OrdenItemResponse toResponse(OrdenItem ordenItem) {
        return OrdenItemResponse.builder()
                .id(ordenItem.getId())
                .sku(ordenItem.getSku())
                .precio(ordenItem.getPrecio())
                .cantidad(ordenItem.getCantidad())
                .build();
    }
}
