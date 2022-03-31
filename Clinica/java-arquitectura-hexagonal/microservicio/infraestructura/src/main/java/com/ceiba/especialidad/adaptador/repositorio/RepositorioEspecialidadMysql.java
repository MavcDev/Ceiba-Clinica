package com.ceiba.especialidad.adaptador.repositorio;

import com.ceiba.especialidad.adaptador.persistencia.MapeoDtoEspecialidad;
import com.ceiba.especialidad.modelo.dto.DtoEspecialidad;
import com.ceiba.especialidad.puerto.repositorio.RepositorioEspecialidad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEspecialidadMysql implements RepositorioEspecialidad {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="especialidad", value="buscarPorId")
    private static String sqlBuscarPorId;

    public RepositorioEspecialidadMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoEspecialidad buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, paramSource, new MapeoDtoEspecialidad());
    }
}
