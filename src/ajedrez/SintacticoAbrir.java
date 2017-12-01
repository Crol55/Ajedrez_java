
package ajedrez;
import java.util.LinkedList;
import java.util.Queue;
public class SintacticoAbrir extends Tablero {
  public static Queue<Integer> pila = new LinkedList<Integer>(); 
 
static int tokens=0;// variable en donde se almacenaran los tokens que vayamos sacando
public static int secuencia=0;
public static int secuencia2=0;
public static int secuencia3=0;
public static boolean principio=true;
public static boolean intermedio=true;
public static boolean fin=true;
public static boolean ultimo=true;
public static boolean puedecontinuar=false;
public static boolean continua=true; // para verificar si debe seguir con el analisis sintacitico si es true debe seguir
    public void abrir(){
        principio=true;
        intermedio=true;
        fin=true;
        puedecontinuar=false;
        continua=true;
        secuencia=0;
        secuencia2=0;
        secuencia3=0;
        
        tokens=pila.poll();  // extraemos el primer token
        //mensajesdepila("extrayendo de la pila "+tokens);
     if(tokens==90){ //REFERENTE A JUGADORES
// aceptamos jugadores
         tokens=pila.poll();//extraemos los : y lo enviamos a jugadores()
          //mensajesdepila("extrayendo token "+tokens);
         
         JUGADORES(tokens);
         //mensajesdepila("ACA SALGO DE JUGADORES Y PRETENDO ENTRAR A TABLERO");
           if(continua==true){
            //   mensajesdepila("INGRESO A TABLERO");
              TABLERO(tokens=pila.poll());
              continua=false;
              
           }
        
         
         
     }else{
     mensajesdepila("error sintatctico se esperaba token 90 y se obtuvo "+tokens);
     } 
    }
    
