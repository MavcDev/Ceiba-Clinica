package com.ceiba.solicitudcita.servicio.testdatabuilder;

import com.ceiba.solicitudcita.comando.ComandoSolicitudCita;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoSolicitudCitaTestDataBuilder {
    private Long id;
    private Long idMedico;
    private Long idUsuario;
    private Long idEspecialidad;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;
    private Long idHorario;

    public ComandoSolicitudCitaTestDataBuilder(){
        idMedico = 1L;
        idUsuario = 1L;
        idEspecialidad = 1L;
        fechaSolicitud = LocalDateTime.now();
        fechaCita = LocalDate.now().plusDays(1);
        while (fechaCita.getDayOfWeek() == DayOfWeek.SATURDAY || fechaCita.getDayOfWeek() == DayOfWeek.SUNDAY){
            fechaCita = fechaCita.plusDays(1);
        }
        idHorario = 1L;
    }

    public ComandoSolicitudCitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoSolicitudCitaTestDataBuilder conIdMedico(Long idMedico) {
        this.idMedico = idMedico;
        return this;
    }

    public ComandoSolicitudCitaTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ComandoSolicitudCitaTestDataBuilder conIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
        return this;
    }

    public ComandoSolicitudCitaTestDataBuilder conIdHorarioDia(Long idHorarioDia) {
        this.idHorario = idHorarioDia;
        return this;
    }

    public ComandoSolicitudCitaTestDataBuilder conFechaSolicitud(LocalDateTime fechaSolicitud){
        this.fechaSolicitud = fechaSolicitud;
        return this;
    }

    public ComandoSolicitudCitaTestDataBuilder conFechaCita(LocalDate fechaCita){
        this.fechaCita = fechaCita;
        return this;
    }

    public ComandoSolicitudCita build(){
        return new ComandoSolicitudCita(id, idMedico, idUsuario, idEspecialidad, fechaSolicitud, fechaCita, idHorario);
    }
}
