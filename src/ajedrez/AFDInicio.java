
package ajedrez;

import java.util.ArrayList;


public class AFDInicio {
   public int estado=0;
   String cadenafinal[];
   int x=0;// equivale al valor del token que tendra cada frase en el programa
   int codigoAscii=0;
   int cont=0;
    public ArrayList<Integer> matrizinicio= new ArrayList<Integer>(); 
   public void analizarInicio(String cadena){
        estado=0;
     // String texto=cadena.replaceAll("\\s","");
    //  cadenafinal=texto.split("");
    cadenafinal=cadena.split(" ");
      
        for(int i=0;i<cadenafinal.length;i++){
          
             switch(estado){
             
                 case 0:{
                   if(cadenafinal[i].equals("PlayChess!")){
                      estado=1;
                      x=1;
                      matrizinicio.add(x);
                       System.out.println("Se acepto jugar ");
                   }else if(cadenafinal[i].equals("CalcChess!")){
                      estado=1;
                      x=2;
                      matrizinicio.add(x);
                       System.out.println("Se acepto calculadora");
                     
                   }else if(cadenafinal[i].equals("Importar")){
                       System.out.println("Se acepto importar");
                      estado=2;
                      x=3;
                      matrizinicio.add(x);
                   }else if(cadenafinal[i].equals("Salir")){
                       System.out.println("Acepto Salir");
                      estado=1;
                      x=4;
                      matrizinicio.add(x);
                   }else{
                       System.out.println("Esa cadena esta erronea inicio");
                       Tablero t= new Tablero();
                       x=5;
                       matrizinicio.add(x);
                   }
                     
                 }
                 case 2:{
                //codigoAscii=cadenafinal[1].codePointAt(cont);
                 
                // if(){
                 
                 //}
                 }break;
             }
            
            if(estado==1){
                System.out.println("La cadena fue aceptada Correctamente");
            } else{System.out.println("La cadena esta erronea");
              
            }
            estado=0;
        
        }
       
    }
         public static void main(String[] args) {
        AFDInicio a= new AFDInicio();
          a.analizarInicio("Importar");
    }
}
