package com.ceiba.usuario.modelo.entidad;


import com.ceiba.persona.modelo.entidad.Persona;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Usuario extends Persona {

    public static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    public static final String LA_FECHA_CREACION_MAYOR_FECHA_ACTUAL = "La fecha de creación es mayor a la fecha actual";
    public static final String LA_FECHA_CREACION_MENOR_FECHA_ACTUAL = "La fecha de creación es menor a la fecha actual";

    private LocalDateTime fechaCreacion;

    public Usuario(Long id, String identificacion, String nombres, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, LocalDateTime fechaCreacion) {
        super(id, identificacion, nombres, primerApellido, segundoApellido, fechaNacimiento);

        this.fechaCreacion = fechaCreacion;
    }

    public void validarFechaCreacion(){
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarFechaMayorActual(fechaCreacion.toLocalDate(), LA_FECHA_CREACION_MAYOR_FECHA_ACTUAL);
        validarFechaMenorActual(fechaCreacion.toLocalDate(), LA_FECHA_CREACION_MENOR_FECHA_ACTUAL);
    }
    
    public boolean esMenorDeEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() < 18;
    }
}
