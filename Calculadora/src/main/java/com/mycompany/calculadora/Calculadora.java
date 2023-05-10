/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.calculadora;

import java.util.Scanner;

/**
 *
 * @author Elio Raymundo
 */
public class Calculadora {

    public static void main(String[] args) {
        boolean calculatorOn = true;
        String sentences = "";
        String palabrasReservadas = "";
        String numeros = "";
        int resultado = 0;
        int pila[];
        //pila = new int[2];
        int indiceArray = 0;
        pila = new int[2];

        System.out.println("Bienvenido a la calculadora mas perrona que usa pilas para realizar operaciones");
        while (calculatorOn) {
            //Reiniciar valores de variables
            palabrasReservadas = "";
            numeros = "";

            Scanner sc = new Scanner(System.in);
            //Ingresar cadena
            System.out.print("Ingrese sus instrucciones -> ");
            sentences = sc.nextLine();

            //Eliminar espacios de la cadena para poder analizarla
            sentences = sentences.replace(" ", "");

            //Separar las instrucciones de los valores
            for (short i = 0; i < sentences.length(); i++) {
                char caracter = sentences.charAt(i);
                if (isNumber(caracter)) {
                    numeros += caracter;
                } else {
                    palabrasReservadas += caracter;
                }
            }
            //System.out.println("Palabras reservadas " + palabrasReservadas);
            switch (palabrasReservadas) {
                case "push":
                    pila[indiceArray] = Integer.valueOf(numeros);
                    indiceArray++;
                    break;

                case "neg":
                    pila[1] = pila[1] * -1;
                    break;

                case "add":
                    for (int i = 0; i < pila.length; i++) {
                        resultado += pila[i];
                    }
                    break;

                case "mul":
                    resultado = pila[0] * pila[1];
                    break;

                case "div":
                    resultado = pila[0] / pila[1];
                    break;

                case "output":
                    System.out.println("El resultado de la operacion es " + resultado);
                    pila = new int[2];
                    resultado = 0;
                    indiceArray = 0;
                    break;

                case "end":
                    calculatorOn = false;
                    break;
            }
        }
    }

    private static boolean isNumber(char caracter) {
        try {
            Integer.parseInt(String.valueOf(caracter));
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
