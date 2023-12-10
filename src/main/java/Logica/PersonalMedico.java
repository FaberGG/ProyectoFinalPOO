/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Logica.Paciente;
/**
 *
 * @author sofi_
 */
public class PersonalMedico extends Persona {
    private String Especializacion;
    private Hospital hospital;
    //private Paciente paciente;
    //PROFE ACÁ EL ATRIBUTO DE TIPO PACIENTE, EL CÓDIGO SIGUE FUNCIONANDO POR LO QUE SOLO ENTRA EL PACIENTE COMO PARÁMETRO
   

    /*public Paciente getPaciente() {
        return paciente;
    }*/

   /*public void setPaciente(Paciente paciente) {
       this.paciente=paciente;
    }
 */ 
     
    public String obtenerTipo(){
        return "Personal Medico";
    }
    public String getEspecializacion() {
        return Especializacion;
    }

    public void setEspecializacion(String Especializacion) {
        this.Especializacion = Especializacion;
    }


    public PersonalMedico(String Nombre, String Apellido, int Edad, int ID, String Especializacion) {

        super(Nombre, Apellido, Edad, ID);
        this.Especializacion = Especializacion;

    }

    public void setHospital(Hospital hospital){
        this.hospital=hospital;
    }
    
    public Hospital getHospital(){
        return hospital;
    }

    public int RealizarConteo(Paciente paciente) {
        
        int aux = 0;

        if (paciente.getEdad() > 60) {
            aux++;
        } 

        if (paciente.getExamen().EstadoCardiaco(paciente).equals("Taquicardia") || paciente.getExamen().EstadoCardiaco(paciente).equals("Bradicardia")) {
            aux += 2;
        } 

        if (paciente.getExamen().CalcularTamañoCorazon(paciente).equals("VOLUMEN BAJO")||paciente.getExamen().CalcularTamañoCorazon(paciente).equals("VOLUMEN ALTO")){
            aux += 1;
        }

        String estadoPresionArterial = paciente.getExamen().EstadoPresionArterial(paciente);

        if (estadoPresionArterial.equals("bajo / alto") || estadoPresionArterial.equals("alto / alto") || estadoPresionArterial.equals("bajo / bajo") || estadoPresionArterial.equals("alto / bajo")) {
            aux += 1;
        }
        String EstadoGlobulosG=paciente.getExamen().CalcularGlobulosBlancos(paciente);
        String EstadoGlobulosR=paciente.getExamen().CalcularGlobulosRojos(paciente);

        if (EstadoGlobulosG.equals("BAJOS") || EstadoGlobulosG.equals("ALTOS") ||EstadoGlobulosR.equals("BAJOS") ||EstadoGlobulosR.equals("Altos")) {
            aux += 1;
        }

        return aux;

    }

    public String RealizarRemision(Paciente paciente) {

        int aux = RealizarConteo(paciente);

        if (aux >= 4) {
            return " Se Remite al paciente";
        } else {
            if(aux < 4 && aux >=1 ){

                return "No se remite al paciente y se le administra medicamento";

            }else{
                return "Se da de alta al paciente";
            }
        }

    }

}
