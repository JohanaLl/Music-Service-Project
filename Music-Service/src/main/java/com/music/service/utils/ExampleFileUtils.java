package com.music.service.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Clase -utilitaria para manejo de archivos y recusros JSON
 */
public class ExampleFileUtils {

    /**
     * Leer y convertir un archivo JSON a un JSONObject
     * @param inputSource archivo a leer
     * @return un Optional contiene el parsed JSONObject, o empty si el parsing falla
     * @throws IllegalArgumentException si el inputSource es null o no existe
     */
    public static JSONObject getJsonFromFile(File inputSource) {
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(new FileReader(inputSource));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera un archivo de los recursos de classpath
     * @param fileName nombre del archivo a recuperar
     * @return el objeto de archivo que representa el recurso
     * @throws IllegalArgumentException si el archivo no puede ser encontrado
     */
    public static File getFileFromResources(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource != null) {
            return new File(resource.getFile());
        } else {
            throw new IllegalArgumentException("Missing file");
        }
    }
}
