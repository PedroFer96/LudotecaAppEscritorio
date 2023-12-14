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
import model.Empleado;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class jPanelListadoPEmpleados extends javax.swing.JPanel {

    
    PanelPropietario parent;
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    int id_ludoteca;
    int fila = -1;
    Empleado empleado;
    
    public jPanelListadoPEmpleados() {
    }

    jPanelListadoPEmpleados(PanelPropietario parentPropietario, int id) {
        initComponents();
        
        this.parent = parentPropietario;
        this.id_ludoteca = id;
        
        jTableEmpleados.setDefaultEditor(Object.class, null);
        jTableEmpleados.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableEmpleados.getTableHeader().setForeground(Color.BLACK);
        jTableEmpleados.getTableHeader().setBackground(Color.GREEN);
        
        
        ObtenerEmpleados();
    }

    public void ObtenerEmpleados() {
        listaEmpleados.clear();
        
        try{
        
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_EMPLEADOS_POR_LUDOTECA + "--" + id_ludoteca );
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nEmpleados = Integer.parseInt(args[1]);

            DefaultTableModel model = (DefaultTableModel) jTableEmpleados.getModel();
            model.setRowCount(0);
            
            for(int i = 0; i < nEmpleados; i++){
                
                received = SocketHandler.getIn().readLine();

                args = received.split("--");
                                
                listaEmpleados.add(new Empleado(Integer.parseInt(args[1]), args[2], args[3], args[4], args[5], args[6], args[7], args[8] ,args[9]));               
                
                Object [] row = {args[2]+ " " + args[3], args[5], args[8], args[9]};
                
                
                model.addRow(row);
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(jPanelListadoPEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonAñadirEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();
        jButtonEliminar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 565));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("Empleados");

        jButtonAñadirEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAñadirEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/circulo-de-persona-mas.png"))); // NOI18N
        jButtonAñadirEmpleado.setText("   Añadir Empleado");
        jButtonAñadirEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirEmpleadoActionPerformed(evt);
            }
        });

        jTableEmpleados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dni", "telefono", "Correo"
            }
        ));
        jTableEmpleados.setMinimumSize(new java.awt.Dimension(900, 400));
        jTableEmpleados.setPreferredSize(new java.awt.Dimension(900, 400));
        jTableEmpleados.getTableHeader().setReorderingAllowed(false);
        jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmpleados);
        if (jTableEmpleados.getColumnModel().getColumnCount() > 0) {
            jTableEmpleados.getColumnModel().getColumn(1).setMinWidth(130);
            jTableEmpleados.getColumnModel().getColumn(1).setMaxWidth(130);
            jTableEmpleados.getColumnModel().getColumn(2).setMinWidth(130);
            jTableEmpleados.getColumnModel().getColumn(2).setMaxWidth(130);
        }

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jButtonEliminar.setText("   Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1)
                        .addGap(349, 349, 349)
                        .addComponent(jButtonAñadirEmpleado))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jButtonAñadirEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAñadirEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirEmpleadoActionPerformed
        
        AñadirEmpleado ae = new AñadirEmpleado(parent, this, id_ludoteca);
        this.parent.setEnabled(false);
        this.setEnabled(false);
        ae.setVisible(true);
        
        
    }//GEN-LAST:event_jButtonAñadirEmpleadoActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        if(fila != -1){
            this.parent.setEnabled(false);
            EliminarEmpleado ee = new EliminarEmpleado(parent, this, listaEmpleados.get(fila).getId() );
            ee.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un empleado");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed

        if(fila != -1){

            AñadirEmpleado ae = new AñadirEmpleado(parent, this, listaEmpleados.get(fila));
            ae.setVisible(true);
            parent.setEnabled(false);
            this.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un empleado");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTableEmpleadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosMousePressed
        this.fila = this.jTableEmpleados.getSelectedRow();
    }//GEN-LAST:event_jTableEmpleadosMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirEmpleado;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmpleados;
    // End of variables declaration//GEN-END:variables


}
