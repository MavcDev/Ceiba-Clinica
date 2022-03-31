package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.modelo.fabrica.FabricaUsuarioModelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;
    private final FabricaUsuarioModelo fabricaUsuarioModelo;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.fabricaUsuarioModelo = new FabricaUsuarioModelo(repositorioUsuario);
    }

    public Long ejecutar(DtoUsuario dtoUsuario) {
        validarExistenciaPrevia(dtoUsuario);
        Usuario usuario = fabricaUsuarioModelo.crear(dtoUsuario);
        usuario.validarFechaCreacion();
        return this.repositorioUsuario.crear(dtoUsuario);
    }

    private void validarExistenciaPrevia(DtoUsuario dtoUsuario) {
        boolean existe = this.repositorioUsuario.existe(dtoUsuario.getIdentificacion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
