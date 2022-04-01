package com.ceiba.persona.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public abstract class Persona {
    public static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION = "Se debe ingresar la identificación";
    public static final String LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A = "La identificación debe tener una longitud maxima o igual a %s";
    public static final String LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MINIMA_O_IGUAL_A = "La identificación debe tener una longitud minima o igual a %s";
    public static final String LA_IDENTIFICACION_NO_DEBER_SER_SOLO_CEROS = "La identifcacion solo contiene ceros";
    public static final String LA_IDENTIFICACION_SOLO_TIENE_ESPACIOS_BLANCOS = "La identificación contiene solo espacios en blanco";

    public static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    public static final String EL_NOMBRE_SOLO_TIENE_ESPACIOS_BLANCOS = "El nombre contiene solo espacios en blanco";
    public static final String EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A = "El nombre debe tener una longitud maxima o igual a %s";

    public static final String SE_DEBE_INGRESAR_EL_PRIMER_APELLIDO = "Se debe ingresar el primer apellido";
    public static final String EL_PRIMER_APELLIDO_SOLO_TIENE_ESPACIOS_BLANCOS = "El primer apellido contiene solo espacios en blanco";
    public static final String EL_PRIMER_APELLIDO_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A = "El primer apellido debe tener una longitud maxima o igual a %s";

    public static final String EL_SEGUNDO_APELLIDO_SOLO_TIENE_ESPACIOS_BLANCOS = "El segundo apellido contiene solo espacios en blanco";
    public static final String EL_SEGUNDO_APELLIDO_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A = "El segundo apellido debe tener una longitud maxima o igual a %s";

    public static final String SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";
    public static final String LA_FECHA_NACIMIENTO_MAYOR_FECHA_ACTUAL = "La fecha de nacimiento es mayor a la fecha actual";

    public static final int LONGITUD_MINIMA_IDENTIFICACION = 6;
    public static final int LONGITUD_MAXIMA_IDENTIFICACION = 11;
    public static final int LONGITUD_MAXIMA_NOMBRE = 50;

    protected Long id;
    protected String identificacion;
    protected String nombres;
    protected String primerApellido;
    protected String segundoApellido;
    protected LocalDate fechaNacimiento;

    protected Persona(Long id, String identificacion, String nombres, String primerApellido, String segundoApellido, LocalDate fechaNacimiento){
        validarIndetificacion(identificacion);
        validarNombre(nombres);
        validarPrimerApellido(primerApellido);
        validarSegundoApellido(segundoApellido);
        validarFechaNacimiento(fechaNacimiento);

        this.id = id;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    private void validarIndetificacion(String identificacion){
        String mensajeLongitudMinima = String.format(LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MINIMA_O_IGUAL_A, LONGITUD_MINIMA_IDENTIFICACION);
        String mensajeLongitudMaxima= String.format(LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A, LONGITUD_MAXIMA_IDENTIFICACION);
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION);
        validarLongitud(identificacion, LONGITUD_MINIMA_IDENTIFICACION, mensajeLongitudMinima);
        validarLongitudMaxima(identificacion, LONGITUD_MAXIMA_IDENTIFICACION, mensajeLongitudMaxima);
        validarTextoBlanco(identificacion, LA_IDENTIFICACION_SOLO_TIENE_ESPACIOS_BLANCOS);
        validarSoloCeros(identificacion, LA_IDENTIFICACION_NO_DEBER_SER_SOLO_CEROS);
    }

    private void validarNombre(String nombres){
        validarObligatorio(nombres, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarNombreApellido(nombres, EL_NOMBRE_SOLO_TIENE_ESPACIOS_BLANCOS, EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A);
    }

    private void validarPrimerApellido(String primerApellido){
        validarObligatorio(primerApellido, SE_DEBE_INGRESAR_EL_PRIMER_APELLIDO);
        validarNombreApellido(primerApellido, EL_PRIMER_APELLIDO_SOLO_TIENE_ESPACIOS_BLANCOS, EL_PRIMER_APELLIDO_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A);
    }

    private void validarSegundoApellido(String segundoApellido){
        if(segundoApellido != null){
            validarNombreApellido(segundoApellido, EL_SEGUNDO_APELLIDO_SOLO_TIENE_ESPACIOS_BLANCOS, EL_SEGUNDO_APELLIDO_DEBE_TENER_UNA_LONGITUD_MAXIMA_O_IGUAL_A);
        }
    }

    private void validarFechaNacimiento(LocalDate fechaNacimiento){
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO);
        validarFechaMayorActual(fechaNacimiento, LA_FECHA_NACIMIENTO_MAYOR_FECHA_ACTUAL);
    }

    private void validarNombreApellido(String valor, String mensajeTextoBlanco, String mensajeLongitudMaxima){
        validarTextoBlanco(valor, mensajeTextoBlanco);
        validarLongitudMaxima(valor, LONGITUD_MAXIMA_NOMBRE, String.format(mensajeLongitudMaxima, LONGITUD_MAXIMA_NOMBRE));
    }

    public String getNombreCompleto(){
        return  String.format("%s %s %s",nombres, primerApellido, segundoApellido == null ? "" : segundoApellido).trim();
    }
}
