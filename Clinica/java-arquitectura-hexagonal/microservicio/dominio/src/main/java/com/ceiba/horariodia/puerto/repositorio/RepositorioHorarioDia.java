package com.ceiba.horariodia.puerto.repositorio;

import com.ceiba.horariodia.modelo.dto.DtoHorarioDia;


public interface RepositorioHorarioDia {

    /**
     * Permite buscar un Horario con el id
     * @param id
     * @return DtoHorarioDia
     */
    DtoHorarioDia buscarPorId(Long id);
}
