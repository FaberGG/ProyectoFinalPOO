/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author sofi_
 */
public class Examen {
    private String Resultados;
    private Paciente paciente;
    private PersonalMedico doctor;
 
    public String getResultados() {
        return Resultados;
    }

    public void setResultados(String Resultados) {
        this.Resultados = Resultados;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PersonalMedico getDoctor() {
        return doctor;
    }


    public Examen(String Resultados) {
        this.Resultados = Resultados;
        
    }

    public Examen(){
        
    }
    public String EstadoCardiaco(Paciente paciente) {

        int ritmoCardiaco = paciente.getcorazon().getRitmoCardiaco();

        if (ritmoCardiaco < 60) {
            return "Bradicardia";
        } else if (ritmoCardiaco > 100) {
            return "Taquicardia";
        } else {
            return "Normal";
        }
    }

    public String EstadoPresionArterial(Paciente paciente) {

        int presionSistolica = paciente.getcorazon().getPresionSitolica();
        int presionDistolica = paciente.getcorazon().getPresionDistolica();

        String sistolica, distolica;

        if (presionSistolica < 90) {
            sistolica = "baja";
        } else if (presionSistolica > 120) {
            sistolica = "alta";
        } else {
            sistolica = "normal";
        }

        if (presionDistolica < 60) {
            distolica = "baja";
        } else if (presionDistolica > 80) {
            distolica = "alta";
        } else {
            distolica = "normal";
        }
        return sistolica + "/" + distolica;

    }

     public String CalcularGrasa(Paciente paciente) {

        int cantidadGrasa = paciente.getcorazon().getCantidadGrasa();

        if (cantidadGrasa < 10) {
            return "Bajo";
        } else if (cantidadGrasa >= 10 && cantidadGrasa <= 20) {
            return "Moderado";
        } else {
            return "Alto";
        }
    }

    public String CalcularTamañoCorazon(Paciente paciente) {
    int  tamañoCorazon = paciente.getcorazon().getTamañoCorazon();

        if (tamañoCorazon<60){
        return "VOLUMEN BAJO";}

        else if (tamañoCorazon>80) {
            return "VOLUMEN ALTO"; 
        } else 
             return "VOLUMEN NORMAL"; 

    }

    public String CalcularGlobulosRojos(Paciente paciente){
       int globulosRojos=paciente.getsangre().getGlobulosRojos();
       if (globulosRojos<4.5){ 
        return "BAJOS";}
        else if (globulosRojos >6.0) {
            return "ALTOS";
        }else 
        return "NORMAL"; 
}

    public String CalcularGlobulosBlancos(Paciente paciente){
       int globulosRojos=paciente.getsangre().getGlobulosRojos();
       if (globulosRojos<4000){ 
        return "BAJOS";}
        else if (globulosRojos >11000) {
            return "ALTOS";
        }else 
        return "NORMAL"; 
}

    
}
