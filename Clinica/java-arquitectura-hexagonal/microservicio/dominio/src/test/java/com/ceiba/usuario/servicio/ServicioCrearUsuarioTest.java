package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.modelo.fabrica.FabricaUsuarioModelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearUsuarioTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        Usuario usuario = new UsuarioTestDataBuilder().build();
        DtoUsuario dtoUsuario = new FabricaUsuarioModelo(null).crear(usuario);

        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);

        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);

        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(dtoUsuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el usuario de manera correcta")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        Usuario usuario = new UsuarioTestDataBuilder().build();
        DtoUsuario dtoUsuario = new FabricaUsuarioModelo(null).crear(usuario);

        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioUsuario.crear(Mockito.any(DtoUsuario.class))).thenReturn(10L);

        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        Long idUsuario = servicioCrearUsuario.ejecutar(dtoUsuario);

        assertEquals(10L,idUsuario);
        Mockito.verify(repositorioUsuario, Mockito.times(1)).crear(dtoUsuario);
    }
}
