/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import utils.Mensajes;
import utils.SocketHandler;

/**
 *
 * @author pedro
 */
public class FormularioActividadRecurrente extends javax.swing.JFrame {

    jPanelListadoActividades sParent;
    GestionDeActividadesRecurrentes parent;
    
    int idPlanning = -1;
    int idLudoteca;
    String tipo;
    String empleado;
    String sala;
    
    ArrayList<String> listaIdTipos = new ArrayList();
    ArrayList<String> listaIdEmpleados = new ArrayList<>();
    ArrayList<String> listaIdSalas = new ArrayList<>();
    
    int jComboIdTipoSeleccionado = 0;
    int jComboIdEmpleados = 0;
    int jComboidSalaSeleccionado = 0;
    
    
    public FormularioActividadRecurrente() {        
    }

    FormularioActividadRecurrente(GestionDeActividadesRecurrentes parent, int idLudoteca) {
        initComponents();
        
        this.parent = parent;
        this.idLudoteca = idLudoteca;
        jListDias.setVisible(false);
        
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Añadir Nuevo Planning");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date hora = sdf.parse("14:00");
            SpinnerDateModel sm = new SpinnerDateModel(hora,null,null,Calendar.HOUR_OF_DAY);
            this.jSpinnerHour.setModel(sm);
            JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinnerHour,"HH:mm");
            jSpinnerHour.setEditor(de);
                    
        } catch (ParseException ex) {
            Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        buttonGroupFrecuencia.add(jRBDiaria);
        buttonGroupFrecuencia.add(jRBPersonalizada);
        
        jRBDiaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jListDias.setVisible(false);
            }
        });
        jRBPersonalizada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jListDias.setVisible(true);
            }
        });
        
        ObtenerTipo();
        ObtenerEmpleados();
        ObtenerSalas();
        
                
    }    

    FormularioActividadRecurrente(jPanelListadoActividades sparent, GestionDeActividadesRecurrentes parent, String idPlanning, int idLudoteca) {
        initComponents();
       
        this.sParent= sparent;
        this.parent = parent;
        this.idPlanning = Integer.parseInt(idPlanning);
        this.idLudoteca = idLudoteca;
        
        try {
                setIconImage(ImageIO.read(getClass().getResourceAsStream("/imagenes/icono ludoteca fondo blanco 24.png")));
        } catch (IOException ex1) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
        }
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono ludoteca fondo blanco 24.png")).getImage());
        this.setTitle("Actualizar Planning");
        this.jBCrear.setText("Actualizar");
        this.jLabel1.setText("Actualizar Planning");
        this.jListDias.setVisible(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date hora = sdf.parse("14:00");
            SpinnerDateModel sm = new SpinnerDateModel(hora,null,null,Calendar.HOUR_OF_DAY);
            this.jSpinnerHour.setModel(sm);
            JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinnerHour,"HH:mm");
            jSpinnerHour.setEditor(de);
                    
        } catch (ParseException ex) {
            Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        buttonGroupFrecuencia.add(jRBDiaria);
        buttonGroupFrecuencia.add(jRBPersonalizada);
        
        jRBDiaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jListDias.setVisible(false);
            }
        });
        jRBPersonalizada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jListDias.setVisible(true);
            }
        });
        
        
        
        
        ObtenerTipo();
        ObtenerEmpleados();
        ObtenerSalas();
        
        ObtenerPlanningId();
        
        jCBTipoActivity.setEnabled(false);
    }
    
    private void ObtenerPlanningId() {
        try{
            SocketHandler.getOut().println(Mensajes.PETICION_OBTENER_INFO_PLANNING + "--" + idPlanning);
            
            String received = SocketHandler.getIn().readLine();
            String [] args = received.split("--");
            
            
            //carga de datos
            this.tipo = args[2];
            this.empleado = args[3] + " " +args[4];
            this.sala = args[5];
            
            jCBEmpleado.setSelectedItem(this.empleado);
            jComboIdEmpleados = jCBEmpleado.getSelectedIndex();

            jCBTipoActivity.setSelectedItem(this.tipo);
            jComboIdTipoSeleccionado = jCBTipoActivity.getSelectedIndex();
            
            jCBSala.setSelectedItem(this.sala);
            jComboidSalaSeleccionado = jCBSala.getSelectedIndex();
            
        
        } catch (IOException ex) {
            Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroupFrecuencia = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelAtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRBDiaria = new javax.swing.JRadioButton();
        jRBPersonalizada = new javax.swing.JRadioButton();
        jCBTipoActivity = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerHour = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDias = new javax.swing.JList<>();
        jBCrear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCBEmpleado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCBSala = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtrasMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Nuevo Planning");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Actividad:");

        jRBDiaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRBDiaria.setSelected(true);
        jRBDiaria.setText("Diaria");

        jRBPersonalizada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRBPersonalizada.setText("Personalizar días");

        jCBTipoActivity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBTipoActivity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBTipoActivityItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Frecuencia:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Hora Inicio:");

        jSpinnerHour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinnerHour.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1701030252641L), null, null, java.util.Calendar.HOUR_OF_DAY));

        jListDias.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jListDias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListDias);

        jBCrear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBCrear.setText("Crear");
        jBCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Empleado:");

        jCBEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBEmpleadoItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Sala:");

        jCBSala.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBSala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBSalaItemStateChanged(evt);
            }
        });
        jCBSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabelAtras)
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(114, 114, 114))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jRBDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRBPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jBCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSpinnerHour, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBTipoActivity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCBEmpleado, 0, 213, Short.MAX_VALUE)
                            .addComponent(jCBSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTipoActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerHour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBSala, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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
        this.parent.setEnabled(true);
    }//GEN-LAST:event_jLabelAtrasMouseClicked

    private void jCBTipoActivityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBTipoActivityItemStateChanged
        this.jComboIdTipoSeleccionado = jCBTipoActivity.getSelectedIndex();
    }//GEN-LAST:event_jCBTipoActivityItemStateChanged

    private void jBCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearActionPerformed
        
        if(listaIdTipos.isEmpty() || listaIdEmpleados.isEmpty()){
            JOptionPane.showMessageDialog(this, "Usted NO ha creado ningun Tipo de Actividad \nO ningun empleado que ponder seleccionar");
        } else {
            
            if(jRBPersonalizada.isSelected() && jListDias.getSelectedValuesList().isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un dia");
            }else{
            
                String hora = new SimpleDateFormat("HH:mm").format(jSpinnerHour.getModel().getValue());
            
                String dias;
                String tipo;
                if(jRBDiaria.isSelected()){
                    tipo = "1";
                    dias = "Lunes-Martes-Miércoles-Jueves-Viernes-Sábado-Domingo";
                }else {
                    tipo = "0";
                    String cadena =jListDias.getSelectedValuesList().toString();
                    dias = cadena.replace("[", "").replace("]", "").replace(", ", "-");
                }
            
            
                if(idPlanning != -1){
                    System.out.println("parte de actualizar");
                    
                    try{
                    
                        SocketHandler.getOut().println(Mensajes.PETICION_UPDATE_PLANNING + "--" + listaIdTipos.get(jComboIdTipoSeleccionado) + "--" + hora + "--" + dias + "--" + tipo + "--" + listaIdEmpleados.get(jComboIdEmpleados) + "--" + listaIdSalas.get(jComboidSalaSeleccionado) + "--" + idPlanning);
                       
                        String received = SocketHandler.getIn().readLine();
                        
                        if(received.equals(Mensajes.PETICION_UPDATE_PLANNING_CORRECTO)){
                            this.dispose();
                            this.parent.setEnabled(true);
                            this.sParent.ObtenerActividades();
                            this.parent.ObtenerPlanning();
                            
                        }
                        
                        if(received.equals(Mensajes.PETICION_UPDATE_PLANNING_ERROR)){
                            JOptionPane.showMessageDialog(this, "Error al intentar actualizar este planning \nIntentelo mas tarde");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    
                    
                    
                }else {
                    System.out.println("parte de crear");
                    try{
                        SocketHandler.getOut().println(Mensajes.PETICION_CREAR_PLANNING + "--" + listaIdTipos.get(jComboIdTipoSeleccionado) + "--" + hora + "--" + dias + "--" + tipo + "--" + listaIdEmpleados.get(jComboIdEmpleados) + "--" + listaIdSalas.get(jComboidSalaSeleccionado) );

                        String received = "";
                        received = SocketHandler.getIn().readLine();

                        if(received.equals(Mensajes.PETICION_CREAR_PLANNING_CORRECTO)){
                            this.dispose();
                            this.parent.setEnabled(true);
                            this.parent.ObtenerPlanning();
                        }

                        if(received.equals(Mensajes.PETICION_CREAR_PLANNING_ERROR)){
                            JOptionPane.showMessageDialog(this, "Error al intentar crear este planning \nIntentelo mas tarde");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                               
            }
                  
        }
        
    }//GEN-LAST:event_jBCrearActionPerformed

    private void jCBEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEmpleadoItemStateChanged
        this.jComboIdEmpleados = jCBEmpleado.getSelectedIndex();        
    }//GEN-LAST:event_jCBEmpleadoItemStateChanged

    private void jCBSalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBSalaItemStateChanged
        this.jComboidSalaSeleccionado = jCBSala.getSelectedIndex();
    }//GEN-LAST:event_jCBSalaItemStateChanged

    private void jCBSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSalaActionPerformed

    }//GEN-LAST:event_jCBSalaActionPerformed

    
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
            java.util.logging.Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioActividadRecurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioActividadRecurrente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupFrecuencia;
    private javax.swing.JButton jBCrear;
    private javax.swing.JComboBox<String> jCBEmpleado;
    private javax.swing.JComboBox<String> jCBSala;
    private javax.swing.JComboBox<String> jCBTipoActivity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAtras;
    private javax.swing.JList<String> jListDias;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBDiaria;
    private javax.swing.JRadioButton jRBPersonalizada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerHour;
    // End of variables declaration//GEN-END:variables

}
