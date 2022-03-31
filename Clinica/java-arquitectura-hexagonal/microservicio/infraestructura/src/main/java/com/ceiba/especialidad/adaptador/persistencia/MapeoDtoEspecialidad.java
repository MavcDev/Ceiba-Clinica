package com.ceiba.especialidad.adaptador.persistencia;

import com.ceiba.especialidad.modelo.dto.DtoEspecialidad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ceiba.especialidad.adaptador.persistencia.TablaEspecialidad.*;

public class MapeoDtoEspecialidad implements RowMapper<DtoEspecialidad>, MapperResult {

    @Override
    public DtoEspecialidad mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong(ID);
        String nombre = resultSet.getString(NOMBRE);
        BigDecimal valor = resultSet.getBigDecimal(VALOR);

        return new DtoEspecialidad(id, nombre, valor);
    }
}
