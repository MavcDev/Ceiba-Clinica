package com.ceiba.solicitudcita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionSolicitudCita;
import com.ceiba.especialidad.modelo.dto.DtoEspecialidad;
import com.ceiba.especialidad.modelo.entidad.Especialidad;
import com.ceiba.especialidad.modelo.fabrica.FabricaEspecialidadModelo;
import com.ceiba.especialidad.puerto.repositorio.RepositorioEspecialidad;
import com.ceiba.especialidad.servicio.testdatabuilder.EspecialidadTestDataBuilder;
import com.ceiba.horariodia.modelo.dto.DtoHorarioDia;
import com.ceiba.horariodia.modelo.entidad.HorarioDia;
import com.ceiba.horariodia.modelo.fabrica.FabricaHorarioDiaModelo;
import com.ceiba.horariodia.puerto.repositorio.RepositorioHorarioDia;
import com.ceiba.horariodia.servicio.testdatabuilder.HorarioDiaTestDataBuilder;
import com.ceiba.medico.modelo.dto.DtoMedico;
import com.ceiba.medico.modelo.entidad.Medico;
import com.ceiba.medico.modelo.fabrica.FabricaMedicoModelo;
import com.ceiba.medico.puerto.repositorio.RepositorioMedico;
import com.ceiba.medico.servicio.testdatabuilder.MedicoTestDataBuilder;
import com.ceiba.solicitudcita.modelo.dto.DtoEntradaCrearSolicitudCita;
import com.ceiba.solicitudcita.modelo.entidad.SolicitudCita;
import com.ceiba.solicitudcita.puerto.repositorio.RepositorioSolicitudCita;
import com.ceiba.solicitudcita.servicio.testdatabuilder.SolicitudCitaTestDataBuilder;
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
import java.time.format.DateTimeFormatter;

