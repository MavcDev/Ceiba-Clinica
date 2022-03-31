package com.ceiba.especialidad.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.especialidad.servicio.testdatabuilder.EspecialidadTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ceiba.especialidad.modelo.entidad.Especialidad.SE_DEBE_INGRESAR_EL_NOMBRE;
import static com.ceiba.especialidad.modelo.entidad.Especialidad.SE_DEBE_INGRESAR_EL_VALOR;


class EspecialidadTest {

    @Test
    @DisplayName("Deberia fallar sin nombre de especialidad")
    void deberiaFallarSinNombreDeEspecialidad() {
        EspecialidadTestDataBuilder especialidadTestDataBuilder = new EspecialidadTestDataBuilder().conNombre(null);
        probarExcepcionValorObligatorio(especialidadTestDataBuilder, SE_DEBE_INGRESAR_EL_NOMBRE);
    }

    @Test
    @DisplayName("Deberia fallar sin valor de especialidad")
    void deberiaFallarSinValorDeEspecialidad() {
        EspecialidadTestDataBuilder especialidadTestDataBuilder = new EspecialidadTestDataBuilder().conValor(null);
        probarExcepcionValorObligatorio(especialidadTestDataBuilder, SE_DEBE_INGRESAR_EL_VALOR);
    }

    void probarExcepcionValorObligatorio(EspecialidadTestDataBuilder especialidadTestDataBuilder, String mensajeExcepcion){
        BasePrueba.assertThrows(() -> {
                    especialidadTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, mensajeExcepcion);
    }
}
