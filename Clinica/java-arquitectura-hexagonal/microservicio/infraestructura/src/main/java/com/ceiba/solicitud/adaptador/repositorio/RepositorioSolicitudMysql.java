package com.ceiba.solicitud.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.solicitud.adaptador.persistencia.ParametroPersistenciaSolicitud;
import com.ceiba.solicitud.modelo.dto.DtoSolicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class RepositorioSolicitudMysql implements RepositorioSolicitud {

    private static final String ID_USUARIO = "usuario";
    private static final String FECHA_CITA = "fecha_cita";
    private static final String ID_MEDICO = "medico";
    private static final String ID_HORARIO = "horario";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final ParametroPersistenciaSolicitud parametroPersistenciaSolicitud;

    @SqlStatement(namespace="solicitudcita", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="solicitudcita", value="existePorUsuarioFecha")
    private static String sqlExistePorUsuarioFecha;

    @SqlStatement(namespace="solicitudcita", value="existePorMedicoFechaHorario")
    private static String sqlExistePorMedicoFechaHorario;

    public RepositorioSolicitudMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, ParametroPersistenciaSolicitud parametroPersistenciaSolicitud) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.parametroPersistenciaSolicitud = parametroPersistenciaSolicitud;
    }

    @Override
    public Long crear(DtoSolicitud dtoSolicitud) {
        MapSqlParameterSource parametroPersistenciaCrear = parametroPersistenciaSolicitud.crear(dtoSolicitud);
        return this.customNamedParameterJdbcTemplate.crear(sqlCrear, parametroPersistenciaCrear);
    }

    @Override
    public Boolean existeSolicitudCitaPorUsuarioFecha(Long idUsuario, LocalDate fechaCita) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_USUARIO, idUsuario);
        paramSource.addValue(FECHA_CITA, fechaCita);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorUsuarioFecha, paramSource, Boolean.class);
    }

    @Override
    public Boolean existeSolcitudCitaPorMedicoFechaHorario(Long idMedico, LocalDate fechaCita, Long idHorario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_MEDICO, idMedico);
        paramSource.addValue(ID_HORARIO, idHorario);
        paramSource.addValue(FECHA_CITA, fechaCita);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorMedicoFechaHorario, paramSource, Boolean.class);
    }
}
