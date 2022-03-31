package com.ceiba.especialidad.puerto.dao;

import com.ceiba.especialidad.modelo.dto.DtoPresentacionEspecialidad;

import java.util.List;

public interface DaoEspecialidad {

    /**
     * Permite listar las especialidades
     * @return las especialidades
     */
    List<DtoPresentacionEspecialidad> listar();
}
