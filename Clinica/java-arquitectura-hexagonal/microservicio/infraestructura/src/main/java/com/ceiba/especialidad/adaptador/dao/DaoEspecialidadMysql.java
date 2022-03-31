package com.ceiba.especialidad.adaptador.dao;

import com.ceiba.especialidad.adaptador.persistencia.MapeoDtoPresentacionEspecialidad;
import com.ceiba.especialidad.modelo.dto.DtoPresentacionEspecialidad;
import com.ceiba.especialidad.puerto.dao.DaoEspecialidad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEspecialidadMysql implements DaoEspecialidad {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="especialidad", value="listar")
    private static String sqlListar;

    public DaoEspecialidadMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPresentacionEspecialidad> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDtoPresentacionEspecialidad());
    }
}
