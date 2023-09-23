/*Laboratorio #2
 * Marinés García - 23391
 * MAIN
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.*;  

public class Informe {
    public static void main(String[] args) {

        //Asignación de variables
        Scanner sc = new Scanner(System.in);
        int idInput;
        ArrayList<Integer> cursoNoList = new ArrayList<Integer>();
        ArrayList<Integer> cursoSiList = new ArrayList<Integer>();

        String[] salon;
        boolean salir = false;

        String line = "";  
        String splitBy = ",";  

        //Lee archivo CSV Salones y convierte a matriz
        System.out.println("\n<<<Archivo Salones>>>");
        try   {  
            BufferedReader brSalon = new BufferedReader(new FileReader("Salones.csv"));  //Lee salones.csv
            while ((line = brSalon.readLine()) != null){  
                salon = line.split(splitBy);    // use comma as separator  
                System.out.println("\nId sede: " + salon[0] + "\nEdificio: " + salon[1] + "\nNivel: " + salon[2] + "\nId salón: " + salon[3] + "\nCapacidad: " + salon[4]);  //Ordena datos separados por comas
                }  
            System.out.println("\nSe ha cargado el archivo exitosamente!");        
        } catch (IOException e)   {  
                e.printStackTrace();  
        } 

        //Lee archivo CSV Cursos y convierte a matriz
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
        
        //Asignación de salones
        System.out.println("\n==== ASIGNACIÓN DE SALONES ====");
        
        while(!salir){

            //Menú
            System.out.println("\n>>> MENÚ <<<");
            System.out.println("1.Asignar curso \n2.Informe \n3.Salón");
            int opc = sc.nextInt();
            sc.nextLine();

            switch(opc){
                case 1:
                    //Asignacion de cursos
                    System.out.println("\n<<Asignación de cursos>>");

                        //pide salón y busca en csv si salón disponible
                    try{
                        BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
                        BufferedReader reader = new BufferedReader(new FileReader("Salones.csv"));
                        System.out.println("Ingrese el salón que desea asifnarse: ");
                        String asignar = in.readLine();
                        
                        boolean found = false;
                        String linea = null;

                        while((linea=reader.readLine())!=null){
                            String[] parts = linea.split(",");
                            int totalParts = parts.length;
                            for(int i = 0; i< totalParts; i++){
                                if(asignar.compareTo(parts[i]) == 0){
                                    System.out.println("Se ha encontrado su salón.");
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if(found == false){
                            System.out.println("No se ha encontrado el salón.");
                        }else{
                            System.out.println("Se ha asignado correctamente!");
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                        }
                    break;
                    
                case 2:
                //                        Imprimir informes
                //            for(int i=0 ;i < cursoNoList.size() +cursoSiList.size()+1; ++i ){
                //                    System.out.print(cursoNoList.get(i));
                //                        System.out.print(",");
                //                            System.out.print(cursoSiList.get(i-1));
                //                                }
                //            imprimirInforme(cursoNoList,cursolist);
                //           
                    break;
                case 3:
                    System.out.println("Ha salido del programa!");
                    salir = true;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
        
        //        for (int i=0 ;i<=cursoNoList.size()-1;i++){
            //            if (!cursoNoList[i].equals(""))
            //                System.out.print(cursoNoList + " ");
        sc.close();
    }
}
