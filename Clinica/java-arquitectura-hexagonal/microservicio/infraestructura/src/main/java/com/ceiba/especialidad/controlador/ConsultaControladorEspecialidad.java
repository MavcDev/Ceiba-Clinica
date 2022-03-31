package com.ceiba.especialidad.controlador;

import com.ceiba.especialidad.consulta.ManejadorListarEspecialidad;
import com.ceiba.especialidad.modelo.dto.DtoPresentacionEspecialidad;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@Api(tags={"Controlador consulta especialidad"})
public class ConsultaControladorEspecialidad {

    private final ManejadorListarEspecialidad manejadorListarEspecialidad;

    public ConsultaControladorEspecialidad(ManejadorListarEspecialidad manejadorListarEspecialidad) {
        this.manejadorListarEspecialidad = manejadorListarEspecialidad;
    }

    @GetMapping
    @ApiOperation("Listar Especialidad")
    public List<DtoPresentacionEspecialidad> listar(){
        return this.manejadorListarEspecialidad.ejecutar();
    }
}
