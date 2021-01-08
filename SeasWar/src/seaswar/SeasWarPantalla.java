/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaswar;

import Cliente.Cliente;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author monic
 */
public class SeasWarPantalla extends javax.swing.JFrame {

    /**
     * Creates new form SeasWarPantalla
     */
    public SeasWarPantalla() {
        initComponents();
    }
    Cliente refCliente;
    

    public void setRefCliente(Cliente refCliente) {
        this.refCliente = refCliente;
    }

    
    public void addMensaje(String msj)
    {
        txtArea.append(msj + "\n");
    }  
    /**
     * Creates new form ClientForm
     */
  


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Fondo = new javax.swing.JPanel();
        panel_Juego = new javax.swing.JPanel();
        panel_Chat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btn_Enviar = new javax.swing.JButton();
        txtField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Fondo.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panel_JuegoLayout = new javax.swing.GroupLayout(panel_Juego);
        panel_Juego.setLayout(panel_JuegoLayout);
        panel_JuegoLayout.setHorizontalGroup(
            panel_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        panel_JuegoLayout.setVerticalGroup(
            panel_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btn_Enviar.setText("Enviar");
        btn_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ChatLayout = new javax.swing.GroupLayout(panel_Chat);
        panel_Chat.setLayout(panel_ChatLayout);
        panel_ChatLayout.setHorizontalGroup(
            panel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panel_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Enviar)
                .addGap(51, 51, 51))
        );
        panel_ChatLayout.setVerticalGroup(
            panel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ChatLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtField))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_FondoLayout = new javax.swing.GroupLayout(panel_Fondo);
        panel_Fondo.setLayout(panel_FondoLayout);
        panel_FondoLayout.setHorizontalGroup(
            panel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_FondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panel_Chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_FondoLayout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(panel_Juego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );
        panel_FondoLayout.setVerticalGroup(
            panel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_FondoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(panel_Juego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_Chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panel_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnviarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            if (txtField.getText().trim().equals(""))
                JOptionPane.showMessageDialog(this, "Sin mensaje para enviar");
            else{
            
                refCliente.hiloCliente.writer.writeInt(2);
                refCliente.hiloCliente.writer.writeUTF(txtField.getText());
                txtField.setText("");
            }
        } catch (IOException ex) {
            
        }
        
        
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeasWarPantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Enviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_Chat;
    private javax.swing.JPanel panel_Fondo;
    private javax.swing.JPanel panel_Juego;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables
}
