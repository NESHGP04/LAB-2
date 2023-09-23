/*Laboratorio #2
 * Marinés García - 23391
 * CLASE
 */

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Salones {

    private String disponible;
    private int capacidad;
    private boolean ocupado;
    String[][] datosCSV = deCSVmatriz("Salones.csv");

    private Scanner s;
    
    public Salones(String disponible, int capacidad, boolean ocupado){
        this.disponible = disponible;
        this.capacidad = capacidad;
        this.ocupado = ocupado;
    }

    //Lee archivo CSV por partes
    public void setSalones(){
        try{
            File f = new File("Salones.csv");
            s = new Scanner (f);
            String line = s.nextLine();
            String[] parts1 = line.split(",");
                System.out.println(parts1[0]+" "+parts1[1]+" "+parts1[2]+" "+parts1[3]+" "+parts1[4]+" "+parts1[5]+" "+parts1[6]);
                System.out.println("------------------------------");

            while(s.hasNextLine()){
                line = s.nextLine();
                String[] parts = line.split(",");
                String[][] matriz = new String[10][7];
                System.out.println(parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]+" "+parts[4]+" "+parts[5]+" "+parts[6]);
                } 
            }catch(FileNotFoundException e){
        System.out.println("el archivo no existe");
        }  
    }

    //Lee archivo CSV y convierte a matriz para ser utilizada después
    public static String[][] deCSVmatriz(String rutaSCV){
        try{
            Scanner lector = new Scanner(new File(rutaSCV));
            String[][] matriz = new String[30][7];
            int fila = 0;
            String linea = lector.nextLine();
 
			while (lector.hasNextLine()) {
				matriz[fila] = linea.split(","); //Separamos datos de la linea CSV leida e insertamos en matriz
				fila++; //APuntamos a la siguiente fila
				linea = lector.nextLine(); //Leemos siguiente línea
			}
			lector.close();
			//Finalizada la lectura de archivo CSV, retornamos la matriz con los datos
			return matriz;
        }catch (FileNotFoundException e) {
			System.out.println("No se encuentra fichero: " + rutaSCV);
			return null;
        }
    }

    public void mostrarAsignaciones(String[][] matriz) {

        System.out.println("Ingrese ID de salón");
        Scanner sc = new Scanner(System.in);
        int idSalon = sc.nextInt();
        String s = String.valueOf(idSalon); //Cambia e int a String

		//Empezamos a recorrer matriz desde fila 1, la fila 0 es cabecera, no contiene datos
		for (int fila = 1; fila < matriz.length; fila++) {
			String nombre = matriz[fila][0]; //Recogemos nombre del estudiante de esta fila
 
			if (nombre != null) //Si no es null, es que en esta fila de la matriz hay datos con los que trabajar
				//Ahora recorremos columnas, si encontramos valor "0", mostramos nombre y número de asignacion
				for (int col = 0; col < matriz[fila].length; col++)
					if (matriz[fila][col].equals(s))
						System.out.println(nombre + " --> " + matriz[0][col]); //Nombre asignacion lo obtenemos de la cabecera(fila 0)
		}
        sc.close();
    }
}
