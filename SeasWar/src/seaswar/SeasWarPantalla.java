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
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jennifer
 */
public class SeasWarPantalla extends javax.swing.JFrame {
    Jugador jugadorActual=new Jugador(); //NO PUEDE QUEDARSE ASI, TIENE QUE SETEAR EL JUGADOR. 
    CommandManager manager = CommandManager.getIntance();
    Cliente refCliente;
    /**
     * Creates new form f
     */
    public SeasWarPantalla() {
        initComponents();
    }
    
    

    public void setRefCliente(Cliente refCliente) {
        this.refCliente = refCliente;
    }

    
    public void addMensaje(String msj)
    {
        txtArea_Command.append(msj + "\n");
    }  
    
    public void convertMatrixToGUI(Jugador jugadorActual, int color1, Luchador luchador1, int color2, Luchador luchador2, int color3, Luchador luchador3) {
    int cantidad1 = (color1*600)/100; //GRIS - 180
    int cantidad2 = (color2*600)/100; //AZUL - 240
    int cantidad3 = (color3*600)/100; //VERDE - 180
    int cont1 = 0;
    int cont2 = 0;
    int cont3 = 0;
    
    String [][]matrix = new String[21][31];
    Casilla [][]casillas = new Casilla[21][31];
    JButton [][]butt = new JButton[21][31];
    JLabel [][]lbl = new JLabel[21][31];
    
    
    panelMatriz.setLayout(new GridLayout(21, 31));
    

    for(int r=0; r<=20; r++){
        for(int c=0; c<=30; ){
            Font fuente = new Font("Calibri", 3, 4);
            butt[r][c] = new JButton(matrix[r][c]);
            butt[r][c].setPreferredSize(new Dimension(25, 25));
            butt[r][c].setFont(fuente);
            casillas[r][c] = new Casilla("","blanco",null,butt[r][c],r,c);
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
                            butt[r][c].setBackground(Color.LIGHT_GRAY); //String historialAtaques, Luchador luchadorRepresentado, Button refBoton, int x, int y
                            casillas[r][c].setLuchadorRepresentado(luchador1);
                            casillas[r][c].setColor("gris");
                            panelMatriz.add(butt[r][c]);
                            cont1+=1;
                            c++;
                            continue;
                        }else{
                            continue;
                        }
                    case 2:
                        if (cont2<cantidad2){
                            butt[r][c].setBackground(Color.BLUE);
                            casillas[r][c].setLuchadorRepresentado(luchador2);
                            casillas[r][c].setColor("azul");
                            panelMatriz.add(butt[r][c]);
                            cont2+=1;
                            c++;
                            continue;
                        }else{
                            continue;
                        }
                    default:
                        if (cont3<cantidad3){
                            butt[r][c].setBackground(Color.GREEN);
                            casillas[r][c].setLuchadorRepresentado(luchador3);
                            casillas[r][c].setColor("verde");
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
    
    
    pack();
    setVisible(true);
    jugadorActual.setMatrizCasillas(casillas);
    
    for(int r=0; r < casillas.length; r++){
        for(int c=0; c<casillas[r].length; c++){
            System.out.println(casillas[r][c].getColor()+" - X: "+casillas[r][c].getX()+" - Y: "+casillas[r][c].getY());
        }
    }
   
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_Escribir = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_Command = new javax.swing.JTextArea();
        btn_Instrucciones = new javax.swing.JButton();
        btn_Enviar = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setPreferredSize(new java.awt.Dimension(775, 105));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel3.setPreferredSize(new java.awt.Dimension(247, 329));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.setPreferredSize(new java.awt.Dimension(247, 331));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
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
        jScrollPane1.setViewportView(txtArea_Escribir);

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

        btn_Instrucciones.setText("Instrucciones");
        btn_Instrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InstruccionesActionPerformed(evt);
            }
        });

        btn_Enviar.setText("Enviar");
        btn_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Instrucciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Enviar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(343, 343, 343))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Instrucciones)
                        .addComponent(btn_Enviar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        panelMatriz.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_InstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InstruccionesActionPerformed
        String commandName=txtArea_Escribir.getText();    
        ICommand command=manager.getCommand(commandName);   
        command.mostrarPantalla(this);
        txtArea_Escribir.setText("");
    }//GEN-LAST:event_btn_InstruccionesActionPerformed

    private void btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnviarActionPerformed
        // TODO add your handling code here:
        String datosTxt=txtArea_Escribir.getText();
        String[] datos= datosTxt.split("-");
        String commandName=datos[0];    
        ICommand command=manager.getCommand(commandName);   
        command.execute(datos,this,jugadorActual);
        txtArea_Escribir.setText("");
    }//GEN-LAST:event_btn_EnviarActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeasWarPantalla().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Enviar;
    public javax.swing.JButton btn_Instrucciones;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPanel panelMatriz;
    public javax.swing.JTextArea txtArea_Command;
    public javax.swing.JTextArea txtArea_Escribir;
    // End of variables declaration//GEN-END:variables
}
