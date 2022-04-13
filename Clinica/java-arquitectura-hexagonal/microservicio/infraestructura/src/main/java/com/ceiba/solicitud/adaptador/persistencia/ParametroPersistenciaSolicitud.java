package com.ceiba.solicitud.adaptador.persistencia;

import com.ceiba.solicitud.modelo.dto.DtoSolicitud;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import static com.ceiba.solicitud.adaptador.persistencia.TablaSolicitud.*;

@Component
public class ParametroPersistenciaSolicitud {

    public MapSqlParameterSource crear(DtoSolicitud dtoSolicitud){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(ID,  dtoSolicitud.getId());
        mapSqlParameterSource.addValue(MEDICO,  dtoSolicitud.getMedico());
        mapSqlParameterSource.addValue(USUARIO,  dtoSolicitud.getUsuario());
        mapSqlParameterSource.addValue(ESPECIALIDAD,  dtoSolicitud.getEspecialidad());
        mapSqlParameterSource.addValue(HORARIO_DIA,  dtoSolicitud.getHorarioDia());
        mapSqlParameterSource.addValue(FECHA_SOLICITUD,  dtoSolicitud.getFechaSolicitud());
        mapSqlParameterSource.addValue(FECHA_CITA,  dtoSolicitud.getFechaCita());
        mapSqlParameterSource.addValue(VALOR,  dtoSolicitud.getValor());
        mapSqlParameterSource.addValue(APLICA_DESCUENTO_MENOR_EDAD, dtoSolicitud.isDescuentoMenorEdad());
        return mapSqlParameterSource;
    }
}