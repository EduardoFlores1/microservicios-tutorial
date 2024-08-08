package com.example.servicio_ordenes.controladores;

import com.example.servicio_ordenes.modelos.dtos.OrdenRequest;
import com.example.servicio_ordenes.modelos.dtos.OrdenResponse;
import com.example.servicio_ordenes.servicios.IOrdenService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ordenes")
public class OrdenController {

    private final IOrdenService ordenService;

    public OrdenController(IOrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping
    ResponseEntity<List<OrdenResponse>> getAll() {
        return ResponseEntity.ok(ordenService.getAll());
    }

    @PostMapping
    @CircuitBreaker(name = "servicio-ordenes", fallbackMethod = "crearOrdenFallBack")
    ResponseEntity<OrdenResponse> crearOrden(@RequestBody OrdenRequest ordenRequest) {
        var ordenes = ordenService.crearOrden(ordenRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ordenes);
    }

    private ResponseEntity<OrdenResponse> crearOrdenFallBack(OrdenRequest ordenRequest, Throwable throwable) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .build();
    }
}
