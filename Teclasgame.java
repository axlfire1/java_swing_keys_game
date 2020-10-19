
//AUTOR
/*************Eleazar David Sarmiento Torres************/

//IMPORTACION DEL PAQUETE SWING (QUE MANEJA TODO LO REFERENTE A FRAMES Y PANELES)
   import javax.swing.*;

    public class Teclasgame extends JFrame {  //PUBLICACION DE LA CLASE
   
       public Teclasgame() {    	
      //VALORES DEL FRAME
      //TAMAÑO EN PIXELES(ANCHO, ALTO)
         setSize(350,200);
      //NO SE PUEDE CAMBIAR EL TAMAÑO DEL FRAME
         setResizable(false);
      //EN LA COORDENADA (X,Y) APARECERA LA ESQUINA SUPERIOR
      //IZQUIERDA DEL FRAME
         setLocation(300,200);
      //TITULO DE LA VENTANA
         setTitle("Autor [David Sarmiento]");
      //POR DEFAULT AL HACER CLICK EN CERRAR, TERMINARA LA APLICACION
         setDefaultCloseOperation(EXIT_ON_CLOSE);        
      
      //SE LE ASIGNA EL TIPO DE ALINEAMIENTO AL
      //CONTENEDOR DEL FRAME Y AL PANEL
         getContentPane().setLayout(null);
         jPanel1.setLayout(null);
      
      //SE LE ASIGNA UN TIPO DE FUENTE Y TAMAÑO
         letra.setFont(new java.awt.Font("Arial", 0, 48));
      //SE ASIGNA UN VALOR INICIAL
         letra.setText("A");
      //SE AGREGA AL PANEL PRINCIPAL
         jPanel1.add(letra);
      //SE ESPECIFICA LOCALIZACION X,Y
      //SE ESPECIFICA TAMAÑO ANCHO,ALTO
         letra.setBounds(130, 30, 70, 70);
      
      //SE ASIGNA UN VALOR INICIAL
         etiqueta.setText("Teclea Esta Letra");
      //SE AGREGA AL PANEL PRINCIPAL
         jPanel1.add(etiqueta);
      //SE ESPECIFICA LOCALIZACION X,Y
      //SE ESPECIFICA TAMAÑO ANCHO,ALTO
         etiqueta.setBounds(10, 60, 100, 16);
      
      //SE ASIGNA UN VALOR INICIAL
         score.setText("Puntaje: 0");
      //SE AGREGA AL PANEL PRINCIPAL
         jPanel1.add(score);
      //SE ESPECIFICA LOCALIZACION X,Y
      //SE ESPECIFICA TAMAÑO ANCHO,ALTO
         score.setBounds(10, 100, 90, 16);
      
      //SE ASIGNA UN VALOR INICIAL
         tiempo.setText("Tiempo: 10");
      //SE AGREGA AL PANEL PRINCIPAL
         jPanel1.add(tiempo);
      //SE ESPECIFICA LOCALIZACION X,Y
      //SE ESPECIFICA TAMAÑO ANCHO,ALTO
         tiempo.setBounds(100, 10, 580, 16);
      
      //SE ASIGNA UN VALOR INICIAL
         campo.setText("A");
      //SE LE ASIGNA UN TIPO DE FUENTE Y TAMAÑO
         campo.setFont(new java.awt.Font("Arial", 0, 18));
      //SE LE AGREGA UN OYENTE AL CAMPO DE TEXTO
         campo.addKeyListener(
                new java.awt.event.KeyAdapter() {
               //EL OYENTE RECIBE LOS EVENTOS DE TODO EL TECLADO
                   public void keyTyped(java.awt.event.KeyEvent evt) {
                  //OBTIENE LA TECLA PRESIONADA Y LA GUARDA EN UNA CADENA				
                     String s = (String) ""+evt.getKeyChar();
                  //SE CONVIERTE LA CADENA EN UN ARREGLO DE CARACTERES
                     char arreglo[] = s.toCharArray();
                  //SE OBTIENE SOLO EL PRIMER ELEMENTO DEL ARREGLO
                     char car = arreglo[0];
                  //SE CONVIERTE EN ENTERO TAL CARACTER
                     int i =(int) car;
                  //SE MUESTRA EN EL CAMPO DE TEXTO 
                     campo.setText(s);
                  //EL NUMERO CORRESPONDIENTE AL ASCII DE LA LETRA TECLEADA
                  //SE GUARDA EN UNA VARIABLE GLOBAL
                     tecla = i;				
                  }
               });
      
      //SE AGREGA UN OYENTE AL FRAME PRINCIPAL
         addWindowListener(
                new java.awt.event.WindowAdapter() {
               //AL PRESIONAR EL BOTON CERRAR DEL FRAME, TERMINARA LA APLICACION
                   public void windowClosing(java.awt.event.WindowEvent evt) {
                     System.exit(0);
                  }
               });
      //AGREGAMOS EL CAMPO DE TEXTO AL PANEL
         jPanel1.add(campo);
      //SE ESPECIFICA LOCALIZACION X,Y
      //SE ESPECIFICA TAMAÑO ANCHO,ALTO
         campo.setBounds(130, 100, 16, 30);
      
      //AGREGAMOS EL PANEL AL CONTENEDOR DEL FRAME
         getContentPane().add(jPanel1);
      //SE ESPECIFICA LOCALIZACION X,Y
      //SE ESPECIFICA TAMAÑO ANCHO,ALTO
         jPanel1.setBounds(20, 20, 490, 130);
        
      //CREAMOS UN HILO Y LE PASAMOS COMO PARAMETRO
      //A ESTA CLASE PARA QUE LO RECIBA EL CONSTRUCTOR
         Hilo t = new Hilo(this);
      //AUTOMATICAMENTE INVOCA AL METODO RUN DE LA CLASE
      //QUE EXTIENDE DE THREAD
         t.start();		
      }
       public static void main(String args[]) {
      //CREAMOS UN FRAME NUEVO Y LO MOSTRAMOS
         Teclasgame t = new Teclasgame();
         t.show();
      }
   
    // DECLARACION DE VARIABLES GLOBALES
      public int puntaje = 0;
      public int energia=50;
      public int velocidad=1000;
   
      public int tecla = 0;
      public int numero = 0;     
   
      public JPanel jPanel1 = new JPanel();
      public JLabel tiempo  = new JLabel();
      public JLabel etiqueta= new JLabel();
      public JLabel score = new JLabel();
      public JTextField campo = new JTextField();
      public JLabel letra = new JLabel();    
   }
