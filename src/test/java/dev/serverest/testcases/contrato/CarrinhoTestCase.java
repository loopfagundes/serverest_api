package dev.serverest.testcases.contrato;

import org.apache.hc.core5.http.HttpStatus;
import org.testng.annotations.Test;
import dev.serverest.bases.CarrinhoBaseTest;
import dev.serverest.helpers.JsonSchemaValidatorHelper;
import dev.serverest.managers.PropertiesManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;

public class CarrinhoTestCase extends CarrinhoBaseTest {

    @Epic("Teste de Carrinhos")
    @Feature("[GET] - Teste para buscar todos carrinhos cadastrados.")
    @Description("Deve retornar 200 e a lista completa dos carrinhos cadastrados.")
    @Test(priority = 1)
    public void buscarTodosCarrinhos200() {
        RestAssured.given()
                    .spec(pathCarrinhoRequest)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("carrinhos/buscar_todos_carrinhos"));
    }
    
    @Epic("Teste de Carrinhos")
    @Feature("[POST] - Teste para cadastrar como adicionar no carrinho.")
    @Description("Deve retornar 201 e o carrinho cadastrado.")
    @Test(priority = 2)
    public void cadastrarUmCarrinho201() {
       idCarrinho =
            RestAssured.given()
                        .spec(cadastrarCarrinhoRquest)
                    .when()
                        .post()
                    .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .log().all()
                        .body(JsonSchemaValidatorHelper.validateJson("carrinhos/cadastrar_carrinho"))
                        .extract().path("_id");
            PropertiesManager.setProperty("properties", "idCarrinho", "ID_CARRINHO", idCarrinho);
    }

    @Epic("Teste de Carrinhos")
    @Feature("[GET] - Teste para buscar por ID do carrinho cadastrado.")
    @Description("Deve retornar 200 e a lista por ID do carrinho cadastrado.")
    @Test(priority = 3)
    public void buscarPorIDDoCarrinhos200() {
        RestAssured.given()
                    .spec(pathCarrinhoRequest)
                .when()
                    .get("/" + ID_CARRINHO)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("carrinhos/buscar_id_carrinho"));
    }

    @Epic("Teste de Carrinhos")
    @Feature("[DELETE] - Teste para excluir do carrinho cadastrado como 'compra cancelada'.")
    @Description("Deve retornar 200 e confirmar que o carrinho foi deletado como 'compra cancelada'.")
    @Test(priority = 4)
    public void cancelarACompraDoCarrinho200() {
        RestAssured.given()
                    .spec(pathCarrinhoRequest)
                .when()
                    .delete("/cancelar-compra")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("carrinhos/delete_carrinho"));
    }

    @Epic("Teste de Carrinhos")
    @Feature("[DELETE] - Teste para excluir do carrinho cadastrado como 'compra concluída'.")
    @Description("Deve retornar 200 e confirmar que o carrinho foi deletado como 'compra concluída'.")
    @Test(priority = 5)
    public void concluirACompraDoCarrinho200() {
        RestAssured.given()
                    .spec(pathCarrinhoRequest)
                .when()
                    .delete("/concluir-compra")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("carrinhos/delete_carrinho"));
    }
}