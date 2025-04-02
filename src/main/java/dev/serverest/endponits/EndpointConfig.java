package dev.serverest.endponits;

import dev.serverest.managers.PropertiesManager;

import java.util.Properties;

public class EndpointConfig {
    private static final String DEFAULT_FILE = "configuration";
    private static final String DEFAULT_FOLDER = "url";
    private static final Properties properties = PropertiesManager.loadProperties(DEFAULT_FILE, DEFAULT_FOLDER);

    protected static final String ID_USER = PropertiesManager.loadProperties("authorize", "idUser").getProperty("ID_USER");

    protected static final String BASE_URI = properties.getProperty("BASE_URI");
    protected static final String PATH_USUARIOS = properties.getProperty("PATH_USUARIOS");
}
