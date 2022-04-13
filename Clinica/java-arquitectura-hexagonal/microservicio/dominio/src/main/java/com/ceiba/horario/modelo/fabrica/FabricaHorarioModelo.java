package com.ceiba.horario.modelo.fabrica;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.modelo.entidad.Horario;


public class FabricaHorarioModelo {

    public DtoHorario crear(Horario horario){
        return new DtoHorario(
                horario.getId(),
                horario.getHoraInicial(),
                horario.getHoraFinal()
        );
    }
}
