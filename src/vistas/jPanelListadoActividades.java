/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class jPanelListadoActividades extends javax.swing.JPanel {

    PanelPropietario parent;
    
    int idLudoteca;
    int fila = -1;
    
    ArrayList<Actividades> listaActividades = new ArrayList<>();
    
    ArrayList<String> listaIdActividades = new ArrayList<>();
    
    public jPanelListadoActividades() {        
    }

    jPanelListadoActividades(PanelPropietario parent, int id) {
        
        initComponents();
        
        this.parent = parent;
        this.idLudoteca = id;
        
        jTableActividades.setDefaultEditor(Object.class, null);
        jTableActividades.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableActividades.getTableHeader().setForeground(Color.BLACK);
        jTableActividades.getTableHeader().setBackground(Color.GREEN);  
        
        ObtenerActividades();
        
    }

    public void ObtenerActividades(){
        listaIdActividades.clear();
        listaActividades.clear();
        
        try{
        
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_ALL_ACTIVIDADES_X_LUDOTECA + "--" + idLudoteca);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nActividades = Integer.parseInt(args[1]);
            
            DefaultTableModel model = (DefaultTableModel) jTableActividades.getModel();
            model.setRowCount(0);
            
            for (int i = 0; i< nActividades ; i++) {
            
                received = SocketHandler.getIn().readLine();
                args = received.split("--");
                
                String horaSalida = "";
                try{
                    String horaEntrada = args[2];
                    SimpleDateFormat formatoEntrada = new SimpleDateFormat("HH:mm:ss");
                    Date hora = formatoEntrada.parse(horaEntrada);

                    SimpleDateFormat formatoSalida = new SimpleDateFormat("HH:mm");
                    horaSalida = formatoSalida.format(hora);
                } catch (ParseException ex) {
                    Logger.getLogger(GestionDeActividadesRecurrentes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String fechaSalida ="";
                try {
                    String fechaEntrada = args[3];
                    SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha = formatoEntrada.parse(fechaEntrada);

                    SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
                    fechaSalida = formatoSalida.format(fecha);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                
                listaActividades.add ( new Actividades(Integer.parseInt(args[1]), horaSalida,fechaSalida , args[4], Integer.parseInt(args[5]), args[6], args[7], args[8]));                               
                
                Object [] row = {fechaSalida, horaSalida, args[4],args[6]+ " " + args[7], args[8] };
                model.addRow(row);
                
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(jPanelListadoActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonConfigurarActividades = new javax.swing.JButton();
        jBAddActividad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableActividades = new javax.swing.JTable();
        jBDeleteActividad = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonVisualizarClientes = new javax.swing.JButton();
        jBAddActividad1 = new javax.swing.JButton();
        jBEditarActividad = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Proximas Actividades");

        jButtonConfigurarActividades.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonConfigurarActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mechanical-gears-.png"))); // NOI18N
        jButtonConfigurarActividades.setText("   Configurar Tipos Actividades");
        jButtonConfigurarActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigurarActividadesActionPerformed(evt);
            }
        });

        jBAddActividad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBAddActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N
        jBAddActividad.setText("   Nueva Actividad Unica");
        jBAddActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActividadActionPerformed(evt);
            }
        });

        jTableActividades.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Hora", "Nombre Tipo Actividad", "Responsable", "Sala"
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
            jTableActividades.getColumnModel().getColumn(0).setMinWidth(100);
            jTableActividades.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTableActividades.getColumnModel().getColumn(0).setMaxWidth(100);
            jTableActividades.getColumnModel().getColumn(1).setMinWidth(100);
            jTableActividades.getColumnModel().getColumn(1).setMaxWidth(100);
            jTableActividades.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableActividades.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jBDeleteActividad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBDeleteActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jBDeleteActividad.setText("   Eliminar Actividad");
        jBDeleteActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActividadActionPerformed(evt);
            }
        });

        jButtonVisualizarClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVisualizarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/magnifying-glass.png"))); // NOI18N
        jButtonVisualizarClientes.setText("   Ver Clientes");
        jButtonVisualizarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarClientesActionPerformed(evt);
            }
        });

        jBAddActividad1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBAddActividad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        jBAddActividad1.setText("   Nueva Actividad Recurrente");
        jBAddActividad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActividad1ActionPerformed(evt);
            }
        });

        jBEditarActividad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBEditarActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jBEditarActividad.setText("   Editar Actividad");
        jBEditarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActividadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(316, 316, 316))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonConfigurarActividades)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBAddActividad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBAddActividad1)
                                .addGap(62, 62, 62))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVisualizarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBEditarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBDeleteActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonConfigurarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAddActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAddActividad1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jBDeleteActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEditarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonVisualizarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfigurarActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigurarActividadesActionPerformed
        
        ConfigurarTiposActividades ca = new ConfigurarTiposActividades(parent, this, idLudoteca);
        parent.setEnabled(false);
        ca.setVisible(true);
    }//GEN-LAST:event_jButtonConfigurarActividadesActionPerformed

    private void jTableActividadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableActividadesMousePressed
        this.fila = this.jTableActividades.getSelectedRow();        
    }//GEN-LAST:event_jTableActividadesMousePressed

    private void jBDeleteActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActividadActionPerformed

        if(fila != -1){
            this.parent.setEnabled(false);
            EliminarActividad ea = new EliminarActividad(parent, this, listaActividades.get(fila));
            ea.setVisible(true);
        
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione alguna actividad");
        }
    }//GEN-LAST:event_jBDeleteActividadActionPerformed

    private void jBAddActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActividadActionPerformed

        FormularioActividadUnica au = new FormularioActividadUnica (parent, this, idLudoteca);
        au.setVisible(true);
        this.parent.setEnabled(false);

    }//GEN-LAST:event_jBAddActividadActionPerformed

    private void jButtonVisualizarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarClientesActionPerformed

        if(fila != -1) {
            this.parent.setEnabled(false);
            VisualizarActividadesClientes ac = new VisualizarActividadesClientes(parent, this, listaActividades.get(fila));
            ac.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione alguna actividad");
        }
        
    }//GEN-LAST:event_jButtonVisualizarClientesActionPerformed

    private void jBAddActividad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActividad1ActionPerformed
        
        GestionDeActividadesRecurrentes ga = new GestionDeActividadesRecurrentes(parent, this, idLudoteca);
        ga.setVisible(true);
        this.parent.setEnabled(false);
        
        
    }//GEN-LAST:event_jBAddActividad1ActionPerformed

    private void jBEditarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActividadActionPerformed
        if(fila != -1) {
            //Editar la actividad tendra que diferencia
            
            if(listaActividades.get(fila).getTipo() == 1){
                //Editar Actividad Unica
            
                FormularioActividadUnica fau = new FormularioActividadUnica(parent, this, listaActividades.get(fila), idLudoteca);
                fau.setVisible(true);
                this.parent.setEnabled(false);
            } else {
            
                //Editar Actividad Recurrente
                EditarActividadRecurrente ear = new EditarActividadRecurrente(parent, this, listaActividades.get(fila), idLudoteca);
                ear.setVisible(true);
                this.parent.setEnabled(false);
            }
            
            
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione alguna actividad");
        }
    }//GEN-LAST:event_jBEditarActividadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddActividad;
    private javax.swing.JButton jBAddActividad1;
    private javax.swing.JButton jBDeleteActividad;
    private javax.swing.JButton jBEditarActividad;
    private javax.swing.JButton jButtonConfigurarActividades;
    private javax.swing.JButton jButtonVisualizarClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableActividades;
    // End of variables declaration//GEN-END:variables
}
