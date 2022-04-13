package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

public interface RepositorioUsuario {
    /**
     * Permite crear un usuario
     * @param dtoUsuario
     * @return el id generado
     */
    Long crear(DtoUsuario dtoUsuario);

    /**
     * Permite bsucar un usuario con el id
     * @param id
     * @return DtoUsuario
     */
    DtoUsuario buscarPorId(Long id);

    /**
     * Permite validar si existe un usuario con la identificacion
     * @param identificacion
     * @return si existe o no
     */
    boolean existe(String identificacion);

    /**
     * Permite validar si existe un usuario por el id
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
