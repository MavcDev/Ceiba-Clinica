package com.ceiba.usuario.adaptador.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoPresentacionUsuario;
import org.springframework.jdbc.core.RowMapper;

import static com.ceiba.usuario.adaptador.persistencia.TablaUsuario.*;

public class MapeoDtoPresentacionUsuario implements RowMapper<DtoPresentacionUsuario>, MapperResult {

    private static final String NOMBRE_COMPLETO = "nombre_completo";

    @Override
    public DtoPresentacionUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong(ID);
        String identificacion = resultSet.getString(IDENTIFICACION);
        String nombreCompleto = resultSet.getString(NOMBRE_COMPLETO);
        LocalDate fechaNacimiento = extraerLocalDate(resultSet,FECHA_NACIMIENTO);

        return new DtoPresentacionUsuario(id,identificacion,nombreCompleto,fechaNacimiento);
    }
}
