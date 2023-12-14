/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import com.toedter.calendar.JDateChooser;
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
import model.Cliente;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class FormularioClienteMayor extends javax.swing.JFrame {

    PanelPropietario sParent;
    jPanelListadoClientes parent;
    int idLudoteca = -1;
    Cliente cliente;
    public FormularioClienteMayor() {
        
    }

    FormularioClienteMayor(PanelPropietario sParent, jPanelListadoClientes parent, int idLudoteca) {
        initComponents();
        
        this.sParent = sParent;
        this.parent = parent;
        this.idLudoteca = idLudoteca;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
//setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Añadir nuevo mayor de edad");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
               
    }

    FormularioClienteMayor(PanelPropietario sParent, jPanelListadoClientes parent, Cliente cliente){
    
        initComponents();
        
        this.sParent = sParent;
        this.parent = parent;
        this.cliente = cliente;
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Editar Cliente Mayor");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        jLabel1.setText("Editar Cliente");
        jBAceptar.setText("Actualizar");
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = cliente.getFechaNacimiento();
        Date fechaN = null;

        try{
            fechaN = formato.parse(fechaString);
        } catch(ParseException e){
            e.printStackTrace();
        }        
                
        this.jTFNombre.setText(cliente.getNombreC());
        this.jTFApellidos.setText(cliente.getApellidosC());
        this.jDateFechaNacimiento.setDate(fechaN);
        this.jTFDni.setText(cliente.getDniC());
        this.jTFPhone.setText(cliente.getPhoneC());
        this.jTFUser.setText(cliente.getUserC());
        this.jTFUser.setEnabled(false);
        this.jTFPassword.setText(cliente.getPasswordC());
        this.jTFPassword.setEnabled(false);
        this.jTFCorreo.setText(cliente.getCorreoC());
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFPhone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTFCorreo = new javax.swing.JTextField();
        jTFApellidos = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jBAceptar = new javax.swing.JButton();
        jLMensajeError = new javax.swing.JLabel();
        jTFPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Cliente Mayor de edad");

        jDateFechaNacimiento.setDateFormatString("dd/MM/yyyy");
        jDateFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Fecha de Nacimiento:");

        jTFNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Dni:");

        jTFDni.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Usuario:");

        jTFUser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Contraseña:");

        jTFPhone.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Correo:");

        jTFCorreo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jTFApellidos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jBAceptar.setText("Crear");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jLMensajeError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLMensajeError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelAtras)
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFPassword))
                            .addComponent(jTFCorreo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
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
        this.parent.setEnabled(true);
    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed

        this.jTFNombre.setText("");
        this.jTFApellidos.setText("");
        this.jTFDni.setText("");
        this.jTFPhone.setText("");
        this.jTFUser.setText("");
        this.jTFPassword.setText("");
        this.jTFCorreo.setText("");
        //this.jDateFechaNacimiento.cle
                
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed

        jLMensajeError.setText("");
        
        if(jTFNombre.getText().isEmpty() || jTFApellidos.getText().isEmpty() || jTFDni.getText().isEmpty() || jTFPhone.getText().isEmpty() || jTFCorreo.getText().isEmpty() || jTFUser.getText().isEmpty() || String.valueOf(jTFPassword.getPassword()).isEmpty()){
            this.jLMensajeError.setForeground(Color.red);
            this.jLMensajeError.setText("Ningun campo puede estar vacio");        
        }else {
            
            Date dateNacimiento = jDateFechaNacimiento.getDate();

            if(dateNacimiento == null){
                this.jLMensajeError.setForeground(Color.red);
                this.jLMensajeError.setText("Por favor, seleccione una fecha de nacimiento");   
            }else{
                
                Calendar hoy = Calendar.getInstance();
                
                Calendar nacimiento  = Calendar.getInstance();
                nacimiento.setTime(dateNacimiento);
                
                int diferenciaEdad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
                
                if(diferenciaEdad < 18){
                    this.jLMensajeError.setForeground(Color.red);
                    this.jLMensajeError.setText("El cliente es menor de edad, Agregelo como menor"); 
                }else if(diferenciaEdad == 18){
                    
                   if(nacimiento.get(Calendar.MONTH) > hoy.get(Calendar.MONTH) || (nacimiento.get(Calendar.MONTH) == hoy.get(Calendar.MONTH) && nacimiento.get(Calendar.DAY_OF_MONTH) > hoy.get(Calendar.DAY_OF_MONTH)) ){
                       this.jLMensajeError.setForeground(Color.red);
                       this.jLMensajeError.setText("El cliente es menor de edad, Agregelo como menor");                        
                   }else{
                   
                       agregarCliente(dateNacimiento);
                   }
                    
                } else {
                    agregarCliente(dateNacimiento);
                }    
            }   
        }      
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void agregarCliente(Date dateNacimiento) {
    
        long d = dateNacimiento.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        
        boolean correoValido;
            
        String regx = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regx);

        Matcher matcher = pattern.matcher(jTFCorreo.getText());

        matcher.matches();

        correoValido = matcher.matches();
        
        if(!correoValido){
            this.jLMensajeError.setForeground(Color.red);
            this.jLMensajeError.setText("El correo proporcionado no es valido");
        } else {
                
            if( idLudoteca == -1){
                System.out.println("Parte de actualizar");
                try{
                    SocketHandler.getOut().println(Mensajes.PETICION_UPDATE_CLIENTE_MAYOR + "--" + jTFNombre.getText() + "--" + jTFApellidos.getText() + "--" + fecha + "--" + jTFDni.getText() + "--" + jTFPhone.getText() + "--" + jTFUser.getText()  + "--" + String.valueOf(jTFPassword.getPassword()) + "--" + jTFCorreo.getText() + "--" + cliente.getId() );

                    String received = "";

                    received = SocketHandler.getIn().readLine();

                    if(received.equals(Mensajes.PETICION_UPDATE_CLIENTE_MAYOR_CORRECTO)){
                        this.dispose();
                        this.sParent.setEnabled(true);
                        parent.setEnabled(true);
                        parent.ObtenerClientes();
                    } 
                    if(received.equals(Mensajes.PETICION_UPDATE_CLIENTE_MAYOR_ERROR)){
                        JOptionPane.showMessageDialog(this, "Error al intentar actualizar el cliente \nIntentelo mas tarde");
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(FormularioClienteMayor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("peticion crear nuevo cliente");

                try {

                    String received ="";

                    SocketHandler.getOut().println(Mensajes.PETICION_CREAR_CLIENTE_MAYOR + "--" + jTFNombre.getText() + "--" + jTFApellidos.getText() + "--" + fecha + "--" + jTFDni.getText() + "--" + jTFPhone.getText() + "--" + jTFUser.getText()  + "--" + String.valueOf(jTFPassword.getPassword()) + "--" + jTFCorreo.getText() + "--" + idLudoteca);

                    received = SocketHandler.getIn().readLine();

                    if(received.equals(Mensajes.PETICION_CREAR_CLIENTE_MAYOR_CORRECTA)){
                        JOptionPane.showMessageDialog(sParent, "Cliente Creado");
                        this.dispose();
                        sParent.setEnabled(true);
                        parent.ObtenerClientes();
                    }
                    if(received.equals(Mensajes.PETICION_CREAR_CLIENTE_MAYOR_ERROR)){
                        this.jLMensajeError.setForeground(Color.red);
                        this.jLMensajeError.setText("Algun dato esta duplicado");
                    }


                } catch (IOException ex) {
                    Logger.getLogger(FormularioClienteMayor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
        }
        
    }
    
    
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
            java.util.logging.Logger.getLogger(FormularioClienteMayor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioClienteMayor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioClienteMayor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioClienteMayor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioClienteMayor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBLimpiar;
    private com.toedter.calendar.JDateChooser jDateFechaNacimiento;
    private javax.swing.JLabel jLMensajeError;
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
