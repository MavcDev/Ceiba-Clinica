package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {
    private String identificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaCreacion;

    public ComandoUsuarioTestDataBuilder() {
        identificacion = "1117522445";
        nombres = "Carlos";
        primerApellido = "Perez";
        segundoApellido = null;
        fechaNacimiento = LocalDate.from(LocalDate.of(2015,1,1));
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoUsuarioTestDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombres = nombre;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(null, identificacion, nombres, primerApellido, segundoApellido, fechaNacimiento, fechaCreacion);
    }
}
