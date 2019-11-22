package generadorregistros;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneradorRegistros {
    
   static java.util.Random X = new java.util.Random();
   static String[] nombres={"JOSHIO","ABEL","ERNESTO","JUAN","JOSÉ LUIS","MARÍA GUADALUPE","FRANCISCO","GUADALUPE","MARÍA","JUANA","ANTONIO","JESÚS","MIGUEL ÁNGEL","PEDRO","ALEJANDRO","MANUEL","MARGARITA","MARÍA DEL CARMEN","JUAN CARLOS","ROBERTO","FERNANDO","DANIEL","CARLOS","JORGE","RICARDO","MIGUEL","EDUARDO","JAVIER","RAFAEL","MARTÍN","RAÚL","DAVID","JOSEFINA","JOSÉ ANTONIO","ARTURO","MARCO ANTONIO","JOSÉ MANUEL","FRANCISCO AVIER","ENRIQUE","VERÓNICA","GERARDO","MARÍA ELENA","LETICIA","ROSA","MARIO","FRANCISCA","ALFREDO","TERESA","ALICIA","MARÍA FERNANDA ","SERGIO ","ALBERTO ","LUIS","ARMANDO","ALEJANDRA","MARTHA","SANTIAGO","YOLANDA","PATRICIA","MARÍA DE LOS ÁNGELES","JUAN MANUEL","ROSA MARÍA","ELIZABETH","GLORIA","ÁNGEL","GABRIELA","SALVADOR","VÍCTOR MANUEL","SILVIA","MARÍA DE GUADALUPE","MARÍA DE JESÚS","GABRIEL","ANDRÉS","ÓSCAR","GUILLERMO","ANA MARÍA","RAMÓN","MARÍA ISABEL","PABLO","RUBEN","ANTONIA","MARÍA LUISA","LUIS ÁNGEL","MARÍA DEL ROSARIO","FELIPE","JORGE JESÚS","JAIME","JOSÉ GUADALUPE","JULIO CESAR","JOSÉ DE JESÚS","DIEGO","ARACELI","ANDREA","ISABEL","MARÍA TERESA","IRMA","CARMEN","LUCÍA","ADRIANA","AGUSTÍN","MARÍA DE LA LUZ","GUSTAVO","NESTOR","MAYLAND","LISETH"};
   static String[] apellidos={"GARCIA","RODRIGUEZ","GONZALEZ","FERNANDEZ","LOPEZ","MARTINEZ","SANCHEZ","PEREZ","GOMEZ","MARTIN","JIMENEZ","RUIZ","HERNANDEZ","DIAZ","MORENO","MUÑOZ","ALVAREZ","ROMERO","ALONSO","GUTIERREZ","NAVARRO","TORRES","DOMINGUEZ","VAZQUEZ","RAMOS","GIL","RAMIREZ","SERRANO","BLANCO","MOLINA","MORALES","SUAREZ","ORTEGA","DELGADO","CASTRO","ORTIZ","RUBIO","MARIN","SANZ","NUÑEZ","IGLESIAS","MEDINA","CORTES","GARRIDO","CASTILLO","SANTOS","LOZANO","GUERRERO","CANO","PRIETO","MENDEZ","CRUZ","CALVO","HERRERA","GALLEGO","FLORES","MARQUEZ","LEON","PEÑA","VIDAL","CABRERA","CAMPOS","VEGA","FUENTES","CARRASCO","DIEZ","REYES","CABALLERO","NIETO","AGUILAR","SANTANA","PASCUAL","HERRERO","MONTERO","HIDALGO","LORENZO","GIMENEZ","IBAÑEZ","FERRER","SANTIAGO","DURAN","VARGAS","BENITEZ","MORA","ARIAS","VICENTE","CARMONA","CRESPO","ROMAN","SOTO","PASTOR","SAEZ","VELASCO","MOYA","SOLER","PARRA","ROJAS","ESTEBAN","BRAVO","GALLARDO"};
    
    public static void main(String[] args) {
        
        int numeroFilas=100;
        int numeroRegistros=4;
        String nombreTabla="Clientes";
        
        String valor=" ";
        
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
                    //valor=Integer.toString(i);
                    imprimirColumna(apellidos[generarAleatorio(apellidos.length)]);
                    break;
                    
                    
                case 4:
                    //valor=Integer.toString(i);
                    imprimirColumnaU(generarFecha());
                    
                    break;
                 
            }
            
        }
        
        }
        
    }
    
    public static void imprimirColumna(String valor){
        System.out.print("'"+valor+"', ");
    }
    
    public static void imprimirColumnaU(String valor){
        System.out.println("'"+valor+"'), ");
    }
    
    public static int generarAleatorio(int l){
        int Y=(X.nextInt(l));
        return Y;
    }
    
//    public static int apellidoAleatorio(){
//        int Y=(X.nextInt(apellidos.length));
//        return Y;
//    }
    
    public static String generarCodigo(){
        String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int length = 4;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int Y=(X.nextInt(symbols.length));
            sb.append( symbols[Y] );
    }
        String password = "CL"+sb.toString();

        return password;
    }
    
    public static String generarFecha(){
        
        int min=1950; //Parámetro de año mínimo para 
        int max=2018;
        
        String[] dias={"01","02","03","04","05","06","07","08","09","10",
                       "11","12","13","14","15","16","17","18","19","20",
                       "21","22","23","24","25","26","27","28","29","30"};
        
        String[] mes={"01","02","03","04","05","06","07","08","09","10","11","12"};
        
        int año = ThreadLocalRandom.current().nextInt(min, max + 1);
        //int año=5;
        
        return String.format("%s-%s-%d",dias[generarAleatorio(29)],mes[generarAleatorio(generarAleatorio(11))],año);
    }
}

