package com.ceiba.solicitud.modelo.fabrica;

import com.ceiba.solicitud.modelo.dto.DtoSolicitud;
import com.ceiba.solicitud.modelo.entidad.Solicitud;

public class FabricaSolicitudModelo {
    public DtoSolicitud crear(Solicitud solicitud){
        return new DtoSolicitud(
                solicitud.getId(),
                solicitud.getMedico().getId(),
                solicitud.getUsuario().getId(),
                solicitud.getEspecialidad().getId(),
                solicitud.getHorario().getId(),
                solicitud.getFechaSolicitud(),
                solicitud.getFechaCita(),
                solicitud.getValor(),
                solicitud.isDescuentoPorMenorEdad()
        );
    }
}
