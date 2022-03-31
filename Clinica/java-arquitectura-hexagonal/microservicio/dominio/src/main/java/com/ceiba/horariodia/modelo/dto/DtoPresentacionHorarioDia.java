package com.ceiba.horariodia.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPresentacionHorarioDia {
    private Long id;
    private String horaInicio;
    private String horaFinal;
}
