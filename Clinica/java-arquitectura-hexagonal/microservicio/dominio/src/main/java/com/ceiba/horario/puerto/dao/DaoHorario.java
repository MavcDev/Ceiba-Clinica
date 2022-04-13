package com.ceiba.horario.puerto.dao;

import com.ceiba.horario.modelo.dto.DtoPresentacionHorario;

import java.util.List;

public interface DaoHorario {

    /**
     * Permite listar los horarios
     * @return los horariaos
     */
    List<DtoPresentacionHorario> listar();
}
