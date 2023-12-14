/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.Ludoteca;
import model.Propietario;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class PanelPropietario extends javax.swing.JFrame {

    int idPropietario;
    String nombre;
    String apellidos;
    Ludoteca ludoteca;
    ArrayList<Ludoteca> listaludoteca = new ArrayList<>();
    int jComboIdSeleccionado = 0;
    public PanelPropietario() {
        
    }

    PanelPropietario(int  idpropietario) {
        
        this.idPropietario = idpropietario;
        
        initComponents();
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            
        }

//setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        
        obtenerNombrePropietario();         
        
        jLabelNombrePropietario.setText(nombre + " " + apellidos);
       
        cargarLudotecas();
        
        
    }

    
    private void obtenerNombrePropietario() {
     
        try{
        
            SocketHandler.getOut().println(Mensajes.PETICION_NOMBRE_PROPIETARIO + "--" + idPropietario);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            nombre = args[0];
            apellidos = args[1];

        } catch (IOException ex) {
            Logger.getLogger(PanelPropietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void cargarLudotecas() {
        
        try{
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_LUDOTECAS_POR_PROPIETARIO + "--" + this.idPropietario);
            
            String received = SocketHandler.getIn().readLine();
            
            String [] args = received.split("--");
            
            int numeroLudotecasPropietario = Integer.parseInt(args[1]);
            
            for(int i = 0; i < numeroLudotecasPropietario; i++){
            
                received = SocketHandler.getIn().readLine();
                
                args = received.split("--");
                
                listaludoteca.add(new Ludoteca(Integer.parseInt(args[1]), args[2], args[3], Double.parseDouble(args[4]), Double.parseDouble(args[5]), args[6], args[7], Integer.parseInt(args[8])));                                
            }             
        } catch (IOException ex) {
            Logger.getLogger(PanelPropietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                    
        for(int i = 0; i< listaludoteca.size(); i++){
            jComboBoxLudotecas.addItem(listaludoteca.get(i).getNombre());
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelNombrePropietario = new javax.swing.JLabel();
        jLabelPerfilPropietario = new javax.swing.JLabel();
        jComboBoxLudotecas = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabelEmpleados = new javax.swing.JLabel();
        jLabelClientes = new javax.swing.JLabel();
        jLabelSalas = new javax.swing.JLabel();
        jLabelInscripciones = new javax.swing.JLabel();
        jLabelActividades = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 175, 44));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido:");

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida.png"))); // NOI18N
        jButtonSalir.setText("   Salir");
        jButtonSalir.setToolTipText("");
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jLabelNombrePropietario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabelPerfilPropietario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelPerfilPropietario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/settings.png"))); // NOI18N
        jLabelPerfilPropietario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelPerfilPropietario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPerfilPropietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPerfilPropietarioMouseClicked(evt);
            }
        });

        jComboBoxLudotecas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxLudotecas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLudotecasItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelPerfilPropietario)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jComboBoxLudotecas, 0, 413, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPerfilPropietario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNombrePropietario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxLudotecas, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 153, 0));

        jLabelEmpleados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        jLabelEmpleados.setText("   Gestión de empleados");
        jLabelEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEmpleadosMouseClicked(evt);
            }
        });

        jLabelClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        jLabelClientes.setText("   Gestión de clientes");
        jLabelClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelClientesMouseClicked(evt);
            }
        });

        jLabelSalas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        jLabelSalas.setText("   Gestión de salas");
        jLabelSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalasMouseClicked(evt);
            }
        });

        jLabelInscripciones.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelInscripciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        jLabelInscripciones.setText("   Inscripciones Pendientes");
        jLabelInscripciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInscripciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInscripcionesMouseClicked(evt);
            }
        });

        jLabelActividades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        jLabelActividades.setText("   Gestión de actividades");
        jLabelActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelActividadesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelInscripciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelSalas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelActividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabelSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelInscripciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );

        jPanelContenedor.setMinimumSize(new java.awt.Dimension(900, 565));

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jLabelPerfilPropietarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPerfilPropietarioMouseClicked
        
        EditarPerfilPropietario ep = new EditarPerfilPropietario(idPropietario);
        ep.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelPerfilPropietarioMouseClicked

    private void jLabelEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEmpleadosMouseClicked

        
        jPanelContenedor.removeAll();
        
        jPanelListadoPEmpleados pl = new jPanelListadoPEmpleados(this, listaludoteca.get(jComboIdSeleccionado).getId());
        
        jPanelContenedor.add(pl);
        jPanelContenedor.validate();
        pl.setSize(900,565);
        jPanelContenedor.setSize(900,565);
        pl.setVisible(true);
        jPanelContenedor.repaint();
    
        
    }//GEN-LAST:event_jLabelEmpleadosMouseClicked

    private void jComboBoxLudotecasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLudotecasItemStateChanged

        this.jComboIdSeleccionado = jComboBoxLudotecas.getSelectedIndex();
        this.setTitle(listaludoteca.get(jComboIdSeleccionado).getNombre());
        jPanelContenedor.removeAll();
        jPanelContenedor.revalidate();
        jPanelContenedor.repaint();
        
    }//GEN-LAST:event_jComboBoxLudotecasItemStateChanged

    private void jLabelSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalasMouseClicked

        jPanelContenedor.removeAll();
        jPanelSalas ps = new jPanelSalas(this, listaludoteca.get(jComboIdSeleccionado).getId());
        
        jPanelContenedor.add(ps);
        jPanelContenedor.validate();
        ps.setSize(900,565);
        jPanelContenedor.setSize(900,565);
        ps.setVisible(true);
        jPanelContenedor.repaint();
        
                
        
    }//GEN-LAST:event_jLabelSalasMouseClicked

    private void jLabelClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClientesMouseClicked

        jPanelContenedor.removeAll();
        jPanelListadoClientes pl = new jPanelListadoClientes(this, listaludoteca.get(jComboIdSeleccionado).getId());
        
        jPanelContenedor.add(pl);
        jPanelContenedor.validate();
        pl.setSize(900,565);
        jPanelContenedor.setSize(900,565);
        pl.setVisible(true);
        jPanelContenedor.repaint();
        
        
    }//GEN-LAST:event_jLabelClientesMouseClicked

    private void jLabelInscripcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInscripcionesMouseClicked
        jPanelContenedor.removeAll();
        jPanelListadoInscripcionesPendientes pl = new jPanelListadoInscripcionesPendientes(this, listaludoteca.get(jComboIdSeleccionado).getId());
        
        jPanelContenedor.add(pl);
        jPanelContenedor.validate();
        pl.setSize(900,565);
        jPanelContenedor.setSize(900,565);
        pl.setVisible(true);
        jPanelContenedor.repaint();
        
    }//GEN-LAST:event_jLabelInscripcionesMouseClicked

    private void jLabelActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelActividadesMouseClicked
        
        jPanelContenedor.removeAll();
        jPanelListadoActividades pla = new jPanelListadoActividades(this, listaludoteca.get(jComboIdSeleccionado).getId());
        
        jPanelContenedor.add(pla);
        jPanelContenedor.validate();
        pla.setSize(900,565);
        jPanelContenedor.setSize(900,565);
        pla.setVisible(true);
        jPanelContenedor.repaint();
        
    }//GEN-LAST:event_jLabelActividadesMouseClicked

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
            java.util.logging.Logger.getLogger(PanelPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPropietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxLudotecas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelActividades;
    private javax.swing.JLabel jLabelClientes;
    private javax.swing.JLabel jLabelEmpleados;
    private javax.swing.JLabel jLabelInscripciones;
    private javax.swing.JLabel jLabelNombrePropietario;
    private javax.swing.JLabel jLabelPerfilPropietario;
    private javax.swing.JLabel jLabelSalas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContenedor;
    // End of variables declaration//GEN-END:variables


}
