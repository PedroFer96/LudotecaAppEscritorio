/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Sala;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class jPanelSalas extends javax.swing.JPanel {

    
    PanelPropietario parent;
    int idLudoteca;
    int fila = -1;
    Sala sala;
    ArrayList<Sala> listaSala = new ArrayList<>();
    
    
    public jPanelSalas() {
        //initComponents();
    }

    jPanelSalas(PanelPropietario parent, int id) {
        initComponents();
        
        this.parent = parent;
        this.idLudoteca = id;
        
        
        jTableSalas.setDefaultEditor(Object.class, null);
        jTableSalas.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableSalas.getTableHeader().setForeground(Color.BLACK);
        jTableSalas.getTableHeader().setBackground(Color.GREEN);
        
        mostrarSalas();
    }

    public void mostrarSalas() {
        listaSala.clear();
        
        try{
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_SALAS_POR_LUDOTECA + "--" + idLudoteca);
            
            String received = SocketHandler.getIn().readLine();
            
            String [] args = received.split("--");
            int numeroSalas = Integer.parseInt(args[1]);
            
            DefaultTableModel model = (DefaultTableModel) jTableSalas.getModel();
            model.setRowCount(0);
            for(int i = 0; i < numeroSalas; i++){
            
                received = SocketHandler.getIn().readLine();
                
                args = received.split("--");
                listaSala.add(new Sala(Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4])));
                Object [] row = { args[2], args[3] };
                
                
                model.addRow(row);
            }
        } catch (IOException ex) {
            Logger.getLogger(jPanelSalas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSalas = new javax.swing.JTable();
        jButtonAñadirSala = new javax.swing.JButton();
        jBDeleteSala = new javax.swing.JButton();
        jBEditarSala = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 565));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Salas");

        jTableSalas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Aforo máximo"
            }
        ));
        jTableSalas.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jTableSalas.setMinimumSize(new java.awt.Dimension(175, 100));
        jTableSalas.setPreferredSize(new java.awt.Dimension(235, 300));
        jTableSalas.getTableHeader().setReorderingAllowed(false);
        jTableSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableSalasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSalas);
        if (jTableSalas.getColumnModel().getColumnCount() > 0) {
            jTableSalas.getColumnModel().getColumn(1).setMinWidth(160);
            jTableSalas.getColumnModel().getColumn(1).setMaxWidth(300);
        }

        jButtonAñadirSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAñadirSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/open-door.png"))); // NOI18N
        jButtonAñadirSala.setText("   Añadir Sala");
        jButtonAñadirSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirSalaActionPerformed(evt);
            }
        });

        jBDeleteSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBDeleteSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jBDeleteSala.setText("   Eliminar");
        jBDeleteSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteSalaActionPerformed(evt);
            }
        });

        jBEditarSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBEditarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jBEditarSala.setText("   Editar");
        jBEditarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAñadirSala))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBEditarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBDeleteSala, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(1729, 1729, 1729))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAñadirSala, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBDeleteSala, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEditarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAñadirSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirSalaActionPerformed
        AñadirSala as = new AñadirSala(parent, this, idLudoteca);
        as.setVisible(true);
        parent.setEnabled(false);
        this.setEnabled(false);
        
        
    }//GEN-LAST:event_jButtonAñadirSalaActionPerformed

    private void jBEditarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarSalaActionPerformed
    
        if(fila != -1){
            AñadirSala as = new AñadirSala(parent, this, listaSala.get(fila));
            as.setVisible(true);
            parent.setEnabled(false);
            this.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione alguna Sala");
        }
        
        
    }//GEN-LAST:event_jBEditarSalaActionPerformed

    private void jBDeleteSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteSalaActionPerformed
        
        if(fila != -1){
            this.parent.setEnabled(false);
            EliminarSala es = new EliminarSala(parent, this, listaSala.get(fila).getId());
            es.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione alguna Sala");
        }
    }//GEN-LAST:event_jBDeleteSalaActionPerformed

    private void jTableSalasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSalasMousePressed
        
        this.fila = this.jTableSalas.getSelectedRow();
    }//GEN-LAST:event_jTableSalasMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDeleteSala;
    private javax.swing.JButton jBEditarSala;
    private javax.swing.JButton jButtonAñadirSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSalas;
    // End of variables declaration//GEN-END:variables


}
