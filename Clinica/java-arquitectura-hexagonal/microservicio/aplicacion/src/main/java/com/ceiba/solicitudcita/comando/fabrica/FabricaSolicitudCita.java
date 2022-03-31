package com.ceiba.solicitudcita.comando.fabrica;

import com.ceiba.solicitudcita.comando.ComandoSolicitudCita;
import com.ceiba.solicitudcita.modelo.dto.DtoEntradaCrearSolicitudCita;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitudCita {
    public DtoEntradaCrearSolicitudCita crear(ComandoSolicitudCita comandoSolicitudCita){
        return new DtoEntradaCrearSolicitudCita(
                comandoSolicitudCita.getId(),
                comandoSolicitudCita.getIdMedico(),
                comandoSolicitudCita.getIdUsuario(),
                comandoSolicitudCita.getIdEspecialidad(),
                comandoSolicitudCita.getIdHorario(),
                comandoSolicitudCita.getFechaSolicitud(),
                comandoSolicitudCita.getFechaCita()
        );
    }
}
