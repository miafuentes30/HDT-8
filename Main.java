/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Mia Alejandra Fuentes Merida
 */

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.PriorityQueue;
 import java.util.Scanner;
 
 public class Main {
 
     public static void main(String[] args) {
         PriorityQueue<Pacientes> colaEmergencia = new PriorityQueue<>();
 
         cargarPacientes(colaEmergencia);
 
         while (!colaEmergencia.isEmpty()) {
             Pacientes paciente = colaEmergencia.poll();
             System.out.println("El paciente retirado es: " + paciente);
         }
     }
 
     private static void cargarPacientes(PriorityQueue<Pacientes> colaEmergencia) {
         try {
             File archivo = new File("pacientes.txt");
             Scanner scanner = new Scanner(archivo);
             while (scanner.hasNextLine()) {
                 String linea = scanner.nextLine();
                 String[] partes = linea.split(",");
                 if (partes.length == 3) {
                     String nombre = partes[0].trim();
                     String sintoma = partes[1].trim();
                     char codigoEmergencia = partes[2].trim().charAt(0);
                     colaEmergencia.add(new Pacientes(nombre, sintoma, codigoEmergencia));
                 }
             }
             scanner.close();
         } catch (FileNotFoundException e) {
             System.err.println("No se pudo cargar el archivo 'pacientes.txt'");
             e.printStackTrace();
         }
     }
 }