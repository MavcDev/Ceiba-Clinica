package com.ceiba.solicitudcita.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.solicitudcita.comando.ComandoSolicitudCita;
import com.ceiba.solicitudcita.comando.fabrica.FabricaSolicitudCita;
import com.ceiba.solicitudcita.modelo.dto.DtoEntradaCrearSolicitudCita;
import com.ceiba.solicitudcita.servicio.ServicioCrearSolicitudCita;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSolicitudCita implements ManejadorComandoRespuesta<ComandoSolicitudCita, ComandoRespuesta<Long>> {

    private final FabricaSolicitudCita fabricaSolicitudCita;
    private final ServicioCrearSolicitudCita servicioCrearSolicitudCita;

    public ManejadorCrearSolicitudCita(FabricaSolicitudCita fabricaSolicitudCita, ServicioCrearSolicitudCita servicioCrearSolicitudCita) {
        this.fabricaSolicitudCita = fabricaSolicitudCita;
        this.servicioCrearSolicitudCita = servicioCrearSolicitudCita;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCita comandoSolicitudCita) {
        DtoEntradaCrearSolicitudCita dtoEntradaCrearSolicitudCita = this.fabricaSolicitudCita.crear(comandoSolicitudCita);
        return new ComandoRespuesta<>(this.servicioCrearSolicitudCita.ejecutar(dtoEntradaCrearSolicitudCita));
    }
}
