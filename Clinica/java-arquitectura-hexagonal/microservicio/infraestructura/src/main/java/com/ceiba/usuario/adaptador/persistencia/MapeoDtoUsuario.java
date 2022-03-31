package com.ceiba.usuario.adaptador.persistencia;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.usuario.adaptador.persistencia.TablaUsuario.*;

public class MapeoDtoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong(ID);
        String identificacion = resultSet.getString(IDENTIFICACION);
        String nombres = resultSet.getString(NOMBRE);
        String primerApellido = resultSet.getString(PRIMER_APELLIDO);
        String segundoApellido = resultSet.getString(SEGUNDO_APELLIDO);
        LocalDate fechaNacimiento = extraerLocalDate(resultSet,FECHA_NACIMIENTO);
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, FECHA_CREACION);

        return new DtoUsuario(id, identificacion, nombres, primerApellido, segundoApellido, fechaNacimiento, fechaCreacion);
    }
}
