package dev.serverest.bases;

import dev.serverest.endponits.EndpointConfig;
import dev.serverest.stubs.UsuarioStub;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class UsuariosBaseTest extends EndpointConfig {
    public static RequestSpecification pathUsuariosRequest;
    public static RequestSpecification cadastrarUsuarioRequest;
    public static RequestSpecification editarUsuarioRequest;
    protected static String idUser;

    @BeforeClass
    public void setUp() {
        pathUsuarios();
        cadastrarDoUsuario();
        editarUsuario();
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
                .setBody(UsuarioStub.cadastrarUsuarioStub())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void editarUsuario() {
        editarUsuarioRequest = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_USUARIOS)
                .setBody(UsuarioStub.editarUsuarioStub())
                .setContentType(ContentType.JSON)
                .build();
    }
}