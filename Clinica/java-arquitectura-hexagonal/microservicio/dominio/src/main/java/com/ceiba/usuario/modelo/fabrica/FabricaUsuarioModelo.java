package com.ceiba.usuario.modelo.fabrica;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;


public class FabricaUsuarioModelo {

    public DtoUsuario crear(Usuario usuario){
        return new DtoUsuario(
                usuario.getId(),
                usuario.getIdentificacion(),
                usuario.getNombres(),
                usuario.getPrimerApellido(),
                usuario.getSegundoApellido(),
                usuario.getFechaNacimiento(),
                usuario.getFechaCreacion()
        );
    }
}
