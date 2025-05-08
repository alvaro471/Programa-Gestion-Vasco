package view;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import persistencia.ManejadorArchivos;
import javax.swing.JOptionPane;
import persistencia.ConfigUtil;

public class EtapasInterfaz extends javax.swing.JFrame {
    
    File carpetaExtra;
    
    public EtapasInterfaz() {
        initComponents();
        
        
        String rutaGuardada = ConfigUtil.cargarRuta();
        if (rutaGuardada != null) {
            ManejadorArchivos.setRutaCarpetaPrincipal(rutaGuardada);
            System.out.println("Ruta cargada desde config.txt: " + rutaGuardada);
        }

        
        txtEtapa1.setEnabled(false);
        txtEtapa2.setEnabled(false);
        txtEtapa3.setEnabled(false);
        txtEtapa4.setEnabled(false);
        txtEtapa5.setEnabled(false);
        txtEtapa6.setEnabled(false);
        txtEtapa7.setEnabled(false);
        txtEtapa8.setEnabled(false);
        btnExaminarEtapa1.setEnabled(false);
        btnExaminarEtapa2.setEnabled(false);
        btnExaminarEtapa3.setEnabled(false);
        btnExaminarEtapa4.setEnabled(false);
        btnExaminarEtapa5.setEnabled(false);
        btnExaminarEtapa6.setEnabled(false);
        btnExaminarEtapa7.setEnabled(false);
        btnExaminarEtapa8.setEnabled(false);
        this.setLocationRelativeTo(null); // Centrar la ventana
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEtapa1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEtapa2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEtapa3 = new javax.swing.JTextField();
        txtEtapa4 = new javax.swing.JTextField();
        txtEtapa5 = new javax.swing.JTextField();
        txtEtapa6 = new javax.swing.JTextField();
        txtEtapa7 = new javax.swing.JTextField();
        txtEtapa8 = new javax.swing.JTextField();
        btnExaminarEtapa1 = new javax.swing.JButton();
        btnExaminarEtapa2 = new javax.swing.JButton();
        btnExaminarEtapa3 = new javax.swing.JButton();
        btnExaminarEtapa4 = new javax.swing.JButton();
        btnExaminarEtapa5 = new javax.swing.JButton();
        btnExaminarEtapa6 = new javax.swing.JButton();
        btnExaminarEtapa7 = new javax.swing.JButton();
        btnExaminarEtapa8 = new javax.swing.JButton();
        txtCasillaEtapa1 = new javax.swing.JTextField();
        txtCasillaEtapa2 = new javax.swing.JTextField();
        txtCasillaEtapa3 = new javax.swing.JTextField();
        txtCasillaEtapa4 = new javax.swing.JTextField();
        txtCasillaEtapa5 = new javax.swing.JTextField();
        txtCasillaEtapa6 = new javax.swing.JTextField();
        txtCasillaEtapa7 = new javax.swing.JTextField();
        txtCasillaEtapa8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtRutaPrincipal = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jcbEtapa1 = new javax.swing.JCheckBox();
        jcbEtapa2 = new javax.swing.JCheckBox();
        jcbEtapa3 = new javax.swing.JCheckBox();
        jcbEtapa4 = new javax.swing.JCheckBox();
        jcbEtapa5 = new javax.swing.JCheckBox();
        jcbEtapa6 = new javax.swing.JCheckBox();
        jcbEtapa7 = new javax.swing.JCheckBox();
        jcbEtapa8 = new javax.swing.JCheckBox();
        jcbSeleccionarTodo = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtCasillaSeguimiento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEtapaSeguimiento = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        txtCarpetaExtra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtResultadoArchivoExtra = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Etapas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 9, -1, -1));
        jPanel1.add(txtEtapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 243, 215, -1));

        jLabel2.setText("Etapa 1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 247, -1, -1));
        jPanel1.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 476, -1));

        jLabel3.setText("Seleccionar carpeta con las etapas:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton1.setText("EXAMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, -1, -1));

        jLabel4.setText("Etapa 2");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 289, -1, -1));
        jPanel1.add(txtEtapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 285, 215, -1));

        jLabel5.setText("Etapa 3");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 331, -1, -1));

        jLabel6.setText("Etapa 4");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 373, -1, -1));

        jLabel7.setText("Etapa 5");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 247, -1, -1));

        jLabel8.setText("Etapa 6");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 289, -1, -1));

        jLabel9.setText("Etapa 7");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 331, -1, -1));

        jLabel10.setText("Etapa 8");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 373, -1, -1));
        jPanel1.add(txtEtapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 327, 215, -1));
        jPanel1.add(txtEtapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 369, 215, -1));
        jPanel1.add(txtEtapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 243, 197, -1));
        jPanel1.add(txtEtapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 285, 197, -1));
        jPanel1.add(txtEtapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 327, 197, -1));
        jPanel1.add(txtEtapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 369, 197, -1));

        btnExaminarEtapa1.setText("EXAMINAR");
        btnExaminarEtapa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 243, -1, -1));

        btnExaminarEtapa2.setText("EXAMINAR");
        btnExaminarEtapa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 285, -1, -1));

        btnExaminarEtapa3.setText("EXAMINAR");
        btnExaminarEtapa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 327, -1, -1));

        btnExaminarEtapa4.setText("EXAMINAR");
        btnExaminarEtapa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 369, -1, -1));

        btnExaminarEtapa5.setText("EXAMINAR");
        btnExaminarEtapa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 243, -1, -1));

        btnExaminarEtapa6.setText("EXAMINAR");
        btnExaminarEtapa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 285, -1, -1));

        btnExaminarEtapa7.setText("EXAMINAR");
        btnExaminarEtapa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 327, -1, -1));

        btnExaminarEtapa8.setText("EXAMINAR");
        btnExaminarEtapa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 369, -1, -1));
        jPanel1.add(txtCasillaEtapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 243, 25, -1));
        jPanel1.add(txtCasillaEtapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 285, 25, -1));
        jPanel1.add(txtCasillaEtapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 327, 25, -1));
        jPanel1.add(txtCasillaEtapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 369, 25, -1));
        jPanel1.add(txtCasillaEtapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 243, 25, -1));
        jPanel1.add(txtCasillaEtapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 285, 25, -1));
        jPanel1.add(txtCasillaEtapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 327, 25, -1));
        jPanel1.add(txtCasillaEtapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 369, 25, -1));

        jLabel11.setText("Seleccionar Carpeta Principal: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));
        jPanel1.add(txtRutaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 476, -1));

        jButton10.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton10.setText("EXAMINAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, -1, -1));

        jcbEtapa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa1ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 243, -1, -1));

        jcbEtapa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa2ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 285, -1, -1));

        jcbEtapa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa3ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 327, -1, -1));

        jcbEtapa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa4ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 369, -1, -1));

        jcbEtapa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa5ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 240, -1, -1));

        jcbEtapa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa6ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 290, -1, -1));

        jcbEtapa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa7ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 330, -1, -1));

        jcbEtapa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa8ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 370, -1, -1));

        jcbSeleccionarTodo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jcbSeleccionarTodo.setText("SELECCIONAR TODO");
        jcbSeleccionarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionarTodoActionPerformed(evt);
            }
        });
        jPanel1.add(jcbSeleccionarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 197, -1, -1));

        jButton2.setText("REFRESCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 201, -1, -1));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 580, -1, -1));

        jButton3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(867, 9, -1, -1));

        jButton4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton4.setText("Funcionamiento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("SELECCIONAR CARPETA CON SUBCARPETAS:");

        jButton5.setText("EXAMINAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setText("ELIMNAR INDICES A SUBCARPETAS:");

        jButton6.setText("ACEPTAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jButton5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton6))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 900, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("SEGUIMIENTO:");

        jButton7.setText("EXAMINAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton19.setText("SE");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtCasillaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEtapaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCasillaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton19))
                    .addComponent(txtEtapaSeguimiento))
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 490, 70));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton8.setText("EXAMINAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel16.setText("CARPETA EXTRA:");

        jLabel17.setText("INGRESAR ARCHIVO:");

        jButton9.setText("EXAMINAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtResultadoArchivoExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(txtCarpetaExtra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCarpetaExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtResultadoArchivoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 460, 130));

        jButton11.setText("SE");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 40, -1));

        jButton12.setText("SE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 40, -1));

        jButton13.setText("SE");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 40, -1));

        jButton14.setText("SE");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 40, -1));

        jButton15.setText("SE");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 240, 40, -1));

        jButton16.setText("SE");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 290, 40, -1));

        jButton17.setText("SE");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 40, -1));

        jButton18.setText("SE");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 370, 40, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(null, "1. Seleccionar la carpeta principal y luego la que contiene las subcarpetas \n 2. En los cuadros se detectara si las carpetas ya contienen archivos dentro \n 3. Seleccionar los archivos que se quiere que se añadan en la etapa");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Crear una instancia del segundo JFrame
        InterfazSeleccionar ventana = new InterfazSeleccionar();

        // Hacerlo visible
        ventana.setVisible(true);

        // Cerrar el actual (opcional)
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JTextField[] listaCampos = {
            txtCasillaEtapa1,
            txtCasillaEtapa2,
            txtCasillaEtapa3,
            txtCasillaEtapa4,
            txtCasillaEtapa5,
            txtCasillaEtapa6,
            txtCasillaEtapa7,
            txtCasillaEtapa8,
            txtCasillaSeguimiento
        };
        ManejadorArchivos.mostrarLlenuraSubcarpetas(ManejadorArchivos.getRutaCarpeta(), listaCampos, Color.red, Color.green);
        txtEtapa1.setText("");
        txtEtapa2.setText("");
        txtEtapa3.setText("");
        txtEtapa4.setText("");
        txtEtapa5.setText("");
        txtEtapa6.setText("");
        txtEtapa7.setText("");
        txtEtapa8.setText("");
        txtEtapaSeguimiento.setText("");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcbSeleccionarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSeleccionarTodoActionPerformed
        JCheckBox[] checkBoxes = {jcbEtapa1, jcbEtapa2, jcbEtapa3, jcbEtapa4,
            jcbEtapa5, jcbEtapa6, jcbEtapa7, jcbEtapa8};

        boolean seleccionar = jcbSeleccionarTodo.isSelected(); // Saber si hay que seleccionar o no

        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setSelected(seleccionar);

            // ⚠️ Aquí llamamos a los métodos generados por el GUI Builder manualmente
            if (checkBox == jcbEtapa1) {
                jcbEtapa1ActionPerformed(evt);
            } else if (checkBox == jcbEtapa2) {
                jcbEtapa2ActionPerformed(evt);
            } else if (checkBox == jcbEtapa3) {
                jcbEtapa3ActionPerformed(evt);
            } else if (checkBox == jcbEtapa4) {
                jcbEtapa4ActionPerformed(evt);
            } else if (checkBox == jcbEtapa5) {
                jcbEtapa5ActionPerformed(evt);
            } else if (checkBox == jcbEtapa6) {
                jcbEtapa6ActionPerformed(evt);
            } else if (checkBox == jcbEtapa7) {
                jcbEtapa7ActionPerformed(evt);
            } else if (checkBox == jcbEtapa8) {
                jcbEtapa8ActionPerformed(evt);
            }
            // Agrega más else if para las demás etapas
        }
    }//GEN-LAST:event_jcbSeleccionarTodoActionPerformed

    private void jcbEtapa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa8ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa8); // Verifica si todos están marcados

        if (jcbEtapa8.isSelected()) {
            txtEtapa8.setEnabled(true);
            btnExaminarEtapa8.setEnabled(true);
        } else {
            txtEtapa8.setEnabled(false);
            btnExaminarEtapa8.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEtapa8ActionPerformed

    private void jcbEtapa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa7ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa7); // Verifica si todos están marcados

        if (jcbEtapa7.isSelected()) {
            txtEtapa7.setEnabled(true);
            btnExaminarEtapa7.setEnabled(true);
        } else {
            txtEtapa7.setEnabled(false);
            btnExaminarEtapa7.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEtapa7ActionPerformed

    private void jcbEtapa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa6ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa6); // Verifica si todos están marcados

        if (jcbEtapa6.isSelected()) {
            txtEtapa6.setEnabled(true);
            btnExaminarEtapa6.setEnabled(true);
        } else {
            txtEtapa6.setEnabled(false);
            btnExaminarEtapa6.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEtapa6ActionPerformed

    private void jcbEtapa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa5ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa5); // Verifica si todos están marcados

        if (jcbEtapa5.isSelected()) {
            txtEtapa5.setEnabled(true);
            btnExaminarEtapa5.setEnabled(true);
        } else {
            txtEtapa5.setEnabled(false);
            btnExaminarEtapa5.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEtapa5ActionPerformed

    private void jcbEtapa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa4ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa4); // Verifica si todos están marcados

        if (jcbEtapa4.isSelected()) {
            txtEtapa4.setEnabled(true);
            btnExaminarEtapa4.setEnabled(true);
        } else {
            txtEtapa4.setEnabled(false);
            btnExaminarEtapa4.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEtapa4ActionPerformed

    private void jcbEtapa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa3ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa3); // Verifica si todos están marcados

        if (jcbEtapa3.isSelected()) {
            txtEtapa3.setEnabled(true);
            btnExaminarEtapa3.setEnabled(true);
        } else {
            txtEtapa3.setEnabled(false);
            btnExaminarEtapa3.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEtapa3ActionPerformed

    private void jcbEtapa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa2ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa2); // Verifica si todos están marcados

        if (jcbEtapa2.isSelected()) {
            txtEtapa2.setEnabled(true);
            btnExaminarEtapa2.setEnabled(true);
        } else {
            txtEtapa2.setEnabled(false);
            btnExaminarEtapa2.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEtapa2ActionPerformed

    private void jcbEtapa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa1ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa1); // Verifica si todos están marcados

        if (jcbEtapa1.isSelected()) {
            txtEtapa1.setEnabled(true);
            btnExaminarEtapa1.setEnabled(true);
        } else {
            txtEtapa1.setEnabled(false);
            btnExaminarEtapa1.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEtapa1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ManejadorArchivos.seleccionarCarpetaPrincipal();
        txtRutaPrincipal.setText(ManejadorArchivos.getRutaCarpetaPrincipal());
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnExaminarEtapa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa8ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "8", txtEtapa8);
    }//GEN-LAST:event_btnExaminarEtapa8ActionPerformed

    private void btnExaminarEtapa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa7ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "7", txtEtapa7);
    }//GEN-LAST:event_btnExaminarEtapa7ActionPerformed

    private void btnExaminarEtapa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa6ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "6", txtEtapa6);
    }//GEN-LAST:event_btnExaminarEtapa6ActionPerformed

    private void btnExaminarEtapa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa5ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "5", txtEtapa5);
    }//GEN-LAST:event_btnExaminarEtapa5ActionPerformed

    private void btnExaminarEtapa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa4ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "4", txtEtapa4);
    }//GEN-LAST:event_btnExaminarEtapa4ActionPerformed

    private void btnExaminarEtapa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa3ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "3", txtEtapa3);
    }//GEN-LAST:event_btnExaminarEtapa3ActionPerformed

    private void btnExaminarEtapa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa2ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "2", txtEtapa2);
    }//GEN-LAST:event_btnExaminarEtapa2ActionPerformed

    private void btnExaminarEtapa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa1ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "1", txtEtapa1);
    }//GEN-LAST:event_btnExaminarEtapa1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Inicialización de ArrayList con JTextFields
        JTextField[] listaCampos = {
            txtCasillaEtapa1,
            txtCasillaEtapa2,
            txtCasillaEtapa3,
            txtCasillaEtapa4,
            txtCasillaEtapa5,
            txtCasillaEtapa6,
            txtCasillaEtapa7,
            txtCasillaEtapa8,
            txtCasillaSeguimiento
        };
        ManejadorArchivos.seleccionarCarpeta(txtRuta);
        ManejadorArchivos.mostrarLlenuraSubcarpetas(ManejadorArchivos.getRutaCarpeta(), listaCampos, Color.red, Color.green);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ManejadorArchivos.seleccionarCarpeta(jTextField1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ManejadorArchivos.eliminarPrefijosNumericos(ManejadorArchivos.getRutaCarpeta());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "seguimiento", txtEtapaSeguimiento);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //Buscar solo para esta interfaz
        JFileChooser selectorCarpeta = new JFileChooser(ManejadorArchivos.getRutaCarpeta());
        selectorCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Solo carpetas
        selectorCarpeta.setAcceptAllFileFilterUsed(false); // Quitar opción de "Todos los archivos"

        int resultado = selectorCarpeta.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            carpetaExtra = selectorCarpeta.getSelectedFile();
            System.out.println("Carpeta seleccionada: " + carpetaExtra.getAbsolutePath());

            // Aquí puedes hacer lo que necesites con la carpeta seleccionada
        }
        txtCarpetaExtra.setText(""+carpetaExtra.getName());
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // 1. Seleccionar archivos
        JFileChooser selectorArchivos = new JFileChooser(ManejadorArchivos.getRutaCarpeta());
        selectorArchivos.setMultiSelectionEnabled(true); // Permite seleccionar múltiples archivos
        selectorArchivos.setAcceptAllFileFilterUsed(true); // Acepta cualquier tipo de archivo

        int resultado = selectorArchivos.showOpenDialog(null);
        if (resultado != JFileChooser.APPROVE_OPTION) {
            return; // Si no se seleccionaron archivos, salimos del método
        }

        File[] archivosSeleccionados = selectorArchivos.getSelectedFiles();
        if (archivosSeleccionados.length == 0) {
            JOptionPane.showMessageDialog(null, "No se seleccionaron archivos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Validar carpeta destino
        if (carpetaExtra == null || !carpetaExtra.isDirectory()) {
            JOptionPane.showMessageDialog(null, "No se seleccionó una carpeta válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Preguntar si desea mover o copiar
        String[] opciones = {"Mover", "Copiar", "Cancelar"};
        int opcion = JOptionPane.showOptionDialog(null,
                "¿Deseas mover o copiar los archivos seleccionados?",
                "Elegir acción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (opcion == 2 || opcion == JOptionPane.CLOSED_OPTION) {
            return; // Cancelar
        }

        boolean copiar = (opcion == 1); // Si eligió "Copiar", será true

        // 4. Procesar los archivos
        int archivosProcesados = 0;
        for (File archivo : archivosSeleccionados) {
            File archivoDestino = new File(carpetaExtra, archivo.getName());
            try {
                if (copiar) {
                    Files.copy(archivo.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } else {
                    Files.move(archivo.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                archivosProcesados++;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al " + (copiar ? "copiar" : "mover") + " el archivo: " + archivo.getName(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(null, archivosProcesados + " archivo(s) " + (copiar ? "copiado(s)" : "movido(s)") + " exitosamente a: " + carpetaExtra.getAbsolutePath());
        txtResultadoArchivoExtra.setText(String.valueOf("Se procesaron: " + archivosProcesados + " archivos"));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        buscarSubcarpeta(txtEtapa1, "1");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        buscarSubcarpeta(txtEtapa2, "2");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        buscarSubcarpeta(txtEtapa3, "3");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        buscarSubcarpeta(txtEtapa4, "4");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        buscarSubcarpeta(txtEtapa5, "5");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        buscarSubcarpeta(txtEtapa6, "6");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        buscarSubcarpeta(txtEtapa7, "7");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        buscarSubcarpeta(txtEtapa8, "8");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        buscarSubcarpeta(txtEtapaSeguimiento, "SEGUIMIENTO");
    }//GEN-LAST:event_jButton19ActionPerformed

    public void buscarSubcarpeta(JTextField campoCantidadArchivos, String palabraClave) {
        // Paso 1: Buscar carpeta que coincida con la palabra clave
        File carpetaBase = new File(ManejadorArchivos.getRutaCarpeta());
        File[] subcarpetas = carpetaBase.listFiles(File::isDirectory);

        File carpetaInicial = carpetaBase; // Por defecto, si no se encuentra nada

        if (subcarpetas != null) {
            for (File sub : subcarpetas) {
                if (sub.getName().toLowerCase().startsWith(palabraClave.toLowerCase())) {
                    carpetaInicial = sub;
                    break;
                }
            }
        }

        // Paso 2: Selección de carpeta
        JFileChooser selectorCarpeta = new JFileChooser(carpetaInicial);
        selectorCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selectorCarpeta.setDialogTitle("Selecciona una carpeta de destino");

        int resultadoCarpeta = selectorCarpeta.showOpenDialog(null);
        if (resultadoCarpeta != JFileChooser.APPROVE_OPTION) {
            return; // Cancelado
        }

        File carpetaDestino = selectorCarpeta.getSelectedFile();
        String rutaDestino = carpetaDestino.getAbsolutePath();

        // Paso 2: Selección de archivos
        JFileChooser selectorArchivos = new JFileChooser(ManejadorArchivos.getRutaCarpeta());
        selectorArchivos.setDialogTitle("Selecciona archivos a procesar");
        selectorArchivos.setMultiSelectionEnabled(true);
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultadoArchivos = selectorArchivos.showOpenDialog(null);
        if (resultadoArchivos != JFileChooser.APPROVE_OPTION) {
            return; // Cancelado
        }

        File[] archivosSeleccionados = selectorArchivos.getSelectedFiles();

        // Paso 3: Confirmar acción
        String[] opciones = {"Copiar", "Mover", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(
            null,
            "¿Qué desea hacer con los archivos seleccionados?",
            "Acción",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (eleccion == 2 || eleccion == JOptionPane.CLOSED_OPTION) {
            return; // Cancelado
        }

        // Paso 4: Procesar archivos
        int procesados = 0;
        for (File archivo : archivosSeleccionados) {
            try {
                File destino = new File(rutaDestino + File.separator + archivo.getName());
                if (eleccion == 0) { // Copiar
                    Files.copy(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } else if (eleccion == 1) { // Mover
                    Files.move(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                procesados++;
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al procesar: " + archivo.getName());
            }
        }

        // Paso 5: Mostrar resultados
        campoCantidadArchivos.setText(String.valueOf("Archivos procesados: " + procesados));
        JOptionPane.showMessageDialog(null, "Archivos procesados: " + procesados);
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
            java.util.logging.Logger.getLogger(EtapasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EtapasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EtapasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EtapasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EtapasInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExaminarEtapa1;
    private javax.swing.JButton btnExaminarEtapa2;
    private javax.swing.JButton btnExaminarEtapa3;
    private javax.swing.JButton btnExaminarEtapa4;
    private javax.swing.JButton btnExaminarEtapa5;
    private javax.swing.JButton btnExaminarEtapa6;
    private javax.swing.JButton btnExaminarEtapa7;
    private javax.swing.JButton btnExaminarEtapa8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JCheckBox jcbEtapa1;
    private javax.swing.JCheckBox jcbEtapa2;
    private javax.swing.JCheckBox jcbEtapa3;
    private javax.swing.JCheckBox jcbEtapa4;
    private javax.swing.JCheckBox jcbEtapa5;
    private javax.swing.JCheckBox jcbEtapa6;
    private javax.swing.JCheckBox jcbEtapa7;
    private javax.swing.JCheckBox jcbEtapa8;
    private javax.swing.JCheckBox jcbSeleccionarTodo;
    private javax.swing.JTextField txtCarpetaExtra;
    private javax.swing.JTextField txtCasillaEtapa1;
    private javax.swing.JTextField txtCasillaEtapa2;
    private javax.swing.JTextField txtCasillaEtapa3;
    private javax.swing.JTextField txtCasillaEtapa4;
    private javax.swing.JTextField txtCasillaEtapa5;
    private javax.swing.JTextField txtCasillaEtapa6;
    private javax.swing.JTextField txtCasillaEtapa7;
    private javax.swing.JTextField txtCasillaEtapa8;
    private javax.swing.JTextField txtCasillaSeguimiento;
    private javax.swing.JTextField txtEtapa1;
    private javax.swing.JTextField txtEtapa2;
    private javax.swing.JTextField txtEtapa3;
    private javax.swing.JTextField txtEtapa4;
    private javax.swing.JTextField txtEtapa5;
    private javax.swing.JTextField txtEtapa6;
    private javax.swing.JTextField txtEtapa7;
    private javax.swing.JTextField txtEtapa8;
    private javax.swing.JTextField txtEtapaSeguimiento;
    private javax.swing.JTextField txtResultadoArchivoExtra;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtRutaPrincipal;
    // End of variables declaration//GEN-END:variables
}
