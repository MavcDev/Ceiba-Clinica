package com.ceiba.usuario.adaptador.persistencia;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import static com.ceiba.usuario.adaptador.persistencia.TablaUsuario.*;

@Component
public class FabricaParametroPersistenciaUsuario {

    public MapSqlParameterSource crear(DtoUsuario dtoUsuario){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(ID, dtoUsuario.getId());
        mapSqlParameterSource.addValue(IDENTIFICACION, dtoUsuario.getIdentificacion());
        mapSqlParameterSource.addValue(NOMBRE, dtoUsuario.getNombres());
        mapSqlParameterSource.addValue(PRIMER_APELLIDO, dtoUsuario.getPrimerApellido());
        mapSqlParameterSource.addValue(SEGUNDO_APELLIDO, dtoUsuario.getSegundoApellido());
        mapSqlParameterSource.addValue(FECHA_NACIMIENTO, dtoUsuario.getFechaNacimiento());
        mapSqlParameterSource.addValue(FECHA_CREACION, dtoUsuario.getFechaCreacion());
        return mapSqlParameterSource;
    }
}