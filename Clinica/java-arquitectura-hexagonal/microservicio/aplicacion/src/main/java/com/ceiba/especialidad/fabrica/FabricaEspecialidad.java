package com.ceiba.especialidad.fabrica;

import com.ceiba.especialidad.modelo.dto.DtoEspecialidad;
import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.especialidad.puerto.repositorio.RepositorioEspecialidad;
import org.springframework.stereotype.Component;

@Component
public class FabricaEspecialidad {

    private final RepositorioEspecialidad repositorioEspecialidad;

    public FabricaEspecialidad(RepositorioEspecialidad repositorioEspecialidad) {
        this.repositorioEspecialidad = repositorioEspecialidad;
    }

    private Especialidad crear(DtoEspecialidad dtoEspecialidad){
        return new Especialidad(
                dtoEspecialidad.getId(),
                dtoEspecialidad.getNombre(),
                dtoEspecialidad.getValor()
        );
    }

    public Especialidad buscarCrear(Long id){
        DtoEspecialidad dtoEspecialidad = repositorioEspecialidad.buscarPorId(id);
        return crear(dtoEspecialidad);
    }
}
