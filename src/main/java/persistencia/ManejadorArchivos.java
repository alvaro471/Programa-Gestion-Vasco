package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import java.awt.Color;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import org.apache.commons.math3.util.Pair;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.util.regex.*;



public class ManejadorArchivos {
    
    //-------------VARIABLES----------------------------------------------------------------------------------------------------------
    private static String rutaCarpeta;//Ruta especifica del RD
    private static String rutaCarpetaExcel;//Guarda la ruta del excel
    private static int ultimaFila;
    private static String ultimaRuta = ".";
    private static int filaIngresada;
    private static String rutaCarpetaPrincipal;

    static {
        String rutaGuardada = ConfigUtil.cargarRuta();
        if (rutaGuardada != null) {
            rutaCarpetaPrincipal = rutaGuardada;
            System.out.println("Ruta cargada desde configuración: " + rutaCarpetaPrincipal);
        } else {
            rutaCarpetaPrincipal = "C:\\Users";
            System.out.println("Primera vez ejecutando el programa. Usando ruta por defecto: " + rutaCarpetaPrincipal);
            System.out.println("Aún no se ha asignado una dirección principal.");
        }
    }

    private static String nombreCarpetaObtenido = "";
    private static String nombreExpedienteObtenido = "";
    private static String condicionFila = "vacio";
    public static String[] rutasRenombradas;
    private static List<File> pdfFiles = new ArrayList<>();
    private static Map<Integer, File[]> documentosMap;
    private static String rutaArchivoSeleccionado = ""; // variable global dentro de esta clase
    private static String rutaArchivoSeleccionadoConsolidado;
    private static List<String> rutasArchivosSeleccionados = new ArrayList<>();
    private static final String ARCHIVO_CONFIG = "config.txt";
    private static int contadorArchivosRenombrados = 0;
    //-------------------------------------------------------------------------------------------------------------------------------
    
    /*
    *
    *
    *
    *
    *
    *
    *
    *
    */
    
    //------------------------Setters y Getters---------------------------------------------------------------------------------
    public static String getRutaCarpetaExcel(){
        return rutaCarpetaExcel;
    }
    public static String getRutaCarpeta(){
        return rutaCarpeta;
    }
    
    public static void setRutaCarpeta(String nuevaRuta) {
        rutaCarpeta = nuevaRuta;
        // Guardamos la nueva ruta en el archivo
        ConfigUtil.guardarRuta(rutaCarpeta);
    }
    public static int getUltimaFila(){
        return ultimaFila;
    }
    public static int getFilaIngresada(){
        return filaIngresada;
    }
    public static void setRutaCarpetaPrincipal(String ruta) {
        rutaCarpetaPrincipal = ruta;
        ConfigUtil.guardarRuta(ruta); // <- Guarda automáticamente
    }

    public static String getRutaCarpetaPrincipal() {
        if (rutaCarpetaPrincipal == null) {
            String rutaGuardada = ConfigUtil.cargarRuta();
            rutaCarpetaPrincipal = (rutaGuardada != null) ? rutaGuardada : "C:\\Users"; // valor por defecto
        }
        return rutaCarpetaPrincipal;
    }
    public static String getNombreCarpetaObtenido(){
        return nombreCarpetaObtenido;
    }
    public static String getNombreExpedienteObtenido(){
        return nombreExpedienteObtenido;
    }
    public static String getCondicionFila(){
        return condicionFila;
    }
    public static String getRutaArchivoSeleccionado(){
        return rutaArchivoSeleccionado;
    }
    public static String getRutaArchivoSeleccionadoConsolidado() {
        return rutaArchivoSeleccionadoConsolidado;
    }
    public static void setRutaArchivoSeleccionado(String ruta) {
        rutaArchivoSeleccionado = ruta;
    }

    
    public static void setRutaArchivoSeleccionadoConsolidado(String ruta) {
        rutaArchivoSeleccionadoConsolidado = ruta;
    }
    public static void agregarRutaArchivo(String ruta) {
        rutasArchivosSeleccionados.add(ruta);
    }

    public static List<String> getRutasArchivos() {
        return rutasArchivosSeleccionados;
    }

    public static void limpiarRutasArchivos() {
        rutasArchivosSeleccionados.clear();
    }
    public static int getContadorArchivosRenombrados(){
        return contadorArchivosRenombrados;
    }
    public static void setContadorArchivosRenombrados(int _contadorArchivosRenombrados){
        contadorArchivosRenombrados = _contadorArchivosRenombrados;
    }
    //--------------------------------------------------------------------------------------------------------------------------------
    
    /*
    *
    *
    *
    *
    *
    *
    *
    *
    */
    
    //---------------------Metodos-------------------------------------------------------------------------------------------------

