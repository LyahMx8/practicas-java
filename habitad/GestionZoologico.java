/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habitad;

/**
 *
 * @author Estudiantes
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GestionZoologico {

    public static void main(String[] args) {
        List<Animal> animalesCosta = Arrays.asList(
            new Animal("Bocachico", 10, TipoAnimal.PEZ),
            new Animal("Mojarra", 6, TipoAnimal.PEZ),
            new Animal("Iguana", 32, TipoAnimal.REPTIL)
        );
        
        List<Animal> animalesCundinamarca = Arrays.asList(
            new Animal("Colibrì", 8, TipoAnimal.AVE),
            new Animal("Ardilla", 15, TipoAnimal.MAMIFERO),
            new Animal("Chiguiro", 20, TipoAnimal.MAMIFERO),
            new Animal("Oso de anteojos", 30, TipoAnimal.MAMIFERO)
        );
        
        List<Animal> animalesAntioquia = Arrays.asList(
            new Animal("Hipopotamo", 13, TipoAnimal.MAMIFERO),
            new Animal("Zariguella", 8, TipoAnimal.MAMIFERO),
            new Animal("Aguila calva", 12, TipoAnimal.AVE)
        );
        
        List<Habitad> habitats = Arrays.asList(
            new Habitad("Costa Colombiana", animalesCosta, Arrays.asList(new Cuidador("Juan Camelo"))),
            new Habitad("Cerros Andinos", animalesCundinamarca, Arrays.asList(new Cuidador("Ana Pardo"), new Cuidador("Andru Vereda"))),
            new Habitad("Eje cafetero", animalesAntioquia, Arrays.asList(new Cuidador("Fabian Virguez"), new Cuidador("Angie Fajardo")))
        );

        // Listar todos los animales por tipo
        System.out.println("--- Mamíferos en el Zoo ---");
        habitats.stream()
                .flatMap(habitad -> habitad.animales.stream())
                .filter(animal -> animal.tipo == TipoAnimal.MAMIFERO)
                .forEach(System.out::println);

        // Filtrar animales por rango de edad
        System.out.println("\n--- Animales entre 5 y 9 años ---");
        habitats.stream()
                .flatMap(habitad -> habitad.animales.stream())
                .filter(animal -> animal.edad >= 5 && animal.edad <= 9)
                .forEach(System.out::println);

        // Habitat con mayor número de animales
        System.out.println("\n--- Hábitat más poblado ---");
        habitats.stream()
                .max(Comparator.comparingInt(h -> h.animales.size()))
                .ifPresent(habitad -> System.out.println(habitad.nombre + " con " + habitad.animales.size() + " animales"));

        // Ordenar todos los animales por nombre
        System.out.println("\n--- Animales ordenados por nombre ---");
        habitats.stream()
                .flatMap(habitad -> habitad.animales.stream())
                .sorted(Comparator.comparing(animal -> animal.nombre))
                .forEach(System.out::println);

        // Promedio de edad de los animales por hábitat
        System.out.println("\n--- Promedio de edad por Hábitat ---");
        habitats.forEach(habitad -> {
            double promedio = habitad.animales.stream()
                                        .mapToInt(a -> a.edad)
                                        .average()
                                        .orElse(0.0);
            System.out.println(habitad.nombre + ": " + promedio + " años");
        });
    }
}