//CLASE HILO QUE EXTIENDE DE LA CLASE THREAD
    class Hilo extends Thread{
   //EL CONSTRUCTOR RECIBE UN OBJETO DE LA CLASE TECLASGAME
       public Hilo(Teclasgame tg){
         tgame = tg;
      }
   //CORRE EL PROCESO DEL JUEGO
       public void run(){
      //CONTADOR INTERNO DE NIVELES DE DIFICULTAD
         int contador=0;
      //MANEJO DE EXCEPCIONES
         try{
         //MIENTRAS TENGA ENERGIA CONTINUARA JUGANDO
            while(tgame.energia >= 0){
            //GENERA UN NUMERO ALEATORIO
               tgame.numero = (int) (1+Math.random()*25);
            //LE AUMENTA 65 PUESTO QUE DE A-Z SON LOS ASCII 65 A 90 (25 LETRAS)
               tgame.numero += 65;
            //ASIGNA ESE NUMERO A UN CARACTER
               char c =(char) tgame.numero;
            //ASIGNAMOS EL CARACTER AL LABEL letra ESTE MOSTRARA
            //LA LETRA QUE HAY QUE TECLEAR EN EL JUEGO
               tgame.letra.setText(""+c);
            //SE DARA CIERTO TIEMPO PARA QUE SE TECLEE LA LETRA
            //ESTO TIENE UNA VELOCIDAD VARIABLE DE ACUERDO AL NIVEL DE DIFICULTAD
               for(int i=tgame.velocidad;i>0;i--){
               //MUESTRA AL USUARIO CUANTA ENERGIA TIENE Y
               //QUE TIEMPO LE RESTA PARA TECLEAR LA LETRA
                  tgame.tiempo.setText("Energia: "+tgame.energia+", Tiempo: "+i);
               //REPINTA O ACTUALIZA TODO EL FRAME
                  tgame.repaint();
               //PAUSA EL PROCESO UN MILISEGUNDO
                  sleep(1);
               }
            //SI LA LETRA TECLEADA ES IGUAL
            //A LA LETRA SOLICITADA POR EL JUEGO
               if(tgame.numero == tgame.tecla){
               //EL PUNTAJE AUMENTA 10 PUNTOS
                  tgame.puntaje +=10;
               //EL CONTADOR AUMENTA 10 PUNTOS
                  contador += 10;
               //SINO
               }
               else{
               //EL NIVEL DE ENERGIA DECREMENTA CINCO UNIDADES
                  tgame.energia -= 5;
               }
            //SI EL CONTADOR ES MAYOR O IGUAL A CIEN
               if(contador >= 100){
               //SE REINICIA EL CONTADOR EN CERO
                  contador = 0;
               //DISMINUYE EL TIEMPO DE ESPERA PARA TECLEAR LA LETRA
               //ES DECIR, AUMENTA LA VELOCIDAD O LA DIFICULTAD
                  tgame.velocidad -=200;
               }
            //MUESTRA EL PUNTAJE OBTENIDO HASTA EL MOMENTO
               tgame.score.setText("Puntaje: "+tgame.puntaje);
               tgame.repaint();
            //PAUSA EL PROCESO 10 MILISEGUNDOS
               sleep(10);
            }//SI OCURRE UNA EXCEPCION DESPLIEGA TODA LA INFORMACION AL RESPECTO
         }
             catch(InterruptedException e){e.printStackTrace();}
      //SI YA NO SE TIENE ENERGIA PARA JUGAR
      //SE DESPLIEGA LA INFORMACION DE SALIDA
         tgame.tiempo.setText("Gracias por jugar. Juego Terminado");
      //SE DESABILITA EL CAMPO DE TEXTO Y NO SE PODRA EDITAR 
         tgame.campo.setEditable(false);
      }
   //VARIABLE GLOBAL Y PRIVADA
      private Teclasgame tgame;
   }
