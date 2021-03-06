package com.ceiba.horario.adaptador.dao;

import com.ceiba.horario.adaptador.persistencia.MapeoDtoPresentacionHorario;
import com.ceiba.horario.modelo.dto.DtoPresentacionHorario;
import com.ceiba.horario.puerto.dao.DaoHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoHorarioMysql implements DaoHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="horariodia", value="listar")
    private static String sqlListar;

    public DaoHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPresentacionHorario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDtoPresentacionHorario());
    }
}
