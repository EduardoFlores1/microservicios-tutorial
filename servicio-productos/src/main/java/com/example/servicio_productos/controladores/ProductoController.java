package com.example.servicio_productos.controladores;

import com.example.servicio_productos.modelos.dtos.ProductoRequest;
import com.example.servicio_productos.modelos.dtos.ProductoResponse;
import com.example.servicio_productos.servicios.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/productos")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @RequestMapping
    //@PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    ResponseEntity<List<ProductoResponse>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Void> crearProducto(@RequestBody ProductoRequest request) {
        productoService.crearProducto(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
