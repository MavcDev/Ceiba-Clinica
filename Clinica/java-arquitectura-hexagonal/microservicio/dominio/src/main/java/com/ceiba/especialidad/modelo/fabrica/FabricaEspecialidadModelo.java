package com.ceiba.especialidad.modelo.fabrica;

import com.ceiba.especialidad.modelo.dto.DtoEspecialidad;
import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.especialidad.puerto.repositorio.RepositorioEspecialidad;

public class FabricaEspecialidadModelo {

    private final RepositorioEspecialidad repositorioEspecialidad;

    public FabricaEspecialidadModelo(RepositorioEspecialidad repositorioEspecialidad) {
        this.repositorioEspecialidad = repositorioEspecialidad;
    }

    public Especialidad crear(DtoEspecialidad dtoEspecialidad){
        return new Especialidad(
                dtoEspecialidad.getId(),
                dtoEspecialidad.getNombre(),
                dtoEspecialidad.getValor()
        );
    }

    public DtoEspecialidad crear(Especialidad especialidad){
        return new DtoEspecialidad(
                especialidad.getId(),
                especialidad.getNombre(),
                especialidad.getValor()
        );
    }

    public Especialidad buscarCrear(Long id){
        DtoEspecialidad dtoEspecialidad = repositorioEspecialidad.buscarPorId(id);
        return crear(dtoEspecialidad);
    }
}
