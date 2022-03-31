package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.persistencia.FabricaParametroPersistenciaUsuario;
import com.ceiba.usuario.adaptador.persistencia.MapeoDtoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private static final String ID = "id";
    private static final String IDENTIFICACION = "identificacion";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final FabricaParametroPersistenciaUsuario fabricaParametroPersistenciaUsuario;

    @SqlStatement(namespace="usuario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="usuario", value="buscarPorId")
    private static String sqlBuscarPorId;

    @SqlStatement(namespace="usuario", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="usuario", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, FabricaParametroPersistenciaUsuario fabricaParametroPersistenciaUsuario) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.fabricaParametroPersistenciaUsuario = fabricaParametroPersistenciaUsuario;
    }

    @Override
    public Long crear(DtoUsuario dtoUsuario) {
        MapSqlParameterSource parametroPersistenciaCrear = fabricaParametroPersistenciaUsuario.crear(dtoUsuario);
        return this.customNamedParameterJdbcTemplate.crear(sqlCrear, parametroPersistenciaCrear);
    }

    @Override
    public DtoUsuario buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID, id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, paramSource, new MapeoDtoUsuario());
    }

    @Override
    public boolean existe(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(IDENTIFICACION, identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID, id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
