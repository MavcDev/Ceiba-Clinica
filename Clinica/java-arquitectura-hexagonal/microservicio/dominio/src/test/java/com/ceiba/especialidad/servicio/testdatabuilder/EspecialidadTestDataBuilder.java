package com.ceiba.especialidad.servicio.testdatabuilder;

import com.ceiba.especialidad.modelo.entidad.Especialidad;

import java.math.BigDecimal;

public class EspecialidadTestDataBuilder {

    private Long id;
    private String nombre;
    private BigDecimal valor;

    public EspecialidadTestDataBuilder(){
        nombre = "General";
        valor = BigDecimal.valueOf(500000);
    }

    public EspecialidadTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public EspecialidadTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public EspecialidadTestDataBuilder conValor(BigDecimal valor){
        this.valor = valor;
        return this;
    }

    public Especialidad build(){
        return new Especialidad(id, nombre, valor);
    }
}
