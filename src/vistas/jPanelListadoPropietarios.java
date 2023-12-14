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
import model.Propietario;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class jPanelListadoPropietarios extends javax.swing.JPanel {

    PanelAdmin parent;
    ArrayList<Propietario> listaPropietarios = new ArrayList<>();
    String correo ;
    int fila = -1;
    
    jPanelListadoPropietarios(PanelAdmin parentAdmin) {
        initComponents();
        this.parent = parentAdmin;
        
        jTablePropietarios.setDefaultEditor(Object.class, null);
        jTablePropietarios.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTablePropietarios.getTableHeader().setForeground(Color.BLACK);
        jTablePropietarios.getTableHeader().setBackground(Color.GREEN);
                
        mostrarPropietarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePropietarios = new javax.swing.JTable();
        jButtonAddPropietario = new javax.swing.JButton();
        jButtonDeletePropietario = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("LISTADO DE PROPIETARIOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTablePropietarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablePropietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dni", "Correo", "Teléfono"
            }
        ));
        jTablePropietarios.getTableHeader().setReorderingAllowed(false);
        jTablePropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePropietariosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePropietarios);

        jButtonAddPropietario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddPropietario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/circulo-de-persona-mas.png"))); // NOI18N
        jButtonAddPropietario.setText("   Añadir");
        jButtonAddPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPropietarioActionPerformed(evt);
            }
        });

        jButtonDeletePropietario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeletePropietario.setText("Eliminar");
        jButtonDeletePropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletePropietarioActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDeletePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAddPropietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDeletePropietario, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void mostrarPropietarios() {
        listaPropietarios.clear();
   
        try{
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_PROPIETARIOS);
            
            String received = SocketHandler.getIn().readLine();
            String[] args = received.split("--");
            int numeroPropietarios = Integer.parseInt(args[1]);
            
            DefaultTableModel model = (DefaultTableModel) jTablePropietarios.getModel();
            model.setRowCount(0);
            
            for(int i = 0; i < numeroPropietarios; i++){
                
                received = SocketHandler.getIn().readLine();              
                args = received.split("--");
                Object [] row = {args[2]+" "+args[3], args[5], args[6], args[7]};             
                model.addRow(row);
                        
            }
            
        } catch (IOException ex) {
            Logger.getLogger(jPanelListadoPropietarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void jButtonAddPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPropietarioActionPerformed
       
        AñadirPropietario ap = new AñadirPropietario(parent, this);
        ap.setVisible(true);
        parent.setEnabled(false);
        this.setEnabled(false);
               
    }//GEN-LAST:event_jButtonAddPropietarioActionPerformed

    private void jTablePropietariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePropietariosMousePressed

        fila = this.jTablePropietarios.getSelectedRow();               
        this.correo = (String) this.jTablePropietarios.getValueAt(fila, 2);

    }//GEN-LAST:event_jTablePropietariosMousePressed

    private void jButtonDeletePropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletePropietarioActionPerformed
        if(fila != -1){
            if(!this.correo.isEmpty()){
                this.parent.setEnabled(false);
                EliminarPropietario ep = new EliminarPropietario (parent,this, correo);
                ep.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un propietarios");
        }
    }//GEN-LAST:event_jButtonDeletePropietarioActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if(!this.correo.isEmpty()){
            this.parent.setEnabled(false);
            AñadirPropietario ap = new AñadirPropietario(parent, correo);
            ap.setVisible(true);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPropietario;
    private javax.swing.JButton jButtonDeletePropietario;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePropietarios;
    // End of variables declaration//GEN-END:variables

}
