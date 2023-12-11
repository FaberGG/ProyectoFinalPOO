/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author sofi_
 */
public class PersonalAdministrativo extends Persona {
    int codigo; 
    private PersonalAdministrativo secretario; //Autorelacion
    private Hospital hospitalsanitas;

    
    public PersonalAdministrativo( String Nombre, String Apellido, int Edad, int ID, int codigo) {
        super(Nombre, Apellido, Edad, ID);
        this.codigo = codigo;
        this.secretario=null;
    }
    
    
    public Hospital getHospitalsanitas() {
        return hospitalsanitas;
    }

    public void setHospitalsanitas(Hospital hospitalsanitas) {
        this.hospitalsanitas = hospitalsanitas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PersonalAdministrativo getSecretario() {
        return secretario;
    }

    public void setSecretario(PersonalAdministrativo secretario) {
        this.secretario = secretario;
    }
    

    
    @Override
    public String obtenerInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
