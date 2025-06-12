package view;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import persistencia.ConfigUtil;
import persistencia.ManejadorArchivos;

public class ExtraerPaginasPDF extends javax.swing.JFrame {

    private String rutaPDFOriginal;
    private PDDocument documento;
    private PDFRenderer renderer;
    private JPanel panelPaginas;
    private JScrollPane scrollPanel;
    private float zoom = 1.0f;
    private Map<Integer, BufferedImage> cache = new HashMap<>();
    private int paginasCargadas = 0;
    private final int BATCH = 3;

    // Componentes UI
    private JTextField txtPaginaInicio, txtPaginaFin;
    private JButton btnExtraer;
    private JLabel lblInfo, lblTotalPaginas, lblPaginaActual;

    public ExtraerPaginasPDF(String rutaPDFOriginal) {
        this.rutaPDFOriginal = rutaPDFOriginal;
        initComponents();
        initPDF();
        
    }

    private void initComponents() {
        txtPaginaInicio = new JTextField(3);
        txtPaginaFin = new JTextField(3);
        btnExtraer = new JButton("Extraer páginas");
        lblInfo = new JLabel("Archivo:");
        lblTotalPaginas = new JLabel("Total: ?");
        lblPaginaActual = new JLabel("Página visible: 1");
        panelPaginas = new JPanel();
        panelPaginas.setLayout(new BoxLayout(panelPaginas, BoxLayout.Y_AXIS));
        String rutaGuardadaGeneral = ConfigUtil.cargarRutaGeneral();
        scrollPanel = new JScrollPane(panelPaginas);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(35);
        scrollPanel.getVerticalScrollBar().addAdjustmentListener(e -> {
            if (!e.getValueIsAdjusting() && e.getValue() + e.getAdjustable().getVisibleAmount() >= e.getAdjustable().getMaximum() - 50) {
                cargarMasPaginas();
            }

            // Mostrar la página actualmente visible
            SwingUtilities.invokeLater(() -> {
                Rectangle visible = scrollPanel.getViewport().getViewRect();
                Component[] comps = panelPaginas.getComponents();
                int pagina = 1;
                for (Component c : comps) {
                    if (c instanceof JLabel) {
                        Rectangle bounds = c.getBounds();
                        if (visible.intersects(bounds)) {
                            lblPaginaActual.setText("Página visible: " + pagina);
                            break;
                        }
                        pagina++;
                    }
                }
            });
        });

        scrollPanel.addMouseWheelListener(e -> {
            if (e.isControlDown()) {
                zoom += e.getWheelRotation() < 0 ? 0.25f : -0.25f;
                zoom = Math.max(0.25f, zoom); // Limitar zoom mínimo
                cache.clear();
                paginasCargadas = 0;
                panelPaginas.removeAll();
                cargarMasPaginas();
            }
        });

        btnExtraer.addActionListener(e -> realizarExtraccion());

        // Layout superior
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(lblInfo);
        top.add(lblTotalPaginas);
        top.add(lblPaginaActual); // Nueva línea para mostrar la página actual
        top.add(new JLabel("Desde:")); top.add(txtPaginaInicio);
        top.add(new JLabel("Hasta:")); top.add(txtPaginaFin);
        top.add(btnExtraer);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(scrollPanel, BorderLayout.CENTER);

        setTitle("Extraer y Previsualizar PDF");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initPDF() {
        try {
            documento = PDDocument.load(new File(rutaPDFOriginal));
            renderer = new PDFRenderer(documento);
            
            lblTotalPaginas.setText("Total: " + documento.getNumberOfPages());
            cargarMasPaginas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al abrir PDF: " + e.getMessage());
        }
    }

    private void cargarMasPaginas() {
        try {
            int total = documento.getNumberOfPages();
            int hasta = Math.min(paginasCargadas + BATCH, total);
            for (int i = paginasCargadas; i < hasta; i++) {
                BufferedImage img = cache.computeIfAbsent(i, idx -> {
                    try {
                        return renderer.renderImage(idx, zoom);
                    } catch (Exception ex) {
                        return null;
                    }
                });
                if (img != null) {
                    JLabel lbl = new JLabel(new ImageIcon(img));
                    lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panelPaginas.add(Box.createVerticalStrut(10));
                    panelPaginas.add(lbl);
                }
            }
            paginasCargadas = hasta;
            panelPaginas.revalidate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al renderizar: " + e.getMessage());
        }
    }

    private void realizarExtraccion() {
        try {
            int inicio = Integer.parseInt(txtPaginaInicio.getText().trim()) - 1;
            int fin = Integer.parseInt(txtPaginaFin.getText().trim()) - 1;
            int total = documento.getNumberOfPages();

            if (inicio < 0 || fin < inicio || fin >= total) {
                JOptionPane.showMessageDialog(this, "Rango inválido.");
                return;
            }

            PDDocument nuevo = new PDDocument();
            for (int i = inicio; i <= fin; i++) {
                nuevo.addPage(documento.getPage(i));
            }

            JFileChooser chooser = new JFileChooser(ManejadorArchivos.getRutaCarpetaGeneral());
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File destino = chooser.getSelectedFile();
                if (!destino.getName().toLowerCase().endsWith(".pdf"))
                    destino = new File(destino.getAbsolutePath() + ".pdf");
                nuevo.save(destino);
                JOptionPane.showMessageDialog(this, "Guardado exitoso.");
            }
            nuevo.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Páginas inválidas.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al extraer: " + ex.getMessage());
        }
    }
}
