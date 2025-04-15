package dev.serverest.bases;

import org.testng.annotations.BeforeClass;

import dev.serverest.endponits.EndpointConfig;
import dev.serverest.stubs.CarrinhoStub;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CarrinhoBaseTest extends EndpointConfig {
    public static RequestSpecification pathCarrinhoRequest;
    public static RequestSpecification cadastrarCarrinhoRquest;
    protected static String idCarrinho;


    @BeforeClass
    public void setUp() {
        pathCarrinho();
        cadastrarCarrinho();
    }

    private void pathCarrinho() {
        pathCarrinhoRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_CARRINHOS)
                .addHeader("Authorization", TOKEN)
                .setContentType(ContentType.JSON)
                .build();
    }

    private void cadastrarCarrinho() {
        cadastrarCarrinhoRquest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_CARRINHOS)
                .addHeader("Authorization", TOKEN)
                .setBody(CarrinhoStub.carrinhoStub())
                .setContentType(ContentType.JSON)
                .build();
    }
}