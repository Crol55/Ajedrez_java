
package ajedrez;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class AFDCalcu {
  public ArrayList<Integer> matrizcalcu= new ArrayList<Integer>(); 
  public  Queue<String> digito = new LinkedList<String>();  
  public  Queue<String> letras = new LinkedList<String>();  
   String texto="";// aca recibimos el texto proveniente del tablero para analisis sintactico
  int codigoAscii=0;
  int estado=1;
  int y=0;
  int contador=1;
  String digitos="";
  String identificadores="";
  String conc="";
  String concatenacion="";
  char caracteres;
   boolean punto=false;// nos indica que solo una vez se podra utilizar el . por cadena de digito 2.3333 o 0.4444
 
  boolean primero=false,segunda=false,union=false;
  public boolean posibilidad=false;
  boolean union2=false; // nos sirve para verificar que se estan concatenando letras
    public void AnalizarCalcu(String cadena){
        texto=cadena;
        estado=0;
       contador=0;
        // texto=cadena.charAt(y);
        for (int i = 0; i <texto.length() ; i++) {
            codigoAscii=texto.codePointAt(i);
            caracteres=texto.charAt(i);
            contador++;  
          //  System.out.println("Codigo "+codigoAscii);
              switch(estado){
                  case 0:{
                  
          
                      if(codigoAscii>=47 && codigoAscii<=57){
                          System.out.println("Digito");
                          digitos=digitos+caracteres;
                          estado=1;
                            if(contador==texto.length()){
                               // System.out.println("El tamano se cumplio");
                                y=33;
                                matrizcalcu.add(y);
                                digito.add(digitos);
                            }
                      }else if(codigoAscii>=97 && codigoAscii<=122){
                          System.out.println("Identificador "+codigoAscii);
                          identificadores=identificadores+caracteres;
                          estado=2;
                             if(contador==texto.length()){
                               // System.out.println("El tamano se cumplio");
                                y=32;
                                matrizcalcu.add(y);
                                letras.add(identificadores);
                            }
                          
                      }else if(codigoAscii==68){//iniciamos Dividir
                        //  System.out.println("D para dividir");
                          estado=3;
                          
                      }else if(codigoAscii==83){// iniciamos Sumar
                        estado=9;
                      
                      }else if(codigoAscii==82){//iniciamos Restar
                        estado=13;
                      }else if(codigoAscii==77){// iniciamos multiplicar
                         estado=18;
                      }else if(codigoAscii==61){
                          System.out.println("acepto =");
                          estado=0;
                            y=22;
                            matrizcalcu.add(y);
                            
                      }else if(codigoAscii==32){
                          System.out.println("Espacio");
                          estado=0;
                          
                      }else if(codigoAscii==43){
                      System.out.println("acepto +");
                      estado=0;
                        y=23;
                        matrizcalcu.add(y);
                      
                      }else if(codigoAscii==59){
                          System.out.println("Acepto ;");
                          estado=0;
                          y=34;
                        matrizcalcu.add(y);
                          
                      }else if(codigoAscii==40){
                          System.out.println("Acepto (");
                          estado=0;
                          y=29;
                        matrizcalcu.add(y);
                          
                      }else if(codigoAscii==41){
                          System.out.println("Acepto )");
                          estado=0;
                          y=30;
                        matrizcalcu.add(y);
                          
                      }else if(codigoAscii==47){
                          System.out.println("Estado /");
                          estado=0;
                          y=26;
                        matrizcalcu.add(y);
                          
                      }else if(codigoAscii==42){
                          System.out.println("Acepto *");
                          estado=0;
                          y=25;
                          matrizcalcu.add(y);
                          
                      }else if(codigoAscii==45){
                          System.out.println("Acepto -");
                          estado=0;
                          y=39;
                        matrizcalcu.add(y);
                          
                      }else if(codigoAscii==44){
                          System.out.println("Acepto ,");
                          estado=0;
                           y=28;
                        matrizcalcu.add(y);
                                  
                          
                      }else if(codigoAscii==46){
                          System.out.println("Acepto .");
                           y=27;
                        matrizcalcu.add(y);
                          
                      }else if(codigoAscii==86){
                             System.out.println("V");
                             estado=29;
                      }else if(codigoAscii==67){
                          System.out.println("C");
                          estado=31;
                      }else {
                          
                          System.out.println("Error Lexico, letra no perteneciente al lenguaje");
                      }
                       
                      
                     
                  
                  }break;
                  
                  case 1:{
                  if(codigoAscii>=48 && codigoAscii<=57){
                      System.out.println("mas digitos");
                        digitos=digitos+caracteres;
                        estado=1;
                        if(contador==texto.length()){
                                System.out.println("Se deberia cumplir la segunda");
                                y=33;
                                matrizcalcu.add(y);
                                digito.add(digitos);
                            }
                  }else if(codigoAscii==61){// acepta =
                     estado=0;
                        y=33;
                        matrizcalcu.add(y); 
                        digito.add(digitos);
                        digitos="";
                        
                  }else if(codigoAscii==32){// espacio
                     estado=0;
                     y=33;
                     matrizcalcu.add(y);
                      digito.add(digitos);
                       digitos="";
                  }else if(codigoAscii==61){// =
                     estado=0;
                        y=33;
                        matrizcalcu.add(y);
                      digito.add(digitos);
                       digitos="";
                       y=22;
                        matrizcalcu.add(y);
                  }else if(codigoAscii==43){//+
                     estado=0;
                     y=33;
                     matrizcalcu.add(y);
                      digito.add(digitos);
                       digitos="";
                      y=23;
                      matrizcalcu.add(y);
                      
                  }else if(codigoAscii==59){//  ;
                      System.out.println(";");
                     estado=0;
                     y=33;
                     matrizcalcu.add(y);
                     
                      y=34;
                     matrizcalcu.add(y);
                      digito.add(digitos);
                       digitos="";
                  }else if(codigoAscii==40){//(
                     estado=0;
                     y=33;
                     matrizcalcu.add(y);
                      digito.add(digitos);
                       digitos="";
                       y=29;
                        matrizcalcu.add(y);
                  }else if(codigoAscii==41){//)
                    estado=0;
                    y=33;
                    matrizcalcu.add(y);
                     digito.add(digitos);
                      digitos="";
                      y=30;
                      matrizcalcu.add(y);
                  }else if(codigoAscii==47){//   /division
                    estado=0;
                    y=33;
                    matrizcalcu.add(y);
                     digito.add(digitos);
                      digitos="";
                      y=26;
                        matrizcalcu.add(y);
                  }else if(codigoAscii==42){// *
                    estado=0;
                    y=33;
                    matrizcalcu.add(y);
                     digito.add(digitos);
                      digitos="";
                      y=25;
                        matrizcalcu.add(y);
                  }else if(codigoAscii==45){// -
                    estado=0;
                    y=33;
                    matrizcalcu.add(y);
                     digito.add(digitos);
                      digitos="";
                      y=24;
                        matrizcalcu.add(y);
                  }else if(codigoAscii==44){//,
                    estado=0;
                    y=33;
                    matrizcalcu.add(y);
                     digito.add(digitos);
                      digitos="";
                      y=28;
                        matrizcalcu.add(y);
                  }else if(codigoAscii==46){// aceta puntos.
                    estado=1;
                     digitos=digitos+caracteres;
                      System.out.println("Acepto puntos");
                     
                  }else{
                      System.out.println("Error Lexico");
                  }
                  
                  }break;
                  case 2:{
                  if(codigoAscii>=97 && codigoAscii<=122){//[a-z]
                    estado=2;
                    identificadores=identificadores+caracteres;
                     if(contador==texto.length()){
                               // System.out.println("El tamano se cumplio");
                                y=32;
                                matrizcalcu.add(y);
                                letras.add(identificadores);
                            }
                    
                  }else if(codigoAscii==61){// acepta =
                     estado=0;
                       y=32;
                    matrizcalcu.add(y);
                     letras.add(identificadores);
                     identificadores="";
                     y=22;
                     matrizcalcu.add(y);
                  }else if(codigoAscii==32){// espacio
                     estado=0;
                      y=32;
                      matrizcalcu.add(y);
                     letras.add(identificadores);
                      identificadores="";
                  }else if(codigoAscii==43){//+
                     estado=0;
                      y=32;
                      matrizcalcu.add(y);
                      letras.add(identificadores);
                       identificadores="";
                      y=23;
                      matrizcalcu.add(y);
                      
                  }else if(codigoAscii==59){//  ;
                      System.out.println("almacena ;");
                     estado=0;
                      y=32;
                      matrizcalcu.add(y);
                     letras.add(identificadores);
                      identificadores="";
                      identificadores="";
                      y=34;
                      matrizcalcu.add(y);
                  }else if(codigoAscii==40){//(
                     estado=0;
                      y=32;
                      matrizcalcu.add(y);
                      letras.add(identificadores);
                       identificadores="";
                      y=29;
                      matrizcalcu.add(y);
                     
                  }else if(codigoAscii==41){//)
                    estado=0;
                     y=32;
                     matrizcalcu.add(y);
                    letras.add(identificadores);
                     identificadores="";
                      y=30;
                      matrizcalcu.add(y);
                  }else if(codigoAscii==47){//   /division
                    estado=0;
                     y=32;
                     matrizcalcu.add(y);
                    letras.add(identificadores);
                     identificadores="";
                      y=26;
                      matrizcalcu.add(y);
                  }else if(codigoAscii==42){// *
                    estado=0;
                     y=32;
                     matrizcalcu.add(y);
                    letras.add(identificadores);
                     identificadores="";
                      y=25;
                      matrizcalcu.add(y);
                  }else if(codigoAscii==45){// -
                    estado=0;
                     y=32;
                     matrizcalcu.add(y);
                    letras.add(identificadores);
                     identificadores="";
                      y=39;
                      matrizcalcu.add(y);
                  }else if(codigoAscii==44){//,
                    estado=0;
                     y=32;
                     matrizcalcu.add(y);
                     letras.add(identificadores);
                      identificadores="";
                      y=28;
                      matrizcalcu.add(y);
                    
                  }else if(codigoAscii==46){// aceta puntos.
                    estado=0;
                      System.out.println("Acepto puntos");
                       y=32;
                       matrizcalcu.add(y);
                       letras.add(identificadores);
                        identificadores="";
                      y=27;
                      matrizcalcu.add(y);
                       
                  }else{
                      System.out.println("Error Lexico");
                  }
                  
                  
                  
                  
                  
                  }break;
                  case 3:{
                    if(codigoAscii==105){
                           // System.out.println("Acepte i");
                            estado=4;
                        }else {
                            System.out.println("Error Lexico donde debia ir i");
                        }
                    
                    }break;
                    case 4:{
                        if(codigoAscii==118){
                       //     System.out.println("Acepte la v");
                            estado=5;
                        }else {
                            System.out.println("Error Lexico donde debia ir v");
                        }
                    
                    
                    }break;
                    case 5:{
                        if(codigoAscii==105){
                           // System.out.println("Acepte la i");
                            estado=6;
                        }else {
                            System.out.println("Error Lexico donde debia ir i");
                        }
                    
                    }break;
                    case 6:{
                    
                    if(codigoAscii==100){
                            //System.out.println("Acepte la d");
                            estado=7;
                        }else {
                            System.out.println("Error Lexico donde debia ir la d");
                        }
                    
                    }break;
                    case 7:{
                    if(codigoAscii==105){
                          //  System.out.println("Acepte la i");
                            estado=8;
                        }else {
                            System.out.println("Error Lexico donde debia ir i ");
                        }
                    
                    }break;
                    case 8:{
                    if(codigoAscii==114){
                            System.out.println("Acepto Dividir");
                          
                            estado=0;
                            y=37;
                            matrizcalcu.add(y);
                        }else {
                            System.out.println("Error Lexico donde debia haber una R");
                        }
                    
                    }break;
                    
                    case 9:{
                        if(codigoAscii==117){
                         //   System.out.println("Acepte la U");
                            estado=10;
                            
                        }else {
                            System.out.println("Error Lexico");
                        }
                        
                    }break;
                    case 10:{
                        if(codigoAscii==109){
                            estado=11;
                          //  System.out.println("Acepte la m");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                    case 11:{
                        if(codigoAscii==97){
                            estado=12;
                           // System.out.println("Acepte la a");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    
                    }break;
                    case 12:{
                        if(codigoAscii==114){
                            estado=28;
                            estado=0;
                            System.out.println("Acepte la Sumar");
                            y=35;
                            
                            matrizcalcu.add(y);
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    
                    }break;
                    
                     case 13:{
                        if(codigoAscii==101){
                            estado=14;
                          //  System.out.println("Acepte la e");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                    case 14:{
                        if(codigoAscii==115){
                            estado=15;
                         //   System.out.println("Acepte la s");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    
                    }break;
                    case 15:{
                        if(codigoAscii==116){
                            estado=16;
                         //   System.out.println("Acepte la t");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    
                    }break;
                    case 16:{
                        if(codigoAscii==97){
                            estado=17;
                          //  System.out.println("Acepte la a");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    
                    }break;
                    case 17:{
                        if(codigoAscii==114){
                           
                            estado=0;
                            System.out.println("Acepto Restar");
                            y=36;
                            matrizcalcu.add(y);
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                   
                    case 18:{
                    if(codigoAscii==117){
                            estado=19;
                           // System.out.println("Acepte la u");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                    case 19:{
                        if(codigoAscii==108){
                            estado=20;
                         //   System.out.println("Acepte la l");
                        }else {
                            System.out.println("Error Lexico");
                        }
                        
                        
                    }break;
                    case 20:{
                    if(codigoAscii==116){
                            estado=21;
                           // System.out.println("Acepte la t");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                    case 21:{
                        if(codigoAscii==105){
                            estado=22;
                           // System.out.println("Acepte la i");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    
                    }break;
                    case 22:{
                        if(codigoAscii==112){
                            estado=23;
                           // System.out.println("Acepte la p");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                    case 23:{
                        if(codigoAscii==108){
                            estado=24;
                         //   System.out.println("Acepte la l");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                    case 24:{
                        if(codigoAscii==105){
                            estado=25;
                         //   System.out.println("Acepte la i");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                    case 25:{
                        if(codigoAscii==99){
                            estado=26;
                           // System.out.println("Acepte la c");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    
                    }break;
                    case 26:{
                        if(codigoAscii==97){
                            estado=27;
                         //   System.out.println("Acepte la a");
                        }else {
                            System.out.println("Error Lexico");
                        }
                    }break;
                    case 27:{if(codigoAscii==114){
                            estado=28;
                            estado=0;
                           System.out.println("Acepte la Multiplicar");
                            y=38;
                            matrizcalcu.add(y);
                        }else {
                            System.out.println("Error Lexico");
                        }}break;
                    case 28:{
                    
                    }break;
                    case 29:{
                       if(codigoAscii==97){// acepto a
                         estado=30;
                       }
                    }break;
                    case 30:{
                        if(codigoAscii==114){// acepto r
                            System.out.println("Aceptamos Var");
                            estado=0;
                              y=20;
                            matrizcalcu.add(y);
                        }else {
                            System.out.println("Error Lexico");
                        }
                    }break;
                    case 31:{
                      if(codigoAscii==111){// acepto o
                         estado=32;
                      }
                    }break;
                    case 32:{
                       if(codigoAscii==110){// acepto n
                           System.out.println("Acepto Con");
                           estado=0;
                             y=21;
                            matrizcalcu.add(y);
                       }else {
                           
                           System.out.println("eror Lexico");
                       
                       }
                    }break;
                
                    
                    
              }// cierre switch
          
        }
     
        
    
    
    }

public static void main(String[] args){
                AFDCalcu a= new AFDCalcu();
                a.AnalizarCalcu("(2.52+3)/2.01 a");
                System.out.println(a.conc);
    }
    
}//conta4++;
//Sumar (Sumar(1,2),Restar(2,3))