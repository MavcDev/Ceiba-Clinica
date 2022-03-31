package com.ceiba.medico.consulta;

import com.ceiba.medico.modelo.dto.DtoPresentacionMedico;
import com.ceiba.medico.puerto.dao.DaoMedico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMedicos {

    private final DaoMedico daoMedico;

    public ManejadorListarMedicos(DaoMedico daoMedico) {
        this.daoMedico = daoMedico;
    }

    public List<DtoPresentacionMedico> ejecutar(Long especialidad){
        return this.daoMedico.listar(especialidad);
    }
}
