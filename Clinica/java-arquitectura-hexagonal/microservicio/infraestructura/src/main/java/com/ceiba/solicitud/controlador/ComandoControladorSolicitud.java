package com.ceiba.solicitud.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.comando.manejador.ManejadorCrearSolicitud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitudes")
@Api(tags = { "Controlador comando solicitud cita"})
public class ComandoControladorSolicitud {

    private final ManejadorCrearSolicitud manejadorCrearSolicitud;

    public ComandoControladorSolicitud(ManejadorCrearSolicitud manejadorCrearSolicitud) {
        this.manejadorCrearSolicitud = manejadorCrearSolicitud;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Crear solicitud cita")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitud comandoSolicitud) {
        return manejadorCrearSolicitud.ejecutar(comandoSolicitud);
    }
}
