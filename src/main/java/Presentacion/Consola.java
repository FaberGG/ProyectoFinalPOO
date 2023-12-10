/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import static Presentacion.Principal.sc;
import java.util.InputMismatchException;

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
        System.out.println(mensaje);
        cadena = sc.next();

        return cadena;
    }

    // METODO IMPRIMIR MENU PRINCIPAL
    public void ImprimirMenuP() {
        imprimirEncabezado("BIENVENIDO AL SISTEMA HOSPITAL COLSANITAS");

        imprimirEncabezado("POR FAVOR INGRESE UNA OPCION");
        System.out.println(" 1. Registrar un paciente");
        System.out.println(" 2. Mostrar examen del paciente ");
        System.out.println(" 3. Mostrar tratamiento del paciente");
        System.out.println(" 4. Mostrar Personal del hospital y pacientes");
        System.out.println(" 5. Salir");
    }
}
