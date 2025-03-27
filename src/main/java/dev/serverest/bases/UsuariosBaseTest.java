package dev.serverest.bases;

import dev.serverest.endponits.EndpointConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class UsuariosBaseTest extends EndpointConfig {
    public static RequestSpecification baseUrl;
    public static RequestSpecification usuariosRequest;
    public static ResponseSpecification statusOK;

    @BeforeClass
    public void setUp() {
        baseUrl();
        usuarios();
        responseStatusOK();
    }

    private void baseUrl() {
        baseUrl = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    private void usuarios() {
        usuariosRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_USUARIOS)
                .setContentType(ContentType.JSON)
                .build();
    }

    private void responseStatusOK() {
        statusOK = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }
}