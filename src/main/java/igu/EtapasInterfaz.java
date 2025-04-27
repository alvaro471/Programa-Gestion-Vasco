package igu;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import persistencia.ManejadorArchivos;
import javax.swing.JOptionPane;
import persistencia.ConfigUtil;

public class EtapasInterfaz extends javax.swing.JFrame {

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
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Etapas");

        jLabel2.setText("Etapa 1");

        jLabel3.setText("Seleccionar carpeta con las etapas:");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton1.setText("EXAMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Etapa 2");

        jLabel5.setText("Etapa 3");

        jLabel6.setText("Etapa 4");

        jLabel7.setText("Etapa 5");

        jLabel8.setText("Etapa 6");

        jLabel9.setText("Etapa 7");

        jLabel10.setText("Etapa 8");

        btnExaminarEtapa1.setText("EXAMINAR");
        btnExaminarEtapa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa1ActionPerformed(evt);
            }
        });

        btnExaminarEtapa2.setText("EXAMINAR");
        btnExaminarEtapa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa2ActionPerformed(evt);
            }
        });

        btnExaminarEtapa3.setText("EXAMINAR");
        btnExaminarEtapa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa3ActionPerformed(evt);
            }
        });

        btnExaminarEtapa4.setText("EXAMINAR");
        btnExaminarEtapa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa4ActionPerformed(evt);
            }
        });

        btnExaminarEtapa5.setText("EXAMINAR");
        btnExaminarEtapa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa5ActionPerformed(evt);
            }
        });

        btnExaminarEtapa6.setText("EXAMINAR");
        btnExaminarEtapa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa6ActionPerformed(evt);
            }
        });

        btnExaminarEtapa7.setText("EXAMINAR");
        btnExaminarEtapa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa7ActionPerformed(evt);
            }
        });

        btnExaminarEtapa8.setText("EXAMINAR");
        btnExaminarEtapa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa8ActionPerformed(evt);
            }
        });

        jLabel11.setText("Seleccionar Carpeta Principal: ");

        jButton10.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton10.setText("EXAMINAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jcbEtapa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa1ActionPerformed(evt);
            }
        });

        jcbEtapa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa2ActionPerformed(evt);
            }
        });

        jcbEtapa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa3ActionPerformed(evt);
            }
        });

        jcbEtapa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa4ActionPerformed(evt);
            }
        });

        jcbEtapa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa5ActionPerformed(evt);
            }
        });

        jcbEtapa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa6ActionPerformed(evt);
            }
        });

        jcbEtapa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa7ActionPerformed(evt);
            }
        });

        jcbEtapa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa8ActionPerformed(evt);
            }
        });

        jcbSeleccionarTodo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jcbSeleccionarTodo.setText("SELECCIONAR TODO");
        jcbSeleccionarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionarTodoActionPerformed(evt);
            }
        });

        jButton2.setText("REFRESCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton4.setText("Funcionamiento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("SELECCIONAR CARPETA CON SUBCARPETAS:");

        jButton5.setText("EXAMINAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setText("ELIMNAR INDICES A SUBCARPETAS:");

        jLabel15.setText("ORDENAR ARCHIVOS AUTOMATICAMENTE:");

        jButton6.setText("ACEPTAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("ACEPTAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
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
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jButton7))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton10)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel11))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRutaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addGap(635, 635, 635)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jcbSeleccionarTodo)
                                                .addGap(44, 44, 44)
                                                .addComponent(jButton2))
                                            .addComponent(jLabel12))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCasillaEtapa4)
                                            .addComponent(txtCasillaEtapa3)
                                            .addComponent(txtCasillaEtapa2)
                                            .addComponent(txtCasillaEtapa1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEtapa1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEtapa3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEtapa2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEtapa4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnExaminarEtapa1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jcbEtapa1))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnExaminarEtapa2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jcbEtapa2))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnExaminarEtapa3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jcbEtapa3))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnExaminarEtapa4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jcbEtapa4)))
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCasillaEtapa5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEtapa5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnExaminarEtapa5))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtCasillaEtapa8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCasillaEtapa7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCasillaEtapa6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel10))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtEtapa8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btnExaminarEtapa8))
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(txtEtapa7, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(btnExaminarEtapa7))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(txtEtapa6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(btnExaminarEtapa6))))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbEtapa5)
                                    .addComponent(jcbEtapa6)
                                    .addComponent(jcbEtapa7)
                                    .addComponent(jcbEtapa8))))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtRutaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSeleccionarTodo)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnExaminarEtapa1)
                                    .addComponent(jcbEtapa1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnExaminarEtapa2)
                                    .addComponent(jcbEtapa2))
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnExaminarEtapa3)
                                .addComponent(jcbEtapa3)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEtapa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExaminarEtapa5)
                                    .addComponent(jLabel7)
                                    .addComponent(txtCasillaEtapa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbEtapa5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtEtapa6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExaminarEtapa6)
                                    .addComponent(txtCasillaEtapa6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbEtapa6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtEtapa7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExaminarEtapa7)
                                    .addComponent(txtCasillaEtapa7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbEtapa7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExaminarEtapa8)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(txtEtapa8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCasillaEtapa8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jcbEtapa8))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnExaminarEtapa4)
                                .addComponent(jcbEtapa4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEtapa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCasillaEtapa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtEtapa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCasillaEtapa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEtapa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(txtCasillaEtapa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEtapa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCasillaEtapa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            txtCasillaEtapa8
        };
        ManejadorArchivos.mostrarLlenuraSubcarpetas(ManejadorArchivos.getRutaCarpeta(), listaCampos, Color.red, Color.green);
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
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), 8);
    }//GEN-LAST:event_btnExaminarEtapa8ActionPerformed

    private void btnExaminarEtapa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa7ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), 7);
    }//GEN-LAST:event_btnExaminarEtapa7ActionPerformed

    private void btnExaminarEtapa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa6ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), 6);
    }//GEN-LAST:event_btnExaminarEtapa6ActionPerformed

    private void btnExaminarEtapa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa5ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), 5);
    }//GEN-LAST:event_btnExaminarEtapa5ActionPerformed

    private void btnExaminarEtapa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa4ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), 4);
    }//GEN-LAST:event_btnExaminarEtapa4ActionPerformed

    private void btnExaminarEtapa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa3ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), 3);
    }//GEN-LAST:event_btnExaminarEtapa3ActionPerformed

    private void btnExaminarEtapa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa2ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), 2);
    }//GEN-LAST:event_btnExaminarEtapa2ActionPerformed

    private void btnExaminarEtapa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa1ActionPerformed
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), 1);
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
            txtCasillaEtapa8
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
        ManejadorArchivos.moverArchivosCoincidentes(ManejadorArchivos.getRutaCarpeta());
    }//GEN-LAST:event_jButton7ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JTextField txtCasillaEtapa1;
    private javax.swing.JTextField txtCasillaEtapa2;
    private javax.swing.JTextField txtCasillaEtapa3;
    private javax.swing.JTextField txtCasillaEtapa4;
    private javax.swing.JTextField txtCasillaEtapa5;
    private javax.swing.JTextField txtCasillaEtapa6;
    private javax.swing.JTextField txtCasillaEtapa7;
    private javax.swing.JTextField txtCasillaEtapa8;
    private javax.swing.JTextField txtEtapa1;
    private javax.swing.JTextField txtEtapa2;
    private javax.swing.JTextField txtEtapa3;
    private javax.swing.JTextField txtEtapa4;
    private javax.swing.JTextField txtEtapa5;
    private javax.swing.JTextField txtEtapa6;
    private javax.swing.JTextField txtEtapa7;
    private javax.swing.JTextField txtEtapa8;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtRutaPrincipal;
    // End of variables declaration//GEN-END:variables
}
