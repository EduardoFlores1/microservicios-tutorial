package com.example.servicio_ordenes.servicios;

import com.example.servicio_ordenes.modelos.dtos.OrdenRequest;
import com.example.servicio_ordenes.modelos.dtos.OrdenResponse;

import java.util.List;

public interface IOrdenService {
    List<OrdenResponse> getAll();
    OrdenResponse crearOrden(OrdenRequest ordenRequest);
}
