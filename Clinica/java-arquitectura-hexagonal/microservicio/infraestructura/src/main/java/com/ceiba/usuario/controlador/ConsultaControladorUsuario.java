package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ManejadorBuscarUsuarios;
import com.ceiba.usuario.modelo.dto.DtoPresentacionUsuario;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/usuarios")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorUsuario {

    private final ManejadorBuscarUsuarios manejadorBuscarUsuarios;

    public ConsultaControladorUsuario(ManejadorBuscarUsuarios manejadorBuscarUsuarios) {
        this.manejadorBuscarUsuarios = manejadorBuscarUsuarios;
    }

    @GetMapping()
    @ApiOperation("Buscar usuario por identificacion")
    public DtoPresentacionUsuario buscarPorIdentificacion(@RequestParam(value = "identificacion") String identificacion) {
        return this.manejadorBuscarUsuarios.ejecutar(identificacion);
    }
}
