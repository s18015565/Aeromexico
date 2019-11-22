
package generadorregistros;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneradorRegistros {
    
   static java.util.Random X = new java.util.Random();
   static String[] nombres={"KARLA","NESTOR","ANDREA","CESAR","EMILIO","ERNESTO","LISETTE","ABEL","TOÑO","ALEXIS","TITO","VICTOR","MAYLAND"};
   static String[] apellidos={};
    
    public static void main(String[] args) {
        
        int numeroFilas=200;
        int numeroRegistros=4;
        String nombreTabla="Viajeros";
        
        String valor="1";
        String registro="' "+valor+" ', ";
        
        
        
        System.out.println("INSERT INTO TABLE "+nombreTabla+" VALUES");
        
        
        for (int i = 1; i <= numeroFilas; i++) {
          
        for (int j = 0; j <= numeroRegistros; j++) {
            
            switch(j){
                
                case 1: //COLUMNA UNO, ID DE LA TABLA
                    System.out.print("(");
                    valor=generarCodigo();
                    imprimirColumna(valor);
                    break;
                    
                case 2:
                    imprimirColumna(nombres[generarAleatorio(nombres.length)]);
                    break;
                    
                case 3:
                    valor=generarFecha();
                    imprimirColumna(valor);
                    break;
                    
                    
                case 4:
                    valor=Integer.toString(i);
                    imprimirColumnaU(valor);
                    
                    break;
                 
            }
            
        }
        
        
        }
        
    }
    
    public static void imprimirColumna(String valor){
        System.out.print("' "+valor+" ', ");
    }
    
    public static void imprimirColumnaU(String valor){
        System.out.println("' "+valor+" '), ");
    }
    
    //Método para generar un número aleatorio con valor entre 0 y <l>. Ocupado principalmente para conseguir un valor aleatorio en un arreglo.
    public static int generarAleatorio(int l){
        int Y=(X.nextInt(l));
        return Y;
    }
    
    public static String generarCodigo(){
        String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int length = 4;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int Y=(generarAleatorio(symbols.length));
            sb.append( symbols[Y] );
    }
        String password = "VI"+sb.toString();

        return password;
    }
    
    public static String generarFecha(){
        
        int min=1950; //Parámetro de año mínimo para 
        int max=2018;
        
        String[] dias={"01","02","03","04","05","06","07","08","09","10",
                       "11","12","13","14","15","16","17","18","19","20",
                       "21","22","23","24","25","26","27","28","29","30"};
        
        String[] mes={"01","02","03","04","05","06","07","08","09","10","11","12"};
        
        //int año = ThreadLocalRandom.current().nextInt(min, max + 1);
        int año=5;
        
        return String.format("%s-%s-%d",dias[generarAleatorio(dias.length)],mes[generarAleatorio(generarAleatorio(mes.length))],año);
    }
}
