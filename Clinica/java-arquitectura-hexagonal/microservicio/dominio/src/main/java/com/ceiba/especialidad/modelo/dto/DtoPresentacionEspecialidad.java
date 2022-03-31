package com.ceiba.especialidad.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class DtoPresentacionEspecialidad {
    private Long id;
    private String nombre;
    private BigDecimal valor;
}
