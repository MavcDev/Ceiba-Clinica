package com.ceiba.configuracion;

import com.ceiba.especialidad.puerto.repositorio.RepositorioEspecialidad;
import com.ceiba.horariodia.puerto.repositorio.RepositorioHorarioDia;
import com.ceiba.medico.puerto.repositorio.RepositorioMedico;
import com.ceiba.solicitudcita.puerto.repositorio.RepositorioSolicitudCita;
import com.ceiba.solicitudcita.servicio.ServicioCrearSolicitudCita;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioConsultaUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioConsultaUsuario servicioConsultaUsuario(RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario){
        return new ServicioConsultaUsuario(repositorioUsuario, daoUsuario);
    }

    @Bean
    public ServicioCrearSolicitudCita servicioCrearSolicitudCita(
            RepositorioSolicitudCita repositorioSolicitudCita,
            RepositorioUsuario repositorioUsuario,
            RepositorioMedico repositorioMedico,
            RepositorioEspecialidad repositorioEspecialidad,
            RepositorioHorarioDia repositorioHorarioDia){
        return new ServicioCrearSolicitudCita(
                repositorioSolicitudCita, repositorioUsuario, repositorioMedico, repositorioEspecialidad, repositorioHorarioDia);
    }
}
