package com.ceiba.solicitudcita.modelo.fabrica;

import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.especialidad.modelo.fabrica.FabricaEspecialidadModelo;
import com.ceiba.horariodia.modelo.entidad.HorarioDia;
import com.ceiba.horariodia.modelo.fabrica.FabricaHorarioDiaModelo;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.medico.modelo.fabrica.FabricaMedicoModelo;
import com.ceiba.solicitudcita.modelo.dto.DtoEntradaCrearSolicitudCita;
import com.ceiba.solicitudcita.modelo.dto.DtoSolicitudCita;
import com.ceiba.solicitudcita.modelo.entidad.SolicitudCita;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.modelo.fabrica.FabricaUsuarioModelo;


public class FabricaSolicitudCitaModelo {

    private final FabricaUsuarioModelo fabricaUsuarioModelo;
    private final FabricaMedicoModelo fabricaMedicoModelo;
    private final FabricaEspecialidadModelo fabricaEspecialidadModelo;
    private final FabricaHorarioDiaModelo fabricaHorarioDiaModelo;

    public FabricaSolicitudCitaModelo(FabricaUsuarioModelo fabricaUsuarioModelo, FabricaMedicoModelo fabricaMedicoModelo, FabricaEspecialidadModelo fabricaEspecialidadModelo, FabricaHorarioDiaModelo fabricaHorarioDiaModelo) {
        this.fabricaUsuarioModelo = fabricaUsuarioModelo;
        this.fabricaMedicoModelo = fabricaMedicoModelo;
        this.fabricaEspecialidadModelo = fabricaEspecialidadModelo;
        this.fabricaHorarioDiaModelo = fabricaHorarioDiaModelo;
    }

    public SolicitudCita crear(DtoEntradaCrearSolicitudCita dtoEntradaCrearSolicitudCita){
        Usuario usuario = fabricaUsuarioModelo.buscarCrear(dtoEntradaCrearSolicitudCita.getUsuario());
        Medico medico = fabricaMedicoModelo.buscarCrear(dtoEntradaCrearSolicitudCita.getMedico());
        Especialidad especialidad = fabricaEspecialidadModelo.buscarCrear(dtoEntradaCrearSolicitudCita.getEspecialidad());
        HorarioDia horarioDia = fabricaHorarioDiaModelo.buscarCrear(dtoEntradaCrearSolicitudCita.getHorarioDia());

        return new SolicitudCita(
                dtoEntradaCrearSolicitudCita.getId(),
                usuario,
                medico, especialidad,
                horarioDia,
                dtoEntradaCrearSolicitudCita.getFechaSolicitud(),
                dtoEntradaCrearSolicitudCita.getFechaCita()
        );
    }

    public DtoSolicitudCita crear(SolicitudCita solicitudCita){
        return new DtoSolicitudCita(
                solicitudCita.getId(),
                solicitudCita.getMedico().getId(),
                solicitudCita.getUsuario().getId(),
                solicitudCita.getEspecialidad().getId(),
                solicitudCita.getHorarioDia().getId(),
                solicitudCita.getFechaSolicitud(),
                solicitudCita.getFechaCita(),
                solicitudCita.getValor(),
                solicitudCita.isDescuentoPorMenorEdad()
        );
    }
}
