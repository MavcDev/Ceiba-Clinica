package com.ceiba.medico.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.medico.adaptador.persistencia.MapeoDtoMedico;
import com.ceiba.medico.modelo.dto.DtoMedico;
import com.ceiba.medico.puerto.repositorio.RepositorioMedico;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMedicoMysql implements RepositorioMedico {

    private static final String ID = "id";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="medico", value="buscarPorId")
    private static String sqlBuscarPorId;

    public RepositorioMedicoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoMedico buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID, id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId,paramSource, new MapeoDtoMedico());
    }
}
