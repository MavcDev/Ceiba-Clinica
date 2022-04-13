package com.ceiba.horario.fabrica;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import org.springframework.stereotype.Component;

@Component
public class FabricaHorario {

    private final RepositorioHorario repositorioHorario;

    public FabricaHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    public Horario crear(DtoHorario dtoHorario){
        return new Horario(
                dtoHorario.getId(),
                dtoHorario.getHoraInicio(),
                dtoHorario.getHoraFinal()
        );
    }

    public Horario buscarCrear(Long id){
        DtoHorario dtoHorario = repositorioHorario.buscarPorId(id);
        return crear(dtoHorario);
    }
}
