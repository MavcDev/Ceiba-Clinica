package com.ceiba.solicitudcita.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCita {
    private Long id;
    private Long idMedico;
    private Long idUsuario;
    private Long idEspecialidad;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;
    private Long idHorario;
}
