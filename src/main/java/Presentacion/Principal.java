package Presentacion;

import java.util.Scanner;
import Logica.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    //CREAMOS OBJETO PARA RELACIZAR TODAS LAS LECTURAS NECESARIAS
    static Scanner sc = new Scanner(System.in);

    //CREAMOS EL OBJETO HOSPITAL 
    static Hospital hospitalsanitas = new Hospital("Sanitas", "Crra 78k-no78B-78Sur- Alameda del parque");
    //creamos el objeto consola para interactuar con el usuario
    static Consola console = new Consola();

    public static void main(String[] args) {

        /*
            * SE CREA UN METODO QUE CREA 
            * LOS DOCTORES ESPECIALIZADOS
            * Y DEVUELVE LA LISTA DE OBJETOS
         */
        //CREAMOS LOS OBJETOS DEL PERSONAL MÉDICO (DOCTORES)
        ArrayList<PersonalMedico> doctores = crearDoctores();

        //AGREGAMOS A LOS DOCTORES EN EL HOSPITAL 
        hospitalsanitas.agregarDoctores(doctores);

        //CREAMOS EL OBJETO DE TIPO PERSONALADMINISTRATIVO PARA REALIZAR LA AUTORELACION 
        PersonalAdministrativo secretario = new PersonalAdministrativo("Thiago", "Bedoya", 18, 8888, 5646);
        PersonalAdministrativo auxiliar = new PersonalAdministrativo("Simon", "Arrechabaleta", 19, 0000, 5657);

        //SETTEAMOS PARA ESTABLECER LA RELACION
        secretario.setSecretario(auxiliar);

        //Agregamos al secretario al hospital
        hospitalsanitas.setSecretario(auxiliar);

        // Invocamos el menú
        int opcion;
        do {
            console.limpiarPantalla(); // limpia la consola
            console.ImprimirMenuP();   //imprime el menu

            opcion = console.leerOpcion(5); // rango de opciones del menu
            console.limpiarPantalla(); //limpia la consola

            //CREAMOS EL SWITCH PARA EMPERZAR A TRABAJAR CON CADA CASO
            switch (opcion) {
                case 1 -> {

                    console.imprimirEncabezado("A G R E G A R  P A C I E N T E");
                    /* 
                        * SE CREA EL METODO PARA LEER LOS DATOS POR 
                        * CONSOLA, ESTE CREA EL OBJETO PACIENTE
                        * Y LO RETORNA PARA ASIGNARLO A LA CREACION
                        * DE UN NUEVO PACIENTE
                     */
                    //llamado a la funcion
                    Paciente nuevoPaciente = crearPaciente();

                    //CREAMOS OBJETO EXAMEN
                    Examen examenpaciente = new Examen("");

                    //setteamos para asociar paciente-examen 
                    examenpaciente.setPaciente(nuevoPaciente);
                    nuevoPaciente.setExamen(examenpaciente);

                    //asociamos el nuevo paciente con el doctor
                    nuevoPaciente.agregarDoctores(doctores);
                    // AGREGAMOS AL PACIENTE EN EL HOSPITAL (AGREGACION)
                    hospitalsanitas.AgregarPacientesAlSistema(nuevoPaciente);

                    console.imprimirEncabezado("!!!Paciente agregado con exito!!!");
                }
                case 2 -> {
                    console.imprimirEncabezado(" E X A M I N A R  P A C I E N T E");
                    int identificacion = console.leerEntero(
                            "Ingrese la identificacion del paciente para buscar su examen: ");
                    //Invocamos el metodo para buscar el paciente, el cual está en la clase Hospital
                    Paciente paciente = hospitalsanitas.BuscarPaciente(identificacion);

                    if (paciente == null) {
                        System.out.println("No se encontró un paciente con la identificación proporcionada.");
                    } else {
                        console.imprimirEncabezado("EXAMEN PACIENTE " + paciente.getNombre() + " "
                                + paciente.getApellido());

                        //llamamos al examen asociado al paciente encontrado
                        Examen examenpaciente = paciente.getExamen();
                        //llama al metodo generar resultados del examen y los imprime
                        System.out.println(examenpaciente.generarResultados());

                        // Se llaman los métodos funciones biológicas de corazón y de sangre
                        //hacemos el polimorfismo con clase abstracta
                        String resultadoCorazon = paciente.getCorazon().funcionBiologica(examenpaciente);
                        String resultadoSangre = paciente.getSangre().funcionBiologica(examenpaciente);
                        String resultadoPulmon = paciente.getPulmon().funcionBiologica(examenpaciente);

                        System.out.println("FUNCION FISIOLOGICA DEL CORAZÓN:\n " + resultadoCorazon);
                        System.out.println("FUNCION FISIOLOGICA DE LA SANGRE:\n " + resultadoSangre);
                        System.out.println("FUNCION FISIOLOGICA DEL PULMON:\n " + resultadoPulmon);
                        System.out.println("\n ESO ES TODO.... \n \n");
                    }
                }
                case 3 -> {
                    console.imprimirEncabezado(" T R A T A M I E N T O ");
                    int identificacion = console.leerEntero(
                            "Ingrese la identificacion del paciente para revisar su tratamiento: ");
                    //Invocamos el metodo para buscar el paciente, el cual está en la clase Hospital
                    Paciente paciente = hospitalsanitas.BuscarPaciente(identificacion);
                    if (paciente == null) {
                        System.out.println("No se encontró un paciente con la identificación proporcionada.");
                    } else {
                        for (PersonalMedico doctor : doctores) {
                            //establece el estado de remision a cada paciente
                            doctor.RealizarRemision();
                        }
                        //imprime el estado de remision del paciente
                        System.out.println("El Paciente " + paciente.getNombre() + " " + paciente.getApellido());
                        console.imprimirEstadoPaciente(paciente.getEstado());
                    }
                }

                case 4 -> { //mostrar personal del hospital y pacientes
                    console.imprimirEncabezado("LISTA DE DOCTORES Y PACIENTES EN " + hospitalsanitas.getNombre());
                    console.imprimirEncabezado("D O C T O R E S ");
                    //HACEMOS USO DEL MÉTODO ABSTRACTO PARA LAS TRES CLASES HIJAS DE LA CLASE PADRE (PERSONA)
                    for (PersonalMedico doctor : hospitalsanitas.getDoctores()) {
                        System.out.println(doctor.obtenerInfo());
                    }
                    console.imprimirEncabezado("P A C I E N T E S");
                    for (Paciente paciente : hospitalsanitas.getPacientes()) {
                        System.out.println(paciente.obtenerInfo());
                    }

                    //MOSTRAMOS LA AUTORELACIÓN, SECRETARIO-AUXILIAR, PARA PERSONAL ADMINISTRATIVO  
                    console.imprimirEncabezado("P E R S O N A L   A D M I N I S T R A T I V O");
                    System.out.println("Secretario: " + secretario.getNombre() + " " + secretario.getApellido() + " ////" + "Codigo de empresa " + secretario.getCodigo());
                    System.out.println("Auxiliar: " + auxiliar.getNombre() + " " + auxiliar.getApellido() + " //// " + "Codigo de la empresa " + auxiliar.getCodigo());
                }
            }
        } while (opcion != 5);// TENGO QUE HACER LA EXCEPCION
        console.imprimirEncabezado("EL PROGRAMA HA FINALIZADO");
    }

    // acá acaba el main
    //metodo crear la lista de doctores especializados del hospital
    private static ArrayList<PersonalMedico> crearDoctores() {
        ArrayList<PersonalMedico> medicos = new ArrayList<>();

        medicos.add(new PersonalMedico("Cristian", "Villada", 56, 2222, "Hematologia"));
        medicos.add(new PersonalMedico("Andres", "Chauta", 46, 1111, "Cardiologia"));
        medicos.add(new PersonalMedico("Felipe", "Guasca", 36, 3333, "Neumologia"));
        medicos.add(new PersonalMedico("Sebastian", "Leon", 26, 4444, "Cardiologia"));

        return medicos;
    }

    //metodo para crear el paciente con los datos ingresados por el usuario
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

        console.esperarTecla();
        console.limpiarPantalla();

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
