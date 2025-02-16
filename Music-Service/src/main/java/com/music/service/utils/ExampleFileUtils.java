package com.music.service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Optional;

/**
 * Clase -utilitaria para manejo de archivos y recusros JSON
 */
public class ExampleFileUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Leer y convertir un archivo JSON a un JSONObject
     * @param inputSource archivo a leer
     * @return un Optional contiene el parsed JSONObject, o empty si el parsing falla
     * @throws IllegalArgumentException si el inputSource es null o no existe
     */
    public static JsonNode getJsonFromFile(File inputSource) {

        try {
            return switch (inputSource) {
                case File f when f.exists() && f.isFile() -> mapper.readTree(f);
                case null ->
                    throw new IllegalArgumentException("Input source cannot be null");
                default ->
                    throw new IllegalArgumentException("Invalid input source");
            };
        } catch (IOException e) {
            throw new UncheckedIOException("Error reading JSON file", e);
        }
    }

    /**
     * Recupera un archivo de los recursos de classpath
     * @param fileName nombre del archivo a recuperar
     * @return el objeto de archivo que representa el recurso
     * @throws IllegalArgumentException si el archivo no puede ser encontrado
     */
    public static File getFileFromResources(String fileName) {

        return Optional.ofNullable(fileName)
                .map(Thread.currentThread().getContextClassLoader()::getResource)
                .map(URL::getFile)
                .map(File::new)
                .orElseThrow(() -> new IllegalArgumentException("File not found: " + fileName));
    }
}
