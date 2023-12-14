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
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class ConfigurarTiposActividades extends javax.swing.JFrame {

    PanelPropietario sParent;
    jPanelListadoActividades parent;
    
    int idLudoteca;
    int fila = -1;
    
    ArrayList<String> listaIdTipos = new ArrayList();
    
    
    
    public ConfigurarTiposActividades() {
    }

    ConfigurarTiposActividades(PanelPropietario sparent, jPanelListadoActividades parent, int idLudoteca) {
        initComponents();
        
        this.sParent = sparent;
        this.parent = parent;
        this.idLudoteca = idLudoteca;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());;
        setResizable(false);
        this.setTitle("Tipos de Actividades");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        jTableTipos.setDefaultEditor(Object.class, null);
        jTableTipos.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableTipos.getTableHeader().setForeground(Color.BLACK);
        jTableTipos.getTableHeader().setBackground(Color.GREEN);
     
        ObtenerTipos();
    }
    
    public void ObtenerTipos(){
    
        listaIdTipos.clear();
        
        try{
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_TIPOS_ACTIVIDADES + "--" + idLudoteca);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nTipos = Integer.parseInt(args[1]);
            
            DefaultTableModel model = (DefaultTableModel) jTableTipos.getModel();
            model.setRowCount(0);
        
            for ( int i = 0 ; i < nTipos ; i++) {
            
                received = SocketHandler.getIn().readLine();
                
                args = received.split("--");
                
                listaIdTipos.add(args[1]); 

                String precio ;
                if( Integer.parseInt(args[3]) == 0 ){
                    precio = "Gratis";
                }else{
                    precio = args[3];
                }
                
                Object [] row ={args[2], precio ,args[4]};
                model.addRow(row);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(ConfigurarTiposActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
                     
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabelAtras = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTipos = new javax.swing.JTable();
        jButtonDelete = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jButtonAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N
        jButtonAdd.setText("   Añadir Tipo");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jTableTipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Categoria"
            }
        ));
        jTableTipos.getTableHeader().setReorderingAllowed(false);
        jTableTipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableTiposMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTipos);
        if (jTableTipos.getColumnModel().getColumnCount() > 0) {
            jTableTipos.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

        jButtonDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jButtonDelete.setText("   Eliminar");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jButtonEditar.setText("   Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Tipos de Actividades");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabelAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(126, 126, 126)
                        .addComponent(jButtonAdd))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtrasMouseClicked
        this.dispose();
        this.sParent.setEnabled(true);
        this.sParent.setVisible(true);

    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if(fila != -1){
            AñadirTipo at = new AñadirTipo(this, idLudoteca, listaIdTipos.get(fila));
            at.setVisible(true);
            this.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione alguna actividad");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        if(fila != -1){
            this.setEnabled(false);
            EliminarTipoActividad et = new EliminarTipoActividad(this, listaIdTipos.get(fila));
            et.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione alguna actividad");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        AñadirTipo at = new AñadirTipo(this, idLudoteca);
        at.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTableTiposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTiposMousePressed
        this.fila = this.jTableTipos.getSelectedRow();
    }//GEN-LAST:event_jTableTiposMousePressed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigurarTiposActividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTipos;
    // End of variables declaration//GEN-END:variables
}
