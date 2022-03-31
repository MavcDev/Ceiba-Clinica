package com.ceiba.especialidad.modelo.entidad;

import lombok.Getter;

import java.math.BigDecimal;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Especialidad {

    public static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    public static final String SE_DEBE_INGRESAR_EL_VALOR = "Se debe ingresar el valor";

    private Long id;
    private String nombre;
    private BigDecimal valor;

    public Especialidad(Long id, String nombre, BigDecimal valor){
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR);

        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }
}
