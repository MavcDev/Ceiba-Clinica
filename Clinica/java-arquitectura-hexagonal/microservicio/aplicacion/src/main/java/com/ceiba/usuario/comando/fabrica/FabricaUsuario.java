package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;

@Component
public class FabricaUsuario {

    public DtoUsuario crear(ComandoUsuario comandoUsuario) {
        return new DtoUsuario(
                comandoUsuario.getId(),
                comandoUsuario.getIdentificacion(),
                comandoUsuario.getNombres(),
                comandoUsuario.getPrimerApellido(),
                comandoUsuario.getSegundoApellido(),
                comandoUsuario.getFechaNacimiento(),
                comandoUsuario.getFechaCreacion()
        );
    }

}
