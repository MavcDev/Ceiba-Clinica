package com.ceiba.especialidad.consulta;

import com.ceiba.especialidad.modelo.dto.DtoPresentacionEspecialidad;
import com.ceiba.especialidad.puerto.dao.DaoEspecialidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEspecialidad {

    private final DaoEspecialidad daoEspecialidad;

    public ManejadorListarEspecialidad(DaoEspecialidad daoEspecialidad) {
        this.daoEspecialidad = daoEspecialidad;
    }

    public List<DtoPresentacionEspecialidad> ejecutar(){
        return this.daoEspecialidad.listar();
    }
}
