/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofi_
 */
public class Hospital {

    private String nombre;
    private String direccion;
    private List<Paciente> pacientes;
    private List<PersonalMedico> doctores;

    public Hospital(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.pacientes = new ArrayList<>();
        this.doctores = new ArrayList<>();
    }

    //Creamos el metodo para agregar los doctores al hospital 
    public void Agregardoctor(PersonalMedico doctor) {
        if(doctores.size() <= 4){
            this.doctores.add(doctor);
            doctor.setHospital(this);
        }
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<PersonalMedico> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<PersonalMedico> doctores) {
        this.doctores = doctores;
    }

    public void AgregarPacientesAlSistema(Paciente paciente) {
        pacientes.add(paciente);
        paciente.setHospital(this);
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
}
