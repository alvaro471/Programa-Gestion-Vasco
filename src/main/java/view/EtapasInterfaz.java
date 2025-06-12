package view;
import com.github.sardine.DavResource;
import com.github.sardine.impl.SardineException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import persistencia.ManejadorArchivos;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import persistencia.ConectarWebDavManualmente;
import persistencia.ConfigUtil;
import persistencia.CredencialesUtil;

public class EtapasInterfaz extends javax.swing.JFrame {
    
    File carpetaExtra;
    String usuario;
    String clave;
    DefaultListModel<String> modeloListaCarpetas1Nombres = new DefaultListModel<>();
    DefaultListModel<String> modeloListaCarpetas1Rutas = new DefaultListModel<>();
    private String rutaSeleccionadaGlobal;
    private ManejadorArchivos manejador = new ManejadorArchivos();
    private ConectarWebDavManualmente conectarManualmente = new ConectarWebDavManualmente();
    String[] credenciales = CredencialesUtil.cargarCredenciales();
    
    
    public EtapasInterfaz() {
        initComponents();
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JListCarpetas.setModel(modeloListaCarpetas1Nombres);
        String rutaGuardadaPrincipal = ConfigUtil.cargarRutaPrincipal();
        if (rutaGuardadaPrincipal != null) {
            ManejadorArchivos.setRutaCarpetaPrincipal(rutaGuardadaPrincipal);
            System.out.println("Ruta principal cargada desde config_principal.txt: " + rutaGuardadaPrincipal);
        } else {
            System.out.println("No hay ruta principal guardada. Se usará la ruta por defecto.");
        }
        if(jcbWeb.isSelected()){
            
        }
        txtPalabraClave.setPreferredSize(new Dimension(262, 24));
        txtRutaPrincipal2.setPreferredSize(new Dimension(262, 24));
        
        String url = "https://drive.mimp.gob.pe/remote.php/webdav/DPAM/PROYECTO%20CARPETA%20UNICA/AÑO%202024";
        int puerto = manejador.obtenerPuertoDesdeURL(url);
        manejador.mostrarInfoConexion(url);
        System.out.println("Puerto detectado para conexión WebDAV: " + puerto);

        
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
        txtUsuario.setEnabled(false);
        jpfContrasena.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEtapa1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel18 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtCasillaSeguimiento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEtapaSeguimiento = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtRutaPrincipal = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtPalabraClave = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListCarpetas = new javax.swing.JList<>();
        jButton8 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnBuscarCarpetaPrincipal = new javax.swing.JButton();
        btnBuscarPalabraClave = new javax.swing.JButton();
        txtRutaPrincipal2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jpfContrasena = new javax.swing.JPasswordField();
        jcbWeb = new javax.swing.JCheckBox();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("GESTION DE ARCHIVOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel1.add(txtEtapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 215, -1));

        jLabel2.setText("Etapa 1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jLabel4.setText("Etapa 2");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));
        jPanel1.add(txtEtapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 215, -1));

        jLabel5.setText("Etapa 3");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        jLabel6.setText("Etapa 4");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel7.setText("Etapa 5");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, -1));

