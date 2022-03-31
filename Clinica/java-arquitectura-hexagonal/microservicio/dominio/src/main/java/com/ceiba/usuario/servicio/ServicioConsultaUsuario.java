package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.usuario.modelo.dto.DtoPresentacionUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioConsultaUsuario {

    private static final String EL_USUARIO_NO_EXISTE = "El usuario no existe";

    private final RepositorioUsuario repositorioUsuario;
    private final DaoUsuario daoUsuario;

    public ServicioConsultaUsuario(RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.daoUsuario = daoUsuario;
    }

    public DtoPresentacionUsuario buscarPorIdentificacion(String identificacion){
        validarExistenciaUsuario(identificacion);
        return daoUsuario.buscarPorIdentificacion(identificacion);
    }

    private void validarExistenciaUsuario(String identificacion){
        boolean existe = repositorioUsuario.existe(identificacion);
        if(!existe){
            throw new ExcepcionSinDatos(EL_USUARIO_NO_EXISTE);
        }
    }
}
