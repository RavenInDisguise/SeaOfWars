/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaswar;

import Cliente.Cliente;
import Command.CommandManager;
import Command.CrearPersonajeCommand;
import Command.ICommand;
import Logica.Jugador;
import Logica.Casilla;
import Logica.Luchador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jennifer
 */
public class SeasWarPantalla extends javax.swing.JFrame {
    int contadorPersonajes=0;
    Cliente refCliente;
    String [][]matrix = new String[21][31];
    JButton [][]butt = new JButton[21][31];
    JLabel [][]lbl = new JLabel[21][31];
    
    
    /**
     * Creates new form f
     */
    public SeasWarPantalla() {
        initComponents();
        convertirMatrizGUI();
    }
    
    public void setRefCliente(Cliente refCliente) {
        this.refCliente = refCliente;
    }
   
    public void enviarMensaje(){
        String datosTxt=txtArea_Escribir.getText();
        String datos[];
        datos=splitText(datosTxt);
        if(datos.length>1){
            try {
                 refCliente.hiloCliente.writer.writeInt(7);
                 refCliente.hiloCliente.writer.writeUTF(datosTxt);
                } catch (IOException ex) {
                    Logger.getLogger(SeasWarPantalla.class.getName()).log(Level.SEVERE, null, ex);
                }

            txtArea_Escribir.setText("");
        }else{
            mostrarInstrucciones(); 
        }
    }
    
    public void addMensaje(String msj){
        txtArea_Command.append(msj + "\n");
    }  
    
    public void addBitacora(String msj){
        txArea_bitacora.append(msj + "\n");
    }  
    
    public void convertirMatrizGUI() {
    
    panelMatriz.setLayout(new GridLayout(21, 31));
    int cantidad1 = (30*600)/100; //GRIS - 180
    int cantidad2 = (20*600)/100; //AZUL - 240
    int cantidad3 = (50*600)/100; //VERDE - 180
    int cont1 = 0;
    int cont2 = 0;
    int cont3 = 0;

    panelMatriz.setLayout(new GridLayout(21, 31));
    
    for(int r=0; r<=20; r++){
        for(int c=0; c<=30; ){
            Font fuente = new Font("Calibri", 3, 4);
            butt[r][c] = new JButton(matrix[r][c]);
            butt[r][c].setPreferredSize(new Dimension(25, 25));
            butt[r][c].setFont(fuente);
            if (r==0 && c==0){
                lbl[r][c] = new JLabel(matrix[r][c]);
                lbl[r][c].setPreferredSize(new Dimension(25, 25));
                lbl[r][c].setBackground(Color.WHITE);
                panelMatriz.add(lbl[r][c]);
                c++;
            }
            else if (r==0){
                lbl[r][c] = new JLabel(matrix[r][c]);
                lbl[r][c].setPreferredSize(new Dimension(25, 25));
                lbl[r][c].setBackground(Color.WHITE);
                lbl[r][c].setText(""+c);
                panelMatriz.add(lbl[r][c]);
                c++;
            }
            else if (c==0){
                lbl[r][c] = new JLabel(matrix[r][c]);
                lbl[r][c].setPreferredSize(new Dimension(25, 25));
                lbl[r][c].setBackground(Color.WHITE);
                lbl[r][c].setText(""+r);
                panelMatriz.add(lbl[r][c]);
                c++;
            }else{
                int caso = (int) (Math.random() * 3) + 1;
                switch (caso) {
                    case 1:
                        if (cont1<cantidad1){
                            butt[r][c].setBackground(Color.WHITE);
                            panelMatriz.add(butt[r][c]);
                            cont1+=1;
                            c++;
                            continue;
                        }else{
                            continue;
                        }
                    case 2:
                        if (cont2<cantidad2){
                            butt[r][c].setBackground(Color.WHITE);
                            panelMatriz.add(butt[r][c]);
                            cont2+=1;
                            c++;
                            continue;
                        }else{
                            continue;
                        }
                    default:
                        if (cont3<cantidad3){
                            butt[r][c].setBackground(Color.WHITE);
                            panelMatriz.add(butt[r][c]);
                            cont3+=1;
                            c++;
                            continue;
                        }else{
                            continue;
                        }
                        
                }
            }
        }
    }  
   }
    
