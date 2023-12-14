/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Actividades;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class EliminarActividad extends javax.swing.JFrame {

    PanelPropietario sParent;
    jPanelListadoActividades parent;
    Actividades actividad;
    public EliminarActividad() {
        
    }

    EliminarActividad(PanelPropietario sParent, jPanelListadoActividades parent, Actividades actividad) {
        initComponents();
        
        this.sParent = sParent;
        this.parent = parent;
        this.actividad = actividad;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());;
        setResizable(false);
        this.setTitle("Eliminar Actividad");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("¿Desea eliminar esta actividad?");

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
        this.sParent.setEnabled(true);
        this.sParent.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        if(actividad.getTipo() == 1){
            
            try {
            
                SocketHandler.getOut().println(Mensajes.PETICION_ELIMINAR_ACTIVIDAD_UNICA + "--" + actividad.getId());
                
                String received = "";
                String flag ="";
                String [] args;
                
                received = SocketHandler.getIn().readLine();
                args = received.split("--");
                flag = args[0];
                
                if(flag.equals(Mensajes.PETICION_ELIMINAR_ACTIVIDAD_UNICA_CORRECTO)){
                    this.dispose();
                    this.sParent.setEnabled(true);
                    this.sParent.setVisible(true);
                    this.parent.ObtenerActividades();                          
                }
                if(flag.equals(Mensajes.PETICION_ELIMINAR_ACTIVIDAD_UNICA_ERROR)){
                    JOptionPane.showMessageDialog(sParent, "Se ha producido un error y no se ha eliminado la actividad \n Intentelo más tarde", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                    this.sParent.setVisible(true);
                    this.sParent.setEnabled(true);
                    this.dispose();
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(EliminarActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else {
        
            try {
            
                SocketHandler.getOut().println(Mensajes.PETICION_ELIMINAR_ACTIVIDAD_PLANIFICADA + "--" + actividad.getId());
                
                String received = "";
                String flag ="";
                String [] args;
                
                received = SocketHandler.getIn().readLine();
                args = received.split("--");
                flag = args[0];
                
                if(flag.equals(Mensajes.PETICION_ELIMINAR_ACTIVIDAD_PLANIFICADA_CORRECTO)){
                    this.dispose();
                    this.sParent.setEnabled(true);
                    this.sParent.setVisible(true);
                    this.parent.ObtenerActividades();                          
                }
                if(flag.equals(Mensajes.PETICION_ELIMINAR_ACTIVIDAD_PLANIFICADA_ERROR)){
                    JOptionPane.showMessageDialog(sParent, "Se ha producido un error y no se ha eliminado la actividad \n Intentelo más tarde", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                    this.sParent.setVisible(true);
                    this.sParent.setEnabled(true);
                    this.dispose();
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(EliminarActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        
        
        
    }//GEN-LAST:event_jButtonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarActividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}