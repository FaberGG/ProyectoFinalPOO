/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sofi_
 */
public class Hospital {

    @Setter @Getter private String nombre;
    @Setter @Getter private String direccion;
    @Setter @Getter private List<Paciente> pacientes;
    @Setter @Getter private List<PersonalMedico> doctores;
    @Setter @Getter private List<PersonalAdministrativo> secretarios;
    @Setter @Getter private List<PersonalAdministrativo> auxiliares;


    public Hospital(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.pacientes = new ArrayList<>();
        this.doctores = new ArrayList<>();
        this.secretarios = new ArrayList<>();
        this.auxiliares = new ArrayList<>();

    }

    //Creamos el metodo para agregar los doctores al hospital 
    public void Agregardoctor(PersonalMedico doctor) {
        this.doctores.add(doctor);
        doctor.setHospital(this);
    }
    
    public void agregarDoctores (ArrayList<PersonalMedico> doctores){
        for (PersonalMedico doctor : doctores) {
            Agregardoctor(doctor);
        }
    }
    public void agregarSecretario (PersonalAdministrativo secretario){
        secretario.getAuxiliar().setHospital(this);
        secretario.setHospital(this);
        auxiliares.add(secretario.getAuxiliar());
        secretarios.add(secretario);
    }
    public void AgregarPacientesAlSistema(Paciente paciente) {
        paciente.setHospital(this);
        pacientes.add(paciente);
    }

    public void RemoverPaciente(Paciente paciente) {
        pacientes.remove(paciente);
        paciente.setHospital(null);
    }

    public Paciente BuscarPaciente(int Identificacion) {
        for (Paciente paciente : pacientes) {
            if (paciente.getID() == Identificacion) {
                return paciente;
            }
        }
        return null;

    }   

    @Override
    public String toString() {
        return " \n nombre:   " + nombre + "\n direccion:" + direccion;
    }
    
}
