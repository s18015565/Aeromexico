

package generadorregistros;

import java.util.concurrent.ThreadLocalRandom;

public class GeneradorRegistros {
   
   
   static String[] nombres={"ARTURO","JOSHIO","ABEL","ERNESTO","JUAN","JOSÉ LUIS","MARÍA GUADALUPE","FRANCISCO","GUADALUPE","MARÍA","JUANA","ANTONIO","JESÚS","MIGUEL ÁNGEL","PEDRO","ALEJANDRO","MANUEL","MARGARITA","MARÍA DEL CARMEN","JUAN CARLOS","ROBERTO","FERNANDO","DANIEL","CARLOS","JORGE","RICARDO","MIGUEL","EDUARDO","JAVIER","RAFAEL","MARTÍN","RAÚL","DAVID","JOSEFINA","JOSÉ ANTONIO","ARTURO","MARCO ANTONIO","JOSÉ MANUEL","FRANCISCO AVIER","ENRIQUE","VERÓNICA","GERARDO","MARÍA ELENA","LETICIA","ROSA","MARIO","FRANCISCA","ALFREDO","TERESA","ALICIA","MARÍA FERNANDA ","SERGIO ","ALBERTO ","LUIS","ARMANDO","ALEJANDRA","MARTHA","SANTIAGO","YOLANDA","PATRICIA","MARÍA DE LOS ÁNGELES","JUAN MANUEL","ROSA MARÍA","ELIZABETH","GLORIA","ÁNGEL","GABRIELA","SALVADOR","VÍCTOR MANUEL","SILVIA","MARÍA DE GUADALUPE","MARÍA DE JESÚS","GABRIEL","ANDRÉS","ÓSCAR","GUILLERMO","ANA MARÍA","RAMÓN","MARÍA ISABEL","PABLO","RUBEN","ANTONIA","MARÍA LUISA","LUIS ÁNGEL","MARÍA DEL ROSARIO","FELIPE","JORGE JESÚS","JAIME","JOSÉ GUADALUPE","JULIO CESAR","JOSÉ DE JESÚS","DIEGO","ARACELI","ANDREA","ISABEL","MARÍA TERESA","IRMA","CARMEN","LUCÍA","ADRIANA","AGUSTÍN","MARÍA DE LA LUZ","GUSTAVO","NESTOR","MAYLAND","LISETH"};
   
   static String[] apellidos={"QUIROZ","GARCIA","RODRIGUEZ","GONZALEZ","FERNANDEZ","LOPEZ","MARTINEZ","SANCHEZ","PEREZ","GOMEZ","MARTIN","JIMENEZ","RUIZ","HERNANDEZ","DIAZ","MORENO","MUÑOZ","ALVAREZ","ROMERO","ALONSO","GUTIERREZ","NAVARRO","TORRES","DOMINGUEZ","VAZQUEZ","RAMOS","GIL","RAMIREZ","SERRANO","BLANCO","MOLINA","MORALES","SUAREZ","ORTEGA","DELGADO","CASTRO","ORTIZ","RUBIO","MARIN","SANZ","NUÑEZ","IGLESIAS","MEDINA","CORTES","GARRIDO","CASTILLO","SANTOS","LOZANO","GUERRERO","CANO","PRIETO","MENDEZ","CRUZ","CALVO","HERRERA","GALLEGO","FLORES","MARQUEZ","LEON","PEÑA","VIDAL","CABRERA","CAMPOS","VEGA","FUENTES","CARRASCO","DIEZ","REYES","CABALLERO","NIETO","AGUILAR","SANTANA","PASCUAL","HERRERO","MONTERO","HIDALGO","LORENZO","GIMENEZ","IBAÑEZ","FERRER","SANTIAGO","DURAN","VARGAS","BENITEZ","MORA","ARIAS","VICENTE","CARMONA","CRESPO","ROMAN","SOTO","PASTOR","SAEZ","VELASCO","MOYA","SOLER","PARRA","ROJAS","ESTEBAN","BRAVO","GALLARDO"};
   
   static String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
   
   static int [] ladas={922,744,449,241,244,981,998,461,625,55,938,461,625,
                     55,938,639,341,656,753,831,443,445,642,631,867,951,
                     392,272,771,627,427,782,644,481,834,921,312,271,735,
                     777,667,983,624,444,653,899,861,353};
   
   static int[] dias={1,2,3,4,5,6,7,8,9,10,
                    11,12,13,14,15,16,17,18,19,20,
                    21,22,23,24,25,26,27,28,29,30};
        
   static int[] mes={1,2,3,4,5,6,7,8,9,10,11,12};
   
   static String[] correo={"@GMAIL.COM","@OUTLOOK.COM","@YAHOO.COM","@HOTMAIL.COM"};
   
   static String nombre=null;
   
   
   
    public static void main(String[] args) {
        
        int numeroFilas=10;
        int numeroCampos=7;
        String nombreTabla="Clientes";
        
        System.out.println("INSERT INTO TABLE "+nombreTabla+" VALUES");
        
        for (int i = 1; i <= numeroFilas; i++) {
          
        for (int j = 0; j <= numeroCampos; j++) {
            
            switch(j){
                
                case 1: //NOMBRE DEL CLIENTE
                    System.out.print("(");
                    nombre=nombres[generarAleatorio(nombres.length)];
                    imprimirColumna(nombre);
                    break;
                    
                case 2: //PRIMER APELLIDO
                    imprimirColumna(apellidos[generarAleatorio(apellidos.length)]);
                    break;
                    
                case 3://SEGUNDO APELLIDO
                    imprimirColumna(apellidos[generarAleatorio(apellidos.length)]);
                    break;
                    
                case 4://GENERAR FECHA DE NACIMIENTO
                    imprimirColumna(generarFecha());
                    break;
                    
                case 5://GENERAR GENERO
                    
                    break;
                    
                case 6://GENERAR TELEFONO
                    imprimirColumna(generarTelefono());
                    break;
                    
                case 7://GENERAR CORREO
                    imprimirColumnaU(generarCorreo(nombre));
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
    
    
    public static int generarAleatorio(int l){ //GENERAR ALEATORIO CON RANGO ENTRE 0 Y <l>
        java.util.Random X = new java.util.Random();
        int num=X.nextInt(l);    
        return num;
    }
    
    public static int generarAleatorioRango(int min, int max){ //GENERAR ALEATORIO CON RANGO MINIMO Y MAXIMO
        int num = ThreadLocalRandom.current().nextInt(min, max + 1);
        return num;
    }
    
    
    public static String generarCodigo(int l){
        
        StringBuilder sb = new StringBuilder(l);
        for (int i = 0; i < l; i++) {
            sb.append( symbols[generarAleatorio(symbols.length)] );
    }
        return sb.toString();
    }
    
    public static String generarFecha(){
        
        int min=1950; //Parámetro de año mínimo 
        int max=2018;//Parámetro de año máximo

        int año = generarAleatorioRango(min,max);
        
        return String.format("%d-%d-%d",dias[generarAleatorio(dias.length)],mes[generarAleatorio(mes.length)],año);
        
    }
    
    public static String generarTelefono(){
        return String.format("%d%s", ladas[generarAleatorio(ladas.length)],generarCodigo(7));
    }
    
    public static String generarCorreo(String n){
        return String.format("%s%s",n,correo[generarAleatorio(correo.length)]);
    }
}

