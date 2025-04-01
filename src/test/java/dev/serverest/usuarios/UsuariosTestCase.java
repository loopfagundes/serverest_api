package dev.serverest.usuarios;

import dev.serverest.bases.UsuariosBaseTest;
import dev.serverest.managers.PropertiesManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class UsuariosTestCase extends UsuariosBaseTest {

    @Epic("Teste de Usuarios")
    @Feature("[GET] - Teste para buscar todos os usuários cadastrados na lista.")
    @Description("Deve retornar 200 e a lista completa de usuários cadastrados.")
    @Test
    public void getBuscarTodosOsUsuarioCadastradosNaLista200() {
        RestAssured.given()
                    .spec(pathUsuariosRequest)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all();
    }

    @Epic("Teste de Usuarios")
    @Feature("[GET] - Teste para buscar por ID um usuário cadastrado na lista.")
    @Description("Deve retornar 200 e a lista do ID um usuário cadastrado.")
    @Test
    public void getBuscarUmUsuarioCadastradoNaLista200() {
        RestAssured.given()
                    .spec(pathUsuariosRequest)
                .when()
                    .get("/" + ID_USER)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all();
    }

    @Epic("Teste de Usuarios")
    @Feature("[POST] - Teste para fazer cadastrar um novo usuário")
    @Description("Deve retornar 200 e usuário cadastrado.")
    @Test
    public void postCadastrarUmNovoUsuario201() {
        idUser =
                RestAssured.given()
                            .spec(cadastrarUsuarioRequest)
                        .when()
                            .post()
                        .then()
                            .statusCode(HttpStatus.SC_CREATED)
                            .log().all()
                            .extract().path("_id");
        PropertiesManager.setProperty("authorize", "id", "ID_USER", idUser);
    }

    @Epic("Teste de Usuarios")
    @Feature("[PUT] - Teste para fazer editar um usuário cadastrado")
    @Description("Deve retornar 200 e um usuário cadastrado foi editado.")
    @Test
    public void putEditarUmUsuario200() {
        RestAssured.given()
                    .spec(editarUsuarioRequest)
                .when()
                    .put("/" + ID_USER)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all();
    }

    @Epic("Teste de Usuarios")
    @Feature("[DELETE] - Teste para excluir um usuário cadastrado.")
    @Description("Deve retornar 200 e confirmar que o usuário foi deletado.")
    @Test
    public void deleteUsuario200() {
        RestAssured.given()
                    .spec(pathUsuariosRequest)
                .when()
                    .delete("/" + ID_USER)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all();
    }
}