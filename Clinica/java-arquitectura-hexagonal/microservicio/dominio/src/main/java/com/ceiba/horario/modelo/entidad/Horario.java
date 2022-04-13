package com.ceiba.horario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Horario {

    public static final String SE_DEBE_INGRESAR_LA_HORA_INICIAL = "Se debe ingresar la hora inicial";
    public static final String SE_DEBE_INGRESAR_LA_HORA_FINAL = "Se debe ingresar la hora final";

    private Long id;
    private String horaInicial;
    private String horaFinal;

    public Horario(Long id, String horaInicial, String horaFinal){
        validarObligatorio(horaInicial, SE_DEBE_INGRESAR_LA_HORA_INICIAL);
        validarObligatorio(horaFinal, SE_DEBE_INGRESAR_LA_HORA_FINAL);

        this.id = id;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    public String getHoraCompleta() {
        return String.format("%s hasta %s", horaInicial, horaFinal);
    }
}
