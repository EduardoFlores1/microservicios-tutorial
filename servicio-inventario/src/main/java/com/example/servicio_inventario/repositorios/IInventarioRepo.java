package com.example.servicio_inventario.repositorios;

import com.example.servicio_inventario.model.entidades.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IInventarioRepo extends JpaRepository<Inventario, Integer> {
    Optional<Inventario> findBySku(String sku);
    List<Inventario> findBySkuIn(List<String> skus);
}
