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
public class PersonalAdministrativo extends Persona {
    @Setter @Getter private int codigo; 
    @Setter @Getter private String cargo; 
    @Setter @Getter private PersonalAdministrativo auxiliar; //Autorelacion
    @Setter @Getter private Hospital hospitalsanitas;

    
    public PersonalAdministrativo( String Nombre, String Apellido, String cargo, int Edad, int ID, int codigo) {
        super(Nombre, Apellido, Edad, ID);
        this.cargo = cargo;
        this.codigo = codigo;
        this.auxiliar=null;
    }
       
    @Override
    public String obtenerInfo() {
        StringBuilder info = new StringBuilder();
        info.append("------------------------------- \n");
        info.append("-----------").append(cargo.toUpperCase()).append("-----------\n");
        info.append(this.toString());
        info.append("\n-------------------------------\n");

        return info.toString();
    }

    @Override
    public String toString() {//11 tabs
        return super.toString() + "\n codigo:          " + codigo +
               "\n cargo:           " + cargo;
    }
}
