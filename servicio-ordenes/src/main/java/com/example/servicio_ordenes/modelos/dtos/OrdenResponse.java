package com.example.servicio_ordenes.modelos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenResponse {
    private Long id;
    private String numeroOrden;
    private List<OrdenItemResponse> ordenItems;
}
