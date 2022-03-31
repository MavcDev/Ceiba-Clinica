package com.ceiba.solicitudcita.puerto.repositorio;

import com.ceiba.solicitudcita.modelo.dto.DtoSolicitudCita;

import java.time.LocalDate;

public interface RepositorioSolicitudCita {

    /**
     * Permite crear una solicitud de cita
     * @param dtoSolicitudCita
     * @return el id generado
     */
    Long crear(DtoSolicitudCita dtoSolicitudCita);

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
