
package ajedrez;

import java.io.FileWriter;
import java.io.IOException;

public class Simbolos {
    
    public void simbolosytokens(){
    
    Tablero t= new Tablero();
    
       try{
FileWriter fw = new FileWriter("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\Simbolos.html");
            fw.write("<meta http-equiv=\"Content-Type\"  content=\"text/html; charset=UTF-8\" />" + "\n"  + "\n");
            fw.write("<HTML><HEAD><TITLE>Listado de Errores en la terminal</TITLE></HEAD>" + "\n" + "\n");
            fw.write("<HR>" + "\n" + "\n");
            fw.write("<BR><CENTER><TABLE BORDER=1>\n");
            fw.write("	<TR>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>NO.Token</B></FONT></TD>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>Token</B></FONT></TD>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>Lexema</B></FONT></TD>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>Fila</B></FONT></TD>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>Columna</B></FONT></TD>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>Palabra Reservada</B></FONT></TD>\n");
            
           // fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>palabra Reser.</B></FONT></TD>\n");
            fw.write("	</TR>\n");
                    
                    for(int numero=0; numero<t.lexema.size();numero++){
                    fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"RED\">" +t.n_token.get(numero)+ "</FONT></TD>\n");
                    fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"RED\">" +t.nombre_token.get(numero)+ "</FONT></TD>\n");
                      fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"RED\">" +t.lexema.get(numero)+ "</FONT></TD>\n");
                    fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLUE\">" +t.linea.get(numero)+ "</FONT></TD>\n");
                    fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLUE\">" +t.linea.get(numero)+ "</FONT></TD>\n");
                    fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"RED\">" +t.palabrareservada.get(numero)+ "</FONT></TD>\n");
                  
                   // fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLUE\">" + "No.columna"  + "</FONT></TD>\n");
                  
                    
                    
                    fw.write("	</TR>\n");
                        }
                    fw.write("</TABLE>" + "\n");
                    fw.flush();
                fw.close();

            }catch(IOException er){
                
                System.out.println(er);
            }
     
    
    
    
    
    
    }    
}
