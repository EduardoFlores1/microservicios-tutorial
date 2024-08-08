package com.example.servicio_inventario.servicios;

import com.example.servicio_inventario.model.dtos.BaseResponse;
import com.example.servicio_inventario.model.dtos.InventarioResponse;
import com.example.servicio_inventario.model.dtos.OrdenItemRequest;
import com.example.servicio_inventario.model.entidades.Inventario;
import com.example.servicio_inventario.model.mappers.InventarioMapper;
import com.example.servicio_inventario.repositorios.IInventarioRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InventarioServiceImpl implements IInventarioService{

    private final IInventarioRepo inventarioRepo;

    public InventarioServiceImpl(IInventarioRepo inventarioRepo) {
        this.inventarioRepo = inventarioRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InventarioResponse> getAll() {
        var list = inventarioRepo.findAll();
        return list.stream().map(InventarioMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String sku) {
        var inventario = inventarioRepo.findBySku(sku);
        return inventario.filter(value -> value.getCantidad() > 0).isPresent();
    }

    @Override
    @Transactional(readOnly = true)
    public BaseResponse areInStock(List<OrdenItemRequest> ordenItemRequestList) {

        var errorList = new ArrayList<String>();
        List<String> skus = ordenItemRequestList.stream().map(OrdenItemRequest::getSku).toList();
        List<Inventario> inventarioList = inventarioRepo.findBySkuIn(skus);

        ordenItemRequestList.forEach(ordenItemRequest -> {
            var inventario = inventarioList.stream().filter(value -> value.getSku().equals(ordenItemRequest.getSku())).findFirst();
            if(inventario.isEmpty()) {
                errorList.add("Producto con sku " + ordenItemRequest.getSku() + " no encontrado.");
            }else if (inventario.get().getCantidad() < ordenItemRequest.getCantidad()) {
                errorList.add("Producto con sku " + ordenItemRequest.getSku() + " no tiene la cantidad suficiente.");
            }
        });
        return !errorList.isEmpty() ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }
}
