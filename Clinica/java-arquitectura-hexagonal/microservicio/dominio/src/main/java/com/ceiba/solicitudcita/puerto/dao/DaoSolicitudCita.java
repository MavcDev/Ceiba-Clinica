package com.ceiba.solicitudcita.puerto.dao;

import com.ceiba.solicitudcita.modelo.dto.DtoPresentacionSolicitudCita;

import java.util.List;

public interface DaoSolicitudCita {

    /**
     * Permite buscar solicitudes de cita por id del usuario
     * @Param idUsuario
     * @return las solicitudes del usuario
     */
    List<DtoPresentacionSolicitudCita> buscarPorIdUsuario(Long idUsuario);
}
