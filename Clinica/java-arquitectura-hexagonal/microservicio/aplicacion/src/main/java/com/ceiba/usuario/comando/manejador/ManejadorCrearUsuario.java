package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<Long>> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioCrearUsuario servicioCrearUsuario;

    public ManejadorCrearUsuario(FabricaUsuario fabricaUsuario, ServicioCrearUsuario servicioCrearUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoUsuario comandoUsuario) {
        DtoUsuario dtoUsuario = this.fabricaUsuario.crear(comandoUsuario);
        return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(dtoUsuario));
    }
}
