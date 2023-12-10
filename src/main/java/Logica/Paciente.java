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
public class Paciente extends Persona {

    @Setter @Getter private String Sexo;
    @Setter @Getter private Corazon corazon;
    @Setter @Getter private Sangre sangre;
    @Setter @Getter private Hospital hospital;
    @Setter @Getter private Examen examen;
    @Setter @Getter private Pulmon pulmon;

    public Paciente(String Nombre, String Apellido, int Edad, int ID, String Sexo, int RitmoCardiaco,
            int PresionSitolica, int PresionDistolica, int TamañoCorazon, int CantidadGrasa, int GlobulosRojos,
            int GlobulosBlancos, int presioninterna, int tasadeflujo, int edadpulmon) {
        super(Nombre, Apellido, Edad, ID);
        this.Sexo = Sexo;
        //CREAMOS LOS OBJETOS DE LAS COMPOSICIONES 
        this.corazon = new Corazon(RitmoCardiaco, PresionSitolica, PresionDistolica, TamañoCorazon, CantidadGrasa);
        this.sangre = new Sangre(GlobulosRojos, GlobulosBlancos);
        this.pulmon = new Pulmon(presioninterna, tasadeflujo, edadpulmon);
    }

    public String obtenerInfo(){
        StringBuilder info = new StringBuilder();
        info.append("-----------PACIENTE-----------\n   -");
        info.append(this.toString());
        info.append("-------HOSPITAL ASOCIADO-------\n   -");
        info.append(this.hospital.toString());
        info.append("--------EXAMEN ASOCIADO--------\n   -");

        return info.toString();
    }
    public String getSexo() {
        return Sexo;
    }
    
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Corazon getcorazon() {

        return corazon;

    }

    public void setCorazon(Corazon corazon) {

        this.corazon = corazon;

    }

    public Sangre getsangre() {

        return sangre;

    }

    public void setsangre(Sangre sangre) {

        this.sangre = sangre;

    }

    public Sangre getSangre() {
        return sangre;
    }

    public void setSangre(Sangre sangre) {
        this.sangre = sangre;
    }

    public Pulmon getPulmon() {
        return pulmon;
    }

    public void setPulmon(Pulmon pulmon) {
        this.pulmon = pulmon;
    }

    public Corazon getCorazon() {
        return corazon;
    }
    

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Paciente{" + super.toString() + "Sexo=" + Sexo + ", corazon=" + corazon + ", sangre=" + sangre + '}';
    }

}
