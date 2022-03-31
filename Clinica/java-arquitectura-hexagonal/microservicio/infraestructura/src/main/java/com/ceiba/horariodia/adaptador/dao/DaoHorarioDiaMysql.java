package com.ceiba.horariodia.adaptador.dao;

import com.ceiba.horariodia.adaptador.persistencia.MapeoDtoPresentacionHorarioDia;
import com.ceiba.horariodia.modelo.dto.DtoPresentacionHorarioDia;
import com.ceiba.horariodia.puerto.dao.DaoHorarioDia;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoHorarioDiaMysql implements DaoHorarioDia {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="horariodia", value="listar")
    private static String sqlListar;

    public DaoHorarioDiaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPresentacionHorarioDia> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDtoPresentacionHorarioDia());
    }
}
