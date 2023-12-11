package Presentacion;

import java.util.Scanner;
import Logica.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    //CREAMOS OBJETO PARA RELACIZAR TODAS LAS LECTURAS NECESARIAS
    static Scanner sc = new Scanner(System.in);

    //CREAMOS EL OBJETO HOSPITAL 
    static Hospital hospitalsanitas = new Hospital("Sanitas", "Crra 78k-no78B-78Sur\n  Alameda del parque");
    //creamos el objeto consola para interactuar con el usuario
    static Consola console = new Consola();

    public static void main(String[] args) {

        //CREAMOS LA LISTA DE PERSONAS EN EL HOSPITAL (polimorfismno inclusion)
        List<Persona> personas;

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
        PersonalAdministrativo secretario = new PersonalAdministrativo("Thiago", "Bedoya", "Secretario" ,18, 8888, 5646);
        PersonalAdministrativo auxiliar = new PersonalAdministrativo("Simon", "Arrechabaleta", "Auxiliar" ,19, 0000, 5657);

        //SETTEAMOS PARA ESTABLECER LA RELACION
        secretario.setAuxiliar(auxiliar);

        //Agregamos al secretario al hospital
        hospitalsanitas.agregarSecretario(secretario);

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

                        System.out.println("FUNCION FISIOLOGICA DEL CORAZÓN:\n " + resultadoCorazon.toLowerCase());
                        System.out.println("FUNCION FISIOLOGICA DE LA SANGRE:\n " + resultadoSangre.toLowerCase());
                        System.out.println("FUNCION FISIOLOGICA DEL PULMON:\n " + resultadoPulmon.toLowerCase());
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
                    console.imprimirEncabezado("LISTA DE PERSONAL Y PACIENTES EN " + hospitalsanitas.getNombre());

                    //obtenemos todas las personas en el hostpital
                    personas = obtenerPersonas(hospitalsanitas);

                    //HACEMOS USO DEL MÉTODO ABSTRACTO PARA OBTENER INFORMACION DE CADA UNA
                    //trato los objetos de la clase hija como objetos de la clase padre
                    for (Persona persona : personas) {
                        System.out.println("");//salto de linea adicional
                        System.out.println(persona.obtenerInfo());
                    }
                }
            }
            console.esperarTecla();
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

    //funcion para crear la lista de todas las personas en un hospital
    private static List<Persona> obtenerPersonas(Hospital hospital) {
        List<Persona> personas = new ArrayList<>();
        //para el personal medico
        personas.addAll(hospital.getDoctores());
        //para secretarios
        personas.addAll(hospital.getSecretarios());
        //para auxiliares
        personas.addAll(hospital.getAuxiliares());
        //para pacientes en el hospital
        personas.addAll(hospital.getPacientes());
        return personas;
    }

    //metodo para crear el paciente con los datos ingresados por el usuario
        private static Paciente crearPaciente() {
        String Nombre = console.leerString("\n Ingrese el nombre del paciente: ");
        String Apellido = console.leerString("\nIngrese el apellido del paciente: ");
        int Edad = console.leerEntero("\nIngrese la edad del paciente: ");

         //CREAMOS LA EXCEPCION PARA INVALIDAR CADENAS INVÁLIDAS
        try {
            String sexo = console.leerString("\nIngrese el sexo del paciente");
            // Resto del código con el sexo obtenido
            System.out.println("Sexo ingresado: " + sexo);
        } catch (Exception e) {
            System.out.println("Error al leer el sexo del paciente. Asegúrate de ingresar una cadena válida.");
        } finally { 
        }

        
        //CREAMOS UNA EXCEPCIÓN PARA INVALIDAR NUMEROS NEGATIVOS PARA LA IDENTIFICACION DEL USUARIO
        boolean entradaValida = false;
        int Identificacion=0;
        while (!entradaValida) {
            try {
               Identificacion = console.leerEntero("\nIngrese la identificación del paciente: ");

                if (Identificacion < 0) {
                    System.out.println("Error: No se permiten valores negativos. Por favor, ingrese un valor válido.");
                } else {
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor entero válido.");
            }
        }

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
