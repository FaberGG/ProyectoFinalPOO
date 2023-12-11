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
    @Setter @Getter private PersonalAdministrativo secretario; //Autorelacion
    @Setter @Getter private Hospital hospitalsanitas;

    
    public PersonalAdministrativo( String Nombre, String Apellido, int Edad, int ID, int codigo) {
        super(Nombre, Apellido, Edad, ID);
        this.codigo = codigo;
        this.secretario=null;
    }
    
    
       
    @Override
    public String obtenerInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
