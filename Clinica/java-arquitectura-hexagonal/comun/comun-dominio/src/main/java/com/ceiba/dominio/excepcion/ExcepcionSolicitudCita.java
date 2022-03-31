package com.ceiba.dominio.excepcion;

public class ExcepcionSolicitudCita extends RuntimeException{

    public ExcepcionSolicitudCita(String mensaje){
        super(mensaje);
    }
}
