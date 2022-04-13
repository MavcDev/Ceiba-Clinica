package com.ceiba.solicitud.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.solicitud.adaptador.persistencia.MapeoDtoPresentacionSolicitud;
import com.ceiba.solicitud.modelo.dto.DtoPresentacionSolicitud;
import com.ceiba.solicitud.puerto.dao.DaoSolicitud;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoSolicitudMysql implements DaoSolicitud {

    private static final String ID_USUARIO = "usuario";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="solicitudcita", value="listarPorUsuario")
    private static String sqlListarPorUsuario;

    public DaoSolicitudMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPresentacionSolicitud> buscarPorIdUsuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_USUARIO, idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorUsuario, paramSource, new MapeoDtoPresentacionSolicitud());
    }
}
