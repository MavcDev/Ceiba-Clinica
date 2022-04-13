package com.ceiba.horario.adaptador.persistencia;

import com.ceiba.horario.modelo.dto.DtoPresentacionHorario;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ceiba.horario.adaptador.persistencia.TablaHorario.*;

public class MapeoDtoPresentacionHorario implements RowMapper<DtoPresentacionHorario>, MapperResult {

    @Override
    public DtoPresentacionHorario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong(ID);
        String horaInicio = resultSet.getString(HORA_INICIAL);
        String horaFinal = resultSet.getString(HORA_FINAL);

        return new DtoPresentacionHorario(id, horaInicio, horaFinal);
    }
}
