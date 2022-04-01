package com.ceiba.solicitudcita.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionSolicitudCita;
import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.horariodia.modelo.entidad.HorarioDia;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.solicitudcita.puerto.repositorio.RepositorioSolicitudCita;
import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class SolicitudCita {

    public static final String SE_DEBE_INGRESAR_EL_USUARIO = "Se debe ingresar el usuario";
    public static final String SE_DEBE_INGRESAR_EL_MEDICO = "Se debe ingresar el medico";
    public static final String SE_DEBE_INGRESAR_LA_ESPECIALIDAD = "Se debe ingresar la especialidad";
    public static final String SE_DEBE_INGRESAR_EL_HORARIO = "Se debe ingresar el horario";

    public static final String SE_DEBE_INGRESAR_LA_FECHA_SOLICITUD = "Se debe ingresar la fecha solicitud";
    public static final String LA_FECHA_SOLICITUD_MAYOR_FECHA_ACTUAL = "La fecha de solicitud es mayor a la fecha actual";
    public static final String LA_FECHA_SOLICITUD_MENOR_FECHA_ACTUAL = "La fecha de solicitud es menor a la fecha actual";

    public static final String SE_DEBE_INGRESAR_LA_FECHA_CITA = "Se debe ingresar la fecha de la cita";
    public static final String LA_FECHA_CITA_MENOR_FECHA_ACTUAL = "La fecha de la cita es menor a la fecha actual";
    public static final String LA_FECHA_CITA_ES_IGUAL_FECHA_ACTUAL = "La fecha de la cita es igual a la fecha actual";
    public static final String LA_FECHA_DE_LA_CITA_ES_SABADO_O_DOMINGO = "La fecha (%s) de la cita es un sabado o un domingo";

    public static final String EL_MEDICO_YA_TIENE_SOLICITUD_FECHA_HORA = "El medico (%s) ya tiene una solicitud cita en le fecha (%s) y hora (%s)";
    public static final String EL_USUARIO_YA_TIENE_SOLICITUD_FECHA = "El usuario (%s) ya tiene una solicitud en la fecha (%s)";

    private Long id;
    private Usuario usuario;
    private Medico medico;
    private Especialidad especialidad;
    private HorarioDia horarioDia;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;
    private BigDecimal valor;
    private boolean descuentoPorMenorEdad;

    public SolicitudCita(Long id, Usuario usuario, Medico medico, Especialidad especialidad, HorarioDia horarioDia, LocalDateTime fechaSolicitud, LocalDate fechaCita){
        validarObligatorio(usuario, SE_DEBE_INGRESAR_EL_USUARIO);
        validarObligatorio(medico, SE_DEBE_INGRESAR_EL_MEDICO);
        validarObligatorio(especialidad, SE_DEBE_INGRESAR_LA_ESPECIALIDAD);
        validarObligatorio(horarioDia, SE_DEBE_INGRESAR_EL_HORARIO);
        validarFechaSolicitud(fechaSolicitud);
        validarFechaCita(fechaCita);

        this.id = id;
        this.usuario = usuario;
        this.medico = medico;
        this.especialidad = especialidad;
        this.horarioDia = horarioDia;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaCita = fechaCita;
    }

    private void validarFechaSolicitud(LocalDateTime fechaSolicitud){
        validarObligatorio(fechaSolicitud, SE_DEBE_INGRESAR_LA_FECHA_SOLICITUD);
        validarFechaMayorActual(fechaSolicitud.toLocalDate(), LA_FECHA_SOLICITUD_MAYOR_FECHA_ACTUAL);
        validarFechaMenorActual(fechaSolicitud.toLocalDate(), LA_FECHA_SOLICITUD_MENOR_FECHA_ACTUAL);
    }

    private void validarFechaCita(LocalDate fechaCita){
        validarObligatorio(fechaCita, SE_DEBE_INGRESAR_LA_FECHA_CITA);
        validarFechaMenorActual(fechaCita, LA_FECHA_CITA_MENOR_FECHA_ACTUAL);
        validarFechaEsIgualActual(fechaCita, LA_FECHA_CITA_ES_IGUAL_FECHA_ACTUAL);
        validarFechaCitaSabadoDomingo(fechaCita);
    }

    public void validarSiExisteSolicitudCitaPorMedicoFechaHorario(RepositorioSolicitudCita repositorioSolicitudCita){
        boolean existe = repositorioSolicitudCita.existeSolcitudCitaPorMedicoFechaHorario(medico.getId(), fechaCita, horarioDia.getId());
        if(existe){
            throw new ExcepcionSolicitudCita(
                    String.format(EL_MEDICO_YA_TIENE_SOLICITUD_FECHA_HORA,
                            medico.getNombreCompleto(),
                            formatearFechaCita(),
                            horarioDia.getHoraCompleta()
                    )
            );
        }
    }

    public void validarSiExisteSolicitudCitaPorUsuarioFecha(RepositorioSolicitudCita repositorioSolicitudCita){
        boolean existe = repositorioSolicitudCita.existeSolicitudCitaPorUsuarioFecha(usuario.getId(), fechaCita);
        if(existe){
            throw new ExcepcionSolicitudCita(
                    String.format(EL_USUARIO_YA_TIENE_SOLICITUD_FECHA,
                            usuario.getNombreCompleto(),
                            formatearFechaCita()
                    )
            );
        }
    }

    private void validarFechaCitaSabadoDomingo(LocalDate fechaCita){
        if(esFechaCitaSabadoDomingo(fechaCita)){
            this.fechaCita = fechaCita;
            throw new ExcepcionSolicitudCita(String.format(LA_FECHA_DE_LA_CITA_ES_SABADO_O_DOMINGO, formatearFechaCita()));
        }
    }

    private boolean esFechaCitaSabadoDomingo(LocalDate fechaCita){
        DayOfWeek diaSemana = fechaCita.getDayOfWeek();
        return diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY;
    }

    public void calcularValorCita(){
        BigDecimal valorEspecialidad = especialidad.getValor();
        this.descuentoPorMenorEdad = usuario.esMenorDeEdad();
        if(descuentoPorMenorEdad){
             valorEspecialidad = valorEspecialidad.multiply(BigDecimal.valueOf(0.5));
        }
        this.valor = valorEspecialidad;
    }

    public String formatearFechaCita(){
        return this.fechaCita.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
