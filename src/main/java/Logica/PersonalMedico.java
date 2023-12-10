/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Logica.Paciente;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 * @author sofi_
 */
public class PersonalMedico extends Persona {
    
    @Setter @Getter private String Especializacion;
    @Setter @Getter private Hospital hospital;
    @Setter @Getter private List<Paciente> pacientes;
    //PROFE ACÁ EL ATRIBUTO DE TIPO PACIENTE, EL CÓDIGO SIGUE FUNCIONANDO POR LO QUE SOLO ENTRA EL PACIENTE COMO PARÁMETRO
    public void AgregarPacientes(Paciente paciente) {
        pacientes.add(paciente);
    }

    //implementacion del metodo abstracto
    @Override
    public String obtenerInfo() {
        return "Personal Medico";
    }

    public PersonalMedico(String Nombre, String Apellido, int Edad, int ID, String Especializacion) {

        super(Nombre, Apellido, Edad, ID);
        this.Especializacion = Especializacion;

    }

    public int RealizarConteo(Paciente paciente) {

        int aux = 0;

        if (paciente.getEdad() > 60) {
            aux++;
        }

        if (paciente.getExamen().EstadoCardiaco(paciente).equals("TAQUICARDIA") || paciente.getExamen().EstadoCardiaco(paciente).equals("BRADICARDIA")) {
            aux += 2;
        }

        if (paciente.getExamen().CalcularTamañoCorazon(paciente).equals("VOLUMEN BAJO") || paciente.getExamen().CalcularTamañoCorazon(paciente).equals("VOLUMEN ALTO")) {
            aux += 1;
        }

        String estadoPresionArterial = paciente.getExamen().EstadoPresionArterial(paciente);

        if (estadoPresionArterial.equals("BAJO / ALTO") || estadoPresionArterial.equals("ALTO / ALTO") || estadoPresionArterial.equals("BAJO / BAJO") || estadoPresionArterial.equals("ALTO / BAJO")) {
            aux += 1;
        }
        String EstadoGlobulosG = paciente.getExamen().CalcularGlobulosBlancos(paciente);
        String EstadoGlobulosR = paciente.getExamen().CalcularGlobulosRojos(paciente);

        if (EstadoGlobulosG.equals("BAJOS") || EstadoGlobulosG.equals("ALTOS") || EstadoGlobulosR.equals("BAJOS") || EstadoGlobulosR.equals("ALTOS")) {
            aux += 1;
        }

        return aux;

    }

    public String RealizarRemision(Paciente paciente) {

        int aux = RealizarConteo(paciente);

        if (aux >= 4) {
            return " Se remite el paciente";
        } else {
            if (aux < 4 && aux >= 1) {

                return "No se remite al paciente y se le administra medicamento";

            } else {
                return "Se da de alta al paciente";
            }
        }

    }

}
