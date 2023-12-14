/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
public class GestionDeActividadesRecurrentes extends javax.swing.JFrame {

    PanelPropietario sParent;
    jPanelListadoActividades parent;
    int idLudoteca;
    int fila = -1;
    
    ArrayList<String> listaIdPlannings = new ArrayList<>();
    ArrayList<String> listaPlannings = new ArrayList<>();
    
    public GestionDeActividadesRecurrentes() {
        
    }

    GestionDeActividadesRecurrentes(PanelPropietario sparent, jPanelListadoActividades parent, int idLudoteca) {
        initComponents();
        this.sParent = sparent;
        this.parent = parent;
        this. idLudoteca = idLudoteca;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        setResizable(false);
        this.getContentPane().setBackground(Color.GREEN);
        this.setTitle("Gestion Actividades Recurrentes");
        
        jTablePlannings.setDefaultEditor(Object.class, null);
        jTablePlannings.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTablePlannings.getTableHeader().setForeground(Color.BLACK);
        jTablePlannings.getTableHeader().setBackground(Color.WHITE);
                
        ObtenerPlanning();
    }

    public void ObtenerPlanning() {
    
        listaIdPlannings.clear();
        
        try {
        
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_PLANNINGS_X_LUDOTECA + "--" + idLudoteca );
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nPlannings = Integer.parseInt(args[1]);
        
            DefaultTableModel model = (DefaultTableModel) jTablePlannings.getModel();
            model.setRowCount(0);
            
            for(int i = 0; i< nPlannings; i++){
                
                received = SocketHandler.getIn().readLine();
                args = received.split("--");                                
                
                listaIdPlannings.add(args[1]);
                 
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
                
                
                String nombre = args[5] + " " + args[6];
                String cadena = args[3];
                String dias  = cadena.replace("-", " ");
                String mensajeDias = "";
                
                if(dias.equals("Lunes Martes Miércoles Jueves Viernes Sábado Domingo")){
                    mensajeDias = "Todos los dias";
                } else {
                    mensajeDias = dias;
                }
                
                Object [] row = {mensajeDias, horaSalida ,args[4],  args[7], nombre};
                model.addRow(row);
            }
        
        } catch (IOException ex) {
            Logger.getLogger(GestionDeActividadesRecurrentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBAddPlanning = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePlannings = new javax.swing.JTable();
        jBDeletePlanning = new javax.swing.JButton();
        jBEditarPlanning = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gestión Actividades Recurrentes");

        jBAddPlanning.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jBAddPlanning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N
        jBAddPlanning.setText("   Nuevo Planning");
        jBAddPlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddPlanningActionPerformed(evt);
            }
        });

        jTablePlannings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dias", "Hora", "Tipo Actividad", "Sala", "Responsable"
            }
        ));
        jTablePlannings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePlanningsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePlannings);
        if (jTablePlannings.getColumnModel().getColumnCount() > 0) {
            jTablePlannings.getColumnModel().getColumn(0).setMinWidth(350);
            jTablePlannings.getColumnModel().getColumn(0).setMaxWidth(350);
            jTablePlannings.getColumnModel().getColumn(1).setMinWidth(90);
            jTablePlannings.getColumnModel().getColumn(1).setMaxWidth(90);
            jTablePlannings.getColumnModel().getColumn(2).setMinWidth(250);
            jTablePlannings.getColumnModel().getColumn(2).setMaxWidth(250);
            jTablePlannings.getColumnModel().getColumn(3).setMinWidth(140);
            jTablePlannings.getColumnModel().getColumn(3).setMaxWidth(140);
        }

        jBDeletePlanning.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jBDeletePlanning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jBDeletePlanning.setText("   Eliminar");
        jBDeletePlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletePlanningActionPerformed(evt);
            }
        });

        jBEditarPlanning.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jBEditarPlanning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jBEditarPlanning.setText("   Editar");
        jBEditarPlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarPlanningActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBEditarPlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBDeletePlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelAtras)
                            .addGap(156, 156, 156)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBAddPlanning))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBAddPlanning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBDeletePlanning, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jBEditarPlanning, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtrasMouseClicked
        this.dispose();
        this.sParent.setEnabled(true);
        this.parent.ObtenerActividades();
    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jBDeletePlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletePlanningActionPerformed

        if(fila != -1) {
            EliminarPlanning ep = new EliminarPlanning(this, listaIdPlannings.get(fila));
            ep.setVisible(true);
            this.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione algun Planning");
        }
    }//GEN-LAST:event_jBDeletePlanningActionPerformed

    private void jBAddPlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddPlanningActionPerformed
        FormularioActividadRecurrente fa = new FormularioActividadRecurrente(this, idLudoteca);
        fa.setVisible(true);
        this.setEnabled(false);              
    }//GEN-LAST:event_jBAddPlanningActionPerformed

    private void jTablePlanningsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePlanningsMousePressed
        this.fila = this.jTablePlannings.getSelectedRow();
    }//GEN-LAST:event_jTablePlanningsMousePressed

    private void jBEditarPlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarPlanningActionPerformed
            
        if(fila != -1) {
            FormularioActividadRecurrente fa = new FormularioActividadRecurrente(parent, this, listaIdPlannings.get(fila), idLudoteca);
            fa.setVisible(true);
            this.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione algun Planning");
        }
    }//GEN-LAST:event_jBEditarPlanningActionPerformed

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
            java.util.logging.Logger.getLogger(GestionDeActividadesRecurrentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDeActividadesRecurrentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDeActividadesRecurrentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDeActividadesRecurrentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDeActividadesRecurrentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddPlanning;
    private javax.swing.JButton jBDeletePlanning;
    private javax.swing.JButton jBEditarPlanning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePlannings;
    // End of variables declaration//GEN-END:variables


}
