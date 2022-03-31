package com.ceiba.especialidad.puerto.repositorio;

import com.ceiba.especialidad.modelo.dto.DtoEspecialidad;

public interface RepositorioEspecialidad {

    /**
     * Permite buscar una especialidad por id
     * @return DtoEspecialidad
     */
    DtoEspecialidad buscarPorId(Long id);
}
