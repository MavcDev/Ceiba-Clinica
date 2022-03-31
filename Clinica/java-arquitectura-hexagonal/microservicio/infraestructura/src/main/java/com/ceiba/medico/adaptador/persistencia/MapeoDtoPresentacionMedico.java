package com.ceiba.medico.adaptador.persistencia;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.medico.modelo.dto.DtoPresentacionMedico;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ceiba.medico.adaptador.persistencia.TablaMedico.ID;

public class MapeoDtoPresentacionMedico implements RowMapper<DtoPresentacionMedico>, MapperResult {

    private static final String NOMBRE_COMPLETO = "nombre_completo";

    @Override
    public DtoPresentacionMedico mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong(ID);
        String nombreCompleto = resultSet.getString(NOMBRE_COMPLETO);

        return new DtoPresentacionMedico(id, nombreCompleto);
    }
}
