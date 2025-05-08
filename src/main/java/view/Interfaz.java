/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.io.File;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import persistencia.ManejadorArchivos;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import persistencia.ConfigUtil;
/**
 *
 * @author user
 */
public class Interfaz extends javax.swing.JFrame {
    String nombreExpediente;
    JComponent[] componentes;
    
    public Interfaz() {
        initComponents();
        setLocationRelativeTo(null);
        ((AbstractDocument) txtDni.getDocument()).setDocumentFilter(new FiltroNumericoLimitado(8));
        ((AbstractDocument) txtAnio.getDocument()).setDocumentFilter(new FiltroNumericoLimitado4numeros(4));
        jCheckBoxEstadoAutocompletado.setSelected(false); // Asegurar que inicie desmarcado
        actualizarEstadoComponentesAutocompletado(false); // Aplicar configuración inicial

        String rutaGuardada = ConfigUtil.cargarRuta();
        if (rutaGuardada != null) {
            ManejadorArchivos.setRutaCarpetaPrincipal(rutaGuardada);
            System.out.println("Ruta cargada desde config.txt: " + rutaGuardada);
        }
        // Asegurar estado inicial correcto
        actualizarEstadoComponentesAutocompletado(jCheckBoxEstadoAutocompletado.isSelected());

    }
    public class FiltroNumericoLimitado4numeros extends DocumentFilter {
        private int maxLength;

        public FiltroNumericoLimitado4numeros(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string == null) return;
            if (esValido(fb.getDocument().getLength(), string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text == null) return;
            if (esValido(fb.getDocument().getLength() - length, text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean esValido(int currentLength, String text) {
            return text.matches("\\d*") && (currentLength + text.length()) <= maxLength;
        }
    }
    public class FiltroNumericoLimitado extends DocumentFilter {
        private int maxLength;

        public FiltroNumericoLimitado(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string == null) return;
            if (esValido(fb.getDocument().getLength(), string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text == null) return;
            if (esValido(fb.getDocument().getLength() - length, text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean esValido(int currentLength, String text) {
            return text.matches("\\d*") && (currentLength + text.length()) <= maxLength;
        }
    }
    // Corrección de estados al cargar la interfaz, luego de que todo esté inicializado
    private void actualizarEstadoComponentesAutocompletado(boolean seleccionado) {
        // Comportamiento para carpeta
        

        txtCarpetaExpediente.setEnabled(!seleccionado);
        btnBuscarCarpeta.setEnabled(!seleccionado);

        // Comportamiento para Excel manual
        txtExcel.setEnabled(!seleccionado);
        btnBuscarExcel.setEnabled(!seleccionado);
        jcbHojaExcel2.setEnabled(!seleccionado);
        txtFilaSeleccionada.setEnabled(!seleccionado);

        // Si querés que también se desactive el botón registrar:
        btnRegistrar.setEnabled(!seleccionado);
        
        //Botones desactivados al inicio
        jButton2.setEnabled(seleccionado);
        txtRutaExcel.setEnabled(seleccionado);
        txtSeleccionaFilaAutocompletado.setEnabled(seleccionado);
        jcbHojaExcel.setEnabled(seleccionado);
        jButton5.setEnabled(seleccionado);
        btnCrearSubcarpetas.setEnabled(seleccionado);
        txtCarpetaExpediente.setEnabled(seleccionado);
        btnBuscarCarpeta.setEnabled(seleccionado);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Registrar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCaso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroExpediente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbSIMISGD = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCarpetaExpediente = new javax.swing.JTextField();
        btnBuscarCarpeta = new javax.swing.JButton();
        txtExcel = new javax.swing.JTextField();
        btnBuscarExcel = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtPrimerNombre = new javax.swing.JTextField();
        txtSegundoNombre = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jcbMes = new javax.swing.JComboBox<>();
        txtAnio = new javax.swing.JTextField();
        txtFilaSeleccionada = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCarpetaPrincipal = new javax.swing.JTextField();
        btnBuscarCarpetaPrincipal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtSeleccionaFilaAutocompletado = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtRutaExcel = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jcbHojaExcel = new javax.swing.JComboBox<>();
        btnCrearSubcarpetas = new javax.swing.JButton();
        jCheckBoxEstadoAutocompletado = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jcbHojaExcel2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Registrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Proyecto Carpeta Unica - Archivo Unico");

        jLabel2.setText("Caso");

        jLabel3.setText("N Expediente");

        jLabel4.setText("N Expediente SIMI o SGD");

        jcbSIMISGD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIMI", "SGD" }));

        jLabel5.setText("Apellido Paterno");

        jLabel6.setText("Apellido Materno");

        jLabel7.setText("Primer Nombre");

        jLabel8.setText("Seguno Nombre");

        jLabel9.setText("DNI, si no tiene ingresar NN");

        jLabel10.setText("Año de expediente");

        jLabel11.setText("Mes de expediente");

        jLabel12.setText("Seleccionar Carpeta");

        jLabel13.setText("Excel de trabajo");

        txtCarpetaExpediente.setColumns(15);

        btnBuscarCarpeta.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btnBuscarCarpeta.setText("EXAMINAR");
        btnBuscarCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCarpetaActionPerformed(evt);
            }
        });

        txtExcel.setColumns(15);

        btnBuscarExcel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btnBuscarExcel.setText("EXAMINAR");
        btnBuscarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarExcelActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jcbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        jLabel15.setText("¿Desde que fila quiere iniciar?");

        jLabel17.setText("Seleccionar carpeta Principal");

        txtCarpetaPrincipal.setColumns(15);

        btnBuscarCarpetaPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnBuscarCarpetaPrincipal.setText("EXAMINAR");
        btnBuscarCarpetaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCarpetaPrincipalActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel18.setText("SELECCIONAR FILA");

        jButton2.setText("SELECCIONAR EXCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("CARGAR DATOS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel20.setText("Seleccionar Excel:");

        jLabel21.setText("Seleccionar Hoja:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(31, 31, 31)
                        .addComponent(txtRutaExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbHojaExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSeleccionaFilaAutocompletado, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButton5))
                    .addComponent(jButton2))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtRutaExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtSeleccionaFilaAutocompletado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jcbHojaExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        btnCrearSubcarpetas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCrearSubcarpetas.setText("RENOMBRAR CARPETA");
        btnCrearSubcarpetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSubcarpetasActionPerformed(evt);
            }
        });

