package com.ceiba.horario.consulta;

import com.ceiba.horario.modelo.dto.DtoPresentacionHorario;
import com.ceiba.horario.puerto.dao.DaoHorario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarHorario {

    private final DaoHorario daoHorario;

    public ManejadorListarHorario(DaoHorario daoHorario) {
        this.daoHorario = daoHorario;
    }

    public List<DtoPresentacionHorario> ejecutar(){
        return daoHorario.listar();
    }
}
