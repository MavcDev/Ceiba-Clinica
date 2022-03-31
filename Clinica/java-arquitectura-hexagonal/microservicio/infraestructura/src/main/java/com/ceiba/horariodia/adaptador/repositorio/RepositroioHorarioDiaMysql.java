package com.ceiba.horariodia.adaptador.repositorio;

import com.ceiba.horariodia.adaptador.persistencia.MapeoDtoHorarioDia;
import com.ceiba.horariodia.modelo.dto.DtoHorarioDia;
import com.ceiba.horariodia.puerto.repositorio.RepositorioHorarioDia;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositroioHorarioDiaMysql implements RepositorioHorarioDia {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="horariodia", value="buscarPorId")
    private static String sqlBuscarPorId;

    public RepositroioHorarioDiaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoHorarioDia buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, paramSource, new MapeoDtoHorarioDia());
    }
}
