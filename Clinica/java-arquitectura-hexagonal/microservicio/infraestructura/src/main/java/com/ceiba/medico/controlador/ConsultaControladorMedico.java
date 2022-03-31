package com.ceiba.medico.controlador;

import com.ceiba.medico.consulta.ManejadorListarMedicos;
import com.ceiba.medico.modelo.dto.DtoPresentacionMedico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@Api(tags={"Controlador consulta medico"})
public class ConsultaControladorMedico {

    private final ManejadorListarMedicos manejadorListarMedicos;

    public ConsultaControladorMedico(ManejadorListarMedicos manejadorListarMedicos) {
        this.manejadorListarMedicos = manejadorListarMedicos;
    }

    @GetMapping()
    @ApiOperation("Listar Medicos por especialidad")
    public List<DtoPresentacionMedico> listar(@RequestParam(value = "especialidad") Long especialidad){
        return manejadorListarMedicos.ejecutar(especialidad);
    }
}
