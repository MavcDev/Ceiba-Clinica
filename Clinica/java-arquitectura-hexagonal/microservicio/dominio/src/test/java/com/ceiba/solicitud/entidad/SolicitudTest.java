package com.ceiba.solicitud.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSolicitudCita;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.servicio.testdatabuilder.SolicitudCitaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ceiba.solicitud.modelo.entidad.Solicitud.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolicitudTest {

    @Test
    @DisplayName("Deberia crear correctamente la solicitud cita")
    void deberiaCrearCorrectamenteLaSolicitudCita() {
        Solicitud solicitud = new SolicitudCitaTestDataBuilder().conId(1L).build();
        assertEquals(1L, solicitud.getId());
        assertEquals(1L, solicitud.getMedico().getId());
        assertEquals(1L, solicitud.getUsuario().getId());
        assertEquals(1L, solicitud.getEspecialidad().getId());
        assertEquals(1L, solicitud.getHorario().getId());
        assertEquals(LocalDate.now(), solicitud.getFechaSolicitud().toLocalDate());
        LocalDate fechaCita = LocalDate.now().plusDays(1L);
        while (fechaCita.getDayOfWeek() == DayOfWeek.SATURDAY || fechaCita.getDayOfWeek() == DayOfWeek.SUNDAY){
            fechaCita = fechaCita.plusDays(1);
        }
        assertEquals(fechaCita, solicitud.getFechaCita());
    }

    @Test
    @DisplayName("Deberia fallar sin usuario de la solicitud cita")
    void deberiaFallarSinUsuarioDeSolicitudCita() {
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conUsuario(null);
        probarExcepcionValorObligatorio(solicitudCitaTestDataBuilder, SE_DEBE_INGRESAR_EL_USUARIO);
    }

    @Test
    @DisplayName("Deberia fallar sin medico de la solicitud cita")
    void deberiaFallarSinMedicoDeSolicitudCita() {
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conMedico(null);
        probarExcepcionValorObligatorio(solicitudCitaTestDataBuilder, SE_DEBE_INGRESAR_EL_MEDICO);
    }

    @Test
    @DisplayName("Deberia fallar sin especialidad de la solicitud cita")
    void deberiaFallarSinEspecialidadDeSolicitudCita() {
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conEspecialidad(null);
        probarExcepcionValorObligatorio(solicitudCitaTestDataBuilder, SE_DEBE_INGRESAR_LA_ESPECIALIDAD);
    }

    @Test
    @DisplayName("Deberia fallar sin horarrio de la solicitud cita")
    void deberiaFallarSinHorariaDiaDeSolicitudCita() {
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conHorarioDia(null);
        probarExcepcionValorObligatorio(solicitudCitaTestDataBuilder, SE_DEBE_INGRESAR_EL_HORARIO);
    }

    // Fecha Solicitud

    @Test
    @DisplayName("Deberia fallar sin fecha de solicitud de la solicitud cita")
    void deberiaFallarSinFechaSolicitudDeSolicitudCita() {
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conFechaSolicitud(null);
        probarExcepcionValorObligatorio(solicitudCitaTestDataBuilder, SE_DEBE_INGRESAR_LA_FECHA_SOLICITUD);
    }

    @Test
    @DisplayName("Deberia fallar fecha de solicitud posterior a la actual de la solicitud cita")
    void deberiaFallarFechaSolicitudFuturaDeSolicitudCita() {
        LocalDateTime fechaSolicitud = LocalDateTime.now().plusDays(1L);
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conFechaSolicitud(fechaSolicitud);
        probarExcepcionValorInvalido(solicitudCitaTestDataBuilder, LA_FECHA_SOLICITUD_MAYOR_FECHA_ACTUAL);
    }

    @Test
    @DisplayName("Deberia fallar fecha de solicitud inferior a la actual de la solicitud cita")
    void deberiaFallarFechaSolicitudPasadaDeSolicitudCita() {
        LocalDateTime fechaSolicitud = LocalDateTime.now().minusDays(1L);
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conFechaSolicitud(fechaSolicitud);
        probarExcepcionValorInvalido(solicitudCitaTestDataBuilder, LA_FECHA_SOLICITUD_MENOR_FECHA_ACTUAL);
    }

    // Fecha cita

    @Test
    @DisplayName("Deberia fallar sin fecha cita de la solicitud cita")
    void deberiaFallarSinFechaCitaDeSolicitudCita() {
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conFechaCita(null);
        probarExcepcionValorObligatorio(solicitudCitaTestDataBuilder, SE_DEBE_INGRESAR_LA_FECHA_CITA);
    }

    @Test
    @DisplayName("Deberia fallar fecha cita es igual a la fecha actual de la solicitud cita")
    void deberiaFallarFechaCitaEsFechaActualDeSolicitudCita() {
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conFechaCita(LocalDate.now());
        probarExcepcionValorInvalido(solicitudCitaTestDataBuilder, LA_FECHA_CITA_ES_IGUAL_FECHA_ACTUAL);
    }

    @Test
    @DisplayName("Deberia fallar fecha cita es inferior a la fecha actual de la solicitud cita")
    void deberiaFallarFechaCitaEsPasadaDeSolicitudCita() {
        LocalDate fechaCita = LocalDate.now().minusDays(1L);
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conFechaCita(fechaCita);
        probarExcepcionValorInvalido(solicitudCitaTestDataBuilder, LA_FECHA_CITA_MENOR_FECHA_ACTUAL);
    }

    @Test
    @DisplayName("Deberia fallar fecha cita es un sabado o domiengo")
    void deberiaFallarFechaCitaEsSabadoODomingoDeSolicitudCita() {
        LocalDate fechaCita = LocalDate.from(LocalDate.of(2022, 4, 30));
        SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder = new SolicitudCitaTestDataBuilder().conFechaCita(fechaCita);
        probarExcepcionSolicitudCita(solicitudCitaTestDataBuilder, String.format(LA_FECHA_DE_LA_CITA_ES_SABADO_O_DOMINGO, fechaCita.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }

    void probarExcepcionValorInvalido(SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    solicitudCitaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, mensajeExcepcion);
    }

    void probarExcepcionValorObligatorio(SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    solicitudCitaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, mensajeExcepcion);
    }

    void probarExcepcionSolicitudCita(SolicitudCitaTestDataBuilder solicitudCitaTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    solicitudCitaTestDataBuilder.build();
                },
                ExcepcionSolicitudCita.class, mensajeExcepcion);
    }
}
