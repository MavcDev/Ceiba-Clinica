package com.ceiba.medico.modelo.fabrica;

import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.especialidad.modelo.fabrica.FabricaEspecialidadModelo;
import com.ceiba.medico.modelo.dto.DtoMedico;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.medico.puerto.repositorio.RepositorioMedico;


public class FabricaMedicoModelo {

    private final RepositorioMedico repositorioMedico;
    private final FabricaEspecialidadModelo fabricaEspecialidadModelo;

    public FabricaMedicoModelo(RepositorioMedico repositorioMedico, FabricaEspecialidadModelo fabricaEspecialidadModelo) {
        this.repositorioMedico = repositorioMedico;
        this.fabricaEspecialidadModelo = fabricaEspecialidadModelo;
    }

    public Medico crear(DtoMedico dtoMedico){
        Especialidad especialidad = fabricaEspecialidadModelo.buscarCrear(dtoMedico.getEspecialidad());
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

    public Medico buscarCrear(Long id){
        DtoMedico dtoMedico = repositorioMedico.buscarPorId(id);
        return crear(dtoMedico);
    }
}
