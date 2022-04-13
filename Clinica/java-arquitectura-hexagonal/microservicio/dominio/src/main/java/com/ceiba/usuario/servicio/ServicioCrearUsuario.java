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
        this.fabricaUsuarioModelo = new FabricaUsuarioModelo();
    }

    public Long ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario.getIdentificacion());
        usuario.validarFechaCreacion();
        DtoUsuario dtoUsuarioNuevo = this.fabricaUsuarioModelo.crear(usuario);
        return this.repositorioUsuario.crear(dtoUsuarioNuevo);
    }

    private void validarExistenciaPrevia(String identificacion) {
        boolean existe = this.repositorioUsuario.existe(identificacion);
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
