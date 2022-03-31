package com.ceiba.horariodia.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.horariodia.servicio.testdatabuilder.HorarioDiaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ceiba.horariodia.modelo.entidad.HorarioDia.SE_DEBE_INGRESAR_LA_HORA_FINAL;
import static com.ceiba.horariodia.modelo.entidad.HorarioDia.SE_DEBE_INGRESAR_LA_HORA_INICIAL;

class HorarioDiaTest {

    @Test
    @DisplayName("Deberia fallar sin hora inicial de horario dia")
    void deberiaFallarSinHoraInicialDeHorarioDia() {
        HorarioDiaTestDataBuilder horarioDiaTestDataBuilder = new HorarioDiaTestDataBuilder().conHorarioInicial(null);
        probarExcepcionValorObligatorio(horarioDiaTestDataBuilder, SE_DEBE_INGRESAR_LA_HORA_INICIAL);
    }

    @Test
    @DisplayName("Deberia fallar sin hora final de horario dia")
    void deberiaFallarSinHoraFinalDeHorarioDia() {
        HorarioDiaTestDataBuilder horarioDiaTestDataBuilder = new HorarioDiaTestDataBuilder().conHorarioFinal(null);
        probarExcepcionValorObligatorio(horarioDiaTestDataBuilder, SE_DEBE_INGRESAR_LA_HORA_FINAL);
    }

    void probarExcepcionValorObligatorio(HorarioDiaTestDataBuilder horarioDiaTestDataBuilder, String mensajeExcepcion) {
        BasePrueba.assertThrows(() -> {
                    horarioDiaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, mensajeExcepcion);
    }

}
