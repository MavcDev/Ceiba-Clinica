package com.ceiba.especialidad.adaptador.persistencia;

import com.ceiba.especialidad.modelo.dto.DtoPresentacionEspecialidad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ceiba.especialidad.adaptador.persistencia.TablaEspecialidad.*;

public class MapeoDtoPresentacionEspecialidad implements RowMapper<DtoPresentacionEspecialidad>, MapperResult {

    @Override
    public DtoPresentacionEspecialidad mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong(ID);
        String nombre = resultSet.getString(NOMBRE);
        BigDecimal valor = resultSet.getBigDecimal(VALOR);

        return new DtoPresentacionEspecialidad(id, nombre, valor);
    }
}
