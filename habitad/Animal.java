/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habitad;

/**
 *
 * @author Estudiantes
 */
enum TipoAnimal { MAMIFERO, AVE, REPTIL, PEZ }

class Animal {
    String nombre;
    int edad;
    TipoAnimal tipo;

    public Animal(String nombre, int edad, TipoAnimal tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ", " + edad + " años)";
    }
}

