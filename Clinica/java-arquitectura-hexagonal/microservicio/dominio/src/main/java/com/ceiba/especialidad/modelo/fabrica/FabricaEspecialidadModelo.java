package com.ceiba.especialidad.modelo.fabrica;

import com.ceiba.especialidad.modelo.dto.DtoEspecialidad;
import com.ceiba.especialidad.modelo.entidad.Especialidad;

public class FabricaEspecialidadModelo {

    public DtoEspecialidad crear(Especialidad especialidad){
        return new DtoEspecialidad(
                especialidad.getId(),
                especialidad.getNombre(),
                especialidad.getValor()
        );
    }
}
