package com.ceiba.horariodia.adaptador.persistencia;

import com.ceiba.horariodia.modelo.dto.DtoPresentacionHorarioDia;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ceiba.horariodia.adaptador.persistencia.TablaHorarioDia.*;

public class MapeoDtoPresentacionHorarioDia implements RowMapper<DtoPresentacionHorarioDia>, MapperResult {

    @Override
    public DtoPresentacionHorarioDia mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong(ID);
        String horaInicio = resultSet.getString(HORA_INICIAL);
        String horaFinal = resultSet.getString(HORA_FINAL);

        return new DtoPresentacionHorarioDia(id, horaInicio, horaFinal);
    }
}
