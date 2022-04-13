package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public FabricaUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario crear(ComandoUsuario comandoUsuario){
        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getIdentificacion(),
                comandoUsuario.getNombres(),
                comandoUsuario.getPrimerApellido(),
                comandoUsuario.getSegundoApellido(),
                comandoUsuario.getFechaNacimiento(),
                comandoUsuario.getFechaCreacion()
        );
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

    public Usuario buscarCrear(Long id){
        DtoUsuario dtoUsuario = repositorioUsuario.buscarPorId(id);
        return crear(dtoUsuario);
    }
}
