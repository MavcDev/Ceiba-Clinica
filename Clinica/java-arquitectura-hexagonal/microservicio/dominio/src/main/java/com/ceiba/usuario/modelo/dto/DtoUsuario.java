package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    protected Long id;
    protected String identificacion;
    protected String nombres;
    protected String primerApellido;
    protected String segundoApellido;
    protected LocalDate fechaNacimiento;
    private LocalDateTime fechaCreacion;
}
