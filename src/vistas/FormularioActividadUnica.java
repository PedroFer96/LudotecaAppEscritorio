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
public class FormularioActividadUnica extends javax.swing.JFrame {

    PanelPropietario sParent;
    jPanelListadoActividades parent;
    Actividades actividad;
    int idLudoteca;
    int idActividadUnica = -1;
    
    ArrayList<String> listaIdTipos = new ArrayList();
    ArrayList<String> listaIdEmpleados = new ArrayList<>();
    ArrayList<String> listaIdSalas = new ArrayList<>();
    
    
    int jComboIdTipoSeleccionado = 0;
    int jComboIdEmpleadoSleccionado = 0;
    int jComboidSalaSeleccionado = 0;
    
    public FormularioActividadUnica() {        
    }

    FormularioActividadUnica(PanelPropietario sParent, jPanelListadoActividades parent, int idLudoteca) {
        initComponents();
        
        this.sParent=sParent;
        this.parent= parent;
        this.idLudoteca= idLudoteca;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Añadir Actividad Unica");
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
        
        ObtenerTipo();
        ObtenerEmpleados();
        ObtenerSalas();
    }

    FormularioActividadUnica(PanelPropietario sParent, jPanelListadoActividades parent, Actividades actividad, int idLudoteca) {
        initComponents();
        this.sParent = sParent;
        this.parent = parent;
        this.actividad = actividad;
        this.idLudoteca = idLudoteca;
        this.idActividadUnica = actividad.getId();
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Editar Actividad (Unica)");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.jLabel1.setText("Editar Actividad");
        this.jBCrear.setText("Actualizar");
        
        
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
        
        ObtenerTipo();
        ObtenerEmpleados();
        ObtenerSalas();
        
        
        //Carga de datos
        String empleado = this.actividad.getNombre() + " " + this.actividad.getApellidos();
        String sala = this.actividad.getSala();       
        
        jCBTipoActivity.setSelectedItem(this.actividad.getNombreTipo());
        jComboIdTipoSeleccionado = jCBTipoActivity.getSelectedIndex();
        jCBTipoActivity.setEnabled(false);
        
        jCBEmpleado.setSelectedItem(empleado);
        jComboIdEmpleadoSleccionado = jCBEmpleado.getSelectedIndex();
        
        jCBSala.setSelectedItem(sala);
        jComboidSalaSeleccionado = jCBSala.getSelectedIndex();
        
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
    
   private void ObtenerTipo(){
    
        try{
        
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_TIPO_X_LUDOTECA + "--" + idLudoteca);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            int nTipos = Integer.parseInt(args[1]);
            
            for (int i = 0 ; i< nTipos; i++){
                received = SocketHandler.getIn().readLine();
                args = received.split("--");
                
                listaIdTipos.add(args[1]);
                jCBTipoActivity.addItem(args[2]);
            }
        } catch (IOException ex) {
            Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAtras5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerHour = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jCBTipoActivity = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jBCrear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCalendarDay = new com.toedter.calendar.JCalendar();
        jLabel3 = new javax.swing.JLabel();
        jCBEmpleado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jCBSala = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAtras5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtras5MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Nueva Actividad Unica");

        jSpinnerHour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinnerHour.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1701030252641L), null, null, java.util.Calendar.HOUR_OF_DAY));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Actividad:");

        jCBTipoActivity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBTipoActivityItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Hora Inicio:");

        jBCrear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBCrear.setText("Crear");
        jBCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Empleado:");

        jCBEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBEmpleadoItemStateChanged(evt);
            }
        });

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
                        .addGap(58, 58, 58)
                        .addComponent(jLabelAtras5)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(jBCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(66, 66, 66)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jCBTipoActivity, 0, 211, Short.MAX_VALUE)
                                    .addComponent(jSpinnerHour, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(jCBEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBSala, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAtras5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTipoActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerHour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBEmpleado))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jCBSala)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jLabelAtras5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtras5MouseClicked
        this.dispose();
        this.sParent.setEnabled(true);
    }//GEN-LAST:event_jLabelAtras5MouseClicked

    private void jCBTipoActivityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBTipoActivityItemStateChanged
        this.jComboIdTipoSeleccionado = jCBTipoActivity.getSelectedIndex();
    }//GEN-LAST:event_jCBTipoActivityItemStateChanged

    private void jBCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearActionPerformed

            if(listaIdTipos.isEmpty() || listaIdEmpleados.isEmpty() || listaIdSalas.isEmpty()){
                JOptionPane.showMessageDialog(this, "Usted NO ha creado algun dato para poder crear una actividad\nya sea: Tipo, Empleado o Sala.");
            }else {            
                Date selectedDate = jCalendarDay.getDate();
                Date currentDate = new Date();

                if(selectedDate.before(currentDate)){
                    JOptionPane.showMessageDialog(this, "No puedes poner una fecha anterior a la de hoy");
                } else{

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = format.format(selectedDate);

                    String hora = new SimpleDateFormat("HH:mm").format(jSpinnerHour.getModel().getValue());

                    if(idActividadUnica != -1 ){
                        System.out.println("Parte de actualizar");
                        
                        try {
                            
                            SocketHandler.getOut().println(Mensajes.PETICION_UPDATE_ACTIVIDAD_UNICA + "--" + dateString + "--" + hora + "--" + listaIdEmpleados.get(jComboIdEmpleadoSleccionado) + "--" + listaIdSalas.get(jComboidSalaSeleccionado) + "--" + idActividadUnica );
                            
                            String received = "";
                            received = SocketHandler.getIn().readLine();
                            
                            if(received.equals(Mensajes.PETICION_UPDATE_ACTIVIDAD_UNICA_CORRECTO)){
                                this.dispose();
                                this.sParent.setEnabled(true);
                                this.parent.ObtenerActividades();
                            }
                            if(received.equals(Mensajes.PETICION_UPDATE_ACTIVIDAD_UNICA_ERROR)){
                                JOptionPane.showMessageDialog(this, "Error al intentar edtiar la actividad\nIntentelo mas tarde");
                            }
                        
                        } catch (IOException ex) {
                            Logger.getLogger(FormularioActividadUnica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }else {
                        System.out.println("Crear actividad Unica");
                        
                        try {

                            SocketHandler.getOut().println(Mensajes.PETICION_CREAR_ACTIVIDAD_UNICA + "--" + listaIdTipos.get(jComboIdTipoSeleccionado) + "--" + hora + "--" + dateString + "--" + listaIdEmpleados.get(jComboIdEmpleadoSleccionado) + "--" + listaIdSalas.get(jComboidSalaSeleccionado) );

                            String received = "";
                            received = SocketHandler.getIn().readLine();

                            if(received.equals(Mensajes.PETICION_CREAR_ACTIVIDAD_UNICA_CORRECTO)){
                                this.dispose();
                                this.sParent.setEnabled(true);
                                this.parent.ObtenerActividades();
                            }
                            if(received.equals(Mensajes.PETICION_CREAR_ACTIVIDAD_UNICA_ERROR)){
                                JOptionPane.showMessageDialog(this, "Ya existe una actividad con esos datos\nmejor edite dicha actvidad");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(FormularioActividadUnica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    
                }
            }                 

    }//GEN-LAST:event_jBCrearActionPerformed

    private void jCBEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEmpleadoItemStateChanged
        this.jComboIdEmpleadoSleccionado = jCBEmpleado.getSelectedIndex();
    }//GEN-LAST:event_jCBEmpleadoItemStateChanged

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
            java.util.logging.Logger.getLogger(FormularioActividadUnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioActividadUnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioActividadUnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioActividadUnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioActividadUnica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCrear;
    private javax.swing.JComboBox<String> jCBEmpleado;
    private javax.swing.JComboBox<String> jCBSala;
    private javax.swing.JComboBox<String> jCBTipoActivity;
    private com.toedter.calendar.JCalendar jCalendarDay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAtras5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinnerHour;
    // End of variables declaration//GEN-END:variables

}
