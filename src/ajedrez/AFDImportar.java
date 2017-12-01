/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.ArrayList;

public class AFDImportar {

    int estado = 0;
    String matris[];
    char matrix[];// matris que almacena caracteres de una cadena entrante.
    int codigoAscii = 0;// lo utilizamos para almacenar el codigo de cada carater.
    int contador = 0;// contador que lleva la cuenta sobre que carater esta posisionado en cada ciclo del for
    boolean nombre = false;// nos sirve para conocer si es un nombre el que esta reconociendo actualmente o es un palabra reservada
    String nombre1 = "";
    String nombre2 = "";
    public ArrayList<Integer> matrizImportar = new ArrayList<Integer>();

    public void AnalizarImportar(String texto) {

        matrix = texto.toCharArray();// la cadena, la partimos en caracteres para poder analizar 1 por 1.
        matris = texto.split("");
        //System.out.println("el tamano "+matrix.length);
//    System.out.println(matrix[2]);
        for (int i = 0; i < matrix.length; i++) {

            codigoAscii = texto.codePointAt(i);
            //  System.out.println("el codigo ascii de B "+codigoAscii);
            switch (estado) {
                case 0: {

                    if (codigoAscii == 116 && nombre == false) {
                        System.out.println("Acepto t");
                        estado = 12;
                    } else if (codigoAscii == 64) {// aceptamos @
                        System.out.println("acepte   @");
                        // System.out.println("el nombre concatenado fue "+nombre1);
                        // nombre1="";
                        nombre = false;
                    } else if (codigoAscii == 32) {

                        System.out.println("acepte el espacio inicial");
                        estado = 0;

                        nombre = true;
                        System.out.println("el nombre fue " + nombre1);
                    } else if (codigoAscii == 66 && nombre == false) {
                        System.out.println("Acepte B");
                        estado = 1;
                        nombre = false;
                    } else if (codigoAscii == 78 && nombre == false) {
                        System.out.println("Acepte N");
                        estado = 7;
                        nombre = false;
                    } else if (codigoAscii == 46) {
                        System.out.println("acepto .");
                        nombre = false;
                    } else if (codigoAscii == 106 && nombre == false) {// aca aceptamos la J para iniciar un jaque mate.
                        System.out.println("Acepte la letra j");
                        estado = 16;
                        nombre = false;
                    } else if (codigoAscii == 108 && nombre == false) {// l para aceptar lfp
                        System.out.println("Acepte la letra   l  ");
                        estado = 25;
                        nombre = false;
                    } else if (codigoAscii >= 97 && codigoAscii <= 104 && nombre == false) {
                        System.out.println("Acepto letras para jugadas");
                        estado = 27;
                        nombre = false;

                    } else if (codigoAscii == 58) {
                        System.out.println(nombre1);
                        System.out.println("acepto los    :  ");
                        nombre = false;
                        nombre1 = "";
                    } else if (codigoAscii == 45) {
                        System.out.println("Acepto los -  ");
                        nombre = false;

                    } else if (codigoAscii == 79 && nombre == false) {// O-O:L o C
                        System.out.println("Acepto el O");
                        estado = 28;
                        nombre = false;
                    } else if (codigoAscii == 120) {
                        System.out.println("aceptamos x");
                        nombre = false;
                    } else if (codigoAscii == 47) {
                        System.out.println("acepto / ");
                        nombre = false;
                    } else if (codigoAscii == 44) {
                        System.out.println("acepto ,");
                        nombre = true;
                    } else if (codigoAscii >= 48 && codigoAscii <= 56) {//[0-9]
                        System.out.println("acepto digitos iniciales");

                    } else if (codigoAscii == 91) {
                        System.out.println("acepte [");
                        nombre = true;
                        nombre1 = "";
                    } else if (codigoAscii == 93) {
                        System.out.println("acepte ]");
                        nombre = false;
                    } else if (codigoAscii == 80 && nombre == false) {// PARA EL PEON
                        System.out.println("acepto P-para peon");
                        estado = 32;
                        nombre = false;
                    } else if (codigoAscii == 65 && nombre == false) {// PARA EL ALFIL
                        System.out.println("Acepto A");
                        estado = 35;
                        nombre = false;
                    } else if (codigoAscii == 84 && nombre == false) {// para la TORRE
                        System.out.println("Acepto T");
                        estado = 39;
                        nombre = false;
                    } else if (codigoAscii == 67 && nombre == false) {// PARA CABALLO
                        System.out.println("acepto C");
                          estado = 43;
                        nombre = false;
                    } else if (codigoAscii == 68 && nombre == false) {// PARA LA DAMA
                        System.out.println("acepto D");
                         estado=49;
                        nombre = false;
                    } else if (codigoAscii == 82 && nombre == false) {// PARA EL REY
                        System.out.println("acepto R");
                        estado=52;
                        nombre = false;
                    } else if ((codigoAscii >= 65 && codigoAscii <= 90 && nombre == true) || (codigoAscii >= 97 && codigoAscii <= 122 && nombre == true)) {
                        //  System.out.println("debo aparecer 3 veces almenos");
                        nombre1 = nombre1 + matris[i];
                        estado = 0;
                        //    System.out.println("entrantes "+nombre1);

                    }

                }
                break;

                case 1: {
                    //  System.out.println("el valor de codigo ascii donde devia haber un espacio es  "+codigoAscii);
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 108) {
                        System.out.println("acepte l");
                        estado = 2;

                    }
                }
                break;

                case 2: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 97) {
                        System.out.println("acepte a");
                        estado = 3;

                    }
                }
                break;
                case 3: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 110) {
                        System.out.println("acepte n");
                        estado = 4;

                    }
                }
                break;
                case 4: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 99) {
                        System.out.println("acepte c");
                        estado = 5;

                    }
                }
                break;
                case 5: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 97) {
                        System.out.println("acepte a");
                        estado = 6;

                    }
                }
                break;
                case 6: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 115) {
                        System.out.println("acepte s");
                        estado = 38;
                        estado = 0;
                    }
                }
                break;
                case 7: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 101) {
                        System.out.println("acepte e");
                        estado = 8;

                    }
                }
                break;
                case 8: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 103) {
                        System.out.println("acepte g");
                        estado = 9;

                    }
                }
                break;
                case 9: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 114) {
                        System.out.println("acepte r");
                        estado = 10;

                    }
                }
                break;
                case 10: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 97) {
                        System.out.println("acepte a");
                        estado = 11;

                    }
                }
                break;
                case 11: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 115) {
                        System.out.println("acepte s");
                        estado = 38;
                        estado = 0;
                    }
                }
                break;
                case 12: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 117) {
                        System.out.println("acepte u");
                        estado = 13;
                    }
                }
                break;
                case 13: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 114) {
                        System.out.println("acepte r");
                        estado = 14;
                    }

                }
                break;
                case 14: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 110) {
                        System.out.println("acepte n");
                        estado = 15;
                    }

                }
                break;
                case 15: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 111) {
                        System.out.println("acepte o");
                        estado = 38;
                        estado = 0;
                    }
                }
                break;
                case 16: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 97) {
                        System.out.println("acepte a ");
                        estado = 17;
                    }

                }
                break;
                case 17: {
                    //System.out.println("deberia entrar aqui");
                    //System.out.println("pero si ingreso aqui?"+codigoAscii);
                    if (codigoAscii == 113) {
                        System.out.println("acepto q");
                        estado = 18;
                    } else if (codigoAscii == 32) {
                        System.out.println("espacio");
                        estado = 0;
                    }

                }
                break;
                case 18: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 117) {
                        System.out.println("acepte u");
                        estado = 19;
                    }

                }
                break;
                case 19: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 101) {
                        System.out.println("acepte e");
                        estado = 21;
                    }

                }
                break;
                case 20: {

                    // if(codigoAscii==32){
                    //  System.out.println("hubo espacio para cambiar");
                    // estado=21;
                    //  }
                }
                break;

                case 21: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 77) {
                        System.out.println("acepte M");
                        estado = 22;
                    }

                }
                break;
                case 22: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 97) {
                        System.out.println("acepte a");
                        estado = 23;
                    }

                }
                break;
                case 23: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 116) {
                        System.out.println("acepte t");
                        estado = 24;
                    }

                }
                break;

                case 24: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 101) {
                        System.out.println("acepte e");
                        estado = 38;
                        estado = 0;
                    }

                }
                break;
                case 25: {

                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 102) {
                        System.out.println("acepte f");
                        estado = 26;
                    }
                }
                break;

                case 26: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 112) {
                        System.out.println("acepte p");
                        estado = 38;
                        estado = 0;
                    }
                }
                break;

                case 27: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii >= 48 && codigoAscii <= 56) {
                        System.out.println("acepto digitos");
                        estado = 38;
                        estado = 0;
                    }
                }
                break;
                case 28: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 45) {
                        System.out.println("acepte -");
                        estado = 29;

                    }

                }
                break;
                case 29: {
                    if (codigoAscii == 32) {
                        estado = 0;
                        System.out.println("hubo espacio");

                    } else if (codigoAscii == 79) {
                        System.out.println("acepte O");
                        estado = 30;
                    }
                }
                break;
                case 30: {

                    if (codigoAscii == 32) {
                        estado = 0;
                        System.out.println("hubo espacio");

                    } else if (codigoAscii == 58) {
                        System.out.println("acepte :");
                        estado = 31;
                    }

                }
                break;

                case 31: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 76) {
                        System.out.println("acepte L");
                        estado = 38;
                        estado = 0;
                    } else if (codigoAscii == 67) {
                        System.out.println("Acepte C");
                        estado = 38;
                        estado = 0;
                    }

                }
                break;

                case 32: {

                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 101) {
                        System.out.println("acepte e");

                        estado = 33;
                    }
                }
                break;

                case 33: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 111) {
                        System.out.println("acepte o");
                        estado = 34;
                    }
                }
                break;
                case 34: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 110) {
                        System.out.println("acepte n");
                        estado = 0;
                        System.out.println("Acepte Peon completo");
                    }

                }
                break;
                case 35: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 108) {
                        // System.out.println("acepte n");
                        estado = 36;

                    }

                }
                break;
                case 36: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 102) {
                        // System.out.println("acepte n");
                        estado = 37;

                    }
                }
                break;
                case 37: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 105) {
                        // System.out.println("acepte n");
                        estado = 38;
                        System.out.println("Acepte Peon completo");
                    }

                }
                break;

                case 38: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 108) {
                        // System.out.println("acepte n");
                        estado = 0;
                        System.out.println("Acepte Alfil");
                    }

                }
                break;

                case 39: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 111) {
                        // System.out.println("acepte n");
                        estado = 40;

                    }
                }
                break;
                case 40: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 114) {
                        // System.out.println("acepte n");
                        estado = 41;

                    }
                }
                break;
                case 41: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 114) {
                        // System.out.println("acepte n");
                        estado = 42;

                    }
                }
                break;
                case 42: {
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 101) {
                        // System.out.println("acepte n");
                        estado = 0;
                        System.out.println("Acepte Torre");

                    }

                }
                break;
                case 43: {               // aca aceptapos aballo
                    if (codigoAscii == 32) {

                        System.out.println("hubo espacio");
                        estado = 0;
                    } else if (codigoAscii == 97) {
                        // System.out.println("acepte n");
                        estado = 44;

                    }
                }
                break;
                case 44: {
                    
                     if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==98){
                   // System.out.println("acepte n");
                    estado=45;
                  
              }
                }
                break;
                case 45: {
                     if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==97){
                   // System.out.println("acepte n");
                    estado=46;
                  
              }
                    
                }
                break;
                case 46: {
                     if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==108){
                   // System.out.println("acepte n");
                    estado=47;
                  
              }
                    
                }
                break;
                case 47: {
                     if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==108){
                   // System.out.println("acepte n");
                    estado=48;
                  
              }
                }
                break;
                case 48: {
                     if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==111){
                         System.out.println("acepto Caballo");
                    estado=0;
                  
              }
                }
                break;
                case 49: {// Aca aceptaremos Dama
                     if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==97){
                   // System.out.println("acepte n");
                    estado=50;
                  
              }
                    
                    
                }
                break;
                case 50: {
                      if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==109){
                   // System.out.println("acepte n");
                    estado=51;
                  
              }
                    
                }
                break;
               
                case 51:{
                  if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==97){
                   // System.out.println("acepte n");
                    estado=0;
                    
                    
                      System.out.println("Acepto Dama");
              }
                
                }break;
                
                case 52:{
                 if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==101){
                   // System.out.println("acepte n");
                    estado=53;
                  
              }
                }break;
                case 53:{
                 if(codigoAscii==32){
                 
                  System.out.println("hubo espacio");
                   estado=0;
                }else if(codigoAscii==121){
                   // System.out.println("acepte n");
                    estado=0;
                     System.out.println("Acepte Rey");
              }
                
                }break;
            }

        }

    }

    public static void main(String[] args) {
        AFDImportar im = new AFDImportar();
        im.AnalizarImportar("@Blancas: Juan @Negras: Pedro @turno1[Juan:Peond4,Pedro:Reyb4]");

    }

}
