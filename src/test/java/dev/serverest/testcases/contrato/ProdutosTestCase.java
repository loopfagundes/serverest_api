package dev.serverest.testcases.contrato;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import dev.serverest.bases.ProdutosBaseTest;
import dev.serverest.managers.PropertiesManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;

public class ProdutosTestCase extends ProdutosBaseTest {

    @Epic("Teste de Produtos")
    @Feature("[GET] - Teste para buscar a lista dos produtos cadastrados.")
    @Description("Deve retornar 200 e a lista completa dos produtos cadastrados.")
    @Test(priority = 1)
    public void deleteProduto200() {
        RestAssured.given()
                    .spec(deleteProdutoRequest)
                .when()
                    .delete("/" + ID_PRODUTO)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all();
    }

    @Epic("Teste de Produtos")
    @Feature("[POST] - Teste para cadastrar um produto.")
    @Description("Deve retornar 201 e a lista completa dos produtos cadastrados.")
    @Test(priority = 1)
    public void cadastrarUmProduto201() {
        idProduto =
            RestAssured.given()
                        .spec(cadastrarProdutoRequest)
                    .when()
                        .post()
                    .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .log().all()
                        .extract().path("_id");
            PropertiesManager.setProperty("properties", "idProduto", "ID_PRODUTO", idProduto);
        }

    @Epic("Teste de Produtos")
    @Feature("[GET] - Teste para buscar a lista dos produtos cadastrados.")
    @Description("Deve retornar 200 e a lista completa dos produtos cadastrados.")
    @Test(priority = 1)
    public void buscarAListaDosProdutos200() {
        RestAssured.given()
                    .spec(pathProdutosRequest)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all();
    }
}
