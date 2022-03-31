package com.ceiba.horariodia.modelo.fabrica;

import com.ceiba.horariodia.modelo.dto.DtoHorarioDia;
import com.ceiba.horariodia.modelo.entidad.HorarioDia;
import com.ceiba.horariodia.puerto.repositorio.RepositorioHorarioDia;

public class FabricaHorarioDiaModelo {

    private final RepositorioHorarioDia repositorioHorarioDia;

    public FabricaHorarioDiaModelo(RepositorioHorarioDia repositorioHorarioDia) {
        this.repositorioHorarioDia = repositorioHorarioDia;
    }

    public HorarioDia crear(DtoHorarioDia dtoHorarioDia){
        return new HorarioDia(
                dtoHorarioDia.getId(),
                dtoHorarioDia.getHoraInicio(),
                dtoHorarioDia.getHoraFinal()
        );
    }

    public DtoHorarioDia crear(HorarioDia horarioDia){
        return new DtoHorarioDia(
                horarioDia.getId(),
                horarioDia.getHoraInicial(),
                horarioDia.getHoraFinal()
        );
    }

    public HorarioDia buscarCrear(Long id){
        DtoHorarioDia dtoHorarioDia = repositorioHorarioDia.buscarPorId(id);
        return crear(dtoHorarioDia);
    }
}
