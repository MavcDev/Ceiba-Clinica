package com.ceiba.horariodia.puerto.dao;

import com.ceiba.horariodia.modelo.dto.DtoPresentacionHorarioDia;

import java.util.List;

public interface DaoHorarioDia {

    /**
     * Permite listar los horarios
     * @return los horariaos
     */
    List<DtoPresentacionHorarioDia> listar();
}
