package dev.serverest.usuarios;

import dev.serverest.bases.UsuariosBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class UsuariosTestCase extends UsuariosBaseTest {

    @Epic("Teste de Usuarios")
    @Feature("[GET] - Teste para buscar todos os usuários cadastrados na lista.")
    @Description("Deve retornar 200 e a lista completa de usuários cadastrados.")
    @Test
    public void getTodosOsUsuarioCadastradosNaLista200() {
        RestAssured.given()
                    .spec(usuariosRequest)
                .when()
                    .get()
                .then()
                    .log().all()
                    .spec(statusOK);
    }
}