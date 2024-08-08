package com.example.servicio_ordenes.servicios;

import com.example.servicio_ordenes.modelos.dtos.BaseResponse;
import com.example.servicio_ordenes.modelos.dtos.OrdenRequest;
import com.example.servicio_ordenes.modelos.dtos.OrdenResponse;
import com.example.servicio_ordenes.modelos.entidades.Orden;
import com.example.servicio_ordenes.modelos.mappers.OrdenItemMapper;
import com.example.servicio_ordenes.modelos.mappers.OrdenMapper;
import com.example.servicio_ordenes.repositorios.IOrdenRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrdenServiceImpl implements IOrdenService{

    private final IOrdenRepo ordenRepo;
    private final WebClient.Builder webClientBuilder;

    public OrdenServiceImpl(IOrdenRepo ordenRepo, WebClient.Builder webClientBuilder) {
        this.ordenRepo = ordenRepo;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrdenResponse> getAll() {
        var ordenes = ordenRepo.findAll();
        return ordenes.stream().map(OrdenMapper::toResponse).toList();
    }

    @Override
    @Transactional
    public OrdenResponse crearOrden(OrdenRequest ordenRequest) {

        // validamos que exista la cantidad solicitada a inventario
        BaseResponse result = this.webClientBuilder.build()
                .post()
                .uri("lb://servicio-inventarios/api/inventarios/in-stock")
                .bodyValue(ordenRequest.getOrdenItems())
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();

        if(result != null && !result.hasErrors()) {
            var orden = new Orden();
            orden.setNumeroOrden(UUID.randomUUID().toString());
            orden.setOrdenItems(ordenRequest.getOrdenItems()
                    .stream()
                    .map(ordenItemReq -> OrdenItemMapper.mapToEntity(ordenItemReq, orden))
                    .toList());

            var ordenes = ordenRepo.save(orden);
            log.info("La orden ha sido creado con exito");

            return OrdenMapper.toResponse(ordenes);

        }else {
            throw new IllegalArgumentException("Algunos productos no están en stock");
        }
    }
}
