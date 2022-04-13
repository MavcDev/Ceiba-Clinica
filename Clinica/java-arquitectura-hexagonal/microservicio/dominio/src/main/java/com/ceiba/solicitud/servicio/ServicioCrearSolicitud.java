package com.ceiba.solicitud.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.solicitud.modelo.fabrica.FabricaSolicitudModelo;
import com.ceiba.solicitud.modelo.dto.DtoSolicitud;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearSolicitud {

    public static final String EL_USUARIO_NO_EXISTE = "El usuario no existe";

    private final RepositorioSolicitud repositorioSolicitud;
    private final RepositorioUsuario repositorioUsuario;
    private final FabricaSolicitudModelo fabricaSolicitudModelo;

    public ServicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud, RepositorioUsuario repositorioUsuario) {
        this.repositorioSolicitud = repositorioSolicitud;
        this.repositorioUsuario = repositorioUsuario;
        this.fabricaSolicitudModelo = new FabricaSolicitudModelo();
    }

    public Long ejecutar(Solicitud solicitud) {
        existeUsuarioPorId(solicitud.getUsuario().getId());
        solicitud.validarSiExisteSolicitudCitaPorMedicoFechaHorario(repositorioSolicitud);
        solicitud.validarSiExisteSolicitudCitaPorUsuarioFecha(repositorioSolicitud);
        solicitud.calcularValorCita();
        DtoSolicitud dtoSolicitudNuevo = fabricaSolicitudModelo.crear(solicitud);
        return this.repositorioSolicitud.crear(dtoSolicitudNuevo);
    }

    private void existeUsuarioPorId(Long id){
        boolean existe = repositorioUsuario.existePorId(id);
        if(!existe){
            throw new ExcepcionSinDatos(EL_USUARIO_NO_EXISTE);
        }
    }
}
