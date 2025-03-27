package dev.serverest.managers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesManager {
    private static final String DIR_PATH_PROPERTIES = Paths.get(System.getProperty("user.dir"), "src", "main", "resources").toString();

    public static Properties loadProperties(String nameFolder, String name) {
        Path filePath = Paths.get(DIR_PATH_PROPERTIES, nameFolder, name + ".properties");
        Properties prop = new Properties();
        try (InputStream inputStream = Files.newInputStream(filePath)) {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo: " + filePath, e);
        }
        return prop;
    }

    public static void setProperty(String nameFolder, String nameProp, String key, String value) throws IOException {
        Properties properties = loadProperties(nameFolder, nameProp);
        properties.setProperty(key, value);
        saveProperties(nameFolder, nameProp, properties);
    }

    private static void saveProperties(String nameFolder, String name, Properties properties) throws IOException {
        Path filePath = Paths.get(DIR_PATH_PROPERTIES, nameFolder, name + ".properties");
        try (OutputStream outputStream = Files.newOutputStream(filePath)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar o arquivo: " + filePath, e);
        }
    }
}
