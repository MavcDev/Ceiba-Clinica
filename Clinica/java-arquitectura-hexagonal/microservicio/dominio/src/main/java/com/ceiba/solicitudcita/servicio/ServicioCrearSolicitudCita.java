package com.ceiba.solicitudcita.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.especialidad.modelo.fabrica.FabricaEspecialidadModelo;
import com.ceiba.especialidad.puerto.repositorio.RepositorioEspecialidad;
import com.ceiba.horariodia.modelo.fabrica.FabricaHorarioDiaModelo;
import com.ceiba.horariodia.puerto.repositorio.RepositorioHorarioDia;
import com.ceiba.medico.modelo.fabrica.FabricaMedicoModelo;
import com.ceiba.medico.puerto.repositorio.RepositorioMedico;
import com.ceiba.solicitudcita.modelo.dto.DtoEntradaCrearSolicitudCita;
import com.ceiba.solicitudcita.modelo.fabrica.FabricaSolicitudCitaModelo;
import com.ceiba.solicitudcita.modelo.dto.DtoSolicitudCita;
import com.ceiba.solicitudcita.modelo.entidad.SolicitudCita;
import com.ceiba.solicitudcita.puerto.repositorio.RepositorioSolicitudCita;
import com.ceiba.usuario.modelo.fabrica.FabricaUsuarioModelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearSolicitudCita {

    public static final String EL_USUARIO_NO_EXISTE = "El usuario no existe";

    private final RepositorioSolicitudCita repositorioSolicitudCita;
    private final RepositorioUsuario repositorioUsuario;
    private final FabricaSolicitudCitaModelo fabricaSolicitudCitaModelo;

    public ServicioCrearSolicitudCita(RepositorioSolicitudCita repositorioSolicitudCita,
                                      RepositorioUsuario repositorioUsuario,
                                      RepositorioMedico repositorioMedico,
                                      RepositorioEspecialidad repositorioEspecialidad,
                                      RepositorioHorarioDia repositorioHorarioDia) {

        this.repositorioSolicitudCita = repositorioSolicitudCita;
        this.repositorioUsuario = repositorioUsuario;
        this.fabricaSolicitudCitaModelo = new FabricaSolicitudCitaModelo(
                new FabricaUsuarioModelo(repositorioUsuario),
                new FabricaMedicoModelo(repositorioMedico, new FabricaEspecialidadModelo(repositorioEspecialidad)),
                new FabricaEspecialidadModelo(repositorioEspecialidad),
                new FabricaHorarioDiaModelo(repositorioHorarioDia));
    }

    public Long ejecutar(DtoEntradaCrearSolicitudCita dtoEntradaSolicitudCita) {
        existeUsuarioPorId(dtoEntradaSolicitudCita.getUsuario());

        SolicitudCita solicitudCita = fabricaSolicitudCitaModelo.crear(dtoEntradaSolicitudCita);
        solicitudCita.validarSiExisteSolicitudCitaPorMedicoFechaHorario(repositorioSolicitudCita);
        solicitudCita.validarSiExisteSolicitudCitaPorUsuarioFecha(repositorioSolicitudCita);
        solicitudCita.calcularValorCita();
        DtoSolicitudCita dtoSolicitudCitaNuevo = fabricaSolicitudCitaModelo.crear(solicitudCita);
        return this.repositorioSolicitudCita.crear(dtoSolicitudCitaNuevo);
    }

    private void existeUsuarioPorId(Long id){
        boolean existe = repositorioUsuario.existePorId(id);
        if(!existe){
            throw new ExcepcionSinDatos(EL_USUARIO_NO_EXISTE);
        }
    }
}
