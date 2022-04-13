package com.ceiba.horario.adaptador.repositorio;

import com.ceiba.horario.adaptador.persistencia.MapeoDtoHorario;
import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositroioHorarioMysql implements RepositorioHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="horariodia", value="buscarPorId")
    private static String sqlBuscarPorId;

    public RepositroioHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoHorario buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, paramSource, new MapeoDtoHorario());
    }
}
