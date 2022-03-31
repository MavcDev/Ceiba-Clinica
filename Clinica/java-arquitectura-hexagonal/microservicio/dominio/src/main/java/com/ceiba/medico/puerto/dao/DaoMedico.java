package com.ceiba.medico.puerto.dao;

import com.ceiba.medico.modelo.dto.DtoPresentacionMedico;

import java.util.List;

public interface DaoMedico {

    /**
     * Permite listar medicos por especialidad
     * @Param idEspecialidad
     * @return los medicos
     */
    List<DtoPresentacionMedico> listar(Long idEspecialidad);
}
