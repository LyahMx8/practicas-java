/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recursividad;

/**
 *
 * @author LyahMotta
 */
public class Recursividad {
    public static String invertirCadena(String texto) {
        if (texto == null || texto.length() <= 1) {
            return texto;
        }
        
        return invertirCadena(texto.substring(1)) + texto.charAt(0);
    }

    public static void main(String[] args) {
        String original = "Hola";
        String invertida = invertirCadena(original);
        System.out.println("Original: " + original);
        System.out.println("Invertida: " + invertida);
        
        String original2 = "Recursividad";
        String invertida2 = invertirCadena(original2);
        System.out.println("Original 2: " + original2);
        System.out.println("Invertida 2: " + invertida2);
        
        String original3 = "a";
        String invertida3 = invertirCadena(original3);
        System.out.println("Original 3: " + original3);
        System.out.println("Invertida 3: " + invertida3);
    }
}