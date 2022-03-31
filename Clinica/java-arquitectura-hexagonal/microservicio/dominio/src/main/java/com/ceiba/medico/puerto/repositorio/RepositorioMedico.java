package com.ceiba.medico.puerto.repositorio;

import com.ceiba.medico.modelo.dto.DtoMedico;

public interface RepositorioMedico {

    /**
     * Permite bsucar un medico con el id
     * @param id
     * @return DtoMedico
     */
    DtoMedico buscarPorId(Long id);
}
