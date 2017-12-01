
package ajedrez;

import java.util.LinkedList;
import java.util.Queue;
public class SintacticoMovimientos extends Tablero {
   public static int token=0;
    
   public static Queue<Integer> pilaparse = new LinkedList<Integer>(); 
   //public static Queue<Integer> pilaaux = new LinkedList<Integer>(); 
   public static int tokenguion=12;// se espera el token de  "-"
   public static   int tokenposicion=15;// se esperaria token de jugada como a1 b2 c3 etc.
   public static int tokenx=20;
          static int tokenauxiliar=0;
          static int tokensalir=35;
          static int tokenguardar=30;
          static int tokenabrir=25;
          static int tokenexportar=1;
           public static boolean guardaractivo=false; 
   static boolean x=false;
   public static boolean er=false;// le servira a metodos externos para conocer si existio o no un error
   
   
    public  void parse(){// eso es lo mismo q metodo parea
        guardaractivo=false;
        er=false;
        x=false;
        //while(!pilaparse.isEmpty()){
            // System.out.println("el tamano de la pila inicial es de "+pilaparse.size());
            token=pilaparse.poll();// aca extraemos lo primero en la pila q usualmente sera enroque o pieza
            mensajesdepila("Extrayendo de la pila el token "+token);
           
        //   System.out.println("el tamano de la pila tras extraer un token es "+pilaparse.size());
        
   if((token==5)||(token==6)||(token==7)||(token==8)||(token==9)||(token==10)){//ENTRA A MOVER O COMER
        if(pilaparse.isEmpty()==true){
            er=true;
            mensajesdepila("Error Sintactico, se esperaba 'x' o '-' y se obtuvo null");
           
           
            pilaparse.clear();
        }else{
          token=pilaparse.poll();
          mensajesdepila("Extrayendo de la pila el token "+token);
             MoverComer(token);
        }   
           
         }else if((token==11)||(token==101)){// ENTRA A ENROCAR
              mensajesdepila("Extrayendo de la pila el token "+token);
             enrocar(token);
         }else if(token==tokenguardar){
             guardaractivo=true;
                mensajesdepila("Analisis Sintactico Correcto se acepto comando Guardar");
         }else if(token==tokenabrir){
               mensajesdepila("Analisis Sintactico Correcto se acepto comando Abrir");
         }else{
              mensajesdepila("Error Sintactico Se esperaba una 'pieza ' o un 'Enroque'");
              er=true;
              pilaparse.clear();
         }
     //  }
       
    //return true;
    }
  
    
    public static void MoverComer(int tokenesperado){
        tokenauxiliar=token;
        if(tokenesperado==20){// x nos lleva a comer una pieza
            if(pilaparse.isEmpty()==true){
                 mensajesdepila("Error Sintactico, se esperaba una posicion y se obtuvo null");
                  er=true;
                pilaparse.clear();
            }else{
             token=pilaparse.poll();
              mensajesdepila("Extrayendo de la pila el token "+token);
             
             Comer(token);
            
            }
        }else if(tokenesperado==12){// nos puede llevar a mover una pieza o a comer una pieza
           // System.out.println("ingrese aqui con el guion");
         if(pilaparse.isEmpty()==true){
             mensajesdepila("Error Sintactico, se esperaba una posicion y se obtuvo null");
              er=true;
             pilaparse.clear();
         }else{
            Mover(token);
         }
        }else{
            mensajesdepila("Error Sintactico,luego de pieza se espera 'x' o ' - '");
             er=true;
            pilaparse.clear();
        }
        
    
    }
    
    
    public static void Comer(int tokesperado){
     //   System.out.println("EL VALOR DE X ES  "+x);
       if((tokesperado==tokenposicion)&&(pilaparse.isEmpty()==true)&&(x==false)){
           mensajesdepila("Analisis Sintactico completo, Desea Comer una pieza");
          // System.out.println("Analisis Sintactico completo, Desea Comer una pieza  ");
           
       }else if((tokesperado==tokenposicion)&&(x==true)&&(pilaparse.isEmpty()==true)){
           mensajesdepila("Analisis Sintactico completo, Desea Comer de una posicion a otra");
          // System.out.println("Analisis Sintactico completo, Desea Comer de una posicion a otra ");
           
       }else if((tokesperado==15)&&(pilaparse.isEmpty()==false)) {
           mensajesdepila("Error Sintactico se encontro un caracter luego de Pieza-posxpos");
            er=true;
            pilaparse.clear();
         // System.out.println("Error Sintactico se encontro un caracter luego de Pieza-posxpos ");
       }
    }
    public static void Mover(int tokenesperado){
    
        if(tokenesperado==tokenguion){ // se espera token guion que es = 12
            //System.out.println("si ingreso en la condicio MOVER DEL GUION");
           token=pilaparse.poll();// extraemos el token de posicion
           mensajesdepila("Extrayendo de la pila el token "+token);
           // System.out.println("cuando extraigo la posicion puede q venga una x entonc el estado es "+pilaparse.isEmpty());
             if((token==tokenposicion)&&(pilaparse.isEmpty()==true)){
                 mensajesdepila("Analisis Sintactico completo, Se quiere mover una pieza p-ae");
              //System.out.println("Analisis Sintactico completo, Se quiere mover una pieza p-ae");
              
             }else if((token==tokenposicion)&&(pilaparse.isEmpty()==false)){
               token=pilaparse.poll();
                 mensajesdepila("Extrayendo de la pila el token "+token);
                if((token==tokenposicion)&&(pilaparse.isEmpty()==true)){
                     mensajesdepila("Analisis Sintactico completo, Se quiere mover una pieza de una posicion a otra.");
               // System.out.println("Analisis Sintactico completo, Se quiere mover una pieza de una posicion a otra.");
                
                
             }else{
                  //token=pilaparse.poll();
                     if((token==tokenx)&&(pilaparse.isEmpty()==false)){
                        token=pilaparse.poll();
                        mensajesdepila("Extrayendo de la pila el token "+token);
                          x=true;
                          Comer(token);
                     }else{
                        mensajesdepila("Error sintactico, luego de la X se esperaba una 'Posicion'");
                         er=true;
                      //  System.out.println("Error sintactico, luego de la X se esperaba una 'Posicion'");
                       pilaparse.clear();
                     }
                }
             }else{
                  mensajesdepila("Error sintactico se esperaba una x o una posicion");
                   er=true;
                  pilaparse.clear();
                // System.out.println("Error sintactico se esperaba una x o una posicion");
             }
        }// colocar aqui error lexico
        
    }
    
