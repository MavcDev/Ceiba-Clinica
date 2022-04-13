package com.ceiba.solicitud.consulta;

import com.ceiba.solicitud.modelo.dto.DtoPresentacionSolicitud;
import com.ceiba.solicitud.puerto.dao.DaoSolicitud;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSolicitud {

    private final DaoSolicitud daoSolicitud;

    public ManejadorListarSolicitud(DaoSolicitud daoSolicitud) {
        this.daoSolicitud = daoSolicitud;
    }

    public List<DtoPresentacionSolicitud> ejecutar(Long idUsuario){
        return this.daoSolicitud.buscarPorIdUsuario(idUsuario);
    }
}
