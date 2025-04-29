package dev.serverest.endponits;

import dev.serverest.managers.PropertiesManager;

import java.util.Properties;

public class EndpointConfig {
    private static final String DEFAULT_FILE = "configuration";
    private static final String DEFAULT_FOLDER = "url";
    private static final Properties properties = PropertiesManager.loadProperties(DEFAULT_FILE, DEFAULT_FOLDER);

    protected static final String ID_USER_ADMIN_TRUE = PropertiesManager.loadProperties("authorize", "idUser").getProperty("ID_USER_ADMIN_TRUE");
    protected static final String ID_PRODUTO = PropertiesManager.loadProperties("properties", "idProduto").getProperty("ID_PRODUTO");
    protected static final String ID_CARRINHO = PropertiesManager.loadProperties("properties", "idCarrinho").getProperty("ID_CARRINHO");

    protected static final String BASE_URI = properties.getProperty("BASE_URI");
    protected static final String PATH_USUARIOS = properties.getProperty("PATH_USUARIOS");
    protected static final String PATH_LOGIN = properties.getProperty("PATH_LOGIN");
    protected static final String PATH_PRODUTOS = properties.getProperty("PATH_PRODUTOS");
    protected static final String PATH_CARRINHOS = properties.getProperty("PATH_CARRINHOS");
}