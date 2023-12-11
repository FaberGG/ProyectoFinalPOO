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
    //metodo abstracto
    public abstract String obtenerInfo();

    public Persona(String Nombre, String Apellido, int Edad, int ID) {

        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.ID = ID;

    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Edad=" + Edad + ", ID=" + ID + '}';
    }

}
