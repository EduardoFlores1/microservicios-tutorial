package com.example.servicio_inventario.utils;

import com.example.servicio_inventario.model.entidades.Inventario;
import com.example.servicio_inventario.repositorios.IInventarioRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final IInventarioRepo inventarioRepo;

    public DataLoader(IInventarioRepo inventarioRepo) {
        this.inventarioRepo = inventarioRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");
        if (inventarioRepo.findAll().isEmpty()) {
            inventarioRepo.saveAll(
                    List.of(
                           Inventario.builder().sku("000001").cantidad(10L).build(),
                            Inventario.builder().sku("000002").cantidad(20L).build(),
                            Inventario.builder().sku("000003").cantidad(30L).build(),
                            Inventario.builder().sku("000004").cantidad(0L).build()
                    )
            );
        }
        log.info("Loading data complete.");
    }
}
