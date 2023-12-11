/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author sofi_
 */
public class Paciente extends Persona {

    @Setter @Getter private String Sexo;
    @Setter @Getter private String estado;
    @Setter @Getter private Corazon corazon;
    @Setter @Getter private Sangre sangre;
    @Setter @Getter private Hospital hospital;
    @Setter @Getter private Examen examen;
    @Setter @Getter private Pulmon pulmon;
    @Setter @Getter private List<PersonalMedico> doctores;

    public Paciente(String Nombre, String Apellido, int Edad, int ID, String Sexo, int RitmoCardiaco,
            int PresionSitolica, int PresionDistolica, int TamañoCorazon, int CantidadGrasa, int GlobulosRojos,
            int GlobulosBlancos, int presioninterna, int tasadeflujo, int edadpulmon) {
            super(Nombre, Apellido, Edad, ID);
            this.Sexo = Sexo;
            this.doctores = new ArrayList<>();
        //CREAMOS LOS OBJETOS DE LAS COMPOSICIONES 
        this.corazon = new Corazon(RitmoCardiaco, PresionSitolica, PresionDistolica, TamañoCorazon, CantidadGrasa);
        this.sangre = new Sangre(GlobulosRojos, GlobulosBlancos);
        this.pulmon = new Pulmon(presioninterna, tasadeflujo, edadpulmon);
    }

    //implementacion del metodo abstracto
    @Override
    public String obtenerInfo() {
        StringBuilder info = new StringBuilder();
        info.append("------------PACIENTE-------------\n");
        info.append(this.toString());
        //uso de los metodos sobrecargados
        info.append(MostrarDatosIngresados());
        info.append(MostrarDatosIngresados(pulmon.toString(), corazon.toString()));
        info.append("\n--------HOSPITAL ASOCIADO--------");
        info.append(this.hospital.toString());
        info.append("\n---------EXAMEN ASOCIADO---------\n");
        info.append(this.examen.generarResultados());
        info.append("------------------------------- \n");

        return info.toString();
    }

    //POLIMORFISMO CON SOBRECARGA DE MÉTODOS
    public String MostrarDatosIngresados(){
        StringBuilder info = new StringBuilder();
        info.append("\n--------DATOS DE LA SANGRE-------\n");
        info.append(this.toStringsangre());  
    return info.toString();

    }
    
    public String MostrarDatosIngresados(String pulmon, String corazon){
        StringBuilder info = new StringBuilder();
        info.append("\n----DATOS DE CORAZON Y PULMON----\n");
        info.append(pulmon);
        info.append(corazon); 
     return info.toString();
    }


    public void Agregardoctor(PersonalMedico doctor) {
        doctores.add(doctor);
        doctor.AgregarPaciente(this);
    }


    public void agregarDoctores(ArrayList<PersonalMedico> doctores){
        for (PersonalMedico doctor : doctores) {
            Agregardoctor(doctor);
        }
    }
    @Override

    public String toString() {
        return super.toString() + "\n Sexo:     " + Sexo + "\n Estado:   " + estado;
    }

     /*public String toStringcorazonypulmon() {
        return "Paciente{" + "Informacion registrada del corazon    " + corazon   + "\nInformación registrada de la sangre     "+sangre + "\nInformacion registrada de los pulmones" + pulmon +'}';
    }*/
      public String toStringsangre() {
        return "\nInformacion registrada de la sangre:\n" + sangre;
    }

}
