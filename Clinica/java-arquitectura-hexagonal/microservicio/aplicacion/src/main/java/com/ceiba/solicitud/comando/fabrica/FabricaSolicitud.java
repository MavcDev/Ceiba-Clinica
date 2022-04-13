package com.ceiba.solicitud.comando.fabrica;

import com.ceiba.especialidad.fabrica.FabricaEspecialidad;
import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.horario.fabrica.FabricaHorario;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.medico.fabrica.FabricaMedico;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitud {

    private final FabricaUsuario fabricaUsuario;
    private final FabricaMedico fabricaMedico;
    private final FabricaEspecialidad fabricaEspecialidad;
    private final FabricaHorario fabricaHorario;

    public FabricaSolicitud(FabricaUsuario fabricaUsuario, FabricaMedico fabricaMedico, FabricaEspecialidad fabricaEspecialidad, FabricaHorario fabricaHorario) {
        this.fabricaUsuario = fabricaUsuario;
        this.fabricaMedico = fabricaMedico;
        this.fabricaEspecialidad = fabricaEspecialidad;
        this.fabricaHorario = fabricaHorario;
    }

    public Solicitud crear(ComandoSolicitud comandoSolicitud){
        Usuario usuario = fabricaUsuario.buscarCrear(comandoSolicitud.getIdUsuario());
        Medico medico = fabricaMedico.buscarCrear(comandoSolicitud.getIdMedico());
        Especialidad especialidad = fabricaEspecialidad.buscarCrear(comandoSolicitud.getIdEspecialidad());
        Horario horario = fabricaHorario.buscarCrear(comandoSolicitud.getIdHorario());
        return new Solicitud(
                comandoSolicitud.getId(),
                usuario,
                medico, especialidad,
                horario,
                comandoSolicitud.getFechaSolicitud(),
                comandoSolicitud.getFechaCita()
        );
    }
}
