package com.ceiba.usuario.modelo.fabrica;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class FabricaUsuarioModelo {

    private final RepositorioUsuario repositorioUsuario;

    public FabricaUsuarioModelo(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario crear(DtoUsuario dtoUsuario){
        return new Usuario(
                dtoUsuario.getId(),
                dtoUsuario.getIdentificacion(),
                dtoUsuario.getNombres(),
                dtoUsuario.getPrimerApellido(),
                dtoUsuario.getSegundoApellido(),
                dtoUsuario.getFechaNacimiento(),
                dtoUsuario.getFechaCreacion()
        );
    }

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

    public Usuario buscarCrear(Long id){
        DtoUsuario dtoUsuario = repositorioUsuario.buscarPorId(id);
        return crear(dtoUsuario);
    }
}