        jLabel8.setText("Etapa 6");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        jLabel9.setText("Etapa 7");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, -1, -1));

        jLabel10.setText("Etapa 8");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, -1));
        jPanel1.add(txtEtapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 215, -1));
        jPanel1.add(txtEtapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 215, -1));
        jPanel1.add(txtEtapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 197, -1));
        jPanel1.add(txtEtapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 197, -1));
        jPanel1.add(txtEtapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 197, -1));
        jPanel1.add(txtEtapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 197, -1));

        btnExaminarEtapa1.setText("EXAMINAR");
        btnExaminarEtapa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        btnExaminarEtapa2.setText("EXAMINAR");
        btnExaminarEtapa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, -1));

        btnExaminarEtapa3.setText("EXAMINAR");
        btnExaminarEtapa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        btnExaminarEtapa4.setText("EXAMINAR");
        btnExaminarEtapa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, -1, -1));

        btnExaminarEtapa5.setText("EXAMINAR");
        btnExaminarEtapa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, -1, -1));

        btnExaminarEtapa6.setText("EXAMINAR");
        btnExaminarEtapa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 390, -1, -1));

        btnExaminarEtapa7.setText("EXAMINAR");
        btnExaminarEtapa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 440, -1, -1));

        btnExaminarEtapa8.setText("EXAMINAR");
        btnExaminarEtapa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEtapa8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminarEtapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, -1, -1));
        jPanel1.add(txtCasillaEtapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 25, -1));
        jPanel1.add(txtCasillaEtapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 25, -1));
        jPanel1.add(txtCasillaEtapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 25, -1));
        jPanel1.add(txtCasillaEtapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 25, -1));
        jPanel1.add(txtCasillaEtapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 25, -1));
        jPanel1.add(txtCasillaEtapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 25, -1));
        jPanel1.add(txtCasillaEtapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 25, -1));
        jPanel1.add(txtCasillaEtapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 480, 25, -1));

        jcbEtapa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa1ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, -1));

        jcbEtapa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa2ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        jcbEtapa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa3ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, -1));

        jcbEtapa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa4ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, -1, -1));

        jcbEtapa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa5ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 350, -1, -1));

        jcbEtapa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa6ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, -1, -1));

        jcbEtapa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa7ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, -1, -1));

        jcbEtapa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEtapa8ActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEtapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 480, -1, -1));

        jcbSeleccionarTodo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jcbSeleccionarTodo.setText("SELECCIONAR TODO");
        jcbSeleccionarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionarTodoActionPerformed(evt);
            }
        });
        jPanel1.add(jcbSeleccionarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jButton2.setText("REFRESCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 580, -1, -1));

        jButton3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton3.setText("MENU PRINCIPAL");
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
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

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

        jLabel18.setText("AGREGAR INDICES A ARCHIVOS:");

        jButton20.setText("ACEPTAR");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton20))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jButton5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jButton20))
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 660, 120));

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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEtapaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCasillaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCasillaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton19)
                    .addComponent(txtEtapaSeguimiento))
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 360, 120));

        jButton11.setText("SE");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 40, -1));

        jButton12.setText("SE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 40, -1));

        jButton13.setText("SE");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 40, -1));

        jButton14.setText("SE");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 40, -1));

        jButton15.setText("SE");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 350, 40, -1));

        jButton16.setText("SE");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 40, -1));

        jButton17.setText("SE");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 440, 40, -1));

        jButton18.setText("SE");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 480, 40, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("Seleccionar Carpeta Principal: ");

        jButton10.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton10.setText("EXAMINAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton1.setText("EXAMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccionar carpeta con las etapas:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(52, 52, 52)
                        .addComponent(txtRutaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtRutaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 440, 160));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setText("Palabra Clave:");

        jScrollPane1.setViewportView(JListCarpetas);

        jButton8.setText("ENVIAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel19.setText("Carpeta General");

        btnBuscarCarpetaPrincipal.setText("EXAMINAR");
        btnBuscarCarpetaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCarpetaPrincipalActionPerformed(evt);
            }
        });

        btnBuscarPalabraClave.setText("BUSCAR");
        btnBuscarPalabraClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPalabraClaveActionPerformed(evt);
            }
        });

        jLabel16.setText("Usuario:");

        jLabel20.setText("Constraseña:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPalabraClave, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(txtRutaPrincipal2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarCarpetaPrincipal)
                            .addComponent(btnBuscarPalabraClave)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jpfContrasena))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRutaPrincipal2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(btnBuscarCarpetaPrincipal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPalabraClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(btnBuscarPalabraClave))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jpfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 610, 250));

        jcbWeb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jcbWeb.setText("ACTIVAR MODO WEB");
        jcbWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbWebActionPerformed(evt);
            }
        });
        jPanel1.add(jcbWeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jButton9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton9.setText("LIMPIAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
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

        InterfazSeleccionar ventana = new InterfazSeleccionar();

        ventana.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jcbWeb.isSelected()) {
            int index = JListCarpetas.getSelectedIndex();
            if (index >= 0) {
                String rutaSeleccionada = modeloListaCarpetas1Rutas.getElementAt(index);
                rutaSeleccionadaGlobal = modeloListaCarpetas1Rutas.getElementAt(index);
                analizarSubcarpetasConArchivos(rutaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una carpeta de la lista primero.");
            }
        }
        else{
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
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcbSeleccionarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSeleccionarTodoActionPerformed
        JCheckBox[] checkBoxes = {jcbEtapa1, jcbEtapa2, jcbEtapa3, jcbEtapa4,
            jcbEtapa5, jcbEtapa6, jcbEtapa7, jcbEtapa8};

        boolean seleccionar = jcbSeleccionarTodo.isSelected();

        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setSelected(seleccionar);

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
        }
    }//GEN-LAST:event_jcbSeleccionarTodoActionPerformed

    private void jcbEtapa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEtapa8ActionPerformed
        ManejadorArchivos.verificarSeleccion(jcbSeleccionarTodo, jcbEtapa8); 
        
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
        
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("CON");
        }
        else{
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "8", txtEtapa8);
        }
    }//GEN-LAST:event_btnExaminarEtapa8ActionPerformed

    private void btnExaminarEtapa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa7ActionPerformed
        
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("AGR");
        }
        else{
            ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "7", txtEtapa7);
        }
        
    }//GEN-LAST:event_btnExaminarEtapa7ActionPerformed

    private void btnExaminarEtapa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa6ActionPerformed
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("SEG");
        }
        else{
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "6", txtEtapa6);
        }
    }//GEN-LAST:event_btnExaminarEtapa6ActionPerformed

    private void btnExaminarEtapa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa5ActionPerformed
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("APE");
        }
        else{
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "5", txtEtapa5);
        }
    }//GEN-LAST:event_btnExaminarEtapa5ActionPerformed

    private void btnExaminarEtapa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa4ActionPerformed
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("ARC");
        }
        else{
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "4", txtEtapa4);
        }
    }//GEN-LAST:event_btnExaminarEtapa4ActionPerformed

    private void btnExaminarEtapa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa3ActionPerformed
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("EMI");
        }
        else{
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "3", txtEtapa3);
        }
    }//GEN-LAST:event_btnExaminarEtapa3ActionPerformed

    private void btnExaminarEtapa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa2ActionPerformed
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("IDE");
        }
        else{
        ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "2", txtEtapa2);
        }
    }//GEN-LAST:event_btnExaminarEtapa2ActionPerformed

    private void btnExaminarEtapa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEtapa1ActionPerformed
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("REC");
            
        }
        else{
            ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "1", txtEtapa1);
        }
    }//GEN-LAST:event_btnExaminarEtapa1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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
        if (jcbWeb.isSelected()) {
            subirArchivosAClave("SEGUIMIENTO");
        }
        else{
            ManejadorArchivos.asignarArchivosEtapas(ManejadorArchivos.getRutaCarpeta(), ManejadorArchivos.getRutaCarpeta(), "seguimiento", txtEtapaSeguimiento);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

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

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        renombrarPorCategoria(ManejadorArchivos.getRutaCarpeta());
    }//GEN-LAST:event_jButton20ActionPerformed

    private void btnBuscarCarpetaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCarpetaPrincipalActionPerformed
        ManejadorArchivos.seleccionarCarpetaPrincipal();
        txtRutaPrincipal.setText(ManejadorArchivos.getRutaCarpetaPrincipal());
        txtRutaPrincipal2.setText(ManejadorArchivos.getRutaCarpetaPrincipal());
    }//GEN-LAST:event_btnBuscarCarpetaPrincipalActionPerformed

    private void btnBuscarPalabraClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPalabraClaveActionPerformed
        if (jcbWeb.isSelected()) { 
            
            String usuario = txtUsuario.getText().trim();
            String clave = new String(jpfContrasena.getPassword());
            String palabraClave = txtPalabraClave.getText().trim();
            String linkWeb = txtRutaPrincipal2.getText();
            manejador.conectar(usuario, clave);
            if (palabraClave.isEmpty() || linkWeb.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete la palabra clave y el enlace.");
                return;
            }

            try {
                
                System.out.println("La url es antes de transformar es: " + linkWeb);
                String urlWebDAV = manejador.transformarLink(linkWeb);
                System.out.println("La url es antes de buscar es: " + urlWebDAV);
                
                Map<String, String> resultados = manejador.buscarSubcarpetas(urlWebDAV, palabraClave);
                
                modeloListaCarpetas1Nombres.clear();
                modeloListaCarpetas1Rutas.clear();

                for (Map.Entry<String, String> entry : resultados.entrySet()) {
                    String nombre = entry.getKey();
                    String ruta = entry.getValue();

                    String rutaRelativa = ruta.replaceFirst(Pattern.quote(urlWebDAV), "");
                    rutaRelativa = java.net.URLDecoder.decode(rutaRelativa, "UTF-8");

                    String textoVisible = nombre + " (en: " + rutaRelativa + ")";
                    modeloListaCarpetas1Nombres.addElement(textoVisible);
                    modeloListaCarpetas1Rutas.addElement(ruta);
                }

                if (resultados.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se encontraron coincidencias.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                System.out.println("Error: " + e);
            }
        }
        else{
            
            String palabraClave = txtPalabraClave.getText();
            String rutaGeneral="";
            ManejadorArchivos.buscarCarpetasSinProfundizarEnEXP(
                rutaGeneral,
                palabraClave,
                palabraClave,
                palabraClave,
                modeloListaCarpetas1Nombres,
                modeloListaCarpetas1Rutas,
                JListCarpetas
            );
            
            /*
            
            String palabraClave = txtPalabraClave.getText();
            ManejadorArchivos.buscarCarpetasEnGeneral(ManejadorArchivos.getRutaCarpetaPrincipal(), palabraClave, palabraClave, palabraClave, modeloListaCarpetas1Nombres, modeloListaCarpetas1Rutas, JListCarpetas);*/
        }
    }//GEN-LAST:event_btnBuscarPalabraClaveActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jcbWeb.isSelected()) {
            int index = JListCarpetas.getSelectedIndex();
            if (index >= 0) {
                String rutaSeleccionada = modeloListaCarpetas1Rutas.getElementAt(index);
                rutaSeleccionadaGlobal = modeloListaCarpetas1Rutas.getElementAt(index);
                analizarSubcarpetasConArchivos(rutaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una carpeta de la lista primero.");
            }
        }
        else{
            int indiceSeleccionado = JListCarpetas.getSelectedIndex();

            if (indiceSeleccionado != -1) {
                String rutaSeleccionada = modeloListaCarpetas1Rutas.getElementAt(indiceSeleccionado);

                System.out.println("Ruta seleccionada: " + rutaSeleccionada);

                this.rutaSeleccionadaGlobal = rutaSeleccionada;
                ManejadorArchivos.setRutaCarpeta(rutaSeleccionadaGlobal);

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
                txtRuta.setText(rutaSeleccionadaGlobal);
                ManejadorArchivos.mostrarLlenuraSubcarpetas(ManejadorArchivos.getRutaCarpeta(), listaCampos, Color.red, Color.green);
                } else {
                JOptionPane.showMessageDialog(null, "Por favor selecciona una carpeta de la lista.");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jcbWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbWebActionPerformed
        boolean activar = jcbWeb.isSelected();
        if(activar){
            btnBuscarCarpetaPrincipal.setText("<-----");
            btnBuscarCarpetaPrincipal.setEnabled(!activar);
            activarDesactivarPaneles(jPanel3 ,false);
            if (credenciales != null) {
                txtUsuario.setText(credenciales[0]);
                jpfContrasena.setText(credenciales[1]);
                txtRutaPrincipal2.setText(credenciales[2]);
                txtUsuario.setEnabled(activar);
                jpfContrasena.setEnabled(activar);
            }
            
        }else{
            btnBuscarCarpetaPrincipal.setText("EXAMINAR");
            btnBuscarCarpetaPrincipal.setEnabled(true);
            txtUsuario.setEnabled(false);
            txtUsuario.setText("");
            jpfContrasena.setEnabled(false);
            jpfContrasena.setText("");
            txtRutaPrincipal2.setText("");
            activarDesactivarPaneles(jPanel3 ,true);
            
        }
        
        
    }//GEN-LAST:event_jcbWebActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        txtRutaPrincipal2.setText("");
        txtPalabraClave.setText("");
        txtUsuario.setText("");
        jpfContrasena.setText("");
        txtRutaPrincipal.setText("");
        txtRuta.setText("");
        txtEtapa1.setText("");
        txtEtapa2.setText("");
        txtEtapa3.setText("");
        txtEtapa4.setText("");
        txtEtapa5.setText("");
        txtEtapa6.setText("");
        txtEtapa7.setText("");
        txtEtapa8.setText("");
        txtEtapaSeguimiento.setText("");
        txtCasillaEtapa1.setText("");
        txtCasillaEtapa2.setText("");
        txtCasillaEtapa3.setText("");
        txtCasillaEtapa4.setText("");
        txtCasillaEtapa5.setText("");
        txtCasillaEtapa6.setText("");
        txtCasillaEtapa7.setText("");
        txtCasillaEtapa8.setText("");
        txtCasillaSeguimiento.setText("");
        
        modeloListaCarpetas1Nombres.clear();
        modeloListaCarpetas1Rutas.clear();
        
        txtCasillaEtapa1.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        txtCasillaEtapa2.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        txtCasillaEtapa3.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        txtCasillaEtapa4.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        txtCasillaEtapa5.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        txtCasillaEtapa6.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        txtCasillaEtapa7.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        txtCasillaEtapa8.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        txtCasillaSeguimiento.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        
        ManejadorArchivos.setRutaCarpeta("");
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    public void buscarSubcarpeta(JTextField campoCantidadArchivos, String palabraClave) {

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

        JFileChooser selectorCarpeta = new JFileChooser(carpetaInicial);
        selectorCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selectorCarpeta.setDialogTitle("Selecciona una carpeta de destino");

        int resultadoCarpeta = selectorCarpeta.showOpenDialog(null);
        if (resultadoCarpeta != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File carpetaDestino = selectorCarpeta.getSelectedFile();
        String rutaDestino = carpetaDestino.getAbsolutePath();

        JFileChooser selectorArchivos = new JFileChooser(ManejadorArchivos.getRutaCarpeta());
        selectorArchivos.setDialogTitle("Selecciona archivos a procesar");
        selectorArchivos.setMultiSelectionEnabled(true);
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultadoArchivos = selectorArchivos.showOpenDialog(null);
        if (resultadoArchivos != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File[] archivosSeleccionados = selectorArchivos.getSelectedFiles();

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
            return;
        }

        int procesados = 0;
        for (File archivo : archivosSeleccionados) {
            try {
                File destino = new File(rutaDestino + File.separator + archivo.getName());
                if (eleccion == 0) {
                    Files.copy(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } else if (eleccion == 1) {
                    Files.move(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                procesados++;
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al procesar: " + archivo.getName());
            }
        }

        campoCantidadArchivos.setText(String.valueOf("Archivos procesados: " + procesados));
        JOptionPane.showMessageDialog(null, "Archivos procesados: " + procesados);
    }

    public static void renombrarPorCategoria(String rutaBase) {
        String[][] claves = {
            {"REC", "1"},
            {"IDE", "2"},
            {"EMI", "3"},
            {"ARC", "4"},
            {"APE", "5"},
            {"SEG", "6"},
            {"AGR", "7"},
            {"CON", "8"}
        };

        File carpetaBase = new File(rutaBase);
        if (!carpetaBase.exists() || !carpetaBase.isDirectory()) {
            System.out.println("Ruta inválida: " + rutaBase);
            return;
        }

        for (String[] clave : claves) {
            String palabraClave = clave[0];
            String numero = clave[1];
            procesarDirectorio(carpetaBase, palabraClave, numero);
        }
        JOptionPane.showMessageDialog(null, "Renombrado completado con éxito.");
    }

    private static void procesarDirectorio(File directorio, String palabraClave, String numero) {
        File[] archivos = directorio.listFiles();
        if (archivos == null) return;

        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                if (archivo.getName().toUpperCase().contains(palabraClave)) {
                    renombrarArchivos(archivo, numero);
                }

                procesarDirectorio(archivo, palabraClave, numero);
            }
        }
    }

    private static void renombrarArchivos(File dir, String numero) {
        File[] archivos = dir.listFiles();
        if (archivos == null) return;

        for (File archivo : archivos) {
            if (archivo.isFile()) {
                String nombreOriginal = archivo.getName();
                if (!nombreOriginal.startsWith(numero + " ")) {
                    String nuevoNombre = numero + " " + nombreOriginal;
                    File nuevoArchivo = new File(archivo.getParent(), nuevoNombre);
                    boolean renombrado = archivo.renameTo(nuevoArchivo);
                    if (!renombrado) {
                        System.out.println("No se pudo renombrar: " + archivo.getAbsolutePath());
                    }
                }
                
            } else if (archivo.isDirectory()) {
                renombrarArchivos(archivo, numero);
            }
        }
    }
    private void analizarSubcarpetasConArchivos(String rutaBase) {
        Map<String, JTextField> carpetasClave = Map.of(
            "REC", txtCasillaEtapa1,
            "IDE", txtCasillaEtapa2,
            "EMI", txtCasillaEtapa3,
            "ARC", txtCasillaEtapa4,
            "APE", txtCasillaEtapa5,
            "SEG", txtCasillaEtapa6,
            "AGR", txtCasillaEtapa7,
            "CON", txtCasillaEtapa8,
            "SEGUIMIENTO", txtCasillaSeguimiento
        );

        

        try {
            URL url = new URL(rutaBase);
            int puerto = url.getPort();
            String protocolo = url.getProtocol();

            if (puerto == -1) {
                puerto = protocolo.equalsIgnoreCase("https") ? 443 : 80;
            }

            System.out.println("-------------->PUERTO: 🌐 Conectando a: " + url.getHost() + " por puerto: " + puerto + " (" + protocolo.toUpperCase() + ")");


            
            System.out.println("📂 Listando contenido de: " + rutaBase);
            List<DavResource> recursos = manejador.listarCarpeta(rutaBase);
            System.out.println("📁 Carpetas encontradas en: " + rutaBase);
            for (DavResource res : recursos) {
                System.out.println(" - " + res.getName());
            }
            



            for (String clave : carpetasClave.keySet()) {
                JTextField campo = carpetasClave.get(clave);
                campo.setBackground(Color.RED);

                boolean encontrado = false;

                for (DavResource res : recursos) {
                    String nombreRes = res.getName().toUpperCase();

                    if (res.isDirectory() && (
                            (clave.equals("SEGUIMIENTO") && nombreRes.equalsIgnoreCase("SEGUIMIENTO"))
                            || nombreRes.matches("\\d+_" + clave + "_\\d+")
                        )) {

                        encontrado = true;

                        String subRuta = buildWebDAVPath(rutaBase, res.getName());
                        

                        System.out.println("Analizando subcarpeta: " + subRuta);


                        boolean tieneArchivos = contieneArchivos(subRuta);


                        if (tieneArchivos) {
                            campo.setBackground(Color.GREEN);
                            System.out.println(clave + " contiene archivos.");
                        } else {
                            System.out.println(clave + " está vacía.");
                        }

                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("No se encontró carpeta para la etapa: " + clave);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al analizar carpetas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String eliminarUltimoSegmentoSiDuplicado(String rutaPadre, String rutaCompleta) {
        String[] partesPadre = rutaPadre.split("/");
        String[] partesCompleta = rutaCompleta.split("/");

        if (partesPadre.length == 0 || partesCompleta.length == 0)
            return rutaCompleta;

        String ultimaPadre = partesPadre[partesPadre.length - 1];
        String ultimaCompleta = partesCompleta[partesCompleta.length - 1];

        // Comparar sin codificación (por si vienen con %20, etc.)
        if (ultimaCompleta.equalsIgnoreCase(ultimaPadre)) {
            // Eliminar el último segmento
            String rutaCorregida = rutaCompleta.substring(0, rutaCompleta.lastIndexOf("/"));
            System.out.println("Subcarpeta duplicada detectada, ruta corregida: " + rutaCorregida);
            return rutaCorregida;
        }

        return rutaCompleta;
    }

    private boolean contieneArchivos(String ruta) throws Exception {
        return contieneArchivos(ruta, 0, 3); // profundidad máxima de 3 niveles
    }

    private boolean contieneArchivos(String ruta, int nivelActual, int profundidadMaxima) throws Exception {
        System.out.println("Nivel " + nivelActual + ": Listando " + ruta);

        if (nivelActual > profundidadMaxima) {
            System.out.println("Límite de profundidad alcanzado en: " + ruta);
            return false;
        }

        List<DavResource> recursos;

        try {
            recursos = manejador.listarCarpeta(ruta);
        } catch (SardineException e) {
            if (e.getStatusCode() == 412) {
                System.out.println("Sardine 412 en: " + ruta);
                String rutaLimpia = ruta.replaceAll("(%20){2,}", "%20");
                System.out.println("Reintentando con ruta corregida: " + rutaLimpia);

                try {
                    recursos = manejador.listarCarpeta(rutaLimpia);
                } catch (Exception e2) {
                    System.out.println("Reintento fallido también: " + e2.getMessage());
                    return false;
                }
            } else {
                System.out.println("Sardine error: " + e.getMessage());
                return false;
            }
        }

        for (DavResource res : recursos) {
            if (!res.isDirectory()) {
                System.out.println("Archivo encontrado: " + res.getName() + " en " + ruta);
                return true;
            } else {
                String subRuta = buildWebDAVPath(ruta, res.getName());
                System.out.println("Descendiendo a subcarpeta: " + subRuta);

                if (contieneArchivos(subRuta, nivelActual + 1, profundidadMaxima)) {
                    return true;
                }
            }
        }

        System.out.println("Sin archivos en: " + ruta);
        return false;
    }

    private String normalizarURL(String url) throws UnsupportedEncodingException {
        // Separar todas las partes
        String[] partes = url.split("/");

        if (partes.length < 2) return url;

        String ultimaParte = partes[partes.length - 1];
        String penultimaParte = partes[partes.length - 2];

        // Decodificar ambas partes
        String ultimaDecodificada = URLDecoder.decode(ultimaParte, "UTF-8").trim().toLowerCase();
        String penultimaDecodificada = URLDecoder.decode(penultimaParte, "UTF-8").trim().toLowerCase();

        // Comparar sin diferenciar mayúsculas, y limpiando espacios extra
        if (ultimaDecodificada.equals(penultimaDecodificada)) {
            // Eliminar el último segmento
            String urlCorregida = url.substring(0, url.lastIndexOf("/" + ultimaParte));
            System.out.println("URL duplicada detectada. Corregido: " + urlCorregida);
            return urlCorregida;
        }

        return url;
    }

    private boolean yaContieneCarpeta(String url, String carpeta) throws UnsupportedEncodingException {
        String carpetaCodificada = URLEncoder.encode(carpeta, "UTF-8").replace("+", "%20");
        String urlNormalizada = normalizarURL(url);
        return urlNormalizada.endsWith("/" + carpetaCodificada);
    }

    private String limpiarNombreCarpeta(String nombre) {
    // Quita espacios extra, convierte a UTF-8 safe
    nombre = nombre.trim().replaceAll("\\s{2,}", " ");
    return nombre;
}

    private String buildWebDAVPath(String baseUrl, String carpeta) throws UnsupportedEncodingException {
        if (!baseUrl.endsWith("/")) {
            baseUrl += "/";
        }

        carpeta = limpiarNombreCarpeta(carpeta); // Limpia espacios dobles, etc.
        String carpetaCodificada = URLEncoder.encode(carpeta, "UTF-8").replace("+", "%20");

        // Decodificamos todo el path para evitar comparaciones parciales
        String baseDecodificada = URLDecoder.decode(baseUrl, "UTF-8").toLowerCase();
        try {
            String[] segmentos = baseUrl.split("/");
            String ultima = segmentos[segmentos.length - 1];
            String ultimaDec = URLDecoder.decode(ultima, "UTF-8").trim().toUpperCase();
            String carpetaDec = carpeta.trim().toUpperCase();

            if (ultimaDec.equals(carpetaDec)) {
                System.out.println("Detección de carpeta duplicada: " + carpeta);
                return baseUrl;
            }
        } catch (UnsupportedEncodingException e) {
            // En caso de error, continuar con la construcción normal
        }


        // También cubre casos donde la codificación ya esté presente
        if (baseUrl.toLowerCase().endsWith("/" + carpetaCodificada.toLowerCase())) {
            System.out.println("Ruta ya contiene la carpeta codificada. No se añade: " + carpetaCodificada);
            return baseUrl;
        }

        // Agrega normalmente si no está repetido
        String rutaFinal = baseUrl + carpetaCodificada;
        System.out.println("Ruta construida: " + rutaFinal);
        return rutaFinal;
    }


    
    private void subirArchivosAClave(String claveCarpeta) {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(jpfContrasena.getPassword());
        System.out.println("Ruta global: " + rutaSeleccionadaGlobal);
        if (rutaSeleccionadaGlobal == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una carpeta en la lista primero.");
            return;
        }

        try {
            // reutilizamos tu método para listar carpetas y buscar subcarpeta clave
            List<DavResource> recursos = manejador.listarCarpeta(rutaSeleccionadaGlobal);

            DavResource carpetaDestino = null;
            for (DavResource res : recursos) {
                if (res.isDirectory() && res.getName().toUpperCase().matches("\\d+_" + claveCarpeta + "_\\d+")) {
                    carpetaDestino = res;
                    break;
                }
            }

            if (carpetaDestino == null) {
                JOptionPane.showMessageDialog(this, "No se encontró carpeta para la clave: " + claveCarpeta);
                return;
            }

            String rutaCarpeta = buildWebDAVPath(rutaSeleccionadaGlobal, carpetaDestino.getName());
            rutaCarpeta = normalizarURL(rutaCarpeta);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            int resultado = fileChooser.showOpenDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File[] archivosSeleccionados = fileChooser.getSelectedFiles();

                for (File archivoLocal : archivosSeleccionados) {
                    String nombreArchivo = archivoLocal.getName();
                    String rutaArchivoRemota = buildWebDAVPath(rutaCarpeta, nombreArchivo);

                    try {
                        byte[] datosArchivo = Files.readAllBytes(archivoLocal.toPath());
                        try (InputStream is = new ByteArrayInputStream(datosArchivo)) {
                            System.out.println("Nombre archivo: " + nombreArchivo);
                            System.out.println("Ruta remota generada: " + rutaArchivoRemota);
                            System.out.println("Tamaño archivo (bytes): " + datosArchivo.length);
                            System.out.println("Usuario usado: " + usuario);
                            System.out.println("Clave usada: " + clave);
                            

                            manejador.subirArchivoHttpClient(rutaArchivoRemota, usuario, clave, datosArchivo);
                            System.out.println("Archivo subido: " + nombreArchivo + " a " + rutaArchivoRemota);
                            System.out.println("Ruta después de buildWebDAVPath: " + buildWebDAVPath(rutaCarpeta, nombreArchivo));
                            System.out.println("Ruta después de normalizarURL: " + rutaArchivoRemota);

                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(this, "Error subiendo archivo: " + nombreArchivo + "\n" + e.getMessage());
                        e.printStackTrace();
                    }
                }

                

                JOptionPane.showMessageDialog(this, "Archivos subidos correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en proceso de subida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void activarDesactivarPaneles(JPanel panel, boolean enabled) {
        panel.setEnabled(enabled);
        for (Component comp : panel.getComponents()) {
            comp.setEnabled(enabled);
            if (comp instanceof JPanel) {
                activarDesactivarPaneles((JPanel) comp, enabled);  // recursivo si hay subpaneles
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
    private javax.swing.JList<String> JListCarpetas;
    private javax.swing.JButton btnBuscarCarpetaPrincipal;
    private javax.swing.JButton btnBuscarPalabraClave;
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
    private javax.swing.JButton jButton20;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JCheckBox jcbWeb;
    private javax.swing.JPasswordField jpfContrasena;
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
    private javax.swing.JTextField txtPalabraClave;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtRutaPrincipal;
    private javax.swing.JTextField txtRutaPrincipal2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
