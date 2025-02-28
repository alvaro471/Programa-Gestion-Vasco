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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
    public static void crearSubcarpetas(String rutaCarpeta, String dni) {
        // Lista de nombres de subcarpetas con la variable incluida en la primera
        String[] nombres = {
            "1_REC_" + dni,
            "2_ID_" + dni,
            "3_EMI_" + dni,
            "4_ARC_" + dni,
            "5_APE_" + dni,
            "6_SEG_" + dni,
            "7_AGR_" + dni,
            "8_CON_" + dni
        };

        // Crear cada subcarpeta
        for (String nombre : nombres) {
            File subcarpeta = new File(rutaCarpeta, nombre);
            if (!subcarpeta.exists()) {
                if (subcarpeta.mkdir()) {
                    System.out.println("Carpetas creadas");
                } else {
                    System.out.println("Error al crear: " + subcarpeta.getAbsolutePath());
                }
            } else {
                System.out.println("La carpeta ya existe: " + subcarpeta.getAbsolutePath());
            }
        }
    }
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
    public static void procesarCarpeta(String rutaBase, String variable) {
        File carpetaBase = new File(rutaBase);

        // Validar que la carpeta existe
        if (!carpetaBase.exists() || !carpetaBase.isDirectory()) {
            System.out.println("La carpeta especificada no existe o no es una carpeta.");
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
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear: " + subcarpeta.getAbsolutePath());
                }
            }
        }

        // Listar archivos PDF y Word
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
            for (String nombreCarpeta : nombresSubcarpetas) {
                if (nombreCarpeta.startsWith(numeroInicial + "_")) {
                    File carpetaDestino = new File(rutaBase, nombreCarpeta);
                    Path origen = archivo.toPath();
                    Path destino = carpetaDestino.toPath().resolve(archivo.getName());

                    try {
                        Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Movido: " + nombreArchivo + " → " + carpetaDestino.getName());
                    } catch (Exception e) {
                        System.out.println("Error moviendo " + nombreArchivo + ": " + e.getMessage());
                    }
                    break; // Dejar de buscar una vez que se encuentra la carpeta
                }
            }
        }
    }
    public static boolean renombrarCarpeta(String currentPath, String newName) {
        File folder = new File(currentPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("La carpeta no existe o no es un directorio.");
            return false;
        }

        File newFolder = new File(folder.getParent(), newName);
        if (folder.renameTo(newFolder)) {
            JOptionPane.showMessageDialog(null, "Carpetas renombradas con exito");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al renombrar la carpeta.");
            return false;
        }
    }
    public static void moverArchivosCoincidentes(String rutaBase) {
        File carpetaBase = new File(rutaBase);

        // Validar que la carpeta base existe y es un directorio
        if (!carpetaBase.exists() || !carpetaBase.isDirectory()) {
            System.out.println("La carpeta especificada no existe o no es un directorio.");
            return;
        }

        // Obtener todas las subcarpetas
        File[] subcarpetas = carpetaBase.listFiles(File::isDirectory);

        if (subcarpetas == null || subcarpetas.length == 0) {
            System.out.println("No se encontraron subcarpetas.");
            return;
        }

        // Obtener todos los archivos PDF y Word que comienzan con un número
        File[] archivos = carpetaBase.listFiles((dir, name) -> name.matches("^\\d+.*\\.(pdf|docx)$"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos PDF o Word con número inicial.");
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
                    } catch (Exception e) {
                        System.out.println("Error moviendo " + nombreArchivo + ": " + e.getMessage());
                    }
                    break; // Una vez que se mueve, no hay que seguir buscando
                }
            }
        }
    }
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
                hoja = workbook.createSheet("Hoja1");
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
                estadoField.setText("Fila lista");
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


}