    public static void enrocar(int tokenespera){
       // System.out.println("estara vacia? "+pilaparse.isEmpty());
        if((tokenespera==101)&&(pilaparse.isEmpty()==true)){// acepta enroque corto.
              mensajesdepila("Analisis Sintactico, se Acepto el movimiento 0-O:C");
            // System.out.println("Analisis Sintactico, se Acepto el movimiento 0-O:C");
           
        }else if((tokenespera==11)&&(pilaparse.isEmpty()==true))  {
              mensajesdepila("Analisis Sintactico, se Acepto el movimiento 0-O:L");
         //System.out.println("Analisis Sintactico, se Acepto el movimiento 0-O:L");
         
        }else if((tokenespera==11 && pilaparse.isEmpty()==false)||(tokenespera==11 && pilaparse.isEmpty()==false)){
              mensajesdepila("Error sintactico se encontro un simbolo agregado a un movimiento de enrocar");
               er=true;
           // System.out.println("Error sintactico se encontro un simbolo agregado a un movimiento de enrocar");
            pilaparse.clear();
            
        }
    }
    
    public static boolean huboerror(){
        System.out.println("si ejecuto el metodo aqui sale "+er);
        return er;
    }
    
    public static boolean SeActivoGuardar(){
    return guardaractivo;
    }
    
}
