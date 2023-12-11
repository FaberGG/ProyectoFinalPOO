/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import static Presentacion.Principal.sc;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author PERSONAL
 */
public class Consola {

    public void Consola() {

    }

    public void imprimirEncabezado(String msg) {
        System.out.println("-------------------------------------------");
        System.out.println(" " + msg.toUpperCase() + " ");
        System.out.println("-------------------------------------------");
        System.out.println(""); //salto de linea

    }

    public void imprimirEstadoPaciente(String estado) {
        switch (estado) {
            case "REMITIDO":
                System.out.println("  -Sera remitido con otro especialista");
                break;
            case "NO REMITIDO":
                System.out.println("  -No se remitira, pero se le debe seguir suministrando medicamento");
                break;
            case "DADO DE ALTA":
                System.out.println("  -Sera dado de alta del hospital");
                break;
            default:
                System.err.println("Error Inesperado");
                ;
        }
    }

    //funcion limpiar consola segun el sistema operativo
    public void limpiarPantalla() {
        try {
            //revisa en que os esta ejecutando
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para sistemas tipo Unix
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al intentar limpiar la consola.");
        }
    }

    // Función para esperar a que se presione una tecla
    public void esperarTecla() {
        System.out.println("\nPresiona ENTER para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Espera hasta que se presione Enter
    }

    public int leerOpcion(int rango) {
        int opc;
        do {
            opc = leerEntero("Ingrese la opcion: ");
            if (opc >= 1 && opc <= rango) {
                return opc;
            } else {
                System.out.println("Opcion no valida VUELVA A INTENTARLO");
            }
        } while (opc <= 1 || opc >= rango);

        return opc;
    }

    public int leerEntero(String mensaje) {
        int entero;
        System.out.println("");
        System.out.print(mensaje);
        try {
            entero = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("!!!Error!!!: Debe ingresar un número entero para la opción.");
            sc.nextLine(); // Limpiar el buffer del scanner
            entero = 0;
        }
        return entero;
    }

    public String leerString(String mensaje) {
        String cadena;
        try {
            System.out.println(mensaje);
            cadena = sc.next();
        } catch (Exception e) {
            System.out.println("Error al leer. Asegúrate de ingresar una cadena válida.");
            return null;
        } finally {
        }
        return cadena;
    }

    // METODO IMPRIMIR MENU PRINCIPAL
    public void ImprimirMenuP() {
        imprimirEncabezado("BIENVENIDOS AL SISTEMA HOSPITAL COLSANITAS");

        imprimirEncabezado("POR FAVOR INGRESE UNA OPCION");
        System.out.println(" 1. Registrar un paciente");
        System.out.println(" 2. Mostrar examen del paciente ");
        System.out.println(" 3. Mostrar tratamiento del paciente");
        System.out.println(" 4. Mostrar Personal del hospital y pacientes");
        System.out.println(" 5. Salir");
    }
}
