package com.ceiba.solicitudcita.adaptador.persistencia;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.solicitudcita.modelo.dto.DtoPresentacionSolicitudCita;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.solicitudcita.adaptador.persistencia.TablaSolicitudCita.*;

public class MapeoDtoPresentacionSolicitudCita implements RowMapper<DtoPresentacionSolicitudCita>, MapperResult {

    private static final String NOMBRE_MEDICO = "medico";
    private static final String IDENTIFICACION_USUARIO = "identificacion_usuario";
    private static final String NOMBRE_USUARIO = "usuario";
    private static final String NOMBRE_ESPECIALIDAD = "especialidad";
    private static final String HORA_INICIO = "horario_inicio";
    private static final String HORA_FINAL = "horario_final";
    private static final String VALOR_BASE = "valor_base";

    @Override
    public DtoPresentacionSolicitudCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong(ID);
        String medico = resultSet.getString(NOMBRE_MEDICO);
        String identificacionUsuario = resultSet.getString(IDENTIFICACION_USUARIO);
        String usuario = resultSet.getString(NOMBRE_USUARIO);
        String especialidad = resultSet.getString(NOMBRE_ESPECIALIDAD);
        LocalDateTime fechaSolicitud = extraerLocalDateTime(resultSet, FECHA_SOLICITUD) ;
        LocalDate fechaCita = extraerLocalDate(resultSet, FECHA_CITA);
        String horarioInicio = resultSet.getString(HORA_INICIO);
        String horarioFinal = resultSet.getString(HORA_FINAL);
        BigDecimal valor = resultSet.getBigDecimal(VALOR);
        BigDecimal valorBase = resultSet.getBigDecimal(VALOR_BASE);
        Boolean aplicaDescuentoMenorEdad = resultSet.getBoolean(APLICA_DESCUENTO_MENOR_EDAD);

        return new DtoPresentacionSolicitudCita(id, medico, identificacionUsuario,usuario, especialidad, fechaSolicitud, fechaCita, horarioInicio, horarioFinal, valor, valorBase, aplicaDescuentoMenorEdad);
    }
}
