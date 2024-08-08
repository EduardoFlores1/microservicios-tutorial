package com.example.servicio_productos.servicios;

import com.example.servicio_productos.modelos.dtos.ProductoRequest;
import com.example.servicio_productos.modelos.dtos.ProductoResponse;

import java.util.List;

public interface IProductoService {
    List<ProductoResponse> listarProductos();
    void crearProducto(ProductoRequest productoRequest);
}
