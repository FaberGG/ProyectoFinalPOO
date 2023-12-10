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
public class Pulmon implements Organos_Biologicos {
    @Setter @Getter private int PresionInterna;
    @Setter @Getter private int Tasadeflujo;
    @Setter @Getter private int Edadpulmon;

    public Pulmon(int PresionInterna, int Tasadeflujo, int Edadpulmon) {
        this.PresionInterna = PresionInterna;
        this.Tasadeflujo = Tasadeflujo;
        this.Edadpulmon = Edadpulmon;
    }
    
    @Override
    public String toString() {
        return "Pulmon{" + "PresionInterna=" + PresionInterna + ", Tasadeflujo=" + Tasadeflujo + ", Edadpulmon=" + Edadpulmon + '}';
    }

     @Override
    public String funcionBiologica(Examen examen){
        String edadPulmones=examen.EdadPulmon(examen.getPaciente());
        if ("EDAD DE PULMONES ALTO".equals(edadPulmones)){
            return"SE DETERMINA QUE SUS PULMONES LLEVAN UNA EDAD AVANZADA Y PROBABLEMENTE PADECE DE PATOLOGÍAS POR DICHA RAZON";
     }
        return"SE DETERMINA QUE LA EDAD DE SUS PULMONES ES ADECUADA Y SI SUFRE ALGUNA PATOLOGÍA, NO SERÁ POR ESTA RAZÓN";   
    
    }

  

}

