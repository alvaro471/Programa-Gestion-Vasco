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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
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
    //
    public static void verificarSeleccion(JCheckBox jcbSeleccionarTodo, JCheckBox checkBox) {
        if (!checkBox.isSelected()) {
            jcbSeleccionarTodo.setSelected(false);
            return; // Si hay al menos uno desmarcado, salimos
        }
        
        jcbSeleccionarTodo.setSelected(true); // Si llegamos aquí, todos están seleccionados
    }

}