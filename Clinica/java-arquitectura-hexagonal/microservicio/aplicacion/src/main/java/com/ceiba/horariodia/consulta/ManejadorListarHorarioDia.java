package com.ceiba.horariodia.consulta;

import com.ceiba.horariodia.modelo.dto.DtoPresentacionHorarioDia;
import com.ceiba.horariodia.puerto.dao.DaoHorarioDia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarHorarioDia {

    private final DaoHorarioDia daoHorarioDia;

    public ManejadorListarHorarioDia(DaoHorarioDia daoHorarioDia) {
        this.daoHorarioDia = daoHorarioDia;
    }

    public List<DtoPresentacionHorarioDia> ejecutar(){
        return daoHorarioDia.listar();
    }
}
