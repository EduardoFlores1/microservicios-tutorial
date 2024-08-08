package com.example.servicio_inventario.controladores;

import com.example.servicio_inventario.model.dtos.BaseResponse;
import com.example.servicio_inventario.model.dtos.InventarioResponse;
import com.example.servicio_inventario.model.dtos.OrdenItemRequest;
import com.example.servicio_inventario.servicios.IInventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/inventarios")
public class InventarioController {

    private final IInventarioService inventarioService;

    public InventarioController(IInventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    ResponseEntity<List<InventarioResponse>> getAll() {
        return ResponseEntity.ok(inventarioService.getAll());
    }

    @GetMapping(value = "/{sku}")
    ResponseEntity<Boolean> isInStock(@PathVariable String sku) {
        return ResponseEntity.ok().body(inventarioService.isInStock(sku));
    }

    @PostMapping(value = "/in-stock")
    ResponseEntity<BaseResponse> areInStock(@RequestBody List<OrdenItemRequest> ordenItemRequestList) {
        return ResponseEntity.ok().body(inventarioService.areInStock(ordenItemRequestList));
    }
}
