package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.persona.modelo.entidad.Persona.*;
import static com.ceiba.usuario.modelo.entidad.Usuario.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsuarioTest {

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElUsusuario() {
        LocalDate fechaNacimiento = LocalDate.from(LocalDate.of(1991, 12, 20));
        LocalDateTime fechaCreacion = LocalDateTime.now();
        Usuario usuario = new UsuarioTestDataBuilder().conFechaCreacion(fechaCreacion).conId(1L).build();

        assertEquals(1, usuario.getId());
        assertEquals("Camilo Andres", usuario.getNombres());
        assertEquals("1117522448", usuario.getIdentificacion());
        assertEquals("Perez", usuario.getPrimerApellido());
        assertEquals("Sanchez", usuario.getSegundoApellido());
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
        assertEquals(fechaCreacion, usuario.getFechaCreacion());
    }

    @Test
    @DisplayName("Deberia crear correctamente el usuario sin segundo apellido")
    void deberiaCrearCorrectamenteElUsusuarioSinSegundoApellido() {
        LocalDate fechaNacimiento = LocalDate.from(LocalDate.of(1991, 12, 20));
        LocalDateTime fechaCreacion = LocalDateTime.now();
        Usuario usuario = new UsuarioTestDataBuilder().conFechaCreacion(fechaCreacion).conSegundoApellido(null).conId(1L).build();

        assertEquals(1, usuario.getId());
        assertEquals("Camilo Andres", usuario.getNombres());
        assertEquals("1117522448", usuario.getIdentificacion());
        assertEquals("Perez", usuario.getPrimerApellido());
        Assert.isNull(usuario.getSegundoApellido(), "Sin segundo apellido");
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
        assertEquals(fechaCreacion, usuario.getFechaCreacion());
    }

    // Identificacion

    @Test
    @DisplayName("Deberia fallar sin identificacion de usuario")
    void deberiaFallarSinIdentificacionDeUsuario() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conIdentificacion(null);
        probarExcepcionValorObligatorio(usuarioTestDataBuilder, SE_DEBE_INGRESAR_LA_IDENTIFICACION);
    }

    @Test
    @DisplayName("Deberia fallar longitud corta de indetificacion de usuario")
    void deberiaFallarConLongituCortaIdentificacionDeUsuario() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conIdentificacion("12345");
        probarExcepcionLongitudValor(usuarioTestDataBuilder, String.format(LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MINIMA_O_IGUAL_A, LONGITUD_MINIMA_IDENTIFICACION));
    }

    @Test
    @DisplayName("Deberia fallar longitud larga de indetificacion de usuario")
    void deberiaFallarConLongituLargaIdentificacionDeUsuario() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conIdentificacion("123456789101");
        probarExcepcionLongitudValor(usuarioTestDataBuilder, String.format(LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_IDENTIFICACION));
    }

    @Test
    @DisplayName("Deberia fallar solo ceros de indetificacion de usuario")
    void deberiaFallarConSoloCerosEnIdentificacionDeUsuario() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conIdentificacion("00000000000");
        probarExcepcionValorInvalido(usuarioTestDataBuilder, LA_IDENTIFICACION_NO_DEBER_SER_SOLO_CEROS);
    }

    @Test
    @DisplayName("Deberia fallar espacio en blanco de indetificacion de usuario")
    void deberiaFallarConIdentificacionDeUsuarioEnBlanco() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conIdentificacion("          ");
        probarExcepcionValorInvalido(usuarioTestDataBuilder, LA_IDENTIFICACION_SOLO_TIENE_ESPACIOS_BLANCOS);
    }

    // Nombre

    @Test
    @DisplayName("Deberia fallar sin nombre de usuario")
    void deberiaFallarSinNombreDeUsuario() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombres(null);
        probarExcepcionValorObligatorio(usuarioTestDataBuilder, SE_DEBE_INGRESAR_EL_NOMBRE);
    }

    @Test
    @DisplayName("Deberia fallar espacio en blanco el nombre  de usuario")
    void deberiaFallarConNombreDeUsuarioEnBlanco() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombres(" ");
        probarExcepcionValorInvalido(usuarioTestDataBuilder, EL_NOMBRE_SOLO_TIENE_ESPACIOS_BLANCOS);
    }

    @Test
    @DisplayName("Deberia fallar longitud larga del nombre de usuario")
    void deberiaFallarConNombreDeUsuarioMuyLargo() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombres("123456789124578895623102457889562311454454545454120");
        probarExcepcionLongitudValor(usuarioTestDataBuilder, String.format(EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE));
    }

    // Primer Apellido

    @Test
    @DisplayName("Deberia fallar sin primer apellido de usuario")
    void deberiaFallarSinPrimerApellidoDeUsuario() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conPrimerApellido(null);
        probarExcepcionValorObligatorio(usuarioTestDataBuilder, SE_DEBE_INGRESAR_EL_PRIMER_APELLIDO);
    }

    @Test
    @DisplayName("Deberia fallar espacio en blancos de primer apellido de usuario")
    void deberiaFallarConPrimerApellidoDeUsuarioEnBlanco() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conPrimerApellido(" ");
        probarExcepcionValorInvalido(usuarioTestDataBuilder, EL_PRIMER_APELLIDO_SOLO_TIENE_ESPACIOS_BLANCOS);
    }

    @Test
    @DisplayName("Deberia fallar longitud larga de primer apellido de usuario")
    void deberiaFallarConPrimerApellidoDeUsuarioMuyLargo() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conPrimerApellido("123456789124578895623102457889562311454454545454120");
        probarExcepcionLongitudValor(usuarioTestDataBuilder, String.format(EL_PRIMER_APELLIDO_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE));
    }

    // Segundo Apellido

    @Test
    @DisplayName("Deberia fallar espacio en blanco de segundo apellido de usuario")
    void deberiaFallarConSegundoApellidoDeUsuarioEnBlanco() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conSegundoApellido(" ");
        probarExcepcionValorInvalido(usuarioTestDataBuilder, EL_SEGUNDO_APELLIDO_SOLO_TIENE_ESPACIOS_BLANCOS);
    }

    @Test
    @DisplayName("Deberia fallar longitud larga de segundo apellido de usuario")
    void deberiaFallarConSegundoApellidoDeUsuarioMuyLargo() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conSegundoApellido("123456789124578895623102457889562311454454545454120");
        probarExcepcionLongitudValor(usuarioTestDataBuilder, String.format(EL_SEGUNDO_APELLIDO_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE));
    }

    // Fecha de nacimiento

    @Test
    @DisplayName("Deberia fallar sin fecha de nacimiento de usuario")
    void deberiaFallarSinFechaNacimientoDeUsuario() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conFechaNacimiento(null);
        probarExcepcionValorObligatorio(usuarioTestDataBuilder, SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO);
    }

    @Test
    @DisplayName("Deberia fallar fecha de nacimiento es posterior a la fecha actual")
    void deberiaFallarFechaNacimientoMayorHoyDeUsuario() {
        LocalDate fechaNacimientoFutura = LocalDate.now().plusDays(1L);
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conFechaNacimiento(fechaNacimientoFutura);
        probarExcepcionValorInvalido(usuarioTestDataBuilder, LA_FECHA_NACIMIENTO_MAYOR_FECHA_ACTUAL);
    }

    @Test
    @DisplayName("Deberia fallar fecha el usuario es mayor de edad")
    void deberiaFallarMayorEdadDeUsuario() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.from(LocalDate.of(fechaActual.getYear() - 18, fechaActual.getMonthValue(), fechaActual.getDayOfMonth()));
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conFechaNacimiento(fechaNacimiento);
        assertTrue(!usuarioTestDataBuilder.build().esMenorDeEdad());
    }

    // Fecha de creacion

    @Test
    @DisplayName("Deberia fallar sin fecha de creacion de usuario")
    void deberiaFallarSinFechaCreacionDeUsuario() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conFechaCreacion(null);
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build().validarFechaCreacion();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
    }

    @Test
    @DisplayName("Deberia fallar fecha de creacion es posterior a la actual")
    void deberiaFallarFechaCreacionMayorHoyDeUsuario() {
        LocalDateTime fechaCreacionFutura = LocalDateTime.now().plusDays(1);

        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conFechaCreacion(fechaCreacionFutura);
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build().validarFechaCreacion();
                },
                ExcepcionValorInvalido.class, LA_FECHA_CREACION_MAYOR_FECHA_ACTUAL);
    }

    @Test
    @DisplayName("Deberia fallar fecha de creacion es inferior a la actual")
    void deberiaFallarFechaCreacionMenorHoyDeUsuario() {
        LocalDateTime fechaCreacionPasada = LocalDateTime.now().minusDays(1L);
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conFechaCreacion(fechaCreacionPasada);
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build().validarFechaCreacion();
                },
                ExcepcionValorInvalido.class, LA_FECHA_CREACION_MENOR_FECHA_ACTUAL);
    }

    void probarExcepcionValorInvalido(UsuarioTestDataBuilder usuarioTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, mensajeExcepcion);
    }

    void probarExcepcionValorObligatorio(UsuarioTestDataBuilder usuarioTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, mensajeExcepcion);
    }

    void probarExcepcionLongitudValor(UsuarioTestDataBuilder usuarioTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, mensajeExcepcion);
    }
}
