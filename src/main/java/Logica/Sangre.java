/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sofi_
 */


public class Sangre implements Organos_Biologicos {

    @Setter @Getter private int GlobulosRojos;
    @Setter @Getter private int GlobulosBlancos;

    public Sangre(int GlobulosRojos, int GlobulosBlancos) {
        this.GlobulosRojos = GlobulosRojos;
        this.GlobulosBlancos = GlobulosBlancos;
    }

    @Override
    public String toString() {
        return " GlobulosRojos:       " 
                + GlobulosRojos + "\n GlobulosBlancos:     " + GlobulosBlancos;
    }

    @Override
    public String funcionBiologica(Examen examen) {
        String estadoGlobulosBlancos = examen.CalcularGlobulosBlancos(examen.getPaciente());
        String estadoGlobulosRojos = examen.CalcularGlobulosRojos(examen.getPaciente());
        if ("BAJOS".equals(estadoGlobulosRojos) && "BAJOS".equals(estadoGlobulosBlancos) || "ALTOS".equals(estadoGlobulosRojos) && "ALTOS".equals(estadoGlobulosBlancos)) {
            return "AL REVISAR SU EXÁMEN, SE DETERMINA QUE LA SANGRE SE ENCUENTRA EN UN ESTADO CRITICO";
        } else {
            if ("BAJOS".equals(estadoGlobulosRojos) && "NORMAL".equals(estadoGlobulosBlancos) || "ALTOS".equals(estadoGlobulosRojos) && "NORMAL".equals(estadoGlobulosRojos)
                    || "NORMAL".equals(estadoGlobulosRojos) && "BAJOS".equals(estadoGlobulosBlancos) || "NORMAL".equals(estadoGlobulosRojos) && "ALTOS".equals(estadoGlobulosRojos)) {
                return "AL REVISAR SU EXAMEN, SE DETERMINA QUE EL ESTADO DE LA SANGRE ES MODERADO AUNQUE SE NECESITA HACER MÁS ANÁLISIS";
            }
        }
        return "POR SU EXÁMEN, SE DETERMINA QUE SU SANGRE SE ENCUENTA EN RANGOS SALUDABLES";

    }

}
