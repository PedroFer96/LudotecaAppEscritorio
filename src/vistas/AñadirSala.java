/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import model.Sala;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class AñadirSala extends javax.swing.JFrame {

    PanelPropietario superParent;
    jPanelSalas parent;
    int idLudoteca = -1;
    Sala sala ;
    
    public AñadirSala() {
        
    }

    AñadirSala(PanelPropietario superParent, jPanelSalas parent, int idLudoteca) {
        
        this.superParent=superParent;
        this.parent=parent;
        this.idLudoteca= idLudoteca;
        
        initComponents();
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }        

//setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Añadir nueva sala");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
        modeloSpinner.setMinimum(0);
        jSpinnerAforo.setModel(modeloSpinner);
        
    }

    AñadirSala(PanelPropietario superParent, jPanelSalas parent, Sala sala) {
        
        this.superParent=superParent;
        this.parent=parent;
        this.sala = sala;
        
        initComponents();
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Editar sala");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        
        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
        modeloSpinner.setMinimum(0);
        jSpinnerAforo.setModel(modeloSpinner);
        
        jLabel1.setText("Editar Sala");
        jButtonAddSala.setText("Actualizar");
        
        jTFNombre.setText(this.sala.getNombre());
        jSpinnerAforo.setValue(sala.getAforo_maximo());
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelAtras = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jButtonAddSala = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerAforo = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Añadir Sala");

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jTFNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonAddSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddSala.setText("Crear");
        jButtonAddSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSalaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre de la Sala:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Aforo máximo:");

        jSpinnerAforo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabelAtras)
                .addGap(148, 148, 148)
                .addComponent(jLabel1)
                .addContainerGap(178, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAddSala, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFNombre)
                            .addComponent(jSpinnerAforo, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerAforo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButtonAddSala, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtrasMouseClicked
        this.dispose();
        this.superParent.setEnabled(true);
    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jButtonAddSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSalaActionPerformed

        if(!jTFNombre.getText().isEmpty() && Integer.parseInt(jSpinnerAforo.getValue().toString()) > 0){
        
            if(idLudoteca == -1){
            
                try{

                    SocketHandler.getOut().println(Mensajes.PETICION_UPDATE_SALA + "--" + sala.getId() + "--" + jTFNombre.getText() + "--" + jSpinnerAforo.getValue().toString());

                    String received ="";

                    received = SocketHandler.getIn().readLine();

                    if(received.equals(Mensajes.PETICION_UPDATE_SALA_CORRECTO)){
                        this.dispose();
                        this.superParent.setEnabled(true);
                        parent.mostrarSalas();
                    }
                    if(received.equals(Mensajes.PETICION_UPDATE_SALA_ERROR)){
                        JOptionPane.showMessageDialog(this, "Error al intentar actualizar la sala \nIntentelo mas tarde");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AñadirSala.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else {
                
                try{
                    SocketHandler.getOut().println(Mensajes.PETICION_CREAR_SALA + "--" + jTFNombre.getText() + "--" + jSpinnerAforo.getValue().toString() + "--" + idLudoteca );

                    String received = "";

                    received = SocketHandler.getIn().readLine();

                    if(received.equals(Mensajes.PETICION_CREAR_SALA_CORRECTO)){
                        this.dispose();
                        this.superParent.setEnabled(true);
                        parent.mostrarSalas();
                    }
                    if(received.equals(Mensajes.PETICION_CREAR_SALA_ERROR)){
                        JOptionPane.showMessageDialog(this, "Error al intentar crear una sala \nIntentelo mas tarde");
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(AñadirSala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Debe introducir un nombre y un aforo superior a 0 personas");
        }
        
    }//GEN-LAST:event_jButtonAddSalaActionPerformed

    
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
            java.util.logging.Logger.getLogger(AñadirSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirSala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerAforo;
    private javax.swing.JTextField jTFNombre;
    // End of variables declaration//GEN-END:variables
}
