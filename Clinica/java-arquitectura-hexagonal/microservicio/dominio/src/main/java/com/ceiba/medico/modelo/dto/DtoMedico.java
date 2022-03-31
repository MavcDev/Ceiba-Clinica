package com.ceiba.medico.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoMedico {
    protected Long id;
    protected String identificacion;
    protected String nombres;
    protected String primerApellido;
    protected String segundoApellido;
    protected LocalDate fechaNacimiento;
    protected Long especialidad;
}
