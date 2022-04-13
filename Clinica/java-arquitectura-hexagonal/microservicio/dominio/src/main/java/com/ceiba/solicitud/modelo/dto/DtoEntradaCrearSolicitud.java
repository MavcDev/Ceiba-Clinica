package com.ceiba.solicitud.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoEntradaCrearSolicitud {
    private Long id;
    private Long medico;
    private Long usuario;
    private Long especialidad;
    private Long horarioDia;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;
}
