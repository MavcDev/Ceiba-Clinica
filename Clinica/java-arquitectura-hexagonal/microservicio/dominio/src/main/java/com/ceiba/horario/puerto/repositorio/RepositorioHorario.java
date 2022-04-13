package com.ceiba.horario.puerto.repositorio;

import com.ceiba.horario.modelo.dto.DtoHorario;


public interface RepositorioHorario {

    /**
     * Permite buscar un Horario con el id
     * @param id
     * @return DtoHorarioDia
     */
    DtoHorario buscarPorId(Long id);
}
