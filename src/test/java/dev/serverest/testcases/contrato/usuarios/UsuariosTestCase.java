package dev.serverest.testcases.contrato.usuarios;

import dev.serverest.bases.UsuariosBaseTest;
import dev.serverest.helpers.JsonSchemaValidatorHelper;
import dev.serverest.managers.PropertiesManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class UsuariosTestCase extends UsuariosBaseTest {

    @Epic("Teste de Usuarios")
    @Feature("[DELETE] - Teste para excluir um usuário cadastrado.")
    @Description("Deve retornar 200 e confirmar que o usuário foi deletado.")
    @Test(priority = 1)
    public void deleteUsuario200() {
        RestAssured.given()
                    .spec(pathUsuariosRequest)
                .when()
                    .delete("/" + ID_USER)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidatorHelper.validateJson("usuarios/delete_user"))
                    .log().all();
    }

    @Epic("Teste de Usuarios")
    @Feature("[GET] - Teste para buscar todos os usuários cadastrados na lista.")
    @Description("Deve retornar 200 e a lista completa de usuários cadastrados.")
    @Test(priority = 2)
    public void getBuscarTodosOsUsuarioCadastradosNaLista200() {
        RestAssured.given()
                    .spec(pathUsuariosRequest)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidatorHelper.validateJson("usuarios/buscar_todos_usuarios"))
                    .log().all();
    }

    @Epic("Teste de Usuarios")
    @Feature("[POST] - Teste para fazer cadastrar um novo usuário")
    @Description("Deve retornar 201 e usuário cadastrado.")
    @Test(priority = 3)
    public void postCadastrarUmNovoUsuario201() {
        idUser =
                RestAssured.given()
                            .spec(cadastrarUsuarioRequest)
                        .when()
                            .post()
                        .then()
                            .statusCode(HttpStatus.SC_CREATED)
                            .log().all()
                            .body(JsonSchemaValidatorHelper.validateJson("usuarios/cadastrar_usuario"))
                            .extract().path("_id");
        PropertiesManager.setProperty("authorize", "idUser", "ID_USER", idUser);
    }

    @Epic("Teste de Usuarios")
    @Feature("[GET] - Teste para buscar por ID um usuário cadastrado na lista.")
    @Description("Deve retornar 200 e a lista do ID um usuário cadastrado.")
    @Test(priority = 4)
    public void getBuscarPorIdDoUsuarioCadastradoNaLista200() {
        RestAssured.given()
                    .spec(pathUsuariosRequest)
                .when()
                    .get("/" + idUser)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidatorHelper.validateJson("usuarios/buscar_id_usuario"))
                    .log().all();
    }

    @Epic("Teste de Usuarios")
    @Feature("[PUT] - Teste para fazer editar um usuário cadastrado")
    @Description("Deve retornar 200 e um usuário cadastrado foi editado.")
    @Test(priority = 5)
    public void putEditarUmUsuario200() {
        RestAssured.given()
                    .spec(editarUsuarioRequest)
                .when()
                    .put("/" + idUser)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidatorHelper.validateJson("usuarios/editar_id_usuario"))
                    .log().all();
    }
}