        jCheckBoxEstadoAutocompletado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCheckBoxEstadoAutocompletado.setText("Autocompletar-Renombrar");
        jCheckBoxEstadoAutocompletado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEstadoAutocompletadoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton3.setText("Funcionamiento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setText("Seleccionar Hoja:");

        jButton4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton4.setText("LIMPIAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("ORDENAR ARCHIVOS AUTOMATICAMENTE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarLayout = new javax.swing.GroupLayout(Registrar);
        Registrar.setLayout(RegistrarLayout);
        RegistrarLayout.setHorizontalGroup(
            RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(38, 38, 38)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbSIMISGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCaso)
                            .addComponent(txtNumeroExpediente)
                            .addComponent(txtApellidoPaterno)
                            .addComponent(txtApellidoMaterno)
                            .addComponent(txtPrimerNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txtSegundoNombre)
                            .addComponent(txtDni))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addComponent(jCheckBoxEstadoAutocompletado)
                                .addGap(30, 30, 30)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBuscarCarpeta, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBuscarExcel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrarLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrarLayout.createSequentialGroup()
                                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel10))
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel12))
                                        .addGap(63, 63, 63)
                                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnBuscarCarpetaPrincipal)
                                            .addComponent(txtCarpetaExpediente, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcbMes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAnio)
                                            .addComponent(txtCarpetaPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrarLayout.createSequentialGroup()
                                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFilaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbHojaExcel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrarLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(btnCrearSubcarpetas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegistrar))
                            .addComponent(jButton6))))
                .addGap(22, 22, 22))
        );
        RegistrarLayout.setVerticalGroup(
            RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBoxEstadoAutocompletado)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(28, 28, 28)
                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNumeroExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jcbSIMISGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jcbHojaExcel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtCarpetaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCarpetaPrincipal)
                                .addGap(18, 18, 18)
                                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCarpetaExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCarpeta)
                        .addGap(18, 18, 18)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarExcel)
                        .addGap(42, 42, 42)))
                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearSubcarpetas)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBuscarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCarpetaActionPerformed
        ManejadorArchivos.seleccionarCarpeta(txtCarpetaExpediente);
        txtCarpetaExpediente.setText(ManejadorArchivos.getRutaCarpeta());
    }//GEN-LAST:event_btnBuscarCarpetaActionPerformed

    private void btnBuscarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarExcelActionPerformed
        ManejadorArchivos.seleccionarExcel(txtExcel, jcbHojaExcel2);
        txtExcel.setText(ManejadorArchivos.getRutaCarpetaExcel());
    }//GEN-LAST:event_btnBuscarExcelActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        nombreExpediente = "EXP_" + txtCaso.getText().toUpperCase() + "_" + txtAnio.getText() + "_" +
                       txtApellidoPaterno.getText().toUpperCase() +
                       txtApellidoMaterno.getText().toUpperCase() +
                       txtPrimerNombre.getText().toUpperCase() +
                       txtSegundoNombre.getText().toUpperCase() + "_" +
                       txtDni.getText();

        String nombreCarpeta = nombreExpediente;

        String[] nombres = {
            txtCaso.getText(),
            txtNumeroExpediente.getText(),
            (String) jcbSIMISGD.getSelectedItem(),
            txtApellidoPaterno.getText().toUpperCase(),
            txtApellidoMaterno.getText().toUpperCase(),
            txtPrimerNombre.getText().toUpperCase(),
            txtSegundoNombre.getText().toUpperCase(),
            txtDni.getText(),
            (String) jcbMes.getSelectedItem(),
            txtAnio.getText(),
            nombreCarpeta,
            nombreExpediente
        };

        String hojaSeleccionada = (String) jcbHojaExcel2.getSelectedItem();
        int filaSeleccionada = Integer.parseInt(txtFilaSeleccionada.getText()) - 1;

        ManejadorArchivos.agregarFilaExcel(
            ManejadorArchivos.getRutaCarpetaExcel(),
            nombres,
            hojaSeleccionada,
            filaSeleccionada
        );

        if (ManejadorArchivos.getCondicionFila().equals("vacio")) {
            ManejadorArchivos.crearCarpetaConSubcarpetas(ManejadorArchivos.getRutaCarpetaPrincipal(), nombreCarpeta, txtDni.getText());
            /*
            ManejadorArchivos.procesarCarpeta(ManejadorArchivos.getRutaCarpetaPrincipal(), txtDni.getText());
            ManejadorArchivos.renombrarCarpeta(ManejadorArchivos.getRutaCarpeta(), nombreCarpeta);
            ManejadorArchivos.renombrarArchivoMerged(ManejadorArchivos.getRutaCarpeta(), nombreExpediente);*/
            JOptionPane.showMessageDialog(null, "Datos ingresados en: " + (ManejadorArchivos.getFilaIngresada() + 1));
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtCaso.setText("");
        txtNumeroExpediente.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtPrimerNombre.setText("");
        txtSegundoNombre.setText("");
        txtDni.setText("");
        txtAnio.setText("");
        txtCarpetaExpediente.setText("");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnBuscarCarpetaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCarpetaPrincipalActionPerformed
        ManejadorArchivos.seleccionarCarpetaPrincipal();
        txtCarpetaPrincipal.setText(ManejadorArchivos.getRutaCarpetaPrincipal());
    }//GEN-LAST:event_btnBuscarCarpetaPrincipalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ManejadorArchivos.seleccionarExcel(txtRutaExcel, jcbHojaExcel);
        JOptionPane.showMessageDialog(null, "Ruta del archivo Excel: " + ManejadorArchivos.getRutaCarpetaExcel());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCrearSubcarpetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSubcarpetasActionPerformed
        String nombreCarpeta = "EXP_" + txtCaso.getText() + "_" + txtAnio.getText() + "_" + 
            txtApellidoPaterno.getText().toUpperCase() + 
            txtApellidoMaterno.getText().toUpperCase() + 
            txtPrimerNombre.getText().toUpperCase() + 
            txtSegundoNombre.getText().toUpperCase() + 
            "_" + txtDni.getText();

        String expediente = "EXP_" + txtCaso.getText().toUpperCase() + "_" + txtAnio.getText() + "_" + 
                txtApellidoPaterno.getText().toUpperCase() + 
                txtApellidoMaterno.getText().toUpperCase() + 
                txtPrimerNombre.getText().toUpperCase() + 
                txtSegundoNombre.getText().toUpperCase() + 
                "_" + txtDni.getText();

        ManejadorArchivos.renombrarArchivoMerged(ManejadorArchivos.getRutaCarpeta(), expediente);
        ManejadorArchivos.procesarCarpeta(ManejadorArchivos.getRutaCarpeta(), txtDni.getText());

        boolean renombrado = ManejadorArchivos.renombrarCarpeta(ManejadorArchivos.getRutaCarpeta(), nombreCarpeta);
        if (renombrado) {
            // Ojo: aquí usamos la carpeta padre más el nuevo nombre
            File nuevaCarpeta = new File(new File(ManejadorArchivos.getRutaCarpeta()).getParent(), nombreCarpeta);
            ManejadorArchivos.setRutaCarpeta(nuevaCarpeta.getAbsolutePath());
        }
    }//GEN-LAST:event_btnCrearSubcarpetasActionPerformed

    private void jCheckBoxEstadoAutocompletadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEstadoAutocompletadoActionPerformed
        boolean seleccionado = jCheckBoxEstadoAutocompletado.isSelected();
        actualizarEstadoComponentesAutocompletado(seleccionado);
    }//GEN-LAST:event_jCheckBoxEstadoAutocompletadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Crear una instancia del segundo JFrame
        InterfazSeleccionar ventana = new InterfazSeleccionar();

        // Hacerlo visible
        ventana.setVisible(true);

        // Cerrar el actual (opcional)
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(null, "1. Despues de completar todos los datos se buscara la carpeta principal de trabajo, luego se tendra que escribir \nla fila en la que se quieren inngresar los datos y seleccionar la carpeta donde se encuentra el excel \n 2. Si se quiere renombrar una carpeta con datos de alguna fila del Excel se debe presionar en 'Automcompletar',\nluego se buscara la carpeta principal y la carpeta que se quiere renombrar, dedpues se escribira la fila\n y se seleccionara el Excel, esto tomara automcompletara el formulario con los datos de la fila, al darle click \nen Renombrar Carpeta renombrara la carpeta, creara las subcarpetas y ordenara los archivos que tengan el indice de las etapas");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JComponent[] componentes = {txtCaso, txtNumeroExpediente, jcbSIMISGD, txtApellidoPaterno, txtApellidoMaterno, 
                            txtPrimerNombre, txtSegundoNombre, txtDni, txtAnio, jcbMes};
        String nombreHojaSeleccionada = (String) jcbHojaExcel.getSelectedItem();

        ManejadorArchivos.autocompletarPorFilaExcel(ManejadorArchivos.getRutaCarpetaExcel(), nombreHojaSeleccionada,Integer.parseInt(txtSeleccionaFilaAutocompletado.getText()), componentes);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ManejadorArchivos.moverArchivosCoincidentes(ManejadorArchivos.getRutaCarpeta());
    }//GEN-LAST:event_jButton6ActionPerformed
    
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Registrar;
    private javax.swing.JButton btnBuscarCarpeta;
    private javax.swing.JButton btnBuscarCarpetaPrincipal;
    private javax.swing.JButton btnBuscarExcel;
    private javax.swing.JButton btnCrearSubcarpetas;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBoxEstadoAutocompletado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcbHojaExcel;
    private javax.swing.JComboBox<String> jcbHojaExcel2;
    private javax.swing.JComboBox<String> jcbMes;
    private javax.swing.JComboBox<String> jcbSIMISGD;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCarpetaExpediente;
    private javax.swing.JTextField txtCarpetaPrincipal;
    private javax.swing.JTextField txtCaso;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtExcel;
    private javax.swing.JTextField txtFilaSeleccionada;
    private javax.swing.JTextField txtNumeroExpediente;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtRutaExcel;
    private javax.swing.JTextField txtSegundoNombre;
    private javax.swing.JTextField txtSeleccionaFilaAutocompletado;
    // End of variables declaration//GEN-END:variables
}
