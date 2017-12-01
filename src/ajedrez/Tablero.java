/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Tablero extends javax.swing.JFrame {
    static String  [][] tableromatriz=new String [8][8];
    //  imagenes de las piezas blancas
    ImageIcon peonB = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\Peon.png");
    ImageIcon caballoB = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\caballo.png");
    ImageIcon alfilB = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\alfilB.png");
    ImageIcon torreB = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\torreB.png");
    ImageIcon damaB = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\damaB.png");
    ImageIcon reyB = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\reyB.png");
    
    // imagenes de las piezas negras
     ImageIcon peonN = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\peonN.png");
     ImageIcon caballoN = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\caballoN.png");
     ImageIcon alfilN =new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\alfilN.png");
     ImageIcon torreN = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\torreN.png");
     ImageIcon damaN = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\damaN.png");
     ImageIcon reyN = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\reyN.png");
    
    
    
    boolean inicio = true, juego = false, calculadora = false, abrir = false, importar = false, instanciamiento = true;
    int contador = 0, resultado = 0,resultado2=0;
    String lineas[];
    public int contadorespecial = 0;
    public 
    int turno=1;
    String lex,reservada;
    int tok;
    String nombretok;
    String regresar="";// Para poder regresar al texto que estaba escrito en la pantalla antes de un error en jugadas
    int resultado3=0;
    int contador7=0;
    boolean blanca=false,negra=false,inicial=false;
    boolean inicial2=false,inicial3=false;
    public int tokeninicio=0;// nos servira para obtener un valor del token que se obtuvo tras analizar lexicamente el inicio
    int resultado4=0;
     public static ArrayList<Integer> linea= new ArrayList<Integer>(); 
     public static ArrayList<String> lexema= new ArrayList<String>(); 
     public static ArrayList<Integer> numero= new ArrayList<Integer>(); 
     public static ArrayList<String> token= new ArrayList<String>();
     public static ArrayList<Integer> n_token= new ArrayList<Integer>(); 
     public static ArrayList<String> palabrareservada= new ArrayList<String>(); 
     public static ArrayList<String> nombre_token= new ArrayList<String>();
     public static ArrayList<Integer> column= new ArrayList<Integer>(); 
    public boolean apertura=false;// esta variable nos siver para saber la inicializacion del juego comenzando por las blancas
                               // nos sirve para conocer si es el movimiento inicial el que se esta dando
    public boolean pilavacia=false;// para conocer si la pila esta vacia al terminar el analisis sintactico indicando si estuvo correcto el analisis o no
    public boolean errorsintactico=false;// Sirve para conocer si existe un error sintactico entrante de la clase "SINTACTICOMOVIMIENTOS"
    public static boolean error=false;// verificar si "SINTACTICO MOVIMIENTOS" analizo correctamente la cadena.
    public boolean unico=false;// solo se activa la primera vez al iniciar el juego y sirve para, que limpie la pantalla una unica vez
                  int especial=0;
                  int contador8=0;// contador que nos mueve en la lista que contiene las letras concatenadas
    public boolean cambio=false;
    public static  boolean guardarpartida=false;// habilita guardar partida.
    //==================Pilas para analisis Sintactico==========
   public static Queue<Integer> pila = new LinkedList<Integer>(); 
   public static Queue<Integer> pilainicio = new LinkedList<Integer>(); 
   public Queue<Integer> tokensdeabrir = new LinkedList<Integer>(); 
   //===================================================================
   //===================== pila para posicion de piezas en el tablero================
    public static Queue<Integer> filai = new LinkedList<Integer>();
     public static Queue<Integer> columnaj = new LinkedList<Integer>();
      public static Queue<String> pieza = new LinkedList<String>();
      
   //======================================
   //=================Manera de almacenar la jugada para luego utilizarla en GuardarChess============
      
      public static Queue<String> movimientosblancas = new LinkedList<String>();
      public static Queue<String> movimientosnegras = new LinkedList<String>();
      public static Queue<Integer> turnospartida= new LinkedList();
     
      public static String nombre1="";
      public static String nombre2="";
      //================================
      public static void mensajesdepila(String me){// esto nos ayuda a mostrar todos los mensajes de errores y aceptacion en los analizadores
      
        JOptionPane.showMessageDialog(null,me); 
      }
      public static void Nombres(){
       nombre1=JOptionPane.showInputDialog("Ingrese nombre del q utilizara las Blancas");
       nombre2=JOptionPane.showInputDialog("Ingrese Nombre de el que utilizara las Negras");
      
      mensajesdepila(nombre1);
      mensajesdepila(nombre2);
        
      
      }
      
      public static ImageIcon prueba(){
       ImageIcon peonB = new ImageIcon("C:\\Users\\carlos\\Documents\\NetBeansProjects\\Ajedrez\\src\\ajedrez\\Peon.png");
         return peonB;
      }
       public static void llenado(){
           for (int i = 0; i < 8; i++) {
               for (int j = 0; j < 8; j++) {
                   if(i==0){
                       if((j==0)||(j==7)){
                         tableromatriz[i][j]="TN";
                       }else if((j==1)||(j==6)){
                         tableromatriz[i][j]="CN";
                       }else if((j==2)||(j==5)){
                          tableromatriz[i][j]="AN";
                       }else if(j==3){
                         tableromatriz[i][j]="RN";
                       }else if(j==4){
                          tableromatriz[i][j]="DN";
                       }
                       
                   }else if(i==1){
                      tableromatriz[i][j]="PN";
                   }else if(i==6){
                     tableromatriz[i][j]="PB";
                     
                   }else if(i==7){
                   if((j==0)||(j==7)){
                         tableromatriz[i][j]="TB";
                       }else if((j==1)||(j==6)){
                         tableromatriz[i][j]="CB";
                       }else if((j==2)||(j==5)){
                          tableromatriz[i][j]="AB";
                       }else if(j==3){
                         tableromatriz[i][j]="RB";
                       }else if(j==4){
                          tableromatriz[i][j]="DB";
                       }
                   }
                   
               }// ciclo j
           }//ciclo i
         //  tableromatriz[1][0]=null;
           //tableromatriz[3][0]="PN";// asi podemos mover las posiciones en el tablero
          
          
       }
      
       public static  void GuardarPartida(){// nos sirve para saber que piezas estan existentes en el tablero.
           GuardarChess cc= new GuardarChess();// hacemos refrencia a la clase GuardarChess;
        for (int i = 0; i < 8; i++) {
               for (int j = 0; j < 8; j++) {
                 
                   String posiciones=tableromatriz[i][j];// tomamos el valor de cada posicion del tablero
                   if(posiciones!=null){// se ejecutara cada vez que encuentre una pieza en el tablero.
                       filai.add(i);
                       columnaj.add(j);
                       pieza.add(posiciones);
                      // System.out.println(j+""+i+""+posiciones);
                      cc.BuscarPiezas(columnaj.poll(),filai.poll(),pieza.poll());//utilizamos el metodo de la clase GuardarChess
                   }
               }
           }
        cc.llenar();
         //  System.out.println("el tamano segun turno es "+turnospartida.size());
          // System.out.println("El tamano segund blancas es "+turnospartida.size());
        while(!turnospartida.isEmpty()){//enviamos todos los movimientos realizados a la clase GuardarChess
          //  System.out.println("ffsfsdfsd"+movimientosblancas.poll());
        cc.GuardarMovimientos(turnospartida.poll(),movimientosblancas.poll(),movimientosnegras.poll());
        
        }
        cc.nombres_jugadores(nombre1, nombre2);
        cc.guardartexto("piez");
       }
      
    public Tablero() {
        initComponents();
        llenado();
        //GuardarPartida();
        
    }
 
/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        h1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        g1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        f1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        e1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        d1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        c1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        b1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        a1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        h2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        g2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        f2 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        e2 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        d2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        c2 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        b2 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        a2 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        h3 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        g3 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        f3 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        e3 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        d3 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        c3 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        b3 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        a3 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        h4 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        g4 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        f4 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        e4 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        d4 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        c4 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        b4 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        a4 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        h5 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        g5 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        f5 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        e5 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        d5 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        c5 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        b5 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        a5 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        h6 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        g6 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        f6 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        e6 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        d6 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        c6 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        b6 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        a6 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        h7 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        g7 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        f7 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        e7 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        d7 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        c7 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        b7 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        a7 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        h8 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        g8 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        f8 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        e8 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        d8 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        c8 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        b8 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        a8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(153, 51, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(153, 51, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(153, 51, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(153, 51, 0));
        jPanel11.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(153, 51, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));
        jPanel13.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(153, 51, 0));
        jPanel14.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 204));
        jPanel15.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(153, 51, 0));
        jPanel16.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 204));
        jPanel17.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(153, 51, 0));
        jPanel18.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 204));
        jPanel19.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 204));
        jPanel20.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(153, 51, 0));
        jPanel21.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 204));
        jPanel28.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel29.setBackground(new java.awt.Color(153, 51, 0));
        jPanel29.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 204));
        jPanel30.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.setBackground(new java.awt.Color(153, 51, 0));
        jPanel31.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 204));
        jPanel33.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel34.setBackground(new java.awt.Color(153, 51, 0));
        jPanel34.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel35.setBackground(new java.awt.Color(153, 51, 0));
        jPanel35.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 204));
        jPanel36.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel37.setBackground(new java.awt.Color(153, 51, 0));
        jPanel37.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel38.setBackground(new java.awt.Color(255, 255, 204));
        jPanel38.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel39.setBackground(new java.awt.Color(153, 51, 0));
        jPanel39.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 204));
        jPanel40.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel41.setBackground(new java.awt.Color(153, 51, 0));
        jPanel41.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel42.setBackground(new java.awt.Color(255, 255, 204));
        jPanel42.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel43.setBackground(new java.awt.Color(255, 255, 204));
        jPanel43.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel44.setBackground(new java.awt.Color(153, 51, 0));
        jPanel44.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel45.setBackground(new java.awt.Color(255, 255, 204));
        jPanel45.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel46.setBackground(new java.awt.Color(153, 51, 0));
        jPanel46.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel47.setBackground(new java.awt.Color(255, 255, 204));
        jPanel47.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel48.setBackground(new java.awt.Color(153, 51, 0));
        jPanel48.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel49.setBackground(new java.awt.Color(255, 255, 204));
        jPanel49.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel50.setBackground(new java.awt.Color(153, 51, 0));
        jPanel50.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel51.setBackground(new java.awt.Color(153, 51, 0));
        jPanel51.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel52.setBackground(new java.awt.Color(255, 255, 204));
        jPanel52.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel53.setBackground(new java.awt.Color(153, 51, 0));
        jPanel53.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel54.setBackground(new java.awt.Color(255, 255, 204));
        jPanel54.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel55.setBackground(new java.awt.Color(153, 51, 0));
        jPanel55.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel56.setBackground(new java.awt.Color(255, 255, 204));
        jPanel56.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel57.setBackground(new java.awt.Color(153, 51, 0));
        jPanel57.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel58.setBackground(new java.awt.Color(255, 255, 204));
        jPanel58.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel59.setBackground(new java.awt.Color(255, 255, 204));
        jPanel59.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel60.setBackground(new java.awt.Color(153, 51, 0));
        jPanel60.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel61.setBackground(new java.awt.Color(255, 255, 204));
        jPanel61.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel62.setBackground(new java.awt.Color(153, 51, 0));
        jPanel62.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel63.setBackground(new java.awt.Color(255, 255, 204));
        jPanel63.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel64.setBackground(new java.awt.Color(153, 51, 0));
        jPanel64.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel65.setBackground(new java.awt.Color(255, 255, 204));
        jPanel65.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel66.setBackground(new java.awt.Color(153, 51, 0));
        jPanel66.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel67.setBackground(new java.awt.Color(153, 51, 0));
        jPanel67.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(h8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel68.setBackground(new java.awt.Color(255, 255, 204));
        jPanel68.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel69.setBackground(new java.awt.Color(153, 51, 0));
        jPanel69.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel70.setBackground(new java.awt.Color(255, 255, 204));
        jPanel70.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel71.setBackground(new java.awt.Color(153, 51, 0));
        jPanel71.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel72.setBackground(new java.awt.Color(255, 255, 204));
        jPanel72.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel73.setBackground(new java.awt.Color(153, 51, 0));
        jPanel73.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel74.setBackground(new java.awt.Color(255, 255, 204));
        jPanel74.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel66.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel66.setText("a");

        jLabel67.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel67.setText("b");

        jLabel68.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel68.setText("c");

        jLabel69.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel69.setText("d");

        jLabel70.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel70.setText("e");

        jLabel71.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel71.setText("f");

        jLabel72.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel72.setText("g");

        jLabel73.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel73.setText("h");

        jLabel74.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel74.setText("8");

        jLabel75.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel75.setText("7");

        jLabel76.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel76.setText("6");

        jLabel77.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel77.setText("5");

        jLabel78.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel78.setText("4");

        jLabel79.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel79.setText("3");

        jLabel80.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel80.setText("2");

        jLabel81.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel81.setText("1");

        jMenu3.setText("Tabla");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });

        jMenuItem1.setText("Errores Lexicos");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Simbolos");
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Ayuda");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel80)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel79)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel78)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel77)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel76)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel75)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel74)
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel69)
                        .addComponent(jLabel71))
                    .addComponent(jLabel70)
                    .addComponent(jLabel73)
                    .addComponent(jLabel72)
                    .addComponent(jLabel67)
                    .addComponent(jLabel68)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
       contador7=0;
       contador8=0;
       pilavacia=false;
       errorsintactico=false;
        String area = jTextArea1.getText();
        if (evt.getExtendedKeyCode() == 10) {
            lineas = jTextArea1.getText().split("\\n");// nos devuelve lo q tiene cada linea donde haya un salto de linea.
            System.out.println("especial"+contadorespecial);
           if(inicio==true){// ingresa cada vez q se regrese al menu principal osea el inicio.
               SintacticoInicio in= new SintacticoInicio();
               if(cambio==false){
                     contadorespecial=0;
               }
              
               AFDInicio i = new AFDInicio();
               i.analizarInicio(lineas[contadorespecial]); // devuelve el int de el automata inicio
//contadorespecial es para SABER EN QUE LINEA DEL TEXTAREA ESTOY ACTUALMENTE ANALIZANDO
   for(int j = 0; j < i.matrizinicio.size(); j++) {
         resultado=i.matrizinicio.get(j);
         in.pila.add(resultado);
        
         String mens=in.COMANDOS();// llamamos al metodo que nos retornara si esta correctamente escrita o incorrecta
         
          JOptionPane.showMessageDialog(null,mens); 
          //System.out.println("el valor de token inicio es "+in.tokk());
   }

                //for (int j = 0; j < i.matrizinicio.size(); j++) {
                 //   resultado=i.matrizinicio.get(j);
                    switch(in.tokk()){
                        case 1:{//entramos en juego.
                        //Nombres();
                        lex="PlayChess!";
                        tok=1;
                        reservada="si";
                        nombretok="PlayC";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pilainicio.add(tok);
                            contadorespecial=0;
                           inicio=false;
                           juego=true;
                           blanca=true;// empiezan las blancas con su turno
                           jTextArea1.setText("");
                           jTextArea1.setText(jTextArea1.getText()+"Turno "+turno+"\n"+"Blancas> ");
                           regresar=jTextArea1.getText();
                           contadorespecial++;
                           Nombres();
       //CREACION Y COLOCACION DE LAS PIEZAS BLANCAS                    
      Icon icono = new ImageIcon(peonB.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono2 = new ImageIcon(torreB.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono3 = new ImageIcon(caballoB.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono4 = new ImageIcon(alfilB.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono5 = new ImageIcon(damaB.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono6 = new ImageIcon(reyB.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      //---------------Peones Blancos-------------
         a7.setIcon(icono); b7.setIcon(icono);
         a7.setText("PeonB");b7.setText("PeonB");// le cambiamos el nombre a los jlabe para tener accesso a donde sta la poiscion
         c7.setIcon(icono);  d7.setIcon(icono);
         c7.setText("PeonB");d7.setText("PeonB");
         e7.setIcon(icono);f7.setIcon(icono);
         e7.setText("PeonB");f7.setText("PeonB");
         g7.setIcon(icono);h7.setIcon(icono);
         g7.setText("PeonB");h7.setText("PeonB");
    //------------Peones Blancos Arriba-------------
         
         h8.setIcon(icono2);a8.setIcon(icono2);
         h8.setText("TorreB");a8.setText("TorreB");
         g8.setIcon(icono3);b8.setIcon(icono3);
         f8.setIcon(icono4);c8.setIcon(icono4);
         e8.setIcon(icono5);d8.setIcon(icono6);
    //--------------Piezas Negras arriba------------     
      //CREACION Y COLOCACION DE LAS PIEZAS NEGRAS. 
      Icon icono7 = new ImageIcon(peonN.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono8 = new ImageIcon(torreN.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono9 = new ImageIcon(caballoN.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono10 = new ImageIcon(alfilN.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono11 = new ImageIcon(damaN.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
      Icon icono12 = new ImageIcon(reyN.getImage().getScaledInstance(h8.getWidth(), h8.getHeight(), Image.SCALE_DEFAULT));
         a2.setIcon(icono7); b2.setIcon(icono7);
         
         a2.setName("PeonN");
         c2.setIcon(icono7);d2.setIcon(icono7);//peones
         e2.setIcon(icono7);f2.setIcon(icono7);
         g2.setIcon(icono7);h2.setIcon(icono7);
         h1.setIcon(icono8);a1.setIcon(icono8);// caballo negro
         g1.setIcon(icono9);b1.setIcon(icono9);// alfil negro
         f1.setIcon(icono10);c1.setIcon(icono10);// Dama negra
         e1.setIcon(icono11);d1.setIcon(icono12);// Rey negro
         
      
                        }break;
                        case 2:{
                        // HAbilita comandos de Calc Chess
                        lex="CalcChess!";
                        tok=2;
                        reservada="si";
                        nombretok="Calc";
                        pilainicio.add(tok);
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema "+lexema);
                        contadorespecial=0;
                        inicio = false;// inhabilitamos el inicio para q la consola ya no busque aqui
                        inicial2=true;// habilitamos una unica vez la posibilidad de hacer cero el contadorespecial
                        calculadora = true;
                        jTextArea1.setText("");
                       
                      }break;
                        case 3:{
                            GuardarChess g= new GuardarChess();
                            g.guardartexto("carajito.chess");
                        lex="Importar";
                        tok=3;
                        reservada="si";
                        nombretok="A_importar";
                        pilainicio.add(tok);
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        inicio = false;
                        importar = true;
                        
                        jTextArea1.setText("");
                        
                        
                        }break;
                        case 4:{
                         lex="Salir";
                        tok=4;
                        reservada="si";
                        nombretok="I_Salir";
                        pilainicio.add(tok);
                         lexema.add(lex);
                        n_token.add(tok);
                        contadorespecial=0;
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        inicio = false;
                        System.exit(0);
                        
                        }break;
                        
                        case 5:{
                            System.out.println("si me estoy ejecutando para aumentar lineas");
                        contadorespecial++;
                        cambio=true;
                        }break;
                    }
                
                     
                   
                      
              
                    
               // }//cierre for
              
           }else if(juego==true){ //aca validamos todo lo del tablero
      
               AFDMovimientos m= new AFDMovimientos();
               SintacticoMovimientos parse= new SintacticoMovimientos();
             
               System.out.println("Contador especial "+contadorespecial);
               m.analizar(lineas[contadorespecial]);
               pilavacia=false;
               error=false;
               for (int j = 0; j < m.matrizMM.size(); j++) {
                   
                    resultado2=m.matrizMM.get(j);
                    switch(resultado2){
                   case 5:{
                    lex="O-O:C";
                        tok=101;
                        reservada="si";
                        nombretok="Enroque Corto";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lex);
                        pila.add(tok);
                    }break;
                    case 6:{
                    lex="O-O:L";
                        tok=11;
                        reservada="si";
                        nombretok="Enroque Largo";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                    System.out.println("lexema :"+lex);
                    }break;
                    case 7:{
                    lex="Caballo";
                        tok=5;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                    System.out.println("lexema :"+lex);
                    }break;
                    case 8:{
                    lex="Peon";
                        tok=6;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                    System.out.println("lexema :"+lex);
                    }break;
                    case 9:{
                    lex="Alfil";
                        tok=7;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                        System.out.println("lexema :"+lex);
                    }break;
                    
                     case 10:{
                    lex="Dama";
                        tok=8;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                    System.out.println("lexema :"+lex);
                    }break;
                    
                    case 11:{
                    lex="Rey";
                      tok=9;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                        System.out.println("lexema :"+lex);
                    }break;
                    case 12:{
                    lex="Torre";
                        tok=10;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                    System.out.println("lexema :"+lex);
                    }break;
                    case 13:{
                        lex=m.lista.poll();
                       // System.out.println("el lexema tras concatenar fue  "+lex);
                        tok=15;
                        pila.add(tok);
                        reservada="no";
                        nombretok="Posicion";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        m.union="";
                    }break;
                    
                    
                    case 14:{   //-----  // ABRIR ARCHIVOS Y PERMITE CARGAR UN ARCHIVO GENERADO POR GUARDAR
                    lex="Abrir";
                        tok=25;
                        reservada="si";
                        nombretok="J_abrir";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        abrir=true;
                        juego=false;
                        inicial=true;
                        jTextArea1.setText("");
                        turno=1;
                        contadorespecial=0;
                            pila.add(tok);                                                             
                        System.out.println("lexema :"+lex);
                    }break;
                    case 15:{
                        
                        lex="Guardar";
                        tok=30;
                        reservada="si";
                        nombretok="J_Guardar";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                       
                    System.out.println("lexema :"+lex);
                    }break;
                    case 16:{
                    lex="Salir";
                        tok=35;
                        pila.add(tok);
                        reservada="si";
                        nombretok="J_Salir";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                    juego=false; 
                    inicio=true;
                    System.out.println("lexema :"+lex);
                    jTextArea1.setText("");
                    turno=1;
                    contadorespecial=0;
                    }break;
                    case 17:{
                    lex="x";
                        tok=20;
                        reservada="no";
                        nombretok="Equis";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                    System.out.println("lexema :"+lex);
                    
                    }break;
                    case 18:{
                        
                    lex="Blancas>";
                       /* tok=1;
                        reservada="si";
                        nombretok="Color_Pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);*/
                    System.out.println("lexema :"+lex);
                    }break;
                    case 19:{
                        lex="Negras>";
                      /*  tok=1;
                        reservada="si";
                        nombretok="Color_Pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        */
                        System.out.println("lexema :"+lex);
                    }break;
                
                    case 170:{
                     lex="-";
                        tok=12;
                        reservada="no";
                        nombretok="guion";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        pila.add(tok);
                    System.out.println("lexema :"+lex);
                    }break;
                }// cierre de switch
                    
              }//cierre for
              pilavacia=pila.isEmpty();// indica si la pila esta vacia inclusive antes de vaciarla.
              while(!pila.isEmpty()){
              
                  parse.pilaparse.add(pila.poll());
               
              }
                    
              if(pilavacia==true){
                 mensajesdepila("Error Lexico de la cadena entera, no existe token");
              }else{
               
               parse.parse();// hacemos referencia a la clase SINTACTICO MOVIMIENTOS PARA ANALIZR LA CADENA INGRESADA
                  //System.out.println("luego de entrar a parse como esta la pila "+pilavacia);
              }
       ///======================colocar if para evitar que entre cuando se ejecuta abrir===================  
       if(abrir==false){
              error=parse.huboerror();
              guardarpartida=parse.guardaractivo;
              
 if((pilavacia==true) || (error==true)){// si la jugada es invalida, borramos y regresamos antes del error 
   //  System.out.println("ingresa aqui en algun momento");
                     if(unico==false){
                       jTextArea1.setText(regresar);  
                       unico=true;
                     }else{
                     jTextArea1.setText(regresar); 
                     }
                     
                     System.out.println("deberia repetir jugada");
                     
                 }else{// si la cadena fue valida auentamos de linea para analizar las negras en la siguiente jugada
                    // mensajesdepila("siempre ingreso aqui con el turno"+m.ColorDePiezaActual());
                     //mensajesdepila(lineas[contadorespecial]);
                     
                     String aux=lineas[contadorespecial].replaceAll("\\s","");// retiramos todos los espacios de lo analizado
                     
                    // mensajesdepila(aux);
                     String auxfinal[]=aux.split(">");
                     if(m.ColorDePiezaActual().equals("blancas")){
                         movimientosblancas.add(auxfinal[1]);
                        // System.out.println("ingreso en blancas con la jugada "+auxfinal[1]);
                     }else{
                         //System.out.println("fijo es negra "+m.ColorDePiezaActual());
                        // System.out.println("y su jugada fue "+auxfinal[1]);
                         movimientosnegras.add(auxfinal[1]);
                     }
                     
                  contadorespecial++;// salto de linea de blancas ---> negras
                 }
            
        
if((pilavacia==false) && (error==false)){
               if(blanca==true && juego==true && abrir==false){// ACA VALIDAMOS EN QUE TURNO NOS ENCONTRAMOS ACTUALMENTE.
                   blanca=false;
                   negra=true;
                   //System.out.println("Si ingrese aqui tras el error");
                   
               }else if(negra==true && juego==true && abrir==false){// TURNO PARA LAS NEGRAS Y ARRIBA ESTA EL DE LAS BLANCAS.
                   negra=false;
                   blanca=true;
                  // System.out.println("si ingrese aqui tras el otro error");
               }///////////////---------------
               if(negra==true && juego==true && abrir==false){
               jTextArea1.setText(jTextArea1.getText()+"Negras> ");
               regresar=jTextArea1.getText();
               }else if(blanca==true && juego==true && abrir==false){
                   turnospartida.add(turno);
                   turno++;
               jTextArea1.setText(jTextArea1.getText()+"Turno "+turno+"\n"+"Blancas> ");
               regresar=jTextArea1.getText();
                    contadorespecial++;
               }  
              }else{// si la pila esta vacia,pilavacia==true debe realizar su turno denuevo
              mensajesdepila("Debe repetir su jugada");
              }
               

              if(guardarpartida==true){
              GuardarPartida();
              }
               
               
           }
               
               
               
               
           }else if(importar==true){
               AFDImportar im= new AFDImportar();
                    
               if(inicial3==true){
                   contadorespecial=0;
               }inicial3=false;
              
               im.AnalizarImportar(lineas[contadorespecial]);
               System.out.println("el tamano es "+im.matrizImportar.size());
               for (int i = 0; i < im.matrizImportar.size(); i++) {
                   System.out.println("entro aqui en la puta vida mierda");
                   resultado4=im.matrizImportar.get(i);
                   System.out.println("Digitos encontrados "+resultado4);
                   switch(resultado4){
                   
                       case 70:{
                       lex="@";
                        tok=102;
                        reservada="no";
                        nombretok="Arroba";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lexema);
                       }break;
                       case 71:{
                        lex="Blancas";
                        tok=94;
                        reservada="si";
                        nombretok="Color_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                           System.out.println("lexema :"+lexema);
                       }break;
                       case 72:{
                          lex=":";
                        tok=91;
                        reservada="no";
                        nombretok="Dos_puntos";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                         System.out.println("lexema :"+lexema);
                       }break;
                       case 73:{
                        lex="Turno";
                        tok=101;
                        reservada="Si";
                        nombretok="Tab_Pieza";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                          System.out.println("lexema :"+lex); 
                       }break;
                       case 74:{
                          lex=",";
                        tok=12;
                        reservada="no";
                        nombretok="Punto_y_coma";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                            System.out.println("lexema :"+lexema);
                       }break;
                       case 75:{
                        lex="x";
                        tok=20;
                        reservada="no";
                        nombretok="Equis";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                    System.out.println("lexema :"+lex);
                       }break;
                       case 76:{
                        lex="Peon-";
                        tok=5;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                    System.out.println("lexema :"+lex);
                           
                       }break;
                       case 77:{
                       lex="Alfil-";
                        tok=5;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lex);
                           
                       }break;
                       case 78:{
                       lex="Torre-";
                        tok=5;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                            System.out.println("lexema :"+lexema);
                       }break;
                       case 79:{
                       lex="[";
                        tok=104;
                        reservada="no";
                        nombretok="Corchete";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lexema);
                       }break;
                       case 80:{}break;
                       case 81:{
                        lex="Negras";
                        tok=95;
                        reservada="si";
                        nombretok="Color_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                         System.out.println("lexema :"+lex);
                       
                       }break;
                       case 82:{}break;
                       case 83:{
                        lex="O-O:L";
                        tok=10;
                        reservada="si";
                        nombretok="Enroque Largo";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                    System.out.println("lexema :"+lex);
                    }break;
                       case 84:{
                        lex="O-O:C";
                        tok=10;
                        reservada="si";
                        nombretok="Enroque Corto";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lex);
                             System.out.println("lexema :"+lexema);
                           
                       }break;
                       case 85:{
                       
                       
                       }break;
                       case 86:{
                        lex="//";
                        tok=105;
                        reservada="no";
                        nombretok="Diagonal_Doble";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lex);

                       
                       }break;
                       case 87:{
                        lex="JaqueMate";
                        tok=1;
                        reservada="si";
                        nombretok="Final_Partida";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lex);

                       }break;
                       case 88:{
                       lex="Rey-";
                      tok=5;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lex);


                       
                       }break;
                       case 89:{
                       
   lex="Dama-";
                        tok=5;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                    System.out.println("lexema :"+lex);
                        System.out.println("lexema :"+lexema);
                       }break;
                       case 90:{
                       lex="Caballo-";
                        tok=5;
                        reservada="si";
                        nombretok="Nombre_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                    System.out.println("lexema :"+lex);
                       }break;
                       
                       
                   }
                   
               }
               
               
               contadorespecial++;
               
           }else if(calculadora==true){
                AFDCalcu c= new AFDCalcu();
                if(inicial2==true){// inicial2 es activado en el modo inicioi tras seleccionar calculadora 
                    contadorespecial=0;// nos sirve unicamente para q cada q se ingrese aqui el contador de lineas no se reinicie en 0
                }  inicial2=false; // para q no se vuelva a poner el contador en cero.
                System.out.println("el contador especiaal "+contadorespecial);
                c.AnalizarCalcu(lineas[contadorespecial]);
                for (int k = 0; k <c.matrizcalcu.size(); k++) {
                    resultado3=c.matrizcalcu.get(k);// del AFD calcu podemos recuperar los caracteres aceptados por el lenguajes
                    
                    switch(resultado3){
                         case 20:{
                        lex="Var";
                        tok=60;
                        reservada="si";
                        nombretok="Tipo";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                             
                        }break;
                        case 21:{
                        lex="Con";
                        tok=61;
                        reservada="si";
                        nombretok="Tipo";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        
                        }break;
                        case 22:{
                        lex="=";
                        tok=2;
                        reservada="no";
                        nombretok="igualdad";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        case 23:{
                        lex="+";
                        tok=85;
                        reservada="no";
                        nombretok="suma";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        
                        }break;
                        case 24:{
                         lex="-";
                        tok=86;
                        reservada="no";
                        nombretok="resta";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        
                        }break;
                        case 25:{
                         lex="*";
                        tok=87;
                        reservada="no";
                        nombretok="multiplicacion";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        case 26:{
                         lex="/";
                        tok=88;
                        reservada="no";
                        nombretok="division";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        
                        }break;
                        case 27:{
                         lex=".";
                        tok=6;
                        reservada="no";
                        nombretok="Punto";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        case 28:{
                         lex=",";
                        tok=12;
                        reservada="no";
                        nombretok="Punto_y_coma";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        case 29:{
                         lex="(";
                        tok=83;
                        reservada="no";
                        nombretok="Parentesis_abierto";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lex);
                        
                        }break;
                        case 30:{
                         lex=")";
                        tok=84;
                        reservada="no";
                         nombretok="Parentesis_Cerrado";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        System.out.println("lexema :"+lex);
                        }break;
                        
                        case 31:{
                         lex="Salir";
                        tok=35;
                        reservada="si";
                         nombretok="j_Salir";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        
                        }break;
                        case 32:{
                         lex=c.letras.poll();
                         tok=9;
                         reservada="no";
                         lexema.add(lex);
                        n_token.add(tok);
                         nombretok="Identificador";
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                      //  c.concatenacion="";
                      contador8++;
                        System.out.println("lexema :"+lex);
                        }break;
                        
                        case 33:{// aca concatenamos o no los digitos que se encuentra en la calculadora
                          if(c.posibilidad==true){
                           contador7=0;
                              System.out.println("yo me active significando que posibilidad es cierta dfsfsdfsdfsdfsdfsdf");
                           }
                            
                         lex=c.digito.poll();
                           // System.out.println("El tamano del contenedor de numeros es "+c.concatenados.size());
                         tok=70;
                         reservada="no";
                         nombretok="Digitos";
                         lexema.add(lex);
                         n_token.add(tok);
                         palabrareservada.add(reservada);
                         nombre_token.add(nombretok);
                         linea.add(contadorespecial);
                            System.out.println("la posibilidad es   "+c.posibilidad);
                       
                      
                           
                           contador7++;
                       
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        case 34:{
                         lex=";";
                        tok=100;
                        reservada="no";
                          nombretok="Punto_y_coma";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        
                        }break;
                        case 35:{
                         lex="Sumar";
                        tok=65;
                        reservada="Si";
                          nombretok="Operador_reservado";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        case 36:{
                        lex="Restar";
                        tok=66;
                        reservada="Si";
                         nombretok="Operador_reservado";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        case 37:{
                        lex="Dividir";
                        tok=67;
                        reservada="Si";
                         nombretok="Operador_reservado";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        case 38:{
                        lex="Multiplicar";
                        tok=68;
                        reservada="Si";
                         nombretok="Operador_reservado";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                         
                        case 39:{
                         lex="-";
                        tok=12;
                        reservada="no";
                         nombretok="Guion";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        
                        System.out.println("lexema :"+lex);
                        }break;
                        
                    }
                }
                contadorespecial++;
           }
           if(abrir==true){
               System.out.println("AWEBOS QUE AQUI SI INGRESARE");
                AFDAbrir a= new AFDAbrir();
               AbrirChess abrirarchivo= new AbrirChess();
                if(inicial==true){
                contadorespecial=0;
                }
                inicial=false;
                System.out.println("el contador especial es "+contadorespecial);
                   
                    String archivoabierto=abrirarchivo.Lector("piez");
                    //System.out.println(archivoabierto);
                     a.AnalizarAbrir(archivoabierto);// referencia a la clase "AFDAbrir"
                   //  for (int i = 0; i < a.matrizabrir.size(); i++) {
                   //System.out.println("el tamano es          "+a.matrizabrir.size());
         for(int i = 0; i < a.matrizabrir.size(); i++){
                int r=a.matrizabrir.get(i);
                    switch(r){
                        case 39:{
                        lex="O-O:C";
                        tok=101;
                        reservada="si";
                        nombretok="Enroque Corto";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                        System.out.println("lexema :"+lex);
                             
                             
                             }break;
                        case 40:{
                        lex=a.nombre_jugador.poll();
                        tok=200;
                        reservada="no";
                        nombretok="Nombre_jugador";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                        System.out.println("lexema :"+lex);
                             
                             }break;
                             case 41:{
                             lex="O-O:L";
                        tok=11;
                        reservada="si";
                        nombretok="Enroque Largo";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                    System.out.println("lexema :"+lex);
                             }break;
                             case 42:{
                             lex="Jugadores";
                        tok=90;
                        reservada="si";
                        nombretok="jugadores";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                        System.out.println("lexema :"+lex);
                   }break;
                        case 43:{
                             lex=":";
                        tok=91;
                        reservada="no";
                        nombretok="Dos_puntos";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                    System.out.println("lexema :"+lex);
                             }break;
                             case 44:{
                             lex="{";
                        tok=92;
                        reservada="no";
                        nombretok="Corchete";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                    System.out.println("lexema :"+lex);
                             }break;
                             case 45:{
                             lex="}";
                        tok=93;
                        reservada="no";
                        nombretok="Corchete";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                        System.out.println("lexema :"+lex);
                   }break;
                             case 46:{
                        lex="Blancas";
                        tok=94;
                        reservada="si";
                        nombretok="Color_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                        System.out.println("lexema :"+lex);
                  }break;
                             case 47:{
                        lex="Negras";
                        tok=95;
                        reservada="si";
                        nombretok="Color_pieza";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                         System.out.println("lexema :"+lex);
                     }break;
                             case 48:{
                             lex=",";
                        tok=201;
                        reservada="no";
                        nombretok="Punto_y_coma";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                         System.out.println("lexema :"+lex);
                     }break;
                             case 49:{
                             lex="Tablero";
                        tok=96;
                        reservada="si";
                        nombretok="PR_tablero";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                         System.out.println("lexema :"+lex);
                      }break;
                             case 50:{
                             lex="nombre";
                        tok=97;
                        reservada="si";
                        nombretok="PR_nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                         System.out.println("lexema :"+lex);
                      }break;
                             case 51:{
                             lex="Posicion";
                        tok=98;
                        reservada="SI";
                        nombretok="pos_tab";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                         System.out.println("lexema :"+lex);
                      }break;
                             case 52:{
                             lex="Pieza";
                        tok=99;
                        reservada="Si";
                        nombretok="Tab_Pieza";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                         System.out.println("lexema :"+lex);
                    }break;
                             case 53:{
                             lex="Movimientos";
                        tok=102;
                        reservada="Si";
                        nombretok="Tab_movimientos";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                              System.out.println("lexema :"+lex);
                             
                        }break;
                             case 54:{
                             lex="Turno";
                        tok=104;
                        reservada="Si";
                        nombretok="Tab_Pieza";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex);    
                             }break;
                             
                            case 55:{
                             lex="Peon";
                        tok=6;
                        reservada="Si";
                        nombretok="nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex); 
                       }break;
                             case 56:{
                             lex="Caballo";
                        tok=5;
                        reservada="Si";
                        nombretok="nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex); 
                             
                             }break;
                             case 57:{
                             lex="Torre";
                        tok=10;
                        reservada="Si";
                        nombretok="nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex); 
                      }break;
                             case 58:{
                             lex="Alfil";
                        tok=7;
                        reservada="Si";
                        nombretok="nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex); 
                      }break;
                             case 59:{
                             lex="Dama";
                        tok=8;
                        reservada="Si";
                        nombretok="nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex); 
                      }break;
                             case 60:{
                             lex="Rey";
                        tok=9;
                        reservada="Si";
                        nombretok="nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex); 
                     }break;
                             case 61:{
                             lex="x";
                        tok=20;
                        reservada="Si";
                        nombretok="nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex); 
                      }break;
                       case 62:{
                             lex=a.numeros.poll();
                        tok=107;
                        reservada="Si";
                        nombretok="nombre";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex); 
                       }break;
                             
                             case 63:{
                              lex="-";
                        tok=12;
                        reservada="no";
                        nombretok="guion";
                        lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                          System.out.println("lexema :"+lex);
                             
                             }break;
                             
                         case 64:{
                                 // se debe agregar un lexema
                        lex=a.jugadas.poll();
                        tok=15;
                        pila.add(tok);
                        reservada="no";
                        nombretok="Pos_jugada";
                         lexema.add(lex);
                        n_token.add(tok);
                        palabrareservada.add(reservada);
                        nombre_token.add(nombretok);
                        linea.add(contadorespecial);
                        tokensdeabrir.add(tok);
                        System.out.println("lexema :"+lex);
                             }break;
                             
                             
                             
                         }// cierre de switch (r)
                     } //cierre de ciclo for
                    // contadorespecial++;
                    SintacticoAbrir AnalisisSintactico= new SintacticoAbrir();// hacemos referencia a la clase "SINTACTICO ABRIR"
                    while(!tokensdeabrir.isEmpty()){
                    
                      AnalisisSintactico.pila.add(tokensdeabrir.poll());// extraemos todos los tokens de esta clase referentes a abrir
                                                                        // y los enviamos a la clase sintactico abrir para analisis
                    } 
                    AnalisisSintactico.abrir();
                    
           }
        }
          
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
       Simbolos simb= new Simbolos();
       if(evt.getButton()==1){
        simb.simbolosytokens();
       }
    }//GEN-LAST:event_jMenu3MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel b1;
    private javax.swing.JLabel b2;
    private javax.swing.JLabel b3;
    private javax.swing.JLabel b4;
    private javax.swing.JLabel b5;
    private javax.swing.JLabel b6;
    private javax.swing.JLabel b7;
    private javax.swing.JLabel b8;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel c7;
    private javax.swing.JLabel c8;
    private javax.swing.JLabel d1;
    private javax.swing.JLabel d2;
    private javax.swing.JLabel d3;
    private javax.swing.JLabel d4;
    private javax.swing.JLabel d5;
    private javax.swing.JLabel d6;
    private javax.swing.JLabel d7;
    private javax.swing.JLabel d8;
    private javax.swing.JLabel e1;
    private javax.swing.JLabel e2;
    private javax.swing.JLabel e3;
    private javax.swing.JLabel e4;
    private javax.swing.JLabel e5;
    private javax.swing.JLabel e6;
    private javax.swing.JLabel e7;
    private javax.swing.JLabel e8;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel f4;
    private javax.swing.JLabel f5;
    private javax.swing.JLabel f6;
    private javax.swing.JLabel f7;
    private javax.swing.JLabel f8;
    private javax.swing.JLabel g1;
    private javax.swing.JLabel g2;
    private javax.swing.JLabel g3;
    private javax.swing.JLabel g4;
    private javax.swing.JLabel g5;
    private javax.swing.JLabel g6;
    public javax.swing.JLabel g7;
    private javax.swing.JLabel g8;
    private javax.swing.JLabel h1;
    private javax.swing.JLabel h2;
    private javax.swing.JLabel h3;
    private javax.swing.JLabel h4;
    private javax.swing.JLabel h5;
    private javax.swing.JLabel h6;
    public static javax.swing.JLabel h7;
    public static javax.swing.JLabel h8;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    public static javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
