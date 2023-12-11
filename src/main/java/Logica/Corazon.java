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

public class Corazon implements Organos_Biologicos{
    @Setter @Getter private int RitmoCardiaco;
    @Setter @Getter private int PresionSitolica;
    @Setter @Getter private int PresionDistolica;
    @Setter @Getter private int TamanoCorazon;
    @Setter @Getter private int CantidadGrasa;

    public Corazon(int RitmoCardiaco, int PresionSitolica, int PresionDistolica, int TamañoCorazon, int CantidadGrasa) {
        this.RitmoCardiaco = RitmoCardiaco;
        this.PresionSitolica = PresionSitolica;
        this.PresionDistolica = PresionDistolica;
        this.TamanoCorazon = TamañoCorazon;
        this.CantidadGrasa = CantidadGrasa;
    }
    @Override
    public String toString() {
        return "\nCorazon:" + "\n RitmoCardiaco:    " + RitmoCardiaco + "\n PresionSitolica:  " 
                + PresionSitolica + "\n PresionDistolica: " + PresionDistolica + 
                "\n Tama\u00f1oCorazon:    " + TamanoCorazon + "\n CantidadGrasa:    " + CantidadGrasa;
    }
    
     @Override
     public String funcionBiologica(Examen examen) {
		
	String estadoCardiaco = examen.EstadoCardiaco(examen.getPaciente());
        return switch (estadoCardiaco) {
            case "Bradicardia" -> "El corazón está experimentando bradicardia, que es una frecuencia cardíaca anormalmente baja.";
            case "Taquicardia" -> "El corazón está experimentando taquicardia, que es una frecuencia cardíaca anormalmente alta.";
            default -> "El corazón tiene un ritmo cardíaco normal.";
        };		
	}
    
    
}


