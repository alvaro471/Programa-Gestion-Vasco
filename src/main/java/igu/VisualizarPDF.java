/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu;
import java.awt.BorderLayout;
import java.awt.Dimension;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.FileInputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author user
 */
public class VisualizarPDF extends javax.swing.JFrame {

    private PDDocument documento;
    private PDFRenderer renderer;
    private int paginaActual = 0;
    private float zoom = 1.0f;
    private String rutaPDF;
    private JPanel panelPaginas;
    private JScrollPane scrollPane;
    private int paginasCargadas = 0;
    private final int PAGINAS_POR_BATCH = 3;

    
    public VisualizarPDF() {
        initComponents();
    }
    public VisualizarPDF(String rutaArchivoPDF) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.rutaPDF = rutaArchivoPDF;

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    if (documento != null) {
                        documento.close(); // Libera el archivo PDF si está abierto
                    }
                } catch (Exception ex) {
                    System.out.println("Error al cerrar PDF: " + ex.getMessage());
                }
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = (int) (screenSize.width * 0.6);
        int alto = (int) (screenSize.height * 0.8);
        setSize(ancho, alto);
        setLocationRelativeTo(null); // Centrar

        // Verificar el tipo de archivo
        if (rutaArchivoPDF.toLowerCase().endsWith(".pdf")) {
            inicializarPDF(); // Cargar como PDF
        } else if (rutaArchivoPDF.toLowerCase().endsWith(".docx")) {
            inicializarWord(); // Cargar como Word
        } else {
            JOptionPane.showMessageDialog(this, "Tipo de archivo no soportado.");
        }
    }
    private void inicializarPDF() {
        try {
            documento = PDDocument.load(new File(rutaPDF));
            renderer = new PDFRenderer(documento);
            inicializarVisorLazy(); // Lazy loading de páginas PDF
            configurarBotones();    // Solo botón Cerrar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al abrir el PDF: " + e.getMessage());
        }
    }
    private void inicializarWord() {
        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        panelPDF.removeAll();
        panelPDF.setLayout(new BorderLayout());
        panelPDF.add(scroll, BorderLayout.CENTER);

        try (FileInputStream fis = new FileInputStream(rutaPDF);
             XWPFDocument doc = new XWPFDocument(fis)) {
            StringBuilder sb = new StringBuilder();
            for (XWPFParagraph p : doc.getParagraphs()) {
                sb.append(p.getText()).append("\n");
            }
            areaTexto.setText(sb.toString());
        } catch (Exception e) {
            areaTexto.setText("Error al abrir Word: " + e.getMessage());
        }

        panelPDF.revalidate();
        panelPDF.repaint();
    }


    private void inicializarVisorLazy() {
        panelPaginas = new JPanel();
        panelPaginas.setLayout(new BoxLayout(panelPaginas, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(panelPaginas);
        scrollPane.addMouseWheelListener(e -> {
        if (e.isControlDown()) {
            if (e.getWheelRotation() < 0) {
                zoom += 0.25f;
            } else if (zoom > 0.25f) {
                zoom -= 0.25f;
            }

            // Volver a cargar desde la primera página
            paginasCargadas = 0;
            panelPaginas.removeAll();
            cargarMasPaginas();
        }
    });

        scrollPane.getVerticalScrollBar().setUnitIncrement(35);

        scrollPane.getVerticalScrollBar().addAdjustmentListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int extent = scrollPane.getVerticalScrollBar().getModel().getExtent();
                int maximum = scrollPane.getVerticalScrollBar().getMaximum();
                int value = scrollPane.getVerticalScrollBar().getValue();

                // Si estamos cerca del fondo, cargamos más páginas
                if (value + extent >= maximum - 100) {
                    cargarMasPaginas();
                }
            }
        });

        panelPDF.removeAll();
        panelPDF.setLayout(new BorderLayout());
        panelPDF.add(scrollPane, BorderLayout.CENTER);
        panelPDF.revalidate();
        panelPDF.repaint();

        cargarMasPaginas(); // Cargar las primeras páginas
    }
    //Funciona con el de arriba
    private void cargarMasPaginas() {
        try {
            int total = documento.getNumberOfPages();
            int hasta = Math.min(paginasCargadas + PAGINAS_POR_BATCH, total);

            for (int i = paginasCargadas; i < hasta; i++) {
                BufferedImage image = renderer.renderImage(i, zoom);
                JLabel label = new JLabel(new ImageIcon(image));
                label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                panelPaginas.add(Box.createVerticalStrut(10));
                panelPaginas.add(label);
            }

            paginasCargadas = hasta;
            panelPaginas.revalidate();
            panelPaginas.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al renderizar páginas: " + e.getMessage());
        }
    }



    private void configurarBotones() {
        JButton btnCerrar = new JButton("Cerrar");

        btnCerrar.addActionListener(e -> {
            try {
                if (documento != null) {
                    documento.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al cerrar el PDF: " + ex.getMessage());
            }
            dispose();
        });

        panelBotones.removeAll();
        panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBotones.add(btnCerrar);
        panelBotones.revalidate();
        panelBotones.repaint();
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPDF = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelPDFLayout = new javax.swing.GroupLayout(panelPDF);
        panelPDF.setLayout(panelPDFLayout);
        panelPDFLayout.setHorizontalGroup(
            panelPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        panelPDFLayout.setVerticalGroup(
            panelPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VisualizarPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarPDF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelPDF;
    // End of variables declaration//GEN-END:variables
}
