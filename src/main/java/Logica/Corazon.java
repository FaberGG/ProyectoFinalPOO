/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author sofi_
 */

public class Corazon implements Organos_Biologicos{
    private int RitmoCardiaco;
    private int PresionSitolica;
    private int PresionDistolica;
    private int TamañoCorazon;
    private int CantidadGrasa;

    public Corazon(int RitmoCardiaco, int PresionSitolica, int PresionDistolica, int TamañoCorazon, int CantidadGrasa) {
        this.RitmoCardiaco = RitmoCardiaco;
        this.PresionSitolica = PresionSitolica;
        this.PresionDistolica = PresionDistolica;
        this.TamañoCorazon = TamañoCorazon;
        this.CantidadGrasa = CantidadGrasa;
    }

    public int getRitmoCardiaco() {
        return RitmoCardiaco;
    }

    public void setRitmoCardiaco(int RitmoCardiaco) {
        this.RitmoCardiaco = RitmoCardiaco;
    }

    public int getPresionSitolica() {
        return PresionSitolica;
    }

    public void setPresionSitolica(int PresionSitolica) {
        this.PresionSitolica = PresionSitolica;
    }

    public int getPresionDistolica() {
        return PresionDistolica;
    }

    public void setPresionDistolica(int PresionDistolica) {
        this.PresionDistolica = PresionDistolica;
    }

    public int getTamañoCorazon() {
        return TamañoCorazon;
    }

    public void setTamañoCorazon(int TamañoCorazon) {
        this.TamañoCorazon = TamañoCorazon;
    }

    public int getCantidadGrasa() {
        return CantidadGrasa;
    }

    public void setCantidadGrasa(int CantidadGrasa) {
        this.CantidadGrasa = CantidadGrasa;
    }

    @Override
    public String toString() {
        return "Corazon{" + "RitmoCardiaco=" + RitmoCardiaco + ", PresionSitolica=" + PresionSitolica + ", PresionDistolica=" + PresionDistolica + ", Tama\u00f1oCorazon=" + TamañoCorazon + ", CantidadGrasa=" + CantidadGrasa + '}';
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