    public static void JUGADORES(int token){
       if(token==91){// aceptamos :
           secuencia=1;
      while(principio==true){
           switch(secuencia){
               case 1:{
                 tokens=pila.poll();// extraemos { 
                 if(tokens==92){// aceptamos {
                    secuencia=2;
                     //  mensajesdepila("acepto { y token es "+tokens);
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
               case 2:{
                tokens=pila.poll();// extraemos Blancas
                  if(tokens==94){
                     secuencia=3;
                      //   mensajesdepila("acepto blancas y token es "+tokens);
                  }else{
                      principio=false;
                      continua=false;
                      System.out.println("Error sintactico se esperaba blancas");
                      
                  }
               }break;
               case 3:{
                tokens=pila.poll();// extraemos : 
                 if(tokens==91){// aceptamos :
                    secuencia=4;
                       //mensajesdepila("acepto : y token es "+tokens);
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
               case 4:{
                tokens=pila.poll();// extraemos 200 
                 if(tokens==200){// aceptamos Nommbre_delJugador
                    secuencia=5;
                     //  mensajesdepila("acepto nombre_jugador y token es "+tokens);
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
               case 5:{
                tokens=pila.poll();// extraemos ,
                 if(tokens==201){// aceptamos ,
                    secuencia=6;
                     //  mensajesdepila("acepto , y token es "+tokens);
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
               case 6:{
                tokens=pila.poll();// extraemos negras
                 if(tokens==95){// aceptamos Negras
                    secuencia=7;
                   //    mensajesdepila("acepto negras y token es "+tokens);
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
               case 7:{
                tokens=pila.poll();// extraemos :
                 if(tokens==91){// aceptamos :
                    secuencia=8;
                     //  mensajesdepila("acepto : y token es "+tokens);
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
               case 8:{
                tokens=pila.poll();// extraemos 200 
                 if(tokens==200){// aceptamos nombre_jugador
                    secuencia=9;
                   //    mensajesdepila("acepto nombre_jugador y token es "+tokens);
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
               case 9:{
                tokens=pila.poll();// extraemos }
                 if(tokens==93){// aceptamos }
                    secuencia=10;
                    //   mensajesdepila("acepto } y token es "+tokens);
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
               case 10:{
                tokens=pila.poll();// extraemos , 
                 if(tokens==201){// aceptamos ,
                    secuencia=0;
                      // mensajesdepila("acepto , y token es "+tokens);
                    principio=false;
                 }else {
                     principio=false;
                     continua=false;
                     System.out.println("Error Sintactico se esperaba token=92 y se obtuvo "+tokens);
                 }
               }break;
              
              
           }
          }// cierre while principio
           
           
          
          
           
       }else{
           continua=false;
           System.out.println("error sintactico se esperaba :");
       }
    }

    public static void TABLERO(int tok){
         mensajesdepila("entrando a tablero");
         //mensajesdepila("Extrayendo token "+tokens);
           if(tokens==96){
               secuencia2=1;
           
              while(intermedio==true){
                 switch(secuencia2){
                     case 1:{
                     tokens=pila.poll();
                     // mensajesdepila("Extrayendo token "+tokens);
                       if(tokens==91){// acepto :
                         secuencia2=2;
                       }else{
                           intermedio=false;
                         mensajesdepila("Error sintactico, se esperaba : y se obtuvo "+tokens);
                       }
                     }break;
                     case 2:{
                     tokens=pila.poll();
                       if(tokens==92){// {
                           // mensajesdepila("Extrayendo token "+tokens);
                         secuencia2=3;
                       }else{
                           intermedio=false;
                         mensajesdepila("Error sintactico, se esperaba { ");
                       }
                     }break;
                     case 3:{
                     tokens=pila.poll();
                    //  mensajesdepila("Extrayendo token "+tokens);
                       if(tokens==200){//nombre_jugador
                         secuencia2=4;
                       }else{
                           intermedio=false;
                         mensajesdepila("Error sintactico se esperaba nombre_jugador ");
                       }
                     }break;
                     case 4:{
                     tokens=pila.poll();
                     // mensajesdepila("Extrayendo token "+tokens);
                       if(tokens==91){//  aceptamos :
                         secuencia2=5;
                       }else{
                           intermedio=false;
                         mensajesdepila("Error sintactico, se esperaba  : ");
                       }
                     }break;
                     case 5:{
                     tokens=pila.poll();
                     // mensajesdepila("Extrayendo token "+tokens);
                       if(tokens==92){// aceptamos {
                         secuencia2=6;
                       }else{
                           intermedio=false;
                         mensajesdepila("Error sintactico, se esperaba {");
                       }
                     }break;
                   
                     case 6:{
                        // mensajesdepila("pretendo entrar a POSICIONES");
                         POSICIONES();
                       //  mensajesdepila("Salgo de posiciones ");
                     secuencia2=7;
                     }break;
                     
                     case 7:{
                      tokens=pila.poll();
                     
                      mensajesdepila("Extrayendo token "+tokens);
                       if(tokens==200){// aceptamos nombre_jugador
                         secuencia2=8;
                       }else{
                           intermedio=false;
                         mensajesdepila("Error sintactico, se esperaba nombre_jugador");
                       }
                     }break;
                     
                     case 8:{
                     tokens=pila.poll();
                       if(tokens==91){// aceptamos :
                       //  mensajesdepila("Extrayendo token "+tokens);
                         secuencia2=9;
                       }else {
                       intermedio=false;
                       mensajesdepila("Error sintactico, se esperaba :");
                       }
                     }break;
                
                     case 9:{
                      tokens=pila.poll();
                       if(tokens==92){// aceptamos :
                        // mensajesdepila("Extrayendo token "+tokens);
                         secuencia2=10;
                       }else {
                       intermedio=false;
                       mensajesdepila("Error sintactico, se esperaba :");
                       }
                     }break;
                     case 10:{
                     POSICIONES();
                     mensajesdepila("SEGUNDO ANALISIS TERMINADO");
                      secuencia2=11;
                     }break;
                     case 11:{
                     tokens=pila.poll();
                     // mensajesdepila("Extrayendo token "+tokens);
                     if(tokens==93){// acepto }
                       secuencia2=12;
                     }else {
                      mensajesdepila("Error sintactico, se esperaba  }");
                     }
                     }break;
                     
                     case 12:{
                      tokens=pila.poll();
                    //  mensajesdepila("Extrayendo token "+tokens);
                     if(tokens==201){// acepto ,
                       secuencia2=13;
                     }else {
                      mensajesdepila("Error sintactico, se esperaba  ,");
                     }
                     }break;
                     case 13:{
                     mensajesdepila("llego al punto donde debo utilizar la funcion MOVIMIENTOS");
                     tokens=pila.poll();
                     // mensajesdepila("Extrayendo token "+tokens);
                     if(tokens==102){
                         secuencia2=14;
                         System.out.println("Acepto movimientos");
                     }else{
                      mensajesdepila("Error sintactico, se esperaba  frase movimientos");
                     }
                   }break;
                     case 14:{
                     tokens=pila.poll();
                     // mensajesdepila("Extrayendo token "+tokens);
                     if(tokens==91){
                         secuencia2=15;
                         System.out.println("Acepto :");
                     }else{
                      mensajesdepila("Error sintactico, se esperaba :");
                     }
                     }break;
                     case 15:{
                     tokens=pila.poll();
                      //mensajesdepila("Extrayendo token "+tokens);
                     if(tokens==92){
                         secuencia2=16;
                         System.out.println("Acepto {");
                     }else{
                      mensajesdepila("Error sintactico, se esperaba {");
                     }
                     }break;
                     case 16:{
                      MOVIMIENTOS();
                      mensajesdepila("salgo de MOVIMIENTOS");
                      secuencia2=17;
                       if(pila.isEmpty()==true){
                         mensajesdepila("ANALISIS SINTATACTICIO COMPLETO");
                       }
                     }break;
                     
            
                   
                   
                 
                 }
              
              }//fin de ciclo while intermedio
           
           
           
           }else{
               System.out.println("Error Sintactico se esperaba tablero tok=96 y se obtuvo "+tokens);
           }
        
        
        
        
    }
    public static boolean PIEZAS(int tok){
        boolean f=false;
        if((tok==5)||(tok==6)||(tok==7)||(tok==8)||(tok==9)||(tok==10)){
          // mensajesdepila("Acepto pieza con token "+tok);
           f=true;
        }else{
        f=false;
            mensajesdepila("Se esperaba una pieza, error sintactico");
        }
    return f;
    }
      
   
    public static void POSICIONES(){
      int secuencias=1;
      int tok=0;
      fin=true;
        while(fin==true){
         
           switch(secuencias){
               case 1:{
                tok=pila.poll();
              //  mensajesdepila("extrayendo token "+tok);
                   if(tok==99){
                       System.out.println("Aceptamos pieza");
                       secuencias=2;
                   }else{
                   mensajesdepila("error sintactico, se esperaba pieza linea 310");
                   }
               }break;
               case 2:{
                 tok=pila.poll();
                //// mensajesdepila("extrayendo token "+tok);
                   if(tok==91){
                       System.out.println("Aceptamos :");
                       secuencias=3;
                   }else{
                   mensajesdepila("error sintactico, se esperaba :");
                   }
               }break;
               case 3:{
               tok=pila.poll();
             
              // mensajesdepila("extrayendo token "+tok);
                   if(tok==92){
                       System.out.println("Aceptamos {");
                       secuencias=4;
                   }else{
                   mensajesdepila("error sintactico, se esperaba {");
                   }
               }break;
               case 4:{
               tok=pila.poll();
              // mensajesdepila("extrayendo token case 4 "+tok);
                   if(tok==97){
                       System.out.println("Aceptamos frase nombre");
                       secuencias=5;
                   }else{
                   mensajesdepila("error sintactico, se esperaba frase nombre");
                   }
               }break;
               case 5:{
                  tok=pila.poll();
              // mensajesdepila("extrayendo token  "+tok);
                   if(tok==91){
                       System.out.println("Aceptamos :");
                       secuencias=6;
                   }else{
                   mensajesdepila("error sintactico, se esperaba :");
                   }
               }break;
               case 6:{
                 tok=pila.poll();
              // mensajesdepila("extrayendo token  "+tok);
               boolean x=PIEZAS(tok);
                   if(x==true){
                       System.out.println("Aceptamos frase nombre");
                       secuencias=7;
                   }else{
                   mensajesdepila("error sintactico, se esperaba frase nombre");
                   }
               }break;
               case 7:{
                  tok=pila.poll();
             //  mensajesdepila("extrayendo token  "+tok);
                   if(tok==201){
                       System.out.println("Aceptamos ,");
                       secuencias=8;
                   }else{
                   mensajesdepila("error sintactico, se esperaba ,");
                   }
               }break;
               case 8:{
                  tok=pila.poll();
                 // mensajesdepila("extrayendo token  "+tok);
                   if(tok==98){
                       System.out.println("Aceptamos frase posicion");
                       secuencias=9;
                   }else{
                   mensajesdepila("error sintactico, se esperaba frase posicion");
                   }
                   
               }break;
               case 9:{
                    tok=pila.poll();
              // mensajesdepila("extrayendo token  "+tok);
                   if(tok==91){
                       System.out.println("Aceptamos :");
                       secuencias=10;
                   }else{
                   mensajesdepila("error sintactico, :");
                   }
               }break;
               case 10:{
                
                    tok=pila.poll();
             //  mensajesdepila("extrayendo token  "+tok);
                   if(tok==15){
                       System.out.println("Aceptamos jugadas [a7]");
                       secuencias=11;
                   }else{
                   mensajesdepila("error sintactico, se esperaba jugada");
                   }
               }break;
               case 11:{
                  tok=pila.poll();
              // mensajesdepila("extrayendo token  "+tok);
                   if(tok==93){
                       System.out.println("Aceptamos }");
                       secuencias=12;
                   }else{
                   mensajesdepila("error sintactico, se esperaba }");
                   }
               }break;
               case 12:{
                  tok=pila.poll();
                 // mensajesdepila("extrayendo donde debe aparecer 201 o 93 y sale "+tok);
                  
                  if(tok==201){
                     //mensajesdepila("debo enciclarme ");
                     secuencias=1;
                  }else if(tok==93){
                  mensajesdepila("termina el analisis ");
                  fin=false;
                  }
               }break;
           }
        }
      
    }
    public static void MOVIMIENTOS(){
        int cambio=1;
        int toke=0;
        ultimo=true;
        while(ultimo==true){
        
            switch(cambio){
            case 1:{
             toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==104){
                cambio=2;
             }else {
             mensajesdepila("Error Sintactico, se esperaba turno");
             }
             
            }break;
            case 2:{
            toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==91){// acepto :
                cambio=3;
             }else {
             mensajesdepila("Error Sintactico, se esperaba :");
             }
            }break;
            case 3:{
            toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==92){// acepto {
                cambio=4;
             }else {
             mensajesdepila("Error Sintactico, {");
             }
            }break;
            case 4:{
            toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==107){// acepto digito
                cambio=5;
             }else {
             mensajesdepila("Error Sintactico, digito");
             }
            
            }break;
            case 5:{
            toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==201){/// acepto ,
                cambio=6;
             }else {
             mensajesdepila("Error Sintactico, se esperaba ,");
             }
            }break;
            case 6:{
            toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==200){// acepto nombre_jugador
                cambio=7;
             }else {
             mensajesdepila("Error Sintactico, se esperaba nombre_jugador");
             }
            
            }break;
            case 7:{
             toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==91){// acepto :
                cambio=8;
             }else {
             mensajesdepila("Error Sintactico, :");
             }
            }break;
            case 8:{
                mensajesdepila("INGRESANDO A ESPECIALES");
                ESPECIALES();
                mensajesdepila("Saliendo de especiales");
                cambio=11;
            }break;
           
            case 11:{
             toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==201){// acepto ,
                cambio=12;
             }else {
             mensajesdepila("Error Sintactico, se esperaba  ,");
             }
            }break;
            case 12:{
             toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==200){// acepto nombre_jugador
                cambio=13;
             }else {
             mensajesdepila("Error Sintactico, se esperaba nombre_jugador");
             }
            }break;
            case 13:{
             toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==91){// acepto :
                cambio=14;
             }else {
             mensajesdepila("Error Sintactico, se esperaba :");
             }
            }break;
            case 14:{
              mensajesdepila("ingresando denuevo a especiales");
              ESPECIALES();
              mensajesdepila("Saliendo de especiales");
              cambio=17;
            }break;
           
           
            case 17:{
             toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==93){// acepto }
                cambio=18;
             }else {
             mensajesdepila("Error Sintactico, se esperaba }");
             }
                
            }break;
            case 18:{
             toke=pila.poll();
             mensajesdepila("Extrayendo token "+toke);
             if(toke==201){// acepto ,
                cambio=1;
             }else if(toke==93){// acepto }
              
               ultimo=false;
             }else {
             mensajesdepila("Error Sintactico, se esperaba , ");
             }
            }break;
            
            
            }
           
            
            
        }
        
        
    }
    
 public static void ESPECIALES(){
     boolean especial=true; 
     int cima=0;
     int tokeen=0;
     int siguiente=0;
     while(especial==true){
         switch(siguiente){
        case 0:{
            tokeen=pila.poll();
            mensajesdepila("extrayendo token en especial "+tokeen);
          if((tokeen==5)||(tokeen==6)||(tokeen==7)||(tokeen==8)||(tokeen==9)||(tokeen==10)){
            
                 tokeen=pila.poll();// extraemos x o -  
                   mensajesdepila("extrayendo token en especial "+tokeen);
                  if(tokeen==12){// aceptamos -
                       tokeen=pila.poll();
                         mensajesdepila("extrayendo token en especial "+tokeen);
                         if(tokeen==15){
                             cima=pila.peek();
                               if(cima==201 || cima==93){
                               mensajesdepila("SE ACEPTO PEON-A4");
                                 especial=false;
                               }else{
                                 tokeen=pila.poll();
                                  mensajesdepila("extrayendo token en especial "+tokeen);
                                   if(tokeen==15){
                                    mensajesdepila("Se acepto algo como Alfil-a5b7");
                                      especial=false;
                                   }else if(tokeen==20){// se aceptaria una jugada adicional
                                       tokeen=pila.poll();
                                        mensajesdepila("extrayendo token en especial "+tokeen);
                                       if(tokeen==15){
                                          mensajesdepila("se acepto algo como Torre-a5xb7");
                                            especial=false;
                                       }
                                   }else{mensajesdepila("error sintactico carajio");}
                               }
                           
                         }else{
                             System.out.println("error sintactico ");
                         }
                  }else if(tokeen==20){
                      tokeen=pila.poll();
                        if(tokeen==15){
                          mensajesdepila("Aceptamos algo como peonxa7");
                            especial=false;
                        }
                  }else{
                  mensajesdepila("ERROR SINTACTICO de aqui obteniendo el token "+tokeen);
                  }
          }else if ((tokeen==101)||(tokeen==11)){
           mensajesdepila("ACEPTAMOS  ENROQUES");
           especial=false;
          }
        }break;
        
         case 1:{}break;
         case 2:{}break;
         case 3:{}break;
         case 4:{}break;
         case 5:{}break;
         case 6:{}break;
         case 7:{}break;
         case 8:{}break;
         case 9:{}break;
         
         
         }
      
         
         
         
      }
 }
    
}
