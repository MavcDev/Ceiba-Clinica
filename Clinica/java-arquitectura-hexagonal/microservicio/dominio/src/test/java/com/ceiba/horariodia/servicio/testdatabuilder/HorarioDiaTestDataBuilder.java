package com.ceiba.horariodia.servicio.testdatabuilder;

import com.ceiba.horariodia.modelo.entidad.HorarioDia;

public class HorarioDiaTestDataBuilder {

    private Long id;
    private String horaInicial;
    private String horaFinal;

    public HorarioDiaTestDataBuilder(){
        horaInicial = "07:00 AM";
        horaFinal = "07:30 AM";
    }

    public HorarioDiaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public HorarioDiaTestDataBuilder conHorarioInicial(String horaInicial){
        this.horaInicial = horaInicial;
        return this;
    }

    public HorarioDiaTestDataBuilder conHorarioFinal(String horaFinal){
        this.horaFinal = horaFinal;
        return this;
    }

    public HorarioDia build(){
        return new HorarioDia(id, horaInicial, horaFinal);
    }
}
