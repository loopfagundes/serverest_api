package dev.serverest.bases;

import org.testng.annotations.BeforeClass;

import dev.serverest.endponits.EndpointConfig;
import dev.serverest.managers.TokenManager;
import dev.serverest.stubs.ProdutoStub;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ProdutosBaseTest extends EndpointConfig {
    public static RequestSpecification pathProdutosRequest;
    public static RequestSpecification cadastrarProdutoRequest;
    public static RequestSpecification editarProdutoRequest;
    public static RequestSpecification deleteProdutoRequest;
    protected static String idProduto;

    @BeforeClass
    public void setUp() {
        deleteProduto();
        pathProdutos();
        cadastrarProdutos();
        editarProduto();
    }

    private void pathProdutos() {
        pathProdutosRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_PRODUTOS)
                .setContentType(ContentType.JSON)
                .build();
    }

    private void cadastrarProdutos() {
        cadastrarProdutoRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_PRODUTOS)
                .addHeader("Authorization", TokenManager.getToken())
                .setBody(ProdutoStub.cadastrarProdutoStub())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void deleteProduto() {
        deleteProdutoRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_PRODUTOS)
                .addHeader("Authorization", TokenManager.getToken())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void editarProduto() {
        editarProdutoRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_PRODUTOS)
                .addHeader("Authorization", TokenManager.getToken())
                .setBody(ProdutoStub.editarProdutoStub())
                .setContentType(ContentType.JSON)
                .build();
    }
}