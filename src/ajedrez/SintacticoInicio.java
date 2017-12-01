
package ajedrez;

import java.util.LinkedList;
import java.util.Queue;


public class SintacticoInicio {
    int tokenplay=1;
    int tokencalc=2;
    int tokenimportar=3;
    int tokensalir=4;
    int tokenesperado=0;
    public int tok=0;
    public static int dato=0;
    public Queue<Integer> pila = new LinkedList<Integer>(); 
    String mensaje="Error Sintactico";
    public String COMANDOS(){
       // Tablero tab= new Tablero();
         tokenesperado=pila.poll();
        if((tokenesperado==tokenplay)&&(pila.isEmpty()==true)){
            System.out.println("Analisis Sintactico correcto,Se acepto 'PlayChess!'");
            dato=tokenplay;
            mensaje="Analisis Sintactico correcto,Se acepto 'PlayChess!'";
        }else if((tokenesperado==tokencalc)&&(pila.isEmpty()==true)){
             System.out.println("Analisis Sintactico correcto,Se acepto 'CalcChess!'");
             dato=tokencalc;
           mensaje="Analisis Sintactico correcto,Se acepto 'CalcChess!'";
        }else if((tokenesperado==tokenimportar)&&(pila.isEmpty()==true)){
              System.out.println("Analisis Sintactico correcto,Se acepto 'Importar'");
              dato=tokenimportar;
              mensaje="Analisis Sintactico correcto,Se acepto 'Importar'";
        }else if((tokenesperado==tokensalir)&&(pila.isEmpty()==true)){
              System.out.println("Analisis Sintactico correcto,Se acepto 'Salir!'");
              dato=tokensalir;
              mensaje="Analisis Sintactico correcto,Se acepto 'Salir!'";
        }
        
        return mensaje;
    }
    
    public static int tokk(){
        
    return dato;
    }
    
}
