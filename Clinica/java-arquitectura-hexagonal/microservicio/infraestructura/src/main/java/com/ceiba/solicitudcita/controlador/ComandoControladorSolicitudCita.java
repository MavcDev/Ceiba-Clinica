package com.ceiba.solicitudcita.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.solicitudcita.comando.ComandoSolicitudCita;
import com.ceiba.solicitudcita.comando.manejador.ManejadorCrearSolicitudCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitudcitas")
@Api(tags = { "Controlador comando solicitud cita"})
public class ComandoControladorSolicitudCita {

    private final ManejadorCrearSolicitudCita manejadorCrearSolicitudCita;

    public ComandoControladorSolicitudCita(ManejadorCrearSolicitudCita manejadorCrearSolicitudCita) {
        this.manejadorCrearSolicitudCita = manejadorCrearSolicitudCita;
    }

    @PostMapping
    @ApiOperation("Crear solicitud cita")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCita comandoSolicitudCita) {
        return manejadorCrearSolicitudCita.ejecutar(comandoSolicitudCita);
    }
}
