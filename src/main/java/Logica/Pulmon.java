/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author sofi_
 */
public class Pulmon {
    private int PresionInterna;
    private int Tasadeflujo;
    private int Edadpulmon;

    public Pulmon(int PresionInterna, int Tasadeflujo, int Edadpulmon) {
        this.PresionInterna = PresionInterna;
        this.Tasadeflujo = Tasadeflujo;
        this.Edadpulmon = Edadpulmon;
    }

    public int getPresionInterna() {
        return PresionInterna;
    }

    public void setPresionInterna(int PresionInterna) {
        this.PresionInterna = PresionInterna;
    }

    public int getTasadeflujo() {
        return Tasadeflujo;
    }

    public void setTasadeflujo(int Tasadeflujo) {
        this.Tasadeflujo = Tasadeflujo;
    }

    public int getEdadpulmon() {
        return Edadpulmon;
    }

    public void setEdadpulmon(int Edadpulmon) {
        this.Edadpulmon = Edadpulmon;
    }

    @Override
    public String toString() {
        return "Pulmon{" + "PresionInterna=" + PresionInterna + ", Tasadeflujo=" + Tasadeflujo + ", Edadpulmon=" + Edadpulmon + '}';
    }


    
    
    
    
}
