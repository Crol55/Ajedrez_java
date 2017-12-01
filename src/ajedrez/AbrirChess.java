/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class AbrirChess {
       //----------------------- lee el archivo------------ 
    public  String Lector(String nombrearchivo){
   File archivolector;
       FileReader FR; 
        
       try{
         archivolector= new File(nombrearchivo);
         FR= new FileReader(archivolector);
       BufferedReader br= new BufferedReader(FR);
       String l="";
       String aux="";
      
     while(true){
      aux=br.readLine();
       if(aux!=null)
         l=l+aux+"\n";
       
      
       else break;
    
     } 
          // System.out.println(l);
      br.close();
       FR.close();
     return l;
       
       }catch(IOException e){
           System.out.println("Ha ocurrido un error"+e.getMessage());
       }
       
return null;
}
    public static void main(String args[]){
       AbrirChess ab= new AbrirChess();
       ab.Lector("piezas");
    }
}
