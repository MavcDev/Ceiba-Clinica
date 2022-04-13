package com.ceiba.solicitud.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionSolicitudCita;
import com.ceiba.especialidad.modelo.dto.DtoEspecialidad;
import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.especialidad.modelo.fabrica.FabricaEspecialidadModelo;
import com.ceiba.especialidad.puerto.repositorio.RepositorioEspecialidad;
import com.ceiba.especialidad.servicio.testdatabuilder.EspecialidadTestDataBuilder;
import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.modelo.fabrica.FabricaHorarioModelo;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import com.ceiba.medico.modelo.dto.DtoMedico;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.medico.modelo.fabrica.FabricaMedicoModelo;
import com.ceiba.medico.puerto.repositorio.RepositorioMedico;
import com.ceiba.medico.servicio.testdatabuilder.MedicoTestDataBuilder;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.solicitud.servicio.testdatabuilder.SolicitudCitaTestDataBuilder;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.modelo.fabrica.FabricaUsuarioModelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.ceiba.solicitud.modelo.entidad.Solicitud.EL_MEDICO_YA_TIENE_SOLICITUD_FECHA_HORA;
import static com.ceiba.solicitud.modelo.entidad.Solicitud.EL_USUARIO_YA_TIENE_SOLICITUD_FECHA;
import static com.ceiba.solicitud.servicio.ServicioCrearSolicitud.EL_USUARIO_NO_EXISTE;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ServicioCrearSolicitudTest {

    private String fechaCitaFormateada;
    private Usuario usuario;
    private Medico medico;
    private Horario horario;
    private Especialidad especialidad;

    private Solicitud solicitud;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioMedico repositorioMedico;
    private RepositorioEspecialidad repositorioEspecialidad;
    private RepositorioHorario repositorioHorario;
    private RepositorioSolicitud repositorioSolicitud;

    @BeforeEach
    void configuracionPreTest(){
        solicitud = new SolicitudCitaTestDataBuilder().conId(20L).build();
        fechaCitaFormateada = solicitud.formatearFechaCita();

        usuario = new UsuarioTestDataBuilder().conId(1L).build();
        DtoUsuario dtoUsuario = new FabricaUsuarioModelo().crear(usuario);
        medico = new MedicoTestDataBuilder().conId(1L).build();
        DtoMedico dtoMedico = new FabricaMedicoModelo().crear(medico);
        especialidad = new EspecialidadTestDataBuilder().conId(1L).build();
        DtoEspecialidad dtoEspecialidad = new FabricaEspecialidadModelo().crear(especialidad);
        horario = new HorarioTestDataBuilder().conId(1L).build();
        DtoHorario dtoHorario = new FabricaHorarioModelo().crear(horario);

        repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.buscarPorId(Mockito.anyLong())).thenReturn(dtoUsuario);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);

        repositorioMedico = Mockito.mock(RepositorioMedico.class);
        Mockito.when(repositorioMedico.buscarPorId(Mockito.anyLong())).thenReturn(dtoMedico);

        repositorioEspecialidad = Mockito.mock(RepositorioEspecialidad.class);
        Mockito.when(repositorioEspecialidad.buscarPorId(Mockito.anyLong())).thenReturn(dtoEspecialidad);

        repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.buscarPorId(Mockito.anyLong())).thenReturn(dtoHorario);

        repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de una solictud de cita con un usuario y en fecha")
    void deberiaLanzarUnaExepcionCuandoExistaSolicitudCitaPorUsuarioYFecha() {
        Mockito.when(repositorioSolicitud.existeSolicitudCitaPorUsuarioFecha(Mockito.anyLong(), Mockito.any())).thenReturn(true);

        ServicioCrearSolicitud servicioCrearSolicitud = instanciaServicioCrearSolicitudCita();

        String mensajeExcepcion = String.format(EL_USUARIO_YA_TIENE_SOLICITUD_FECHA, usuario.getNombreCompleto(), fechaCitaFormateada);
        probarEjecutarDeServicioCrearSolicitudCita(servicioCrearSolicitud, mensajeExcepcion);
    }

    @Test
    @DisplayName("Deberia lanzar uan excepcion cuando se valide la existencia de una solicitud de cita de un medico en una fecha y hora")
    void deberiaLanzarUnaExepcionCuandoExistaSolicitudCitaDeUnMedicoEnFechaHora() {
        Mockito.when(repositorioSolicitud.existeSolcitudCitaPorMedicoFechaHorario(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(true);

        ServicioCrearSolicitud servicioCrearSolicitud = instanciaServicioCrearSolicitudCita();

        String mensajeExepcion = String.format(EL_MEDICO_YA_TIENE_SOLICITUD_FECHA_HORA, medico.getNombreCompleto(), fechaCitaFormateada, horario.getHoraCompleta());
        probarEjecutarDeServicioCrearSolicitudCita(servicioCrearSolicitud, mensajeExepcion);
    }

    @Test
    @DisplayName("Deberia crear la solicitud de cita de manera correcta")
    void deberiaCrearLaSolicitudCitaDeManeraCorrecta() {
        Mockito.when(repositorioSolicitud.existeSolicitudCitaPorUsuarioFecha(Mockito.anyLong(), Mockito.any())).thenReturn(false);
        Mockito.when(repositorioSolicitud.existeSolcitudCitaPorMedicoFechaHorario(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSolicitud.crear(Mockito.any())).thenReturn(20L);

        ServicioCrearSolicitud servicioCrearSolicitud = instanciaServicioCrearSolicitudCita();
        Long idSolicitud =  servicioCrearSolicitud.ejecutar(solicitud);

        assertEquals(idSolicitud, solicitud.getId());
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion si el usuario no existe")
    void deberiaLanzarExcepcionUsuarioNoExiste() {
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSolicitud.existeSolicitudCitaPorUsuarioFecha(Mockito.anyLong(), Mockito.any())).thenReturn(false);
        Mockito.when(repositorioSolicitud.existeSolcitudCitaPorMedicoFechaHorario(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSolicitud.crear(Mockito.any())).thenReturn(20L);

        ServicioCrearSolicitud servicioCrearSolicitud = instanciaServicioCrearSolicitudCita();

        BasePrueba.assertThrows(() -> servicioCrearSolicitud.ejecutar(solicitud), ExcepcionSinDatos.class, EL_USUARIO_NO_EXISTE);
    }

    @Test
    @DisplayName("Verificar si se aplico el descuento de menor de edad")
    void verificarSiAplicoDescuentoMenorEdad() {
        LocalDate fechaNacimiento = LocalDate.from(LocalDate.of(2015,1,1));
        Usuario usuarioMenor = new UsuarioTestDataBuilder().conId(1L).conFechaNacimiento(fechaNacimiento).build();

        Solicitud solicitud = new SolicitudCitaTestDataBuilder().conUsuario(usuarioMenor).build();
        solicitud.calcularValorCita();

        assertEquals(solicitud.getEspecialidad().getValor().multiply(BigDecimal.valueOf(0.5)), solicitud.getValor());
    }

    private ServicioCrearSolicitud instanciaServicioCrearSolicitudCita(){
        return new ServicioCrearSolicitud(repositorioSolicitud, repositorioUsuario);
    }

    private void probarEjecutarDeServicioCrearSolicitudCita(ServicioCrearSolicitud servicioCrearSolicitud, String mensajeExcepcion){

        BasePrueba.assertThrows(() -> servicioCrearSolicitud.ejecutar(solicitud), ExcepcionSolicitudCita.class, mensajeExcepcion);
    }
}
