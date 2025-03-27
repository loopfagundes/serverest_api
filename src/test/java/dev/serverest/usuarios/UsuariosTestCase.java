package dev.serverest.usuarios;

import dev.serverest.bases.UsuariosBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class UsuariosTestCase extends UsuariosBaseTest {

    @Epic("Teste de Usuarios - API")
    @Feature("Teste o buscar todos usuarios cadastrados na lista.")
    @Description("Deve retornar 200 e todos lista dos usuarios cadastrados.")
    @Test
    public void getUsuario() {
        RestAssured.given()
                .spec(usuariosRequest)
                .when()
                .get()
                .then()
                .log().all()
                .spec(statusOK);
    }
}