package com.ceiba.solicitudcita.servicio.testdatabuilder;

import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.especialidad.servicio.testdatabuilder.EspecialidadTestDataBuilder;
import com.ceiba.horariodia.modelo.entidad.HorarioDia;
import com.ceiba.horariodia.servicio.testdatabuilder.HorarioDiaTestDataBuilder;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.medico.servicio.testdatabuilder.MedicoTestDataBuilder;
import com.ceiba.solicitudcita.modelo.entidad.SolicitudCita;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SolicitudCitaTestDataBuilder {

    private Long id;
    private Usuario usuario;
    private Medico medico;
    private Especialidad especialidad;
    private HorarioDia horarioDia;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;

    public SolicitudCitaTestDataBuilder(){
        usuario = new UsuarioTestDataBuilder().conId(1L).build();
        medico = new MedicoTestDataBuilder().conId(1L).build();
        especialidad = new EspecialidadTestDataBuilder().conId(1L).build();
        horarioDia = new HorarioDiaTestDataBuilder().conId(1L).build();
        fechaSolicitud = LocalDateTime.now();
        fechaCita = LocalDate.now().plusDays(1L);
    }

    public SolicitudCitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public SolicitudCitaTestDataBuilder conUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public SolicitudCitaTestDataBuilder conMedico(Medico medico) {
        this.medico = medico;
        return this;
    }

    public SolicitudCitaTestDataBuilder conEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
        return this;
    }

    public SolicitudCitaTestDataBuilder conHorarioDia(HorarioDia horarioDia) {
        this.horarioDia = horarioDia;
        return this;
    }

    public SolicitudCitaTestDataBuilder conFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
        return this;
    }

    public SolicitudCitaTestDataBuilder conFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
        return this;
    }

    public SolicitudCita build(){
        return new SolicitudCita(id, usuario, medico, especialidad, horarioDia, fechaSolicitud, fechaCita);
    }
}
