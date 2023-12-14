/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ludoteca;
import model.Propietario;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class ListadoLudotecasPorPropietario extends javax.swing.JFrame {

    Propietario propietario;
    ArrayList<Ludoteca> listaLudotecas = new ArrayList<>();
    Ludoteca ludoteca;
    int fila = -1;
    EditarPerfilPropietario parent;
    
    
    public ListadoLudotecasPorPropietario() {
    }

    ListadoLudotecasPorPropietario(Propietario pr, EditarPerfilPropietario parent) {
        initComponents();
        this.propietario = pr;
        this.parent = parent;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        setResizable(false);
        this.getContentPane().setBackground(Color.GREEN);
        this.setTitle("Lista de Ludotecas");
        
        jTableListLudotecas.setDefaultEditor(Object.class, null);
        jTableListLudotecas.getTableHeader().setFont(new Font("Tahoma",1,18));
        jTableListLudotecas.getTableHeader().setForeground(Color.BLACK);
        jTableListLudotecas.getTableHeader().setBackground(Color.WHITE);
       
        ObtenerLudotecasPorPropietario();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNuevaLudoteca = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListLudotecas = new javax.swing.JTable();
        jButtonEliminartLudoteca = new javax.swing.JButton();
        jLabelAtras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));

        jButtonNuevaLudoteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ludoteca.png"))); // NOI18N
        jButtonNuevaLudoteca.setText("   Nueva Ludoteca");
        jButtonNuevaLudoteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaLudotecaActionPerformed(evt);
            }
        });

        jTableListLudotecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre"
            }
        ));
        jTableListLudotecas.getTableHeader().setReorderingAllowed(false);
        jTableListLudotecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableListLudotecasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListLudotecas);
        if (jTableListLudotecas.getColumnModel().getColumnCount() > 0) {
            jTableListLudotecas.getColumnModel().getColumn(0).setMinWidth(50);
            jTableListLudotecas.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableListLudotecas.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButtonEliminartLudoteca.setText("Eliminar");
        jButtonEliminartLudoteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminartLudotecaActionPerformed(evt);
            }
        });

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEliminartLudoteca, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNuevaLudoteca, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonNuevaLudoteca, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminartLudoteca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void ObtenerLudotecasPorPropietario() {
        
        int id = propietario.getId();
        

        try{
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_LUDOTECAS_POR_PROPIETARIO + "--" + id);
            
            String received = SocketHandler.getIn().readLine();
            
            String [] args = received.split("--");
            
            int numeroLudotecasPropietario = Integer.parseInt(args[1]);
            
            
            for(int i = 0; i < numeroLudotecasPropietario; i++){
            
                received = SocketHandler.getIn().readLine();
                
                args = received.split("--");
                
                //SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
                //String fecha;
                listaLudotecas.add(new Ludoteca(Integer.parseInt(args[1]), args[2], args[3], Double.parseDouble(args[4]), Double.parseDouble(args[5]), args[6], args[7], Integer.parseInt(args[8])));
                
                Object [] row = {args[1], args [2] };
                
                DefaultTableModel model = (DefaultTableModel) jTableListLudotecas.getModel();
                
                model.addRow(row);
                
                
            }           
        
        
        } catch (IOException ex) {
            Logger.getLogger(ListadoLudotecasPorPropietario.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        
        
    }
    
    private void jButtonNuevaLudotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaLudotecaActionPerformed
        AñadirLudoteca al = new AñadirLudoteca(this.propietario, parent);
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonNuevaLudotecaActionPerformed

    private void jButtonEliminartLudotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminartLudotecaActionPerformed
        
        if(fila != -1){
            this.parent.setEnabled(true);
            EliminarLudoteca el = new EliminarLudoteca(parent, listaLudotecas.get(fila).getId());
            this.dispose();
            el.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione alguna Ludoteca");
        }
        
    }//GEN-LAST:event_jButtonEliminartLudotecaActionPerformed

    private void jTableListLudotecasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListLudotecasMousePressed
    
        this.fila = this.jTableListLudotecas.getSelectedRow();

    }//GEN-LAST:event_jTableListLudotecasMousePressed

    private void jLabelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtrasMouseClicked
        this.dispose();
        parent.setEnabled(true);

    }//GEN-LAST:event_jLabelAtrasMouseClicked

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
            java.util.logging.Logger.getLogger(ListadoLudotecasPorPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoLudotecasPorPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoLudotecasPorPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoLudotecasPorPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoLudotecasPorPropietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminartLudoteca;
    private javax.swing.JButton jButtonNuevaLudoteca;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListLudotecas;
    // End of variables declaration//GEN-END:variables

}
