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
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class jPanelListadoLudotecas extends javax.swing.JPanel {
    
    PanelAdmin parent;
    String id_propietario;
    ArrayList<String> idPropietarios = new ArrayList<>();
    int fila = -1;

    jPanelListadoLudotecas(PanelAdmin parent) {
        initComponents();
        
        this.parent = parent;
        
        jTablePropietarios.setDefaultEditor(Object.class, null);
        jTablePropietarios.getTableHeader().setFont(new Font("Tahoma", 1, 18));
        jTablePropietarios.getTableHeader().setForeground(Color.BLACK);
        jTablePropietarios.getTableHeader().setBackground(Color.GREEN);
        
        ObtenerLudotecas();
    }

    private void ObtenerLudotecas() {
    
        try{
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_LUDOTECAS);
            
            String received = SocketHandler.getIn().readLine();
            
            String[] args = received.split("--");
            int numeroLudotecas = Integer.parseInt(args[1]);
            
            for(int i = 0; i < numeroLudotecas ; i++){
            
                received = SocketHandler.getIn().readLine();
                
                args = received.split("--");
                
                idPropietarios.add(args[6]);
                Object [] row = { args[2], args[3], args[4], args[5], args[7] };
                
                DefaultTableModel model = (DefaultTableModel) jTablePropietarios.getModel();
                
                model.addRow(row);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(jPanelListadoLudotecas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePropietarios = new javax.swing.JTable();
        jButtonSelect = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("LISTADO DE LUDOTECAS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTablePropietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Direccion", "Telefono", "Fecha creacion", "Dueño"
            }
        ));
        jTablePropietarios.getTableHeader().setReorderingAllowed(false);
        jTablePropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePropietariosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePropietarios);

        jButtonSelect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSelect.setText("Seleccionar");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(264, 264, 264)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePropietariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePropietariosMousePressed
        fila = this.jTablePropietarios.getSelectedRow();       
        this.id_propietario = idPropietarios.get(fila);
    }//GEN-LAST:event_jTablePropietariosMousePressed

    private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
        if(fila != -1){
            if(!this.id_propietario.isEmpty()){
                this.parent.setEnabled(false);
                AñadirPropietario ap = new AñadirPropietario(parent, this, id_propietario);
                ap.setVisible(true);
                //Visualizar propietario mejor un JDialog con esos datos y listo¿? 
           }
        }
        else{
        JOptionPane.showMessageDialog(this, "Selecione una ludoteca");
        }
    }//GEN-LAST:event_jButtonSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePropietarios;
    // End of variables declaration//GEN-END:variables


}