    public void pintarMatriz(int i, int j, String color){
         if(color.equals("gris")){
            butt[i+1][j+1].setBackground(Color.DARK_GRAY);
        }else if(color.equals("verde")){
            butt[i+1][j+1].setBackground(Color.GREEN);
        }else if(color.equals("azul")){
            butt[i+1][j+1].setBackground(Color.BLUE);
        }
    }
    public void rellenarLabelsLuchadores(int pos, String nombreLuchador1, int totales1, int vivas1){
         int destruida1=0;
         int porcentaje1=0;
        switch(pos){
            case 0:
                //Luchador 1
               lbl_nombrePersonaje1.setText(nombreLuchador1);
               destruida1=totales1-vivas1;
               lbl_casillasDest1.setText(destruida1+" de "+totales1);
               porcentaje1=(vivas1/totales1)*100;
               lbl_vida1.setText("Porcentaje: "+Integer.toString(porcentaje1));
            break;    
            case 1:
                 //Luchador 2
                lbl_nombrePersonaje2.setText(nombreLuchador1);
                destruida1=totales1-vivas1; 
                lbl_casillasDest2.setText(destruida1+" de "+totales1);
                porcentaje1=(vivas1/totales1)*100;
                lbl_vida2.setText("Porcentaje: "+Integer.toString(porcentaje1));
            break;    
            case 2:
                //Luchador 3
                lbl_nombrePersonaje3.setText(nombreLuchador1);
                destruida1=totales1-vivas1;
                lbl_casillasDest3.setText(destruida1+" de "+totales1);
                porcentaje1=(vivas1/totales1)*100;
                lbl_vida3.setText("Porcentaje: "+Integer.toString(porcentaje1));
            break;    
            default:
        }
       
       
        
    }
    
    public String[] splitText(String datostxt){
        String[] datos= datostxt.split("-");
        return datos;
    }
    
