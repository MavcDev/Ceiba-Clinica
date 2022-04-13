package com.ceiba.horario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ceiba.horario.modelo.entidad.Horario.SE_DEBE_INGRESAR_LA_HORA_FINAL;
import static com.ceiba.horario.modelo.entidad.Horario.SE_DEBE_INGRESAR_LA_HORA_INICIAL;

class HorarioTest {

    @Test
    @DisplayName("Deberia fallar sin hora inicial de horario dia")
    void deberiaFallarSinHoraInicialDeHorarioDia() {
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conHorarioInicial(null);
        probarExcepcionValorObligatorio(horarioTestDataBuilder, SE_DEBE_INGRESAR_LA_HORA_INICIAL);
    }

    @Test
    @DisplayName("Deberia fallar sin hora final de horario dia")
    void deberiaFallarSinHoraFinalDeHorarioDia() {
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conHorarioFinal(null);
        probarExcepcionValorObligatorio(horarioTestDataBuilder, SE_DEBE_INGRESAR_LA_HORA_FINAL);
    }

    void probarExcepcionValorObligatorio(HorarioTestDataBuilder horarioTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, mensajeExcepcion);
    }

}
