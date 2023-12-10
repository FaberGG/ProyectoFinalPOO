package Presentacion;

import java.util.Scanner;
import Logica.*;

public class Principal {

    //CREAMOS EL OBJETO HOSPITAL 
    static Hospital hospitalsanitas = new Hospital("Sanitas", "Crra 78k-no78B-78Sur- Alameda del parque");
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //CREAMOS OBJETO EXAMEN
        Examen examenpaciente = new Examen("");

        // Invocamos el menú
        Consola console = new Consola();
        int opcion;
        do {
            console.ImprimirMenuP();

            opcion = console.leerOpcion(5); // rango de opciones

            switch (opcion) {
                case 1 -> {
                    String Nombre = console.leerString("Ingrese el nombre del paciente: ");
                    String Apellido = console.leerString("Ingrese el apellido del paciente: ");
                    int Edad = console.leerEntero("Ingrese la edad del paciente: ");
                    int Identificacion = console.leerEntero("Ingrese la identificación del paciente: ");
                    String Sexo = console.leerString("Ingrese el sexo del paciente");

                    console.imprimirEncabezado("""
                                               MUY BIEN, ESTAMOS A UN PASO 
                                               DE INGRESARLO AL SISTEMA.
                                               AHORA INGRESEMOS TUS DATOS CARDIOLOGICOS
                                               """);

                    int RitmoCardiaco = console.leerEntero(
                            "Ingrese latidos por minuto del paciente: ");
                    int PresionSistolica = console.leerEntero(
                            "Ingrese la presión sistólica del paciente: ");
                    int PresionDistolica = console.leerEntero(
                            "Ingrese la presión distólica del paciente: ");
                    int TamañoCorazon = console.leerEntero(
                            "Ingrese el tamaño del volumen sistólico del corazón del paciente: ");
                    int CantidadGrasa = console.leerEntero(
                            "Ingrese la cantidad de grasa del paciente: ");
                    int GlobulosRojos = console.leerEntero(
                            "Ingrese la cantidad de glóbulos rojos del paciente: ");
                    int GlobulosBlancos = console.leerEntero(
                            "Ingrese la cantidad de glóbulos blancos del paciente: ");
                    int Presioninterna = console.leerEntero(
                            "Ingrese la presión interna de los pulmones: ");
                    int Tasadeflujo = console.leerEntero(
                            "Ingrese la tasa de flujo en los pulmones: ");
                    int EdadPulmon = console.leerEntero(
                            "Ingrese la edad de los pulmones: ");
                    Paciente nuevoPaciente = new Paciente(Nombre, Apellido, Edad, Identificacion, Sexo, RitmoCardiaco,
                            PresionSistolica, PresionDistolica, TamañoCorazon, CantidadGrasa, GlobulosRojos,
                            GlobulosBlancos, Presioninterna, Tasadeflujo, EdadPulmon);
                    // AGREGAMOS AL PACIENTE EN EL HOSPITAL (ASOCIACION)
                    hospitalsanitas.AgregarPacientesAlSistema(nuevoPaciente);
                    console.imprimirEncabezado("!!!Paciente agregado con exito!!!");
                }
                case 2 -> {
                    int identificacion = console.leerEntero(
                            "Ingrese la identificacion del paciente para buscar su examen");
                    //Invocamos el metodo para buscar el paciente, el cual está en la clase Hospital
                    Paciente pacientebuscar = hospitalsanitas.BuscarPaciente(identificacion);
                     
                    if (pacientebuscar == null) {
                        System.out.println("No se encontró un paciente con la identificación proporcionada.");
                        
                        break;
                    }else{
                        console.imprimirEncabezado("EXAMEN PACIENTE " + pacientebuscar.getNombre() + " "
                                + pacientebuscar.getApellido());
                                                
                        //setteamos para asociar paciente-examen 

                        examenpaciente.setPaciente(pacientebuscar);
                        pacientebuscar.setExamen(examenpaciente);
                        //llama al metodo generar resultados y los imprime
                        System.out.println(examenpaciente.generarResultados());
                        //hacemos el polimorfismo con clase abstracta
                        pacientebuscar.getcorazon().funcionBiologica(examenpaciente);
                        pacientebuscar.getSangre().funcionBiologica(examenpaciente);
                        pacientebuscar.getPulmon().funcionBiologica(examenpaciente);
                         /*Organos_Biologicos organos[]=new Organos_Biologicos[3];
                         organos[1]=pacientebuscar.getcorazon();
                         organos[2]=pacientebuscar.getSangre();
                         organos[3]=pacientebuscar.getPulmon();

                         for (Organos_Biologicos organo:organos){
                                pacientebuscar.
                         }*/
                        
                                                   
                    }
                }

                case 3 -> {
                }

                case 4 -> {
                }

            }
        } while (opcion != 5);// TENGO QUE HACER LA EXCEPCION
        System.out.println("El programa termino");

    }
    // acá acaba el main
    

}
