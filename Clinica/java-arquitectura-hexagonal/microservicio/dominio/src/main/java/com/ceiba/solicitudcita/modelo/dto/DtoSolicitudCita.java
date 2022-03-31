package com.ceiba.solicitudcita.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoSolicitudCita {
    private Long id;
    private Long medico;
    private Long usuario;
    private Long especialidad;
    private Long horarioDia;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;
    private BigDecimal valor;
    private boolean descuentoMenorEdad;
}
