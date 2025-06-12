/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomatizadorMIMP {
    private WebDriver driver;
    private WebDriverWait wait;
    
    public AutomatizadorMIMP(){
        
    }

    public void iniciarSesion(String usuario, String clave, boolean headless) {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://drive.mimp.gob.pe/apps/files/files");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user"))).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(clave);

        WebElement botonLogin = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Iniciar sesión']]")
        ));
        botonLogin.click();

        try {
            Thread.sleep(1000);
            if (!headless) {
                minimizarChromeViaPowerShell();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void abrirRuta(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table")));
    }

    public boolean buscarEXPRecursivamente(String nombreBusqueda, DefaultListModel<String> nombres, DefaultListModel<String> rutas) throws InterruptedException {
        nombres.clear();
        rutas.clear();

        String urlRaiz = driver.getCurrentUrl();

        List<WebElement> carpetasPrincipales = driver.findElements(By.cssSelector("tr[data-type='dir']"));
        int totalCarpetas = carpetasPrincipales.size();

        for (int i = 0; i < totalCarpetas; i++) {
            driver.get(urlRaiz);
            Thread.sleep(1000);

            carpetasPrincipales = driver.findElements(By.cssSelector("tr[data-type='dir']"));

            WebElement carpetaPrincipal = carpetasPrincipales.get(i);
            String nombrePrincipal = carpetaPrincipal.getAttribute("data-file");
            String pathPrincipal = carpetaPrincipal.getAttribute("data-path");
            String idPrincipal = carpetaPrincipal.getAttribute("data-id");

            String rutaPrincipal = "https://drive.mimp.gob.pe/apps/files/files?dir=" +
                    pathPrincipal + "/" + nombrePrincipal +
                    "&fileid=" + idPrincipal;

            driver.get(rutaPrincipal);
            Thread.sleep(1500);

            cargarTodoElContenidoConScroll();

            List<WebElement> subCarpetas = driver.findElements(By.cssSelector("tr[data-type='dir']"));
            for (WebElement subCarpeta : subCarpetas) {
                String nombreSubCarpeta = subCarpeta.getAttribute("data-file").toLowerCase();
                String pathSub = subCarpeta.getAttribute("data-path");
                String idSub = subCarpeta.getAttribute("data-id");

                String rutaSub = "https://drive.mimp.gob.pe/apps/files/files?dir=" +
                        pathSub + "/" + nombreSubCarpeta +
                        "&fileid=" + idSub;

                if (nombreSubCarpeta.contains(nombreBusqueda.toLowerCase())) {
                    nombres.addElement(subCarpeta.getAttribute("data-file"));
                    rutas.addElement(rutaSub);
                    return true;
                }
            }

        }

        return false;
    }


    
    private boolean buscarEnNivel(String nombreBusqueda, DefaultListModel<String> nombres, DefaultListModel<String> rutas) throws InterruptedException {
        List<WebElement> carpetas = driver.findElements(By.cssSelector("tr[data-type='dir']"));
        int totalCarpetas = carpetas.size();

        for (int i = 0; i < totalCarpetas; i++) {
            carpetas = driver.findElements(By.cssSelector("tr[data-type='dir']"));
            WebElement carpeta = carpetas.get(i);

            String nombreCarpeta = carpeta.getAttribute("data-file").toLowerCase();
            String pathCarpeta = carpeta.getAttribute("data-path");
            String idCarpeta = carpeta.getAttribute("data-id");

            String ruta = "https://drive.mimp.gob.pe/apps/files/files?dir=" +
                    pathCarpeta + "/" + carpeta.getAttribute("data-file") +
                    "&fileid=" + idCarpeta;

            if (nombreCarpeta.contains(nombreBusqueda)) {

                nombres.addElement(carpeta.getAttribute("data-file"));
                rutas.addElement(ruta);

                return true;
            }

        }

        return false;
    }



    public void obtenerArchivosDeRuta(String rutaCarpeta, DefaultListModel<String> nombresArchivos, DefaultListModel<String> rutasArchivos) {
        driver.get(rutaCarpeta);

        try {
            cargarTodoElContenidoConScroll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> archivos = driver.findElements(By.cssSelector("tr[data-type='file']"));

        nombresArchivos.clear();
        rutasArchivos.clear();

        for (WebElement archivo : archivos) {
            String nombreArchivo = archivo.getAttribute("data-file");
            if (nombreArchivo == null) continue;

            if (nombreArchivo.toLowerCase().endsWith(".doc") || nombreArchivo.toLowerCase().endsWith(".docx")) {
                continue;
            }

            String pathArchivo = archivo.getAttribute("data-path");
            String idArchivo = archivo.getAttribute("data-id");

            String ruta = "https://drive.mimp.gob.pe/apps/files/files?dir=" +
                pathArchivo + "&fileid=" + idArchivo;

            nombresArchivos.addElement(nombreArchivo);
            rutasArchivos.addElement(ruta);
        }

        System.out.println("Archivos encontrados: " + nombresArchivos.size());
    }


    public void cerrar() {
        if (driver != null) driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
    
    private void cargarTodoElContenidoConScroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String selector = "#app-content";

        // Verifica que el contenedor exista
        Boolean existeContenedor = (Boolean) js.executeScript(
            "return document.querySelector('" + selector + "') !== null;"
        );

        if (!existeContenedor) {
            System.out.println("Contenedor con scroll no encontrado: " + selector);
            return;
        }

        long lastHeight = (long) js.executeScript(
            "return document.querySelector('" + selector + "').scrollHeight;"
        );

        int intentosSinCambios = 0;

        while (intentosSinCambios < 3) { // deja 3 ciclos sin cambios antes de salir
            js.executeScript(
                "document.querySelector('" + selector + "').scrollTo(0, document.querySelector('" + selector + "').scrollHeight);"
            );
            Thread.sleep(1000); // puedes subir a 1500 si aún falla

            long newHeight = (long) js.executeScript(
                "return document.querySelector('" + selector + "').scrollHeight;"
            );

            if (newHeight == lastHeight) {
                intentosSinCambios++;
            } else {
                intentosSinCambios = 0;
                lastHeight = newHeight;
            }
        }

        System.out.println("Scroll automático completado.");
        List<WebElement> carpetas = driver.findElements(By.cssSelector("tr[data-type='dir']"));
        System.out.println("Carpetas visibles después del scroll: " + carpetas.size());

        for (WebElement carpeta : carpetas) {
            System.out.println("Carpeta: " + carpeta.getAttribute("data-file"));
        }

    }
    

    
    public void descargarArchivo(String url, File destino) throws Exception {
        driver.get(url);

        WebElement botonDescarga = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button[aria-label='Descargar']") // Ajusta según el sitio
        ));
        botonDescarga.click();

    }

    public void abrirCarpetaPorNombreExactoEnVistaActual(
        String nombreExacto,
        DefaultListModel<String> nombresArchivos,
        DefaultListModel<String> rutasArchivos
    ) throws InterruptedException {
        cargarTodoElContenidoConScroll();

        List<WebElement> carpetas = driver.findElements(By.cssSelector("tr[data-type='dir']"));

        for (WebElement carpeta : carpetas) {
            String nombre = carpeta.getAttribute("data-file").trim().toLowerCase();

            if (nombre.equals(nombreExacto)) {
                String path = carpeta.getAttribute("data-path");
                String id = carpeta.getAttribute("data-id");

                String ruta = "https://drive.mimp.gob.pe/apps/files/files?dir=" +
                    path + "/" + carpeta.getAttribute("data-file") +
                    "&fileid=" + id;

                driver.get(ruta);
                Thread.sleep(1500);

                obtenerArchivosDeRuta(ruta, nombresArchivos, rutasArchivos);
                return;
            }
        }

        throw new RuntimeException("No se encontró la carpeta con nombre exacto: " + nombreExacto);
    }

    public void descargarArchivo(String nombreArchivo) {
        try {
            if (driver == null) {
                System.out.println("El driver no está inicializado.");
                return;
            }

            WebDriverWait waitLocal = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement filaArchivo = waitLocal.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//tr[td//span[@class='innernametext' and contains(text(),'" + nombreArchivo + "')]]")
            ));

            WebElement botonOpciones = filaArchivo.findElement(By.cssSelector("a.action-menu"));
            botonOpciones.click();

            WebElement opcionDescargar = waitLocal.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[contains(@class,'action-menu')]//a[contains(@data-action,'Download')]")
            ));
            opcionDescargar.click();

            System.out.println("Descarga iniciada para: " + nombreArchivo);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar descargar el archivo: " + nombreArchivo);
        }
    }
    
    public void descargarArchivoDirecto(String url, String destino) {
        try (InputStream in = new URL(url).openStream()) {
            Files.copy(in, Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo descargado a: " + destino);
        } catch (IOException e) {
            System.out.println("Error al descargar desde URL: " + url);
            e.printStackTrace();
        }
    }
    public void descargarArchivoPorNombre(String nombreArchivoSeleccionado) {
        if (nombreArchivoSeleccionado == null || nombreArchivoSeleccionado.isEmpty()) {
        System.out.println("No hay archivo seleccionado.");
        return;
        }

        try {
            cargarTodoElContenidoConScroll();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            List<WebElement> elementos = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.innernametext"))
            );

            WebElement filaArchivo = null;
            String nombreBuscado = nombreArchivoSeleccionado.trim().replaceAll("\\s+", " ").toLowerCase();

            for (WebElement elem : elementos) {
                String nombreDOM = elem.getText().trim().replaceAll("\\s+", " ").toLowerCase();
                System.out.println("Archivo DOM: [" + nombreDOM + "]");

                if (nombreDOM.contains(nombreBuscado)) {
                    filaArchivo = elem.findElement(By.xpath("./ancestor::tr"));
                    break;
                }
            }

            if (filaArchivo == null) {
                System.out.println("No se encontró el archivo en la tabla: " + nombreArchivoSeleccionado);
                return;
            }

            WebElement botonOpciones = filaArchivo.findElement(By.cssSelector("a.action-menu"));
            botonOpciones.click();

            WebElement opcionDescargar = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.action-download-container > a.action-download")));
            opcionDescargar.click();

            System.out.println("Descarga iniciada para: " + nombreArchivoSeleccionado);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar descargar el archivo: " + nombreArchivoSeleccionado);
        }
    }
    
    
    //Reemplaza descargarArchivoPorNombre porque es muy estricto
    public void abrirCarpetaPorNombreMasParecidoEnVistaActual(
        String nombreBuscado,
        DefaultListModel<String> nombresArchivos,
        DefaultListModel<String> rutasArchivos
    ) throws InterruptedException {
        cargarTodoElContenidoConScroll();

        List<WebElement> carpetas = driver.findElements(By.cssSelector("tr[data-type='dir']"));

        String mejorCoincidenciaNombre = null;
        String mejorCoincidenciaRuta = null;
        int mejorScore = Integer.MIN_VALUE;

        String nombreBuscadoNormalizado = normalizarTexto(nombreBuscado);

        for (WebElement carpeta : carpetas) {
            String nombreActual = carpeta.getAttribute("data-file").trim();
            String nombreActualNormalizado = normalizarTexto(nombreActual);

            int score = calcularSimilitud(nombreBuscadoNormalizado, nombreActualNormalizado);

            if (score > mejorScore) {
                mejorScore = score;
                mejorCoincidenciaNombre = nombreActual;

                String path = carpeta.getAttribute("data-path");
                String id = carpeta.getAttribute("data-id");

                mejorCoincidenciaRuta = "https://drive.mimp.gob.pe/apps/files/files?dir=" +
                        path + "/" + carpeta.getAttribute("data-file") +
                        "&fileid=" + id;
            }
            System.out.println("Comparando: [" + nombreBuscadoNormalizado + "] vs [" + nombreActualNormalizado + "] => Score: " + score);

        }

        if (mejorCoincidenciaRuta != null && mejorScore > 0) {
            System.out.println("?Abriendo carpeta más parecida: " + mejorCoincidenciaNombre + " (score: " + mejorScore + ")");
            driver.get(mejorCoincidenciaRuta);
            Thread.sleep(1500);
            obtenerArchivosDeRuta(mejorCoincidenciaRuta, nombresArchivos, rutasArchivos);
        } else {
            System.out.println("Ninguna coincidencia con score suficiente. Score más alto: " + mejorScore);
            throw new RuntimeException("No se encontró ninguna carpeta parecida a: " + nombreBuscado +
            ". Total carpetas visibles: " + carpetas.size());

        }

        System.out.println("Carpetas encontradas en vista actual: " + carpetas.size());
        for (WebElement carpeta : carpetas) {
            System.out.println("Carpeta DOM: [" + carpeta.getAttribute("data-file") + "]");
        }
        

    }
    public int calcularSimilitud(String a, String b) {
        int coincidencias = 0;
        String[] palabrasA = a.split(" ");
        String[] palabrasB = b.split(" ");
        for (String palabraA : palabrasA) {
            for (String palabraB : palabrasB) {
                if (palabraA.equals(palabraB)) coincidencias++;
            }
        }
        return coincidencias;
    }

    public String normalizarTexto(String texto) {
        return texto
            .toLowerCase()
            .replaceAll("(?i)\\.pdf$", "")
            .replaceAll("[^a-z0-9áéíóúñ ]", "")
            .replaceAll("\\s+", " ")
            .trim();
    }

    public void abrirArchivoPorNombre(String nombreArchivoSeleccionado) {
        if (nombreArchivoSeleccionado == null || nombreArchivoSeleccionado.isEmpty()) {
            System.out.println("No hay archivo seleccionado.");
            return;
        }

        try {
            cargarTodoElContenidoConScroll();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            List<WebElement> elementos = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.innernametext"))
            );

            WebElement filaArchivo = null;
            String nombreBuscado = nombreArchivoSeleccionado.trim().replaceAll("\\s+", " ").toLowerCase();

            for (WebElement elem : elementos) {
                String nombreDOM = elem.getText().trim().replaceAll("\\s+", " ").toLowerCase();
                if (nombreDOM.contains(nombreBuscado)) {
                    filaArchivo = elem.findElement(By.xpath("./ancestor::tr"));
                    break;
                }
            }

            if (filaArchivo == null) {
                System.out.println("No se encontró el archivo en la tabla: " + nombreArchivoSeleccionado);
                return;
            }

            filaArchivo.click();
            Thread.sleep(100);
            filaArchivo.click();

            System.out.println("Archivo abierto: " + nombreArchivoSeleccionado);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar abrir el archivo: " + nombreArchivoSeleccionado);
        }
    }

    public void minimizarChrome() {
        User32 user32 = User32.INSTANCE;
        final HWND[] chromeWindow = new HWND[1];

        user32.EnumWindows((hWnd, data) -> {
            char[] windowText = new char[512];
            user32.GetWindowText(hWnd, windowText, 512);
            String title = Native.toString(windowText).toLowerCase();
            System.out.println("Ventana detectada: '" + title + "'");

            if (title.contains("chrome") && user32.IsWindowVisible(hWnd)) {
                chromeWindow[0] = hWnd;
                return false;
            }
            return true;
        }, null);

        if (chromeWindow[0] != null) {
            System.out.println("Minimizando ventana: " + chromeWindow[0]);
            boolean result = user32.ShowWindow(chromeWindow[0], WinUser.SW_MINIMIZE);
            System.out.println("ShowWindow result: " + result);
        } else {
            System.out.println("No se encontró ventana de Chrome para minimizar.");
        }
    }


    public void minimizarChromeViaPowerShell() {
        try {
            String script = "powershell -command \"(Get-Process chrome | Where-Object { $_.MainWindowHandle -ne 0 }).MainWindowHandle | ForEach-Object {" +
                    "Add-Type -Name Win32 -Namespace Native -MemberDefinition '[DllImport(\\\"user32.dll\\\")]public static extern bool ShowWindowAsync(IntPtr hWnd, int nCmdShow);'; " +
                    "[Native.Win32]::ShowWindowAsync($_, 6) }\"";

            Runtime.getRuntime().exec(script);
            System.out.println("PowerShell ejecutado para minimizar Chrome.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
