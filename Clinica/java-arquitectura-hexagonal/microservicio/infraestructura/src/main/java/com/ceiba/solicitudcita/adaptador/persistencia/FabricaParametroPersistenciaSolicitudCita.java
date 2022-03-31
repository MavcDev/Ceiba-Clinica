package com.ceiba.solicitudcita.adaptador.persistencia;

import com.ceiba.solicitudcita.modelo.dto.DtoSolicitudCita;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import static com.ceiba.solicitudcita.adaptador.persistencia.TablaSolicitudCita.*;

@Component
public class FabricaParametroPersistenciaSolicitudCita {

    public MapSqlParameterSource crear(DtoSolicitudCita dtoSolicitudCita){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(ID,  dtoSolicitudCita.getId());
        mapSqlParameterSource.addValue(MEDICO,  dtoSolicitudCita.getMedico());
        mapSqlParameterSource.addValue(USUARIO,  dtoSolicitudCita.getUsuario());
        mapSqlParameterSource.addValue(ESPECIALIDAD,  dtoSolicitudCita.getEspecialidad());
        mapSqlParameterSource.addValue(HORARIO_DIA,  dtoSolicitudCita.getHorarioDia());
        mapSqlParameterSource.addValue(FECHA_SOLICITUD,  dtoSolicitudCita.getFechaSolicitud());
        mapSqlParameterSource.addValue(FECHA_CITA,  dtoSolicitudCita.getFechaCita());
        mapSqlParameterSource.addValue(VALOR,  dtoSolicitudCita.getValor());
        mapSqlParameterSource.addValue(APLICA_DESCUENTO_MENOR_EDAD, dtoSolicitudCita.isDescuentoMenorEdad());
        return mapSqlParameterSource;
    }
}