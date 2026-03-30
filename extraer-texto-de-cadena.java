/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.mycompany.mavenproject2;

/**
*
* @author Estudiantes
*/
public class persons_age {
    String texto = "Juan(25), Maria(30), Pedro(19), Ana(22), Carlos(35), Laura(28), "
                + "Miguel(41), Sofia(27), Diego(33), Camila(24), Andres(29), Daniela(31), "
                + "Jorge(45), Paula(26), Fernando(38), Valentina(21), Ricardo(50), "
                + "Patricia(36), Gabriel(32), Luisa(23), Alejandro(40), Natalia(34), "
                + "Roberto(44), Adriana(37), Esteban(39), Monica(42), Sebastian(20), "
                + "Tatiana(27), Oscar(48), Carolina(33), Manuel(46), Beatriz(29), "
                + "Rafael(41), Veronica(35), Hector(52), Angela(30), Ivan(28), "
                + "Diana(24), Pablo(47), Andrea(31), Eduardo(43), Claudia(36), "
                + "Alberto(55), Rosa(49), Tomas(38), Gloria(45), Victor(53), "
                + "Sandra(34), Luis(37), Marta(44), Sergio(39), Elena(41), "
                + "Julian(26), Silvia(28), Cristian(32), Irene(33), Nicolas(22), "
                + "Lorena(27), Mario(35), Teresa(42), David(31), Alicia(30), "
                + "Francisco(48), Pilar(46), Raul(29), Cecilia(34), Bruno(25), "
                + "Isabel(37), Joaquin(40), Carmen(39), Mateo(23), Julia(24)";

    public void main() {
        String[] person_age = texto.split(",");

        for (String person_age1 : person_age) {
            String[] parts = person_age1.split("\\s*[()]");
            System.out.println("El ciudadano "+parts[0] + " tiene " + parts[1] + " años");
        }
    }
}
 