package com.ceiba.solicitud.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoPresentacionSolicitud {
    private Long id;
    private String medico;
    private String identificacionUsuario;
    private String usuario;
    private String especialidad;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;
    private String horaInicio;
    private String horaFinal;
    private BigDecimal valor;
    private BigDecimal valorBase;
    private boolean descuentoMenorEdad;
}
