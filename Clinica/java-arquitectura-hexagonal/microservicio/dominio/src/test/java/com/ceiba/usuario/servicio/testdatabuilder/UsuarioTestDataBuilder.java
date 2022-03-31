package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String identificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaCreacion;

    public UsuarioTestDataBuilder() {
        identificacion = "1117522448";
        nombres = "Camilo Andres";
        primerApellido = "Perez";
        segundoApellido = "Sanchez";
        fechaNacimiento = LocalDate.from(LocalDate.of(1991, 12, 20));
        fechaCreacion = LocalDateTime.now();
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public UsuarioTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public UsuarioTestDataBuilder conPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public UsuarioTestDataBuilder conSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public UsuarioTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public UsuarioTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Usuario build() {
        return new Usuario(id, identificacion, nombres, primerApellido, segundoApellido, fechaNacimiento, fechaCreacion);
    }
}
