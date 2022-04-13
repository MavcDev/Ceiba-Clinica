package com.ceiba.solicitud.controlador;

import com.ceiba.solicitud.consulta.ManejadorListarSolicitud;
import com.ceiba.solicitud.modelo.dto.DtoPresentacionSolicitud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
@Api(tags={"Controlador consulta solicitud cita"})
public class ConsultaControladorSolicitud {

    private final ManejadorListarSolicitud manejadorListarSolicitud;

    public ConsultaControladorSolicitud(ManejadorListarSolicitud manejadorListarSolicitud) {
        this.manejadorListarSolicitud = manejadorListarSolicitud;
    }

    @GetMapping()
    @ApiOperation("Buscar solicitudes de cita por id de usuario")
    public List<DtoPresentacionSolicitud> listarSolicitudCitaPorUsuario(@RequestParam(value = "usuario") Long usuario) {
        return this.manejadorListarSolicitud.ejecutar(usuario);
    }
}
