package com.ceiba.medico.adaptador.persistencia;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.medico.modelo.dto.DtoMedico;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static com.ceiba.medico.adaptador.persistencia.TablaMedico.*;

public class MapeoDtoMedico implements RowMapper<DtoMedico>, MapperResult {
    @Override
    public DtoMedico mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong(ID);
        String identificacion = resultSet.getString(IDENTIFICACION);
        String nombres = resultSet.getString(NOMBRE);
        String primerApellido = resultSet.getString(PRIMER_APELLIDO);
        String segundoApellido = resultSet.getString(SEGUNDO_APELLIDO);
        Long especialidad = resultSet.getLong(ESPECIALIDAD);
        LocalDate fechaNacimiento = extraerLocalDate(resultSet, FECHA_NACIMIENTO);

        return new DtoMedico(id, identificacion, nombres, primerApellido, segundoApellido,fechaNacimiento, especialidad);
    }
}
