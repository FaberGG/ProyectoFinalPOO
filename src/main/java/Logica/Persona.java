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
public abstract class Persona {
    @Setter @Getter private String Nombre;
    @Setter @Getter private String Apellido;
    @Setter @Getter private int Edad;
    @Setter @Getter private int ID;
    @Setter @Getter private Hospital hospital;

    public abstract String obtenerTipo();
    
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
     public Persona(String Nombre, String Apellido, int Edad, int ID) {

        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.ID = ID;
        
    }

     public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Edad=" + Edad + ", ID=" + ID  + '}';
    }
    
    
}
