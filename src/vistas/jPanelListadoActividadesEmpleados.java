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
import model.Actividades;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class jPanelListadoActividadesEmpleados extends javax.swing.JPanel {

    PanelEmpleado parent;
    int fila = -1;
    
    int idEmpleado;
    int idLudoteca;
    
    ArrayList<String> listaIdActividades = new ArrayList<>();
    ArrayList<Actividades> listaActividades = new ArrayList<>();
    
    
    public jPanelListadoActividadesEmpleados() {
     
    }

    jPanelListadoActividadesEmpleados(PanelEmpleado parent, int idEmpleado, String  idLudoteca) {
        initComponents();

        this.parent = parent;
        this.idEmpleado = idEmpleado;
        this.idLudoteca = Integer.parseInt(idLudoteca);
           
        jTableActividades.setDefaultEditor(Object.class, null);
        jTableActividades.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableActividades.getTableHeader().setForeground(Color.BLACK);
        jTableActividades.getTableHeader().setBackground(Color.GREEN);  

        ObtenerActividadesEmpleado();
        
    }
    
    
    private void ObtenerActividadesEmpleado() {
        listaIdActividades.clear();
        
        try{
        
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_ACTIVIDADES_X_EMPLEADO + "--" + this.idEmpleado + "--" + this.idLudoteca);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nActividades = Integer.parseInt(args[1]);
            
            DefaultTableModel model = (DefaultTableModel) jTableActividades.getModel();
            model.setRowCount(0);
            
            for (int i = 0; i< nActividades; i++){
            
                received = SocketHandler.getIn().readLine();
                args = received.split("--");
                
                listaActividades.add ( new Actividades(Integer.parseInt(args[1]), args[2], args[3], args[4], Integer.parseInt(args[5])));
                
                String tipo ;
                if(Integer.parseInt(args[5]) == 1){
                    tipo = "Actividad Unica";
                }else {
                    tipo = "Actividad Planificada";
                }
                
                Object [] row = {args[2], args[3], args[4], tipo };
                model.addRow(row);
                
                
            }
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(jPanelListadoActividadesEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableActividades = new javax.swing.JTable();
        jButtonVisualizarClientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTableActividades.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Hora", "Actividad", "Tipo"
            }
        ));
        jTableActividades.setRowMargin(3);
        jTableActividades.getTableHeader().setReorderingAllowed(false);
        jTableActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableActividadesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableActividades);
        if (jTableActividades.getColumnModel().getColumnCount() > 0) {
            jTableActividades.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTableActividades.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTableActividades.getColumnModel().getColumn(2).setPreferredWidth(350);
        }

        jButtonVisualizarClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVisualizarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/magnifying-glass.png"))); // NOI18N
        jButtonVisualizarClientes.setText("   Visualizar Clientes Apuntados");
        jButtonVisualizarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarClientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Actividades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonVisualizarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVisualizarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableActividadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableActividadesMousePressed
        this.fila = this.jTableActividades.getSelectedRow();
    }//GEN-LAST:event_jTableActividadesMousePressed

    private void jButtonVisualizarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarClientesActionPerformed

        if(fila != -1) {
            this.parent.setEnabled(false);
            VisualizarActividadesClientes ac = new VisualizarActividadesClientes(parent, this, listaActividades.get(fila));
            ac.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione alguna actividad");
        }

    }//GEN-LAST:event_jButtonVisualizarClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVisualizarClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableActividades;
    // End of variables declaration//GEN-END:variables


}
