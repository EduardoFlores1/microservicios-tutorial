package com.example.servicio_inventario.servicios;

import com.example.servicio_inventario.model.dtos.BaseResponse;
import com.example.servicio_inventario.model.dtos.InventarioResponse;
import com.example.servicio_inventario.model.dtos.OrdenItemRequest;

import java.util.List;

public interface IInventarioService {
    List<InventarioResponse> getAll();
    boolean isInStock(String sku);
    BaseResponse areInStock(List<OrdenItemRequest> ordenItemRequestList);
}
