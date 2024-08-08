package com.example.servicio_ordenes.modelos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenItemResponse {
    private Long id;
    private String sku;
    private Double precio;
    private Long cantidad;
}