    void generarPersonajes(String[] datos){
        System.out.println(contadorPersonajes);
        switch (contadorPersonajes) {
            case 1:
                generarPersonaje1Pantalla(datos);
            break;
            case 2:
                generarPersonaje2Pantalla(datos);
            break;
            case 3:
                generarPersonaje3Pantalla(datos);
                try {
                    refCliente.hiloCliente.writer.writeInt(5);
                    refCliente.hiloCliente.writer.writeInt(6);
                } catch (IOException ex) {
                    Logger.getLogger(SeasWarPantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            break;    
            default:
               txArea_bitacora.append("Ya agregó 3 personajes.");

        }
    }
        
    void generarPersonaje1Pantalla(String[] datos){
        /*
        String nombreLuchador; 1
        String Grupo; 2
        int porcentajeCivilizacion; 3
        int poderLuchador; 4
        int resistenciaLuchador; 5
        int SanidadLuchador; 6
        String rutaImagen; 7
        */
        txt_nombrePersonaje1.setText(datos[1]);
        //txt_nombrePersonaje1.setHorizontalAlignment(SwingConstants.CENTER);
        txt_ataque1.setText(datos[2]);
        //txt_ataque1.setHorizontalAlignment(SwingConstants.CENTER);
        txt_valor1.setText(datos[3]);
        //txt_valor1.setHorizontalAlignment(SwingConstants.CENTER);
        txt_poder1.setText("Poder: "+datos[4]);
        txt_resistencia1.setText("Resistencia: "+datos[5]);
        txt_sanidad1.setText("Sanidad: "+datos[6]);
        System.out.println(datos[7]);
        //Display image on jlable
        ImageIcon ii = new ImageIcon(datos[7]);
        //            Resize image to fit jlabel

        Image image = ii.getImage().getScaledInstance(lbl_imagen1.getWidth(), lbl_imagen1.getHeight(), Image.SCALE_SMOOTH);

        lbl_imagen1.setIcon(new ImageIcon(image));
    }
    
    void generarPersonaje2Pantalla(String[] datos){
        txt_nombrePersonaje2.setText(datos[1]);
        txt_ataque2.setText(datos[2]);
        txt_valor2.setText(datos[3]);
        txt_poder2.setText("Poder: "+datos[4]);
        txt_resistencia2.setText("Resistencia: "+datos[5]);
        txt_sanidad2.setText("Sanidad: "+datos[6]);
        //Display image on jlable2
        ImageIcon ii = new ImageIcon(datos[7]);
        //            Resize image to fit jlabel

        Image image = ii.getImage().getScaledInstance(lbl_imagen2.getWidth(), lbl_imagen2.getHeight(), Image.SCALE_SMOOTH);

        lbl_imagen2.setIcon(new ImageIcon(image));
        
    }
    
    void generarPersonaje3Pantalla(String[] datos){
        txt_nombrePersonaje3.setText(datos[1]);
        txt_ataque3.setText(datos[2]);
        txt_valor3.setText(datos[3]);
        txt_poder3.setText("Poder: "+datos[4]);
        txt_resistencia3.setText("Resistencia: "+datos[5]);
        txt_sanidad3.setText("Sanidad: "+datos[6]);
        //Display image on jlable
        System.out.println(datos[7].trim());
        ImageIcon ii = new ImageIcon(datos[7].trim());
        //            Resize image to fit jlabel

        Image image = ii.getImage().getScaledInstance(lbl_imagen3.getWidth(), lbl_imagen3.getHeight(), Image.SCALE_SMOOTH);

        lbl_imagen3.setIcon(new ImageIcon(image));
    }
    
    public void crearPersonajes(String datos[]){
        String datosTxt=txtArea_Escribir.getText();
        if(datos.length>1){
            contadorPersonajes++;
            if(contadorPersonajes<4){
                try {
                    refCliente.hiloCliente.writer.writeInt(4);
                    refCliente.hiloCliente.writer.writeUTF(datosTxt);
                } catch (IOException ex) {
                    Logger.getLogger(SeasWarPantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            generarPersonajes(datos);
            txtArea_Escribir.setText("");
        }else{
            mostrarInstrucciones(); 
        }
    }
    public void verificarListo(String datosTxt){
        try {
            //refCliente.hiloCliente.writer.writeInt(8);
            refCliente.hiloCliente.writer.writeInt(8); //Hay que comentar esta línea en generarPersonajes()
            refCliente.hiloCliente.writer.writeUTF(datosTxt);
        } catch (IOException ex) {
            Logger.getLogger(SeasWarPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void mostrarInstrucciones(){
        String commandName=txtArea_Escribir.getText(); 
        try {
            refCliente.hiloCliente.writer.writeInt(3);
            refCliente.hiloCliente.writer.writeUTF(commandName);
        } catch (IOException ex) {
            Logger.getLogger(SeasWarPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        txtArea_Escribir.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_imagen1 = new javax.swing.JLabel();
        txt_valor1 = new javax.swing.JLabel();
        txt_nombrePersonaje1 = new javax.swing.JLabel();
        txt_ataque1 = new javax.swing.JLabel();
        txt_poder1 = new javax.swing.JLabel();
        txt_resistencia1 = new javax.swing.JLabel();
        txt_sanidad1 = new javax.swing.JLabel();
        lbl_imagen2 = new javax.swing.JLabel();
        txt_valor2 = new javax.swing.JLabel();
        txt_nombrePersonaje2 = new javax.swing.JLabel();
        txt_poder2 = new javax.swing.JLabel();
        txt_ataque2 = new javax.swing.JLabel();
        txt_resistencia2 = new javax.swing.JLabel();
        txt_sanidad2 = new javax.swing.JLabel();
        lbl_imagen3 = new javax.swing.JLabel();
        txt_valor3 = new javax.swing.JLabel();
        txt_nombrePersonaje3 = new javax.swing.JLabel();
        txt_poder3 = new javax.swing.JLabel();
        txt_ataque3 = new javax.swing.JLabel();
        txt_resistencia3 = new javax.swing.JLabel();
        txt_sanidad3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_casillasDestGen = new javax.swing.JLabel();
        lbl_vidaGen = new javax.swing.JLabel();
        lbl_vida1 = new javax.swing.JLabel();
        lbl_nombrePersonaje1 = new javax.swing.JLabel();
        lbl_nombrePersonaje3 = new javax.swing.JLabel();
        lbl_nombrePersonaje2 = new javax.swing.JLabel();
        lbl_vida2 = new javax.swing.JLabel();
        lbl_vida3 = new javax.swing.JLabel();
        lbl_casillasDest1 = new javax.swing.JLabel();
        lbl_casillasDest2 = new javax.swing.JLabel();
        lbl_casillasDest3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txArea_bitacora = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_Escribir = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_Command = new javax.swing.JTextArea();
        btn_seleccionarImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setResizable(false);
        setSize(new java.awt.Dimension(1328, 810));

        panelMatriz.setBackground(new java.awt.Color(255, 255, 255));
        panelMatriz.setPreferredSize(new java.awt.Dimension(775, 521));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lbl_imagen1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 2, 3, 2, new java.awt.Color(102, 204, 255)));

        txt_valor1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_valor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_valor1.setText("Porcentaje");
        txt_valor1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_nombrePersonaje1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nombrePersonaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_nombrePersonaje1.setText("Nombre del personaje");
        txt_nombrePersonaje1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_ataque1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ataque1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ataque1.setText("Ataque");
        txt_ataque1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_poder1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_poder1.setText("Poder: ");
        txt_poder1.setBorder(new javax.swing.border.MatteBorder(null));
        txt_poder1.setOpaque(true);

        txt_resistencia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_resistencia1.setText("Resistencia: ");
        txt_resistencia1.setBorder(new javax.swing.border.MatteBorder(null));
        txt_resistencia1.setOpaque(true);

        txt_sanidad1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_sanidad1.setText("Sanidad:");
        txt_sanidad1.setBorder(new javax.swing.border.MatteBorder(null));
        txt_sanidad1.setOpaque(true);

        lbl_imagen2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 2, 3, 2, new java.awt.Color(102, 204, 255)));

        txt_valor2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_valor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_valor2.setText("Porcentaje");

        txt_nombrePersonaje2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nombrePersonaje2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_nombrePersonaje2.setText("Nombre del personaje");
        txt_nombrePersonaje2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_poder2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_poder2.setText("Poder: ");
        txt_poder2.setBorder(new javax.swing.border.MatteBorder(null));
        txt_poder2.setOpaque(true);

        txt_ataque2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ataque2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ataque2.setText("Ataque");
        txt_ataque2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_resistencia2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_resistencia2.setText("Resistencia: ");
        txt_resistencia2.setBorder(new javax.swing.border.MatteBorder(null));
        txt_resistencia2.setOpaque(true);

        txt_sanidad2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_sanidad2.setText("Sanidad:");
        txt_sanidad2.setBorder(new javax.swing.border.MatteBorder(null));
        txt_sanidad2.setOpaque(true);

        lbl_imagen3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 2, 3, 2, new java.awt.Color(102, 204, 255)));

        txt_valor3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_valor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_valor3.setText("Porcentaje");
        txt_valor3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_nombrePersonaje3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nombrePersonaje3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_nombrePersonaje3.setText("Nombre del personaje");
        txt_nombrePersonaje3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_poder3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_poder3.setText("Poder: ");
        txt_poder3.setBorder(new javax.swing.border.MatteBorder(null));
        txt_poder3.setOpaque(true);

        txt_ataque3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ataque3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ataque3.setText("Ataque");
        txt_ataque3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_resistencia3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_resistencia3.setText("Resistencia: ");
        txt_resistencia3.setBorder(new javax.swing.border.MatteBorder(null));
        txt_resistencia3.setOpaque(true);

        txt_sanidad3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_sanidad3.setText("Sanidad:");
        txt_sanidad3.setBorder(new javax.swing.border.MatteBorder(null));
        txt_sanidad3.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txt_valor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombrePersonaje1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_resistencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_poder1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sanidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_ataque1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txt_valor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombrePersonaje2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_resistencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_poder2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sanidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_ataque2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_imagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txt_valor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombrePersonaje3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_resistencia3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_poder3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sanidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_ataque3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_valor1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombrePersonaje1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ataque1)
                        .addGap(1, 1, 1)
                        .addComponent(txt_poder1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_resistencia1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_sanidad1))
                    .addComponent(lbl_imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_valor2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombrePersonaje2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ataque2)
                        .addGap(1, 1, 1)
                        .addComponent(txt_poder2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_resistencia2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_sanidad2))
                    .addComponent(lbl_imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_valor3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombrePersonaje3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ataque3)
                        .addGap(1, 1, 1)
                        .addComponent(txt_poder3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_resistencia3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_sanidad3))
                    .addComponent(lbl_imagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setPreferredSize(new java.awt.Dimension(775, 105));

        lbl_casillasDestGen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_casillasDestGen.setText("Casillas destruidas: ");

        lbl_vidaGen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_vidaGen.setText("Vida: ");

        lbl_vida1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_vida1.setText("Porcentaje: ");

        lbl_nombrePersonaje1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombrePersonaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombrePersonaje1.setText("Nombre del personaje");
        lbl_nombrePersonaje1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_nombrePersonaje3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombrePersonaje3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombrePersonaje3.setText("Nombre del personaje");
        lbl_nombrePersonaje3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_nombrePersonaje2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombrePersonaje2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombrePersonaje2.setText("Nombre del personaje");
        lbl_nombrePersonaje2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_vida2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_vida2.setText("Porcentaje: ");

        lbl_vida3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_vida3.setText("Porcentaje: ");

        lbl_casillasDest1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_casillasDest1.setText("X de X casillas");

        lbl_casillasDest2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_casillasDest2.setText("X de X casillas");

        lbl_casillasDest3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_casillasDest3.setText("X de X casillas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_vidaGen, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_casillasDestGen, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombrePersonaje1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_casillasDest1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_vida1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombrePersonaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_casillasDest3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_vida2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombrePersonaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_casillasDest2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_vida3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_casillasDestGen)
                    .addComponent(lbl_vidaGen))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombrePersonaje3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_nombrePersonaje1)
                        .addComponent(lbl_nombrePersonaje2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_vida1)
                    .addComponent(lbl_vida2)
                    .addComponent(lbl_vida3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_casillasDest1)
                    .addComponent(lbl_casillasDest2)
                    .addComponent(lbl_casillasDest3))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel3.setPreferredSize(new java.awt.Dimension(247, 329));

