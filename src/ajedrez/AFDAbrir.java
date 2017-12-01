
package ajedrez;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class AFDAbrir {
    
  
    int codigoAscii=0;
    char cadenafila[];
    String textos[];
    String texto;
    int estado=0;
    char caracter;
    int x=0;// hace referencia a los tokens
    String digitos="";// concatenamos todos los digitos q aparezan referidos a turno _1 etc
    String union="";// para unir jugadas como [a-h][0-9]
    String nombre="";
     public Queue<String> jugadas = new LinkedList<String>();
     public ArrayList<Integer> matrizabrir= new ArrayList<Integer>(); 
     public Queue<String> nombre_jugador = new LinkedList<String>(); 
     public Queue<String> numeros = new LinkedList<String>(); 
    public void AnalizarAbrir(String cadena){
 
        texto=cadena;
        //System.out.println("LA LONGITUD ES   "+texto.length());
       
      
      
      
      
        for (int i = 0; i < texto.length(); i++) {
           codigoAscii=texto.codePointAt(i);
           caracter=texto.charAt(i);
            //System.out.println(""+codigoAscii);
            switch(estado){
                
                case 0:{// se acepta el caracter inicial que nos lleva a los demas estados o cases.
                 if(codigoAscii==106){
                 //System.out.println("Acepto j");
                 estado=1;
                  }else if(codigoAscii==32){
                // System.out.println("hubo espacio nada mas");
                 }else if(codigoAscii==10){
               // System.out.println("Hubo saltos de linea");
                }else if(codigoAscii==110){
                     System.out.println("Acepte n refrente a nombre");
                estado=9;
                 }else if(codigoAscii==66){
                    // System.out.println("Acepto B");
                     estado=14;
                       nombre=""+caracter;
                 }else if(codigoAscii==78){
                    // System.out.println("Acepto N");
                     estado=20;
                       nombre=""+caracter;
                     
                 }else if(codigoAscii==44){
                     System.out.println("Acepto ,");
                      x=48;
                      matrizabrir.add(x);
                     
                 }else if(codigoAscii==123){
                     System.out.println("Acepto {");
                      x=44;
                      matrizabrir.add(x);  
                     
                 }else if(codigoAscii==125){
                     System.out.println("Acepto }");
                      x=45;
                      matrizabrir.add(x);
                     
                 }else if(codigoAscii==58){
                     System.out.println("Acepto :");
                      x=43;
                      matrizabrir.add(x);
                     
                 }else if(codigoAscii==45){
                     System.out.println("Acepto -");
                      x=63;
                      matrizabrir.add(x);
                     
                 }else if(codigoAscii==120){
                     System.out.println("Acepto x");
                     x=61;
                      matrizabrir.add(x);
                     
                 }else if(codigoAscii==116){
                    // System.out.println("Acepto t");
                     estado=25;
                 }else if(codigoAscii==112){
                    // System.out.println("Acepto p");
                     estado=31;
                 }else if(codigoAscii>=97 && codigoAscii<=104){
                    // System.out.println("Letra de movimiento");
                     union=""+caracter;
                     estado=38;
                 }else if(codigoAscii==80){
                    // System.out.println("Acepte P");
                     estado=39;
                       nombre=""+caracter;
                 }else if(codigoAscii==65){
                    // System.out.println("Acepte A");
                     estado=42;
                       nombre=""+caracter;
                 }else if(codigoAscii==84){
                    // System.out.println("Acepte T");
                     estado=46;
                       nombre=""+caracter;
                 }else if(codigoAscii==67){
                    // System.out.println("Acepto C");
                    estado=50;
                      nombre=""+caracter;
                 }else if(codigoAscii==68){
                    // System.out.println("Acepto D");
                   estado=56;
                     nombre=""+caracter;
                 }else if(codigoAscii==82){
                   estado=59;
                    // System.out.println("Acepte R");
                       nombre=""+caracter;
                 }else if(codigoAscii==79){
                  //   System.out.println("Acepto O");
                     estado=79;
                 }else if(codigoAscii==109){
                     //System.out.println("Acepto m");
                     estado=61;
                       nombre=""+caracter;
                 }else if (codigoAscii >= 48 && codigoAscii <= 56){// para digitos [0-9]+
                    // System.out.println("Aceptamos digitos");
                     digitos=""+caracter;
                     estado=78;
                 }else if(codigoAscii>=65 && codigoAscii<=90){// para cualquier nombre
                    // System.out.println("Registro un nombre con "+caracter);
                     nombre=""+caracter;
                    // System.out.println("Ingreso aqui con           "+caracter);
                     estado=71;
                 }else if(codigoAscii==9){
                     //System.out.println("hubo tabulador");
                 }else{
                System.out.println("error lexico que se da aca "+caracter);
            }
                
                
                }break;
                case 1:{
                if(codigoAscii==117){
                    
               // System.out.println("Acepto u");
                estado=2;
            }
                }break;
                case 2:{
                if(codigoAscii==103){
              //  System.out.println("Acepto g");
                estado=3;
            }
                }break;
                case 3:{
                if(codigoAscii==97){
             //   System.out.println("Acepto a");
                estado=4;
            }
                }break;
                case 4:{
                 if(codigoAscii==100){
               // System.out.println("Acepto d");
                estado=5;
            }
                }break;
                case 5:{
                    if(codigoAscii==111){
               // System.out.println("Acepto o");
                estado=6;
            }
                }break;
                case 6:{
                 if(codigoAscii==114){
             //   System.out.println("Acepto r");
                estado=7;
            }
                }break;
                case 7:{
                 if(codigoAscii==101){
                //System.out.println("Acepto e");
                estado=8;
            }
                }break;
                case 8:{
                 if(codigoAscii==115){
               // System.out.println("Acepto s");
                estado=0;
                x=42;
                matrizabrir.add(x);
                     System.out.println("Acepte Jugadores");
            }
                }break;
                case 9:{
                 if(codigoAscii==111){
            
                      estado=10;
                    }
                }break;
                case 10:{
                if(codigoAscii==109){
            
                      estado=11;
                    }
                }break;
                case 11:{
                if(codigoAscii==98){
            
                      estado=12;
                    }
                }break;
                case 12:{
                if(codigoAscii==114){
            
                      estado=13;
                    }
                }break;
                case 13:{
                if(codigoAscii==101){
            
                      estado=0;
                      System.out.println("Acepte nombre");
                x=50;
                matrizabrir.add(x);
                    }
                }break;
                case 14:{
                if(codigoAscii==108){
            
                      estado=15;
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 15:{
                if(codigoAscii==97){
            
                      estado=16;
                    }
                }break;
                case 16:{
                if(codigoAscii==110){
            
                      estado=17;
                    }
                }break;
                case 17:{
                if(codigoAscii==99){
            
                      estado=18;
                    }
                }break;
                case 18:{
                if(codigoAscii==97){
            
                      estado=19;
                    }
                }break;
                case 19:{
                if(codigoAscii==115){
            
                      estado=0;
                      System.out.println("Acepto Blancas");
                x=46;
                matrizabrir.add(x);
                    }
                }break;
                case 20:{
                if(codigoAscii==101){
            
                      estado=21;
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 21:{
                if(codigoAscii==103){
            
                      estado=22;
                    }
                }break;
                case 22:{
                if(codigoAscii==114){
            
                      estado=23;
                    }
                }break;
                case 23:{
                if(codigoAscii==97){
            
                      estado=24;
                    }
                }break;
                case 24:{
                if(codigoAscii==115){
            
                      estado=0;
                      System.out.println("Acepte Negras");
                x=47;
                matrizabrir.add(x);    
                }
                }break;
                case 25:{
                 if(codigoAscii==97){
            // a de tablero
                      estado=26;
                    
                    }else if(codigoAscii==117){
                   //  System.out.println("Acepto u");
                     estado=72;
                    }
                }break;
                case 26:{
                if(codigoAscii==98){
            
                      estado=27;
                    
                    }
                }break;
                case 27:{
                if(codigoAscii==108){
            
                      estado=28;
                    
                    }
                }break;
                case 28:{
                if(codigoAscii==101){
            
                      estado=29;
                    
                    }
                }break;
                case 29:{
                if(codigoAscii==114){
            
                      estado=30;
                    
                    }
                }break;
                case 30:{
                if(codigoAscii==111){
            
                      estado=0;
                    System.out.println("Acepte tablero");
                    x=49;
                   matrizabrir.add(x);
                    }
                }break;
                case 31:{
                if(codigoAscii==111){
            
                      estado=32;
                    
                    }else if(codigoAscii==105){
                    // i
                    estado=75;
                    }
                }break;
                case 32:{
                if(codigoAscii==115){
            
                      estado=33;
                    
                    }
                }break;
                case 33:{
                if(codigoAscii==105){
            // i
                      estado=34;
                    
                    }
                }break;
                case 34:{
                if(codigoAscii==99){
            //c
                      estado=35;
                    
                    }
                }break;
                case 35:{
                if(codigoAscii==105){
            //i
                      estado=36;
                    
                    }
                }break;
                case 36:{
                if(codigoAscii==111){
            //o
                      estado=37;
                    
                    }
                }break;
                case 37:{
                if(codigoAscii==110){
            //n
                      estado=0;
                    System.out.println("Acepte posicion");
                    x=51;
                    matrizabrir.add(x);
                    }
                }break;
                case 38:{
                if(codigoAscii >= 48 && codigoAscii <= 56){
                  union=union+caracter;
                  estado=0;
                    x=64;
                   matrizabrir.add(x);
                   jugadas.add(union);
                    union="";
                }
                }break;
                case 39:{
                 if(codigoAscii==101){
            //e
                      estado=40;
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 40:{
                if(codigoAscii==111){
            //o
                      estado=41;
                    
                    }
                }break;
                case 41:{
                 if(codigoAscii==110){
            //n
                      estado=0;
                     System.out.println("Acepte Peon");
                    x=55;
                   matrizabrir.add(x);
                    }
                }break;
                case 42:{
                
                 if(codigoAscii==108){
            //l
                      estado=43;
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 43:{
                
                 if(codigoAscii==102){
            //f
                      estado=44;
                    
                    }
                }break;
                case 44:{
                
                 if(codigoAscii==105){
            //i
                      estado=45;
                    
                    }
                }break;
                case 45:{
                
                 if(codigoAscii==108){
            //l
                      estado=0;
                     System.out.println("Acepte Alfil");
                    x=58;
                    matrizabrir.add(x);
                    }
                }break;
                case 46:{
                
                 if(codigoAscii==111){
            //o
                      estado=47;
                    
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 47:{
                
                 if(codigoAscii==114){
            //r
                      estado=48;
                    
                    }
                }break;
                case 48:{
                
                 if(codigoAscii==114){
            //r
                      estado=49;
                    
                    }
                }break;
                case 49:{
                
                 if(codigoAscii==101){
            //e
                      estado=0;
                     System.out.println("Acepte Torre");
                    x=57;
                    matrizabrir.add(x);
                    }
                }break;
                case 50:{
                if(codigoAscii==97){
            //a
                      estado=51;
               
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 51:{
                if(codigoAscii==98){
            //b
                      estado=52;
               
                    }
                }break;
                case 52:{
                if(codigoAscii==97){
            //a
                      estado=53;
               
                    }
                }break;
                case 53:{
                if(codigoAscii==108){
            //l
                      estado=54;
               
                    }
                }break;
                case 54:{
                if(codigoAscii==108){
            //l
                      estado=55;
               
                    }
                }break;
                case 55:{
                if(codigoAscii==111){
            //l
                      estado=0;
                    System.out.println("Acepte Caballo");
                     x=56;
                   matrizabrir.add(x);
                    }
                }break;
                case 56:{
                  if(codigoAscii==97){
            //a
                      estado=57;
               
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 57:{
                  if(codigoAscii==109){
            //m
                      estado=58;
               
                    }
                }break;
                case 58:{
                  if(codigoAscii==97){
            //a
                      estado=0;
                      System.out.println("Acepte Dama");
                        x=59;
                   matrizabrir.add(x);
                    }
                }break;
                case 59:{
                  if(codigoAscii==101){
            //e
                      estado=60;
               
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 60:{
                  if(codigoAscii==121){
            //y
                      estado=0;
                      System.out.println("Acepto Rey");
                    x=60;
                   matrizabrir.add(x);
                    }
                }break;
                case 61:{
                  if(codigoAscii==111){
            //o
                      estado=62;
               
                    }else if(codigoAscii>=68 && codigoAscii<=90){
                     nombre=nombre+caracter;
                     estado=71;
                 }
                }break;
                case 62:{
                if(codigoAscii==118){
            //v
                      estado=63;
               
                    }
                }break;
                case 63:{
                if(codigoAscii==105){
            //i
                      estado=64;
               
                    }
                }break;
                case 64:{
                if(codigoAscii==109){
            //m
                      estado=65;
               
                    }
                }break;
                case 65:{
                if(codigoAscii==105){
            //i
                      estado=66;
               
                    }
                }break;
                case 66:{
                if(codigoAscii==101){
            //e
                      estado=67;
               
                    }
                }break;
                case 67:{
                if(codigoAscii==110){
            //n
                      estado=68;
                   
                    }
                }break;
                case 68:{
                if(codigoAscii==116){
            //t
                      estado=69;
               
                    }
                }break;
                case 69:{
                if(codigoAscii==111){
            //o
                      estado=70;
               
                    }
                }break;
                case 70:{
                if(codigoAscii==115){
            //s
                      estado=0;
                    System.out.println("Acepte movimientos");
                    x=53;
                    matrizabrir.add(x);
                    }
                }break;
                case 71:{// aca aceptamos los nombres posibles
                  if(codigoAscii>=65 && codigoAscii<=90){
                    //  System.out.println("Nombre posible");
                     estado=71;
                     nombre=nombre+caracter;
                   
                 }else{
                      System.out.println("el nombre fue "+nombre);
                         x=40;
                         matrizabrir.add(x);
                         nombre_jugador.add(nombre);
                      nombre="";
                  estado=0;
                  }
                    
                    
                    
                }break;
                case 72:{
                 if(codigoAscii==114){
            //r
                      estado=73;
               
                    }
                }break;
                case 73:{
                 if(codigoAscii==110){
            //n
                      estado=74;
               
                    }
                }break;
                case 74:{
                if(codigoAscii==111){
            //o
                      estado=0;
                      System.out.println("Acepto turno");
                    x=54;
                    matrizabrir.add(x);
                    }
                }break;
                case 75:{
                if(codigoAscii==101){
               estado=76;
                }
                }break;
                case 76:{
                if(codigoAscii==122){
               estado=77;
                }
                }break;
                case 77:{
                if(codigoAscii==97){
               estado=0;
                    System.out.println("Acepto pieza");
                     x=52;
                    matrizabrir.add(x);
                }
                }break;
                case 78:{
                if( codigoAscii >= 48 && codigoAscii <= 56){
                    System.out.println("Entran digitos ");
                    digitos=digitos+caracter;
                    estado=78;
                   
                }else if(codigoAscii==44){
                    System.out.println("se supone que encuentro una coma aqui");
                    System.out.println("Acepto "+digitos);
                     numeros.add(digitos);
                   
                     digitos="";
                     x=62;// almacenara un digito cada vez q ingrese mejorar metodo
                    matrizabrir.add(x);
                      x=48;
                     matrizabrir.add(x);
                    estado=0;
                }
                }break;
                case 79:{
                if(codigoAscii==45){
                    System.out.println("Acepto -");
                    estado=80;
                }
                }break;
                case 80:{
                if(codigoAscii==79){
                    System.out.println("Acepto O");
                    estado=81;
                }
                }break;
                case 81:{
                if(codigoAscii==58){
                    System.out.println("ACepto :");
                    estado=82;
                }
                }break;
                case 82:{
                if(codigoAscii==67){
                    System.out.println("Acepto O-O:C");
                    estado=0;
                     x=39;// 
                   matrizabrir.add(x);
                }else if(codigoAscii==76){
                    System.out.println("Acepto O-O:L");
                     x=41;// 
                   matrizabrir.add(x);
                    estado=0;
                }
                }break;
                
                
            
            }//cierre de switch
            
            
            
            
            
            
        }//cierre de for principal
    }
    
    public static void main(String[] args){
              AFDAbrir a= new AFDAbrir();
              a.AnalizarAbrir("O-O:L O-O:C");
             
    }
    
    
}
