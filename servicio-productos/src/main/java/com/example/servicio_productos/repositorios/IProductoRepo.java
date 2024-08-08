package com.example.servicio_productos.repositorios;

import com.example.servicio_productos.modelos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepo extends JpaRepository<Producto, Long> {
}
