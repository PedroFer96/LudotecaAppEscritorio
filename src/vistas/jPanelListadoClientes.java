/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class jPanelListadoClientes extends javax.swing.JPanel {

    PanelPropietario parent;
    
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    
    int idLudoteca;
    int fila = -1;
    Cliente cliente;
    
    
    public jPanelListadoClientes() {        
    }

    jPanelListadoClientes(PanelPropietario parentPropietario, int id) {
        initComponents();
        
        this.parent = parentPropietario;
        this.idLudoteca = id;     
     
                
        jTableClientes.setDefaultEditor(Object.class, null);
        jTableClientes.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableClientes.getTableHeader().setForeground(Color.BLACK);
        jTableClientes.getTableHeader().setBackground(Color.GREEN);                
        
        ObtenerClientes();
    }

    public void ObtenerClientes() {
        listaCliente.clear();
        
        try{
        
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_CLIENTES_POR_LUDOTECA + "--" + idLudoteca);
            
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nClientes = Integer.parseInt(args[1]);
            
            DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
            model.setRowCount(0);
            
            for(int i = 0 ; i < nClientes; i++){
            
                received = SocketHandler.getIn().readLine();
                
                args = received.split("--");
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                listaCliente.add(new Cliente(Integer.parseInt(args[1]), args[2], args[3], args[4] ,args[5], args[6], args[7], args[8], args[9], Integer.parseInt(args[10]), Integer.parseInt(args[11]), args[12], args[13], args[14] ,args[15], Integer.parseInt(args[16]), Integer.parseInt(args[17])));
                String nombre = args[2] + "  "+ args[3];
                String telefono  = args[6];
                String correo = args[7];
                
                
                String tutor;
                if( Integer.parseInt(args[11]) == 0){
                    tutor = "Mayor de edad";
                }else {
                    tutor = "Tutor asignado";
                }
                
                Object [] row = {nombre, telefono, correo, tutor };
                
                model.addRow(row);                
            }
              
        } catch (IOException ex) {
            Logger.getLogger(jPanelListadoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jBNuevoCliente = new javax.swing.JButton();
        jBEditarCliente = new javax.swing.JButton();
        jBEliminarCliente = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 565));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Usuarios");

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Telefono", "Coreeo", "Tutor"
            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jBNuevoCliente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jBNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/circulo-de-persona-mas.png"))); // NOI18N
        jBNuevoCliente.setText("   Nuevo Cliente");
        jBNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoClienteActionPerformed(evt);
            }
        });

        jBEditarCliente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jBEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jBEditarCliente.setText("   Editar");
        jBEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarClienteActionPerformed(evt);
            }
        });

        jBEliminarCliente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jBEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jBEliminarCliente.setText("   Eliminar");
        jBEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327)
                        .addComponent(jBNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBNuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarClienteActionPerformed
        
        if(fila != -1){
            
            if(listaCliente.get(fila).getIdTutor() == 0) {

                FormularioClienteMayor cm = new FormularioClienteMayor(parent, this, listaCliente.get(fila));
                cm.setVisible(true);
                parent.setEnabled(false);
                this.setEnabled(false);
                
            }else {
                
                FormularioClienteNiño cn = new FormularioClienteNiño(parent, this, listaCliente.get(fila));
                cn.setVisible(true);
                parent.setEnabled(false);
                this.setEnabled(false);
            }
            
            
        }else{
         JOptionPane.showMessageDialog(this, "Seleccione algun cliente");
        }
        
    }//GEN-LAST:event_jBEditarClienteActionPerformed

    private void jBEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarClienteActionPerformed
        if(fila != -1){
            this.parent.setEnabled(false);
            EliminarCliente ec = new EliminarCliente(parent, this, listaCliente.get(fila).getId(), this.idLudoteca);
            ec.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione algun cliente");
        }
    }//GEN-LAST:event_jBEliminarClienteActionPerformed

    private void jBNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoClienteActionPerformed
        
        PreguntaCliente pc = new PreguntaCliente(parent, this, idLudoteca);
        pc.setVisible(true);
        parent.setEnabled(false);
        
    }//GEN-LAST:event_jBNuevoClienteActionPerformed

    private void jTableClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMousePressed
        this.fila = this.jTableClientes.getSelectedRow();
    }//GEN-LAST:event_jTableClientesMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditarCliente;
    private javax.swing.JButton jBEliminarCliente;
    private javax.swing.JButton jBNuevoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables
}
