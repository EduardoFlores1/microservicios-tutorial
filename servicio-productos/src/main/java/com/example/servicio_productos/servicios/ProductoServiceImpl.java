package com.example.servicio_productos.servicios;

import com.example.servicio_productos.modelos.dtos.ProductoRequest;
import com.example.servicio_productos.modelos.dtos.ProductoResponse;
import com.example.servicio_productos.modelos.entidades.Producto;
import com.example.servicio_productos.modelos.mappers.ProductoMapper;
import com.example.servicio_productos.repositorios.IProductoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements IProductoService{

    private final IProductoRepo productoRepo;

    public ProductoServiceImpl(IProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoResponse> listarProductos() {
        var list = productoRepo.findAll();
        return list.stream().map(ProductoMapper::mapToResponse).toList();
    }

    @Override
    @Transactional
    public void crearProducto(ProductoRequest productoRequest) {
        var producto = Producto.builder()
                .sku(productoRequest.getSku())
                .nombre(productoRequest.getNombre())
                .descripcion(productoRequest.getDescripcion())
                .precio(productoRequest.getPrecio())
                .estado(productoRequest.getEstado())
                .build();
        productoRepo.save(producto);
        log.info("Producto insertado exitosamente: {}", producto);
    }
}
