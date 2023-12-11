package Presentacion;

import java.util.Scanner;
import Logica.*;

public class Principal {

    //CREAMOS OBJETO PARA RELACIZAR TODAS LAS LECTURAS NECESARIAS
    static Scanner sc = new Scanner(System.in);

    //CREAMOS EL OBJETO HOSPITAL 
    static Hospital hospitalsanitas = new Hospital("Sanitas", "Crra 78k-no78B-78Sur- Alameda del parque");
    //creamos el objeto consola para interactuar con el usuario
    static Consola console = new Consola();

    public static void main(String[] args) {

        //CREAMOS OBJETO EXAMEN
        Examen examenpaciente = new Examen("");

        //CREAMOS LOS OBJETOS DEL PERSONAL MÉDICO (DOCTORES)
        PersonalMedico doctor1 = new PersonalMedico("Cristian", "Villada", 56, 2222, "Hematologia");
        PersonalMedico doctor2 = new PersonalMedico("Andres", "Chauta", 46, 1111, "Cardiologia");
        PersonalMedico doctor3 = new PersonalMedico("Felipe", "Guasca", 36, 3333, "Neumologia");
        PersonalMedico doctor4 = new PersonalMedico("Sebastian", "Leon", 26, 4444, "Cardiologia");

        //AGREGAMOS A LOS DOCTORES EN EL HOSPITAL 
        hospitalsanitas.Agregardoctor(doctor1);
        hospitalsanitas.Agregardoctor(doctor2);
        hospitalsanitas.Agregardoctor(doctor3);
        hospitalsanitas.Agregardoctor(doctor4);

        // Invocamos el menú
        int opcion;
        do {
            console.ImprimirMenuP();
            opcion = console.leerOpcion(5); // rango de opciones
            //CREAMOS EL SWITCH PARA EMPERZAR A TRABAJAR CON CADA CASO
            switch (opcion) {
                case 1 -> {

                    /* 
                        * SE CREA EL METODO PARA LEER LOS DATOS POR 
                        * CONSOLA, ESTE CREA EL OBJETO PACIENTE
                        * Y LO RETORNA PARA ASIGNARLO A LA CREACION
                        * DE UN NUEVO PACIENTE
                     */
                    //llamado a la funcion
                    Paciente nuevoPaciente = crearPaciente();

                    // AGREGAMOS AL PACIENTE EN EL HOSPITAL (AGREGACION)
                    hospitalsanitas.AgregarPacientesAlSistema(nuevoPaciente);
                    nuevoPaciente.setHospital(hospitalsanitas);

                    console.imprimirEncabezado("!!!Paciente agregado con exito!!!");
                }
                case 2 -> {
                    int identificacion = console.leerEntero(
                            "Ingrese la identificacion del paciente para buscar su examen: ");
                    //Invocamos el metodo para buscar el paciente, el cual está en la clase Hospital
                    Paciente pacientebuscar = hospitalsanitas.BuscarPaciente(identificacion);

                    if (pacientebuscar == null) {
                        System.out.println("No se encontró un paciente con la identificación proporcionada.");
                    } else {
                        console.imprimirEncabezado("EXAMEN PACIENTE " + pacientebuscar.getNombre() + " "
                                + pacientebuscar.getApellido());

                        //setteamos para asociar paciente-examen 
                        examenpaciente.setPaciente(pacientebuscar);
                        pacientebuscar.setExamen(examenpaciente);

                        //llama al metodo generar resultados del examen y los imprime
                        System.out.println(examenpaciente.generarResultados());

                        // Se llaman los métodos funciones biológicas de corazón y de sangre
                        //hacemos el polimorfismo con clase abstracta
                        String resultadoCorazon = pacientebuscar.getCorazon().funcionBiologica(examenpaciente);
                        String resultadoSangre = pacientebuscar.getSangre().funcionBiologica(examenpaciente);
                        String resultadoPulmon = pacientebuscar.getPulmon().funcionBiologica(examenpaciente);

                        System.out.println("FUNCION FISIOLOGICA DEL CORAZÓN:\n " + resultadoCorazon);
                        System.out.println("FUNCION FISIOLOGICA DE LA SANGRE:\n " + resultadoSangre);
                        System.out.println("FUNCION FISIOLOGICA DEL PULMON:\n " + resultadoPulmon);
                        System.out.println("\n ESO ES TODO.... \n \n");

                    }
                }
                case 3 -> {

                }

                case 4 -> { //mostrar personal del hospital y pacientes
                    console.imprimirEncabezado("LISTA DE DOCTORES Y PACIENTES EN " + hospitalsanitas.getNombre());
                    console.imprimirEncabezado("D O C T O R E S ");
                    for (PersonalMedico doctor : hospitalsanitas.getDoctores()) {
                        System.out.println(doctor.obtenerInfo());
                    }
                    console.imprimirEncabezado("P A C I E N T E S");
                    for (Paciente paciente : hospitalsanitas.getPacientes()) {
                        System.out.println(paciente.obtenerInfo());
                    }
                }
            }
        } while (opcion != 5);// TENGO QUE HACER LA EXCEPCION
        console.imprimirEncabezado("EL PROGRAMA HA FINALIZADO");
    }

    // acá acaba el main
    private static Paciente crearPaciente() {
        String Nombre = console.leerString("Ingrese el nombre del paciente: ");
        String Apellido = console.leerString("Ingrese el apellido del paciente: ");
        int Edad = console.leerEntero("Ingrese la edad del paciente: ");
        int Identificacion = console.leerEntero("Ingrese la identificación del paciente: ");
        String Sexo = console.leerString("Ingrese el sexo del paciente");

        console.imprimirEncabezado("""
                                               MUY BIEN, ESTAMOS A UN PASO 
                                               DE INGRESARLO AL SISTEMA.
                                               AHORA INGRESEMOS TUS DATOS CARDIOL\u00d3GICOS
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

        //se crea el paciente con los datos ingresados por el usuario
        Paciente nuevoPaciente = new Paciente(Nombre, Apellido, Edad, Identificacion, Sexo, RitmoCardiaco,
                PresionSistolica, PresionDistolica, TamañoCorazon, CantidadGrasa, GlobulosRojos,
                GlobulosBlancos, Presioninterna, Tasadeflujo, EdadPulmon);
        return nuevoPaciente;
    }
}
