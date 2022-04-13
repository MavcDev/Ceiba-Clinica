package com.ceiba.solicitud.puerto.repositorio;

import com.ceiba.solicitud.modelo.dto.DtoSolicitud;

import java.time.LocalDate;

public interface RepositorioSolicitud {

    /**
     * Permite crear una solicitud de cita
     * @param dtoSolicitud
     * @return el id generado
     */
    Long crear(DtoSolicitud dtoSolicitud);

    /**
     * Permite validar si un usuario tiene una solcitud de cita en una fecha
     * @Param idUsuario
     * @Param fechaCita
     * @return si existe o no
     */
    Boolean existeSolicitudCitaPorUsuarioFecha(Long idUsuario, LocalDate fechaCita);

    /**
     * Permite validar si un medico tiene una solicitud de cita en la fecha y hora
     * @Param idMedico
     * @Param fechaCita
     * @return si existe o no
     */
    Boolean existeSolcitudCitaPorMedicoFechaHorario(Long idMedico, LocalDate fechaCita, Long idHorario);
}
