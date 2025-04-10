package dev.serverest.bases;

import dev.serverest.endponits.EndpointConfig;
import dev.serverest.stubs.LoginStub;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class LoginBaseTest extends EndpointConfig {
    public static RequestSpecification loginRequest;
    protected static String token;

    @BeforeClass
    public void setUp() {
        login();
    }

    private void login() {
        loginRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_LOGIN)
                .setBody(LoginStub.loginUsuarioStub())
                .setContentType(ContentType.JSON)
                .build();
    }
}