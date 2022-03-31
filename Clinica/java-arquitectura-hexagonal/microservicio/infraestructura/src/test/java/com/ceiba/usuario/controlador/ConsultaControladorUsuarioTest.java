package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoUsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorUsuarioTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia buscar un usuario por identificacion")
    void deberiaListarUsuarios() throws Exception {
        ComandoUsuario comandoUsuario = new ComandoUsuarioTestDataBuilder().build();
        mocMvc.perform(get("/usuarios?identificacion=".concat("1117522443"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.identificacion").value("1117522443"))
                .andExpect(jsonPath("$.nombreCompleto").value("Juan Manuel Velasquez Rivera"))
                .andExpect(jsonPath("$.fechaNacimiento").value("2020-12-21"));
    }

    @Test
    @DisplayName("Deberia devolver not found, no se encontro el usuario por identificacion")
    void deberiaTraerNoFoundNoEncontroElUsuario() throws Exception {
        ComandoUsuario comandoUsuario = new ComandoUsuarioTestDataBuilder().build();
        mocMvc.perform(get("/usuarios?identificacion=".concat("111555555"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
