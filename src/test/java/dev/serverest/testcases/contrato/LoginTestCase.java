package dev.serverest.testcases.contrato;

import dev.serverest.bases.LoginBaseTest;
import dev.serverest.helpers.JsonSchemaValidatorHelper;
import dev.serverest.managers.PropertiesManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class LoginTestCase extends LoginBaseTest {

    @Epic("Teste de Login")
    @Feature("[POST] - Teste para fazer login.")
    @Description("Deve retornar 200 e confirmar que o usuário foi logado.")
    @Test(priority = 1)
    public void efeturaLogin200() {
      token =
        RestAssured.given()
                    .spec(loginRequest)
                .when()
                    .post()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("login/efetura_login"))
                .extract().path("authorization");
        PropertiesManager.setProperty("authorize", "auth", "TOKEN", token);
    }
}