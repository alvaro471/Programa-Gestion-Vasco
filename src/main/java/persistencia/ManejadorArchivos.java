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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Comparator;
import javax.imageio.ImageIO;
import org.apache.commons.math3.util.Pair;

public class ManejadorArchivos {
    private static String rutaCarpeta;
    private static String rutaCarpetaExcel;
    private static int ultimaFila;
    private static String ultimaRuta = ".";
    private static int filaIngresada;
    private static String rutaCarpetaPrincipal = "C:\\Users";
    private static String nombreCarpetaObtenido = "";
    private static String nombreExpedienteObtenido = "";
    private static String condicionFila = "vacio";
    public static String[] rutasRenombradas;
    private static List<File> pdfFiles = new ArrayList<>(); // Lista estática para almacenar los PDFs
    
    public static String getRutaCarpetaExcel(){
        return rutaCarpetaExcel;
    }
    public static String getRutaCarpeta(){
        return rutaCarpeta;
    }
    public static int getUltimaFila(){
        return ultimaFila;
    }
    public static int getFilaIngresada(){
        return filaIngresada;
    }
    public static String getRutaCarpetaPrincipal(){
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

    
    
    
    //Selecciona, Guarda la direccion en rutaCarpeta
    public static void seleccionarCarpeta(JTextField txtRuta) {
        JFileChooser chooser = new JFileChooser(rutaCarpetaPrincipal); // Siempre usa rutaCarpetaPrincipal
        chooser.setDialogTitle("Selecciona una carpeta");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        int seleccion = chooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = chooser.getSelectedFile();
            rutaCarpeta = carpetaSeleccionada.getAbsolutePath(); // Guarda la nueva ruta seleccionada
            txtRuta.setText(rutaCarpeta); // Muestra la ruta en el JTextField
        }
    }
    //Selecciona, Guarda la direccion del Excel en rutaCarpetaExcel, muestra estado
    public static void seleccionarExcel(int filaSeleccionada, JTextField estadoTextField) {
        JFileChooser fileChooser = new JFileChooser(rutaCarpetaPrincipal); // Siempre usa rutaCarpetaPrincipal
        fileChooser.setDialogTitle("Seleccionar archivo Excel");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Agregar filtro para archivos Excel
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Excel (*.xls, *.xlsx)", "xls", "xlsx");
        fileChooser.setFileFilter(filtro);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            rutaCarpetaExcel = archivoSeleccionado.getAbsolutePath(); // Guarda la ruta seleccionada

            // Leer y analizar el archivo Excel
            try (FileInputStream fis = new FileInputStream(archivoSeleccionado);
                 Workbook workbook = rutaCarpetaExcel.endsWith(".xlsx") ? new XSSFWorkbook(fis) : new HSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheetAt(0); // Obtener la primera hoja


                Row row = sheet.getRow(filaSeleccionada);

                int celdasLlenas = 0;
                
                for (int j = 0; j < 12; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null && cell.getCellType() != CellType.BLANK) {
                        celdasLlenas++;
                    }
                }

                if (celdasLlenas == 0) {
                    estadoTextField.setText("La fila esta completamente vacia: " + filaSeleccionada);
                    return;
                } else if (celdasLlenas < 12) {
                    estadoTextField.setText("Fila parcialmente llena: " + filaSeleccionada);
                    return;
                }
                

                estadoTextField.setText("Cambie de fila, todas llenas");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //Crea la carpeta y subcarpetas
    public static void crearCarpetaConSubcarpetas(String rutaBase, String nombreCarpeta, String[] subcarpetas) {
        // Crear la carpeta principal
        File carpetaPrincipal = new File(rutaBase, nombreCarpeta);

        if (!carpetaPrincipal.exists()) {
            if (carpetaPrincipal.mkdirs()) {
                System.out.println("Carpeta creada: " + carpetaPrincipal.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear la carpeta", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Crear subcarpetas dentro de la carpeta principal
        for (String nombreSubcarpeta : subcarpetas) {
            File subcarpeta = new File(carpetaPrincipal, nombreSubcarpeta);
            if (!subcarpeta.exists()) {
                if (subcarpeta.mkdir()) {
                    System.out.println("Subcarpeta creada: " + subcarpeta.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear la subcarpeta: " + nombreSubcarpeta);
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Estructura de carpetas creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    //Crea las subcarpetas y la vez ordena los archivos
    public static void procesarCarpeta(String rutaBase, String variable) {
        File carpetaBase = new File(rutaBase);

        // Validar que la carpeta existe
        if (!carpetaBase.exists()) {
            System.out.println("La carpeta especificada no existe.");
            return;
        }
        if(!carpetaBase.isDirectory()){
            System.out.println("No ha seleccionado una carpeta");
            return;
        }

        // Crear subcarpetas
        String[] nombresSubcarpetas = {
            "1_REC_" + variable,
            "2_ID_" + variable,
            "3_EMI_" + variable,
            "4_ARC_" + variable,
            "5_APE_" + variable,
            "6_SEG_" + variable,
            "7_AGR_" + variable,
            "8_CON_" + variable
        };

        for (String nombre : nombresSubcarpetas) {
            File subcarpeta = new File(rutaBase, nombre);
            if (!subcarpeta.exists()) {
                if (subcarpeta.mkdir()) {
                    System.out.println("Se creo la subcarpeta: " + nombre);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear la subcarpeta: " + subcarpeta.getAbsolutePath());
                }
            }
        }

        // Ordenar archivos PDF y Word
        File[] archivos = carpetaBase.listFiles((dir, name) -> name.matches("(?i)^\\d+.*\\.(pdf|docx|doc|jpg|jpeg|png)$"));

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
                    File carpetaDestino = new File(rutaBase, nombreSubcarpeta);
                    Path archivoPath = archivo.toPath();
                    Path destino = carpetaDestino.toPath().resolve(archivo.getName());

                    try {
                        Files.move(archivoPath, destino, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Movido: " + nombreArchivo + " hacia " + carpetaDestino.getName());
                        break; // Dejar de buscar una vez que se encuentra la carpeta
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error moviendo " + nombreArchivo + ": " + e.getMessage());
                    }
                }
            }
        }
    }
    //Renombra la carpeta seleccionada en rutaCarpeta
    public static boolean renombrarCarpeta(String currentPath, String newName) {
        File folder = new File(currentPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("La carpeta no existe o no es un directorio.");
            return false;
        }

        File newFolder = new File(folder.getParent(), newName);
        if (folder.renameTo(newFolder)) {
            JOptionPane.showMessageDialog(null, "Carpeta renombrada con exito");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al renombrar la carpeta.");
            return false;
        }
    }
    //Mueve todos los tipos de archivo y los reemplaza si existen
    public static void moverArchivosCoincidentes(String rutaBase) {
        File carpetaBase = new File(rutaBase);

        // Validar que la carpeta base existe y es un directorio
        if (!carpetaBase.exists() || !carpetaBase.isDirectory()) {
            JOptionPane.showMessageDialog(null, "La carpeta especificada no existe o no es un directorio.");
            return;
        }

        // Obtener todas las subcarpetas
        File[] subcarpetas = carpetaBase.listFiles(File::isDirectory);

        if (subcarpetas == null || subcarpetas.length == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron subcarpetas.");
            return;
        }

        // Obtener todos los archivos PDF y Word que comienzan con un número
        File[] archivos = carpetaBase.listFiles((dir, name) -> name.matches("(?i)^\\d+.*\\.(pdf|docx|doc|jpg|jpeg|png)$"));

        if (archivos == null || archivos.length == 0) {
            JOptionPane.showMessageDialog(null,"No se encontraron archivos PDF o Word con número inicial.");
            return;
        }

        // Procesar archivos
        for (File archivo : archivos) {
            String nombreArchivo = archivo.getName();
            String numeroInicial = nombreArchivo.replaceAll("^([0-9]+).*", "$1");

            // Buscar una subcarpeta que comience con el mismo número
            for (File subcarpeta : subcarpetas) {
                if (subcarpeta.getName().startsWith(numeroInicial + "_")) {
                    Path origen = archivo.toPath();
                    Path destino = subcarpeta.toPath().resolve(archivo.getName());

                    try {
                        Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Movido: " + nombreArchivo + " → " + subcarpeta.getName());
                        break; // Una vez que se mueve, no hay que seguir buscando
                    } catch (Exception e) {
                        System.out.println("Error moviendo " + nombreArchivo + ": " + e.getMessage());
                    }
                    
                }
            }
        }
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
    public static void agregarFilaExcel(String rutaArchivo, String[] valores, int numeroFila, JTextField estadoField) {
        if (valores.length != 12) {
            throw new IllegalArgumentException("Se requieren exactamente 12 valores.");
        }

        File archivo = new File(rutaArchivo);
        Workbook workbook = null;
        FileInputStream fileInputStream = null;

        try {
            // Verificar si el archivo existe
            if (archivo.exists()) {
                fileInputStream = new FileInputStream(archivo);
                workbook = new XSSFWorkbook(fileInputStream);
            } else {
                // Si no existe, crear un nuevo workbook
                workbook = new XSSFWorkbook();
            }

            Sheet hoja = workbook.getSheetAt(0); // Primera hoja del archivo
            if (hoja == null) {
                hoja = workbook.createSheet("Hoja1"); //LLogico porque workbook es NUEVO
            }

            Row fila = hoja.getRow(numeroFila);
            if (fila == null) {
                fila = hoja.createRow(numeroFila); 
            }

            
            // Contar celdas llenas en la fila
            int celdasLlenas = 0;
            for (int i = 0; i < 12; i++) {
                Cell celda = fila.getCell(i);
                if (celda != null && celda.getCellType() != CellType.BLANK) {
                    celdasLlenas++;
                }
            }

            if (celdasLlenas < 12) {
                // Escribir los valores en la fila
                for (int i = 0; i < valores.length; i++) {
                    Cell celda = fila.getCell(i);
                    if (celda == null) {
                        celda = fila.createCell(i);
                    }
                    celda.setCellValue(valores[i]);
                }

                // Escribir los cambios en el archivo
                FileOutputStream fileOutputStream = new FileOutputStream(archivo);
                workbook.write(fileOutputStream);

                // Cerrar recursos
                fileOutputStream.close();
                estadoField.setText("Fila ingresada");
                JOptionPane.showMessageDialog(null, "Fila añadida correctamente en " + rutaArchivo);
                filaIngresada = numeroFila;

            } else {
                estadoField.setText("Fila llena");
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
    public static void seleccionarCarpetaPrincipal(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Solo carpetas
        fileChooser.setDialogTitle("Selecciona una carpeta");

        int seleccion = fileChooser.showOpenDialog(null); // Abre la ventana

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = fileChooser.getSelectedFile();
            rutaCarpetaPrincipal = carpetaSeleccionada.getAbsolutePath(); // Guarda la ruta en la variable
        } else {
            rutaCarpetaPrincipal = null; // Si el usuario cancela, asignamos null
        }
    }
    //Completa el array de JComponent con elementos en orden de la linea excel
    public static void autocompletarPorFilaExcel(String rutaArchivo, int numeroFila, JComponent[] campos) {
        try (FileInputStream file = new FileInputStream(new File(rutaArchivo));
            Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(numeroFila - 1);

            if (row != null) {
                int totalCeldas = row.getLastCellNum();
                int numCampos = campos.length;

                for (int i = 0; i < numCampos && i < totalCeldas; i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String valor = "";

                    // Obtener el valor de la celda
                    switch (cell.getCellType()) {
                        case STRING:
                            valor = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            double valorNumerico = cell.getNumericCellValue();
                            if (valorNumerico == (int) valorNumerico) { 
                                valor = String.valueOf((int) valorNumerico); // Elimina el .0
                            } else {
                                valor = String.valueOf(valorNumerico);
                            }
                            break;
                        case BOOLEAN:
                            valor = String.valueOf(cell.getBooleanCellValue());
                            break;
                        default:
                            valor = "";
                            break;
                    }

                    // Asignar valor al componente correspondiente
                    if (campos[i] instanceof JTextField) {
                        ((JTextField) campos[i]).setText(valor);
                    } else if (campos[i] instanceof JComboBox) {
                        ((JComboBox<String>) campos[i]).setSelectedItem(valor);
                    }
                }

                // Extraer valores para las variables de la clase
                if (totalCeldas >= numCampos + 1) {
                    Cell cell11 = row.getCell(numCampos, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell11 != null) {
                        switch (cell11.getCellType()) {
                            case STRING:
                                nombreCarpetaObtenido = cell11.getStringCellValue();
                                break;
                            case NUMERIC:
                                double valorNumerico = cell11.getNumericCellValue();
                                nombreCarpetaObtenido = (valorNumerico == (int) valorNumerico) ? 
                                    String.valueOf((int) valorNumerico) : String.valueOf(valorNumerico);
                                break;
                            case BOOLEAN:
                                nombreCarpetaObtenido = String.valueOf(cell11.getBooleanCellValue());
                                break;
                            default:
                                nombreCarpetaObtenido = "";
                                break;
                        }
                    } else {
                        nombreCarpetaObtenido = "";
                    }
                }

                if (totalCeldas >= numCampos + 2) {
                    Cell cell12 = row.getCell(numCampos + 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell12 != null) {
                        switch (cell12.getCellType()) {
                            case STRING:
                                nombreExpedienteObtenido = cell12.getStringCellValue();
                                break;
                            case NUMERIC:
                                double valorNumerico = cell12.getNumericCellValue();
                                nombreExpedienteObtenido = (valorNumerico == (int) valorNumerico) ? 
                                    String.valueOf((int) valorNumerico) : String.valueOf(valorNumerico);
                                break;
                            case BOOLEAN:
                                nombreExpedienteObtenido = String.valueOf(cell12.getBooleanCellValue());
                                break;
                            default:
                                nombreExpedienteObtenido = "";
                                break;
                        }
                    } else {
                        nombreExpedienteObtenido = "";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void renombrarArchivoMerged(String rutaCarpeta, String newFileName){
        // Crear un objeto File para la carpeta
        File folder = new File(rutaCarpeta);
        
        // Verificar que la carpeta exista y sea un directorio
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("❌ La carpeta especificada no existe o no es un directorio.");
            return;
        }

        // Buscar el archivo que se llama exactamente "merged"
        File mergedFile = new File(folder, "merged");

        // Verificar si el archivo "merged" existe
        if (!mergedFile.exists() || !mergedFile.isFile()) {
            System.out.println("❌ No se encontró el archivo 'merged' en la carpeta especificada.");
            return;
        }

        // Crear el nuevo archivo con el nombre deseado dentro de la misma carpeta
        File renamedFile = new File(folder, newFileName);

        // Intentar renombrar el archivo
        if (mergedFile.renameTo(renamedFile)) {
            System.out.println("✅ Archivo renombrado con éxito a: " + renamedFile.getName());
            return;
        } else {
            System.out.println("❌ No se pudo renombrar el archivo.");
            return;
        }
    }
    public static void mostrarLlenuraSubcarpetas(String rutaPadre, JTextField[] camposTexto, Color colorVacio, Color colorLleno){
        File carpetaPadre = new File(rutaPadre);

        if (!carpetaPadre.exists() || !carpetaPadre.isDirectory()) {
            System.out.println("La ruta proporcionada no es válida.");
            return;
        }

        File[] subCarpetas = carpetaPadre.listFiles(File::isDirectory);

        if (subCarpetas == null) {
            return;
        }

        // Recorrer las subcarpetas y actualizar los colores en los JTextField correspondientes
        for (int i = 0; i < subCarpetas.length && i < camposTexto.length; i++) {
            File subCarpeta = subCarpetas[i];

            boolean tieneArchivos = subCarpeta.listFiles() != null && subCarpeta.listFiles().length > 0;

            camposTexto[i].setBackground(tieneArchivos ? colorLleno : colorVacio);
        }
    }
    public static void asignarArchivosEtapas(String rutaPadre, String rutaDestino, int numeroEtapa) {
        // Validar que la ruta padre existe
        File directorioPadre = new File(rutaPadre);
        if (!directorioPadre.exists() || !directorioPadre.isDirectory()) {
            JOptionPane.showMessageDialog(null, "La ruta padre no es válida o no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Seleccionar archivos con JFileChooser
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

        // Buscar la carpeta destino que comience con el número especificado
        File directorioDestino = new File(rutaDestino);
        if (!directorioDestino.exists() || !directorioDestino.isDirectory()) {
            JOptionPane.showMessageDialog(null, "La ruta destino no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File carpetaDestino = null;
        File[] carpetas = directorioDestino.listFiles(File::isDirectory);
        if (carpetas != null) {
            for (File carpeta : carpetas) {
                if (carpeta.getName().startsWith(String.valueOf(numeroEtapa))) {
                    carpetaDestino = carpeta;
                    break;
                }
            }
        }

        if (carpetaDestino == null) {
            JOptionPane.showMessageDialog(null, "No se encontró una carpeta que comience con el número " + numeroEtapa, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mover los archivos seleccionados a la carpeta destino encontrada
        int archivosMovidos = 0;
        for (File archivo : archivosSeleccionados) {
            File archivoDestino = new File(carpetaDestino, archivo.getName());

            try {
                Files.move(archivo.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                archivosMovidos++;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al mover el archivo: " + archivo.getName(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(null, archivosMovidos + " archivo(s) movido(s) exitosamente a: " + carpetaDestino.getAbsolutePath());
    }
    public static void verificarSeleccion(JCheckBox jcbSeleccionarTodo, JCheckBox checkBox) {
        if (!checkBox.isSelected()) {
            jcbSeleccionarTodo.setSelected(false);
            return; // Si hay al menos uno desmarcado, salimos
        }
        
        jcbSeleccionarTodo.setSelected(true); // Si llegamos aquí, todos están seleccionados
    }
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
                textField.setText("Archivos Agregados");
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
}