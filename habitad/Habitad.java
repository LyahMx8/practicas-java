/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package habitad;

import java.util.List;

/**
 *
 * @author Estudiantes
 */
public class Habitad {
    String nombre;
    List<Animal> animales;
    List<Cuidador> cuidadores;

    public Habitad(String nombre, List<Animal> animales, List<Cuidador> cuidadores) {
        this.nombre = nombre;
        this.animales = animales;
        this.cuidadores = cuidadores;
    }
}

    //String[] animales = ["vaca","cabra","oveja","cordero","gallina"];