import static com.ceiba.solicitudcita.modelo.entidad.SolicitudCita.EL_MEDICO_YA_TIENE_SOLICITUD_FECHA_HORA;
import static com.ceiba.solicitudcita.modelo.entidad.SolicitudCita.EL_USUARIO_YA_TIENE_SOLICITUD_FECHA;
import static com.ceiba.solicitudcita.servicio.ServicioCrearSolicitudCita.EL_USUARIO_NO_EXISTE;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ServicioCrearSolicitudCitaTest {

    private String fechaCitaFormateada;
    private Usuario usuario;
    private Medico medico;
    private HorarioDia horarioDia;
    private Especialidad especialidad;

    private DtoEntradaCrearSolicitudCita dtoEntradaCrearSolicitudCita;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioMedico repositorioMedico;
    private RepositorioEspecialidad repositorioEspecialidad;
    private RepositorioHorarioDia repositorioHorarioDia;
    private RepositorioSolicitudCita repositorioSolicitudCita;

    @BeforeEach
    void configuracionPreTest(){
        SolicitudCita solicitudCita = new SolicitudCitaTestDataBuilder().conId(20L).build();
        dtoEntradaCrearSolicitudCita = new DtoEntradaCrearSolicitudCita(
                solicitudCita.getId(),
                solicitudCita.getMedico().getId(),
                solicitudCita.getUsuario().getId(),
                solicitudCita.getEspecialidad().getId(),
                solicitudCita.getHorarioDia().getId(),
                solicitudCita.getFechaSolicitud(),
                solicitudCita.getFechaCita()
        );
        fechaCitaFormateada = solicitudCita.formatearFechaCita();

        usuario = new UsuarioTestDataBuilder().conId(1L).build();
        DtoUsuario dtoUsuario = new FabricaUsuarioModelo(null).crear(usuario);
        medico = new MedicoTestDataBuilder().conId(1L).build();
        DtoMedico dtoMedico = new FabricaMedicoModelo(null, null).crear(medico);
        especialidad = new EspecialidadTestDataBuilder().conId(1L).build();
        DtoEspecialidad dtoEspecialidad = new FabricaEspecialidadModelo(null).crear(especialidad);
        horarioDia = new HorarioDiaTestDataBuilder().conId(1L).build();
        DtoHorarioDia dtoHorarioDia = new FabricaHorarioDiaModelo(null).crear(horarioDia);

        repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.buscarPorId(Mockito.anyLong())).thenReturn(dtoUsuario);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);

        repositorioMedico = Mockito.mock(RepositorioMedico.class);
        Mockito.when(repositorioMedico.buscarPorId(Mockito.anyLong())).thenReturn(dtoMedico);

        repositorioEspecialidad = Mockito.mock(RepositorioEspecialidad.class);
        Mockito.when(repositorioEspecialidad.buscarPorId(Mockito.anyLong())).thenReturn(dtoEspecialidad);

        repositorioHorarioDia = Mockito.mock(RepositorioHorarioDia.class);
        Mockito.when(repositorioHorarioDia.buscarPorId(Mockito.anyLong())).thenReturn(dtoHorarioDia);

        repositorioSolicitudCita = Mockito.mock(RepositorioSolicitudCita.class);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de una solictud de cita con un usuario y en fecha")
    void deberiaLanzarUnaExepcionCuandoExistaSolicitudCitaPorUsuarioYFecha() {
        Mockito.when(repositorioSolicitudCita.existeSolicitudCitaPorUsuarioFecha(Mockito.anyLong(), Mockito.any())).thenReturn(true);

        ServicioCrearSolicitudCita servicioCrearSolicitudCita = instanciaServicioCrearSolicitudCita();

        String mensajeExcepcion = String.format(EL_USUARIO_YA_TIENE_SOLICITUD_FECHA, usuario.getNombreCompleto(), fechaCitaFormateada);
        probarEjecutarDeServicioCrearSolicitudCita(servicioCrearSolicitudCita, mensajeExcepcion);
    }

    @Test
    @DisplayName("Deberia lanzar uan excepcion cuando se valide la existencia de una solicitud de cita de un medico en una fecha y hora")
    void deberiaLanzarUnaExepcionCuandoExistaSolicitudCitaDeUnMedicoEnFechaHora() {
        Mockito.when(repositorioSolicitudCita.existeSolcitudCitaPorMedicoFechaHorario(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(true);

        ServicioCrearSolicitudCita servicioCrearSolicitudCita = instanciaServicioCrearSolicitudCita();

        String mensajeExepcion = String.format(EL_MEDICO_YA_TIENE_SOLICITUD_FECHA_HORA, medico.getNombreCompleto(), fechaCitaFormateada, horarioDia.getHoraCompleta());
        probarEjecutarDeServicioCrearSolicitudCita(servicioCrearSolicitudCita, mensajeExepcion);
    }

    @Test
    @DisplayName("Deberia crear la solicitud de cita de manera correcta")
    void deberiaCrearLaSolicitudCitaDeManeraCorrecta() {
        Mockito.when(repositorioSolicitudCita.existeSolicitudCitaPorUsuarioFecha(Mockito.anyLong(), Mockito.any())).thenReturn(false);
        Mockito.when(repositorioSolicitudCita.existeSolcitudCitaPorMedicoFechaHorario(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSolicitudCita.crear(Mockito.any())).thenReturn(20L);

        ServicioCrearSolicitudCita servicioCrearSolicitudCita = instanciaServicioCrearSolicitudCita();
        Long idSolicitud =  servicioCrearSolicitudCita.ejecutar(dtoEntradaCrearSolicitudCita);

        assertEquals(idSolicitud, dtoEntradaCrearSolicitudCita.getId());
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion si el usuario no existe")
    void deberiaLanzarExcepcionUsuarioNoExiste() {
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSolicitudCita.existeSolicitudCitaPorUsuarioFecha(Mockito.anyLong(), Mockito.any())).thenReturn(false);
        Mockito.when(repositorioSolicitudCita.existeSolcitudCitaPorMedicoFechaHorario(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSolicitudCita.crear(Mockito.any())).thenReturn(20L);

        ServicioCrearSolicitudCita servicioCrearSolicitudCita = instanciaServicioCrearSolicitudCita();

        BasePrueba.assertThrows(() -> servicioCrearSolicitudCita.ejecutar(dtoEntradaCrearSolicitudCita), ExcepcionSinDatos.class, EL_USUARIO_NO_EXISTE);
    }

    @Test
    @DisplayName("Verificar si se aplico el descuento de menor de edad")
    void verificarSiAplicoDescuentoMenorEdad() {
        LocalDate fechaNacimiento = LocalDate.from(LocalDate.of(2015,1,1));
        Usuario usuarioMenor = new UsuarioTestDataBuilder().conId(1L).conFechaNacimiento(fechaNacimiento).build();

        SolicitudCita solicitudCita = new SolicitudCitaTestDataBuilder().conUsuario(usuarioMenor).build();
        solicitudCita.calcularValorCita();

        assertEquals(solicitudCita.getEspecialidad().getValor().multiply(BigDecimal.valueOf(0.5)), solicitudCita.getValor());
    }

    private ServicioCrearSolicitudCita instanciaServicioCrearSolicitudCita(){
        return new ServicioCrearSolicitudCita(
                repositorioSolicitudCita,
                repositorioUsuario,
                repositorioMedico,
                repositorioEspecialidad,
                repositorioHorarioDia
        );
    }

    private void probarEjecutarDeServicioCrearSolicitudCita(ServicioCrearSolicitudCita servicioCrearSolicitudCita, String mensajeExcepcion){
        BasePrueba.assertThrows(() -> servicioCrearSolicitudCita.ejecutar(dtoEntradaCrearSolicitudCita), ExcepcionSolicitudCita.class, mensajeExcepcion);
    }
}
