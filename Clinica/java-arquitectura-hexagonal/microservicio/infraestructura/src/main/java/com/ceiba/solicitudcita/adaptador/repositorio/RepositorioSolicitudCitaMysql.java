package com.ceiba.solicitudcita.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.solicitudcita.adaptador.persistencia.ParametroPersistenciaSolicitudCita;
import com.ceiba.solicitudcita.modelo.dto.DtoSolicitudCita;
import com.ceiba.solicitudcita.puerto.repositorio.RepositorioSolicitudCita;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class RepositorioSolicitudCitaMysql implements RepositorioSolicitudCita {

    private static final String ID_USUARIO = "usuario";
    private static final String FECHA_CITA = "fecha_cita";
    private static final String ID_MEDICO = "medico";
    private static final String ID_HORARIO = "horario";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final ParametroPersistenciaSolicitudCita parametroPersistenciaSolicitudCita;

    @SqlStatement(namespace="solicitudcita", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="solicitudcita", value="existePorUsuarioFecha")
    private static String sqlExistePorUsuarioFecha;

    @SqlStatement(namespace="solicitudcita", value="existePorMedicoFechaHorario")
    private static String sqlExistePorMedicoFechaHorario;

    public RepositorioSolicitudCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, ParametroPersistenciaSolicitudCita parametroPersistenciaSolicitudCita) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.parametroPersistenciaSolicitudCita = parametroPersistenciaSolicitudCita;
    }

    @Override
    public Long crear(DtoSolicitudCita dtoSolicitudCita) {
        MapSqlParameterSource parametroPersistenciaCrear = parametroPersistenciaSolicitudCita.crear(dtoSolicitudCita);
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
