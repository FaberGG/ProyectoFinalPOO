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
        return "La sangre presenta un estado de glóbulos blancos: " + estadoGlobulosBlancos +
                " y un estado de glóbulos rojos: " + estadoGlobulosRojos + ".";

    }
    
}
