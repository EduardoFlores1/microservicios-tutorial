package com.example.servicio_productos.modelos.mappers;

import com.example.servicio_productos.modelos.dtos.ProductoResponse;
import com.example.servicio_productos.modelos.entidades.Producto;

public class ProductoMapper {
    public static ProductoResponse mapToResponse(Producto producto) {
        return ProductoResponse.builder()
                .id(producto.getId())
                .sku(producto.getSku())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .estado(producto.getEstado())
                .build();
    }
}
