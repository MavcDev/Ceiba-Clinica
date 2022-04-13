package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.modelo.entidad.Horario;

public class HorarioTestDataBuilder {

    private Long id;
    private String horaInicial;
    private String horaFinal;

    public HorarioTestDataBuilder(){
        horaInicial = "07:00 AM";
        horaFinal = "07:30 AM";
    }

    public HorarioTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public HorarioTestDataBuilder conHorarioInicial(String horaInicial){
        this.horaInicial = horaInicial;
        return this;
    }

    public HorarioTestDataBuilder conHorarioFinal(String horaFinal){
        this.horaFinal = horaFinal;
        return this;
    }

    public Horario build(){
        return new Horario(id, horaInicial, horaFinal);
    }
}
