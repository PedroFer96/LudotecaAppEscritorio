/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class AñadirTipo extends javax.swing.JFrame {

    ConfigurarTiposActividades parent;
    int idLudotca = -1;
    int idTipo = -1;
    
    ArrayList<String> listaNombreCategoria = new ArrayList();
    ArrayList<String> listaIdCategoria = new ArrayList();
    
    int jComboIdCategoriaSeleccionado = 0;

    public AñadirTipo() {        
    }

    AñadirTipo(ConfigurarTiposActividades parent, int idLudoteca) {
        
        initComponents();
        this.parent = parent;
        this.idLudotca = idLudoteca;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());;
        setResizable(false);
        this.setTitle("Añadir tipo actividad");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        
        ObtenerCategorias();
    }
    
    AñadirTipo(ConfigurarTiposActividades parent,int idLudoteca, String idTipo){
        initComponents();
        this.parent = parent;
        this.idLudotca = idLudoteca;
        this.idTipo = Integer.parseInt(idTipo);
        
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());;
        setResizable(false);
        this.setTitle("Editar tipo actividad");
        this.jBAceptar.setText("Actualizar");
        this.jLabel1.setText("Editar Tipo de actualidad");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        
        ObtenerCategorias();
        
        ObtenerTipoId();
        
        
        
    }

    private void ObtenerTipoId() {
    
        try {
            
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_TIPO + "--" + idTipo);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            System.out.println(received);
            jTFNombreActividad.setText(args[1]);
            jSpinnerPrecio.setValue(Integer.parseInt(args[2]));
            
            String nombreTipo = args[3];
            jCBCategorias.setSelectedItem(nombreTipo);
            jComboIdCategoriaSeleccionado = jCBCategorias.getSelectedIndex();
            
            
        } catch (IOException ex) {
            Logger.getLogger(AñadirTipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ObtenerCategorias() {
        
        try{
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_CATEGORIAS);
            
            String received = SocketHandler.getIn().readLine();

            String [] args = received.split("--");
            
            int nCategorias = Integer.parseInt(args[1]);
            
            for(int i = 0; i < nCategorias; i++) {
                received = SocketHandler.getIn().readLine();
                args  = received.split("--");
                 
                listaIdCategoria.add(args[1]);
                
                listaNombreCategoria.add(args[2]);
                
                jCBCategorias.addItem(args[2]);
                 
            }
        
        } catch (IOException ex) {
            Logger.getLogger(AñadirTipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNombreActividad = new javax.swing.JTextField();
        jSpinnerPrecio = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jCBCategorias = new javax.swing.JComboBox<>();
        jBAceptar = new javax.swing.JButton();
        jLabelAtras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Añadir nuevo tipo de actividad");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Precio:");

        jTFNombreActividad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jSpinnerPrecio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Categoria:");

        jCBCategorias.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jCBCategorias.setMaximumRowCount(20);
        jCBCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCategoriasItemStateChanged(evt);
            }
        });

        jBAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAtras)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTFNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSpinnerPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jCBCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
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
        this.parent.setEnabled(true);

    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed

        //añadir Correcion de errores 

        if(Integer.parseInt(jSpinnerPrecio.getValue().toString()) < 1 ){
            JOptionPane.showMessageDialog(this, "El precio no puede ser inferior a 1");
        } else{

            if( idTipo != -1){

                System.out.println("parte actualizar");

                try{
                    String received ="";

                    SocketHandler.getOut().println(Mensajes.PETICION_UPDATE_TIPO_ACTIVIDAD + "--" + jTFNombreActividad.getText() + "--" + jSpinnerPrecio.getValue() + "--" + listaIdCategoria.get(jComboIdCategoriaSeleccionado) + "--" + idTipo);

                    received = SocketHandler.getIn().readLine();

                    if(received.equals(Mensajes.PETICION_UPDATE_TIPO_ACTIVIDAD_CORRECTO)){
                        JOptionPane.showMessageDialog(parent, "Tipo actividad Actualizada");
                        this.dispose();
                        parent.setEnabled(true);
                        parent.ObtenerTipos();
                    }
                    if(received.equals(Mensajes.PETICION_UPDATE_TIPO_ACTIVIDAD_ERROR)){
                        JOptionPane.showMessageDialog(this, "Se ha producido un error \nIntentelo mas tarde");
                    }

                } catch (IOException ex) {
                    Logger.getLogger(AñadirTipo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {        
                System.out.println(" crear nuevo tipo actividad");

                try {

                    String received = "";

                    SocketHandler.getOut().println(Mensajes.PETICION_CREAR_NUEVO_TIPO_ACTIVIDAD + "--" + jTFNombreActividad.getText() + "--" + jSpinnerPrecio.getValue() + "--" + listaIdCategoria.get(jComboIdCategoriaSeleccionado) + "--" + idLudotca);

                    received = SocketHandler.getIn().readLine();

                    if(received.equals(Mensajes.PETICION_CREAR_NUEVO_TIPO_ACTIVIDAD_CORRECTO)){
                        JOptionPane.showMessageDialog(parent, "Tipo actividad Creada");
                        this.dispose();
                        parent.setEnabled(true);
                        parent.ObtenerTipos();
                    }
                    if(received.equals(Mensajes.PETICION_CREAR_NUEVO_TIPO_ACTIVIDAD_ERROR)){
                       JOptionPane.showMessageDialog(this, "Se ha producido un error \nIntentelo mas tarde");
                    }


                } catch (IOException ex) {
                    Logger.getLogger(AñadirTipo.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        }

        
        
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void jCBCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCategoriasItemStateChanged
        this.jComboIdCategoriaSeleccionado = jCBCategorias.getSelectedIndex();
    }//GEN-LAST:event_jCBCategoriasItemStateChanged

    
    
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
            java.util.logging.Logger.getLogger(AñadirTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirTipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JComboBox<String> jCBCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerPrecio;
    private javax.swing.JTextField jTFNombreActividad;
    // End of variables declaration//GEN-END:variables


}
