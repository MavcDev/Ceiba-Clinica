package com.ceiba.medico.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.medico.adaptador.persistencia.MapeoDtoPresentacionMedico;
import com.ceiba.medico.modelo.dto.DtoPresentacionMedico;
import com.ceiba.medico.puerto.dao.DaoMedico;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoMedicoMysql implements DaoMedico {

    private static final String ID_ESPECIALIDAD = "especialidad";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="medico", value="listarPorEspecialidad")
    private static String sqlListarPorEspecialidad;

    public DaoMedicoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPresentacionMedico> listar(Long idEspecialidad) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_ESPECIALIDAD, idEspecialidad);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorEspecialidad, paramSource, new MapeoDtoPresentacionMedico());
    }
}
