package com.ceiba.medico.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.medico.servicio.testdatabuilder.MedicoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDate;

import static com.ceiba.medico.modelo.entidad.Medico.SE_DEBE_INGRESAR_LA_ESPECIALIDAD;
import static com.ceiba.persona.modelo.entidad.Persona.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MedicoTest {

    @Test
    @DisplayName("Deberia crear correctamente el medico")
    void deberiaCrearCorrectamenteElUsusuario() {
        LocalDate fechaNacimiento = LocalDate.from(LocalDate.of(1991, 12, 20));
        Medico medico = new MedicoTestDataBuilder().conId(1L).build();
        assertEquals(1, medico.getId());
        assertEquals("1117522448", medico.getIdentificacion());
        assertEquals("Camilo Andres", medico.getNombres());
        assertEquals("Perez", medico.getPrimerApellido());
        assertEquals("Sanchez", medico.getSegundoApellido());
        assertEquals(fechaNacimiento, medico.getFechaNacimiento());
        assertNotNull(medico.getEspecialidad());
        assertEquals("Camilo Andres Perez Sanchez", medico.getNombreCompleto());
    }

    @Test
    @DisplayName("Deberia crear correctamente el medico sin segundo apellido")
    void deberiaCrearCorrectamenteElMedicoSinSegundoApellido() {
        LocalDate fechaNacimiento = LocalDate.from(LocalDate.of(1991, 12, 20));
        Medico medico = new MedicoTestDataBuilder().conId(1L).conSegundoApellido(null).build();

        assertEquals(1, medico.getId());
        assertEquals("1117522448", medico.getIdentificacion());
        assertEquals("Camilo Andres", medico.getNombres());
        assertEquals("Perez", medico.getPrimerApellido());
        Assert.isNull(medico.getSegundoApellido(), "Sin segundo apellido");
        assertEquals(fechaNacimiento, medico.getFechaNacimiento());
        assertNotNull(medico.getEspecialidad());
        assertEquals("Camilo Andres Perez", medico.getNombreCompleto());
    }

    // Identificacion

    @Test
    @DisplayName("Deberia fallar sin identificacion de medico")
    void deberiaFallarSinIdentificacionDeMedico() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conIdentificacion(null);
        probarExcepcionValorObligatorio(medicoTestDataBuilder, SE_DEBE_INGRESAR_LA_IDENTIFICACION);
    }

    @Test
    @DisplayName("Deberia fallar longitud corta de indetificacion de medico")
    void deberiaFallarConLongituCortaIdentificacionDeMedico() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conIdentificacion("12345");
        probarExcepcionLongitudValor(medicoTestDataBuilder, String.format(LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MINIMA_O_IGUAL_A, LONGITUD_MINIMA_IDENTIFICACION));
    }

    @Test
    @DisplayName("Deberia fallar longitud larga de indetificacion de medico")
    void deberiaFallarConLongituLargaIdentificacionDeMedico() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conIdentificacion("123456789101");
        probarExcepcionLongitudValor(medicoTestDataBuilder, String.format(LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_IDENTIFICACION));
    }

    @Test
    @DisplayName("Deberia fallar solo ceros de indetificacion de medico")
    void deberiaFallarConSoloCerosEnIdentificacionDeMedico() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conIdentificacion("00000000000");
        probarExcepcionValorInvalido(medicoTestDataBuilder, LA_IDENTIFICACION_NO_DEBER_SER_SOLO_CEROS);
    }

    @Test
    @DisplayName("Deberia fallar espacio en blanco de indetificacion de medico")
    void deberiaFallarConIdentificacionDeMedicoEnBlanco() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conIdentificacion("          ");
        probarExcepcionValorInvalido(medicoTestDataBuilder, LA_IDENTIFICACION_SOLO_TIENE_ESPACIOS_BLANCOS);
    }

    // Nombre

    @Test
    @DisplayName("Deberia fallar sin nombre de medico")
    void deberiaFallarSinNombreDeMedico() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conNombres(null);
        probarExcepcionValorObligatorio(medicoTestDataBuilder, SE_DEBE_INGRESAR_EL_NOMBRE);
    }

    @Test
    @DisplayName("Deberia fallar espacio en blanco de nombre  de medico")
    void deberiaFallarConNombreDeMedicoEnBlanco() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conNombres(" ");
        probarExcepcionValorInvalido(medicoTestDataBuilder, EL_NOMBRE_SOLO_TIENE_ESPACIOS_BLANCOS);
    }

    @Test
    @DisplayName("Deberia fallar longitud larga de nombre  de medico")
    void deberiaFallarConNombreDeMedicoMuyLargo() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conNombres("123456789124578895623102457889562311454454545454120");
        probarExcepcionLongitudValor(medicoTestDataBuilder, String.format(EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE));
    }

    // Primer Apellido

    @Test
    @DisplayName("Deberia fallar sin primer apellido de medico")
    void deberiaFallarSinPrimerApellidoDeMedico() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conPrimerApellido(null);
        probarExcepcionValorObligatorio(medicoTestDataBuilder, SE_DEBE_INGRESAR_EL_PRIMER_APELLIDO);
    }

    @Test
    @DisplayName("Deberia fallar espacio en blancos de primer apellido de medico")
    void deberiaFallarConPrimerApellidoDeMedicoEnBlanco() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conPrimerApellido(" ");
        probarExcepcionValorInvalido(medicoTestDataBuilder, EL_PRIMER_APELLIDO_SOLO_TIENE_ESPACIOS_BLANCOS);
    }

    @Test
    @DisplayName("Deberia fallar longitud larga de primer apellido de medico")
    void deberiaFallarConPrimerApellidoDeMedicoMuyLargo() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conPrimerApellido("123456789124578895623102457889562311454454545454120");
        probarExcepcionLongitudValor(medicoTestDataBuilder, String.format(EL_PRIMER_APELLIDO_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE));
    }

    // Segundo Apellido

    @Test
    @DisplayName("Deberia fallar espacio en blanco de segundo apellido de medico")
    void deberiaFallarConSegundoApellidoDeMedicoEnBlanco() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conSegundoApellido(" ");
        probarExcepcionValorInvalido(medicoTestDataBuilder, EL_SEGUNDO_APELLIDO_SOLO_TIENE_ESPACIOS_BLANCOS);
    }

    @Test
    @DisplayName("Deberia fallar longitud larga de segundo apellido de medico")
    void deberiaFallarConSegundoApellidoDeMedicoMuyLargo() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conSegundoApellido("123456789124578895623102457889562311454454545454120");
        probarExcepcionLongitudValor(medicoTestDataBuilder, String.format(EL_SEGUNDO_APELLIDO_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE));
    }

    // Fecha de nacimiento

    @Test
    @DisplayName("Deberia fallar sin fecha de nacimiento de medico")
    void deberiaFallarSinFechaNacimientoDeMedico() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conFechaNacimiento(null);
        probarExcepcionValorObligatorio(medicoTestDataBuilder, SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO);
    }

    @Test
    @DisplayName("Deberia fallar fecha de nacimiento es posterior a la fecha actual")
    void deberiaFallarFechaNacimientoMayorHoyDeMedico() {
        LocalDate fechaNacimientoFutura = LocalDate.now().plusDays(1);
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conFechaNacimiento(fechaNacimientoFutura);
        probarExcepcionValorInvalido(medicoTestDataBuilder, LA_FECHA_NACIMIENTO_MAYOR_FECHA_ACTUAL);
    }

    // Especialidad

    @Test
    @DisplayName("Deberia fallar sin especialidad de medico")
    void deberiaFallarSinEspecialidadDeMedico() {
        MedicoTestDataBuilder medicoTestDataBuilder = new MedicoTestDataBuilder().conEspecialidad(null);
        probarExcepcionValorObligatorio(medicoTestDataBuilder, SE_DEBE_INGRESAR_LA_ESPECIALIDAD);
    }

    void probarExcepcionValorInvalido(MedicoTestDataBuilder medicoTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    medicoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, mensajeExcepcion);
    }

    void probarExcepcionValorObligatorio(MedicoTestDataBuilder medicoTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    medicoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, mensajeExcepcion);
    }

    void probarExcepcionLongitudValor(MedicoTestDataBuilder medicoTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    medicoTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, mensajeExcepcion);
    }
}
