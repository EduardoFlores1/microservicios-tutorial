package com.example.servicio_ordenes.repositorios;

import com.example.servicio_ordenes.modelos.entidades.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenRepo extends JpaRepository<Orden, Long> {
}
