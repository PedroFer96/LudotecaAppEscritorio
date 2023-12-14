/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Actividades;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class VisualizarActividadesClientes extends javax.swing.JFrame {

    PanelPropietario sParent;
    PanelEmpleado sParentE;
    
    jPanelListadoActividades parent;
    jPanelListadoActividadesEmpleados parentE;
    Actividades actividades;
    int fila = -1;
    
    ArrayList<String> listaIdClientes = new ArrayList<>();
    
    boolean empleadCliente = false;
    
    public VisualizarActividadesClientes() {
        
    }

    VisualizarActividadesClientes(PanelPropietario sParent, jPanelListadoActividades parent, Actividades actividades) {
        
        initComponents();
    
        this.sParent = sParent;
        this.parent = parent;
        this.actividades = actividades;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());;
        setResizable(false);
        this.setTitle("Vizualizar actividad");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        jLabelActividad.setText(actividades.getHora() + " - " + actividades.getFecha());
        jTableClientes.setDefaultEditor(Object.class, null);
        jTableClientes.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableClientes.getTableHeader().setForeground(Color.BLACK);
        jTableClientes.getTableHeader().setBackground(Color.GREEN);   
        
        
        ObtenerClientes();
        
        
    }

    VisualizarActividadesClientes(PanelEmpleado sParent, jPanelListadoActividadesEmpleados parent, Actividades actividades) {
        initComponents();
        
        this.sParentE = sParent;
        this.parentE = parent;
        this.actividades = actividades;
        this.empleadCliente = true;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());;
        setResizable(false);
        this.setTitle("Vizualizar actividad");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
               
        jLabelActividad.setText(actividades.getHora() + " - " + actividades.getFecha());
        jTableClientes.setDefaultEditor(Object.class, null);
        jTableClientes.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableClientes.getTableHeader().setForeground(Color.BLACK);
        jTableClientes.getTableHeader().setBackground(Color.GREEN);   
        
        this.jBEliminarCliente.setVisible(false);
        ObtenerClientes();
    }
    
    
    public void ObtenerClientes() {
        listaIdClientes.clear();
        
        if(actividades.getTipo() == 0){            
           //Actividades Planificadas
        
           try {
               
               SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_ACTIVIDADES_CLIENTES_PLANIFICADAS + "--" + actividades.getId());
               
               String received = SocketHandler.getIn().readLine();
               String [] args = received.split("--");
               
               int nClientes = Integer.parseInt(args[1]);
               
               
               DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
               model.setRowCount(0);
               
               for(int i = 0; i< nClientes; i++){
               
                   received = SocketHandler.getIn().readLine();
                   args = received.split("--");
                   
                   listaIdClientes.add(args[1]);
                   Object [] row = {args[2] +"  "+ args[3], args[4]};
                   
                   model.addRow(row);                   
                   
               }
               
            } catch (IOException ex) {
                Logger.getLogger(VisualizarActividadesClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        } else {        
            //Actividades Unicas
            
            try {
               
               SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_ACTIVIDADES_CLIENTES_UNICAS + "--" + actividades.getId());
               
               String received = SocketHandler.getIn().readLine();
               String [] args = received.split("--");
               
               int nClientes = Integer.parseInt(args[1]);
               
               
               DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
               model.setRowCount(0);
               
               for(int i = 0; i< nClientes; i++){
               
                   received = SocketHandler.getIn().readLine();
                   args = received.split("--");
                   
                   
                   listaIdClientes.add(args[1]);
                   Object [] row = {args[2] +"  "+ args[3], args[4]};
                   
                   model.addRow(row);                   
                   
               }

            } catch (IOException ex) {
                Logger.getLogger(VisualizarActividadesClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
                
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAtras = new javax.swing.JLabel();
        jLabelActividad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jBEliminarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jLabelActividad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelActividad.setText(" 18:00  -  16/11/2023");

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Teléfono"
            }
        ));
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);
        if (jTableClientes.getColumnModel().getColumnCount() > 0) {
            jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jBEliminarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBEliminarCliente.setText("Eliminar Cliente");
        jBEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabelAtras)
                        .addGap(133, 133, 133)
                        .addComponent(jLabelActividad)
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jLabelActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jBEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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
        if(this.empleadCliente){
            this.sParentE.setEnabled(true);
        }else {
        this.sParent.setEnabled(true);
        }
    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jBEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarClienteActionPerformed

        if(fila != -1) {
            EliminarClienteDeActividad eca  = new EliminarClienteDeActividad(this, listaIdClientes.get(fila), actividades.getId(), actividades.getTipo());
            eca.setVisible(true);
            this.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione algun Cliente");
        }
        
    }//GEN-LAST:event_jBEliminarClienteActionPerformed

    private void jTableClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMousePressed
        this.fila = this.jTableClientes.getSelectedRow();
    }//GEN-LAST:event_jTableClientesMousePressed

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
            java.util.logging.Logger.getLogger(VisualizarActividadesClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarActividadesClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarActividadesClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarActividadesClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarActividadesClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminarCliente;
    private javax.swing.JLabel jLabelActividad;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables


}
