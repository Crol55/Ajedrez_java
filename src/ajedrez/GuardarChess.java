/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.util.Queue;

public class GuardarChess {
    String union="";// nos sirve para concatenar la posicion que entra en el metodo Busar piezas
    int color=0;// puede tomar valores de 1 y 2, 1 hace referencia a BLANBAS Y 2 A NEGRAS SIRVE PARA SABER DE DONDE IR A SACAR DATOS
       public  static Queue<String> piezablanca = new LinkedList<String>();
       public  static Queue<String> piezanegra = new LinkedList<String>();
       public  static Queue<String> posicion = new LinkedList<String>();
       public static Queue<Integer> tipodecolor = new LinkedList<Integer>();
      public  static Queue<String> jugadorblancas = new LinkedList<String>();// para ver que piezas existen en el tablero y que sean blancas
      public  static Queue<String> jugadornegras = new LinkedList<String>();// piezas existentes en el tablero y color negro
       public  static Queue<String> posicionblancas = new LinkedList<String>();
        public  static Queue<String> posicionnegras = new LinkedList<String>();
        
        //=============Listas donde recibimos los movimientos que vienen de la clase Tablero===============
        public  static Queue<String> movblancas = new LinkedList<String>();
         public  static Queue<String> movnegras = new LinkedList<String>();
          public  static Queue<Integer> turnoss = new LinkedList<Integer>();
   
      //======================================
          String nombre_jugador1="";
          String nombre_jugador2="";
       public void BuscarPiezas(int columna,int fila,String pieza){
       
        switch (columna) {
            case 0:{
            union="h";
              //  System.out.println("ingreso a h");
            }break;
            case 1:{
             union="g";
               // System.out.println("ingreso a g");
            }break;
            case 2:{
            union="f";
               // System.out.println("ingreso a f");
            }break;
            case 3:{
            union="e";
              //  System.out.println("ingreso a e");
            }break;
            case 4:{
            union="d";
                //System.out.println("ingreso a d con 4");
            }break;
            case 5:{
            union="c";    
                //System.out.println("ingreso a c");
            }break;
            case 6:{
             union="b";   
               // System.out.println("ingreso a b");
            }break;
            case 7:{
              //  System.out.println("ingreso a ");
            union="a";    
            }break;
            
        }// cierre switch columna
    
    switch(fila){
        case 0:{
        union=union+"1";
        }break;
        case 1:{
        
        union=union+"2";
        }break;
        case 2:{
        union=union+"3";
        }break;
        case 3:{
        union=union+"4";
        }break;
        case 4:{
        union=union+"5";
        }break;
        case 5:{
        union=union+"6";
        }break;
        case 6:{
        union=union+"7";
        }break;
        case 7:{
        union=union+"8";
        }break;
    }// cierra switch fila
        posicion.add(union);
        union="";
        switch(pieza){
            
            case "TN":{
              color=2;
              piezanegra.add("Torre");
               tipodecolor.add(color);
              //  System.out.println("Torre negra");
            }break;
            case "CN":{
               // System.out.println("Caballo negro");
                piezanegra.add("Caballo");
              color=2;
               tipodecolor.add(color);
            }break;
            case "AN":{
                 piezanegra.add("Alfil");
              //  System.out.println("Alfil negro");
              color=2;
               tipodecolor.add(color);
            }break;
            case "RN":{
                 piezanegra.add("Rey");
             //   System.out.println("Rey negro");
              color=2;
               tipodecolor.add(color);
            }break;
            case "DN":{
                piezanegra.add("Dama");
               // System.out.println("Dama negra");
               color=2;
               tipodecolor.add(color);
            }break;
            case "PN":{
               // System.out.println("Peon negro");
                piezanegra.add("Peon");
              color=2;
               tipodecolor.add(color);
            }break;
             case "TB":{
              color=1;
                // System.out.println("ingresara "+color);
               tipodecolor.add(color);
               piezablanca.add("Torre");
             //    System.out.println("extrayendo"+tipodecolor.poll());
                //System.out.println("Torre blanca");
            }break;
            case "CB":{
               // System.out.println("Caballo blanca");
               piezablanca.add("Caballo");
                color=1;
               tipodecolor.add(color);
            }break;
            case "AB":{
                //System.out.println("Alfil blanca");
              piezablanca.add("Alfil");
              color=1;
               tipodecolor.add(color);
            }break;
            case "RB":{
               // System.out.println("Rey blanca");
               piezablanca.add("Rey");
              color=1;
               tipodecolor.add(color);
            }break;
            case "DB":{
                //System.out.println("Dama blanca");
                piezablanca.add("Dama");
              color=1;
               tipodecolor.add(color);
            }break;
            case "PB":{
                //System.out.println("Peon blanca");
                piezablanca.add("Peon");
                color=1;
                tipodecolor.add(color);
            }break;
        }// cierre switch pieza
       // System.out.println("posiciones "+union);
        
    }
       public void nombres_jugadores(String nombre1,String nombre2){
       nombre_jugador1=nombre1;
       nombre_jugador2=nombre2;
       }
   
