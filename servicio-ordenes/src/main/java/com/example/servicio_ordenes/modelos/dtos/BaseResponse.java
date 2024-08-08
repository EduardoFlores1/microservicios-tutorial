package com.example.servicio_ordenes.modelos.dtos;

public record BaseResponse (String[] errorMessages) {
    public boolean hasErrors() {
        return errorMessages != null && errorMessages.length > 0;
    }
}
