package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoPresentacionUsuario {
    private Long id;
    private String identificacion;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
}
