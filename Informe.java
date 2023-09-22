/*Laboratorio #2
 * Marinés García - 23391
 * MAIN
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  

public class Informe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idInput;
        ArrayList<Integer> cursoNoList = new ArrayList<Integer>();
        ArrayList<Integer> cursoSiList = new ArrayList<Integer>();

        String line = "";  
        String splitBy = ",";  

        System.out.println("\n<<<Archivo Salones>>>");
        try   {  
            BufferedReader brSalon = new BufferedReader(new FileReader("Salones.csv"));  
            while ((line = brSalon.readLine()) != null){  
                String[] salon = line.split(splitBy);    // use comma as separator  
                System.out.println("\nId sede: " + salon[0] + "\nEdificio: " + salon[1] + "\nNivel: " + salon[2] + "\nId salón: " + salon[3] + "\nCapacidad: " + salon[4]);  
                }  
            System.out.println("\nSe ha cargado el archivo exitosamente!");        
        } catch (IOException e)   {  
                e.printStackTrace();  
        } 

        System.out.println("\n<<<Archivo Cursos>>>");
        try   {  
            BufferedReader brCurso = new BufferedReader(new FileReader("Cursos.csv"));  
            while ((line = brCurso.readLine()) != null){  
                String[] curso = line.split(splitBy);    // use comma as separator  
                System.out.println("\nId curso: " + curso[0] + "\nId sede: " + curso[1] + "\nNombre curso: " + curso[2] + "\nHorario: " + curso[3] + " " + curso[5] + "\nDuración (hr): " + curso[4] + "\nCantidad de estudiantes:" + curso[6]);  
                }  
            System.out.println("\nSe ha cargado el archivo exitosamente!");    
        } catch (IOException e)   {  
                e.printStackTrace();  
        }  









        sc.close();
    }
}
