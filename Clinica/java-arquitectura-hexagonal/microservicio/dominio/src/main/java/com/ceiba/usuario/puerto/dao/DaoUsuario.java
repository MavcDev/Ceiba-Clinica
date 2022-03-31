package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoPresentacionUsuario;


public interface DaoUsuario {

    /**
     * Permite buscar usuario por identificacion
     * @Param identificacion
     * @return usuario
     */
    DtoPresentacionUsuario buscarPorIdentificacion(String identificacion);

}