        txArea_bitacora.setColumns(20);
        txArea_bitacora.setRows(5);
        jScrollPane4.setViewportView(txArea_bitacora);

        jLabel1.setText("Bitácora");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.setPreferredSize(new java.awt.Dimension(247, 331));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel2.setText("Resultados de los ataques");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtArea_Escribir.setBackground(new java.awt.Color(0, 153, 153));
        txtArea_Escribir.setColumns(20);
        txtArea_Escribir.setFont(new java.awt.Font("Adobe Jenson Pro Lt Capt", 1, 18)); // NOI18N
        txtArea_Escribir.setForeground(new java.awt.Color(255, 255, 255));
        txtArea_Escribir.setRows(5);
        txtArea_Escribir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtArea_Escribir.setCaretColor(new java.awt.Color(255, 255, 255));
        txtArea_Escribir.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtArea_Escribir.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtArea_Escribir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArea_EscribirKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtArea_Escribir);

        txtArea_Command.setEditable(false);
        txtArea_Command.setBackground(new java.awt.Color(0, 153, 153));
        txtArea_Command.setColumns(20);
        txtArea_Command.setFont(new java.awt.Font("Adobe Jenson Pro Lt Capt", 1, 18)); // NOI18N
        txtArea_Command.setForeground(new java.awt.Color(255, 255, 255));
        txtArea_Command.setRows(5);
        txtArea_Command.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtArea_Command.setCaretColor(new java.awt.Color(255, 255, 255));
        txtArea_Command.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtArea_Command.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(txtArea_Command);

        btn_seleccionarImagen.setText("Seleccionar Imagen");
        btn_seleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_seleccionarImagen)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_seleccionarImagen))
                .addContainerGap())
        );

        panelMatriz.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarImagenActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & PNG Images", "png", "jpg", "jpeg");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = chooser.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null, selectedImagePath);
            txtArea_Escribir.append(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btn_seleccionarImagenActionPerformed

    private void txtArea_EscribirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArea_EscribirKeyPressed
        // TODO add your handling code here:
        String datosTxt=txtArea_Escribir.getText();
        if(evt.getKeyCode()==10){
            txtArea_Command.append(datosTxt+"\n");
            String datos[]=splitText(datosTxt);
            if(datos[0].trim().equals("CREARPERSONAJE")){
                crearPersonajes(datos);
            }else if(datos[0].trim().equals("MENSAJE")){
                enviarMensaje();
            }else if(datos[0].trim().equals("LISTO")){
                verificarListo(datosTxt);
            }else{
                try {
                    refCliente.hiloCliente.writer.writeInt(4);
                    refCliente.hiloCliente.writer.writeUTF(datosTxt);
                } catch (IOException ex) {
                    Logger.getLogger(SeasWarPantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            txtArea_Escribir.setText("");
        } 
    }//GEN-LAST:event_txtArea_EscribirKeyPressed

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
            java.util.logging.Logger.getLogger(SeasWarPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeasWarPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeasWarPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeasWarPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeasWarPantalla().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_seleccionarImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_casillasDest1;
    private javax.swing.JLabel lbl_casillasDest2;
    private javax.swing.JLabel lbl_casillasDest3;
    private javax.swing.JLabel lbl_casillasDestGen;
    private javax.swing.JLabel lbl_imagen1;
    private javax.swing.JLabel lbl_imagen2;
    private javax.swing.JLabel lbl_imagen3;
    private javax.swing.JLabel lbl_nombrePersonaje1;
    private javax.swing.JLabel lbl_nombrePersonaje2;
    private javax.swing.JLabel lbl_nombrePersonaje3;
    private javax.swing.JLabel lbl_vida1;
    private javax.swing.JLabel lbl_vida2;
    private javax.swing.JLabel lbl_vida3;
    private javax.swing.JLabel lbl_vidaGen;
    public javax.swing.JPanel panelMatriz;
    private javax.swing.JTextArea txArea_bitacora;
    public javax.swing.JTextArea txtArea_Command;
    public javax.swing.JTextArea txtArea_Escribir;
    private javax.swing.JLabel txt_ataque1;
    private javax.swing.JLabel txt_ataque2;
    private javax.swing.JLabel txt_ataque3;
    private javax.swing.JLabel txt_nombrePersonaje1;
    private javax.swing.JLabel txt_nombrePersonaje2;
    private javax.swing.JLabel txt_nombrePersonaje3;
    private javax.swing.JLabel txt_poder1;
    private javax.swing.JLabel txt_poder2;
    private javax.swing.JLabel txt_poder3;
    private javax.swing.JLabel txt_resistencia1;
    private javax.swing.JLabel txt_resistencia2;
    private javax.swing.JLabel txt_resistencia3;
    private javax.swing.JLabel txt_sanidad1;
    private javax.swing.JLabel txt_sanidad2;
    private javax.swing.JLabel txt_sanidad3;
    private javax.swing.JLabel txt_valor1;
    private javax.swing.JLabel txt_valor2;
    private javax.swing.JLabel txt_valor3;
    // End of variables declaration//GEN-END:variables
}
