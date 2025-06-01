package persistencia;

import java.io.*;

public class ConfigUtil {
    private static final File ARCHIVO_PRINCIPAL;
    private static final File ARCHIVO_GENERAL;

    static {
        String userHome = System.getProperty("user.home");
        ARCHIVO_PRINCIPAL = new File(userHome, "config_principal.txt");
        ARCHIVO_GENERAL = new File(userHome, "config_general.txt");
    }

    public static void guardarRutaPrincipal(String ruta) {
        guardarRuta(ARCHIVO_PRINCIPAL, ruta);
    }

    public static String cargarRutaPrincipal() {
        return cargarRuta(ARCHIVO_PRINCIPAL);
    }

    public static void guardarRutaGeneral(String ruta) {
        guardarRuta(ARCHIVO_GENERAL, ruta);
    }

    public static String cargarRutaGeneral() {
        return cargarRuta(ARCHIVO_GENERAL);
    }

    private static void guardarRuta(File archivo, String ruta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(ruta);
            System.out.println("Ruta guardada exitosamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("No se pudo guardar la ruta: " + e.getMessage());
        }
    }

    private static String cargarRuta(File archivo) {
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                return reader.readLine();
            } catch (IOException e) {
                System.out.println("No se pudo leer la ruta: " + e.getMessage());
            }
        }
        return null;
    }
}
