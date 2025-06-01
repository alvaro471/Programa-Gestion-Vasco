package persistencia;

import java.io.*;

public class CredencialesUtil {
    private static final File ARCHIVO_CREDENCIALES;

    static {
        String userHome = System.getProperty("user.home");
        ARCHIVO_CREDENCIALES = new File(userHome, "credenciales_config.txt");
    }

    public static void guardarCredenciales(String usuario, String contrasena, String link) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CREDENCIALES))) {
            writer.write(usuario + "\n");
            writer.write(contrasena + "\n");
            writer.write(link + "\n");
            System.out.println("Credenciales guardadas exitosamente en: " + ARCHIVO_CREDENCIALES.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al guardar credenciales: " + e.getMessage());
        }
    }

    public static String[] cargarCredenciales() {
        if (ARCHIVO_CREDENCIALES.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CREDENCIALES))) {
                String usuario = reader.readLine();
                String contrasena = reader.readLine();
                String link = reader.readLine();
                return new String[]{usuario, contrasena, link};
            } catch (IOException e) {
                System.out.println("Error al leer credenciales: " + e.getMessage());
            }
        }
        return null;
    }
}
