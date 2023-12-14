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
import model.Propietario;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class AñadirPropietario extends javax.swing.JFrame {

    PanelAdmin parentSuper;
    jPanelListadoPropietarios parent;
    String correo = null;
    Propietario propietario;
    String idPropietario = null;

    private AñadirPropietario() {
        
    }

    AñadirPropietario(PanelAdmin parentSuper, jPanelListadoPropietarios parent) {
       initComponents();
       
       try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
       this.setTitle("Añadir Propietario");
       this.parentSuper = parentSuper;
       this.parent = parent;
       this.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    AñadirPropietario(PanelAdmin parent, String correo) {
        //Este es para editar
       initComponents();
       
       try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
       //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
       this.setTitle("Editar Propietario");
       this.parentSuper = parent;
       this.correo = correo;
       this.getContentPane().setBackground(Color.LIGHT_GRAY);
       jLabel3.setText("Editar Propietario");
       jButtonCrear.setText("Actualizar");
       cargarPropietario();
       
    }

    AñadirPropietario(PanelAdmin parentSuper, jPanelListadoLudotecas parent, String id_propietario) {
        
        initComponents();
        
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }

//setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Editar Propietario");
        this.parentSuper=parentSuper;
        this.idPropietario = id_propietario;
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        jLabel3.setText("Editar Propietario");
        jButtonCrear.setText("Actualizar");
        
        cargarPropietarioId();
    }

   
    private void cargarPropietario() {

        try{
            
            String received = "";
            String [] args;
            
            System.out.println("Peticion de editar propietario");

            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_EDITAR_PROPIETARIO + "--" + correo );

            received = SocketHandler.getIn().readLine();

            args = received.split("--");
            
            propietario = new Propietario(Integer.parseInt(args[1]),args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9]);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = propietario.getFechaNacimiento();
            Date fechaN = null;
            
            try{
                fechaN = formato.parse(fechaString);
            } catch(ParseException e){
                e.printStackTrace();
            }  
            
            this.jTFNombre.setText(propietario.getNombre());
            this.jTFApellidos.setText(propietario.getApellidos());
            this.jDateFechaNacimiento.setDate(fechaN);
            this.jTFDni.setText(propietario.getDni());
            this.jTFTelefono.setText(propietario.getPhone());
            this.jTFCorreo.setText(propietario.getCorreo());
            this.jTFUser.setText(propietario.getUser());
            this.jPFPassword.setText(propietario.getPassword());
            
        } catch (IOException ex) {
            Logger.getLogger(AñadirPropietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void cargarPropietarioId() {
    
        try{
        
            String received = "";
            String [] args;
            
            
            SocketHandler.getOut().println(Mensajes.PETICION_MOSTRAR_EDITAR_PROPIETARIO + "--" + idPropietario);
            
            received = SocketHandler.getIn().readLine();
            
            args = received.split("--");
            
            propietario = new Propietario(Integer.parseInt(args[1]),args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9]);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = propietario.getFechaNacimiento();
            Date fechaN = null;
            
            try{
                fechaN = formato.parse(fechaString);
            } catch(ParseException e){
                e.printStackTrace();
            }
            
            this.jTFNombre.setText(propietario.getNombre());
            this.jTFApellidos.setText(propietario.getApellidos());
            this.jDateFechaNacimiento.setDate(fechaN);
            this.jTFDni.setText(propietario.getDni());
            this.jTFTelefono.setText(propietario.getPhone());
            this.jTFCorreo.setText(propietario.getCorreo());
            this.jTFUser.setText(propietario.getUser());
            this.jPFPassword.setText(propietario.getPassword());
        
        } catch (IOException ex) {
            Logger.getLogger(AñadirPropietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jTFApellidos = new javax.swing.JTextField();
        jTFDni = new javax.swing.JTextField();
        jTFTelefono = new javax.swing.JTextField();
        jTFCorreo = new javax.swing.JTextField();
        jTFUser = new javax.swing.JTextField();
        jPFPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelMensajeError = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCrear = new javax.swing.JButton();
        jLabelAtras = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Añadir Nuevo Propietario");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Dni:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Telefono:");

        jTFNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTFApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTFDni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTFTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTFUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPFPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Correo Electronico:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Contraseña:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Usuario:");

        jLabelMensajeError.setBackground(new java.awt.Color(255, 255, 255));

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonCrear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCrear.setText("Crear");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento:");

        jDateFechaNacimiento.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAtras)
                                .addGap(143, 143, 143)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(63, 63, 63)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jPFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelMensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTFCorreo)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        
        this.jTFNombre.setText("");
        this.jTFApellidos.setText("");
        this.jTFDni.setText("");
        this.jTFTelefono.setText("");
        this.jTFCorreo.setText("");
        this.jTFUser.setText("");
        this.jPFPassword.setText("");
        
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed

        this.jLabelMensajeError.setText("");
        
        if(jTFNombre.getText().isEmpty() || jTFApellidos.getText().isEmpty() || jTFDni.getText().isEmpty() || jTFTelefono.getText().isEmpty() || jTFUser.getText().isEmpty() || String.valueOf(jPFPassword.getPassword()).isEmpty() || jTFCorreo.getText().isEmpty() ) {
            this.jLabelMensajeError.setForeground(Color.red);
            this.jLabelMensajeError.setText("Ningun campo puede estar vacio");
        }else{        
            
            Date dateNacimiento = jDateFechaNacimiento.getDate();

            if(dateNacimiento == null){
                this.jLabelMensajeError.setForeground(Color.red);
                this.jLabelMensajeError.setText("Por favor, seleccione una fecha de nacimiento");   
            }else{
            
                Calendar hoy = Calendar.getInstance();
                
                Calendar nacimiento  = Calendar.getInstance();
                nacimiento.setTime(dateNacimiento);
                
                int diferenciaEdad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
                
                if(diferenciaEdad < 18){
                    this.jLabelMensajeError.setForeground(Color.red);
                    this.jLabelMensajeError.setText("El Propietario no puede ser menor de edad"); 
                }else {
                
                    agregarPropietario(dateNacimiento);
                }            
            }                                            
        }
        
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void agregarPropietario(Date dateNacimiento) {
        
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
        }else{
            if(correo != null || idPropietario != null){ // si es distinto a null es que estamos en la parte de editar propietario

                try{

                    String received ="";

                    System.out.println("Peticion actualizar");

                    SocketHandler.getOut().println(Mensajes.PETICION_EDITAR_PROPIETARIO + "--" + propietario.getId()  + "--" + jTFNombre.getText() + "--" + jTFApellidos.getText() + "--" + fecha  + "--" + jTFDni.getText() + "--" + jTFTelefono.getText() + "--" + jTFCorreo.getText() + "--" + jTFUser.getText() + "--" + String.valueOf(jPFPassword.getPassword()) );

                    received = SocketHandler.getIn().readLine();

                    if(received.equals(Mensajes.PETICION_EDITAR_PROPIETARIO_ERROR)){
                        this.jLabelMensajeError.setForeground(Color.red);
                        this.jLabelMensajeError.setText("Algun dato esta duplicado o no es correcto");
                    }else if(received.equals(Mensajes.PETICION_EDITAR_PROPIETARIO_CORRECTO)){

                        this.parentSuper.setEnabled(true);
                        //parent.setVisible(true);
                        this.dispose();

                       this.parent.mostrarPropietarios();

                    }
                } catch (IOException ex) {
                    Logger.getLogger(AñadirPropietario.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else{


                try{
                    String received = "";

                    System.out.println("Peticion de nuevo propietario");

                    SocketHandler.getOut().println(Mensajes.PETICION_CREAR_PROPIETARIO + "--" + jTFNombre.getText() + "--" + jTFApellidos.getText() + "--" + fecha  + "--" + jTFDni.getText() + "--" + jTFTelefono.getText() + "--" + jTFCorreo.getText() + "--" + jTFUser.getText() + "--" + String.valueOf(jPFPassword.getPassword()));

                    received = SocketHandler.getIn().readLine();

                    if(received.equals(Mensajes.PETICION_CREAR_PROPIETARIO_ERROR)){
                        this.jLabelMensajeError.setForeground(Color.red);
                        this.jLabelMensajeError.setText("Algun dato esta duplicado");
                    }else if(received.equals(Mensajes.PETICION_CREAR_PROPIETARIO_CORRECTA)){                            
                        this.parentSuper.setEnabled(true);
                        //parent.setVisible(true);
                        this.dispose();
                        this.parent.mostrarPropietarios();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(AñadirPropietario.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } 
        
        
    }
    
    
    
    
    private void jLabelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtrasMouseClicked
        this.dispose();
        parentSuper.setEnabled(true);
//        parent.setEnabled(true);
//        parent.setVisible(true);
        
        
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
            java.util.logging.Logger.getLogger(AñadirPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirPropietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrear;
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
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFApellidos;
    private javax.swing.JTextField jTFCorreo;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFTelefono;
    private javax.swing.JTextField jTFUser;
    // End of variables declaration//GEN-END:variables



}
