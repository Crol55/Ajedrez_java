/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author carlos
 */
public class AFDMovimientos extends Tablero {
    
 public ArrayList<Integer> matrizMM = new ArrayList<Integer>(); 
  public  Queue<String> lista = new LinkedList<String>();
      String cadena[],tex[];
    int tamano;
    int estado=0;
    int codigoAscii=0;
    int contador=0;
    int conta=0,conta2=0, x=0;
    String colordepieza="";// nos sirve para determinar si las piezas blancas estan activas o las negras.
    String union="";
    int conta3=0;
    String concatblanca="";
    int contador4=0;
    char caracter;// nos sirve para conocer el posible caracter de error que aparecion 
    public String auxiliar="";// nos sirve para concatenar las jugadas iniciales
    public String auxiliar2="";// nos sirve para almacenar la segunda jugada
    public void analizar(String texto){
        tamano=0;
        union="";
        concatblanca="";
            for (int i = 0; i < texto.length(); i++) {
                //System.out.println("la longitud es "+texto.length());
              //  if(contador>1){ // ciclo para partir cadenas de jugadas   e 6 x g 8 o a5
               codigoAscii=texto.codePointAt(i);
               caracter=texto.charAt(i);
                    
               // }
              
            switch(estado){
               
                case 0:{ 
                    
                    if(codigoAscii==79){
                       // System.out.println("Acepto O ");
                        estado=2;
                       
                        
                    }else if(codigoAscii==67){
                        estado=2;
                       // System.out.println("Acepto C");
                        estado=6;
                      
                        
                    }else if(codigoAscii==80){
                        estado=12;
                        //System.out.println("Acepto P");
                       
                         
                    }else if(codigoAscii==65){//Alfil
                        estado=15;
                        System.out.println("acepto A");
                       
                    }else if(codigoAscii==68){      // Dama
                       // System.out.println("Acepte D");
                        estado=19;
                        
                    }else if(codigoAscii==82){
                        estado=22;
                         //   System.out.println("Acepto R");
                        
                    }else if(codigoAscii==84){
                        //System.out.println("Acepte T");
                        estado=24;
                       
                        
                    }else if(codigoAscii>=97 && codigoAscii<=104){// aca aceptamos la letra para el movimiento de una pieza
                        estado=1;
                        union=union+texto.charAt(i);
                       //conta3++;
                      //  System.out.println("Letra de movimiento");
                        
                    }else if(codigoAscii==97){ // aca esta abrir
                        estado=28;
                      
                     //   System.out.println("Acepto a ");
                        
                    }else if(codigoAscii==71){// aca empezamos G para Guardar.
                        estado=32;
                       // System.out.println("Se Acepto G");
                       
                    }else if(codigoAscii==83){
                        estado=38;
                         // System.out.println("Acepte S");
                     }else if(codigoAscii==120){
                        
                        estado=2;
                        //System.out.println("se acepto la x");
                        estado=0;
                        x=17;
                        matrizMM.add(x);
                    }else if(codigoAscii==66){
                        estado=42;
                        //System.out.println("Acepte B");
                        concatblanca=concatblanca+"B";
                        //x=18;
                        //matrizMM.add(x);
                    }else if(codigoAscii==78){
                       estado=43;
                        //System.out.println("se ha aceptado directamente negras?>");
                        //x=19;
                       //matrizMM.add(x);
                    }else if(codigoAscii==69){
                        estado=49;
                        // System.out.println("Acepto E");
                    }else if(codigoAscii==32){
                       // System.out.println("espacio");
                    }else if (codigoAscii==45){
                        //System.out.println("acepto -");
                        x=170;
                        matrizMM.add(x);
                    }else {
                       mensajesdepila("Error Lexico, la letra '"+caracter+"' No es parte del lenguaje");
                       estado=70;
                       // debe estar activo una unica vez.
                    }
                }break;
                case 1:{
                   
                if(codigoAscii >= 48 && codigoAscii <= 56){
                    estado=2;
                   union=union+texto.charAt(i);
                  // if(union.length()==2){
                      // System.out.println("me cumplo?");
                      auxiliar=union;
                      lista.add(auxiliar);
                    x=13;
                   matrizMM.add(x);
                   union="";
                   auxiliar="";
                 //  }
                  
                   // System.out.println("EL TAMANO DE LA CEDENA ACTUAL ES "+union.length());
                }else{
                    System.out.println("Error Lexico, se esperaba una letra de [a-h] y se obtuvo "+texto.charAt(i));
                }
                estado=0;
                }break;
                
                case 2:{
               if(codigoAscii==45){
                       // System.out.println("Acepto - ");
                        estado=3;
                     }else{
                   mensajesdepila("Error lexico,se esperaba un - y se obtuvo---> "+caracter);
                   estado=70;// lo enviamos a un estado de error ya que todo lo que le sigue esta erroneo a menos q haya un espacio en blanc
                    // el espacio en blanco nos generaria una nueva cadena a analizar
               }
                   
                }break;
                case 3:{
                  if(codigoAscii==79){
                      //  System.out.println("Acepto O ");
                        estado=4;
                     }else{
                   mensajesdepila("Error lexico,se esperaba un O y se obtuvo---> "+caracter);
                   estado=70;
               }
                  
                }break;
                case 4:{
                  if(codigoAscii==58){
                       // System.out.println("Acepto : ");
                        estado=5;
                    }else{
                   mensajesdepila("Error lexico,se esperaban ' : ' y se obtuvo ------> "+caracter);
                   estado=70;// lo enviamos a un estado de error ya que todo lo que le sigue esta erroneo a menos q haya un espacio en blanc
                    // el espacio en blanco nos generaria una nueva cadena a analizar
               }
                }break;
                case 5:{
                  if(codigoAscii==76){
                       // System.out.println("Acepto O-O:L ");
                        estado=0;
                         x=6;
                        matrizMM.add(x);
                    }else if(codigoAscii==67){
                     // System.out.println("Acepto O-O:C");
                        x=5;
                        matrizMM.add(x);
                      
                    }else{
                   mensajesdepila("Error lexico,no se especifico el tipo de Enroque se esperaba 'L ' 0 ' C ' y se obtuvo----> "+caracter);
                   estado=70;
               }
                  estado=0;
                }break;
                case 6:{
                 if (codigoAscii == 97) {
                        // System.out.println("acepte a");
                        estado = 7;
                 }else{
                   mensajesdepila("Error lexico,Se esperaba la letra a y se obtuvo----> "+caracter);
                   estado=70;
               }
                 
            }break;
                case 7:{
                 if(codigoAscii==98){
                  // System.out.println("acepte b");
                    estado=8;
                  
              }else{
                   mensajesdepila("Error lexico,se esperaba un b y se obtuvo---> "+caracter);
                   estado=70;
               }
                 
                }break;
                case 8: {
                   if(codigoAscii==97){
                    //System.out.println("acepte a");
                    estado=9;
              }else{
                   mensajesdepila("Error lexico,se esperaba un a y se obtuvo---> "+caracter);
                   estado=70;
               }
                }
                break;
                case 9: {
                    if(codigoAscii==108){
                   // System.out.println("acepte l");
                    estado=10;
                    }else{
                   mensajesdepila("Error lexico,se esperaba un l y se obtuvo---> "+caracter);
                   estado=70;
               }
                }
                break;
                case 10: {
                    if(codigoAscii==108){
                 //  System.out.println("acepte l");
                    estado=11;
                    }else{
                   mensajesdepila("Error lexico,se esperaba un l y se obtuvo---> "+caracter);
                   estado=70;
               }
                    
                }
                break;
                case 11: {
                   if(codigoAscii==111){
                        //System.out.println("acepto Caballo");
                        x=7;
                        matrizMM.add(x);
                    estado=0;
                  
              }else{
                   mensajesdepila("Error lexico,se esperaba un o y se obtuvo---> "+caracter);
                   estado=70;
               } 
                    
                }
                break;
                case 12: {
                    if (codigoAscii == 101) {
                      //  System.out.println("acepte e");

                        estado = 13;
                    }else{
                   mensajesdepila("Error lexico,se esperaba un e y se obtuvo---> "+caracter);
                   estado=70;
               }
                    
         }break;
                case 13:{
                if (codigoAscii == 111) {
                      //  System.out.println("acepte o");
                        estado = 14;
                    }else{
                   mensajesdepila("Error lexico,se esperaba un O y se obtuvo---> "+caracter);
                   estado=70;
               }
            }break;
                 case 14:{
                 if (codigoAscii == 110) {
                       //// System.out.println("acepte n");
                      //  System.out.println("Acepte Peon");
                        x=8;
                        matrizMM.add(x);
                        estado = 0;
                    }else{
                   mensajesdepila("Error lexico,se esperaba un n y se obtuvo---> "+caracter);
                   estado=70;
               }
           }break;
                 case 15:{
                 if (codigoAscii == 108) {
                       //  System.out.println("acepte l");
                        estado = 16;

                    }else if(codigoAscii==98){
                        estado=29;
                       // System.out.println("acepte b");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un 'l' y se obtuvo---> "+caracter);
                   estado=70;
               }
                 }break;
                 case 16:{
                 if (codigoAscii == 102) {
                       //  System.out.println("acepte f");
                        estado = 17;
                 }else{
                   mensajesdepila("Error lexico,se esperaba un f y se obtuvo---> "+caracter);
                   estado=70;
               }
          }break;
                 case 17:{
                 if (codigoAscii == 105) {
                        // System.out.println("acepte n");
                        estado = 18;
                      //  System.out.println("acepte i");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un i y se obtuvo---> "+caracter);
                   estado=70;
               }
            }break;
                 case 18:{
                 if (codigoAscii == 108) {
                       
                        estado = 0;
                       // System.out.println("Acepte Alfil");
                         x=9;
                       matrizMM.add(x);
                    }else{
                   mensajesdepila("Error lexico,se esperaba un l y se obtuvo---> "+caracter);
                   estado=70;
               }
            }break;
                 case 19:{
                 if (codigoAscii == 97) {
                    
                        estado = 20;
                      //  System.out.println("acepte a");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un a y se obtuvo---> "+caracter);
                   estado=70;
                   }
             }break;
                 case 20:{
                 if (codigoAscii == 109) {
                      
                        estado = 21;
                        //System.out.println("acepte m");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un m y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 21:{
                 if (codigoAscii == 97) {
                        // System.out.println("acepte a");
                        estado = 0;
                       // System.out.println("acepto Dama");
                        x=10;
                        matrizMM.add(x);
                    }else{
                   mensajesdepila("Error lexico,se esperaba un a y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 
                 }break;
                 case 22:{
                   if (codigoAscii == 101) {
                     
                        estado = 23;
                        //System.out.println("acepte e");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un e y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 23:{
                   if (codigoAscii == 121) {
                       
                        estado = 0;
                        //System.out.println("acepte y");
                        //System.out.println("Acepto Rey");
                        x=11;    
                         matrizMM.add(x);
                    }else{
                   mensajesdepila("Error lexico,se esperaba un y y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 24:{
                  if (codigoAscii == 111) {
                      
                        estado = 25;
                        //System.out.println("acepte 0");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un o y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 25:{
                  if (codigoAscii == 114) {
                       
                        estado = 26;
                        //System.out.println("acepte r");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 26:{
                   if (codigoAscii == 114) {
                        // System.out.println("acepte n");
                        estado = 27;
                        //System.out.println("acepte r");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 27:{
                   if (codigoAscii == 101) {
                        // System.out.println("acepte n");
                        estado = 0;
                        //System.out.println("acepte e");
                        //System.out.println("Acepte Torre");
                         x=12;
                        matrizMM.add(x);
                    }else{
                   mensajesdepila("Error lexico,se esperaba un e y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 28:{
                  if (codigoAscii == 98) {
                       
                        estado = 29;
                        //System.out.println("acepte b");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un b y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 29:{
                  if (codigoAscii == 114) {
                    
                        estado = 30;
                        //System.out.println("acepte r");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 30:{
                  if (codigoAscii == 105) {
               
                        estado = 31;
                        //System.out.println("acepte i");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un i y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 31:{
                  if (codigoAscii == 114) {
                        
                        estado = 0;
                        //System.out.println("acepte r");
                          x=14;
                         matrizMM.add(x);
                         //System.out.println("Acepte Abrir");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 32:{
                  if (codigoAscii == 117) {
                    
                        estado = 33;
                        //System.out.println("acepte u");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un u y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 33:{
                  if (codigoAscii == 97) {
                 
                        estado = 34;
                        //System.out.println("acepte a");
                        
                    }else{
                   mensajesdepila("Error lexico,se esperaba un a y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 34:{
                  if (codigoAscii == 114) {
                   
                        estado = 35;
                        //System.out.println("acepte r");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 35:{
                  if (codigoAscii == 100) {
                       
                        estado = 36;
                        //System.out.println("acepte d");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un d y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 36:{
                  if (codigoAscii == 97) {
            
                        estado = 37;
                        //System.out.println("acepte a");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un a y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 37:{
                  if (codigoAscii == 114) {
                        // System.out.println("acepte n");
                        estado = 0;
                        //System.out.println("acepte r");
                        //System.out.println("Acepte Guardar");
                         x=15;
                         matrizMM.add(x);
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 38:{
                   if (codigoAscii == 97) {
                        // System.out.println("acepte n");
                        estado = 39;
                        //System.out.println("acepte a");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un a y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 39:{
                 if (codigoAscii ==108) {
                        // System.out.println("acepte n");
                        estado = 40;
                       // System.out.println("acepte l");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un l y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 40:{
                   if (codigoAscii == 105) {
                      
                        estado = 41;
                       // System.out.println("acepte i");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un i y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 41:{
                  if (codigoAscii == 114) {
                         estado = 0;
                         x=16;
                        matrizMM.add(x);
                        System.out.println("acepte r");
                        System.out.println("Acepte Salir");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 42:{
                  if (codigoAscii == 108) {
                        // System.out.println("acepte n");
                        estado = 42;
                       // System.out.println("acepte l");
                        concatblanca=concatblanca+"l";
                    }else if(codigoAscii==97){
                      //System.out.println("acepte a");
                      concatblanca=concatblanca+"a";
                    }else if(codigoAscii==110){
                     // System.out.println("acepte n");
                      concatblanca=concatblanca+"n";
                    }else if(codigoAscii==99){
                     // System.out.println("acepte c");
                      concatblanca=concatblanca+"c";
                    }else if(codigoAscii==97){
                     // System.out.println("acepte a");
                      concatblanca=concatblanca+"a";
                    }else if(codigoAscii==115){
                      //System.out.println("acepte s");
                      concatblanca=concatblanca+"s";
                    }else if(codigoAscii==62){
                     // System.out.println("acepte >");
                      concatblanca=concatblanca+">";
                      if(concatblanca.equals("Blancas>")){
                       //System.out.println("Acepte Blancas>");
                        colordepieza="blancas";
                       estado=0;
                      }else{
                        //  System.out.println("Blancas> esta mla escrito");
                      }
                      
                    }
                 }break;
                 case 43:{
                 if (codigoAscii == 101) {
                        // System.out.println("acepte n");
                        estado = 44;
                       // System.out.println("acepte e");
                    }
                 }break;
                 case 44:{
                 if (codigoAscii == 103) {
                        // System.out.println("acepte n");
                        estado = 45;
                        //System.out.println("acepte g");
                    }
                 }break;
                 case 45:{
                 if (codigoAscii == 114) {
                        // System.out.println("acepte n");
                        estado = 46;
                       // System.out.println("acepte r");
                    }
                 }break;
                 case 46:{
                 if (codigoAscii == 97) {
                        // System.out.println("acepte n");
                        estado = 47;
                       // System.out.println("acepte a");
                    }
                 }break;
                 case 47:{
                 if (codigoAscii == 115) {
                        // System.out.println("acepte n");
                        estado = 48;
                       // System.out.println("s");
                    }
                 }break;
                 case 48:{
                 if (codigoAscii == 62) {
                        colordepieza="negras";
                        estado = 0;
                      //  System.out.println("Acepto Negras>");
                    }
                 }break;
                 case 49:{
                  if (codigoAscii == 120) {
                        // System.out.println("acepte n");
                        estado = 50;
                       // System.out.println("acepte x");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un x y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 50:{
                  if (codigoAscii == 112) {
                        // System.out.println("acepte n");
                        estado = 51;
                        //System.out.println("acepte p");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un p y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 51:{
                  if (codigoAscii ==111) {
                        // System.out.println("acepte n");
                        estado = 52;
                       // System.out.println("acepte o");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un o y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 52:{
                  if (codigoAscii == 114) {
                        // System.out.println("acepte n");
                        estado = 53;
                       // System.out.println("acepte r");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 53:{
                  if (codigoAscii == 116) {
                        // System.out.println("acepte n");
                        estado = 54;
                       // System.out.println("acepte t");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un t y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 54:{
                  if (codigoAscii == 97) {
                        // System.out.println("acepte n");
                        estado = 55;
                       // System.out.println("acepte a");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un a y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 case 55:{
                  if (codigoAscii == 114) {
                        // System.out.println("acepte n");
                        estado = 0;
                          x=70;
                         matrizMM.add(x);
                       // System.out.println("acepte r");
                        System.out.println("Acepto Exportar");
                    }else{
                   mensajesdepila("Error lexico,se esperaba un r y se obtuvo---> "+caracter);
                   estado=70;
                   }
                 }break;
                 
                 case 70:{// aca ingresan todas las cadenas erronas siguientes
                   if(codigoAscii==32){// se generararia una nueva linea
                      // System.out.println("Hubo espacio en Blanco?");
                     estado=0;
                   }else{
                     //  System.out.println("ingresa como erronea");
                   }
                 }break;
            }// cierra de switch
            
          
              conta2++;  
            }
            conta++;
            estado=0;
       // }
            
         
            
        }
    public String ColorDePiezaActual(){
    return colordepieza;
    }
        public static void main(String[] args){
                AFDMovimientos a= new AFDMovimientos();
                a.analizar("torre ");
                
               // System.out.println(""+a.analizar("e6"));
    }
    
}