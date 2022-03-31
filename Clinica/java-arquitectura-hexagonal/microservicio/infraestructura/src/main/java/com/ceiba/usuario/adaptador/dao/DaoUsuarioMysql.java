package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.persistencia.MapeoDtoPresentacionUsuario;
import com.ceiba.usuario.modelo.dto.DtoPresentacionUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoUsuarioMysql implements DaoUsuario {

    private static final String IDENTIFICACION = "identificacion";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="buscarPorIndentificacion")
    private static String sqlBuscarPorIndentificacion;

    public DaoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoPresentacionUsuario buscarPorIdentificacion(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(IDENTIFICACION, identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorIndentificacion, paramSource, new MapeoDtoPresentacionUsuario());
    }
}
