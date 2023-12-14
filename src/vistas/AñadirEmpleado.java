/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Empleado;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class AñadirEmpleado extends javax.swing.JFrame {

    PanelPropietario superParent;
    jPanelListadoPEmpleados parent;
    int idLudoteca = -1;
    Empleado empleado;
    
    public AñadirEmpleado() {
        
    }

    AñadirEmpleado(PanelPropietario sParent, jPanelListadoPEmpleados parent, int id_ludoteca) {
        this.superParent = sParent;
        this.parent = parent;
        this.idLudoteca = id_ludoteca;
        
        initComponents();
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Añadir nuevo empleado");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
    }


    
     AñadirEmpleado(PanelPropietario sParent, jPanelListadoPEmpleados parent, Empleado empleado) {
        initComponents();
        this.superParent = sParent;
        this.parent = parent;
        this.empleado = empleado;
        
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
            } catch (IOException ex1) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Editar empleado");
        jLabel1.setText("Editar Empleado");
        jButtonCrearEmpleado.setText("Actualizar" );
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        cargarEmpleado();
        
    }

     private void cargarEmpleado(){
         
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = empleado.getFechaNacimiento();
        Date fechaN = null;
         
        try{
            fechaN = formato.parse(fechaString);
        } catch(ParseException e){
            e.printStackTrace();
        }  
         
         this.jTFNombre.setText(empleado.getNombre());
         this.jTFApellidos.setText(empleado.getApellidos());
         this.jDateFechaNacimiento.setDate(fechaN);
         this.jTFDni.setText(empleado.getDni());
         this.jTFPhone.setText(empleado.getPhone());
         this.jTFUser.setText(empleado.getUser());
         this.jTFUser.setEnabled(false);
         this.jTFPassword.setText(empleado.getPassword());
         this.jTFCorreo.setText(empleado.getCorreo());
                 
     
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jTFApellidos = new javax.swing.JTextField();
        jTFDni = new javax.swing.JTextField();
        jTFPhone = new javax.swing.JTextField();
        jTFUser = new javax.swing.JTextField();
        jTFCorreo = new javax.swing.JTextField();
        jLabelMensajeError = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCrearEmpleado = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jTFPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Empleado");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Dni:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Usuario:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Contraseña:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Correo:");

        jTFNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTFApellidos.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTFDni.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTFPhone.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTFUser.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTFCorreo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonCrearEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCrearEmpleado.setText("Crear");
        jButtonCrearEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearEmpleadoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFDni)
                                    .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jTFPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFPassword))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTFNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                                            .addComponent(jTFCorreo)
                                            .addComponent(jTFApellidos)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(43, 43, 43)
                                        .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelMensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(jLabel1)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCrearEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
        superParent.setEnabled(true);
        parent.setEnabled(true);
        
    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
    
        this.jTFNombre.setText("");
        this.jTFApellidos.setText("");
        this.jTFDni.setText("");
        this.jTFPhone.setText("");
        this.jTFUser.setText("");
        this.jTFPassword.setText("");
        this.jTFCorreo.setText("");
        
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearEmpleadoActionPerformed
        this.jLabelMensajeError.setText("");
        
        if(jTFNombre.getText().isEmpty() || jTFApellidos.getText().isEmpty() || jTFDni.getText().isEmpty() || jTFPhone.getText().isEmpty() || jTFUser.getText().isEmpty() || String.valueOf(jTFPassword.getPassword()).isEmpty() || jTFCorreo.getText().isEmpty()) {
            this.jLabelMensajeError.setForeground(Color.red);
            this.jLabelMensajeError.setText("Ningun campo puede estar vacio");
        } else {
            
            Date dateNacimiento = jDateFechaNacimiento.getDate();
            
            if(dateNacimiento == null){
                this.jLabelMensajeError.setForeground(Color.red);
                this.jLabelMensajeError.setText("Por favor, seleccione una fecha de nacimiento");                           
            }else{
                
                Calendar hoy = Calendar.getInstance();
                
                Calendar nacimiento = Calendar.getInstance();
                nacimiento.setTime(dateNacimiento);
                
                int diferenciaEdad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
                
                if( diferenciaEdad < 18){
                    this.jLabelMensajeError.setForeground(Color.red);
                    this.jLabelMensajeError.setText("El empleado es menor de edad"); 
                }else{
                    agregarEmpleado(dateNacimiento);
                }
                
                
                
            }
        }
    }//GEN-LAST:event_jButtonCrearEmpleadoActionPerformed

    private void agregarEmpleado(Date dateNacimiento) {
    
        long d = dateNacimiento.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        
        boolean correoValido;

        String regx = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regx);

        Matcher matcher = pattern.matcher(jTFCorreo.getText());

        matcher.matches();

        correoValido = matcher.matches();

        if(!correoValido){
            this.jLabelMensajeError.setForeground(Color.red);
            this.jLabelMensajeError.setText("El correo proporcionado no es valido");
        } else {

            if ( idLudoteca == -1){
                System.out.println("Parte de actualizar");
                
                try {
                    SocketHandler.getOut().println(Mensajes.PETICION_UPDATE_EMPLEADO + "--" + jTFNombre.getText() + "--" + jTFApellidos.getText() + "--" + fecha + "--" + jTFDni.getText() + "--" + jTFPhone.getText() + "--" + jTFUser.getText() + "--" + String.valueOf(jTFPassword.getPassword()) + "--" + jTFCorreo.getText() + "--" + empleado.getId());
                    
                    String received = "";
                    
                    received  = SocketHandler.getIn().readLine();
                    
                    if(received.equals(Mensajes.PETICION_UPDATE_EMPLEADO_CORRECTO)){
                        this.dispose();
                        this.superParent.setEnabled(true);
                        this.superParent.setVisible(true);
                        this.parent.ObtenerEmpleados();
                    }
                    if(received.equals(Mensajes.PETICION_UPDATE_EMPLEADO_ERROR)){
                        JOptionPane.showMessageDialog(this, "Error al intentar actualizar el empleado \nIntentelo mas tarde");
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(AñadirEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {

                System.out.println("peticion de crear");

                try{
                    String received = "";

                    SocketHandler.getOut().println(Mensajes.PETICION_CREAR_EMPLEADO + "--" + jTFNombre.getText() + "--" + jTFApellidos.getText() + "--" + fecha + "--" + jTFDni.getText() + "--" + jTFPhone.getText() + "--" + jTFUser.getText() + "--" + String.valueOf(jTFPassword.getPassword()) + "--" + jTFCorreo.getText() + "--" + idLudoteca);

                    received = SocketHandler.getIn().readLine();


                    if (received.equals(Mensajes.PETICION_CREAR_EMPLEADO_CORRECTO)){

                        JOptionPane.showMessageDialog(superParent, "Empleado Creado");
                        this.parent.ObtenerEmpleados();
                        superParent.setEnabled(true);
                        parent.setEnabled(true);
                        
                        this.dispose();

                    }
                    if(received.equals(Mensajes.PETICION_CREAR_EMPLEADO_ERROR)){
                        this.jLabelMensajeError.setForeground(Color.red);
                        this.jLabelMensajeError.setText("Algun dato esta duplicado");
                    }


                } catch (IOException ex) {
                    Logger.getLogger(AñadirEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                        
        }
        
        
        
        
    }
    
    
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
            java.util.logging.Logger.getLogger(AñadirEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrearEmpleado;
    private javax.swing.JButton jButtonLimpiar;
    private com.toedter.calendar.JDateChooser jDateFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JLabel jLabelMensajeError;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFApellidos;
    private javax.swing.JTextField jTFCorreo;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JPasswordField jTFPassword;
    private javax.swing.JTextField jTFPhone;
    private javax.swing.JTextField jTFUser;
    // End of variables declaration//GEN-END:variables


}