    //Selecciona y Guarda la direccion en rutaCarpeta, se complemnta con el metodo ""
    public static void seleccionarCarpeta(JTextField txtRuta) {
        JFileChooser chooser = new JFileChooser(rutaCarpetaPrincipal);//Se empieza a buscar desde "rutaCarpetaPrincipal"
        chooser.setDialogTitle("Selecciona una carpeta");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        int seleccion = chooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = chooser.getSelectedFile();
            rutaCarpeta = carpetaSeleccionada.getAbsolutePath(); // Aqui guarda la ruta del RD
            txtRuta.setText(rutaCarpeta); // Muestra la ruta en el JTextField ingresado comp parametro
        }
    }
    
    
    
    /*
    *
    *
    */
    
    
    
    //Selecciona y Guarda la direccion del Excel en rutaCarpetaExcel, muestra estado
    public static void seleccionarExcel(JTextField rutaExcelTextField, JComboBox<String> hojasComboBox) {
        
        File rutaPrincipal = (rutaCarpetaPrincipal != null && new File(rutaCarpetaPrincipal).exists()) ?
                new File(rutaCarpetaPrincipal) : new File(System.getProperty("user.home"));
        
        /*
        
        File rutaInicial;
        if (rutaCarpetaPrincipal != null && new File(rutaCarpetaPrincipal).exists()) {
            rutaInicial = new File(rutaCarpetaPrincipal);
        } else {
            rutaInicial = new File(System.getProperty("user.home"));
        }
        */
        
        JFileChooser fileChooser = new JFileChooser(rutaPrincipal);
        fileChooser.setDialogTitle("Seleccionar archivo Excel");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos Excel (*.xls, *.xlsx)", "xls", "xlsx"));

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            rutaCarpetaExcel = archivoSeleccionado.getAbsolutePath();
            //Mostrarlo en el JTextField ingresado en el parametro
            rutaExcelTextField.setText(rutaCarpetaExcel);

            try (FileInputStream fis = new FileInputStream(archivoSeleccionado);
                 Workbook workbook = rutaCarpetaExcel.endsWith(".xlsx") ? new XSSFWorkbook(fis) : new HSSFWorkbook(fis)) {

                // Mostrar las hojas en el JComboBoc ingresado en el parametro
                hojasComboBox.removeAllItems();//remueve todos los items si tuviera
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    hojasComboBox.addItem(workbook.getSheetName(i));
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    
    /*
    *
    *
    */
    
    

    //Crea la carpeta y subcarpetas
    public static void crearCarpetaConSubcarpetas(String rutaBase, String nombreCarpeta, String variable) {
        boolean condicionSubcarpeta = true;
        
        // Crear la carpeta principal conbinando la ruta con el nombre
        File carpeta = new File(rutaBase, nombreCarpeta);

        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Carpeta creada: " + carpeta.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear la carpeta", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Creacion de subcarpetas
        //Variable es pasado por el parametro
        String[] nombresSubcarpetas = {
            "1_REC_" + variable,
            "2_IDE_" + variable,
            "3_EMI_" + variable,
            "4_ARC_" + variable,
            "5_APE_" + variable,
            "6_SEG_" + variable,
            "7_AGR_" + variable,
            "8_CON_" + variable
        };

        // Crear subcarpetas dentro de la carpeta seleccionada
        for (String nombreSubcarpeta : nombresSubcarpetas) {
            //Crea la subcarpea
            File subcarpeta = new File(carpeta, nombreSubcarpeta);
            if (!subcarpeta.exists()) {
                if (subcarpeta.mkdir()) {
                    System.out.println("Subcarpeta creada: " + subcarpeta.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo crear la subcarpeta: " + nombreSubcarpeta);
                    condicionSubcarpeta = false;
                }
            }
        }

        if(condicionSubcarpeta == true){
            JOptionPane.showMessageDialog(null, "Estructura de carpetas creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "La estructura de carpetas NO fue creada exitosamente");
        }
        
    }
    
    
    
    /*
    *
    *
    */
    
    

    //La carpeta ya tiene que estar creada y solo crea las subcarpetas y ahora ordena los archivos
    //(Mas adelante ay otro metodo que solo los ordena y no crea nada se llama "moverArchivosCoincidentes")
    public static void procesarCarpeta(String rutaCarpeta, String variable) {
        File carpeta = new File(rutaCarpeta);

        // Validar que la carpeta existe
        if (!carpeta.exists()) {
            System.out.println("La carpeta especificada no existe.");
            return;
        }
        if(!carpeta.isDirectory()){
            System.out.println("No ha seleccionado una carpeta");
            return;
        }

        // Crear subcarpetas
        String[] nombresSubcarpetas = {
            "1_REC_" + variable,
            "2_IDE_" + variable,
            "3_EMI_" + variable,
            "4_ARC_" + variable,
            "5_APE_" + variable,
            "6_SEG_" + variable,
            "7_AGR_" + variable,
            "8_CON_" + variable
        };

        for (String nombreSubcarpeta : nombresSubcarpetas) {
            File subcarpeta = new File(rutaCarpeta, nombreSubcarpeta);
            if (!subcarpeta.exists()) {
                if (subcarpeta.mkdir()) {
                    System.out.println("Se creo la subcarpeta: " + nombreSubcarpeta);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear la subcarpeta: " + subcarpeta.getAbsolutePath());
                }
            }
        }

        // Ordenar archivos PDF y Word
        File[] archivos = carpeta.listFiles((dir, name) -> name.matches("(?i)^\\d+.*\\.(pdf|docx|doc|jpg|jpeg|png)$"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos PDF o Word con número inicial.");
            return;
        }

        // Mover archivos a la carpeta correspondiente
        for (File archivo : archivos) {
            String nombreArchivo = archivo.getName();
            String numeroInicial = nombreArchivo.replaceAll("^([0-9]+).*", "$1");

            // Buscar carpeta correspondiente
            for (String nombreSubcarpeta : nombresSubcarpetas) {
                if (nombreSubcarpeta.startsWith(numeroInicial + "_")) {
                    File subcarpetaDestino = new File(rutaCarpeta, nombreSubcarpeta);
                    Path archivoPath = archivo.toPath();
                    Path destino = subcarpetaDestino.toPath().resolve(archivo.getName());

                    try {
                        Files.move(archivoPath, destino, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Movido: " + nombreArchivo + " hacia " + subcarpetaDestino.getName());
                        break; // Dejar de buscar una vez que se encuentra la carpeta
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error moviendo " + nombreArchivo + ": " + e.getMessage());
                    }
                }
            }
        }
    }
    
    
    /*
    *
    *
    */
    
    
    //slo renombra la carpeta seleccionada en "rutaCarpeta"
    public static boolean renombrarCarpeta(String rutaCarpeta, String newName) {
        File folder = new File(rutaCarpeta);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("La carpeta no existe o no es un directorio.");
            return false;
        }

        File folderNuevoNombre = new File(folder.getParent(), newName);
        if (folder.renameTo(folderNuevoNombre)) {
            JOptionPane.showMessageDialog(null, "Carpeta renombrada con exito");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al renombrar la carpeta.");
            return false;
        }
    }
    
    
    /*
    *
    *
    */
    
    
    
    //Mueve todos los tipos de archivo a las etapasy los reemplaza si existen
    public static void moverArchivosCoincidentes(String ruta) {
        File rutaCarpeta = new File(ruta);

        if (!rutaCarpeta.exists() || !rutaCarpeta.isDirectory()) {
            JOptionPane.showMessageDialog(null, "La carpeta especificada no existe o no es un directorio.");
            return;
        }

        File[] subcarpetas = rutaCarpeta.listFiles(File::isDirectory);
        if (subcarpetas == null || subcarpetas.length == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron subcarpetas.");
            return;
        }

        int archivosMovidosEtapas = 0;
        int archivosMovidosSeguimiento = 0;

        // Archivos con número inicial y extensiones conocidas (PDF, imágenes)
        File[] archivosConNumero = rutaCarpeta.listFiles((dir, name) -> 
            name.matches("(?i)^\\d+.*\\.(pdf|jpg|jpeg|png)$") &&
            !name.toLowerCase().endsWith(".doc") &&
            !name.toLowerCase().endsWith(".docx")
        );


        // Archivos Word sin necesidad de número inicial
        File[] archivosWord = rutaCarpeta.listFiles((dir, name) ->
            name.toLowerCase().endsWith(".doc") || name.toLowerCase().endsWith(".docx")
        );

        
        //-----------------------------------------------------------------------------------------------------------
        
        // MOVER ARCHIVOS WORD SIN NUMERO A LA CARPETA QUE TENGA AL INCIO EL "3_"-----------------------------------
        if (archivosWord != null) {
            for (File archivo : archivosWord) {
                String nombreArchivo = archivo.getName();

                for (File subcarpeta : subcarpetas) {
                    if (subcarpeta.getName().startsWith("3_")) {
                        Path origen = archivo.toPath();
                        Path destino = subcarpeta.toPath().resolve(nombreArchivo);
                        try {
                            Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Word movido: " + nombreArchivo + " → " + subcarpeta.getName());
                            archivosMovidosEtapas++;
                            break;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error moviendo Word " + nombreArchivo + ": " + e.getMessage());
                        }
                    }
                }
            }
        }
        
        // MUEVE ARCHIVOS CON NUMERO--------------------------------------------
        if (archivosConNumero != null) {
            for (File archivo : archivosConNumero) {
                String nombreArchivo = archivo.getName();
                String numeroInicial = nombreArchivo.replaceAll("^([0-9]+).*", "$1");

                for (File subcarpeta : subcarpetas) {
                    if (subcarpeta.getName().startsWith(numeroInicial + "_")) {
                        Path origen = archivo.toPath();
                        Path destino = subcarpeta.toPath().resolve(nombreArchivo);
                        try {
                            Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Movido: " + nombreArchivo + " → " + subcarpeta.getName());
                            archivosMovidosEtapas++;
                            break;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error moviendo " + nombreArchivo + ": " + e.getMessage());
                        }
                    }
                }
            }
        }
        // EXTRAER ARCHIVOS WORD DE SUBCARPETAS Y MOVER A "3_"
        File subcarpeta3 = Arrays.stream(subcarpetas)
            .filter(f -> f.getName().startsWith("3_"))
            .findFirst()
            .orElse(null);

        if (subcarpeta3 != null) {
            for (File subcarpeta : subcarpetas) {
                File[] archivos = subcarpeta.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        if (archivo.isFile() && (archivo.getName().toLowerCase().endsWith(".doc") || archivo.getName().toLowerCase().endsWith(".docx"))) {
                            Path origen = archivo.toPath();
                            Path destino = subcarpeta3.toPath().resolve(archivo.getName());
                            try {
                                Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("📄 Word extraído y movido a 3_: " + archivo.getName());
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "Error moviendo Word desde subcarpeta: " + e.getMessage());
                            }
                        }
                    }
                }
            }
        }

        // MOVER ARCHIVOS QUE ESTEN DENTRO DE CUALQUIER SUBCARPETA (se ignoran los de "seguimiento" porque tiene otra logica)
        for (File subcarpeta : subcarpetas) {
            
        if (!subcarpeta.getName().equalsIgnoreCase("seguimiento") &&
            !subcarpeta.getName().startsWith("1_") &&
            !subcarpeta.getName().startsWith("2_") &&
            !subcarpeta.getName().startsWith("3_") &&
            !subcarpeta.getName().startsWith("4_") &&
            !subcarpeta.getName().startsWith("5_") &&
            !subcarpeta.getName().startsWith("6_") &&
            !subcarpeta.getName().startsWith("7_") &&
            !subcarpeta.getName().startsWith("8_")) {

            File[] archivos = subcarpeta.listFiles();
            if (archivos == null) continue;

            Set<String> numerosDetectados = new HashSet<>();
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    String nombre = archivo.getName();
                    if (nombre.matches("(?i)^\\d+.*\\.(pdf|jpg|jpeg|png)$")) {
                        String numero = nombre.replaceAll("^([0-9]+).*", "$1");
                        numerosDetectados.add(numero);
                    }
                }
            }

            boolean carpetaMovida = false;
            for (String numero : numerosDetectados) {
                for (File destino : subcarpetas) {
                    if (destino.getName().startsWith(numero + "_")) {
                        Path origen = subcarpeta.toPath();
                        if (subcarpeta.getParentFile().equals(destino.getParentFile())) {
                            System.out.println("🔁 La carpeta ya está en su ubicación correcta: " + subcarpeta.getName());
                            continue;
                        }
                        Path destinoCarpeta = destino.toPath().getParent().resolve(subcarpeta.getName());
                        if (subcarpeta.toPath().equals(destinoCarpeta)) {
                            System.out.println("🚫Evitado intento de mover carpeta dentro de sí misma: " + subcarpeta.getName());
                            continue;
                        }
                        try {
                            Files.move(origen, destinoCarpeta, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Carpeta movida: " + subcarpeta.getName() + " → " + destino.getName());
                            archivosMovidosEtapas++;
                            carpetaMovida = true;
                            break;
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "Error moviendo carpeta " + subcarpeta.getName() + ": " + e.getMessage());
                            System.out.println("Error moviendo carpeta " + subcarpeta.getName() + ": " + e.getMessage());
                        }
                    }
                    if (carpetaMovida) break;
                }
                if (carpetaMovida) break;
            }

            if (!carpetaMovida) {
                archivosMovidosEtapas += moverDesdeSubcarpeta(subcarpeta, subcarpetas);
            }
        }
    }

        // ---------------------------------------------------------------------------

        
        //ME QUEDE AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII-------------------------------------
        
        
        // Buscar carpeta 'seguimiento'
        File carpetaSeguimiento = null;
        for (File subcarpeta : rutaCarpeta.listFiles(File::isDirectory)) {
            if (subcarpeta.getName().equalsIgnoreCase("seguimiento")) {
                carpetaSeguimiento = subcarpeta;
                break;
            }
        }

        // Mover contenido de 'seguimiento' a 6_
        if (carpetaSeguimiento != null && carpetaSeguimiento.isDirectory()) {
            String nombreSubcarpetaBase = "6_";
            File subcarpetaEtapa6 = null;

            for (File subcarpeta : subcarpetas) {
                if (subcarpeta.getName().startsWith(nombreSubcarpetaBase)) {
                    subcarpetaEtapa6 = subcarpeta;
                    break;
                }
            }

            if (subcarpetaEtapa6 == null) {
                subcarpetaEtapa6 = new File(rutaCarpeta, nombreSubcarpetaBase + "SEG");
                if (!subcarpetaEtapa6.exists()) {
                    subcarpetaEtapa6.mkdir();
                }
            }

            File[] contenidoSeguimiento = carpetaSeguimiento.listFiles();
            if (contenidoSeguimiento != null) {
                for (File item : contenidoSeguimiento) {
                    Path origen = item.toPath();
                    Path destino = subcarpetaEtapa6.toPath().resolve(item.getName());
                    try {
                        Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Movido desde seguimiento: " + item.getName() + " → " + subcarpetaEtapa6.getName());
                        archivosMovidosSeguimiento++;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error moviendo " + item.getName() + " desde seguimiento: " + e.getMessage());
                    }
                }
            }

            // Eliminar carpeta 'seguimiento' después de mover los archivos
            try {
                Files.walk(carpetaSeguimiento.toPath())
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
                carpetaSeguimiento.delete();
                System.out.println("Carpeta 'seguimiento' eliminada exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar la carpeta 'seguimiento': " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la carpeta 'seguimiento'. Verifica si está en la ruta correcta.");
        }

        // Mover archivos con palabras clave a carpeta 4_
        File subcarpetaEtapa4 = null;
        for (File subcarpeta : subcarpetas) {
            if (subcarpeta.getName().startsWith("4_")) {
                subcarpetaEtapa4 = subcarpeta;
                break;
            }
        }

        if (subcarpetaEtapa4 == null) {
            subcarpetaEtapa4 = new File(rutaCarpeta, "4_DEFUNCIONES");
            if (!subcarpetaEtapa4.exists()) {
                subcarpetaEtapa4.mkdir();
            }
        }

        for (File subcarpeta : subcarpetas) {
            if (!subcarpeta.equals(subcarpetaEtapa4)) {
                File[] archivos = subcarpeta.listFiles(File::isFile);
                if (archivos != null) {
                    for (File archivo : archivos) {
                        String nombre = archivo.getName().toLowerCase();
                        if (nombre.contains("defuncion") || nombre.contains("defucion") || nombre.contains("fallecimiento")) {
                            Path origen = archivo.toPath();
                            Path destino = subcarpetaEtapa4.toPath().resolve(archivo.getName());
                            try {
                                Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("Archivo con palabra clave movido: " + archivo.getName() + " → " + subcarpetaEtapa4.getName());
                                archivosMovidosEtapas++;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error moviendo archivo con palabra clave " + archivo.getName() + ": " + e.getMessage());
                            }
                        }
                    }
                }
            }
        }

        // Verificar archivos restantes
        File[] archivosRestantes = rutaCarpeta.listFiles((dir, name) -> new File(dir, name).isFile());
        if (archivosRestantes == null || archivosRestantes.length == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron archivos adicionales en la carpeta base.");
        }

        // --- Mostrar mensaje final ---
        String mensajeFinal = "";
        if (archivosMovidosEtapas > 0) {
            mensajeFinal += "✅ Se movieron " + archivosMovidosEtapas + " archivo(s) a las etapas.\n";
        }
        if (archivosMovidosSeguimiento > 0) {
            mensajeFinal += "✅ Se movieron " + archivosMovidosSeguimiento + " archivo(s) desde la carpeta 'seguimiento'.\n";
        }
        if (mensajeFinal.isEmpty()) {
            mensajeFinal = "ℹ️ No se movieron archivos.";
        }
        JOptionPane.showMessageDialog(null, mensajeFinal);
    }

    /*
    *
    *
    */
    
    
    // ------- Método auxiliar para mover archivos desde subcarpetas comunes -------
    private static int moverDesdeSubcarpeta(File carpeta, File[] subcarpetasDestino) {
        int archivosMovidos = 0;

        File[] archivos = carpeta.listFiles();
        if (archivos == null) return archivosMovidos;

        // Detectar números en archivos dentro de la carpeta
        Set<String> numerosDetectados = new HashSet<>();
        for (File archivo : archivos) {
            if (archivo.isFile()) {
                String nombreArchivo = archivo.getName();
                if (nombreArchivo.matches("(?i)^\\d+.*\\.(pdf|jpg|jpeg|png)$")) {
                    String numeroInicial = nombreArchivo.replaceAll("^([0-9]+).*", "$1");
                    numerosDetectados.add(numeroInicial);
                }
            }
        }

        // Intentar mover la carpeta completa
        for (String numero : numerosDetectados) {
            for (File destino : subcarpetasDestino) {
                if (destino.getName().startsWith(numero + "_")) {
                    Path origen = carpeta.toPath();
                    Path destinoCarpeta = destino.toPath().resolve(carpeta.getName());

                    if (origen.equals(destinoCarpeta)) {
                        System.out.println("🚫 Evitado intento de mover carpeta dentro de sí misma: " + carpeta.getName());
                        continue;
                    }

                    try {
                        Files.move(origen, destinoCarpeta, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("📁 Carpeta movida desde subcarpeta: " + carpeta.getName() + " → " + destino.getName());
                        return 1; // Movida con éxito
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error moviendo carpeta " + carpeta.getName() + ": " + e.getMessage());
                    }
                }
            }
        }

        // Si no se pudo mover la carpeta, mostrar advertencia
        if (!numerosDetectados.isEmpty()) {
            String mensaje = "⚠️ No se pudo mover la carpeta '" + carpeta.getName() + "' aunque contiene archivo(s) con número inicial. " +
                             "Verifica que exista una subcarpeta destino que comience con ese número.";
            JOptionPane.showMessageDialog(null, mensaje);
        }

        return archivosMovidos;
    }




    

    public static void renombrarArchivoPorNombreJOptionPane(String rutaArchivo) {
        File archivo = new File(rutaArchivo);

        if (!archivo.exists() || !archivo.isFile()) {
            JOptionPane.showMessageDialog(null, "El archivo no existe o no es válido.\nRuta: " + rutaArchivo,
                                          "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mostrar input dialog para nuevo nombre
        String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Ingrese el nuevo nombre del archivo:",
                            archivo.getName());

        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            // Cancelado o vacío
            return;
        }

        nuevoNombre = nuevoNombre.trim();

        // Validar que el nombre no contenga caracteres inválidos
        if (nuevoNombre.matches(".*[\\\\/:*?\"<>|].*")) {
            JOptionPane.showMessageDialog(null, "El nombre contiene caracteres inválidos.",
                                          "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mantener la extensión original si el usuario no la pone
        if (!nuevoNombre.contains(".")) {
            String extension = getExtension(archivo.getName());
            if (!extension.isEmpty()) {
                nuevoNombre += "." + extension;
            }
        }

        File nuevoArchivo = new File(archivo.getParent(), nuevoNombre);

        // Si ya existe un archivo con ese nombre, avisar
        if (nuevoArchivo.exists()) {
            JOptionPane.showMessageDialog(null, "Ya existe un archivo con ese nombre.",
                                          "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Files.move(archivo.toPath(), nuevoArchivo.toPath());
            setRutaArchivoSeleccionado(nuevoArchivo.getAbsolutePath()); // Actualiza ruta si usás eso
            JOptionPane.showMessageDialog(null, "Archivo renombrado:\n" + nuevoArchivo.getAbsolutePath(),
                                          "Renombrado exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al renombrar archivo:\n" + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   private static String getExtension(String nombreArchivo) {
        int i = nombreArchivo.lastIndexOf('.');
        if (i > 0 && i < nombreArchivo.length() - 1) {
            return nombreArchivo.substring(i + 1);
        }
        return "";
    }



    //Pienso, no tiene funcion
    public static void renombrarArchivo(String folderPath, String newFileName) {
        if (folderPath == null || folderPath.isEmpty()) {
            System.out.println("Error: La ruta de la carpeta es nula o vacía.");
            return;
        }

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Error: La ruta especificada no es válida o no es una carpeta.");
            return;
        }

        // Buscar archivos PDF o Word en la carpeta
        File[] archivos = folder.listFiles((dir, name) -> 
            name.toLowerCase().endsWith(".pdf") || 
            name.toLowerCase().endsWith(".docx") || 
            name.toLowerCase().endsWith(".doc")
        );

        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos PDF o Word en la carpeta.");
            return;
        }

        // Seleccionar el primer archivo encontrado
        File archivoEncontrado = archivos[0];

        if (archivoEncontrado == null) {
            System.out.println("Error: No se pudo obtener un archivo válido.");
            return;
        }

        // Obtener la extensión del archivo original
        String extension = "";
        int lastDotIndex = archivoEncontrado.getName().lastIndexOf(".");
        if (lastDotIndex != -1) {
            extension = archivoEncontrado.getName().substring(lastDotIndex); // Incluye el punto
        }

        // Verificar si el nuevo nombre es válido
        if (newFileName == null || newFileName.trim().isEmpty()) {
            System.out.println("Error: El nuevo nombre del archivo no puede ser nulo o vacío.");
            return;
        }

        // Eliminar las primeras 4 letras del nuevo nombre
        if (newFileName.length() > 4) {
            newFileName = newFileName.substring(4);
        } else {
            System.out.println("Advertencia: El nuevo nombre tiene menos de 4 caracteres, no se modificará.");
        }

        // Crear el nuevo archivo con el nombre modificado y misma extensión
        File nuevoArchivo = new File(folder, newFileName + extension);

        if (archivoEncontrado.renameTo(nuevoArchivo)) {
            System.out.println("Archivo renombrado exitosamente a: " + nuevoArchivo.getName());
        } else {
            System.out.println("Error al renombrar el archivo. Asegúrate de que no esté en uso.");
        }
    }
    //Introducion 12 valores del String[] a la fila Excel
    public static void agregarFilaExcel(String rutaArchivo, String[] valores, String nombreHoja, int numeroFila) {
        if (valores.length != 12) {
            throw new IllegalArgumentException("Se requieren exactamente 12 valores.");
        }

        File archivo = new File(rutaArchivo);
        Workbook workbook = null;
        FileInputStream fileInputStream = null;

        try {
            if (archivo.exists()) {
                fileInputStream = new FileInputStream(archivo);
                workbook = new XSSFWorkbook(fileInputStream);
            } else {
                workbook = new XSSFWorkbook();
            }

            Sheet hoja = workbook.getSheet(nombreHoja);
            if (hoja == null) {
                hoja = workbook.createSheet(nombreHoja);
            }

            Row fila = hoja.getRow(numeroFila);
            if (fila == null) {
                fila = hoja.createRow(numeroFila);
            }

            int celdasLlenas = 0;
            for (int i = 0; i < 12; i++) {
                Cell celda = fila.getCell(i);
                if (celda != null && celda.getCellType() != CellType.BLANK) {
                    celdasLlenas++;
                }
            }

            if (celdasLlenas < 12) {
                for (int i = 0; i < valores.length; i++) {
                    Cell celda = fila.getCell(i);
                    if (celda == null) {
                        celda = fila.createCell(i);
                    }
                    celda.setCellValue(valores[i]);
                }

                FileOutputStream fileOutputStream = new FileOutputStream(archivo);
                workbook.write(fileOutputStream);
                fileOutputStream.close();

                JOptionPane.showMessageDialog(null, "Fila añadida correctamente en " + rutaArchivo);
                filaIngresada = numeroFila;
                condicionFila = "vacio";

            } else {
                JOptionPane.showMessageDialog(null, "La fila " + numeroFila + " está llena. Seleccione otra fila.");
                condicionFila = "lleno";
            }

            if (fileInputStream != null) fileInputStream.close();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
    //Busca la carpeta principal de busqueda
    public static void seleccionarCarpetaPrincipal() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Selecciona una carpeta");

        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = fileChooser.getSelectedFile();
            rutaCarpetaPrincipal = carpetaSeleccionada.getAbsolutePath();

            ConfigUtil.guardarRuta(rutaCarpetaPrincipal); // Guarda en config.txt
            System.out.println("Ruta seleccionada y guardada: " + rutaCarpetaPrincipal);
        } else {
            System.out.println("No se seleccionó ninguna carpeta.");
            rutaCarpetaPrincipal = null;
        }
    }


    //Completa el array de JComponent con elementos en orden de la linea excel
    public static void autocompletarPorFilaExcel(String rutaArchivo, String nombreHoja, int numeroFila, JComponent[] campos) {
        try (FileInputStream file = new FileInputStream(new File(rutaArchivo));
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(nombreHoja);

            if (sheet == null) {
                JOptionPane.showMessageDialog(null, "La hoja '" + nombreHoja + "' no existe en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Row row = sheet.getRow(numeroFila - 1);

            if (row != null) {
                int totalCeldas = row.getLastCellNum();
                int numCampos = campos.length;
                boolean hayDatos = false;

                for (int i = 0; i < numCampos && i < totalCeldas; i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String valor = "";

                    switch (cell.getCellType()) {
                        case STRING:
                            valor = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            double valorNumerico = cell.getNumericCellValue();
                            valor = (valorNumerico == (int) valorNumerico) ?
                                    String.valueOf((int) valorNumerico) : String.valueOf(valorNumerico);
                            break;
                        case BOOLEAN:
                            valor = String.valueOf(cell.getBooleanCellValue());
                            break;
                        default:
                            valor = "";
                            break;
                    }

                    // Depuración: mostrar el valor en consola
                    System.out.println("Celda " + i + ": '" + valor + "'");

                    if (!valor.trim().isEmpty()) {
                        hayDatos = true;
                    }

                    if (campos[i] instanceof JTextField) {
                        ((JTextField) campos[i]).setText(valor);
                    } else if (campos[i] instanceof JComboBox) {
                        ((JComboBox<String>) campos[i]).setSelectedItem(valor);
                    }
                }

                // Obtenemos nombreCarpetaObtenido
                if (totalCeldas >= campos.length + 1) {
                    Cell cell11 = row.getCell(campos.length, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    nombreCarpetaObtenido = obtenerValorComoString(cell11);
                } else {
                    nombreCarpetaObtenido = "";
                }

                // Obtenemos nombreExpedienteObtenido
                if (totalCeldas >= campos.length + 2) {
                    Cell cell12 = row.getCell(campos.length + 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    nombreExpedienteObtenido = obtenerValorComoString(cell12);
                } else {
                    nombreExpedienteObtenido = "";
                }

                if (hayDatos) {
                    JOptionPane.showMessageDialog(null, "Datos cargados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "La fila está vacía o no contiene datos útiles.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cargar la fila. Verifique el número de fila.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String obtenerValorComoString(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                double valorNumerico = cell.getNumericCellValue();
                return (valorNumerico == (int) valorNumerico) ? String.valueOf((int) valorNumerico) : String.valueOf(valorNumerico);
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }



    //Renombra el MERGED
    public static void renombrarArchivoMerged(String rutaCarpeta, String newFileName) {
        File folder = new File(rutaCarpeta);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("❌ La carpeta especificada no existe o no es un directorio.");
            return;
        }

        // Buscar cualquier archivo que se llame "merged" con cualquier extensión
        File[] archivos = folder.listFiles((dir, name) -> name.toLowerCase().startsWith("merged") && name.toLowerCase().endsWith(".pdf"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("❌ No se encontró ningún archivo 'merged*.pdf' en la carpeta.");
            return;
        }

        File mergedFile = archivos[0]; // Usamos el primero que coincida

        // Asegurar que el nuevo nombre tenga extensión .pdf
        if (!newFileName.toLowerCase().endsWith(".pdf")) {
            newFileName += ".pdf";
        }

        File renamedFile = new File(folder, newFileName);

        if (mergedFile.renameTo(renamedFile)) {
            System.out.println("✅ Archivo renombrado con éxito a: " + renamedFile.getName());
        } else {
            System.out.println("❌ No se pudo renombrar el archivo.");
        }
    }

    //La cantidad de subcarpetas deberian ser iguales a la cantidad de JTextField(EN QUE ORDEN ESTARA?)
    public static void mostrarLlenuraSubcarpetas(String rutaPadre, JTextField[] camposTexto, Color colorVacio, Color colorLleno) {
        File carpetaPadre = new File(rutaPadre);

        // Verifica si la ruta proporcionada es válida y si es una carpeta
        if (!carpetaPadre.exists() || !carpetaPadre.isDirectory()) {
            System.out.println("La ruta proporcionada no es válida.");
            return;
        }

        // Obtiene las subcarpetas de la carpeta principal
        File[] subCarpetas = carpetaPadre.listFiles(File::isDirectory);
        if (subCarpetas == null) {
            return;
        }

        // Lista para almacenar carpetas válidas (con nombre numérico o "seguimiento")
        List<File> carpetasFiltradas = new ArrayList<>();

        // Recorre las subcarpetas y filtra las que empiezan con un número o se llaman "seguimiento"
        for (File subCarpeta : subCarpetas) {
            String nombre = subCarpeta.getName();
            System.out.println("Analizando carpeta: " + nombre);  // DEBUG

            // Verifica si el nombre de la carpeta es numérico o "seguimiento" (ignorando mayúsculas/minúsculas)
            if (nombre.matches("^\\d+.*") || nombre.equalsIgnoreCase("seguimiento")) {
                carpetasFiltradas.add(subCarpeta);
                System.out.println("   -> Aceptada: " + nombre); // DEBUG
            } else {
                System.out.println("   -> Rechazada: " + nombre); // DEBUG
            }
        }

        // Recorre las carpetas filtradas y marca los campos de texto con colores
        for (int i = 0; i < carpetasFiltradas.size() && i < camposTexto.length; i++) {
            File carpeta = carpetasFiltradas.get(i);
            // Verifica si la carpeta contiene archivos o subcarpetas
            File[] archivosYCarpetas = carpeta.listFiles();  // Considera tanto archivos como subcarpetas
            boolean tieneContenido = archivosYCarpetas != null && archivosYCarpetas.length > 0;

            // Establece el color del campo de texto según si la carpeta tiene contenido
            camposTexto[i].setBackground(tieneContenido ? colorLleno : colorVacio);
        }
    }



    //Solo buscar una carpeta,SELLAMA VARIAS VECES
    public static void asignarArchivosEtapas(String rutaPadre, String rutaDestino, String nombreEtapa, JTextField campoDestino) {
        File directorioPadre = new File(rutaPadre);
        if (!directorioPadre.exists() || !directorioPadre.isDirectory()) {
            JOptionPane.showMessageDialog(null, "La ruta padre no es válida o no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser(rutaPadre);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter(
                "Archivos permitidos (PDF, Word, JPG, PNG)", "pdf", "doc", "docx", "jpg", "jpeg", "png"));

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File[] archivosSeleccionados = fileChooser.getSelectedFiles();
        if (archivosSeleccionados.length == 0) {
            JOptionPane.showMessageDialog(null, "No se seleccionaron archivos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Preguntar al usuario si desea copiar o mover los archivos
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

        boolean copiar = (opcion == 1);

        File directorioDestino = new File(rutaDestino);
        if (!directorioDestino.exists() || !directorioDestino.isDirectory()) {
            JOptionPane.showMessageDialog(null, "La ruta destino no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File carpetaDestino = null;
        File[] carpetas = directorioDestino.listFiles(File::isDirectory);

        if (carpetas != null) {
            for (File carpeta : carpetas) {
                String nombreCarpeta = carpeta.getName();
                if (nombreEtapa.equalsIgnoreCase("seguimiento")) {
                    if (nombreCarpeta.equalsIgnoreCase("seguimiento")) {
                        carpetaDestino = carpeta;
                        break;
                    }
                } else {
                    if (nombreCarpeta.startsWith(nombreEtapa)) {
                        carpetaDestino = carpeta;
                        break;
                    }
                }
            }
        }

        if (carpetaDestino == null) {
            JOptionPane.showMessageDialog(null, "No se encontró una carpeta correspondiente a: " + nombreEtapa, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int archivosProcesados = 0;
        for (File archivo : archivosSeleccionados) {
            File archivoDestino = new File(carpetaDestino, archivo.getName());
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

        /*
        // Mostrar solo el nombre de la carpeta destino en el campo de texto
        if (campoDestino != null) {
            campoDestino.setText(carpetaDestino.getName());
        }*/
        // Mostrar solo la cantidad
        if (campoDestino != null) {
            campoDestino.setText(String.valueOf("Se procesaron: " + archivosProcesados + " archivos"));
        }

        JOptionPane.showMessageDialog(null, archivosProcesados + " archivo(s) " + (copiar ? "copiado(s)" : "movido(s)") + " exitosamente a: " + carpetaDestino.getAbsolutePath());
    }



    //
    public static void verificarSeleccion(JCheckBox jcbSeleccionarTodo, JCheckBox checkBox) {
        if (!checkBox.isSelected()) {
            jcbSeleccionarTodo.setSelected(false);
            return; // Si hay al menos uno desmarcado, salimos
        }
        
        jcbSeleccionarTodo.setSelected(true); // Si llegamos aquí, todos están seleccionados
    }
    //Muestraun mensaje el JOptionPane "Archivos renombrados" y en JTextField "Archivos agregados"
    public static void buscarPonerNumeroArchivo(String carpetaInicial, int numero, JTextField textField) {
        // Configurar JFileChooser para que abra la carpeta inicial
        JFileChooser chooser = new JFileChooser(carpetaInicial);
        chooser.setDialogTitle("Seleccione los archivos a renombrar");
        chooser.setMultiSelectionEnabled(true); // Permitir selección múltiple

        // Filtro para mostrar solo archivos con extensiones permitidas
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Archivos permitidos (PDF, DOC, DOCX, JPG, JPEG, PNG)",
                "pdf", "doc", "docx", "jpg", "jpeg", "png");
        chooser.setFileFilter(filtro);

        int resultado = chooser.showOpenDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.println("No se seleccionaron archivos.");
            return;
        }

        // Obtener los archivos seleccionados
        File[] archivosSeleccionados = chooser.getSelectedFiles();
        
        //-------------------------------------------------------
        // Mapa para almacenar múltiples arrays de archivos con un identificador numérico
        documentosMap = new HashMap<>();

        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivosSeleccionados = chooser.getSelectedFiles();
            documentosMap.put(numero, archivosSeleccionados);
            System.out.println("Se han guardado " + archivosSeleccionados.length + " archivos en documentos" + numero);
        }
        
        if (archivosSeleccionados.length == 0) {
            System.out.println("No se seleccionaron archivos.");
            return;
        }
        //-------------------------------------------------------
        
        if (archivosSeleccionados.length == 0) {
            System.out.println("No se seleccionaron archivos.");
            return;
        }

        List<String> rutasRenombradasList = new ArrayList<>();

        // Renombrar archivos seleccionados
        for (File archivo : archivosSeleccionados) {
            try {
                String nuevoNombre = numero + " " + archivo.getName();
                File nuevoArchivo = new File(archivo.getParent(), nuevoNombre);
                Files.move(archivo.toPath(), nuevoArchivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
                rutasRenombradasList.add(nuevoArchivo.getAbsolutePath());
                System.out.println("Archivo renombrado: " + nuevoArchivo.getAbsolutePath());
                textField.setBackground(Color.GREEN);;
            } catch (Exception e) {
                System.out.println("Error al renombrar archivo: " + archivo.getName() + " - " + e.getMessage());
            }
        }

        // Mostrar lista de archivos renombrados en un cuadro de diálogo
        if (!rutasRenombradasList.isEmpty()) {
            StringBuilder mensaje = new StringBuilder("Archivos renombrados:\n");
            for (String ruta : rutasRenombradasList) {
                mensaje.append(ruta).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Renombrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }   
    
    public static void renombrarArchivoConNumero(String rutaArchivo, int numero) {
        
        File archivo = new File(rutaArchivo);

        if (!archivo.exists() || !archivo.isFile()) {
            JOptionPane.showMessageDialog(null, "El archivo no existe o no es válido.\nRuta: " + rutaArchivo,
                                          "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String nombreArchivo = archivo.getName();

            // Elimina cualquier número al inicio del nombre original
            String nombreSinNumero = nombreArchivo.replaceFirst("^\\d+\\s+", "");

            // Construye el nuevo nombre anteponiendo el número
            String nuevoNombre = numero + " " + nombreSinNumero;

            // Crea el nuevo archivo con la nueva ruta y nombre
            File nuevoArchivo = new File(archivo.getParent(), nuevoNombre);

            // Mueve (renombra) el archivo
            Files.move(archivo.toPath(), nuevoArchivo.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Actualiza la fecha de modificación al momento actual
            nuevoArchivo.setLastModified(System.currentTimeMillis());

            // Muestra la ruta completa del archivo renombrado
            System.out.println("Archivo renombrado: " + nuevoArchivo.getAbsolutePath());

            // Incrementa el contador global
            contadorArchivosRenombrados++;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al renombrar archivo:\n" + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    
    //----------------------------------------------------------
    public static void mostrarDocumentosLista(int clave) {
        StringBuilder mensaje = new StringBuilder();

        for (Map.Entry<Integer, File[]> entry : documentosMap.entrySet()) {
            int key = entry.getKey();  // Clave del documento
            File[] archivos = entry.getValue(); // Array de archivos

            mensaje.append("Documentos originales cambiados con el indice ").append(key).append(":\n");
            for (File archivo : archivos) {
                mensaje.append(" - ").append(archivo.getName()).append("\n");
            }
            mensaje.append("\n"); // Espaciado entre grupos de documentos
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Lista de Documentos", JOptionPane.INFORMATION_MESSAGE);
    }

    
    //----------------------------------------------------------------------------
    //Metodo en desarrollo
    public static void buscarConverirAPdfs(String rutaInicial, String nombreArchivoFusion) {
    JFileChooser fileChooser = new JFileChooser(rutaInicial);
    fileChooser.setMultiSelectionEnabled(true);
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF, Word, Imágenes", "pdf", "docx", "doc", "png", "jpeg", "jpg"));

    int resultado = fileChooser.showOpenDialog(null);

    if (resultado == JFileChooser.APPROVE_OPTION) {
        File[] archivosSeleccionados = fileChooser.getSelectedFiles();
        List<Pair<Integer, Object>> listaArchivos = new ArrayList<>();

        Pattern pattern = Pattern.compile("^(\\d+)"); // Capturar números al inicio del nombre

        for (File archivo : archivosSeleccionados) {
            String fileName = archivo.getName().toLowerCase();
            Matcher matcher = pattern.matcher(fileName);
            int num = matcher.find() ? Integer.parseInt(matcher.group(1)) : Integer.MAX_VALUE; // Si no hay número, poner un valor alto

            if (fileName.endsWith(".pdf")) {
                listaArchivos.add(new Pair<>(num, archivo)); // Guardamos número y archivo
            } else if (fileName.endsWith(".docx") || fileName.endsWith(".doc") || fileName.endsWith(".png") || fileName.endsWith(".jpeg") || fileName.endsWith(".jpg")) {
                PDDocument pdfConvertido = convertirA_PDF(archivo);
                if (pdfConvertido != null) {
                    listaArchivos.add(new Pair<>(num, pdfConvertido)); // Guardamos número y documento en memoria
                }
            }
        }

        // Ordenar correctamente según el número extraído del nombre
        listaArchivos.sort(Comparator.comparingInt(Pair::getKey));

        // Fusionar directamente desde listaArchivos sin dividir
        fusionarPDFs(listaArchivos, rutaInicial + "/" + nombreArchivoFusion + ".pdf");
    }
}

    private static PDDocument convertirA_PDF(File archivo) {
    String fileName = archivo.getName().toLowerCase();
    try {
        if (fileName.endsWith(".docx") || fileName.endsWith(".doc")) {
            File outputFile = File.createTempFile("temp_pdf_", ".pdf");
            convertirWordAPDF(archivo, outputFile);
            return PDDocument.load(outputFile);
        } else if (fileName.endsWith(".png") || fileName.endsWith(".jpeg") || fileName.endsWith(".jpg")) {
            return convertirImagenAPDF(archivo);
        }
    } catch (Exception e) {
        System.err.println("Error al convertir " + archivo.getName() + " a PDF: " + e.getMessage());
    }
    return null;
}
    private static void convertirWordAPDF(File inputFile, File outputFile) throws Exception {
        FileInputStream fis = new FileInputStream(inputFile);
        XWPFDocument document = new XWPFDocument(fis);
        Document pdfDocument = new Document();
        PdfWriter.getInstance(pdfDocument, new FileOutputStream(outputFile));

        pdfDocument.open();
        document.getParagraphs().forEach(p -> {
            try {
                pdfDocument.add(new Paragraph(p.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        pdfDocument.close();
        document.close();
        fis.close();
    }
    private static PDDocument convertirImagenAPDF(File inputFile) throws Exception {
    BufferedImage image = ImageIO.read(inputFile);
    PDDocument pdfDocument = new PDDocument();
    PDPage page = new PDPage();
    pdfDocument.addPage(page);

    float pageWidth = page.getMediaBox().getWidth();
    float pageHeight = page.getMediaBox().getHeight();

    float imageWidth = image.getWidth();
    float imageHeight = image.getHeight();

    float scale = Math.min(pageWidth / imageWidth, pageHeight / imageHeight);
    float scaledWidth = imageWidth * scale;
    float scaledHeight = imageHeight * scale;

    float xPosition = (pageWidth - scaledWidth) / 2;
    float yPosition = (pageHeight - scaledHeight) / 2;

    PDImageXObject pdImage = PDImageXObject.createFromFile(inputFile.getAbsolutePath(), pdfDocument);
    PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);

    contentStream.drawImage(pdImage, xPosition, yPosition, scaledWidth, scaledHeight);
    contentStream.close();

    return pdfDocument; // Se devuelve el documento en memoria
}
    private static void fusionarPDFs(List<Pair<Integer, Object>> listaArchivos, String destino) {
    PDFMergerUtility fusionador = new PDFMergerUtility();
    fusionador.setDestinationFileName(destino);

    try {
        for (Pair<Integer, Object> item : listaArchivos) {
            if (item.getValue() instanceof File) {
                fusionador.addSource((File) item.getValue());
            } else {
                PDDocument doc = (PDDocument) item.getValue();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                doc.save(out);
                fusionador.addSource(new ByteArrayInputStream(out.toByteArray()));
                doc.close(); // Cerrar después de agregar
            }
        }

        fusionador.mergeDocuments(null);
        JOptionPane.showMessageDialog(null, "PDFs fusionados correctamente en: " + destino);

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al fusionar PDFs: " + e.getMessage());
    }
}

    
    public static void cargarArchivosEnLista(String rutaCarpeta, JList<String> lista, DefaultListModel<String> modeloNombres, DefaultListModel<String> modeloRutas) {
        File carpeta = new File(rutaCarpeta);

        if (carpeta.isDirectory()) {
            modeloNombres.clear();
            modeloRutas.clear();

            int contadorWord = 1; // Para numerar los archivos Word como 3.1, 3.2, etc.

            // Archivos de la carpeta principal
            File[] archivos = carpeta.listFiles(File::isFile);
            if (archivos != null) {
                Arrays.sort(archivos, (a, b) -> {
                    String regexNumero = "^\\d+(\\.\\d+)?";
                    String nombreA = a.getName();
                    String nombreB = b.getName();

                    double numA = extraerNumeroInicial(nombreA, regexNumero);
                    double numB = extraerNumeroInicial(nombreB, regexNumero);

                    int comparacionNumeros = Double.compare(numA, numB);
                    if (comparacionNumeros != 0) {
                        return comparacionNumeros;
                    }

                    return Long.compare(a.lastModified(), b.lastModified());
            });
            File archivoMasNuevo = null;
            long ultimaModificacion = Long.MIN_VALUE;


            for (File archivo : archivos) {
                String nombreArchivo = archivo.getName();
                String rutaCompleta = archivo.getAbsolutePath();

                // Obtener extensión
                String extension = "";
                int i = nombreArchivo.lastIndexOf('.');
                if (i > 0) {
                    extension = nombreArchivo.substring(i + 1).toLowerCase();
                }

                if (extension.equals("doc") || extension.equals("docx")) {
                    String nombreConNumero = "3." + contadorWord + " " + nombreArchivo;
                    modeloNombres.addElement(nombreConNumero);
                    contadorWord++;
                } else {
                    modeloNombres.addElement(nombreArchivo);
                }

                modeloRutas.addElement(rutaCompleta);
                System.out.println("Archivo cargado: " + rutaCompleta);
                if (archivo.lastModified() > ultimaModificacion) {
                    ultimaModificacion = archivo.lastModified();
                    archivoMasNuevo = archivo;
                }
            }
            if (archivoMasNuevo != null) {
                System.out.println("📌 Archivo más reciente: " + archivoMasNuevo.getName() +
                                   " (Modificado: " + new java.util.Date(archivoMasNuevo.lastModified()) + ")");
            }
        }


            // Procesar subcarpetas
            File[] subcarpetas = carpeta.listFiles(File::isDirectory);
            for (File subcarpeta : subcarpetas) {
                if (subcarpeta.getName().equalsIgnoreCase("seguimiento")) {
                    int[] contadorSeguimiento = {1}; // Para numerar tipo 6.1, 6.2, etc.
                    procesarCarpetaSeguimiento(subcarpeta, modeloNombres, modeloRutas, "6", contadorSeguimiento);
                } else {
                    contadorWord = procesarCarpetaNormal(subcarpeta, modeloNombres, modeloRutas, contadorWord);
                }
            }

            lista.setModel(modeloNombres);
            aplicarColorALista(lista); // Si ya usás este método para estilizar
        } else {
            JOptionPane.showMessageDialog(null, "La ruta no es válida.");
        }
    }

    //Metodo auxiliar del metodo cargararchivoslista() de arriba
    private static double extraerNumeroInicial(String nombre, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);
        if (matcher.find()) {
            try {
                return Double.parseDouble(matcher.group());
            } catch (NumberFormatException e) {
                return Double.MAX_VALUE;
            }
        }
        return Double.MAX_VALUE;
    }
    
    //Buscar rd para mostrar en JTextField del consolidado "notificacion"
    public static void buscarArchivoConRD(String rutaCarpeta, JTextField campoTexto) {
        File carpeta = new File(rutaCarpeta);

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles(File::isFile);
            if (archivos != null) {
                for (File archivo : archivos) {
                    String nombre = archivo.getName();
                    String nombreSinExtension = nombre.contains(".") 
                        ? nombre.substring(0, nombre.lastIndexOf('.')) 
                        : nombre;

                    // Tomar solo los primeros 5 caracteres
                    String primeros5 = nombreSinExtension.length() >= 5 
                        ? nombreSinExtension.substring(0, 5) 
                        : nombreSinExtension;

                    if (primeros5.toUpperCase().contains("RD")) {
                        campoTexto.setText(nombre); // Muestra el nombre en el JTextField
                        System.out.println("Archivo encontrado: " + nombre);
                        return;
                    }
                }
            }
        }

        campoTexto.setText("No se encontró archivo con 'RD' en las primeras 5 letras");
        System.out.println("No se encontró archivo con 'RD' en las primeras 5 letras.");
    }


    private static int procesarCarpetaNormal(File carpeta, DefaultListModel<String> modeloNombres, DefaultListModel<String> modeloRutas, int contadorWord) {
        File[] archivosYCarpetas = carpeta.listFiles();
        if (archivosYCarpetas != null) {
            for (File archivo : archivosYCarpetas) {
                if (archivo.isFile()) {
                    String nombreArchivo = archivo.getName();
                    String rutaCompleta = archivo.getAbsolutePath();

                    // Obtener extensión
                    String extension = "";
                    int i = nombreArchivo.lastIndexOf('.');
                    if (i > 0) {
                        extension = nombreArchivo.substring(i + 1).toLowerCase();
                    }

                    if (extension.equals("doc") || extension.equals("docx")) {
                        String nombreConNumero = "3." + contadorWord + " " + nombreArchivo;
                        modeloNombres.addElement(nombreConNumero);
                        contadorWord++;
                    } else {
                        modeloNombres.addElement(nombreArchivo);
                    }

                    modeloRutas.addElement(rutaCompleta);
                    System.out.println("Archivo cargado: " + rutaCompleta);
                } else if (archivo.isDirectory()) {
                    // Recursivo si hay más subcarpetas
                    contadorWord = procesarCarpetaNormal(archivo, modeloNombres, modeloRutas, contadorWord);
                }
            }
        }
        return contadorWord;
    }

    private static void procesarCarpetaSeguimiento(File carpeta, DefaultListModel<String> modeloNombres, DefaultListModel<String> modeloRutas, String prefijo, int[] contador) {
        File[] archivosYCarpetas = carpeta.listFiles();
        if (archivosYCarpetas != null) {
            for (File archivo : archivosYCarpetas) {
                if (archivo.isFile()) {
                    String nombreMostrado = prefijo + "." + contador[0] + " - " + archivo.getName();
                    modeloNombres.addElement(nombreMostrado);
                    modeloRutas.addElement(archivo.getAbsolutePath());
                    contador[0]++;
                } else if (archivo.isDirectory()) {
                    procesarCarpetaSeguimiento(archivo, modeloNombres, modeloRutas, prefijo, contador);
                }
            }
        }
    }

    
    private static void agregarArchivo(File archivo, DefaultListModel<String> modeloNombres, DefaultListModel<String> modeloRutas, int[] contadorWord, boolean ignorar) {
        String nombreArchivo = archivo.getName();
        String rutaCompleta = archivo.getAbsolutePath();

        String extension = "";
        int i = nombreArchivo.lastIndexOf('.');
        if (i > 0) {
            extension = nombreArchivo.substring(i + 1).toLowerCase();
        }

        if (extension.equals("doc") || extension.equals("docx")) {
            String nombreConNumero = "3." + contadorWord[0] + " " + nombreArchivo;
            modeloNombres.addElement(nombreConNumero);
            contadorWord[0]++;
        } else {
            modeloNombres.addElement(nombreArchivo);
        }

        modeloRutas.addElement(rutaCompleta);
        System.out.println("Archivo cargado: " + rutaCompleta);
    }


    private static void procesarCarpetaRecursiva(File carpeta, DefaultListModel<String> modeloNombres, DefaultListModel<String> modeloRutas, String prefijo, int[] contador) {
        File[] archivosYCarpetas = carpeta.listFiles();
        if (archivosYCarpetas != null) {
            for (File archivo : archivosYCarpetas) {
                if (archivo.isFile()) {
                    String nombreMostrado = prefijo + "." + contador[0] + " - " + archivo.getName();
                    modeloNombres.addElement(nombreMostrado);
                    modeloRutas.addElement(archivo.getAbsolutePath());
                    contador[0]++;
                } else if (archivo.isDirectory()) {
                    procesarCarpetaRecursiva(archivo, modeloNombres, modeloRutas, prefijo, contador);
                }
            }
        }
    }


    public static void cargarArchivosEnListaSinColor(String rutaCarpeta, JList<String> lista) {
    File carpeta = new File(rutaCarpeta);
    if (carpeta.isDirectory()) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (File archivo : carpeta.listFiles()) {
            if (archivo.isFile()) {
                modelo.addElement(archivo.getName());
            }
        }
        lista.setModel(modelo);

        // Asegurarse de que no haya un renderer personalizado
        lista.setCellRenderer(new DefaultListCellRenderer());

    } else {
        JOptionPane.showMessageDialog(null, "La ruta no es válida.");
    }
}
    
    public static void aplicarColorALista(JList<String> lista) {
        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {

                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                String nombreArchivo = value.toString();

                if (nombreArchivo.matches("^\\d.*")) {
                    label.setBackground(Color.GREEN);
                } else {
                    label.setBackground(Color.RED);
                }

                label.setForeground(Color.BLACK);

                if (isSelected) {
                    label.setBackground(label.getBackground().darker());
                    label.setForeground(Color.WHITE);
                }

                return label;
            }
        });
    }


    public static void reaccionSeleccion(String nombreArchivo, String rutaCarpeta, JComboBox<String> comboBox) {
        rutaArchivoSeleccionado = rutaCarpeta + File.separator + nombreArchivo;
        String nombre = nombreArchivo.toLowerCase();

        if (nombre.contains("reporte") || 
            nombre.contains("asignación") || 
            nombre.contains("caso") || 
            nombre.contains("inicial") ||
            nombre.contains("antecedentes")) {
            comboBox.setSelectedItem("1");
        } 
        else if (nombre.contains("ficha de campo") || 
                 nombre.contains("evaluación") || 
                 nombre.contains("multidisciplinario") || 
                 nombre.contains("informe técnico") || 
                 nombre.contains("test") || 
                 nombre.contains("actas") || 
                 nombre.contains("reniec") || 
                 nombre.contains("identificación")) {
            comboBox.setSelectedItem("2");
        }
        else if (nombre.contains("medida de protección") || 
                 nombre.contains("resolución directoral") || 
                 nombre.contains("informe legal") || 
                 nombre.contains("oficio") || 
                 nombre.contains("notificación") || 
                 nombre.contains("temporal") || 
                nombre.contains("rd") || 
                nombre.contains("RD") || 
                 nombre.contains("protección temporal")) {
            comboBox.setSelectedItem("3");
        }
        else if (nombre.contains("archivo provisional") || 
                 nombre.contains("archivo definitivo") || 
                 nombre.contains("cierre") || 
                 nombre.contains("finalización") || 
                 nombre.contains("informe de archivo")) {
            comboBox.setSelectedItem("4");
        }
        else if (nombre.contains("reconsideración") || 
                 nombre.contains("apelación") || 
                 nombre.contains("impugnación") || 
                 nombre.contains("respuesta")) {
            comboBox.setSelectedItem("5");
        }
        else if (nombre.contains("seguimiento") || 
                 nombre.contains("fase de seguimiento") || 
                 nombre.contains("reiterativo") || 
                 nombre.contains("implementación") || 
                 nombre.contains("variación") || 
                 nombre.contains("cese de medidas")) {
            comboBox.setSelectedItem("6");
        }
        else if (nombre.contains("otros documentos") || 
                 nombre.contains("complementario") || 
                 nombre.contains("diversos") || 
                 nombre.contains("adicional")) {
            comboBox.setSelectedItem("7");
        }
        else if (nombre.contains("expediente consolidado") || 
                 nombre.contains("consolidación") || 
                 nombre.contains("finalización") || 
                nombre.contains("EXPEDIENTE") || 
                nombre.contains("expediente") || 
                nombre.contains("exp") || 
                nombre.contains("EXP") || 
                 nombre.contains("expediente completo")) {
            comboBox.setSelectedItem("8");
        }
        else {
            comboBox.setSelectedItem(null); // O podrías usar "No identificado" si tenés ese ítem en el combo
        }
    }

    
    public static void renombrarArchivoSinNumeros(String rutaArchivo) {
        File archivo = new File(rutaArchivo);

        // Verificamos si el archivo existe
        if (!archivo.exists() || !archivo.isFile()) {
            JOptionPane.showMessageDialog(null, "El archivo no existe o no es válido.\nRuta: " + rutaArchivo,
                                          "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Extraemos el nombre del archivo
        String nombreArchivo = archivo.getName();

        // Mostramos el nombre original para depuración
        System.out.println("Nombre original: " + nombreArchivo);

        // Modificamos la expresión regular para eliminar los espacios, números, guiones y puntos hasta la primera letra
        // Ahora eliminamos todos los espacios al inicio
        String nuevoNombre = nombreArchivo.replaceAll("^\\s*[\\d\\-\\.]+", "");  // Eliminar espacios + números, guiones y puntos al inicio

        // Eliminamos también cualquier espacio al inicio que quede
        nuevoNombre = nuevoNombre.replaceAll("^\\s+", "");  // Eliminar cualquier espacio restante al inicio

        // Mostramos el nuevo nombre para depuración
        System.out.println("Nuevo nombre después de la expresión regular: " + nuevoNombre);

        // Si el nombre no cambió, significa que no había nada para eliminar
        if (nombreArchivo.equals(nuevoNombre)) {
            JOptionPane.showMessageDialog(null, "El nombre del archivo ya está correcto, no se realizó ningún cambio.");
            return;
        }

        // Renombramos el archivo
        File nuevoArchivo = new File(archivo.getParent(), nuevoNombre);

        // Verificamos si el archivo con el nuevo nombre ya existe
        if (nuevoArchivo.exists()) {
            JOptionPane.showMessageDialog(null, "El archivo con el nuevo nombre ya existe.");
            return;
        }

        // Intentamos renombrar el archivo
        if (archivo.renameTo(nuevoArchivo)) {
            System.out.println("Archivo renombrado correctamente a: " + nuevoNombre);
        } else {
            JOptionPane.showMessageDialog(null, "Error al renombrar el archivo.");
        }
    }


    
    public static void cargarArchivosFiltradosPorTexto(String rutaCarpeta, String palabraClave, JList<String> lista) {
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.isDirectory()) {
            JOptionPane.showMessageDialog(null, "La ruta no es válida.");
            return;
        }

        DefaultListModel<String> modelo = new DefaultListModel<>();

        for (File archivo : carpeta.listFiles()) {
            if (archivo.isFile()) {
                String nombreArchivo = archivo.getName().toLowerCase();

                try {
                    if (nombreArchivo.endsWith(".pdf")) {
                        if (contieneTextoPDF(archivo, palabraClave)) {
                            modelo.addElement(archivo.getName());
                        }
                    }

                    // Si deseas agregar soporte para Word (.docx), avísame y lo añadimos con Apache POI

                } catch (IOException e) {
                    System.err.println("Error al leer archivo: " + archivo.getName());
                    e.printStackTrace();
                }
            }
        }

        lista.setModel(modelo);
        lista.setCellRenderer(new DefaultListCellRenderer());
    }
    
    public static void cargarArchivosFiltradosPorTextoConPantallaCarga(String rutaCarpeta, String palabraClave, JList<String> lista, JFrame parentFrame) {
        // Crear un JDialog sencillo como pantalla de carga
        JDialog loadingDialog = new JDialog(parentFrame, "Cargando...", true);
        JLabel label = new JLabel("Buscando archivos, por favor espera...");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        loadingDialog.add(label);
        loadingDialog.setSize(300, 100);
        loadingDialog.setLocationRelativeTo(parentFrame);

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                DefaultListModel<String> modelo = new DefaultListModel<>();
                File carpeta = new File(rutaCarpeta);
                if (carpeta.isDirectory()) {
                    for (File archivo : carpeta.listFiles()) {
                        if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".pdf")) {
                            try {
                                if (contieneTextoPDF(archivo, palabraClave)) {
                                    modelo.addElement(archivo.getName());
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                // Actualizamos el JList fuera del hilo de fondo
                SwingUtilities.invokeLater(() -> {
                    lista.setModel(modelo);
                    lista.setCellRenderer(new DefaultListCellRenderer());
                });
                return null;
            }

            @Override
            protected void done() {
                loadingDialog.dispose(); // Cierra la pantalla de carga
            }
        };

        worker.execute();
        loadingDialog.setVisible(true); // Muestra el diálogo (bloquea hasta que se llame dispose)
    }
    /*String ruta = ManejadorArchivos.getRutaCarpeta();
    String palabraClave = jTextFieldBusqueda.getText();
    ManejadorArchivos.cargarArchivosConPantallaCarga(ruta, palabraClave, jList1, this); // 'this' es el JFrame
    */
    //NO SE ESTA USANDO
    private static boolean contieneTextoPDF(File archivo, String textoBuscado) throws IOException {
        try (PDDocument documento = PDDocument.load(archivo)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String contenido = stripper.getText(documento);
            return contenido.toLowerCase().contains(textoBuscado.toLowerCase());
        }
    }
    
    public static void moverRuta(int indexDesde, int indexHasta) {
        if (indexDesde >= 0 && indexHasta >= 0 && indexDesde < rutasArchivosSeleccionados.size() && indexHasta < rutasArchivosSeleccionados.size()) {
            String temp = rutasArchivosSeleccionados.remove(indexDesde);
            rutasArchivosSeleccionados.add(indexHasta, temp);
        }
    }
    
    //TAMPOCO SE ESTA USANDO
    public static void crearArchivoUnido(String rutaSalida) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSalida))) {
            for (String ruta : rutasArchivosSeleccionados) {
                List<String> lineas = Files.readAllLines(Paths.get(ruta));
                for (String linea : lineas) {
                    writer.write(linea);
                    writer.newLine();
                }
            }
        }
    }
    
    

    public static void unirPDFs(String nombreArchivo, File carpetaDestino) throws IOException {
        if (nombreArchivo == null || nombreArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del archivo no puede estar vacío.");
        }

        if (rutasArchivosSeleccionados.isEmpty()) {
            throw new IllegalStateException("No hay archivos seleccionados para combinar.");
        }

        PDFMergerUtility merger = new PDFMergerUtility();
        File tempFolder = new File(carpetaDestino, "temp_img_pdfs");

        if (!tempFolder.exists()) {
            tempFolder.mkdirs();
        }

        List<File> archivosTemporales = new ArrayList<>();

        for (String ruta : rutasArchivosSeleccionados) {
            File archivo = new File(ruta);
            String nombre = archivo.getName().toLowerCase();

            if (!archivo.exists()) continue;

            if (nombre.endsWith(".pdf")) {
                // 🔍 Validar si el PDF es válido antes de agregarlo
                try (PDDocument doc = PDDocument.load(archivo)) {
                    merger.addSource(archivo);
                } catch (IOException e) {
                    System.err.println("Archivo PDF inválido: " + archivo.getName() + " — " + e.getMessage());
                    throw new IOException("Archivo PDF inválido: " + archivo.getName() + " — " + e.getMessage(), e);
                }
            } else if (nombre.matches(".*\\.(jpg|jpeg|png|bmp|gif)$")) {
                PDDocument doc = new PDDocument();
                PDPage page = new PDPage();
                doc.addPage(page);

                PDImageXObject pdImage = PDImageXObject.createFromFileByContent(archivo, doc);
                PDPageContentStream contentStream = new PDPageContentStream(doc, page);
                contentStream.drawImage(pdImage, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
                contentStream.close();

                File tempPDF = new File(tempFolder, archivo.getName() + ".pdf");
                doc.save(tempPDF);
                doc.close();

                merger.addSource(tempPDF);
                archivosTemporales.add(tempPDF);
            } else {
                System.out.println("Ignorado: " + nombre);
            }
        }

        if (!nombreArchivo.toLowerCase().endsWith(".pdf")) {
            nombreArchivo += ".pdf";
        }

        File archivoFinal = new File(carpetaDestino, nombreArchivo);
        merger.setDestinationFileName(archivoFinal.getAbsolutePath());
        merger.mergeDocuments(null);

        for (File f : archivosTemporales) {
            f.delete();
        }
        tempFolder.delete();
    }


    public static void eliminarRuta(int index) {
        if (index >= 0 && index < rutasArchivosSeleccionados.size()) {
            rutasArchivosSeleccionados.remove(index);
        }
    }
        public static void eliminarTodasLasRutas() {
        rutasArchivosSeleccionados.clear();
    }
    
    public static void eliminarPrefijosNumericos(String rutaBase) {
        File carpetaBase = new File(rutaBase);

        if (!carpetaBase.exists() || !carpetaBase.isDirectory()) {
            System.out.println("La carpeta especificada no existe o no es un directorio.");
            return;
        }

        Pattern pattern = Pattern.compile("^\\d+[-_]*");
        boolean[] cambiosRealizados = {false}; // para poder modificar dentro de la recursión

        // Recorrido recursivo de carpetas
        LinkedList<File> carpetasPorProcesar = new LinkedList<>();
        carpetasPorProcesar.add(carpetaBase);

        while (!carpetasPorProcesar.isEmpty()) {
            File carpetaActual = carpetasPorProcesar.removeFirst();

            // Procesar archivos
            File[] archivos = carpetaActual.listFiles(File::isFile);
            if (archivos != null) {
                for (File archivo : archivos) {
                    String nombreArchivoOriginal = archivo.getName();
                    Matcher archivoMatcher = pattern.matcher(nombreArchivoOriginal);

                    if (archivoMatcher.find()) {
                        String nuevoNombreArchivo = nombreArchivoOriginal.replaceFirst("^\\d+[-_]*", "");
                        File archivoRenombrado = new File(carpetaActual, nuevoNombreArchivo);

                        if (archivo.renameTo(archivoRenombrado)) {
                            System.out.println("Renombrado archivo: " + nombreArchivoOriginal + " → " + nuevoNombreArchivo);
                            cambiosRealizados[0] = true;
                        } else {
                            System.out.println("Error renombrando el archivo: " + nombreArchivoOriginal);
                        }
                    }
                }
            }

            // Agregar subcarpetas para procesar después
            File[] subcarpetas = carpetaActual.listFiles(File::isDirectory);
            if (subcarpetas != null) {
                carpetasPorProcesar.addAll(Arrays.asList(subcarpetas));
            }
        }

        if (cambiosRealizados[0]) {
            JOptionPane.showMessageDialog(null, "La operación de renombrado de archivos se ha completado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se realizaron cambios, ya que no se encontraron archivos con los prefijos especificados.");
        }
    }



    //ES reemplazado por el de abajo
    public static void contarYActualizarTiposDeArchivos(
        DefaultListModel<String> modeloLista1Rutas, 
        DefaultListModel<String> modeloLista1Nombres, 
        JTextField textFieldPDF, 
        JTextField textFieldDOC, 
        JTextField textFieldImagenes) {

        int contadorPDF = 0;
        int contadorDOC = 0;
        int contadorImagenes = 0;

        // Recorremos todos los archivos seleccionados en el JList1
        for (int i = 0; i < modeloLista1Rutas.size(); i++) {
            String ruta = modeloLista1Rutas.get(i); // Obtenemos la ruta de cada archivo
            String extension = obtenerExtensionArchivo(ruta);  // Obtenemos la extensión del archivo

            // Comprobamos la extensión y contamos los archivos
            switch (extension.toLowerCase()) {
                case "pdf":
                    contadorPDF++;
                    break;
                case "doc":
                case "docx":
                    contadorDOC++;
                    break;
                case "jpg":
                case "jpeg":
                case "png":
                case "bmp":
                case "gif":
                    contadorImagenes++;
                    break;
                // Puedes agregar más extensiones si lo necesitas
            }
        }

        // Actualizamos los JTextFields con los contadores correspondientes
        textFieldPDF.setText(""+contadorPDF);
        textFieldDOC.setText(""+contadorDOC);
        textFieldImagenes.setText(""+contadorImagenes);
    }
    //Cambiado por este
    public static void insertarOrdenadoPorNumero(DefaultListModel<String> modeloNombres,
                                                 DefaultListModel<String> modeloRutas,
                                                 String nombre, String ruta) {
        double nuevoNumero = extraerNumeroInicial(nombre);

        int i = 0;
        while (i < modeloNombres.size()) {
            double numeroActual = extraerNumeroInicial(modeloNombres.get(i));
            if (nuevoNumero < numeroActual) {
                break;
            }
            i++;
        }

        modeloNombres.add(i, nombre);
        modeloRutas.add(i, ruta);
    }

    private static double extraerNumeroInicial(String nombreArchivo) {
        try {
            String primeraParte = nombreArchivo.split("[ _]", 2)[0];
            return Double.parseDouble(primeraParte);
        } catch (Exception e) {
            return 9999.0; // Si no tiene número, va al final
        }
    }

    
    public static String obtenerExtensionArchivo(String ruta) {
        File archivo = new File(ruta);
        String nombre = archivo.getName();
        int punto = nombre.lastIndexOf(".");
        if (punto > 0 && punto < nombre.length() - 1) {
            return nombre.substring(punto + 1);
        } else {
            return "";
        }
    }
    // Guarda la ruta en un archivo
    public static void guardarRuta(String ruta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getRutaArchivoConfig()))) {
            writer.write(ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar la ruta: " + e.getMessage());
        }
    }

    // Carga la ruta desde el archivo (si existe)
    public static String cargarRuta() {
        File archivo = new File(getRutaArchivoConfig());
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                return reader.readLine(); // Leer solo la primera línea
            } catch (IOException e) {
                System.out.println("Error al leer la ruta: " + e.getMessage());
            }
        }
        return null;
    }

    // Devuelve la ruta completa del archivo config.txt junto al .jar
    private static String getRutaArchivoConfig() {
        // Carpeta donde se ejecuta el .jar
        String rutaEjecutable = System.getProperty("user.dir");
        return rutaEjecutable + File.separator + ARCHIVO_CONFIG;
    }


}