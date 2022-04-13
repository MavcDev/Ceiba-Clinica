package com.ceiba.medico.fabrica;

import com.ceiba.especialidad.fabrica.FabricaEspecialidad;
import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.medico.modelo.dto.DtoMedico;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.medico.puerto.repositorio.RepositorioMedico;
import org.springframework.stereotype.Component;

@Component
public class FabricaMedico {

    private final RepositorioMedico repositorioMedico;
    private final FabricaEspecialidad fabricaEspecialidad;

    public FabricaMedico(RepositorioMedico repositorioMedico, FabricaEspecialidad fabricaEspecialidad) {
        this.repositorioMedico = repositorioMedico;
        this.fabricaEspecialidad = fabricaEspecialidad;
    }

    public Medico crear(DtoMedico dtoMedico){
        Especialidad especialidad = fabricaEspecialidad.buscarCrear(dtoMedico.getEspecialidad());
        return new Medico(
                dtoMedico.getId(),
                dtoMedico.getIdentificacion(),
                dtoMedico.getNombres(),
                dtoMedico.getPrimerApellido(),
                dtoMedico.getSegundoApellido(),
                dtoMedico.getFechaNacimiento(),
                especialidad
        );
    }

    public Medico buscarCrear(Long id){
        DtoMedico dtoMedico = repositorioMedico.buscarPorId(id);
        return crear(dtoMedico);
    }
}
