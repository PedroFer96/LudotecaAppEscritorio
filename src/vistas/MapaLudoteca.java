/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

/**
 *
 * @author pedro
 */
public class MapaLudoteca extends javax.swing.JFrame {

    public static double longitude = 0;
    public static double latitude = 0;

    private AñadirLudoteca parent;
    
    public MapaLudoteca(){}
    
    public MapaLudoteca(AñadirLudoteca parent) {
        initComponents();
        init();
        setTitle("Ubica su ludoteca");
        this.parent = parent;
    }

    private void init(){
    
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapLudotecas.setTileFactory(tileFactory);
        
        GeoPosition geo = new GeoPosition(36.461756, -5.725740);
        jXMapLudotecas.setAddressLocation(geo);
        jXMapLudotecas.setZoom(12);
        
        
        MouseInputListener mm = new PanMouseInputListener(jXMapLudotecas);
        jXMapLudotecas.addMouseListener(mm);
        jXMapLudotecas.addMouseMotionListener(mm);
        jXMapLudotecas.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapLudotecas));
        
        Set<Waypoint> waypoints = new HashSet<Waypoint>();
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
        waypointPainter.setWaypoints(waypoints);
        jXMapLudotecas.setOverlayPainter(waypointPainter);
        
        
        jXMapLudotecas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                GeoPosition geoPosition = jXMapLudotecas.convertPointToGeoPosition(e.getPoint());
                
                waypoints.clear();
                waypoints.add(new DefaultWaypoint(geoPosition));
                
                waypointPainter.setWaypoints(waypoints);
                
                jXMapLudotecas.repaint();
                
                latitude = geoPosition.getLatitude();
                longitude = geoPosition.getLongitude();
            }
        
            
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapLudotecas = new org.jxmapviewer.JXMapViewer();
        comboMapType = new javax.swing.JComboBox<>();
        jButtonAceptar = new javax.swing.JButton();
        jLAtras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboMapType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboMapType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open Stree", "Virtual Earth", "Hybrid", "Satellite" }));
        comboMapType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapTypeActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAtrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jXMapLudotecasLayout = new javax.swing.GroupLayout(jXMapLudotecas);
        jXMapLudotecas.setLayout(jXMapLudotecasLayout);
        jXMapLudotecasLayout.setHorizontalGroup(
            jXMapLudotecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapLudotecasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 800, Short.MAX_VALUE)
                .addGroup(jXMapLudotecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboMapType, 0, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXMapLudotecasLayout.setVerticalGroup(
            jXMapLudotecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapLudotecasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXMapLudotecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMapType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE)
                .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXMapLudotecas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXMapLudotecas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboMapTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapTypeActionPerformed
        
        TileFactoryInfo info;
        int index = comboMapType.getSelectedIndex();
        
        if(index == 0){
            info = new OSMTileFactoryInfo();
        } else if (index == 1){
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        } else if (index == 2){
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
        } else {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
        }
        
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapLudotecas.setTileFactory(tileFactory);
    }//GEN-LAST:event_comboMapTypeActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        if(latitude !=  0 || longitude != 0){
            //mirar como puedo devolver los datos al padre
            parent.setCoordinates(latitude, longitude);
            parent.setEnabled(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Debes de selecionar el punto donde\nse encuentra su ludoteca");
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jLAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAtrasMouseClicked
        this.parent.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jLAtrasMouseClicked


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
            java.util.logging.Logger.getLogger(MapaLudoteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapaLudoteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapaLudoteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapaLudoteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapaLudoteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboMapType;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLAtras;
    private javax.swing.JLabel jLabelAtras;
    private org.jxmapviewer.JXMapViewer jXMapLudotecas;
    // End of variables declaration//GEN-END:variables
}
