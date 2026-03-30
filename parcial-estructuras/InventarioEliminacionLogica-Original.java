import java.io.*;
import java.util.Scanner;

public class InventarioEliminacionLogica {
    // Método para mostrar contenido de un archivo
    public static void mostrarArchivo(String nombreArchivo) {
        System.out.println("Contenido del archivo: " + nombreArchivo);
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        System.out.println("-------------------------");
    }

    public static void crearArchivoInventario(String nombreArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            pw.println("Camiseta,50,15000");
            pw.println("Pantalón,30,25000");
            pw.println("Zapatos,20,40000");
            pw.println("Gorra,15,10000");
            System.out.println("Archivo de inventario creado: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    // Métodos a implementar
    // 1. Marcar un registro como eliminado agregando '#' al inicio si coincide con el producto indicado
    public static void marcarEliminado(String nombreArchivo, String productoEliminar) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            String newFile = "";

            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith("#") && linea.contains(productoEliminar)) {
                    newFile += "#" + linea + "\n";
                } else {
                    newFile += linea + "\n";
                }
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
                pw.print(newFile);
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    // 2. Crear un nuevo archivo sin los registros marcados como eliminados
    public static void crearArchivoSinEliminados(String archivoOriginal, String archivoNuevo) {
        // Completar implementación
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivo = "inventario.txt";

        crearArchivoInventario(archivo);
        mostrarArchivo(archivo);

        System.out.print("Ingrese el nombre del producto para eliminar lógicamente: ");
        String productoEliminar = sc.nextLine();

        marcarEliminado(archivo, productoEliminar);
        mostrarArchivo(archivo);

        String archivoActualizado = "inventario_actualizado.txt";
        crearArchivoSinEliminados(archivo, archivoActualizado);
        mostrarArchivo(archivoActualizado);

        sc.close();
    }
}
