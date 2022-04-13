package com.ceiba.medico.modelo.fabrica;


import com.ceiba.medico.modelo.dto.DtoMedico;
import com.ceiba.medico.modelo.entidad.Medico;


public class FabricaMedicoModelo {

    public DtoMedico crear(Medico medico){
        return new DtoMedico(
                medico.getId(),
                medico.getIdentificacion(),
                medico.getNombres(),
                medico.getPrimerApellido(),
                medico.getSegundoApellido(),
                medico.getFechaNacimiento(),
                medico.getEspecialidad().getId()
        );
    }
}
