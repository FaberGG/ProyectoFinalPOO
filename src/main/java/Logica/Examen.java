/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import lombok.Setter;
import lombok.Getter;

/**
 *
 * @author sofi_
 */
public class Examen {

    @Setter @Getter private String Resultados;
    @Setter @Getter private Paciente paciente;
    @Setter @Getter private PersonalMedico doctor;

    public Examen(String Resultados) {
        this.Resultados = Resultados;

    }

    public Examen() {

    }
    
    public String generarResultados() {
        StringBuilder informe = new StringBuilder("");

        informe.append(" -PACIENTE:    ").append(paciente.getNombre()).append(" ")
                .append(paciente.getApellido()).append("\n \n");
        informe.append("   --RESULTADOS DEL EXAMEN-- \n");

        informe.append("ESTADO CARDIACO: ").append(paciente.getCorazon().getRitmoCardiaco())
                .append("      ").append(EstadoCardiaco(paciente)).append("\n");
        informe.append("PRESION ARTERIAL: ").append(paciente.getCorazon().getPresionSitolica())
                .append("/").append(paciente.getCorazon().getPresionDistolica())
                .append("     ").append(EstadoPresionArterial(paciente)).append("\n");
        informe.append("GLOBULOS BLANCOS: ").append(paciente.getSangre().getGlobulosBlancos())
                .append("      ").append(CalcularGlobulosBlancos(paciente)).append("\n");
        informe.append("GLOBULOS ROJOS: ").append(paciente.getSangre().getGlobulosRojos())
                .append("          ").append(CalcularGlobulosRojos(paciente)).append("\n");
        informe.append("TAMAÑO CORAZON: ").append(paciente.getCorazon().getTamanoCorazon())
                .append("         ").append(CalcularTamañoCorazon(paciente)).append("\n");
        informe.append("CANTIDAD GRASA: ").append(paciente.getCorazon().getCantidadGrasa())
                .append("         ").append(CalcularGrasa(paciente)).append("\n");

        
        this.Resultados = informe.toString(); 
        return informe.toString();
    }
    
    public String EstadoCardiaco(Paciente paciente) {

        int ritmoCardiaco = paciente.getCorazon().getRitmoCardiaco();

        if (ritmoCardiaco < 60) {
            return "BRADICARDIA";
        } else if (ritmoCardiaco > 100) {
            return "TAQUICARDI";
        } else {
            return "NORMAL";
        }
    }

    public String EstadoPresionArterial(Paciente paciente) {

        int presionSistolica = paciente.getCorazon().getPresionSitolica();
        int presionDistolica = paciente.getCorazon().getPresionDistolica();

        String sistolica, distolica;

        if (presionSistolica < 90) {
            sistolica = "BAJA";
        } else if (presionSistolica > 120) {
            sistolica = "ALTA";
        } else {
            sistolica = "NORMAL";
        }

        if (presionDistolica < 60) {
            distolica = "BAJA";
        } else if (presionDistolica > 80) {
            distolica = "ALTA";
        } else {
            distolica = "NORMAL";
        }
        return sistolica + "/" + distolica;

    }

    public String CalcularGrasa(Paciente paciente) {

        int cantidadGrasa = paciente.getCorazon().getCantidadGrasa();

        if (cantidadGrasa < 10) {
            return "BAJO";
        } else if (cantidadGrasa >= 10 && cantidadGrasa <= 20) {
            return "MODERADO";
        } else {
            return "ALTO";
        }
    }

    public String CalcularTamañoCorazon(Paciente paciente) {
        int tamañoCorazon = paciente.getCorazon().getTamanoCorazon();

        if (tamañoCorazon < 60) {
            return "VOLUMEN BAJO";
        } else if (tamañoCorazon > 80) {
            return "VOLUMEN ALTO";
        } else {
            return "VOLUMEN NORMAL";
        }

    }

    public String CalcularGlobulosRojos(Paciente paciente) {
        int globulosRojos = paciente.getSangre().getGlobulosRojos();
        if (globulosRojos < 4.5) {
            return "BAJOS";
        } else if (globulosRojos > 6.0) {
            return "ALTOS";
        } else {
            return "NORMAL";
        }
    }

    public String CalcularGlobulosBlancos(Paciente paciente) {
        int globulosRojos = paciente.getSangre().getGlobulosRojos();
        if (globulosRojos < 4000) {
            return "BAJOS";
        } else if (globulosRojos > 11000) {
            return "ALTOS";
        } else {
            return "NORMAL";
        }
    }

    public String CalcularPresionInterna(Paciente paciente) {
        int Presioni = paciente.getPulmon().getPresionInterna();
        if (Presioni < -200) {
            return "PRESION BAJA";
        } else if (Presioni > 200) {
            return "PRESION ALTA";
        } else {
            return "PRESION NORMAL";
        }
    }

    public String CalcularTasaDeFlujo(Paciente paciente) {
        int TasaF = paciente.getPulmon().getPresionInterna();
        if (TasaF < 2000) {
            return "TASA DE FLUJO BAJA";
        } else if (TasaF > 5000) {
            return "TASA DE FLUJO ALTA";
        } else {
            return "TASA DE FLUJO NORMAL";
        }
    }

    public String EdadPulmon(Paciente paciente) {
        int EdadP = paciente.getPulmon().getEdadpulmon();
        if (EdadP > 70) {
            return "EDAD DE PULMONES ALTO";
        } else {
            return "EDAD DE PULMONES NORMAL ";
        }
    }

}
