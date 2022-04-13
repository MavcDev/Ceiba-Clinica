package com.ceiba.solicitud.puerto.dao;

import com.ceiba.solicitud.modelo.dto.DtoPresentacionSolicitud;

import java.util.List;

public interface DaoSolicitud {

    /**
     * Permite buscar solicitudes de cita por id del usuario
     * @Param idUsuario
     * @return las solicitudes del usuario
     */
    List<DtoPresentacionSolicitud> buscarPorIdUsuario(Long idUsuario);
}
