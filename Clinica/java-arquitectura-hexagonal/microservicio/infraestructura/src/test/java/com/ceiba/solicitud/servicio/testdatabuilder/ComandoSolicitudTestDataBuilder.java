package com.ceiba.solicitud.servicio.testdatabuilder;

import com.ceiba.solicitud.comando.ComandoSolicitud;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoSolicitudTestDataBuilder {
    private Long id;
    private Long idMedico;
    private Long idUsuario;
    private Long idEspecialidad;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;
    private Long idHorario;

    public ComandoSolicitudTestDataBuilder(){
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

    public ComandoSolicitudTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoSolicitudTestDataBuilder conIdMedico(Long idMedico) {
        this.idMedico = idMedico;
        return this;
    }

    public ComandoSolicitudTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ComandoSolicitudTestDataBuilder conIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
        return this;
    }

    public ComandoSolicitudTestDataBuilder conIdHorarioDia(Long idHorarioDia) {
        this.idHorario = idHorarioDia;
        return this;
    }

    public ComandoSolicitudTestDataBuilder conFechaSolicitud(LocalDateTime fechaSolicitud){
        this.fechaSolicitud = fechaSolicitud;
        return this;
    }

    public ComandoSolicitudTestDataBuilder conFechaCita(LocalDate fechaCita){
        this.fechaCita = fechaCita;
        return this;
    }

    public ComandoSolicitud build(){
        return new ComandoSolicitud(id, idMedico, idUsuario, idEspecialidad, fechaSolicitud, fechaCita, idHorario);
    }
}
