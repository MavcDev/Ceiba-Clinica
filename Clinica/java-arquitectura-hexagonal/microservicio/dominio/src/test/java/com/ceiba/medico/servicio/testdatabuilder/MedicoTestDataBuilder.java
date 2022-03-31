package com.ceiba.medico.servicio.testdatabuilder;

import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicoTestDataBuilder {

    private Long id;
    private String identificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private Especialidad especialidad;

    public MedicoTestDataBuilder() {
        identificacion = "1117522448";
        nombres = "Camilo Andres";
        primerApellido = "Perez";
        segundoApellido = "Sanchez";
        fechaNacimiento = LocalDate.from(LocalDate.of(1991, 12, 20));
        especialidad = new Especialidad(1L, "General", BigDecimal.valueOf(500000));
    }

    public MedicoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public MedicoTestDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public MedicoTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public MedicoTestDataBuilder conPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public MedicoTestDataBuilder conSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public MedicoTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public MedicoTestDataBuilder conEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
        return this;
    }

    public Medico build() {
        return new Medico(id, identificacion, nombres, primerApellido, segundoApellido, fechaNacimiento, especialidad);
    }
}
