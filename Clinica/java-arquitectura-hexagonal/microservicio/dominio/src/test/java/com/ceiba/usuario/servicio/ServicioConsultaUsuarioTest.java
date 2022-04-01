package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.usuario.modelo.dto.DtoPresentacionUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioConsultaUsuarioTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion sin datos")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        DaoUsuario daoUsuario = Mockito.mock(DaoUsuario.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(false);
        ServicioConsultaUsuario servicioConsultaUsuario = new ServicioConsultaUsuario(repositorioUsuario, daoUsuario);

        BasePrueba.assertThrows(() -> servicioConsultaUsuario.buscarPorIdentificacion("1117522445"), ExcepcionSinDatos.class,"El usuario no existe");
    }

    @Test
    @DisplayName("Deberia devolver un dto del usuario")
    void deberiaDevolverUnDtoUsuario() {
        DtoPresentacionUsuario dtoPresentacionUsuario = new DtoPresentacionUsuario(
                1L,
                "1117522445",
                "Carlos Antonio Perez",
                LocalDate.from(LocalDate.of(1989,03,25))
        );
        DaoUsuario daoUsuario = Mockito.mock(DaoUsuario.class);
        Mockito.when(daoUsuario.buscarPorIdentificacion(Mockito.anyString())).thenReturn(dtoPresentacionUsuario);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioConsultaUsuario servicioConsultaUsuario = new ServicioConsultaUsuario(repositorioUsuario, daoUsuario);
        
        DtoPresentacionUsuario dtoPresentacionUsuarioRespuesta = servicioConsultaUsuario.buscarPorIdentificacion("1117522445");

        assertEquals(dtoPresentacionUsuario.getId(), dtoPresentacionUsuarioRespuesta.getId());
        assertEquals(dtoPresentacionUsuario.getIdentificacion(), dtoPresentacionUsuarioRespuesta.getIdentificacion());
    }
}
