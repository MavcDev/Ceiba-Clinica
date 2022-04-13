package com.ceiba.solicitud.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionSolicitudCita;
import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Solicitud {

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

    public static final String FORMATO_FECHA = "dd/MM/yyyy";

    public static final BigDecimal DESCUENTO_50_PORCIENTO = BigDecimal.valueOf(0.5);

    private Long id;
    private Usuario usuario;
    private Medico medico;
    private Especialidad especialidad;
    private Horario horario;
    private LocalDateTime fechaSolicitud;
    private LocalDate fechaCita;
    private BigDecimal valor;
    private boolean descuentoPorMenorEdad;

    public Solicitud(Long id, Usuario usuario, Medico medico, Especialidad especialidad, Horario horario, LocalDateTime fechaSolicitud, LocalDate fechaCita){
        validarObligatorio(usuario, SE_DEBE_INGRESAR_EL_USUARIO);
        validarObligatorio(medico, SE_DEBE_INGRESAR_EL_MEDICO);
        validarObligatorio(especialidad, SE_DEBE_INGRESAR_LA_ESPECIALIDAD);
        validarObligatorio(horario, SE_DEBE_INGRESAR_EL_HORARIO);
        validarFechaSolicitud(fechaSolicitud);
        validarFechaCita(fechaCita);

        this.id = id;
        this.usuario = usuario;
        this.medico = medico;
        this.especialidad = especialidad;
        this.horario = horario;
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

    public void validarSiExisteSolicitudCitaPorMedicoFechaHorario(RepositorioSolicitud repositorioSolicitud){
        boolean existe = repositorioSolicitud.existeSolcitudCitaPorMedicoFechaHorario(medico.getId(), fechaCita, horario.getId());
        if(existe){
            throw new ExcepcionSolicitudCita(
                    String.format(EL_MEDICO_YA_TIENE_SOLICITUD_FECHA_HORA,
                            medico.getNombreCompleto(),
                            formatearFechaCita(),
                            horario.getHoraCompleta()
                    )
            );
        }
    }

    public void validarSiExisteSolicitudCitaPorUsuarioFecha(RepositorioSolicitud repositorioSolicitud){
        boolean existe = repositorioSolicitud.existeSolicitudCitaPorUsuarioFecha(usuario.getId(), fechaCita);
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
             valorEspecialidad = valorEspecialidad.multiply(DESCUENTO_50_PORCIENTO);
        }
        this.valor = valorEspecialidad;
    }

    public String formatearFechaCita(){
        return this.fechaCita.format(DateTimeFormatter.ofPattern(FORMATO_FECHA));
    }
}