    public static void llenar(){// metodo para 
        System.out.println("el tamano es "+posicion.size());
        
       while(!posicion.isEmpty()){
            int x= tipodecolor.poll();
            //System.out.println("el valor es "+x);
               switch(x){
            case 1:{
               
             // System.out.println(piezablanca.poll()+" "+posicion.poll());
              
   jugadorblancas.add(piezablanca.poll());// agregamos la posible pieza blanca del tablero
   posicionblancas.add(posicion.poll());// y su respectiva posicion
            }break;
            case 2:{
           //  System.out.println(piezanegra.poll()+" "+posicion.poll());
   jugadornegras.add(piezanegra.poll());// extraemos la piezas y posiciones y las enviamos a JUGADORNEGRAS
    posicionnegras.add(posicion.poll());

            }break;
        }//cierre switch
       }// cierre ciclo while
     
    
    }
      public void GuardarMovimientos(int turn,String blanc,String negr){
        turnoss.add(turn);
        movblancas.add(blanc);
        movnegras.add(negr);
      
      }
    
    //------------ guarda el archivo------------------------------
    public void guardartexto(String nombrearchivo){
      String simbolo=",";
   
      File archivo;
      FileWriter fw;
    try{
         archivo= new File(nombrearchivo);
        fw= new FileWriter(archivo);
      BufferedWriter bw= new BufferedWriter(fw);
      PrintWriter fin= new PrintWriter(bw);
    //  fin.write(nombreusuario+","+contrasena);//son parametros
    fin.write("jugadores:{\r\n\tBlancas: "+nombre_jugador1+" ,\r\n\tNegras: "+nombre_jugador2+"\r\n},") ;
   // fin.write(""+nombre_jugador1+"");
    fin.write("\r\ntablero:{\r\n     "+nombre_jugador1+" :{\r\n");
    while(!jugadorblancas.isEmpty()){// para llenar el jugador de las blancas
        if(jugadorblancas.size()==1){
            //System.out.println("si me cumplo antes de escribir la ultimma linea");
        simbolo="";
        }
    fin.write("           pieza:{\r\n                nombre:"+jugadorblancas.poll()+",\r\n\t\tposicion:"+posicionblancas.poll()+"\r\n           }"+simbolo+"\r\n");
    }
    fin.write("     }\r\n");
    fin.write("     "+nombre_jugador2+" :{\r\n");
     while(!jugadornegras.isEmpty()){//para llenar el jugador de la negras
         simbolo=",";
        if(jugadornegras.size()==1){
            //System.out.println("si me cumplo antes de escribir la ultimma linea");
        simbolo="";
        }
    fin.write("           pieza:{\r\n                nombre:"+jugadornegras.poll()+",\r\n\t\tposicion:"+posicionnegras.poll()+"\r\n           }"+simbolo+"\r\n");
    }
    fin.write("     }\r\n");
    fin.write("},\r\n");
    fin.write("movimientos:{\r\n");
    
    while(!turnoss.isEmpty()){// aca llenamos los movimientos realizados durante la partida
    fin.write("       turno:{\r\n");
    simbolo=",";
        if(turnoss.size()==1){
        simbolo="";
        }
    fin.write("              "+turnoss.poll()+",\r\n              "+nombre_jugador1+" : "+movblancas.poll()+",\r\n              "+nombre_jugador2+" : "+movnegras.poll()+"\r\n       }"+simbolo+"\r\n");
    }
    fin.write("}");
    fin.close();
      bw.close();
    }catch(IOException e){
        System.out.println("Error de ejecucion de archivo"+e.getMessage());
    }
    
    }
//-----------leer archivo con jfilechooser---------------------
    
    public void leergrafico(){
    File archivoleido;
    JFileChooser seleccion= new JFileChooser();
      seleccion.showOpenDialog(seleccion);
      String ruta=seleccion.getSelectedFile().getAbsolutePath();
      String lectura="";
     archivoleido=new File(ruta);
    try{
     FileReader archivolector= new FileReader(archivoleido);
     BufferedReader br= new BufferedReader(archivolector);
     String aux="";
     while((aux=br.readLine())!=null){
     lectura=lectura+aux+"\n";
     }
     archivolector.close();
     br.close();
    }catch(IOException ev){
        System.out.println("Ha ocurrido un error al leer el archivo"+ev.getMessage());
        
    }
 
    } 
   
}

