/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author sofi_
 */
public class Sangre extends Organos_Biologicos {
     private int GlobulosRojos;
    private int GlobulosBlancos;

    public Sangre(int GlobulosRojos, int GlobulosBlancos) {
        this.GlobulosRojos = GlobulosRojos;
        this.GlobulosBlancos = GlobulosBlancos;
    }

    public int getGlobulosRojos() {
        return GlobulosRojos;
    }

    public void setGlobulosRojos(int GlobulosRojos) {
        this.GlobulosRojos = GlobulosRojos;
    }

    public int getGlobulosBlancos() {
        return GlobulosBlancos;
    }

    public void setGlobulosBlancos(int GlobulosBlancos) {
        this.GlobulosBlancos = GlobulosBlancos;
    }

    @Override
    public String toString() {
        return "Sangre{" + "GlobulosRojos=" + GlobulosRojos + ", GlobulosBlancos=" + GlobulosBlancos + '}';
    }

    @Override
    public String funcionBiologica(Examen examen) {
        String estadoGlobulosBlancos = examen.CalcularGlobulosBlancos(examen.getPaciente());
        String estadoGlobulosRojos = examen.CalcularGlobulosRojos(examen.getPaciente());
        if (estadoGlobulosRojos=="BAJOS"&& estadoGlobulosBlancos=="BAJOS"||estadoGlobulosRojos=="ALTOS"&& estadoGlobulosBlancos=="ALTOS"){
            return "AL REVISAR SU EXÁMEN, SE DETERMINA QUE LA SANGRE SE ENCUENTRA EN UN ESTADO CRITICO";
        }else{
            if(estadoGlobulosRojos=="BAJOS"&& estadoGlobulosBlancos=="NORMAL"||estadoGlobulosRojos=="ALTOS"&& estadoGlobulosRojos=="NORMAL"
            ||estadoGlobulosRojos=="NORMAL"&& estadoGlobulosBlancos=="BAJOS"||estadoGlobulosRojos=="NORMAL"&& estadoGlobulosRojos=="ALTOS"
            ){ 
                return "AL REVISAR SU EXAMEN, SE DETERMINA QUE EL ESTADO DE LA SANGRE ES MODERADO AUNQUE SE NECESITA HACER MÁS ANÁLISIS";
        }

        }
                return "POR SU EXÁMEN, SE DETERMINA QUE SU SANGRE SE ENCUENTA EN RANGOS SALUDABLES";


    }
    
}
