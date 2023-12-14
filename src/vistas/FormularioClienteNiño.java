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
import model.Cliente;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class FormularioClienteNiño extends javax.swing.JFrame {

    PanelPropietario sParent;
    jPanelListadoClientes parent;
    int idLudoteca = -1;
    Cliente cliente;
    
    public FormularioClienteNiño() {
        
    }

    FormularioClienteNiño(PanelPropietario sParent, jPanelListadoClientes parent, int idLudoteca) {
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
        this.setTitle("Añadir nuevo niño");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    FormularioClienteNiño(PanelPropietario sParent, jPanelListadoClientes parent, Cliente cliente){
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
        this.setTitle("Editar Cliente Menor");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        jLabel1.setText("Editar cliente");
        jButtonCrear.setText("Actualizar");
        jLabel10.setText("Editar Tutor");
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaStringC = cliente.getFechaNacimiento();
        
        Date fechaNC = null;
        
        try{
            fechaNC = formato.parse(fechaStringC);
        } catch (ParseException ex) {
            Logger.getLogger(FormularioClienteNiño.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String fechaStringT = cliente.getFechaNacimientoTutor();
        Date fechaNT = null;
        
        try{
            fechaNT = formato.parse(fechaStringT);
        } catch (ParseException ex) {
            Logger.getLogger(FormularioClienteNiño.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        this.jTFNombreC.setText(cliente.getNombreC());
        this.jTFApellidosC.setText(cliente.getApellidosC());
        this.jDateNacimientoC.setDate(fechaNC);
        this.jTFDniC.setText(cliente.getDniC());
        this.jTFPhoneC.setText(cliente.getPhoneC());
        this.jTFUser.setText(cliente.getUserC());
        this.jTFUser.setEnabled(false);
        this.jTFPassword.setText(cliente.getPasswordC());
        this.jTFPassword.setEnabled(false);
        this.jTFCorreo.setText(cliente.getCorreoC());
        this.jTFNombreT.setText(cliente.getNombreT());
        this.jTFApellidosT.setText(cliente.getApellidosT());
        this.jDateNacimientoT.setDate(fechaNT);
        this.jTFDniT.setText(cliente.getDniT());
        this.jTFPhoneT.setText(String.valueOf(cliente.getPhoneT()));
        this.jTFCodSeguridad.setText(String.valueOf(cliente.getCodSeguridad()));
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFNombreC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFApellidosC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateNacimientoC = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jTFDniC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFPhoneC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonCrear = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTFNombreT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFApellidosT = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jDateNacimientoT = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTFDniT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTFPhoneT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTFCodSeguridad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTFCorreo = new javax.swing.JTextField();
        jLabelMensajeError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jTFPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Cliente Menor de edad");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Nombre:");

        jTFNombreC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFNombreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreCActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Apellidos:");

        jTFApellidosC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Fecha Nacimiento:");

        jDateNacimientoC.setDateFormatString("dd/MM/yyyy");
        jDateNacimientoC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Correo:");

        jTFDniC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Telefono:");

        jTFPhoneC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Usuario");

        jTFUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Contraseña:");

        jButtonCrear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCrear.setText("Crear");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });

        jBLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Nombre:");

        jTFNombreT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Agregar a  su Tutor");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("Apellidos:");

        jTFApellidosT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        jSeparator1.setAlignmentY(5.5F);

        jDateNacimientoT.setDateFormatString("dd/MM/yyyy");
        jDateNacimientoT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("Fecha Nacimiento:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel13.setText("Dni:");

        jTFDniT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel14.setText("Telefono:");

        jTFPhoneT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Codigo de Seguridad:");

        jTFCodSeguridad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("Dni:");

        jTFCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelMensajeError.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Fax", 1, 13)); // NOI18N
        jTextArea1.setRows(3);
        jTextArea1.setText("Si el niño no posee un numero de telefono o un correo, \nusar el de su tutor.");
        jTextArea1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/warning.png"))); // NOI18N

        jTFPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelMensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAtras)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel1)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(172, 172, 172)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTFApellidosC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(151, 151, 151)
                                                .addComponent(jDateNacimientoC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jTFNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(230, 230, 230)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTFPhoneC, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                                .addComponent(jTFPassword)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTFDniC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTFCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addGap(184, 184, 184))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTFNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTFDniT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTFPhoneT, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 72, Short.MAX_VALUE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTFApellidosT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(210, 210, 210)
                                                .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1)
                                        .addContainerGap())
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFCodSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateNacimientoT, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFApellidosT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFDniT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFPhoneT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateNacimientoT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCodSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFApellidosC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateNacimientoC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPhoneC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDniC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtrasMouseClicked
        this.dispose();
        this.sParent.setEnabled(true);
        this.parent.setEnabled(true);
    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jTFNombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreCActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        this.jTFNombreC.setText("");
        this.jTFApellidosC.setText("");
        this.jTFDniC.setText("");
        this.jTFPhoneC.setText("");
        this.jTFUser.setText("");
        this.jTFPassword.setText("");
        this.jTFCorreo.setText("");
        this.jTFNombreT.setText("");
        this.jTFApellidosT.setText("");
        this.jTFDniT.setText("");
        this.jTFPhoneT.setText("");
        this.jTFCodSeguridad.setText("");
        
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed

        jLabelMensajeError.setText("");
        
        if(jTFNombreC.getText().isEmpty() || jTFApellidosC.getText().isEmpty() || jTFPhoneC.getText().isEmpty() || jTFUser.getText().isEmpty() || String.valueOf(jTFPassword.getPassword()).isEmpty() || jTFCorreo.getText().isEmpty() || jTFNombreT.getText().isEmpty() || jTFApellidosT.getText().isEmpty() || jTFDniT.getText().isEmpty() || jTFPhoneT.getText().isEmpty() || jTFCodSeguridad.getText().isEmpty() ){
            this.jLabelMensajeError.setForeground(Color.red);
            this.jLabelMensajeError.setText("Ningun campo puede estar vacio");        
        } else {
        
            Date dateNacimientoT = jDateNacimientoT.getDate();
            
            if(dateNacimientoT == null){
                this.jLabelMensajeError.setForeground(Color.red);
                this.jLabelMensajeError.setText("Por favor, seleccione una fecha de nacimiento del tutor");    
            } else {
                Calendar hoy = Calendar.getInstance();

                Calendar nacimientoT  = Calendar.getInstance();
                nacimientoT.setTime(dateNacimientoT);

                int diferenciaEdadT = hoy.get(Calendar.YEAR) - nacimientoT.get(Calendar.YEAR);
                
                if(diferenciaEdadT < 18){
                    this.jLabelMensajeError.setForeground(Color.red);
                    this.jLabelMensajeError.setText("El tutor no puede ser un menor de edad"); 
                } else {
                    
                    
                    Date dateNacimientoC = jDateNacimientoC.getDate();
                    
                    if(dateNacimientoC == null){
                        this.jLabelMensajeError.setForeground(Color.red);
                this.jLabelMensajeError.setText("Por favor, seleccione una fecha de nacimiento para el menor");    
                    }else{
                        Calendar nacimientoC = Calendar.getInstance();
                        nacimientoC.setTime(dateNacimientoC);
                        int diferenciaEdadC = hoy.get(Calendar.YEAR) - nacimientoC.get(Calendar.YEAR);

                        if(diferenciaEdadC > 18){
                            this.jLabelMensajeError.setForeground(Color.red);
                            this.jLabelMensajeError.setText("El cliente no puede ser un mayor de edad"); 
                        } else {
                            agregarClienteMenor(dateNacimientoC, dateNacimientoT);
                        }  
                    }
                } 
            }
        }
        
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void agregarClienteMenor(Date dateNacimientoC, Date dateNacimientoT) {
       
        long c = dateNacimientoC.getTime();
        java.sql.Date fechaCliente = new java.sql.Date(c);
        
        long t = dateNacimientoT.getTime();
        java.sql.Date fechaTutor = new java.sql.Date(t);
        
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
        
            if( idLudoteca == -1) {
                System.out.println("Parte de actualizar");
                
                try {
                    SocketHandler.getOut().println(Mensajes.PETICION_UPDATE_CLIENTE_MENOR + "--" + jTFNombreC.getText() + "--" + jTFApellidosC.getText() + "--" + fechaCliente + "--" + jTFDniC.getText() + "--" + jTFPhoneC.getText() + "--" + jTFUser.getText()  + "--" + String.valueOf(jTFPassword.getPassword()) + "--" + jTFCorreo.getText() + "--" + jTFNombreT.getText() + "--" + jTFApellidosT.getText() + "--" + fechaTutor + "--" + jTFDniT.getText() + "--" + jTFPhoneT.getText() + "--" + jTFCodSeguridad.getText() + "--" + cliente.getId() + "--" + cliente.getIdTutor() );
                    
                    String received = "";
                    
                    received = SocketHandler.getIn().readLine();
                    
                    if(received.equals(Mensajes.PETICION_UPDATE_CLIENTE_MENOR_CORRECTO)){
                        this.dispose();
                        this.sParent.setEnabled(true);
                        parent.setEnabled(true);
                        parent.ObtenerClientes();
                    }
                    if(received.equals(Mensajes.PETICION_UPDATE_CLIENTE_MENOR_ERROR)){
                        JOptionPane.showMessageDialog(this, "Error al intentar actualizar el cliente \nIntentelo mas tarde");
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(FormularioClienteNiño.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                System.out.println("Crear nuevo cliente menor");

                try {
                    String received ="";
                    
                    SocketHandler.getOut().println(Mensajes.PETICION_CREAR_CLIENTE_MENOR + "--" + jTFNombreC.getText() + "--" + jTFApellidosC.getText() + "--" + fechaCliente + "--" + jTFDniC.getText() + "--" + jTFPhoneC.getText() + "--" + jTFUser.getText() + "--" + String.valueOf(jTFPassword.getPassword()) + "--" + jTFCorreo.getText() + "--" + jTFNombreT.getText() + "--" + jTFApellidosT.getText() + "--" + fechaTutor + "--" +jTFDniT.getText() + "--" + jTFPhoneT.getText() + "--" + jTFCodSeguridad.getText() + "--" + idLudoteca );
                    
                    received = SocketHandler.getIn().readLine();
                    
                    if(received.equals(Mensajes.PETICION_CREAR_CLIENTE_MENOR_CORRECTO)){
                        JOptionPane.showMessageDialog(sParent, "Cliente Creado");
                        this.dispose();
                        sParent.setEnabled(true);
                        parent.ObtenerClientes();
                    }
                    if(received.equals(Mensajes.PETICION_CREAR_CLIENTE_MENOR_ERROR)){
                        this.jLabelMensajeError.setForeground(Color.red);
                        this.jLabelMensajeError.setText("Algun dato esta duplicado o es incorrecto");
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(FormularioClienteNiño.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(FormularioClienteNiño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioClienteNiño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioClienteNiño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioClienteNiño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioClienteNiño().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jButtonCrear;
    private com.toedter.calendar.JDateChooser jDateNacimientoC;
    private com.toedter.calendar.JDateChooser jDateNacimientoT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFApellidosC;
    private javax.swing.JTextField jTFApellidosT;
    private javax.swing.JTextField jTFCodSeguridad;
    private javax.swing.JTextField jTFCorreo;
    private javax.swing.JTextField jTFDniC;
    private javax.swing.JTextField jTFDniT;
    private javax.swing.JTextField jTFNombreC;
    private javax.swing.JTextField jTFNombreT;
    private javax.swing.JPasswordField jTFPassword;
    private javax.swing.JTextField jTFPhoneC;
    private javax.swing.JTextField jTFPhoneT;
    private javax.swing.JTextField jTFUser;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables


}
