package com.ceiba.medico.modelo.entidad;

import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.persona.modelo.entidad.Persona;
import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Medico extends Persona {

    public static final String SE_DEBE_INGRESAR_LA_ESPECIALIDAD = "Se debe ingresar la especialidad";

    private Especialidad especialidad;

    public Medico(Long id, String identificacion, String nombres, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, Especialidad especialidad){
        super(id, identificacion, nombres, primerApellido, segundoApellido, fechaNacimiento);

        validarObligatorio(especialidad, SE_DEBE_INGRESAR_LA_ESPECIALIDAD);

        this.especialidad = especialidad;
    }
}
