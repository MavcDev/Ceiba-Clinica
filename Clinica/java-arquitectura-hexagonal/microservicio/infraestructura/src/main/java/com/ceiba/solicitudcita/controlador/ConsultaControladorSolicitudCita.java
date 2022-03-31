package com.ceiba.solicitudcita.controlador;

import com.ceiba.solicitudcita.consulta.ManejadorListarSolicitudCita;
import com.ceiba.solicitudcita.modelo.dto.DtoPresentacionSolicitudCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudcitas")
@Api(tags={"Controlador consulta solicitud cita"})
public class ConsultaControladorSolicitudCita {

    private final ManejadorListarSolicitudCita manejadorListarSolicitudCita;

    public ConsultaControladorSolicitudCita(ManejadorListarSolicitudCita manejadorListarSolicitudCita) {
        this.manejadorListarSolicitudCita = manejadorListarSolicitudCita;
    }

    @GetMapping()
    @ApiOperation("Buscar solicitudes de cita por id de usuario")
    public List<DtoPresentacionSolicitudCita> listarSolicitudCitaPorUsuario(@RequestParam(value = "usuario") Long usuario) {
        return this.manejadorListarSolicitudCita.ejecutar(usuario);
    }
}
