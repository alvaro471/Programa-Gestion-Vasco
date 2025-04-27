package persistencia;

import java.io.*;

public class ConfigUtil {
    private static final File ARCHIVO_CONFIG;

    static {
        // Ubicación del archivo config.txt junto al .jar ejecutado
        File jarDir = new File(ConfigUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
        ARCHIVO_CONFIG = new File(jarDir, "config.txt");
    }

    public static void guardarRuta(String ruta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CONFIG))) {
            writer.write(ruta);
        } catch (IOException e) {
            System.out.println("No se pudo guardar la ruta: " + e.getMessage());
        }
    }

    public static String cargarRuta() {
        if (ARCHIVO_CONFIG.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CONFIG))) {
                return reader.readLine();
            } catch (IOException e) {
                System.out.println("No se pudo leer la ruta: " + e.getMessage());
            }
        }
        return null;
    }
}