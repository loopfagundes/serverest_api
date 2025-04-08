package dev.serverest.bases;

import org.testng.annotations.BeforeClass;

import dev.serverest.endponits.EndpointConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ProdutosBaseTest extends EndpointConfig {
    public static RequestSpecification pathProdutosRequest;

    @BeforeClass
    public void setUp() {
        pathProdutos();
        cadastrarProdutos();
    }

    private void pathProdutos() {
        pathProdutosRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_PRODUTOS)
                .setContentType(ContentType.JSON)
                .build();
    }

    private void cadastrarProdutos() {
        pathProdutosRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_PRODUTOS)
                .setContentType(ContentType.JSON)
                .build();
    }

}