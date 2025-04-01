package dev.serverest.bases;

import dev.serverest.endponits.EndpointConfig;
import dev.serverest.stubs.CadastrarUsuarioStub;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class UsuariosBaseTest extends EndpointConfig {
    public static RequestSpecification baseUrl;
    public static RequestSpecification pathUsuariosRequest;
    public static RequestSpecification cadastrarUsuarioRequest;
    protected static String idUser;

    @BeforeClass
    public void setUp() {
        baseUrl();
        pathUsuarios();
        cadastrarDoUsuario();
    }

    private void baseUrl() {
        baseUrl = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    private void pathUsuarios() {
        pathUsuariosRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_USUARIOS)
                .setContentType(ContentType.JSON)
                .build();
    }

    private void cadastrarDoUsuario() {
        cadastrarUsuarioRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_USUARIOS)
                .setBody(CadastrarUsuarioStub.usuarioDto())
                .setContentType(ContentType.JSON)
                .build();
    }
}