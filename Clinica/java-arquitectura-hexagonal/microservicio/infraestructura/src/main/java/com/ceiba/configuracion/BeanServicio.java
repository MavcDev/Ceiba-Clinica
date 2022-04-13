package com.ceiba.configuracion;

import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.solicitud.servicio.ServicioCrearSolicitud;
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
    public ServicioCrearSolicitud servicioCrearSolicitudCita(RepositorioSolicitud repositorioSolicitud, RepositorioUsuario repositorioUsuario){
        return new ServicioCrearSolicitud(repositorioSolicitud, repositorioUsuario);
    }
}
