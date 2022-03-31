package com.ceiba.horariodia.controlador;

import com.ceiba.horariodia.consulta.ManejadorListarHorarioDia;
import com.ceiba.horariodia.modelo.dto.DtoPresentacionHorarioDia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@Api(tags={"Controlador consulta horario"})
public class ConsultaControladorHorarioDia {

    private final ManejadorListarHorarioDia manejadorListarHorarioDia;

    public ConsultaControladorHorarioDia(ManejadorListarHorarioDia manejadorListarHorarioDia) {
        this.manejadorListarHorarioDia = manejadorListarHorarioDia;
    }

    @GetMapping
    @ApiOperation("Listar Horario")
    public List<DtoPresentacionHorarioDia> listar(){
        return this.manejadorListarHorarioDia.ejecutar();
    }
}
