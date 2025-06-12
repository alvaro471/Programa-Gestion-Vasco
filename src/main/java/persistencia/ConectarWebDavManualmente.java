/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;


import org.apache.jackrabbit.webdav.client.methods.PropFindMethod;
import org.apache.jackrabbit.webdav.DavConstants;
import org.apache.jackrabbit.webdav.MultiStatus;
import org.apache.jackrabbit.webdav.MultiStatusResponse;
import org.apache.jackrabbit.webdav.security.SecurityConstants;
import org.apache.jackrabbit.webdav.client.methods.DavMethodBase;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.LinkedHashMap;

import java.util.Map;


public class ConectarWebDavManualmente {
    public String normalizar(String texto) {
        return java.text.Normalizer.normalize(texto, java.text.Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                    .replaceAll("[^a-zA-Z0-9]", "") // quita guiones, etc.
                    .toLowerCase();
    }

    public Map<String, String> buscarSubcarpetasManual(String urlWebDAV, String palabraClave, String usuario, String token) throws Exception {
        Map<String, String> resultados = new LinkedHashMap<>();

        HttpClient client = new HttpClient();
        client.getParams().setAuthenticationPreemptive(true);
        client.getState().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(usuario, token));

        PropFindMethod propFind = new PropFindMethod(urlWebDAV, DavConstants.PROPFIND_ALL_PROP, DavConstants.DEPTH_1);

        int status = client.executeMethod(propFind);

        System.out.println("Código HTTP: " + status);
        System.out.println("Respuesta:\n" + propFind.getResponseBodyAsString());

        if (status != 207) {
            throw new RuntimeException("PROPFIND falló con código HTTP: " + status);
        }

        MultiStatus multiStatus = propFind.getResponseBodyAsMultiStatus();
        for (MultiStatusResponse response : multiStatus.getResponses()) {
            String href = response.getHref();
            if (href.equals("/") || href.equals(new java.net.URL(urlWebDAV).getPath()) || href.equals(new java.net.URL(urlWebDAV).getPath() + "/")) {
                continue;
            }
            String displayName = response.getProperties(200).get(DavConstants.PROPERTY_DISPLAYNAME).getValue().toString();
            String resourcetype = response.getProperties(200).get(DavConstants.PROPERTY_RESOURCETYPE).getValue().toString();
            boolean isCollection = resourcetype.contains("collection");

            if (isCollection && normalizar(displayName).contains(normalizar(palabraClave))) {
                String fullPath = urlWebDAV;
                if (!fullPath.endsWith("/")) fullPath += "/";
                String rutaCodificada = URLEncoder.encode(displayName, "UTF-8").replace("+", "%20");
                resultados.put(displayName, fullPath + rutaCodificada);
            }
        }

        propFind.releaseConnection();
        return resultados;
    }

    
    public String transformarLinkWebDAVNextcloud(String linkNextcloud, String usuario) throws Exception {
        if (!linkNextcloud.contains("dir=")) {
            throw new Exception("URL inválida. No contiene 'dir='.");
        }

        String ruta = linkNextcloud.substring(linkNextcloud.indexOf("dir=") + 4);
        int ampersandIndex = ruta.indexOf("&");
        if (ampersandIndex != -1) {
            ruta = ruta.substring(0, ampersandIndex);
        }

        ruta = java.net.URLDecoder.decode(ruta, "UTF-8");

        // Construir URL WebDAV Nextcloud
        StringBuilder url = new StringBuilder("https://drive.mimp.gob.pe/remote.php/dav/files/");
        url.append(usuario);

        String[] partes = ruta.split("/");
        for (String parte : partes) {
            if (parte.isEmpty()) continue;
            url.append("/");
            url.append(java.net.URLEncoder.encode(parte, "UTF-8").replace("+", "%20"));
        }

        return url.toString();
    }




}
