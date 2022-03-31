package com.ceiba.solicitudcita.consulta;

import com.ceiba.solicitudcita.modelo.dto.DtoPresentacionSolicitudCita;
import com.ceiba.solicitudcita.puerto.dao.DaoSolicitudCita;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSolicitudCita {

    private final DaoSolicitudCita daoSolicitudCita;

    public ManejadorListarSolicitudCita(DaoSolicitudCita daoSolicitudCita) {
        this.daoSolicitudCita = daoSolicitudCita;
    }

    public List<DtoPresentacionSolicitudCita> ejecutar(Long idUsuario){
        return this.daoSolicitudCita.buscarPorIdUsuario(idUsuario);
    }
}
