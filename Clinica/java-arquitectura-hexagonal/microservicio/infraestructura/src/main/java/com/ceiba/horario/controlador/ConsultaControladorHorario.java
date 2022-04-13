package com.ceiba.horario.controlador;

import com.ceiba.horario.consulta.ManejadorListarHorario;
import com.ceiba.horario.modelo.dto.DtoPresentacionHorario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@Api(tags={"Controlador consulta horario"})
public class ConsultaControladorHorario {

    private final ManejadorListarHorario manejadorListarHorario;

    public ConsultaControladorHorario(ManejadorListarHorario manejadorListarHorario) {
        this.manejadorListarHorario = manejadorListarHorario;
    }

    @GetMapping
    @ApiOperation("Listar Horario")
    public List<DtoPresentacionHorario> listar(){
        return this.manejadorListarHorario.ejecutar();
    }
}
