package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoPresentacionUsuario;
import com.ceiba.usuario.servicio.ServicioConsultaUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarUsuarios {

    private final ServicioConsultaUsuario servicioConsultaUsuario;

    public ManejadorBuscarUsuarios(ServicioConsultaUsuario servicioConsultaUsuario){
        this.servicioConsultaUsuario = servicioConsultaUsuario;
    }

    public DtoPresentacionUsuario ejecutar(String identificacion){ return this.servicioConsultaUsuario.buscarPorIdentificacion(identificacion);}
}
