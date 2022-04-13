package com.ceiba.horario.adaptador.persistencia;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ceiba.horario.adaptador.persistencia.TablaHorario.*;

public class MapeoDtoHorario implements RowMapper<DtoHorario>, MapperResult {

    @Override
    public DtoHorario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong(ID);
        String horaInicio = resultSet.getString(HORA_INICIAL);
        String horaFinal = resultSet.getString(HORA_FINAL);

        return new DtoHorario(id, horaInicio, horaFinal);
    }
}
