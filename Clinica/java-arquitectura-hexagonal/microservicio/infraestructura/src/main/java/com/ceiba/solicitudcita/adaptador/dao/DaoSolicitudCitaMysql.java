package com.ceiba.solicitudcita.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.solicitudcita.adaptador.persistencia.MapeoDtoPresentacionSolicitudCita;
import com.ceiba.solicitudcita.modelo.dto.DtoPresentacionSolicitudCita;
import com.ceiba.solicitudcita.puerto.dao.DaoSolicitudCita;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoSolicitudCitaMysql implements DaoSolicitudCita {

    private static final String ID_USUARIO = "usuario";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="solicitudcita", value="listarPorUsuario")
    private static String sqlListarPorUsuario;

    public DaoSolicitudCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPresentacionSolicitudCita> buscarPorIdUsuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_USUARIO, idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorUsuario, paramSource, new MapeoDtoPresentacionSolicitudCita());
    }
}
