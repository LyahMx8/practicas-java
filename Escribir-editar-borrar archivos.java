/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.archivopractica;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
import java.io.FileNotFoundException;

public class ArchivoPractica {
    public static void main(String[] args) {
        ArchivoPractica.crearArchivo("lalaland.txt");
        
        ArchivoPractica.escribirArchivo("lalaland.txt", "Erase una vez una cucaracha...");
        
        try {
            ArchivoPractica.anexarArchivo("lalaland.txt", "Que salió volando y se perdió");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArchivoPractica.leerArchivo("lalaland.txt");
        
        //ArchivoPractica.borrarArchivo("lalaland.txt");
    }
    
    public static void crearArchivo(String nombreArchivo) {
        try {
            File myFile = new File(nombreArchivo);
            
            if(!myFile.createNewFile()) {
                System.out.println("Error creating " + nombreArchivo);
            } else {
                System.out.println("File created: " + myFile.getName());
            }
        } catch (IOException e) {
            System.err.println("Error creating " + nombreArchivo);
            e.printStackTrace();
        }
    }
    
    public static void escribirArchivo(String nombreArchivo, String content) {
        try(FileWriter writeFile = new FileWriter(nombreArchivo)) {
            writeFile.write(content);
            writeFile.close();
            System.out.println("Succesfully file writted " + nombreArchivo);
        } catch(IOException e) {
            System.err.println("Error writting " + nombreArchivo);
            e.printStackTrace();
        }
    }
    
    public static void anexarArchivo(String nombreArchivo, String content) throws IOException {
        try {
            Path filePath = Paths.get(nombreArchivo);
            
            List<String> lines = Files.readAllLines(filePath);

            if(!lines.isEmpty()) {
                lines.add(content);
                Files.write(filePath, lines);
            } else {
                Files.write(filePath, List.of(content));
            }
        } catch (FileNotFoundException  e) {
            System.err.println("Error getting file " + nombreArchivo);
            e.printStackTrace();
        }
        
    }
    
    public static void leerArchivo(String nombreArchivo) {
        Path filePath = Paths.get(nombreArchivo);
        
        try {
            Scanner fileReader = new Scanner(filePath);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
        } catch(FileNotFoundException  e) {
            System.err.println("Error getting file " + nombreArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void borrarArchivo(String nombreArchivo) {
        Path filePath = Paths.get(nombreArchivo);
        
        try {
            Files.delete(filePath);
            System.out.println("File is deleted");
        } catch (IOException e) {
            System.err.println("Failed to delete the file: " + nombreArchivo);
            e.printStackTrace();
        }
    }
}