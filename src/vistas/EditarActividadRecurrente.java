/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import model.Actividades;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class EditarActividadRecurrente extends javax.swing.JFrame {

    PanelPropietario sParent;
    jPanelListadoActividades parent;
    Actividades actividad;
    int idLudoteca;
    
    ArrayList<String> listaIdEmpleados = new ArrayList<>();
    ArrayList<String> listaIdSalas = new ArrayList<>();
    
    int jComboIdEmpleadoSleccionado = 0;
    int jComboidSalaSeleccionado = 0;
    
    public EditarActividadRecurrente() {
        
    }

    EditarActividadRecurrente(PanelPropietario sParent, jPanelListadoActividades parent, Actividades actividad, int idLudoteca) {
        initComponents();
        
        this.sParent = sParent;
        this.parent = parent;
        this.actividad = actividad;
        this. idLudoteca = idLudoteca;
        
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Editar Actividad (Recurrente)");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date hora = sdf.parse("14:00");
            SpinnerDateModel sm = new SpinnerDateModel(hora,null,null,Calendar.HOUR_OF_DAY);
            this.jSpinnerHour.setModel(sm);
            JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinnerHour,"HH:mm");
            jSpinnerHour.setEditor(de);
                    
        } catch (ParseException ex) {
            Logger.getLogger(FormularioActividadUnica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ObtenerEmpleados();
        ObtenerSalas();
        
        jLNombreTipoActividad.setText(this.actividad.getNombreTipo());
        
        String empleado = this.actividad.getNombre() + " " + this.actividad.getApellidos();
        jCBEmpleado.setSelectedItem(empleado);
        jComboIdEmpleadoSleccionado = jCBEmpleado.getSelectedIndex();
        
        try{
            String fechaEntrada = this.actividad.getFecha();
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoEntrada.parse(fechaEntrada);
            
            jCalendarDay.setDate(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(FormularioActividadUnica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
            String horaEntrada = this.actividad.getHora();
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
            Date hora = formatoHora.parse(horaEntrada);
            jSpinnerHour.setValue(hora);
            
        } catch (ParseException ex) {
            Logger.getLogger(FormularioActividadUnica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sala = this.actividad.getSala(); 
        jCBSala.setSelectedItem(sala);
        jComboidSalaSeleccionado = jCBSala.getSelectedIndex();
        
    }

    private void ObtenerEmpleados(){
        try{
        
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_EMPLEADOS_TIPO_ACTIVITY + "--" + idLudoteca);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nEmpleados = Integer.parseInt(args[1]);
            
            for(int i = 0; i< nEmpleados; i++){
                received = SocketHandler.getIn().readLine();
                args = received.split("--");
                listaIdEmpleados.add(args[1]);                
                jCBEmpleado.addItem(args[2] + " " + args[3]);  
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(AñadirTipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void ObtenerSalas(){
    
        try{
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_SALAS + "--" + idLudoteca);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nSalas = Integer.parseInt(args[1]);
            
            for(int i = 0; i< nSalas; i++){
                received = SocketHandler.getIn().readLine();
                args = received.split("--");
                listaIdSalas.add(args[1]);
                jCBSala.addItem(args[2]);
            }
        } catch (IOException ex) {
            Logger.getLogger(FormularioActividadUnica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLNombreTipoActividad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerHour = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jCBEmpleado = new javax.swing.JComboBox<>();
        jBActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCalendarDay = new com.toedter.calendar.JCalendar();
        jLabel5 = new javax.swing.JLabel();
        jCBSala = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Editar Actividad");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Actividad:");

        jLNombreTipoActividad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Hora Inicio:");

        jSpinnerHour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinnerHour.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1701030252641L), null, null, java.util.Calendar.HOUR_OF_DAY));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Empleado:");

        jCBEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBEmpleadoItemStateChanged(evt);
            }
        });

        jBActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendarDay, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendarDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Sala:");

        jCBSala.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBSala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBSalaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabelAtras)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jCBEmpleado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinnerHour, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNombreTipoActividad, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(jCBSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLNombreTipoActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerHour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jCBEmpleado))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBSala, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtrasMouseClicked
        this.dispose();
        this.sParent.setEnabled(true);
    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jCBEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEmpleadoItemStateChanged
        this.jComboIdEmpleadoSleccionado = jCBEmpleado.getSelectedIndex();
    }//GEN-LAST:event_jCBEmpleadoItemStateChanged

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed

        if(listaIdEmpleados.isEmpty()){
            JOptionPane.showMessageDialog(this, "Usted NO ha creado ningun Tipo de Actividad \nO ningun empleado que ponder seleccionar");
        }else {
        
            Date selectedDate = jCalendarDay.getDate();
            Date currentDate = new Date();

            if(selectedDate.before(currentDate)){
                JOptionPane.showMessageDialog(this, "No puedes poner una fecha anterior a la de hoy");
            } else{
            
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = format.format(selectedDate);

                String hora = new SimpleDateFormat("HH:mm").format(jSpinnerHour.getModel().getValue());                      
                
                try {
                    SocketHandler.getOut().println(Mensajes.PETICION_UPDATE_ACTIVIDAD_RECURRENTE + "--" + hora + "--" + dateString + "--" + listaIdEmpleados.get(jComboIdEmpleadoSleccionado) + "--" + listaIdSalas.get(jComboidSalaSeleccionado)  + "--" + this.actividad.getId());
                
                    String received = "";
                    received = SocketHandler.getIn().readLine();
                    
                    if(received.equals(Mensajes.PETICION_UPDATE_ACTIVIDAD_RECURRENTE_CORRECTO)){
                        this.dispose();
                        this.sParent.setEnabled(true);
                        this.parent.ObtenerActividades();
                    }
                    
                    if(received.equals(Mensajes.PETICION_UPDATE_ACTIVIDAD_RECURRENTE_ERROR)){
                        JOptionPane.showMessageDialog(this, "Error al intentar actualizar la actividad\nIntentelo mas tarde");
                    }
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(EditarActividadRecurrente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
        
        }
        
        
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jCBSalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBSalaItemStateChanged
        this.jComboidSalaSeleccionado = jCBSala.getSelectedIndex();
    }//GEN-LAST:event_jCBSalaItemStateChanged

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
            java.util.logging.Logger.getLogger(EditarActividadRecurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarActividadRecurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarActividadRecurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarActividadRecurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarActividadRecurrente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JComboBox<String> jCBEmpleado;
    private javax.swing.JComboBox<String> jCBSala;
    private com.toedter.calendar.JCalendar jCalendarDay;
    private javax.swing.JLabel jLNombreTipoActividad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinnerHour;
    // End of variables declaration//GEN-END:variables
}
