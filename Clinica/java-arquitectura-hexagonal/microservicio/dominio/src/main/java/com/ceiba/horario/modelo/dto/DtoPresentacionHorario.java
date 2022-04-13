package com.ceiba.horario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPresentacionHorario {
    private Long id;
    private String horaInicio;
    private String horaFinal;
}
